public class GroupE_BusinessSimulator {

    public static void main(String[] args) {
        // Build the four real BuildRight Hardware items as one Item[] array.
        // Item[] can hold any subclass because every subclass IS-A Item.
        Item[] items = {
            new PercentDiscountItem("Cement (bag)",    35000.0, 5, 5),   // qty >= 5 -> 5% off
            new NoDiscountItem     ("Nails (kg)",       4000.0),          // never discounted
            new FlatDiscountItem   ("Paint (tin)",     45000.0, 3, 5000), // qty >= 3 -> UGX 5,000 off
            new PercentDiscountItem("Timber (piece)",  25000.0, 4, 10)    // qty >= 4 -> 10% off
        };

        // Phase 1 test quantities - kept so we can verify the same total.
        int[] quantities = {4, 2, 2, 4};

        displayPriceList(items);
        double grandTotal = processAndPrintReceipt(items, quantities);

        System.out.println("----------------------------------------");
        System.out.printf("TOTAL        = UGX %.2f%n", grandTotal);
    }

    // Display formatted business price list (uses getName() / getPrice())
    public static void displayPriceList(Item[] items) {
        System.out.println("==== BUILDRIGHT HARDWARE ====");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-15s UGX %.2f%n",
                    i + 1, items[i].getName(), items[i].getPrice());
        }
        System.out.println();
    }

    // Print receipt lines, then return grand total.
    // Notice: no if/else on item type here at all - each object runs its OWN
    // calculateTotal() (polymorphism), which is the whole point of Phase 2.
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
