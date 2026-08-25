package strings_wrappers;

/**
 * Demonstrates common String methods for Java students.
 */
public class StringMethods {

    public static void main(String[] args) {
        String course = "CS 161 Computer Programming II";
        String phrase = "  Java is fun!  ";

        System.out.println("Original course string: \"" + course + "\"");
        System.out.println("Original phrase string: \"" + phrase + "\"");
        System.out.println();

        // length(): number of characters in the string.
        System.out.println("length() -> " + course.length());

        // charAt(index): character at a specific position.
        System.out.println("charAt(0) -> " + course.charAt(0));

        // substring(begin, end): slice from begin index (inclusive) to end (exclusive).
        System.out.println("substring(0, 6) -> " + course.substring(0, 6));

        // toUpperCase() / toLowerCase(): case conversions.
        System.out.println("toUpperCase() -> " + course.toUpperCase());
        System.out.println("toLowerCase() -> " + course.toLowerCase());

        // contains(text): check for substring.
        System.out.println("contains(\"Intro\") -> " + course.contains("Intro"));

        // indexOf(text): first index where text appears, or -1 if not found.
        System.out.println("indexOf(\"CS\") -> " + course.indexOf("CS"));

        // replace(old, new): replaces all occurrences of old text.
        System.out.println("replace(\"CS\", \"Computer Science\") -> "
                + course.replace("CS", "Computer Science"));

        // trim(): removes leading and trailing whitespace.
        System.out.println("trim() -> \"" + phrase.trim() + "\"");

        // startsWith / endsWith: prefix/suffix checks.
        System.out.println("startsWith(\"CS\") -> " + course.startsWith("CS"));
        System.out.println("endsWith(\"II\") -> " + course.endsWith("II"));

        // equalsIgnoreCase: case-insensitive comparison.
        String a = "hello";
        String b = "HELLO";
        System.out.println("equalsIgnoreCase between \"" + a + "\" and \"" + b + "\" -> "
                + a.equalsIgnoreCase(b));
    }
}
