package be.xentricator.test.jobrunrmongodb.web;

import be.xentricator.test.jobrunrmongodb.fragments.FragmentContextHolder;
import be.xentricator.test.jobrunrmongodb.fragments.FragmentFactory;
import be.xentricator.test.jobrunrmongodb.fragments.FragmentName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
@RequiredArgsConstructor
public class TestController {

    private final FragmentFactory fragmentFactory;
    @GetMapping(value = "/test")
    public String templateTest(ModelMap modelMap) {
        FragmentContextHolder fragmentContextHolder = fragmentFactory.getFragmentContextHolderForFragments(FragmentName.MENUS);
        modelMap.put("fragmentContextHolder", fragmentContextHolder);
        return "index";
    }
}
