package info.nkzn.android.sample.horizontal_fragment_list.scroll;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import info.nkzn.android.sample.horizontal_fragment_list.ListItemFragment;
import info.nkzn.android.sample.horizontal_fragment_list.R;

public class HorizontalListActivity extends AppCompatActivity {

    private static final String TAG = HorizontalListActivity.class.getSimpleName();

    @InjectView(R.id.ll_container)
    LinearLayout llContainer;

    final List<ListItemFragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_list);
        ButterKnife.inject(this);

        fragments.add(ListItemFragment.newInstance(1));
        fragments.add(ListItemFragment.newInstance(2));
        fragments.add(ListItemFragment.newInstance(3));
        fragments.add(ListItemFragment.newInstance(4));
        fragments.add(ListItemFragment.newInstance(5));

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        for (Fragment fragment: fragments) {
            final View fragmentContainer = getLayoutInflater().inflate(R.layout.view_fragment_container, llContainer, false);
            fragmentContainer.setId(View.generateViewId());
            llContainer.addView(fragmentContainer);

            fragmentTransaction.add(fragmentContainer.getId(), fragment);
        }

        fragmentTransaction.commit();
    }
}