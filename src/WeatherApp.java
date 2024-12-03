import java.io.IOException;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) throws IOException {

        WeatherAPI api = new WeatherAPI();

        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while(run){
            System.out.println("What city would you ike to see the weather for? : ");
            String city = scanner.nextLine();

            String forecastString = api.getForecast(city);
            //System.out.println(forecastString);

            WeatherResponseParse parser = new WeatherResponseParse();
            parser.parseAndPrint(forecastString);

            System.out.println("\nWould you like to try another city? (y/n)");
            String choice = scanner.nextLine().toLowerCase();

            if(!choice.equals("y")){
                run = false;
                scanner.close();
            }
        }
    }
}
