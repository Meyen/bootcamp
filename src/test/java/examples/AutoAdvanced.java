package examples;

/**
 * Created by Gerry on 21/07/2017.
 * Constructor (alles in constructor wordt meteen gedaan, je hoeft geen class aan te roepen.
 * Komt in de blauwdruk, is altijd zelfde. (bvb allemaal toyota's) constructor moet je altijd meegeven, moet er altijd zijn.
 */
public class AutoAdvanced {

    public String brand;

    // brand leeft nu in de hele methode
    public AutoAdvanced(String brand, int hp, int rpm) {
        this.brand = brand;
        System.out.println("Car is ready to drive");
        System.out.println("Brand of the car is " + brand);
        CalculateTorque(hp,rpm); // moeten vanuit class worden meegegeven
    }

    public void CalculateTorque(int hp, int rpm) {
        System.out.println("Torque of the car is " + (hp * 5252) / rpm);
    }


    public void printBrand() {
        System.out.println(brand);
    }
}
