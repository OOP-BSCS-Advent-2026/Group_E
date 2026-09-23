public class GroupE_BusinessSimulator {

    public static void main(String[] args) {
       // Placed the four BuildRight Hardware items into one Item[] array
      // This is possible because every subclass "IS-A" Item.
        Item[] items = {
            new PercentDiscountItem("Cement (bag)",    35000.0, 5, 5),   // qty >= 5 -> 5% off
            new NoDiscountItem     ("Nails (kg)",       4000.0),          // never discounted
            new FlatDiscountItem   ("Paint (tin)",     45000.0, 3, 5000), // qty >= 3 -> UGX 5,000 off
            new PercentDiscountItem("Timber (piece)",  25000.0, 4, 10)    // qty >= 4 -> 10% off
        };

        // Using the same quatities to verify the total in phase 1.
        int[] quantities = {4, 2, 2, 4};

        displayPriceList(items);
        double grandTotal = processAndPrintReceipt(items, quantities);

        System.out.println("----------------------------------------");
        System.out.printf("TOTAL        = UGX %.2f%n", grandTotal);
    }

    // Method to display business price list using getName() and getPrice()
    public static void displayPriceList(Item[] items) {
        System.out.println("==== BUILDRIGHT HARDWARE ====");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-15s UGX %.2f%n",
                    i + 1, items[i].getName(), items[i].getPrice());
        }
        System.out.println();
    }

    // Method to print receipt lines and then return grand total.
    public static double processAndPrintReceipt(Item[] items, int[] quantities) {
        double total = 0.0;
        System.out.println("==== RECEIPT ====");

        for (int i = 0; i < items.length; i++) {
            double lineTotal = items[i].calculateTotal(quantities[i]);
            System.out.printf("%-15s x%d = UGX %.2f%n",
                    items[i].getName(), quantities[i], lineTotal);
            total += lineTotal;
        }

        return total;
    }
}
