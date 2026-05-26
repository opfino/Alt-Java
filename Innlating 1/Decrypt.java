
// Uppgáva 4.39
// Decrypt Verisón

import java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a four-digit encrypted number to decrypt: ");
        int encrypted = input.nextInt();

        // Ensure it's a four-digit number
        if (encrypted < 1000 || encrypted > 9999) {
            System.out.println("Please enter a valid four-digit encrypted number.");
            return;
        }

        // Extract digits
        int e4 = encrypted % 10;
        encrypted /= 10;
        int e3 = encrypted % 10;
        encrypted /= 10;
        int e2 = encrypted % 10;
        encrypted /= 10;
        int e1 = encrypted % 10;

        // Swap back: first with third, second with fourth
        int temp = e1;
        e1 = e3;
        e3 = temp;
        temp = e2;
        e2 = e4;
        e4 = temp;

        // Decrypt each digit: subtract 7 mod 10
        int d1 = (e1 - 7 + 10) % 10;
        int d2 = (e2 - 7 + 10) % 10;
        int d3 = (e3 - 7 + 10) % 10;
        int d4 = (e4 - 7 + 10) % 10;

        // Form original number
        int original = d1 * 1000 + d2 * 100 + d3 * 10 + d4;

        System.out.println("Decrypted number: " + original);
    }
}