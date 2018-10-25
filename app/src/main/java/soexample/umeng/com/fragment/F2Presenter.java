package soexample.umeng.com.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import soexample.umeng.com.R;
import soexample.umeng.com.adapter.F2REAdapter;
import soexample.umeng.com.bean.ShoppingCartDataBean;
import soexample.umeng.com.listener.F2reListener;
import soexample.umeng.com.listener.OkHttpHelperListener;
import soexample.umeng.com.mvp.view.AppDelegate;
import soexample.umeng.com.net.OkHttpHelper;

public class F2Presenter extends AppDelegate implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private View layutview;
    private RecyclerView f2_re;
    private ImageView f2_img;
    private CheckBox f2_che;
    private TextView f2_text;
    private Button f2_btn;
    private EditText f2_edit;
    private Context context;
    private int ss;
    private double nn;
    @Override
    public int getLayoutId() {
        return R.layout.fragemnt_f2_layout;
    }

    @Override
    public void initData() {
        layutview = getLayutview();
        f2_re = layutview.findViewById(R.id.f2_re);
        f2_img = layutview.findViewById(R.id.f2_img);
        f2_che = layutview.findViewById(R.id.f2_che);
        f2_text = layutview.findViewById(R.id.f2_text);
        f2_btn = layutview.findViewById(R.id.f2_btn);
        f2_edit = layutview.findViewById(R.id.f2_edit);


        f2_img.setOnClickListener(this);
        f2_btn.setOnClickListener(this);

        f2_che.setOnCheckedChangeListener(this);


    }

    @Override
    public void initContext(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f2_img:
                String uid = f2_edit.getText().toString();
                new OkHttpHelper().get("http://www.zhaoapi.cn/product/getCarts?" + uid).setListener(new OkHttpHelperListener() {


                    private F2REAdapter f2REAdapter;

                    @Override
                    public void succeed(String data) {
                        Gson gson = new Gson();
                        ShoppingCartDataBean shoppingCartDataBean = gson.fromJson(data, ShoppingCartDataBean.class);
                        List<ShoppingCartDataBean.DataBean> data1 = shoppingCartDataBean.getData();
                        f2_re.setLayoutManager(new LinearLayoutManager(context));
                        f2REAdapter = new F2REAdapter(data1, context);
                        f2_re.setAdapter(f2REAdapter);


                        f2REAdapter.setListener(new F2reListener() {

                            @Override
                            public void rejiannumAndPrice(int num, double price) {

                                nn -= price;
                                ss -= num;
                                f2_btn.setText("去结算(" + ss + ")");
                                f2_text.setText("合计:" + ss * nn + "元");
                            }

                            @Override
                            public void rejianumAndPrice(int num, double price) {
                                double v1 = price * num;
                                f2_btn.setText("去结算(" + ss + ")");
                                f2_text.setText("合计:" + (ss * nn )+v1+ "元");
                            }


                        });

                    }

                    @Override
                    public void failure(String error) {

                    }
                });

                break;
            case R.id.f2_btn:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.f2_che:
                break;
        }
    }
}
