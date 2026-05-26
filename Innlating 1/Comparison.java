
// Uppgáva 4.36

import java.util.Scanner; // program uses class Scanner

public class Comparison {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter first integer: ");
            int number1 = input.nextInt();
            
            System.out.print("Enter second integer: ");
            int number2 = input.nextInt();
            
            System.out.println(compare(number1, number2));
        }
    }
    
    public static int compare(int a, int b) {
        if (a == b) return 0;
        else if (a > b) return 1;
        else return -1;
    } // end method main
} // end class Comparison

