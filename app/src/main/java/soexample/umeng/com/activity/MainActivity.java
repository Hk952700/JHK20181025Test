package soexample.umeng.com.activity;

import soexample.umeng.com.mvp.presenter.BaseActivityPresenter;

public class MainActivity extends BaseActivityPresenter<MainActivityPresenter> {


    @Override
    public Class<MainActivityPresenter> getClassDelegate() {
        return MainActivityPresenter.class;
    }
}
