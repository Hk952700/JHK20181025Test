package soexample.umeng.com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import soexample.umeng.com.R;
import soexample.umeng.com.bean.ShoppingCartDataBean;
import soexample.umeng.com.listener.F2reListener;
import soexample.umeng.com.listener.F2reitemCheckListener;

public class F2REAdapter extends RecyclerView.Adapter<F2REAdapter.MyViewHolder> {


    private List<ShoppingCartDataBean.DataBean> list;
    private Context context;
    private F2REitemAdapter f2REitemAdapter;

    public F2reListener listener;

    public void setListener(F2reListener listener) {
        this.listener = listener;
    }

    public F2REAdapter(List<ShoppingCartDataBean.DataBean> data1, Context context) {
        list = data1;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.f2_re_itme_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.f2_re_itme_re.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        f2REitemAdapter = new F2REitemAdapter(list.get(i).getList(), context);
        myViewHolder.f2_re_itme_re.setAdapter(f2REitemAdapter);
        f2REitemAdapter.setListener(new F2reitemCheckListener() {

            @Override
            public void jianumAndPrice(int num, double price) {
                listener.rejianumAndPrice(num, price);
            }

            @Override
            public void jiannumAndPrice(int num, double price) {
                listener.rejiannumAndPrice(num, price);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView f2_re_itme_re;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            f2_re_itme_re = itemView.findViewById(R.id.f2_re_itme_re);

        }
    }
}
