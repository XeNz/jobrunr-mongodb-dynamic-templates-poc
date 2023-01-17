package be.xentricator.test.jobrunrmongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class TestServiceImpl implements TestService{
    Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public void test() {
        logger.info("running test service at {}", LocalDateTime.now());
    }
}
