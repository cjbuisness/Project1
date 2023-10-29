package StockLedger;

public class Main {
    public static void main(String[] args) {
        StockLedger stockLedger = new StockLedger();  // create ledger

        // Buying stock
        stockLedger.buy("AAPL", 20, 45.0);  // Purchase 1
        stockLedger.buy("AAPL", 20, 75.0);  // Purchase 2
        stockLedger.buy("MSFT", 20, 95.0);  // Purchase 3
        stockLedger.displayLedger();  // display ledger, after 1st three steps

        // Selling stock
        double gainOrLoss1 = stockLedger.sell("AAPL", 30, 65.0);  //Sale 1
        stockLedger.displayLedger();  //display ledger, after 1st four steps
        System.out.println("Gain or Loss 1: $" + gainOrLoss1);  // gain/loss of sale

        double gainOrLoss2 = stockLedger.sell("AAPL", 10, 65.0);  // Sale 2
        stockLedger.displayLedger();  // display ledger, first 5 steps
        System.out.println("Gain or Loss 2: $" + gainOrLoss2);  // gain/loss of sale

        stockLedger.buy("AAPL", 100, 20.0);  // Purchase 4
        stockLedger.buy("AAPL", 20, 24.0);  //Purchase 5
        stockLedger.buy("TSLA", 200, 36.0);  // Purchase 6
        stockLedger.displayLedger();  // display ledger, first 8 steps
//so on, so forth
        double gainOrLoss3 = stockLedger.sell("AAPL", 10, 65.0);  
        stockLedger.displayLedger();  
        System.out.println("Gain or Loss 3: $" + gainOrLoss3);  

        double gainOrLoss4 = stockLedger.sell("TSLA", 150, 30.0);  
        stockLedger.displayLedger();  
        System.out.println("Gain or Loss 4: $" + gainOrLoss4); 

        stockLedger.buy("MSFT", 5, 60.0); 
        stockLedger.buy("MSFT", 5, 70.0);  
        stockLedger.displayLedger(); 

        double gainOrLoss5 = stockLedger.sell("MSFT", 4, 30.0); 
        stockLedger.displayLedger();  
        System.out.println("Gain or Loss 5: $" + gainOrLoss5); 

        double gainOrLoss6 = stockLedger.sell("MSFT", 2, 30.0);  
        stockLedger.displayLedger();  
        System.out.println("Gain or Loss 6: $" + gainOrLoss6);  
    }
}
