package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        Function<Double, Double> priceWithVat = price -> price * 1.20;

        Consumer<Double> priceFormat = price -> System.out.printf("%.2f%n",price);

        System.out.println("Prices with VAT:");

        for (Double price : prices) {
           double priceVat = priceWithVat.apply(price);
           priceFormat.accept(priceVat);


        }
    }
}
