
// Uppgáva 4.39
// Encrypt Verisón

import java.util.Scanner;

public class Cryptography {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a four-digit number to encrypt: ");
        int num = input.nextInt();

        // Ensure it's a four-digit number
        if (num < 1000 || num > 9999) {
            System.out.println("Please enter a valid four-digit number.");
            return;
        }

        // Extract digits
        int d4 = num % 10;
        num /= 10;
        int d3 = num % 10;
        num /= 10;
        int d2 = num % 10;
        num /= 10;
        int d1 = num % 10;

        // Encrypt each digit
        int e1 = (d1 + 7) % 10;
        int e2 = (d2 + 7) % 10;
        int e3 = (d3 + 7) % 10;
        int e4 = (d4 + 7) % 10;

        // Swap first with third, second with fourth
        int temp = e1;
        e1 = e3;
        e3 = temp;
        temp = e2;
        e2 = e4;
        e4 = temp;

        // Form encrypted number
        int encrypted = e1 * 1000 + e2 * 100 + e3 * 10 + e4;

        System.out.printf("Encrypted number: %04d\n", encrypted);
    }
}