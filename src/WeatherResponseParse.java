import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
to parse and print the response that we get from the api
 */
public class WeatherResponseParse {
    public void parseAndPrint (String jsonResponse){ //takes the json response (a string)
        JSONObject jsonObj = new JSONObject(jsonResponse); //it's going to parse that string -jsonResponse -  and allow us to access the propetis/methods from that Json object

        if(jsonObj.getInt("cod") == 200){
            System.out.println("Weather forecast for city : ");
            JSONArray forecasts = jsonObj.getJSONArray("list");

            for(int i = 0; i < forecasts.length(); i++){
                JSONObject forecast = forecasts.getJSONObject(i);
                long timestamp = forecast.getLong("dt");
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp + 1000));
                Double temp = forecast.getJSONObject("main").getDouble("temp");
                String description = forecast.getJSONArray("weather").getJSONObject(0).getString("description");

                System.out.println(date + " :" + temp + "C. " + description);
            }
        } else {
            System.out.println("Request contains an error!");
        }

    }
}
