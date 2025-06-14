package ExamPreparation;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> swords = new TreeMap<>();
        swords.put("Gladius",0);
        swords.put("Shamshir",0);
        swords.put("Katana",0);
        swords.put("Sabre",0);


        ArrayDeque<Integer> steels = new ArrayDeque<>();
        ArrayDeque<Integer> carbons = new ArrayDeque<>();


        int[] steelInput = readArray(scanner);
        int[] carbonInput = readArray(scanner);

        for (int steel : steelInput) {
            steels.offer(steel);
        }
        for (int carbon : carbonInput) {
            carbons.push(carbon);
        }

        int craftedSwords = 0;

        while (!carbons.isEmpty() && !steels.isEmpty()) {


            int currentSteal = steels.peek();
            int currentCarbon = carbons.peek();
            int currentMaterialsSum =currentSteal+currentCarbon;

            switch (currentMaterialsSum){
                case 70 ->{

                    if (swords.containsKey("Gladius")){
                        int currentCount = swords.get("Gladius")+1;
                        swords.put("Gladius",currentCount);
                    }else {
                        swords.put("Gladius",1);
                    }

                    craftedSwords+=1;
                    steels.poll();
                    carbons.pop();
                }
                case 80 ->{


                    if (swords.containsKey("Shamshir")){
                        int currentCount = swords.get("Shamshir")+1;
                        swords.put("Shamshir",currentCount);
                    }else {
                        swords.put("Shamshir",1);
                    }

                    craftedSwords+=1;
                    steels.poll();
                    carbons.pop();
                }
                case 90 -> {

                    if (swords.containsKey("Katana")){
                        int currentCount = swords.get("Katana")+1;
                        swords.put("Katana",currentCount);
                    }else {
                        swords.put("Katana",1);
                    }


                    craftedSwords+=1;
                    steels.poll();
                    carbons.pop();
                }
                case 110 ->{

                    if (swords.containsKey("Sabre")){
                        int currentCount = swords.get("Sabre")+1;
                        swords.put("Sabre",currentCount);
                    }else {
                        swords.put("Sabre",1);
                    }

                    craftedSwords+=1;
                    steels.poll();
                    carbons.pop();
                }
                default -> {
                    steels.poll();
                    carbons.pop();
                    currentCarbon += 5;
                    carbons.push(currentCarbon);
                }
            }


        }
      if (craftedSwords !=0){
          System.out.printf("You have forged %d swords.%n", craftedSwords);
      }else {
          System.out.println("You did not have enough resources to forge a sword.");
      }


      if (steels.isEmpty()){
          System.out.println("Steel left: none");
      }else {
          System.out.print("Steel left: ");
          System.out.println(steels.toString().replace("[","").replace("]", ""));
      }
      if (carbons.isEmpty()){
          System.out.println("Carbon left: none");
      }else {
          System.out.print("Carbon left: ");
          System.out.println(carbons.toString().replace("[","").replace("]", ""));
      }


    if (!swords.isEmpty()){
       swords.entrySet().stream().filter(e-> e.getValue()!=0).forEach(sword -> System.out.println(sword.getKey() + ": " + sword.getValue()));
    }




    }

    private static int[] readArray(Scanner scanner) {

        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
