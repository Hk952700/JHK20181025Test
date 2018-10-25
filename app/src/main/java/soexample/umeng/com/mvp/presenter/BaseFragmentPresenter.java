package soexample.umeng.com.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import soexample.umeng.com.mvp.view.AppDelegate;

public abstract class BaseFragmentPresenter<T extends AppDelegate> extends Fragment {

    T delegate;
    public abstract Class<T> getClassDelegate();

    public BaseFragmentPresenter() {
        try {
            delegate=getClassDelegate().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        delegate.create(inflater,container,savedInstanceState);

        return delegate.getLayutview();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        delegate.initContext(getActivity());
        delegate.initData();
    }



}
