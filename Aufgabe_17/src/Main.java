import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "j";

        while (true) {
            if (input.equals("n")) {
                return;
            } else {
                try {
                    URL url = new URL("https://witzapi.de/api/joke/");
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(url.openStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        Object obj = JSONValue.parse(inputLine);
                        JSONArray array = (JSONArray) obj;
                        JSONObject jsonObject = (JSONObject) array.getFirst();
                        String joke = (String) jsonObject.get("text");
                        System.out.println(joke);
                    }

                    in.close();
                } catch (Exception exception) {
                    System.out.println("API momentan nicht erreichbar, versuche es später wieder");
                    return;
                }
                System.out.print("Nächsten Witz holen? j/n  ");
                input = scanner.nextLine();
            }
        }
    }
}