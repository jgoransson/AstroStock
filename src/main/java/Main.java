import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception  {

        sendPostAztro();
        sendPostAlphaVantage();
    }


    public static void sendPostAztro() throws Exception {


        //Sends API key and host credentials. Sends a post with query for selected horoscope and day
        final HttpResponse<JsonNode> response = Unirest.post("https://sameer-kumar-aztro-v1.p.rapidapi.com/")
                //Api key
                .header("x-rapidapi-key", "37528f0ba4msh940fe61e6dbd892p16d3efjsncff2fa9d4c4f")
                //Api Host name
                .header("x-rapidapi-host", "sameer-kumar-aztro-v1.p.rapidapi.com")
                //Specified query (The information that we want to GET)
                .queryString("day", "Today")
                .queryString("sign", "Gemini")
                .asJson();

        //Handles the Json response from the Request, and extracts the object we want. In this case Lucky Number
        System.out.println(response.getBody().getObject().getString("lucky_number"));

    }

    public static void sendPostAlphaVantage() throws Exception {

        final HttpResponse<String> response = Unirest.post("https://alpha-vantage.p.rapidapi.com/")
                .header("x-rapidapi-key", "37528f0ba4msh940fe61e6dbd892p16d3efjsncff2fa9d4c4f")
                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                .queryString("function","GLOBAL_QUOTE")
                .queryString("symbol","MSFT")
                .queryString("datatype","json")
                .asString();

        System.out.println(response.getBody());
    }
}
