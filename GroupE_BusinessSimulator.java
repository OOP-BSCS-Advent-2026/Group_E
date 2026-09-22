public class GroupE_BusinessSimulator {

    public static void main(String[] args) {
        Item[] items = {
            new PercentDiscountItem("Cement (bag)", 35000.0, 5, 5),
            new NoDiscountItem("Nails (kg)", 4000.0),
            new FlatDiscountItem("Paint (tin)", 45000.0, 3, 5000),
            new PercentDiscountItem("Timber (piece)", 25000.0, 4, 10)
        };

        int[] quantities = {4, 2, 2, 4};

        displayPriceList(items);
        double grandTotal = processAndPrintReceipt(items, quantities);

        System.out.println("----------------------------------------");
        System.out.printf("TOTAL        = UGX %.2f%n", grandTotal);
    }

    public static void displayPriceList(Item[] items) {
        System.out.println("==== BUILDRIGHT HARDWARE ====");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-15s UGX %.2f%n",
                    i + 1, items[i].getName(), items[i].getPrice());
        }
        System.out.println();
    }

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

    static class Item {
        private final String name;
        private final double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public double calculateTotal(int quantity) {
            return price * quantity;
        }
    }

    static class NoDiscountItem extends Item {
        public NoDiscountItem(String name, double price) {
            super(name, price);
        }
    }

    static class PercentDiscountItem extends Item {
        private final int threshold;
        private final int percentage;

        public PercentDiscountItem(String name, double price, int threshold, int percentage) {
            super(name, price);
            this.threshold = threshold;
            this.percentage = percentage;
        }

        @Override
        public double calculateTotal(int quantity) {
            double subtotal = super.calculateTotal(quantity);
            if (quantity >= threshold) {
                subtotal = subtotal * (100 - percentage) / 100.0;
            }
            return subtotal;
        }
    }

    static class FlatDiscountItem extends Item {
        private final int threshold;
        private final double flatAmount;

        public FlatDiscountItem(String name, double price, int threshold, double flatAmount) {
            super(name, price);
            this.threshold = threshold;
            this.flatAmount = flatAmount;
        }

        @Override
        public double calculateTotal(int quantity) {
            double subtotal = super.calculateTotal(quantity);
            if (quantity >= threshold) {
                subtotal = Math.max(0, subtotal - flatAmount);
            }
            return subtotal;
        }
    }
}