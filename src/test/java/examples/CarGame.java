package examples;

import org.testng.annotations.Test;

/**
 * Created by Gerry on 21/07/2017.
 * Class genaamd Auto,  (1 blauwdruk, 2 objecten)
 */
public class CarGame {

    @Test
    public void startGame() {
        Auto auto = new Auto();
                auto.setColor("Red");
                auto.setBrand("Jaguar");
                auto.setNumberOfDoors(4);
                auto.setEngineType("Diesel");
             //   auto.CalculateTorque(163,4600);

        Auto autoTwo = new Auto();
                autoTwo.setColor("Pimple Purple");
                autoTwo.setBrand("Holden");
                autoTwo.setNumberOfDoors(0);
                autoTwo.setEngineType("Petrol");
            //    autoTwo.CalculateTorque(204,6700);
    }

    @Test
    public void startGameTwo() {
        AutoAdvanced autoAdvanced = new AutoAdvanced("Toyota", 200, 4600);
       // autoAdvanced.printBrand();
    }

}
