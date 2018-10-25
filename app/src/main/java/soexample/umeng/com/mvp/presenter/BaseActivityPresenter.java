package soexample.umeng.com.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import soexample.umeng.com.mvp.view.AppDelegate;

public abstract class BaseActivityPresenter<T extends AppDelegate> extends AppCompatActivity {

    T delegate;
    public abstract Class<T> getClassDelegate();

    public BaseActivityPresenter() {
        try {
            delegate= getClassDelegate().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // asdasdas 自分支阿斯达大a

        delegate.create(getLayoutInflater(),null,savedInstanceState);
        setContentView(delegate.getLayutview());
        delegate.initContext(this);
        delegate.initData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        delegate.destroy();
        delegate=null;

    }
}
