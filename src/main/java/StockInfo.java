public class StockInfo {

    private String stockName;
    private String stockHigh;
    private String stockLow;
    private String stockChange;

    public StockInfo(){}

    public StockInfo(String stockName){
        this.stockName = stockName;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockHigh() {
        return stockHigh;
    }

    public void setStockHigh(String stockHigh) {
        this.stockHigh = stockHigh;
    }

    public String getStockLow() {
        return stockLow;
    }

    public void setStockLow(String stockLow) {
        this.stockLow = stockLow;
    }

    public String getStockChange() {
        return stockChange;
    }

    public void setStockChange(String stockToDate) {
        this.stockChange = stockToDate;
    }


}
