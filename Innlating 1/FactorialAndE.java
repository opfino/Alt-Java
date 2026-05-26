
// Uppgáva 4.38
// Compute factorial, estimate e, and estimate e^x

import java.util.Scanner;

public class FactorialAndE {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            // ----- Part (a): Factorial -----
            System.out.print("Enter a nonnegative integer: ");
            int n = input.nextInt();

            long factorial = 1;

            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }

            System.out.printf("Factorial of %d is %d%n", n, factorial);


            // ----- Part (b): Estimate e -----
            System.out.print("%nEnter number of terms to estimate e: ");
            int terms = input.nextInt();

            double e = 1.0;

            for (int i = 1; i <= terms; i++) {
                // you compute factorial here again OR reuse logic
                long fact = 1;

                for (int j = 1; j <= i; j++) {
                    fact *= j;
                }

                e += 1.0 / fact;
            }

            System.out.printf("Estimated value of e: %f%n", e);


            // ----- Part (c): Estimate e^x -----
            System.out.print("%nEnter value of x: ");
            double x = input.nextDouble();

            System.out.print("Enter number of terms: ");
            int termsX = input.nextInt();

            double ex = 1.0;

            for (int i = 1; i <= termsX; i++) {

                // compute factorial
                long fact = 1;
                for (int j = 1; j <= i; j++) {
                    fact *= j;
                }

                // compute x^i
                double power = 1.0;
                for (int j = 1; j <= i; j++) {
                    power *= x;
                }

                ex += power / fact;
            }

            System.out.printf("Estimated value of e^x: %f%n", ex);
        }
    }
};
