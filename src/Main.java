import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(new Laptop("Model1", 8, 256, "Windows", "Black"));
        laptopList.add(new Laptop("Model2", 16, 512, "macOS", "Gray"));
        // Add more laptops...

        Shop shop = new Shop(laptopList);
        Scanner scanner = new Scanner(System.in);

        Map<String, Object> criteria = new HashMap<>();

        System.out.println("Select filtering criteria: \n1. RAM\n2. Storage\n3. OS\n4. Color");
        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Minimum RAM (GB): ");
                    criteria.put("ram", scanner.nextInt());
                }
                case 2 -> {
                    System.out.print("Minimum Storage (GB): ");
                    criteria.put("storage", scanner.nextInt());
                }
                case 3 -> {
                    System.out.print("Operating System: ");
                    criteria.put("os", scanner.nextLine());
                }
                case 4 -> {
                    System.out.print("Color: ");
                    criteria.put("color", scanner.nextLine());
                }
                default -> System.out.println("Invalid choice.");
            }
            System.out.println("Do you want to add more criteria? (yes/no)");
            if (scanner.next().equalsIgnoreCase("no")) {
                break;
            }
        }

        List<Laptop> filteredLaptops = shop.filterLaptops(criteria);

        // Displaying results
        System.out.println("Filtered laptops:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println("Model: " + laptop.model + ", RAM: " + laptop.ram + ", Storage: " + laptop.storage +
                    ", OS: " + laptop.os + ", Color: " + laptop.color);
        }
    }
}
