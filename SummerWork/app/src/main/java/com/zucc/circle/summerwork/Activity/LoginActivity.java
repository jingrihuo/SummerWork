package com.zucc.circle.summerwork.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.zucc.circle.summerwork.Contants.ContantUri;
import com.zucc.circle.summerwork.MyApplication;
import com.zucc.circle.summerwork.R;
import com.zucc.circle.summerwork.Util.StringUtils;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends Activity implements View.OnClickListener {
    private TextView btn_login, btn_regist;
    private LinearLayout ll_login, ll_regist;
    private Button btn_login_app, btn_regist_app;
    private EditText et_login_phonenumber, et_login_password;
    private EditText et_regist_phonenumber, et_regist_username, et_regist_password, et_regist_check_password;
    private TextView tv_is_phone;
    private TextView tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = (TextView) findViewById(R.id.btn_login);
        btn_regist = (TextView) findViewById(R.id.btn_regist);
        btn_login_app = (Button) findViewById(R.id.btn_login_app);
        btn_regist_app = (Button) findViewById(R.id.btn_regist_app);
        ll_login = (LinearLayout) findViewById(R.id.ll_login);
        ll_regist = (LinearLayout) findViewById(R.id.ll_regist);
        et_login_phonenumber = (EditText) findViewById(R.id.et_login_phonenumber);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        et_regist_check_password = (EditText) findViewById(R.id.et_regist_check_password);
        et_regist_password = (EditText) findViewById(R.id.et_regist_password);
        et_regist_phonenumber = (EditText) findViewById(R.id.et_regist_phonenumber);
        et_regist_username = (EditText) findViewById(R.id.et_regist_username);
        tv_is_phone = (TextView) findViewById(R.id.is_phone);
        tv_test = (TextView) findViewById(R.id.test);
        btn_login.setOnClickListener(this);
        btn_regist.setOnClickListener(this);
        btn_login_app.setOnClickListener(this);
        btn_regist_app.setOnClickListener(this);
        et_regist_phonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str="^(0(10|2\\d|[3-9]\\d\\d)[- ]{0,3}\\d{7,8}|0?1[3584]\\d{9})$";
                Pattern p = Pattern.compile(str);
                Matcher m = p.matcher(editable.toString());
                if(!m.matches()) {
                    tv_is_phone.setVisibility(View.VISIBLE);
                }
                else {
                    tv_is_phone.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                switchLoginMenu();
                break;
            case R.id.btn_regist:
                switchRegistMenu();
                break;
            case R.id.btn_login_app:
                UserLogin();
                break;
            case R.id.btn_regist_app:
                UserRegist();
                break;
            default:
                break;
        }
    }
    //切换登录菜单
    private void switchLoginMenu(){
        btn_login.setBackgroundResource(R.drawable.textview_bg);
        btn_login.setTextColor(Color.parseColor("#ffffff"));
        btn_regist.setBackgroundResource(R.drawable.textview_white_bg);
        btn_regist.setTextColor(Color.parseColor("#0f68c5"));
        ll_regist.setVisibility(View.GONE);
        ll_login.setVisibility(View.VISIBLE);
    }

    //切换注册菜单
    private void switchRegistMenu(){
        btn_regist.setBackgroundResource(R.drawable.textview_bg);
        btn_regist.setTextColor(Color.parseColor("#ffffff"));
        btn_login.setBackgroundResource(R.drawable.textview_white_bg);
        btn_login.setTextColor(Color.parseColor("#0f68c5"));
        ll_regist.setVisibility(View.VISIBLE);
        ll_login.setVisibility(View.GONE);
    }

    //判断登录逻辑
    public void UserLogin() {
        String phonenumber = et_login_phonenumber.getText().toString().trim();
        String password = et_login_password.getText().toString().trim();
        if (null == phonenumber || StringUtils.isEmpty(phonenumber)){
            //手机号为空
            return;
        }
        if (null == password || StringUtils.isEmpty(password)){
            //密码为空
            return;
        }
        Login(phonenumber, password);
    }
    //判断注册逻辑
    public void UserRegist() {
        String phonenumber = et_regist_phonenumber.getText().toString().trim();
        String password = et_regist_password.getText().toString().trim();
        String check_password = et_regist_check_password.getText().toString().trim();
        String username = et_regist_username.getText().toString().trim();
        if (null == phonenumber || StringUtils.isEmpty(phonenumber)){
            //手机号为空
            return;
        }
        if (null == password || StringUtils.isEmpty(password)){
            //密码为空
            return;
        }
        if (null == check_password || StringUtils.isEmpty(check_password)){
            //再次密码为空
            return;
        }
        if (null == username || StringUtils.isEmpty(username)){
            //用户名为空
            return;
        }
        if(!password.equals(check_password)) {
            //两次密码输入不一样
            return;
        }
        Regist(phonenumber, username, password);
    }
    //向服务器发起登录请求
    public void Login(String phonenumber, String password) {
        //创建String请求；第一个参数是地址，第二个参数指定请求方法
        Request<String> request = NoHttp.createStringRequest(ContantUri.LOGIN_URL, RequestMethod.POST);
        request.add("username","123456");
        request.add("userpassword","1234567");
        //创建请求队列
        RequestQueue queue = MyApplication.getmRequestQueue();
        //请求回调
        OnResponseListener<String> callBack = new OnResponseListener<String>() {
            //这些方法都运行在主线程中，可以直接更新界面，同时也意味着不能做耗时操作
            @Override
            public void onStart(int what) {
                //发出请求时，开始执行的方法
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                //请求成功时执行的方法
                String json = response.get();
                tv_test.setText(json.toString());
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                //请求失败时执行的方法
            }

            @Override
            public void onFinish(int what) {
                //请求结束时执行的方法
            }
        };
        //将网络请求添加到请求队列中；第一个参数：请求的标识，标记是哪个请求；第二个参数：请求对象；第三个参数：回调对象
        queue.add(0, request, callBack);
    }
    //向服务器发起注册请求
    public void Regist(String phonenumber, String username, String password) {

    }
}
