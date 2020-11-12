# Утилита для работы с датами 
## Цель работы : 
### Необходимо реализовать класс для работы с датами, который реализует следующий функцонал:
```java
boolean isLeapYear(int year) //Определяет високосный год или нет.
boolean isValidDate(int year, int month, int day) //Осуществляет проверку даты на корректность.
int getDayOfWeek(int year, int month, int day) //Возвращает номер дня недели, где 0 – MON, 6- SUN (Можно сделать enum – ом )
String toString(int year, int month, int day) //Форматирует дату в красивом виде. Например Tuesday 14 Feb 2012
int countDays(int year, int month, int day) //Вычисляет сколько дней прошло с данной даты по сегодняшнюю
```
