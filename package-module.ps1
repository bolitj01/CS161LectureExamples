<#
.SYNOPSIS
    Packages a single module of this multi-module Maven project into a
    standalone, student-ready zip file.

.DESCRIPTION
    Copies the given module folder (excluding build output like target/),
    rewrites its pom.xml into a self-contained, parent-less pom that inlines
    the shared <properties>, <dependencies>, and <build> sections from the
    root pom.xml, then zips the result so it can be handed to students as an
    independent Maven project.

.PARAMETER ModuleName
    The folder name of the module to package, e.g. "Ch6_Classes_Objects_I".

.PARAMETER OutputDir
    Where to write the resulting zip. Defaults to ".\dist".

.EXAMPLE
    .\package-module.ps1 -ModuleName Ch6_Classes_Objects_I
#>
param(
    [Parameter(Mandatory = $true)]
    [string]$ModuleName,

    [string]$OutputDir = (Join-Path $PSScriptRoot "dist")
)

$ErrorActionPreference = "Stop"

$repoRoot = $PSScriptRoot
$modulePath = Join-Path $repoRoot $ModuleName
$rootPomPath = Join-Path $repoRoot "pom.xml"
$modulePomPath = Join-Path $modulePath "pom.xml"

if (-not (Test-Path $modulePath)) {
    throw "Module folder '$ModuleName' was not found under $repoRoot"
}
if (-not (Test-Path $modulePomPath)) {
    throw "'$modulePomPath' does not exist. Is '$ModuleName' a Maven module?"
}

# Pull the shared sections out of the root aggregator pom so the packaged
# module doesn't need a <parent> to resolve dependencies/build config.
$rootPomText = Get-Content $rootPomPath -Raw
function Get-XmlBlock([string]$text, [string]$tag) {
    $match = [regex]::Match($text, "<$tag>.*?</$tag>", [System.Text.RegularExpressions.RegexOptions]::Singleline)
    if (-not $match.Success) {
        throw "Could not find <$tag> block in root pom.xml"
    }
    return $match.Value
}
$propertiesBlock = Get-XmlBlock $rootPomText "properties"
$dependenciesBlock = Get-XmlBlock $rootPomText "dependencies"
$buildBlock = Get-XmlBlock $rootPomText "build"

$modulePomText = Get-Content $modulePomPath -Raw
$artifactIdMatch = [regex]::Match($modulePomText, "<artifactId>(.*?)</artifactId>")
if (-not $artifactIdMatch.Success) {
    throw "Could not find <artifactId> in $modulePomPath"
}
$artifactId = $artifactIdMatch.Groups[1].Value

# Stage a clean copy of the module (skip build output and IDE/VCS folders)
$stagingRoot = Join-Path ([System.IO.Path]::GetTempPath()) ("package-staging-" + [guid]::NewGuid())
$stagingModule = Join-Path $stagingRoot $ModuleName
New-Item -ItemType Directory -Path $stagingModule -Force | Out-Null

robocopy $modulePath $stagingModule /E /XD target .git .vscode /NFL /NDL /NJH /NJS | Out-Null
if ($LASTEXITCODE -ge 8) {
    throw "robocopy failed while copying '$modulePath' (exit code $LASTEXITCODE)"
}

$standalonePom = @"
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>examples</groupId>
    <artifactId>$artifactId</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    $propertiesBlock

    $dependenciesBlock

    $buildBlock
</project>
"@
Set-Content -Path (Join-Path $stagingModule "pom.xml") -Value $standalonePom -Encoding UTF8

New-Item -ItemType Directory -Path $OutputDir -Force | Out-Null
$zipPath = Join-Path $OutputDir "$ModuleName.zip"
if (Test-Path $zipPath) {
    Remove-Item $zipPath -Force
}
Compress-Archive -Path $stagingModule -DestinationPath $zipPath

Remove-Item $stagingRoot -Recurse -Force

Write-Host "Packaged '$ModuleName' -> $zipPath"
