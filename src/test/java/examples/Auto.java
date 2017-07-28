package examples;

/**
 * Created by Gerry on 21/07/2017.
 */
public class Auto {

    public void setColor(String carColor) {
        System.out.println("The color of the car: " + carColor);
    }

    public void setBrand(String carBrand) {
        System.out.println("The brand of the car: " + carBrand);
    }

    public void setNumberOfDoors(int carDoors) {
        System.out.println("The number of doors of the car: " + carDoors);
    }

    public void setEngineType(String carEngineType) {
        System.out.println("The engine type of the car: " + carEngineType);
    }

    //Torque berekenen
    public void CalculateTorque(int hp, int rpm) {
        System.out.println("Torque of the car is: " + (hp * 5252) / rpm);
    }
}

