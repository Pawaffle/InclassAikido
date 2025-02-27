import java.time.LocalDate;

public class Session {
    private final LocalDate date;
    private final Integer durationMinutes;

    public Session(Integer duration) {
        this.durationMinutes = duration;
        this.date = LocalDate.now();
    }

    public Integer getDurationMinutes() { return durationMinutes; }
    public LocalDate getDate() { return date; }
}
