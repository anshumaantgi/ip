package Tasks;

import Exceptions.DateTimeNotParsed;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TimeParser {
    private static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("E,dd'%s' MMMM,yyyy ha", Locale.ENGLISH);
    private static final DateTimeFormatter DATE_PARSE_FORMAT = DateTimeFormatter.ofPattern("d/M/y", Locale.ENGLISH);
    private static final DateTimeFormatter TIME_PARSE_FORMAT = DateTimeFormatter.ofPattern("HHMM", Locale.ENGLISH);
    private LocalDate ld;
    private LocalTime lt;
    private LocalDateTime ldt;


    public TimeParser(String input) throws DateTimeNotParsed {
        try {
            String[] DateTime = input.trim().split(" ");
            this.ld = LocalDate.parse(DateTime[0], DATE_PARSE_FORMAT); // dd/mm/yyyy
            this.lt = LocalTime.parse(DateTime[1], TIME_PARSE_FORMAT);// HHMM
            this.ldt = LocalDateTime.of(ld, lt);
        } catch (DateTimeParseException e) {
            throw new DateTimeNotParsed(input);
        }
    }

    //This was adapted from https://stackoverflow.com/questions/4011075/how-do-you-format-the-day-of-the-month-to-say-11th-21st-or-23rd-ordinal
    @Override
    public String toString(){
        int day = ldt.getDayOfMonth();
        String daySuff = this.getDaySuffix(day);
        return String.format(DATE_TIME_PATTERN.format(ldt), daySuff);
    }

    public String getDaySuffix(int day) {
            if (day  == 1 || day == 21 || day == 31) {
                return "st";
            } else if(day == 2 || day == 22) {
                return "nd";
            } else if (day == 3 || day ==23) {
                return "rd";
            } else {
                return "th";
            }
    }

}
