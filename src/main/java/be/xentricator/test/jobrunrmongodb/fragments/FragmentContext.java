package be.xentricator.test.jobrunrmongodb.fragments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class FragmentContext {
    private String fragmentName;
    private String template;
    private String fragment;
}
