package soexample.umeng.com.fragment;

import soexample.umeng.com.mvp.presenter.BaseFragmentPresenter;

public class F3 extends BaseFragmentPresenter<F3Presenter> {
    @Override
    public Class<F3Presenter> getClassDelegate() {
        return F3Presenter.class;
    }
}
