package be.xentricator.test.jobrunrmongodb.fragments;

import lombok.Getter;

public enum FragmentName {
    MENUS("menus"),
    REVIEWS("reviews"),
    VOUCHERS("vouchers");

    @Getter
    private final String innerName;

    FragmentName(String innerName) {
        this.innerName = innerName;
    }
}
