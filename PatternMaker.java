        public class PatternMaker {
            public static void printNumberTriangle(int rows) {
                for (int i = 1; i <= rows; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
            }
            public static void printMultiplicationTable(int number, int limit) {
                for (int i = 1; i <= limit; i++) {
                    int result = number * i;
                    System.out.println(number + " x " + i + " = " + result);
                }
            }
            public static void main(String[] args) {
                System.out.println("Triangle Numbers:");
                printNumberTriangle(5);

                System.out.println("\nMultiplication Table of 5:");
                printMultiplicationTable(5, 12);
            }
        }
