package soexample.umeng.com.fragment;

import soexample.umeng.com.mvp.presenter.BaseFragmentPresenter;

public class F4 extends BaseFragmentPresenter<F4Presenter> {
    @Override
    public Class<F4Presenter> getClassDelegate() {
        return F4Presenter.class;
    }
}
