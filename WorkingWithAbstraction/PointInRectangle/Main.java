package WorkingWithAbstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] points = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        Point bottomLeft = new Point(points[0], points[1]);
        Point topRight = new Point(points[2], points[3]);

        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){

            int[] newPoint = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point point = new Point(newPoint[0],newPoint[1]);

            System.out.println( rectangle.Contains(point));


        }

    }
}
