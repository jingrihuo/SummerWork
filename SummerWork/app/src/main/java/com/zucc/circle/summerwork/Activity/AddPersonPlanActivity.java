package com.zucc.circle.summerwork.Activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.rey.material.widget.Button;
import com.rey.material.widget.Switch;
import com.zucc.circle.summerwork.R;
import com.zucc.circle.summerwork.Util.AlarmUtils;

public class AddPersonPlanActivity extends Activity implements View.OnClickListener{
    private Switch switch_person_time;
    private LinearLayout ll_person_time_set;
    private RelativeLayout rl_person_plan_start_date,rl_calendarview,rl_person_plan_start_time,rl_timeview;
    private MaterialCalendarView calendarView;
    private TimePicker timePicker;
    private TextView tv_person_plan_start_date,tv_person_plan_start_time,btn_check_person_plan;
    private Button btn_check_date,btn_check_time;
    private int month,day,hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person_plan);
        switch_person_time = (Switch) findViewById(R.id.switch_person_time);
        ll_person_time_set = (LinearLayout) findViewById(R.id.ll_person_time_set);
        calendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        rl_person_plan_start_date = (RelativeLayout) findViewById(R.id.rl_person_plan_start_date);
        rl_calendarview = (RelativeLayout) findViewById(R.id.rl_calendarview);
        rl_person_plan_start_time = (RelativeLayout) findViewById(R.id.rl_person_plan_start_time);
        rl_timeview = (RelativeLayout) findViewById(R.id.rl_timeview);
        tv_person_plan_start_date = (TextView) findViewById(R.id.cur_person_plan_start_date);
        tv_person_plan_start_time = (TextView) findViewById(R.id.tv_person_plan_start_time);
        btn_check_date = (Button) findViewById(R.id.btn_check_date);
        btn_check_time = (Button) findViewById(R.id.btn_check_time);
        btn_check_person_plan = (TextView) findViewById(R.id.btn_check_person_plan);
        switch_person_time.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(Switch view, boolean checked) {
                if(checked) {
                    ll_person_time_set.setVisibility(View.VISIBLE);
                }
                else {
                    ll_person_time_set.setVisibility(View.GONE);
                }
            }
        });
        rl_person_plan_start_date.setOnClickListener(this);
        rl_person_plan_start_time.setOnClickListener(this);
        btn_check_date.setOnClickListener(this);
        btn_check_time.setOnClickListener(this);
        btn_check_person_plan.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_person_plan_start_date:
                rl_calendarview.setVisibility(View.VISIBLE);
                break;
            case R.id.rl_person_plan_start_time:
                rl_timeview.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_check_date:
                CalendarDay cd = calendarView.getSelectedDate();
                String current_date = cd.getYear() + "/" + (cd.getMonth()+1) + "/" + cd.getDay();
                tv_person_plan_start_date.setText(current_date);
                rl_calendarview.setVisibility(View.GONE);
                month = cd.getMonth() + 1;
                day = cd.getDay();
                break;
            case R.id.btn_check_time:
                String current_time = timePicker.getHour() + "  时 " + timePicker.getMinute() + " 分";
                tv_person_plan_start_time.setText(current_time);
                rl_timeview.setVisibility(View.GONE);
                hour = timePicker.getHour();
                minute = timePicker.getMinute();
                break;
            case R.id.btn_check_person_plan:
                AlarmUtils.setAlarm(this,month,day,hour,minute,001,"提醒ssssss");
                break;
            default:
                break;
        }

    }

}
