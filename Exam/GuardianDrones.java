package Exam;

import java.util.*;

public class GuardianDrones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> mechanicalPartsStack = new ArrayDeque<>();
        ArrayDeque<Integer> powerCellsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> mechanicalPartsStack.push(Integer.valueOf(element)));

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> powerCellsQueue.offer(Integer.valueOf(element)));

        List<String> drones = new ArrayList<>();
        drones.add("Sentinel-X");
        drones.add("Viper-MKII");
        drones.add("Aegis-7");
        drones.add("Striker-R");
        drones.add("Titan-Core");

        List<String> assembledDrones = new ArrayList<>();

        while (!drones.isEmpty() && !mechanicalPartsStack.isEmpty() && !powerCellsQueue.isEmpty()) {

            int currentPart = mechanicalPartsStack.pop();
            int powerCell = powerCellsQueue.poll();

            int totalPower = currentPart + powerCell;


            if (totalPower >= 100 && drones.contains("Sentinel-X")) {
                if (totalPower==100){
                    drones.remove("Sentinel-X");
                    assembledDrones.add("Sentinel-X");

                }else {
                    drones.remove("Sentinel-X");
                    assembledDrones.add("Sentinel-X");
                    int newPowerCell = powerCell - 30;
                    if (newPowerCell > 0) {
                        powerCellsQueue.offer(newPowerCell);
                    }
                }

            } else if (totalPower >= 85 && drones.contains("Viper-MKII")) {
                if (totalPower == 85) {
                    drones.remove("Viper-MKII");
                    assembledDrones.add("Viper-MKII");
                } else {
                    drones.remove("Viper-MKII");
                    assembledDrones.add("Viper-MKII");
                    int newPowerCell = powerCell - 30;
                    if (newPowerCell > 0) {
                        powerCellsQueue.offer(newPowerCell);
                    }

                }

            } else if (totalPower >= 75 && drones.contains("Aegis-7")) {
                if (totalPower == 75) {
                    drones.remove("Aegis-7");
                    assembledDrones.add("Aegis-7");
                }else {
                    drones.remove("Aegis-7");
                    assembledDrones.add("Aegis-7");
                    int newPowerCell = powerCell - 30;
                    if (newPowerCell > 0) {
                        powerCellsQueue.offer(newPowerCell);
                    }

                }

            } else if (totalPower >= 65 && drones.contains("Striker-R")) {
                if (totalPower==65){
                    drones.remove("Striker-R");
                    assembledDrones.add("Striker-R");
                }else {
                    drones.remove("Striker-R");
                    assembledDrones.add("Striker-R");
                    int newPowerCell = powerCell - 30;
                    if (newPowerCell > 0) {
                        powerCellsQueue.offer(newPowerCell);
                    }
                }



            } else if (totalPower >= 55 && drones.contains("Titan-Core")) {
                if (totalPower==55){
                    drones.remove("Titan-Core");
                    assembledDrones.add("Titan-Core");
                }else {
                    drones.remove("Titan-Core");
                    assembledDrones.add("Titan-Core");
                    int newPowerCell = powerCell - 30;
                    if (newPowerCell > 0) {
                        powerCellsQueue.offer(newPowerCell);
                    }
                }


            }else {
                int newPowerCell = powerCell - 1;
                if (newPowerCell > 0) {
                    powerCellsQueue.offer(newPowerCell);
                }
            }


        }


       if (drones.isEmpty()){
           System.out.println("Mission Accomplished! All Guardian Drones activated!");
       }else {
           System.out.println("Mission Failed! Some drones were not built.");
       }

       if (!assembledDrones.isEmpty()){
           System.out.print("Assembled Drones: ");
           System.out.println(assembledDrones.toString().replace("[","").replace("]",""));
       }

       if (!mechanicalPartsStack.isEmpty()){
           System.out.print("Mechanical Parts: ");
           System.out.println(mechanicalPartsStack.toString().replace("[","").replace("]",""));
       }
       if (!powerCellsQueue.isEmpty()){
           System.out.print("Power Cells: ");
           System.out.println(powerCellsQueue.toString().replace("[","").replace("]",""));
       }


    }


}
