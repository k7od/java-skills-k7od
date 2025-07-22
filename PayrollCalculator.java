        public class PayrollCalculator {

            public static double calculateWeeklyPay(String type, double hours, double rate) {
                if (hours < 0 || rate < 0) {
                    System.out.println("Invalid input: negative hours or rate.");
                    return 0;
                }

                double pay = 0;

                switch (type) {
                    case "FULL_TIME":
                        if (hours > 40) {
                            pay = (40 * rate) + ((hours - 40) * rate * 1.5);
                        } else {
                            pay = hours * rate;
                        }
                        break;

                    case "PART_TIME":
                        if (hours > 25) hours = 25;
                        pay = hours * rate;
                        break;

                    case "CONTRACTOR":
                        pay = hours * rate;
                        break;

                    case "INTERN":
                        if (hours > 20) hours = 20;
                        pay = hours * rate * 0.8; // 20% discount
                        break;

                    default:
                        System.out.println("Unknown employee type: " + type);
                }

                return pay;
            }

            public static double calculateTax(double grossPay, boolean hasInsurance) {
                double tax = 0;

                if (grossPay <= 500) {
                    tax = grossPay * 0.10;
                } else if (grossPay <= 1000) {
                    tax = grossPay * 0.15;
                } else if (grossPay <= 2000) {
                    tax = grossPay * 0.20;
                } else {
                    tax = grossPay * 0.25;
                }

                if (hasInsurance) {
                    tax -= 50;
                    if (tax < 0) tax = 0;
                }

                return tax;
            }

            public static void processPayroll(String[] types, double[] hours, double[] rates, String[] names) {
                int count = Math.min(Math.min(types.length, hours.length), Math.min(rates.length, names.length));

                double totalPay = 0;
                double maxPay = Double.MIN_VALUE;
                double minPay = Double.MAX_VALUE;
                String highestName = "";
                String lowestName = "";
                int overtimeWorkers = 0;

                System.out.println("\n--- Payroll Summary ---");
                System.out.printf("%-10s %-12s %-6s %-6s %-10s %-10s %-10s\n",
                        "Name", "Type", "Hours", "Rate", "Gross", "Tax", "Net");

                for (int i = 0; i < count; i++) {
                    double gross = calculateWeeklyPay(types[i], hours[i], rates[i]);
                    double tax = calculateTax(gross, true);
                    double net = gross - tax;

                    System.out.printf("%-10s %-12s %-6.1f %-6.2f %-10.2f %-10.2f %-10.2f\n",
                            names[i], types[i], hours[i], rates[i], gross, tax, net);

                    totalPay += net;

                    if (gross > maxPay) {
                        maxPay = gross;
                        highestName = names[i];
                    }

                    if (gross < minPay) {
                        minPay = gross;
                        lowestName = names[i];
                    }

                    if (hours[i] > 40) {
                        overtimeWorkers++;
                    }
                }

                double avgPay = totalPay / count;

                System.out.println("\n--- Statistics ---");
                System.out.println("Highest Paid: " + highestName + " ($" + maxPay + ")");
                System.out.println("Lowest Paid: " + lowestName + " ($" + minPay + ")");
                System.out.println("Average Net Pay: $" + String.format("%.2f", avgPay));
                System.out.println("Employees with Overtime: " + overtimeWorkers);
            }

            public static void main(String[] args) {
                String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
                double[] hours = {45, 20, 35, 15, 50};
                double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
                String[] names = {"Idris", "Albaraa", "Ahmed", "Osama", "Mohammed"};

                System.out.println("--- Individual Pay ---");
                for (int i = 0; i < types.length; i++) {
                    double gross = calculateWeeklyPay(types[i], hours[i], rates[i]);
                    double tax = calculateTax(gross, true);
                    double net = gross - tax;
                    System.out.printf("%s: Gross = %.2f, Tax = %.2f, Net = %.2f\n", names[i], gross, tax, net);
                }

                processPayroll(types, hours, rates, names);
            }
        }
