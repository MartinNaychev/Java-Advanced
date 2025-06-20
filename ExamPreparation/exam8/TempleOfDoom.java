package ExamPreparation.exam8;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> substanceStack = new ArrayDeque<>();


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> toolsQueue.offer(Integer.valueOf(element)));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> substanceStack.push(Integer.valueOf(element)));
        List<Integer> challengesList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        boolean foundChallenge = false;

        while (!toolsQueue.isEmpty() && !substanceStack.isEmpty()) {
            foundChallenge = false;
            int currentTool = toolsQueue.poll();
            int currentSubstance = substanceStack.pop();
            int result = currentTool * currentSubstance;

            for (Integer challenge : challengesList) {
                if (result == challenge) {
                    foundChallenge = true;
                }
            }

            if (!foundChallenge) {
                toolsQueue.offer(currentTool + 1);
                currentSubstance -= 1;
                if (currentSubstance > 0) {
                    substanceStack.push(currentSubstance);
                }

            }else {
               challengesList.remove(Integer.valueOf(result));
            }


        }


        if (!challengesList.isEmpty()){
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }
        if (!toolsQueue.isEmpty()){
            System.out.print("Tools: ");
            System.out.println(toolsQueue.toString().replace("[","").replace("]",""));
        }
        if (!substanceStack.isEmpty()){
            System.out.print("Substances: ");
            System.out.println(substanceStack.toString().replace("[","").replace("]",""));
        }
        if (!challengesList.isEmpty()){
            System.out.print("Challenges: ");
            System.out.println(challengesList.toString().replace("[","").replace("]",""));
        }
    }
}
