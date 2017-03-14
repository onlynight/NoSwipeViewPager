package com.github.onlynight.noswipeviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private LinearLayout btnPage1;
    private LinearLayout btnPage2;
    private LinearLayout btnPage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        btnPage1 = (LinearLayout) findViewById(R.id.btnPage1);
        btnPage2 = (LinearLayout) findViewById(R.id.btnPage2);
        btnPage3 = (LinearLayout) findViewById(R.id.btnPage3);

        btnPage1.setOnClickListener(this);
        btnPage2.setOnClickListener(this);
        btnPage3.setOnClickListener(this);
        initFragment();
    }

    private void initFragment() {
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            private DemoFragment[] fragments = {
                    new DemoFragment(),
                    new DemoFragment(),
                    new DemoFragment()
            };

            @Override
            public Fragment getItem(int position) {
                DemoFragment fragment = fragments[position];
                fragment.updateTitle("pager" + (position + 1));
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        };

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnPage1:
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.btnPage2:
                viewPager.setCurrentItem(1, false);
                break;
            case R.id.btnPage3:
                viewPager.setCurrentItem(2, false);
                break;
        }
    }
}
