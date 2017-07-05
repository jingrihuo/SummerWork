package com.zucc.circle.summerwork.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.zucc.circle.summerwork.Activity.AddPersonPlanActivity;
import com.zucc.circle.summerwork.Adapter.PersonPlanAdapter;
import com.zucc.circle.summerwork.Entity.PersonPlanEntity;
import com.zucc.circle.summerwork.R;
import com.zucc.circle.summerwork.View.ScrollListviewDelete;

import java.util.ArrayList;
import java.util.List;

import it.neokree.materialtabs.MaterialTabHost;

public class PersonPlanFragment extends Fragment implements View.OnClickListener{
    FloatingActionButton fab_add_person_plan;
    ScrollListviewDelete lv_person_plan;
    PersonPlanAdapter adapter;
    List<PersonPlanEntity> personPlans;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_person_plan, container, false);
        fab_add_person_plan = (FloatingActionButton) view.findViewById(R.id.action_add_person_plan);
        fab_add_person_plan.setOnClickListener(this);
        lv_person_plan = (ScrollListviewDelete) view.findViewById(R.id.lv_person_plan);
        personPlans = new ArrayList<>();
        personPlans.add(new PersonPlanEntity("我要吃饭", "2016/7/29/16:00", "2016/7/29/16:00"));
        personPlans.add(new PersonPlanEntity("我要吃饭", "2016/7/29/16:00", "2016/7/29/16:00"));
        personPlans.add(new PersonPlanEntity("我要吃饭", "2016/7/29/16:00", "2016/7/29/16:00"));
        personPlans.add(new PersonPlanEntity("我要吃饭", "2016/7/29/16:00", "2016/7/29/16:00"));
        personPlans.add(new PersonPlanEntity("我要吃饭", "2016/7/29/16:00", "2016/7/29/16:00"));
        adapter = new PersonPlanAdapter(view.getContext(),R.layout.item_person_plan,personPlans);
        lv_person_plan.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.action_add_person_plan:
                Intent intent = new Intent();
                intent.setClass(view.getContext(), AddPersonPlanActivity.class);
                view.getContext().startActivity(intent);

        }
    }
}
