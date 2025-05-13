package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String,Double>> shops = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")){
            String[] storeData = input.split(", ");
            String shop = storeData[0];
            String product = storeData[1];
            double price = Double.parseDouble(storeData[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).put(product,price);


            input= scanner.nextLine();
        }

        for (var shop : shops.entrySet()) {
            String shopName = shop.getKey();
            System.out.println(shopName + "->");
            for (var product : shop.getValue().entrySet()) {
                String productName = product.getKey();
                double price = product.getValue();
                System.out.printf("Product: %s, Price: %.1f%n",productName,price);
            }
        }
    }
}
