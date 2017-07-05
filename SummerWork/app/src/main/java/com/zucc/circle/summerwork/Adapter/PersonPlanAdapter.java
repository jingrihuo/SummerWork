package com.zucc.circle.summerwork.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zucc.circle.summerwork.Entity.PersonPlanEntity;
import com.zucc.circle.summerwork.R;

import java.util.List;

/**
 * Created by 圆圈 on 2017-07-05.
 */

public class PersonPlanAdapter extends ArrayAdapter<PersonPlanEntity> {
    private int resource;
    public PersonPlanAdapter(Context context, int resource, List<PersonPlanEntity> personplans) {
        super(context, resource,personplans);
        this.resource = resource;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonPlanEntity personplan = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource,null);
        TextView person_plan_title = (TextView)view.findViewById(R.id.person_plan_title);
        TextView person_plan_time_start = (TextView)view.findViewById(R.id.person_plan_time_start);
        TextView person_plan_time_end = (TextView)view.findViewById(R.id.person_plan_time_end);
        person_plan_title.setText(personplan.getTitle());
        person_plan_time_start.setText(personplan.getStart_time());
        person_plan_time_end.setText(personplan.getEnd_time());
        return view;
    }
}
