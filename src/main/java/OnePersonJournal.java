import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class OnePersonJournal {
    private Integer sessionsInTotal;
    private Integer totalDurationMinutes;
    private Double totalDurationHours;
    private final List<Session> sessionHistory;

    public OnePersonJournal() {
        sessionsInTotal = 0;
        totalDurationMinutes = 0;
        sessionHistory = new ArrayList<Session>();
    }

    public void AddSession(Session newSession) {
        sessionsInTotal++;
        totalDurationMinutes += newSession.getDurationMinutes();
        totalDurationHours = totalDurationMinutes / 60.0;
        sessionHistory.add(newSession);
    }

    public Double ReturnTotalPracticeTime(){
        return Math.round(totalDurationHours * 100.0) / 100.0;
    }

    public long daysSinceStart(){
        return ChronoUnit.DAYS.between(sessionHistory.getFirst().getDate(), LocalDate.now());
    }

    public boolean KyuGraduated(){
        return sessionsInTotal >= 60 || daysSinceStart() > 180;
    }

    public List<Session> getSessionHistory() {
        return sessionHistory;
    }
}
