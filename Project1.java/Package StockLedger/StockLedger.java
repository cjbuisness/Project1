package StockLedger;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Deque.LinkedDeque;

public class StockLedger implements StockLedgerInterface {
    private List<LedgerEntry> ledgerEntries;  // listthat will store ledger objects for different stocks.

    public StockLedger() {
        ledgerEntries = new ArrayList<>();  // for new ledger object, this will initialize list
    }

    @Override
    public void buy(String stockSymbol, int sharesBought, double pricePerShare) {
        int stockIndex = findStockIndex(stockSymbol);
        if (stockIndex == -1) {
            // if sotck is not in ledger, create new ledgerentry
            LedgerEntry newEntry = new LedgerEntry(stockSymbol);
            newEntry.getPurchases().addToBack(new StockPurchase(stockSymbol, sharesBought, pricePerShare));
            ledgerEntries.add(newEntry);
        } else {
            // add a StockPurchase to existing LedgerEntry
            ledgerEntries.get(stockIndex).getPurchases().addToBack(new StockPurchase(stockSymbol, sharesBought, pricePerShare));
        }
    }

    @Override
    public double sell(String stockSymbol, int sharesSold, double pricePerShare) {
        int stockIndex = findStockIndex(stockSymbol);
        if (stockIndex == -1) {
            return 0.0; // return no gain, no loss (0.0), if stock is not found
        }

        LinkedDeque<StockPurchase> purchases = ledgerEntries.get(stockIndex).getPurchases();
        double totalGainOrLoss = 0.0;

        while (sharesSold > 0 && !purchases.isEmpty()) {
            StockPurchase purchase = purchases.getFront();
            int sharesInThisPurchase = purchase.getSharesBought();

            if (sharesInThisPurchase <= sharesSold) {
                // sell shares in this particular purchase, calculate gain/loss
                totalGainOrLoss += (pricePerShare - purchase.getPricePerShare()) * sharesInThisPurchase;
                sharesSold -= sharesInThisPurchase;
                purchases.removeFront();
            } else {
                // sell a portion, calculate gain/loss
                totalGainOrLoss += (pricePerShare - purchase.getPricePerShare()) * sharesSold;
                purchase.setSharesBought(sharesInThisPurchase - sharesSold);
                sharesSold = 0;
            }
        }

        return totalGainOrLoss; //return total gain, total loss
    }

    @Override
    public boolean contains(String stockSymbol) {
        return findStockIndex(stockSymbol) != -1; // check if ledger contains symbol
    }

    @Override
    public LedgerEntry getEntry(String stockSymbol) {
        int stockIndex = findStockIndex(stockSymbol);
        if (stockIndex != -1) {
            return ledgerEntries.get(stockIndex); // get entry for specific stock
        }
        return null; // return null if stock is not in ledger
    }

    public void displayLedger() {
        System.out.println("---- Stock Ledger ----"); //header
        for (LedgerEntry entry : ledgerEntries) {
            LinkedDeque<StockPurchase> purchases = entry.getPurchases();
            Iterator<StockPurchase> iterator = purchases.iterator(); //initialize iterator for purchased objects

            // display purchases information
            while (iterator.hasNext()) {
                StockPurchase purchase = iterator.next();
                System.out.format("%s: %.1f (%d shares)%s", purchase.getStockSymbol(),
                        purchase.getPricePerShare(), purchase.getSharesBought(), iterator.hasNext() ? ", " : "\n");
            }
        }
    }
//find index of stock
    private int findStockIndex(String stockSymbol) {
        for (int i = 0; i < ledgerEntries.size(); i++) {
            LedgerEntry entry = ledgerEntries.get(i);
            if (entry.getStockSymbol().equals(stockSymbol)) {
                return i; //return index of stock in ledger
            }
        }
        return -1; // return -1 if the stock is not found
    }
}
