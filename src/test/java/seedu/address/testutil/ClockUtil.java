package seedu.address.testutil;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ClockUtil {
    private static final Instant TEST_CLOCK_TIME = Instant.from(ZonedDateTime.of(LocalDateTime.of(
            2000,10,10,10,10,10,10),ZoneId.systemDefault()));
    public static final Clock DEFAULT_TEST_CLOCK = Clock.fixed(TEST_CLOCK_TIME,ZoneId.systemDefault());
    public static final LocalDateTime DEFAULT_TEST_TIME = LocalDateTime.now(DEFAULT_TEST_CLOCK);
}
