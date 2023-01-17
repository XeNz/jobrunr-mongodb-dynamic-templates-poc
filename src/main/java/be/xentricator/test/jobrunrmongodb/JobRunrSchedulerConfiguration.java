package be.xentricator.test.jobrunrmongodb;

import jakarta.annotation.PostConstruct;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class JobRunrSchedulerConfiguration {

    private final JobScheduler jobScheduler;

    public JobRunrSchedulerConfiguration(JobScheduler jobScheduler) {
        this.jobScheduler = jobScheduler;
    }

    @PostConstruct
    public void init() {
        jobScheduler.scheduleRecurrently("test-job-15", Cron.every15seconds(), TestRecurringJob::testJobExecute);
        jobScheduler.scheduleRecurrently("test-job-30", Cron.every30seconds(), TestRecurringJob::testJobExecute);
        jobScheduler.scheduleRecurrently("test-job-60", Cron.minutely(), TestRecurringJob::testJobExecute);
    }
}
