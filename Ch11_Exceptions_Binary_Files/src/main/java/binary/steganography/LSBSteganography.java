package binary.steganography;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;

public class LSBSteganography {
	
	public static void main(String[] args) {
		String message = "Steganography is interesting! We can hide all kinds of data.";
		
		String filePath = "/collegestudent.bmp";
		
		embedMessage(message, filePath);
		
		String extractedMessage = extractMessage(filePath);
		
		System.out.println("Extracted message: " + extractedMessage);
	}
	
	private static RandomAccessFile openResource(String resource, String mode) throws IOException {
		try {
			return new RandomAccessFile(new File(LSBSteganography.class.getResource(resource).toURI()), mode);
		} catch (URISyntaxException e) {
			throw new IOException(e);
		}
	}

	private static String toBinaryString(String message) {
        byte[] bytes = message.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binary.toString();
    }
	
	private static char binaryToChar(String binary) {
		int charCode = Integer.parseInt(binary, 2);
		return (char) charCode;
	}

	private static boolean embedMessage(String message, String filepath) {
        int startOffset = 54; // Example offset for BMP images to skip header
        
        try {
            RandomAccessFile image = openResource(filepath, "rw");
            String binaryMessage = toBinaryString(message + ";;"); // Adding ";;" as a simple delimiter

            // Move to the start offset
            image.seek(startOffset);
            
            int messageIndex = 0;
            long filePointer;
            while (messageIndex < binaryMessage.length()) {
                filePointer = image.getFilePointer();
                byte originalByte = image.readByte();
                byte newByte = (byte)((originalByte & 0xFE) | (binaryMessage.charAt(messageIndex) == '1' ? 1 : 0));
                image.seek(filePointer);
                image.writeByte(newByte);
                messageIndex++;
                image.seek(filePointer + 1); // Move to the next byte
            }
            
            image.close();
            System.out.println("Message embedded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}

    private static String extractMessage(String stegoFile) {
        int startOffset = 54; // Example offset for BMP images to skip header
        StringBuilder binaryMessage = new StringBuilder();

        try {
            RandomAccessFile image = openResource(stegoFile, "r");
            image.seek(startOffset);

            long filePointer;
            // Read until the delimiter ";;" is found
            while (true) {
                filePointer = image.getFilePointer();
                byte b = image.readByte();
                binaryMessage.append(b & 1);
                if (binaryMessage.length() >= 16 && binaryMessage.substring(binaryMessage.length() - 16).equals("0011101100111011")) { // ";;" in binary
                    break;
                }
                image.seek(filePointer + 1);
            }
            image.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert binary string to characters
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < binaryMessage.length() - 16; i += 8) {
            String byteString = binaryMessage.substring(i, i + 8);
            char character = binaryToChar(byteString);
            message.append(character);
        }

        return message.toString();
    }
	
}
