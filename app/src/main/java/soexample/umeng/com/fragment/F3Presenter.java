package soexample.umeng.com.fragment;

import android.content.Context;

import soexample.umeng.com.R;
import soexample.umeng.com.mvp.view.AppDelegate;

public class F3Presenter extends AppDelegate {

    private Context context;

    @Override
    public int getLayoutId() {
        return R.layout.fragemnt_f3_layout;
    }



    @Override
    public void initData() {

    }

    @Override
    public void initContext(Context context) {
        this.context = context;
    }
}
