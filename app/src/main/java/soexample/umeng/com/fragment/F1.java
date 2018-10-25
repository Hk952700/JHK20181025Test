package soexample.umeng.com.fragment;

import soexample.umeng.com.mvp.presenter.BaseFragmentPresenter;

public class F1 extends BaseFragmentPresenter<F1Presenter> {
    @Override
    public Class<F1Presenter> getClassDelegate() {
        return F1Presenter.class;
    }
}
