package Client; /**
 * @Created 29/12/2020
 * @Project Client.AstroStock
 * @auther Mewk
 */


import com.google.gson.Gson;

import static spark.Spark.*;

public class APIRunner {

    public static void main(String[] args) {
        port(500);

        AstroInfo astroInfo = new AstroInfo();

        StockInfo stockInfo = new StockInfo();

        /**
         * Tanken var att få ut en lista med alla get-metoder från Client.AstroInfo nedan. Se bortkommenterad kod..
         */
        //ArrayList<Client.AstroInfo> astrolist = new ArrayList<Client.AstroInfo>();


        Gson gson = new Gson();

        get("/",(req, res) ->{

            int astronummer = astroInfo.getLuckyNumber();
           String astrisign = astroInfo.getAstroSign();
            //astroInfo.getDailyMessage();
            //astroInfo.getLuckyColor();

            //astrolist.add(astroSign, astroMessage, astroColor);

            res.type("application/json");
            res.body(gson.toJson(astronummer));
            return res.body();
        });

    }


}