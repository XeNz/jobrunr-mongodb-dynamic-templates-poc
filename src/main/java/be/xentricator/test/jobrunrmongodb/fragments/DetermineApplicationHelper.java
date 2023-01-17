package be.xentricator.test.jobrunrmongodb.fragments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DetermineApplicationHelper {

    @Value("${application.name}")
    private String applicationName;

    public Application determineApplication() {
        return Objects.equals(applicationName, Application.TABLEDEALS.getInnerName()) ?
                Application.TABLEDEALS :
                Application.RESTO;
    }
}

