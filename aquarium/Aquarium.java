package aquarium;

import java.util.ArrayList;

import java.util.List;


public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void setFishInPool(List<Fish> fishInPool) {
        this.fishInPool = fishInPool;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public void add(Fish fish) {


        for (Fish fish1 : fishInPool) {
            if (fish1.getName().equals(fish.getName())){
                return;
            }
        }
        if (fishInPool.size()<capacity){
            fishInPool.add(fish);
        }
    }

    public boolean remove (String name){

        Fish fishToRemove = findFish(name);
        return  fishInPool.remove(fishToRemove);

    }

    public Fish findFish(String name){

        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)){
                return fish;
            }
        }
        return null;
    }


    public String report() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Aquarium: %s ^ Size: %d%n",name,size));

        for (Fish fish : fishInPool) {
            stringBuilder.append(fish.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString() ;
    }
}
