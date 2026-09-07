public class Stock() {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public Stock(Stock object 2) {
        symbol = object2.symbol;
        price = object2.price;
    }

    public String toString() {
        return "Stock: " + symbol + " Price: " + price;
    }

    public boolean equals(Stock otherStock) {
        return symbol.equals(otherStock.symbol) && price == otherStock.price;
    }

    public static void main(String[] args) {
        Stock stock1 = new Stock("GMX", 55.3);
        Stock stock2 = new Stock("GMX", 55.3);
        // This is a mistake. The addresses will be different, therefore always false.
        if (stock1 == stock2)
            System.out.println("The objects are the same.");
        else
            System.out.println("The objects are not the same.");

                
        // Create a Stock object
        Stock company1 = new Stock("XYZ", 9.62);
        //Create company2, a copy of company1
        Stock company2 = new Stock(company1);

    }
}
