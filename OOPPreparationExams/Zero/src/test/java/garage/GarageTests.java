package OOPPreparationExams.Zero.src.test.java.garage;
/*

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GarageTests {
    private Garage garage;
    private Car car;


    @BeforeEach
    public void createGarageAndCar(){
        this.garage= new Garage("Sofia_Garage", 2);
        this.car = new Car("Mazda", 150, "Red");
        garage.addCar(car);
    }

    @Test
    public void addCarTest(){

        garage.addCar(new Car("Mercedes", 150, "Black"));
        Assertions.assertEquals(2, garage.getCount());

    }


    @Test
   public void addCarInFullCollection(){

        garage.addCar(new Car("Mercedes", 150, "Black"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  garage.addCar(new Car("BMW", 130, "Yellow")));

    }
    @Test
    public void addExistingCar(){

        Assertions.assertThrows(IllegalArgumentException.class,() -> garage.addCar(car));
    }
    @Test
    public void removeCar(){

        Assertions.assertTrue(garage.removeCar(car.getBrand()));
    }

    @Test
    public void removeCarNotExist(){

        Assertions.assertFalse(garage.removeCar("BMW"));
    }


    @Test
    public void returnMostPowerfulCar(){
        garage.addCar(new Car("Mercedes", 200, "Black"));
        String mostPowerfulCar = garage.getMostPowerfulCar();
        Assertions.assertEquals("Mercedes", mostPowerfulCar);
    }


    @Test
    public  void returnCarWithColor(){

        List<Car> cars= garage.getCarsWithDesiredColor("Red");
        Assertions.assertEquals(car, cars.getFirst());

    }

    @Test
    public  void returnCarWithNoExistingColor(){

        List<Car> cars= garage.getCarsWithDesiredColor("Black");
        Assertions.assertTrue(cars.isEmpty());
    }
    @Test

    public void returnCarsListSize(){
        Assertions.assertEquals(1, garage.getCount());

    }
    @Test

    public void returnCarName(){
        Assertions.assertEquals("Sofia_Garage", garage.getName());
    }

    @Test

    public void tesGetCapacity(){
        Assertions.assertEquals(2, garage.getCapacity());
    }




    @Test
    public void setNameThrowNullPointerException(){
        Assertions.assertThrows(NullPointerException.class,()-> garage.setName("   "));
        Assertions.assertThrows(NullPointerException.class,()-> garage.setName(null));
        Assertions.assertThrows(NullPointerException.class,()-> garage.setName(""));

    }


    @Test
    public void setNameTest(){
       garage.setName("Center");
       Assertions.assertEquals("Center", garage.getName());

    }
    @Test
    public void  setCapacityThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> garage.setCapacity(-5));
    }

    @Test
    public void  setCapacityTest(){
       garage.setCapacity(10);
       Assertions.assertEquals(10, garage.getCapacity());
    }

}


*/
