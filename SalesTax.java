
import java.io.*;
import java.util.Map;
import java.util.HashMap;




public class SalesTax {
    public static void main (String[] args) {
        String fileName;
        double totalSalesTax = 0.0;
        double total = 0.0;


        if (args.length  == 0) {
            System.out.println("Please specify at least 1 string argument");
            System.exit(0);
        }

        
            fileName = args[0];
            //Item myItem;

        try { 
                File f = new File(fileName);

                BufferedReader b = new BufferedReader(new FileReader(f));

                String readLine = "";

                while ((readLine = b.readLine()) != null) {
                    //System.out.println(readLine);
                    String[] parsed = readLine.split(" ");
                    if (parsed.length < 3) {  
                        System.out.println("Not enough info for an item");
                    }

                    int quantity = Integer.parseInt(parsed[0]);
                    //System.out.println("quantity: " + quantity);

                    double price = Double.parseDouble(parsed[parsed.length-1]);
                    //System.out.println("price: " + price);
                   
                    boolean imported = false;
                    int check_if_imported = readLine.indexOf("imported");
                    if (check_if_imported != -1) {
                        imported  = true;
                    }

                    ////////////////////////////////////////////////////////////////////////////////////////////////////////////


                    boolean exempt = false;
                   
                    ///////////////////////////////////////////////////////////////////////////////////////////////////////////


                    //Assembles Name for later use:

                    String name = "";
                    // boolean exempt = false;
                    for ( int i = 0; i < parsed.length; i++) {
                        if ( i > 0  &&  i < parsed.length -2) {
                            name += parsed[i];
                            if (i != parsed.length-3)
                                name += " ";
                        }
                         if (parsed[i].equals("imported")) {
                                 imported = true;
                         }
                         if (parsed[i].equals("book") || parsed[i].equals("pills") || parsed[i].contains("chocolate")) {
                                exempt = true;
                         }
                    }

                    Item myItem = new Item(quantity, price, name, imported, exempt);
                    myItem.printItem();
                    totalSalesTax +=  myItem.getTax();
                    total += myItem.getTotalPrice();
                }

                } catch (IOException e) {
                e.printStackTrace();
            }
            // 
                System.out.format("Sales Taxes: %.2%\n", totalSalesTax);
                System.out.format("Total: %.02f\n", total);

}




}