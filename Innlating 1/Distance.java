
// Uppgáva 4.37

import java.util.Scanner; // program uses class Scanner

public class Distance {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter first integer: ");
            int number1 = input.nextInt();
            
            System.out.print("Enter second integer: ");
            int number2 = input.nextInt();

            System.out.print("Enter third integer: ");
            int number3 = input.nextInt();

            System.out.print("Enter fourth integer: ");
            int number4 = input.nextInt();
            
            System.out.println(compare(number1, number2, number3, number4));
        }
    }
    
public static String compare(int x1, int y1, int x2, int y2) {
    if (x1 == x2) {
    return "The points lie on a vertical line";
    }

    else if (y1 == y2) {
    return "The points lie on a horizontal line";
    }

    else {
    return "The points do not lie on a line perpendicular to an axis.";
    }  
} // end method main
} // end class Distance
