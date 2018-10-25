package soexample.umeng.com.fragment;

import soexample.umeng.com.mvp.presenter.BaseFragmentPresenter;

public class F2 extends BaseFragmentPresenter<F2Presenter> {
    @Override
    public Class<F2Presenter> getClassDelegate() {
        return F2Presenter.class;
    }
}
