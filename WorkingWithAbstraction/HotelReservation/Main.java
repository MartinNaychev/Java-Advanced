package WorkingWithAbstraction.HotelReservation;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        double price = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        String seasonType = input[2];
        String discount = input[3];

        Season season = Season.valueOf(seasonType.toUpperCase(Locale.ROOT));
        DiscountType discountType = DiscountType.NONE;
        if (discount.equals("VIP")){
            discountType=DiscountType.VIP;
        } else if (discount.equals("SecondVisit")) {
            discountType=DiscountType.SecondVisit;
        }

        double finalPrice = price * numberOfDays * season.getMultiplayer()* discountType.getPercent();
        System.out.printf("%.2f%n",finalPrice);
    }
}
