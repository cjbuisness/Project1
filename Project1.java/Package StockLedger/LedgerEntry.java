package StockLedger;

import Deque.LinkedDeque;

public class LedgerEntry {
    private String stockSymbol;            // store symbol for entry
    private LinkedDeque<StockPurchase> purchases;  //linked deque will store purchases

    public LedgerEntry(String stockSymbol) {
        this.stockSymbol = stockSymbol;   // initialize symbol for stocks
        this.purchases = new LinkedDeque<>();  // initialized linked deque for purchases
    }

    public String getStockSymbol() {
        return stockSymbol;  // get symbol for this entry
    }

    public LinkedDeque<StockPurchase> getPurchases() {
        return purchases;   // get liinked deque of purchases
    }
}
