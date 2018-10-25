package soexample.umeng.com.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;

import soexample.umeng.com.R;
import soexample.umeng.com.adapter.MainTabAdapter;
import soexample.umeng.com.fragment.F1;
import soexample.umeng.com.fragment.F2;
import soexample.umeng.com.fragment.F3;
import soexample.umeng.com.fragment.F4;
import soexample.umeng.com.mvp.view.AppDelegate;

public class MainActivityPresenter extends AppDelegate {

    private Context context;
    private View layutview;
    private TabLayout main_tablayout;
    private ViewPager main_viewpager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        layutview = getLayutview();
        main_tablayout = layutview.findViewById(R.id.main_tablayout);
        main_viewpager = layutview.findViewById(R.id.main_viewpager);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("F1");
        strings.add("F2");
        strings.add("F3");
        strings.add("F4");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new F1());
        fragments.add(new F2());
        fragments.add(new F3());
        fragments.add(new F4());
        MainTabAdapter mainTabAdapter = new MainTabAdapter(((MainActivity) context).getSupportFragmentManager(), fragments, strings);
        main_viewpager.setAdapter(mainTabAdapter);
        main_tablayout.setupWithViewPager(main_viewpager);






    }

    @Override
    public void initContext(Context context) {
        this.context =context;
    }
}
