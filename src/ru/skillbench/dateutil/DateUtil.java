package ru.skillbench.dateutil;

public class DateUtil implements IDateUtil {
    private static  String[] strDays =  { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
            "Saturday", "Sunday" };
    private static  String[] strMonths = {"January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"};

    public boolean isLeapYear(int year) {
        boolean isLeap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeap = true;
                } else {
                    isLeap = false;
                }
            } else {
                isLeap = true;
            }
        } else {
            isLeap = false;
        }
        return isLeap;
    }

    public boolean isValidDate(int year, int month, int day) {

        if (year > 10000 || year < 1000)
            return false;

        if (month < 1 || month > 12)
            return false;

        if (day < 1 || day > 31)
            return false;

        if (month == 2) {
            if (isLeapYear(year))
                return (day <= 29);
            else
                return (day <= 28);
        }

        if (month == 4 || month == 6 || month == 9 || month == 11)
            return (day <= 30);

        return true;
    }

    public int getDayOfWeek(int year, int month, int day) {
        int num = 0;
        int dayName;

        if (year / 100 == 17) {
            num += 4;
        }
        if (year / 100 == 18) {
            num += 2;
        }
        if (year / 100 == 19) {
            num += 0;
        }
        if (year / 100 == 20) {
            num += 6;
        }
        if (year / 100 == 21) {
            num += 4;
        }
        if (year / 100 == 22) {
            num += 2;
        }
        if (year / 100 == 23) {
            num += 0;
        }
        if (year / 100 == 24) {
            num += 6;
        }
        int x = year % 100;
        num += x / 4;
        num += day + month;
        dayName = num % 7;
        return dayName;
    }

    public  String toString(int year, int month, int day) {
        int dayOfWeek = getDayOfWeek(year, month, day);
        String str = strDays[dayOfWeek];
        String strMonth = strMonths[month-1];
        return str + " " + day + " " + strMonth + " " + year;
    }

    public  int countDays(int year, int month, int day) {
        long dayinMillis = 24 * 60 * 60 * 1000;
        long current = System.currentTimeMillis();
        long leap = (year - 1970) / 4;
        if (year % 4 == 3 || year % 4 == 2) {
            leap--;
        }
        long days = ((year - 1970) * 365 + dayAtTheBeginningOfTheYear(month) + leap + day) * dayinMillis;
        long diff = current - days;
        long count = diff / dayinMillis;
        return (int) count;
    }
    public static int dayAtTheBeginningOfTheYear(int month) {
        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += monthsday(i);
        }
        return sum;
    }
    public static int monthsday(int month) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            return 28;
        }
        return 31;
    }
}
