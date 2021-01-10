package Client;

import java.io.IOException;

public class Start {



    public static void main(String[] args) throws IOException {
        //AstroStock astro = new AstroStock();
        //astro.inputMessage();
        ClientConnect client = new ClientConnect("localhost", 5001);
    }
}
