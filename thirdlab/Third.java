package thirdlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Third {
    private static Polynominal Polynomial;

    public static void main() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean inpustIsValid = false;
        while (!inpustIsValid) {
            try {
                System.out.print("Enter the number of terms in the first polynomial: ");
                int n1 = Integer.parseInt(reader.readLine());

                System.out.println("Enter the coefficients and exponents of the first polynomial:");
                HashMap<Integer, Double> p1 = new HashMap<>();
                for (int i = 0; i < n1; i++) {
                    System.out.printf("Term %d: ", i + 1);
                    double coefficient = Double.parseDouble(reader.readLine());
                    int exponent = Integer.parseInt(reader.readLine());
                    p1.put(exponent, coefficient);
                }

                System.out.print("Enter the number of terms in the second polynomial: ");
                int n2 = Integer.parseInt(reader.readLine());

                System.out.println("Enter the coefficients and exponents of the second polynomial:");
                HashMap<Integer, Double> p2 = new HashMap<>();
                for (int i = 0; i < n2; i++) {
                    System.out.printf("Term %d: ", i + 1);
                    double coefficient = Double.parseDouble(reader.readLine());
                    int exponent = Integer.parseInt(reader.readLine());
                    p2.put(exponent, coefficient);
                }

                HashMap<Integer, Double> result = Polynomial.addPolynomials(p1, p2);
                System.out.println("Result: " + result);
                inpustIsValid = true;
            } catch (NumberFormatException e) {

                e.printStackTrace();
                System.err.println("Invalid input format. Please enter numbers only.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}








