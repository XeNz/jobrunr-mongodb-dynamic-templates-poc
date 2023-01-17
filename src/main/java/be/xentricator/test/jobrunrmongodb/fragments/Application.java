package be.xentricator.test.jobrunrmongodb.fragments;

import lombok.Getter;

public enum Application {
    TABLEDEALS("tabledeals"),
    RESTO("resto");

    @Getter
    private final String innerName;

    Application(String innerName) {
        this.innerName = innerName;
    }
}
