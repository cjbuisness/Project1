package StockLedger;

public class StockPurchase {
    private String stockSymbol;  //store purchase symbol
    private int sharesBought;    // store shares bought in this purchase
    private double pricePerShare; // store price per share for purchase

    public StockPurchase(String stockSymbol, int sharesBought, double pricePerShare) {
        this.stockSymbol = stockSymbol;       // initialize symbol
        this.sharesBought = sharesBought;     // initialize number of shares bought
        this.pricePerShare = pricePerShare;   //initialize price per share
    }
//get symbol
    public String getStockSymbol() {
        return stockSymbol;  // return symbol
    }
//get # of shares
    public int getSharesBought() {
        return sharesBought;  // return # of shares
    }

    public void setSharesBought(int sharesBought) {
        this.sharesBought = sharesBought;  // update the number of shares bought.
    }
//get price per share
    public double getPricePerShare() {
        return pricePerShare;  //return pps
    }
}
