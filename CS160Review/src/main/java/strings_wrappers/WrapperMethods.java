package strings_wrappers;

/**
 * Demonstrates common wrapper class methods and behavior.
 */
public class WrapperMethods {

    public static void main(String[] args) {
        // Parsing strings into primitive values.
        int parsedInt = Integer.parseInt("42");
        double parsedDouble = Double.parseDouble("3.14159");
        boolean parsedBoolean = Boolean.parseBoolean("true");

        System.out.println("Integer.parseInt(\"42\") -> " + parsedInt);
        System.out.println("Double.parseDouble(\"3.14159\") -> " + parsedDouble);
        System.out.println("Boolean.parseBoolean(\"true\") -> " + parsedBoolean);
        System.out.println();

        // valueOf creates wrapper objects.
        Integer intObj = Integer.valueOf("100");
        Double doubleObj = Double.valueOf("2.5");

        System.out.println("Integer.valueOf(\"100\") -> " + intObj);
        System.out.println("Double.valueOf(\"2.5\") -> " + doubleObj);
        System.out.println();

        // Useful constants and helper methods.
        System.out.println("Integer.MAX_VALUE -> " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE -> " + Integer.MIN_VALUE);
        System.out.println("Double.isNaN(Double.NaN) -> " + Double.isNaN(Double.NaN));
        System.out.println();

        // compare compares two values and returns negative, zero, or positive.
        System.out.println("Integer.compare(7, 12) -> " + Integer.compare(7, 12));
        System.out.println("Integer.compare(12, 12) -> " + Integer.compare(12, 12));
        System.out.println("Integer.compare(20, 12) -> " + Integer.compare(20, 12));
        System.out.println();

        // toString converts primitive values to strings.
        String intAsString = Integer.toString(55);
        String doubleAsString = Double.toString(9.75);

        System.out.println("Integer.toString(55) -> \"" + intAsString + "\"");
        System.out.println("Double.toString(9.75) -> \"" + doubleAsString + "\"");
        System.out.println();

        // Autoboxing and unboxing happen automatically.
        Integer scoreObject = 88; // autoboxing
        int scorePrimitive = scoreObject; // unboxing

        System.out.println("Autoboxed Integer -> " + scoreObject);
        System.out.println("Unboxed int -> " + scorePrimitive);
    }
}
