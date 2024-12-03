import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI {

    private static final String API_KEY = ""; // delete when commiting
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast";

    public String getForecast(String city) throws IOException {
        String apiURL = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";

        // Set up the connection
        URL url = new URL(apiURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

//        // Handle response
//        int responseCode = connection.getResponseCode();
//        if (responseCode != HttpURLConnection.HTTP_OK) {
//            throw new IOException("Error: " + responseCode + " - " + connection.getResponseMessage());

            // Read response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null) {
            response.append(line);
        }

        // Close resources
        reader.close();
        connection.disconnect();

        return response.toString();
    }
}
