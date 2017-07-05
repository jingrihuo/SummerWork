package com.zucc.circle.summerwork;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.zucc.circle.summerwork.Fragment.GroupPlanFragment;
import com.zucc.circle.summerwork.Fragment.PersonFinacialFragment;
import com.zucc.circle.summerwork.Fragment.PersonPlanFragment;
import com.zucc.circle.summerwork.Fragment.PersonZoneFragment;

public class MainActivity extends AppCompatActivity {
    private BottomBar bottomBar;
    private BottomBarTab nearby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Object ob = null;
                switch (tabId) {
                    case R.id.tab_person_plan:
                        ob = new PersonPlanFragment();
                        break;
                    case R.id.tab_group_plan:
                        ob = new GroupPlanFragment();
                        break;
                    case R.id.tab_financial:
                        ob = new PersonFinacialFragment();
                        break;
                    case R.id.tab_person_zone:
                        ob = new PersonZoneFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,(Fragment) ob).commit();
            }
        });

    }
}
