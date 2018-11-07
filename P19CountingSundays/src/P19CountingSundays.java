import java.util.HashMap;

public class P19CountingSundays {

    public static void main(String[] args) {
        int sundays = 0;
        int month = 1; // January
        int year = 1901;

        // 1 = Monday...
        //1900 not a leap year ==> 365 days
        int day = 365 % 7 + 1; // 1 Jan 1901 day

        HashMap<Integer, Integer> daysInMonth = new HashMap<>();
        daysInMonth.put(1, 31);
        daysInMonth.put(2, 28);
        daysInMonth.put(3, 31);
        daysInMonth.put(4, 30);
        daysInMonth.put(5, 31);
        daysInMonth.put(6, 30);
        daysInMonth.put(7, 31);
        daysInMonth.put(8, 31);
        daysInMonth.put(9, 30);
        daysInMonth.put(10, 31);
        daysInMonth.put(11, 30);
        daysInMonth.put(12, 31);

        while (year != 2001) {
            if (day == 7) sundays++;

            boolean leap = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
            int toNext1;
            if (month == 2 && leap) toNext1 = 29;
            else toNext1 = daysInMonth.get(month);
            day = (day + toNext1 % 7) % 7;
            if (day == 0) day =7;

            if (month == 12) {
                month = 1;
                year++;
            }
            else month++;
        }

        System.out.println(sundays);
    }

}
