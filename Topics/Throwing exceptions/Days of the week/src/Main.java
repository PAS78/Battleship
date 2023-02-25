import java.util.*;

public class Main {

    public static String getDayOfWeekName(int number) {

        String result = "";

        switch (number) {
            case 1 -> result = "Mon";
            case 2 -> result = "Tue";
            case 3 -> result = "Wed";
            case 4 -> result = "Thu";
            case 5 -> result = "Fri";
            case 6 -> result = "Sat";
            case 7 -> result = "Sun";
            default -> throw new IllegalArgumentException("Unexpected value: " + number);
        }
        return result;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        try {
            System.out.println(getDayOfWeekName(dayNumber));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}