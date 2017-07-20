package examples;

import org.testng.annotations.Test;

/**
 * Created by Gerry on 19/07/2017.
 */
public class AboutMethods {

// print
    private void printProduct(int printableInt) {

        System.out.println(printableInt);

    }
// vermenigvuldigen
    private int multiply(int i, int j) {

        int k = i*j;
        return k;
    }
// vermenigvuldigen oproepen, parameters meegeven en print oproepen
    @Test
    public void printMultiply() {
        printProduct(multiply(1,2));


    }

}


