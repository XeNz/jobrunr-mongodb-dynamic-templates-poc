package be.xentricator.test.jobrunrmongodb.fragments;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class FragmentRegistry {

    private final Table<Application, FragmentName, FragmentContext> table = ImmutableTable.<Application, FragmentName, FragmentContext>builder()
            .put(Application.RESTO, FragmentName.MENUS, new FragmentContext(FragmentName.MENUS.getInnerName(), "fragments/resto", "menus"))
            .put(Application.RESTO, FragmentName.REVIEWS, new FragmentContext(FragmentName.REVIEWS.getInnerName(), "fragments/resto", "reviews"))
            .put(Application.RESTO, FragmentName.VOUCHERS, new FragmentContext(FragmentName.VOUCHERS.getInnerName(), "fragments/resto", "vouchers"))
            .put(Application.TABLEDEALS, FragmentName.MENUS, new FragmentContext(FragmentName.MENUS.getInnerName(), "fragments/td", "menus"))
            .put(Application.TABLEDEALS, FragmentName.REVIEWS, new FragmentContext(FragmentName.REVIEWS.getInnerName(), "fragments/td", "reviews"))
            .put(Application.TABLEDEALS, FragmentName.VOUCHERS, new FragmentContext(FragmentName.VOUCHERS.getInnerName(), "fragments/td", "vouchers"))
            .build();

    public FragmentContext findFragmentContextForApplicationAndFragmentName(Application application, FragmentName fragmentName) {
        return table.get(application, fragmentName);
    }
}
