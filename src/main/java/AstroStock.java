import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.apache.http.impl.client.HttpClients;

import javax.swing.*;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.http.HttpClient;

public class AstroStock {

    public static void main(String[] args) throws Exception  {

        //inputMessage();
        getLuckyNumber();
        //getStockInfo();
    }

    //Method which prompts user for their Star Sign
    public static String inputMessage(){

        String sign = JOptionPane.showInputDialog(null, "Please input Star Sign");

        return sign;
    }

    //Method takes user input on star sign, sends a post request to Aztro API and gives user their lucky number of current day
    public static void getLuckyNumber() throws Exception {

        //Declare String variable for star sign
        String luckyNmr = " ";
        //String variable is initialized through JOptionpane inputdialog in inputMessage method.
        String sign = inputMessage();


        //Sends API key and host credentials. Sends a post with query for selected horoscope and day
        final HttpResponse<JsonNode> response = Unirest.post("https://sameer-kumar-aztro-v1.p.rapidapi.com/")
                //Api key
                .header("x-rapidapi-key", "37528f0ba4msh940fe61e6dbd892p16d3efjsncff2fa9d4c4f")
                //Api Host name
                .header("x-rapidapi-host", "sameer-kumar-aztro-v1.p.rapidapi.com")
                //Specified query (The information that we want to GET)
                .queryString("day", "Today")
                .queryString("sign", sign)
                .asJson();

        //Handles the Json response from the Request, and extracts the object we want. In this case Lucky Number
       System.out.println("Your Lucky number is: " + response.getBody().getObject().getString("lucky_number"));

        //luckyNmr = (response.getBody().getObject().getString("lucky_number"));

        //return luckyNmr;


    }

    //Unfinished/Unimplemented method which send GET request to Alpha Vantage.
    // Currently hard coded to IBM stock and daily low point.
    //Method returns separate String variables with Stock and daily low point
    public static String getStockInfo() throws Exception {

        String func = " ";
        String stock = " ";

        final HttpResponse<JsonNode> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?")
                .header("x-rapidapi-key", "37528f0ba4msh940fe61e6dbd892p16d3efjsncff2fa9d4c4f")
                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                .queryString("function","GLOBAL_QUOTE")
                .queryString("symbol","MSFT")
                .asJson();

        //System.out.println(response.getBody().getObject().getJSONObject("Global Quote").getString("04. low"));
        //System.out.println(response.getBody().getObject().getJSONObject("Global Quote").getString("01. symbol"));

            func = (response.getBody().getObject().getJSONObject("Global Quote").getString("04. low"));
            stock = (response.getBody().getObject().getJSONObject("Global Quote").getString("01. symbol"));

            return func + stock;


    }
}
