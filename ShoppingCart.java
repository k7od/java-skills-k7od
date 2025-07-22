        public class ShoppingCart {

            public static double calculateTotal(double[] prices, String customerType) {
                double total = 0;
                for (int i = 0; i < prices.length; i++) {
                    total += prices[i];
                }

                switch (customerType.toUpperCase()) {
                    case "REGULAR":
                        break;
                    case "PREMIUM":
                        total = total * 0.9;
                        break;
                    case "VIP":
                        total = total * 0.8;
                        break;
                    default:
                        System.out.println("Unknown customer type and No discount applied.");
                }

                return total;
            }

            public static double findMostExpensive(double[] prices) {
                if (prices.length == 0) {
                    return 0;
                }

                double max = prices[0];

                for (int i = 1; i < prices.length; i++) {
                    if (prices[i] > max) {
                        max = prices[i];
                    }
                }

                return max;
            }

            public static int countExpensiveItems(double[] prices, double threshold) {
                int count = 0;

                for (int i = 0; i < prices.length; i++) {
                    if (prices[i] > threshold) {
                        count++;
                    }
                }

                return count;
            }

            public static void main(String[] args) {
                double[] cart = {35.99,40.99,55.99,65.99,70.99};

                System.out.println("Regular customer: $" + calculateTotal(cart, "REGULAR"));
                System.out.println("Premium customer: $" + calculateTotal(cart, "PREMIUM"));
                System.out.println("VIP customer: $" + calculateTotal(cart, "VIP"));

                double mostExpensive = findMostExpensive(cart);
                System.out.println("The expensive item is: $" + mostExpensive);

                int expensiveCount = countExpensiveItems(cart, 30);
                System.out.println("Number of items over $30: " + expensiveCount);
            }
        }
