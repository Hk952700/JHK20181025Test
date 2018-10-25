package soexample.umeng.com.fragment;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import soexample.umeng.com.R;
import soexample.umeng.com.bean.UserLoginBean;
import soexample.umeng.com.listener.OkHttpHelperListener;
import soexample.umeng.com.mvp.view.AppDelegate;
import soexample.umeng.com.net.OkHttpHelper;

public class F1Presenter extends AppDelegate implements View.OnClickListener {

    private Context context;
    private View layutview;
    private Button f1_btn_login;
    private EditText f1_edit_name;
    private EditText f1_edit_pwd;
    private EditText f1_edit_token;

    @Override
    public int getLayoutId() {
        return R.layout.fragemnt_f1_layout;
    }

    @Override
    public void initData() {
        layutview = getLayutview();
        f1_btn_login = layutview.findViewById(R.id.f1_btn_login);
        f1_edit_name = layutview.findViewById(R.id.f1_edit_name);
        f1_edit_pwd = layutview.findViewById(R.id.f1_edit_pwd);
        f1_edit_token = layutview.findViewById(R.id.f1_edit_token);

        f1_btn_login.setOnClickListener(this);

    }

    @Override
    public void initContext(Context context) {
        this.context =context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.f1_btn_login:

                String name = f1_edit_name.getText().toString();
                String pwd = f1_edit_pwd.getText().toString();

                new OkHttpHelper().get("http://www.zhaoapi.cn/user/login?mobile="+name+"&password="+pwd).setListener(new OkHttpHelperListener() {
                    @Override
                    public void succeed(String data) {
                        Gson gson = new Gson();
                        UserLoginBean userLoginBean = gson.fromJson(data, UserLoginBean.class);
                        String token = userLoginBean.getData().getToken();
                        int uid = userLoginBean.getData().getUid();
                        Log.i("aaaa", "succeed: "+data);

                        f1_edit_token.setText("token="+token+"   UID="+uid);
                    }

                    @Override
                    public void failure(String error) {
                        Log.i("aaaa", "failure: "+error);
                    }
                });



                break;
        }
    }
}
