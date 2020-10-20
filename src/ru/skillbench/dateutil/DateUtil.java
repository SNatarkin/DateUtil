package ru.skillbench.dateutil;

public class DateUtil implements IDateUtil {

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

    public  boolean isValidDate(int year, int month, int day) {

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

    public  int getDayOfWeek(int year, int month, int day) {
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

    @Override
    public String toString(int year, int month, int day) {
        String date = ("Day " + day + " Month " + month + " Year " + year);
        return date;
    }

    @Override
    public int countDays(int year, int month, int day) {
        int monthLength[] = {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
        int days = 0;
        if (isLeapYear(year) && month > 2) days += 1;
        for (int i = 0; i < month - 1; i++) days += monthLength[i];
        return days += day;
    }





}
