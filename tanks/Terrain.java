package tanks;

import java.util.ArrayList;
import java.util.List;

public class Terrain {

    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.area = area;
        this.tanks = new ArrayList<>();
    }

    public Tank getTankByBrandAndModel(String brand, String model) {
        for (Tank tank : tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
                return tank;
            }
        }

        return null;
    }

    public String addTank(Tank tank) {
        if (getTankByBrandAndModel(tank.getBrand(), tank.getModel()) != null) {
            return "Tank with this brand and model already exists!";
        } else if (this.type.equals("Swamp") && tank.getWeight() > 14000) {
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        } else {
            tanks.add(tank);
            return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
        }

    }

    public boolean removeTank(String brand, String model) {
        Tank tank = getTankByBrandAndModel(brand, model);
        return tanks.remove(tank);
    }


    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> tankBuilder = new ArrayList<>();

        for (Tank tank : tanks) {
            if (tank.getBarrelCaliber() > barrelCaliber) {
                tankBuilder.add(tank.getBrand());
            }
        }

        if (!tankBuilder.isEmpty()) {
            stringBuilder.append(String.format("Tanks with caliber more than %dmm: ", barrelCaliber));
            stringBuilder.append(tankBuilder.toString().replace("[", "").replace("]", ""));
        } else {
            stringBuilder.append("There are no tanks with the specified caliber.");
        }

        return stringBuilder.toString();
    }

    public String getTheMostArmoredTank() {
        StringBuilder stringBuilder = new StringBuilder();
        int thickestArmor = 0;
        for (Tank tank : tanks) {
            if (tank.getArmor() > thickestArmor) {
                thickestArmor = tank.getArmor();
            }
        }
        for (Tank tank : tanks) {
            if (tank.getArmor() == thickestArmor) {
                stringBuilder.append(String.format("%s %s is the most armored tank with %dmm. armor thickness.", tank.getBrand(), tank.getModel(), tank.getArmor()));
            }
        }
        return stringBuilder.toString();
    }

    public int getCount() {
        return this.tanks.size();
    }

    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder();

        if (tanks.isEmpty()){
            stringBuilder.append(String.format("There are no tanks in the %s.",this.type.toLowerCase()));

        }else {

            stringBuilder.append(String.format("Tanks located in the %s:", this.type.toLowerCase()));
            for (Tank tank : tanks) {
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append(String.format("-- %s %s", tank.getBrand(), tank.getModel()));
            }
        }

        return stringBuilder.toString();
    }
}

