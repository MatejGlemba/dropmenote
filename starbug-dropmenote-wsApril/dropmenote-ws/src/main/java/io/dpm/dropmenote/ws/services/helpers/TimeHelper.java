/**
 * 
 */
package io.dpm.dropmenote.ws.services.helpers;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class TimeHelper {

    public static long TIMEHELPER_DEVELTESTING_TIMEOFFSET = 0;

    /**
     * Toto je metoda ktora vracia aktualny cas, ale vracia cas nastaveny v setting
     * apliakcie. Pomaha to ziskavat cas do buducna alebo spatne koli testingu.
     * Pretoze ocas developmentu este nie su platne cestovne poriadky a preto treba
     * datumy do selectov posiealt fejkove.<br>
     * <br>
     * TimeHelper.TIMEHELPER_DEVELTESTING_TIMEOFFSET
     * 
     * @return
     */
    public static Calendar generateConfigurableNow() {
        Calendar now = Calendar.getInstance();
        // Set fake offset
        now.setTimeInMillis(now.getTime().getTime() + TimeHelper.TIMEHELPER_DEVELTESTING_TIMEOFFSET);

        return now;
    }

    /**
     * Add custom ms to the time. You can use negative or positive value
     * 
     * @param addTimeInMs
     * @return
     */
    public static Time addCustomOffset(Time time, int addTimeInMs) {
        return new Time(time.getTime() + (addTimeInMs));
    }

    /**
     * 
     * @param calendar
     * @return
     */
    public static Time convertToHHmmssTime(Calendar calendar) {
        return new Time(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    }

    /**
     * 
     * @param timeInCet
     * @return
     */
    public static LocalDateTime cetToUtc(LocalDateTime timeInCet) {
        ZonedDateTime cetTimeZoned = ZonedDateTime.of(timeInCet, ZoneId.of("CET"));
        return cetTimeZoned.withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
    }

    /**
     * 
     * @param timeInUtc
     * @return
     */
    public static LocalDateTime utcToCet(LocalDateTime timeInUtc) {
        ZonedDateTime utcTimeZoned = ZonedDateTime.of(timeInUtc, ZoneId.of("UTC"));
        return utcTimeZoned.withZoneSameInstant(ZoneId.of("CET")).toLocalDateTime();
    }

    public static void main(String[] args) {
        System.out.println(TimeHelper.generateConfigurableNow());
        System.out.println(TimeHelper.generateConfigurableNow().getTime());
    }
}
