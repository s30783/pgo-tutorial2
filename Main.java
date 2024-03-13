import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you a resident of Warsaw? (yes/no): ");
        boolean fromWarsaw = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Is it Thursday? (yes/no): ");
        boolean isThursday = scanner.nextLine().equalsIgnoreCase("yes");

        double ticketPrice = calculateTicketPrice(city, age, fromWarsaw, isThursday);
        double discount = calculateDiscount(city, age, fromWarsaw, isThursday);

        System.out.println("\nData: " + city + ", " + age + " years old, " + (isThursday ? "Thursday" : "weekday"));
        System.out.println("Ticket price: " + ticketPrice + " PLN");
        System.out.println("Discount: " + discount + "%");
    }

    public static double calculateTicketPrice(String city, int age, boolean fromWarsaw, boolean isThursday) {
        double basePrice = 40;
        double ticketPrice;

        if (age < 10) {
            ticketPrice = 0;
        } else if (age <= 18) {
            ticketPrice = basePrice / 2;
        } else {
            ticketPrice = basePrice;
        }

        if (fromWarsaw) {
            ticketPrice *= 0.9;
        }

        if (isThursday) {
            ticketPrice = 0;
        }

        return ticketPrice;
    }

    public static double calculateDiscount(String city, int age, boolean fromWarsaw, boolean isThursday) {
        double discount = 0;

        if (age <= 18) {
            discount += 50;
        }

        if (fromWarsaw) {
            discount += 10;
        }

        if (isThursday) {
            discount = 100;
        }

        return discount;
    }
}