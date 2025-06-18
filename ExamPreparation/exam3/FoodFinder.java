package ExamPreparation.exam3;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        String[] firstLine = scanner.nextLine().split("\\s+");
        String[] secondLine = scanner.nextLine().split("\\s+");

        for (String symbol : firstLine) {
            vowelsQueue.offer(symbol);
        }
        for (String symbol : secondLine) {
            consonantsStack.push(symbol);
        }

        Map<String, String[]> foundedWords = new LinkedHashMap<>();

        foundedWords.put("pear", new String[4]);
        foundedWords.put("flour", new String[5]);
        foundedWords.put("pork", new String[4]);
        foundedWords.put("olive", new String[5]);

        while (!consonantsStack.isEmpty()) {
            String currentConsonant = consonantsStack.pop();
            String currentVowel = vowelsQueue.poll();


            for (var entry : foundedWords.entrySet()) {
                String currentWord = entry.getKey();

                for (int i = 0; i < currentWord.length(); i++) {
                    if (currentWord.charAt(i) == currentConsonant.charAt(0)) {
                        String[] currentArray = entry.getValue();
                        currentArray[i] = currentConsonant;
                        foundedWords.put(currentWord, currentArray);
                    }
                    if (currentWord.charAt(i) == currentVowel.charAt(0)) {
                        String[] currentArray = entry.getValue();
                        currentArray[i] = currentVowel;
                        foundedWords.put(currentWord, currentArray);
                    }
                }
            }

            vowelsQueue.offer(currentVowel);

        }


        List<String> words = new ArrayList<>();

        for (var entry : foundedWords.entrySet()) {
            String word = entry.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            for (String symbol : entry.getValue()) {
                stringBuilder.append(symbol);
            }
            String foundedWord = stringBuilder.toString();


            if (word.equals(foundedWord)) {
                words.add(word);
            }

        }

        System.out.printf("Words found: %d%n", words.size());
        words.forEach(word -> System.out.println(word));


    }
}
