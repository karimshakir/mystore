import java.util.*;
  
public class Item {
        
    private int quantity;
    private double price;
    private String name;
    private boolean imported;
    private boolean exempt;
    public static final double salesTax_rate = 10;
    public static final double importTax_rate = 0.05;
         
    public Item(int quantity, double price, String name, boolean imported, boolean exempt) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.imported = imported;
        this.exempt = exempt;    
    }

    public double getTax() {
        // calculates tax for a single item
        double sales_tax = 0.00; 
        if (!exempt) {
            // multiply and dividee by 20 to round to nearest .05)
            // divide by 100 becasue sales tax is not represented as a percent
            sales_tax += Math.round(price * salesTax_rate * 20) / (100 * 20.0);
        }
        if (imported) {
            sales_tax  += Math.round(price * importTax_rate * 20) /20.0;
        }
        //System.out.println(sales_tax);
        return sales_tax;
    }

    public void printItem() {
        System.out.println(quantity + " " + name + " " + ":" + " " + getTotalPrice());
    }

    public double getTotalPrice() {
        return Math.round((price + getTax()) * 100) / (100.0);
    }
}


