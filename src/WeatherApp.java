import java.io.IOException;

public class WeatherApp {
    public static void main(String[] args) throws IOException {

        WeatherAPI api = new WeatherAPI();
        String forecastString = api.getForecast("Lisbon");

        WeatherResponseParse parser = new WeatherResponseParse();
        parser.parseAndPrint(forecastString);
    }
}
