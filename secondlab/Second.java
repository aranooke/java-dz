package secondlab;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.regex.*;
public class Second {
    public static void main() {
    /*
            Написати регулярне вираження, що визначає чи є заданий рядок правильним Mac-Адресою.
        Приклад правильних виражень: ae:dc:ca:56:76:54.
        Приклад неправильних виражень: 01:23:45:67:89:Az.

     */
        System.out.println("Enter your mac adress");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String mac;

        boolean inputIsValid = false;
        while (!inputIsValid) {
            try {
                mac = reader.readLine();
                Thread.sleep(1000);
                inputIsValid = true;

                if (mac.length() != 17)
                {
                    inputIsValid=false;
                    throw new Exception("Line should be length == 17\n");

                }
                checkMac(mac);

            } catch (IOException e) {
                System.err.println("error reading input,try again\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void checkMac(String mac)
    {
        Pattern pattern = Pattern.compile("([a-f0-9A-F]{2}[:-]){5}[0-9A-Fa-f]{2}");
        Matcher matcher = pattern.matcher(mac);
        if(matcher.find() == true)
        {
            System.out.println("found mac adress" + matcher);

        }
        else{
            System.out.println("Not found");
        }
    }
}
