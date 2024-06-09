import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String s = "*".repeat(16);
        boolean inputIsValid = false;

        do {
            try {
                System.out.print("Insert decimal number to convert: ");
                int input = scan.nextInt();

                System.out.printf("%s RESULT %s\n", s, s);
                System.out.printf("| %-15s | %-18s |\n", "Octal", decimalToOctal(input));
                System.out.printf("| %-15s | %-18s |\n", "Hexadecimal", decimalToHex(input));
                System.out.printf("| %-15s | %-18s |\n", "Binary", decimalToBinary(input));
                inputIsValid = true;
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Invalid Input. Please try again.");
                inputIsValid = false;
            }
        } while (!inputIsValid);

        scan.close();
    }

    private static String decimalToOctal(int num) {
        StringBuilder result = new StringBuilder();

        while (num != 0) {
            result.insert(0, num % 8);
            num /= 8;
        }

        return result.toString();
    }

    private static String decimalToHex(int num) {
        StringBuilder result = new StringBuilder();
        String hexChars = "0123456789ABCDEF";

        while (num != 0) {
            result.insert(0, hexChars.charAt(num % 16));
            num /= 16;
        }

        return result.toString();
    }

    private static String decimalToBinary(int num) {
        StringBuilder result = new StringBuilder();

        while (num != 0) {
            result.insert(0, num % 2);
            num /= 2;
        }

        return result.toString();
    }

}