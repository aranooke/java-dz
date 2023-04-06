package firstlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Scanner;


public class First  {


    public static void main() throws IOException {

        Scanner reader = new Scanner(System.in);
        int n = 0;
        boolean inputIsValid = false;
        while (!inputIsValid) {
            try {
                System.out.print("Enter n: ");
                n = Integer.parseInt(reader.nextLine());
                if(Integer.parseInt(String.valueOf(n)) != n)
                {
                    throw new NumberFormatException("It`s not integer number");
                }
                else {
                    calculateLength(n,reader);
                }
                inputIsValid = true;
                reader.close();
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter an integer." + e.getMessage());
            }
        }

    }

    public static void calculateLength(int n,Scanner reader)
    {

        String[] result = new String[n];
        float len = 0;
        String stroka;
        for (int i = 0; i < n ; i++) {
            System.out.printf("Enter sentence %d: ", i + 1);
            stroka = reader.nextLine();
            result[i] = stroka;
            len += stroka.length();
        }
        len /= n;
        System.out.printf("Average length of words is %.2f\n", len);
        for (int i = 0; i < n ; i++) {
            if(result[i].length() < len) {
                System.out.println(result[i]);
            }
        }
        reader.close();


    }
}