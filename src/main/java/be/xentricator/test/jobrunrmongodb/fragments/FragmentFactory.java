package be.xentricator.test.jobrunrmongodb.fragments;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FragmentFactory {
    private final DetermineApplicationHelper determineApplicationHelper;
    private final FragmentRegistry fragmentRegistry;

    public FragmentFactory(DetermineApplicationHelper determineApplicationHelper, FragmentRegistry fragmentRegistry) {
        this.determineApplicationHelper = determineApplicationHelper;
        this.fragmentRegistry = fragmentRegistry;
    }

    public FragmentContextHolder getFragmentContextHolderForFragments(FragmentName... fragmentNames) {
        Application application = determineApplicationHelper.determineApplication();
        List<FragmentContext> fragmentContexts = Arrays.stream(fragmentNames)
                .map(fragmentName -> getFragmentContextForApplicationAndFragmentName(application, fragmentName))
                .collect(Collectors.toList());

        return new FragmentContextHolder(fragmentContexts);

    }

    public FragmentContext getFragmentContextForFragment(FragmentName fragmentName) {
        Application application = determineApplicationHelper.determineApplication();
        return getFragmentContextForApplicationAndFragmentName(application, fragmentName);
    }

    private FragmentContext getFragmentContextForApplicationAndFragmentName(Application application, FragmentName fragmentName) {
        return fragmentRegistry.findFragmentContextForApplicationAndFragmentName(application, fragmentName);
    }

}

