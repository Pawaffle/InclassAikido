import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OnePersonJournalTest {
    private OnePersonJournal journal;

    @BeforeEach
    void setUp() {
        journal = new OnePersonJournal();
    }

    @Test
    void addSession() {
        Session session = new Session(90);
        journal.AddSession(session);
        List<Session> newlist = journal.getSessionHistory();

        assertEquals(1, newlist.size(), "Session history should contain 1 session");
    }

    @Test
    void returnTotalPracticeTime() {
        journal.AddSession(new Session(90)); // 1.5 hours
        journal.AddSession(new Session(30)); // 0.5 hours

        assertEquals(2.00, journal.ReturnTotalPracticeTime(), "Total practice time should be 2.00 hours");
    }

    @Test
    void daysSinceStart() {
        Session session = new Session(90);
        journal.AddSession(session);

        long expectedDays = ChronoUnit.DAYS.between(session.getDate(), LocalDate.now());
        assertEquals(expectedDays, journal.daysSinceStart(), "Days since start should be correctly calculated");
    }

    @Test
    void kyuGraduated() {
        journal.AddSession(new Session(90));
        assertFalse(journal.KyuGraduated(), "Should not be eligible for Kyu yet");

        for (int i = 0; i < 60; i++) {
            journal.AddSession(new Session(60));
        }
        assertTrue(journal.KyuGraduated(), "Should be eligible for Kyu by session count");
    }
}
