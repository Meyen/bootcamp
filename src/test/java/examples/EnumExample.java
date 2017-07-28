package examples;

public class EnumExample {

    public enum BootCampDays{
        DAYONE,
        DAYTWO,
        DAYTHREE,
        DAYFOUR,
        DAYFIVE;
    }

    public static String checkBootCampDaysInfo(BootCampDays bootCampDays){
        switch (bootCampDays) {
            case DAYONE:
                return "Zin in!";
            case DAYTWO:
                return "Spijt van!";
            case DAYTHREE:
                return "Oh wat heb ik toch gedaan?";
            case DAYFOUR:
                return "Gaat de zon ooit nog schijnen?";
            case DAYFIVE:
                return "Het viel toch nog mee...";
            default:
                return "Welke dag bedoel je?";
        }
    }
}
