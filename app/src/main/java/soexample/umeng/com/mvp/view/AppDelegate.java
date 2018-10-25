package soexample.umeng.com.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AppDelegate implements IDelegate {

    private View view;


    @Override
    public View getLayutview() {
        return view;
    }

    @Override
    public void create(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        view = inflater.inflate(getLayoutId(), viewGroup, false);
    }

    public abstract int getLayoutId();


    public void destroy() {
        view = null;
    }

}
