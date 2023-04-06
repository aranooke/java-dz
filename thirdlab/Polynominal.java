package thirdlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

public class Polynominal {


        public static HashMap<Integer, Double> addPolynomials(HashMap<Integer, Double> p1, HashMap<Integer, Double> p2) {
            HashMap<Integer, Double> result = new HashMap<>();
            try {
                // определяем максимальную степень многочлена
                int maxDegree = Math.max(Collections.max(p1.keySet()), Collections.max(p2.keySet()));

                // проходим в цикле по всем степеням многочлена
                for (int i = maxDegree; i >= 0; i--) {
                    double coef1 = p1.containsKey(i) ? p1.get(i) : 0.0;
                    double coef2 = p2.containsKey(i) ? p2.get(i) : 0.0;

                    double sum = coef1 + coef2;
                    result.put(i, sum);
                }
            } catch (Exception e) {
                System.out.println("Error occurred while adding polynomials: " + e.getMessage());
            }
            return result;
        }
}










