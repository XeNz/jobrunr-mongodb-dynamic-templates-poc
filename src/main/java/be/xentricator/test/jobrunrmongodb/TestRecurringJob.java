package be.xentricator.test.jobrunrmongodb;

import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.stereotype.Component;

@Component
public class TestRecurringJob {

    private final TestService testService;

    public TestRecurringJob(TestService testService) {
        this.testService = testService;
    }

    @Recurring(id = "test-recurring-job", cron = "*/10 * * * * *")
    @Job(name = "My recurring job")
    public void testJobExecute() {
        testService.test();
    }
}
