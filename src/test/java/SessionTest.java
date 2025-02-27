import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    private Session session;
    private int testDuration;

    @BeforeEach
    void setUp() {
        testDuration = 90;
        session = new Session(testDuration);
    }

    @Test
    void getDurationMinutes() {
        assertEquals(testDuration, session.getDurationMinutes(), "Duration should match the value set in constructor");
    }

    @Test
    void getDate() {
        LocalDate today = LocalDate.now();
        assertEquals(today, session.getDate(), "Session date should be today's date");
    }
}
