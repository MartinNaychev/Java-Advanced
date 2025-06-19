package ExamPreparation.exam4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> contestantsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> piesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> contestantsQueue.offer(Integer.valueOf(element)));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> piesStack.push(Integer.valueOf(element)));

        while (!contestantsQueue.isEmpty() && !piesStack.isEmpty() ){

            int contestant = contestantsQueue.poll();
            int piePieces = piesStack.pop();

            if (contestant>=piePieces){
                if (contestant-piePieces>0){
                    contestantsQueue.offer(contestant-piePieces);
                }

            }else {
                int leftPieces = piePieces-contestant;

                if (leftPieces>1){
                    piesStack.push(leftPieces);
                } else if (piesStack.isEmpty()) {
                    piesStack.push(leftPieces);
                } else {
                    int newPiece = piesStack.pop();
                    piesStack.push(newPiece+leftPieces);

                }

            }

        }

        if (piesStack.isEmpty() && !contestantsQueue.isEmpty()){
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.print("Contestants left: ");
            System.out.println(contestantsQueue.toString()
                    .replace("[","").replace("]",""));
        } else if (!piesStack.isEmpty() && contestantsQueue.isEmpty()) {
            System.out.println("Our contestants need to rest!");
            System.out.print("Pies left: ");
            System.out.println(piesStack.reversed().toString()
                    .replace("[","").replace("]",""));

        }else {
            System.out.println("We have a champion!");
        }


    }
}
