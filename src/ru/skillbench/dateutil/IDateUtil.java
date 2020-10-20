package ru.skillbench.dateutil;

public interface IDateUtil {

    boolean isLeapYear(int year);


    boolean isValidDate(int year, int month, int day);


    int getDayOfWeek(int year, int month, int day);


    String toString(int year, int month, int day);


    int countDays(int year, int month, int day);
}
