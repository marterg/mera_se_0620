import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Date {
    private final int day;
    private  final Month month;
    private final int year;

    Date(int day, Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Date date = (Date) obj;
        return day == date.day &&
                year == date.year &&
                month == date.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public static Date generateRandomDate() {
        Month month = Month.generateRandomMonth();
        int day = ThreadLocalRandom.current().nextInt(month.getDays()) + 1;
        int year = 2020;
        return new Date(day, month, year);
    }
}