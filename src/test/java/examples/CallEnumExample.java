package examples;

import org.testng.annotations.Test;

public class CallEnumExample {

    @Test
    public void prinTheBootCampDays(){
        System.out.println(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYONE));
        System.out.println(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYTWO));
        System.out.println(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYTHREE));
        System.out.println(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYFOUR));
        System.out.println(EnumExample.checkBootCampDaysInfo(EnumExample.BootCampDays.DAYFIVE));

    }
}
