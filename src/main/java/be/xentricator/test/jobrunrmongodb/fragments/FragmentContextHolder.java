package be.xentricator.test.jobrunrmongodb.fragments;

import lombok.Data;

import java.util.List;

@Data
public class FragmentContextHolder {

    List<FragmentContext> fragmentContexts;

    public FragmentContextHolder(List<FragmentContext> fragmentContexts) {
        this.fragmentContexts = fragmentContexts;
    }

    public FragmentContext getForFragmentName(String fragmentName) {
        return fragmentContexts.stream()
                .filter(fc -> fc.getFragmentName().equals(fragmentName))
                .findFirst()
                .orElseThrow(  () -> new RuntimeException("Cannot find fragment for %s".formatted(fragmentName)));
    }
}
