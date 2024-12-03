import org.json.JSONObject;

/*
to parse and print the response that we get from the api
 */
public class WeatherResponseParse {
    public void parseAndPrint (String jsonResponse){ //takes the json response (a string)
        JSONObject jsonObject = new JSONObject(jsonResponse); //it's going to parse that string -jsonResponse -  and allow us to access the propetis/methods from that Json object
     }
}
