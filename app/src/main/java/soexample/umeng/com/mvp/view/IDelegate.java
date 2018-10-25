package soexample.umeng.com.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface IDelegate {
    void initData();
    void initContext(Context context);
    View getLayutview();
    void create(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle);
}
