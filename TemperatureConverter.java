import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1. Convert Celsius to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Celsius");
            System.out.print("Enter your choice (1 or 2): ");

            int choice = scanner.nextInt();

            System.out.print("Enter the temperature value: ");
            double temperature = scanner.nextDouble();

            double convertedTemperature = switch (choice) {
                case 1 -> (temperature * 9 / 5) + 32;
                case 2 -> (temperature - 32) * 5 / 9;
                default -> {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    yield Double.NaN; // Return NaN for invalid input
                }
            };

            if (!Double.isNaN(convertedTemperature)) {
                switch (choice) {
                    case 1 -> System.out.printf("%.2f degrees Celsius is %.2f degrees Fahrenheit.", temperature, convertedTemperature);
                    case 2 -> System.out.printf("%.2f degrees Fahrenheit is %.2f degrees Celsius.", temperature, convertedTemperature);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}