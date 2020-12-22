public class AstroInfo {

    private int luckyNumber;
    private String dailyMessage;
    private String luckyColor;
    private String astroSign;

    public AstroInfo(){}

    public AstroInfo(int luckyNumber){
        this.luckyNumber = luckyNumber;
    }

    public AstroInfo(String astroSign){
        this.astroSign = astroSign;
    }

    public AstroInfo(String luckyColor, int luckyNumber, String dailyMessage){
        this.dailyMessage = dailyMessage;
        this.luckyColor = luckyColor;
        this.luckyNumber = luckyNumber;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(int luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public String getastroSign(){
        return astroSign;
    }

    public void setastroSign(String astroSign){
        this.astroSign = astroSign;
    }

    public String getDailyMessage() {
        return dailyMessage;
    }

    public void setDailyMessage(String dailyMessage) {
        this.dailyMessage = dailyMessage;
    }

    public String getLuckyColor() {
        return luckyColor;
    }

    public void setLuckyColor(String luckyColor) {
        this.luckyColor = luckyColor;
    }

}
