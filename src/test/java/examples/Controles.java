package examples;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created by Gerry on 19/07/2017.
 */

public class Controles {

    @Test
    public void vergelijkingentekst() {
        String text = "ditiseenstringmetwatrandomtekst";

        Assertions.assertThat(text).as("Tekst in header").contains("tekst");
    }

    @Test
    public void vergelijkingeninteger() {
        int i = 13;

                Assertions.assertThat(i).as("randomgetal").isGreaterThan(12);
    }

}
