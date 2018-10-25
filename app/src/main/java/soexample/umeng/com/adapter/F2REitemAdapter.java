package soexample.umeng.com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import soexample.umeng.com.R;
import soexample.umeng.com.bean.ShoppingCartDataBean;
import soexample.umeng.com.listener.F2reitemCheckListener;

public class F2REitemAdapter extends RecyclerView.Adapter<F2REitemAdapter.MyViewHolder2>{

    private List<ShoppingCartDataBean.DataBean.ListBean> list;
    private Context context;

    public F2reitemCheckListener listener;

    public void setListener(F2reitemCheckListener listener) {
        this.listener = listener;
    }

    public F2REitemAdapter(List<ShoppingCartDataBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.f2_re_itme_itme_layout, null);
        return new MyViewHolder2(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder2 myViewHolder2, final int i) {

         //图片
        String images = list.get(i).getImages();
        String replace = images.replace("https", "http");
        String[] split = replace.split("\\|");
        Glide.with(context).load(split[0]).into(myViewHolder2.itme_itme_img);


        //title
        myViewHolder2.itme_itme_title.setText(list.get(i).getTitle());

        //单价
        myViewHolder2.itme_itme_yuan.setText(String.valueOf(list.get(i).getPrice()));

        //数量
        myViewHolder2.itme_itme_sum.setText(String.valueOf(list.get(i).getNum()));

        //是否选择
        if(list.get(i).getSelected()==0){
            myViewHolder2.itme_itme_che.setChecked(false);
        }else{
            myViewHolder2.itme_itme_che.setChecked(true);
        }



        //选择
        myViewHolder2.itme_itme_che.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    notifyDataSetChanged();
                    list.get(i).setSelected(1);
                    listener.jianumAndPrice( list.get(i).getNum(),list.get(i).getPrice());
                }else{
                    notifyDataSetChanged();
                    list.get(i).setSelected(0);
                    listener.jiannumAndPrice(list.get(i).getNum(),list.get(i).getPrice());
                }

            }
        });




        //点击加减
        myViewHolder2.itme_itme_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(i).setNum(list.get(i).getNum()+1);
                notifyDataSetChanged();

                if(myViewHolder2.itme_itme_che.isChecked()){
                    list.get(i).setSelected(1);
                    listener.jianumAndPrice( list.get(i).getNum(),list.get(i).getPrice());
                }


            }
        });
        myViewHolder2.itme_itme_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(i).getNum()>0){
                    list.get(i).setNum(list.get(i).getNum()-1);
                    notifyDataSetChanged();
                    if(myViewHolder2.itme_itme_che.isChecked()){
                        list.get(i).setSelected(1);
                        listener.jiannumAndPrice( list.get(i).getNum(),list.get(i).getPrice());
                    }
                }
            }
        });








    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder2 extends RecyclerView.ViewHolder {

        private CheckBox itme_itme_che;
        private ImageView itme_itme_img;
        private ImageView itme_itme_jia;
        private TextView itme_itme_sum;
        private ImageView itme_itme_jian;
        private TextView itme_itme_yuan;
        private TextView itme_itme_title;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            itme_itme_che = itemView.findViewById(R.id.itme_itme_che);
            itme_itme_img = itemView.findViewById(R.id.itme_itme_img);
            itme_itme_jia = itemView.findViewById(R.id.itme_itme_jia);
            itme_itme_sum = itemView.findViewById(R.id.itme_itme_sum);
            itme_itme_jian = itemView.findViewById(R.id.itme_itme_jian);
            itme_itme_yuan = itemView.findViewById(R.id.itme_itme_yuan);
            itme_itme_title = itemView.findViewById(R.id.itme_itme_title);

        }
    }
}
