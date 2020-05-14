package alistar.moneysave.date.utils;

import alistar.moneysave.date.AbstractDate;
import alistar.moneysave.date.CivilDate;
import alistar.moneysave.date.IslamicDate;
import alistar.moneysave.date.PersianDate;

public class DateUtils {

    public static int getMonthLength(CalendarType calendar, int year, int month) {
        int yearOfNextMonth = month == 12 ? year + 1 : year;
        int nextMonth = month == 12 ? 1 : month + 1;
        return (int) (getDateOfCalendar(calendar, yearOfNextMonth, nextMonth, 1).toJdn() -
                getDateOfCalendar(calendar, year, month, 1).toJdn());
    }

    public static AbstractDate getDateOfCalendar(CalendarType calendar, int year, int month, int day) {
        switch (calendar) {
            case ISLAMIC:
                return new IslamicDate(year, month, day);
            case GREGORIAN:
                return new CivilDate(year, month, day);
            case SHAMSI:
            default:
                return new PersianDate(year, month, day);
        }
    }

}
