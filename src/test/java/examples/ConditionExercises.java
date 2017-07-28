package examples;

import org.testng.annotations.Test;

/**
 * Created by Gerry on 20/07/2017.
 */
public class ConditionExercises {

    public void bootcampAgeChecker (int leeftijd) {
       String resultaat;

        if (leeftijd > 64){
                resultaat = "deelnemer niet toegelaten. Check bij de manager.";
        } else if (leeftijd > 21) {
                resultaat = "deelnemer toegelaten";
        } else {
                resultaat = "deelnemer te jong.";
        }

System.out.println(resultaat + " " + leeftijd);

}

@Test
public void testmember(){
    bootcampAgeChecker(12);
    bootcampAgeChecker(21);
    bootcampAgeChecker(64);
    bootcampAgeChecker(65);
    }
}


