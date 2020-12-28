import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.apache.http.impl.client.HttpClients;
import javax.swing.*;


public class AstroStock {

    AstroInfo astroInfo;
    StockInfo stockInfo;

    public AstroStock(){
        new AstroInfo();
        new StockInfo();
    }


    //Method which prompts user for their Star Sign
    public void inputMessage(){

        String sign = JOptionPane.showInputDialog(null, "Please input Star Sign");

        astroInfo.setastroSign(sign);

    }

    //Method uses star sign from AstroInfo Class to retrieve lucky number via Unirest Call to aztro API
    public void getHoroscopeInfo() throws Exception {

        String sign = astroInfo.getastroSign();
        String message = " ";
        String color = " ";
        String luckyTime = " ";
        int luckyNmr;


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

        //parse string lucky number into int
        luckyNmr = Integer.parseInt((response.getBody().getObject().getString("lucky_number")));
        message = response.getBody().getObject().getString("description");
        color = response.getBody().getObject().getString("color");


        //Sets variables in AstroInfo Class
        astroInfo.setLuckyNumber(luckyNmr);
        astroInfo.setDailyMessage(message);
        astroInfo.setLuckyColor(color);

    }


    //Unfinished/Unimplemented method which send GET request to Alpha Vantage.
    // Currently hard coded to IBM stock and daily low point.
    //Method returns separate String variables with Stock and daily low point
    public void getStockInfo() throws Exception {

        String stockName = stockInfo.getStockName();
        String stockLow = " ";
        String stockHigh = " ";
        String stockChange = " ";

        final HttpResponse<JsonNode> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?")
                //Api key
                .header("x-rapidapi-key", "37528f0ba4msh940fe61e6dbd892p16d3efjsncff2fa9d4c4f")
                //Api Host name
                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                //Specified query (The information that we want to GET)
                .queryString("function","GLOBAL_QUOTE")
                // variable stockName = specific stock user has submitted
                .queryString("symbol",stockName)
                .asJson();


            stockHigh = (response.getBody().getObject().getJSONObject("Global Quote").getString("03. high"));
            stockLow = (response.getBody().getObject().getJSONObject("Global Quote").getString("04. low"));
            stockChange = (response.getBody().getObject().getJSONObject("Global Quote").getString("10. change percent"));

            //Sets variables in StockInfo Class
            stockInfo.setStockHigh(stockHigh);
            stockInfo.setStockLow(stockLow);
            stockInfo.setStockChange(stockChange);


    }

    public boolean shouldYouBuy(){
        int luckyNumber = astroInfo.getLuckyNumber();

        if(luckyNumber<= 49){
            return true;
        }
        else
            return false;

    }
}


