/**
 * @Created 29/12/2020
 * @Project AstroStock
 * @auther Mewk
 */


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class APIRunner {

    public static void main(String[] args) {
        port(500);

        AstroInfo astroInfo = new AstroInfo();

        StockInfo stockInfo = new StockInfo();

        /**
         * Tanken var att få ut en lista med alla get-metoder från AstroInfo nedan. Se bortkommenterad kod..
         */
        //ArrayList<AstroInfo> astrolist = new ArrayList<AstroInfo>();


        Gson gson = new Gson();

        get("/",(req, res) ->{

            int astronummer = astroInfo.getLuckyNumber();
           String astrisign = astroInfo.getastroSign();
            //astroInfo.getDailyMessage();
            //astroInfo.getLuckyColor();

            //astrolist.add(astroSign, astroMessage, astroColor);

            res.type("application/json");
            res.body(gson.toJson(astronummer));
            return res.body();
        });

    }


}