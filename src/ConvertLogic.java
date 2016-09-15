
/**
 *
 * @author Lemon baka
 * Purpose: Convert hex binary decimal baka
 */
public class ConvertLogic {

    public static char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static int base = 16;

    public static String hexaFromDec(int dec) {  //Convert from Decimal to Hexa
        String hexa = "";
        while (dec > 0) {
            int char_hex = dec % 16;
            hexa += hex[char_hex];
            dec = dec / base;
        }
        return new StringBuilder(hexa).reverse().toString();
    }

    public static int hexaToDec(String hexa) {  //Convert from Hexa to decimal
        int i = 0, decimal = 0;
        String hexalist = new String(hex);
        while (i < hexa.length()) {
            char hexadigit = hexa.charAt(i); //What char is at i place
            int decdigit = hexalist.indexOf(hexadigit); //Find what number the digit is in 0-F
            decimal = decimal * base + decdigit; //Multiply by base + add digit
            i++;
        }
        return decimal;
    }

    public static String decToBinary(int dec) {
        int div2;
        String binary = "";
        while (dec > 1) {
            div2 = dec % 2;
            dec = dec >> 1; //Learning shift right bit operator (Divide by 2)
            binary += div2; //Add the number to the binary string aka 1 or 0
        }
        binary += dec;
        binary = binaryPad(binary);
        return new StringBuilder(binary).reverse().toString(); //reverse string to become formal binary
    }

    public static double binaryToDec(String binary) {
        String binaryRev = new StringBuilder(binary).reverse().toString();
        System.out.println(binaryRev);
        double tom = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binaryRev.charAt(i) == '1') {
                System.out.println(i);
                tom = (Math.pow(2, i)) + tom;
            }
        }
        return tom;
    }

    public static String binaryPad(String binary) {
        if (binary.length() % 4 != 0) {
            binary += "0";
            if (binary.length() % 4 != 0) {
                binaryPad(binary);
            }
        }
        return binary;
    }

    public static String logic(String hexa_entry, String decimal_entry, String binary_entry) {
        if ("".equals(hexa_entry) && "".equals(decimal_entry) && !"".equals(binary_entry)) {
            return "binary";
        }
        if ("".equals(hexa_entry) && !"".equals(decimal_entry) && "".equals(binary_entry)) {
            return "decimal";
        }
        if (!"".equals(hexa_entry) && "".equals(decimal_entry) && "".equals(binary_entry)) {
            return "hexa";
        }
        return "error";
    }
}
