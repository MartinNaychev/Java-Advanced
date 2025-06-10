package GenericsExercise.GenericBox;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int readLine = Integer.parseInt(scanner.nextLine());
        //задача 1:
        /*Box<String> box = new Box<>();

        while (readLine-- > 0) {
            String line = scanner.nextLine();
            box.add(line);


        }

        System.out.println(box);*/

        //задача 2:
        /*Box<Integer> box = new Box<>();

        while (readLine-- > 0) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);

        }

        System.out.println(box);*/

        //задача 3:
        /*Box<String> box = new Box<>();

        while (readLine-- > 0) {
            String line = scanner.nextLine();
            box.add(line);
        }

        int[] indices = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        box.swap(indices[0],indices[1]);

        System.out.println(box);
*/

        //задача 4:
        /*Box<Integer> box = new Box<>();

        while (readLine-- > 0) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        }

        int[] indices = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        box.swap(indices[0],indices[1]);

        System.out.println(box);
*/

        //задача 5:
        /*Box<String> box = new Box<>();

        while (readLine-- > 0) {
            String line = scanner.nextLine();
            box.add(line);
        }
        String toCompare = scanner.nextLine();

        System.out.println(box.compare(toCompare));
*/
        //задача 6:
        Box<Double> box = new Box<>();

        while (readLine-- > 0) {
            double number = Double.parseDouble(scanner.nextLine());
            box.add(number);
        }
        double toCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(box.compare(toCompare));



    }
}
