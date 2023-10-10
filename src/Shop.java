import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    List<Laptop> laptops;

    public Shop(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public List<Laptop> filterLaptops(Map<String, Object> criteria) {
        return laptops.stream()
                .filter(laptop -> criteria.get("ram") == null || laptop.ram >= (int) criteria.get("ram"))
                .filter(laptop -> criteria.get("storage") == null || laptop.storage >= (int) criteria.get("storage"))
                .filter(laptop -> criteria.get("os") == null || laptop.os.equalsIgnoreCase((String) criteria.get("os")))
                .filter(laptop -> criteria.get("color") == null || laptop.color.equalsIgnoreCase((String) criteria.get("color")))
                .collect(Collectors.toList());
    }
}
