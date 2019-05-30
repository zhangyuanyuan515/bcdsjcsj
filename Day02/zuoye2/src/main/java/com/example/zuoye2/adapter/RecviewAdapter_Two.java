package com.example.zuoye2.adapter;

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
import com.example.zuoye2.R;
import com.example.zuoye2.bean.Bean_Two;

import java.util.ArrayList;

public class RecviewAdapter_Two extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Bean_Two.ResultBean.DataBean> list;

    public RecviewAdapter_Two(Context context, ArrayList<Bean_Two.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View view=View.inflate(context,R.layout.recview_item,null);
             ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        }else {
            View view=View.inflate(context,R.layout.recview_item1,null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
         int viewType = getItemViewType(i);
        if (viewType==0){
            ViewHolder1 holder1= (ViewHolder1) viewHolder;
            holder1.tv1.setText(list.get(i).getAuthor_name());
            holder1.tv2.setText(list.get(i).getCategory());
            Glide.with(context).load(list.get(i).getThumbnail_pic_s()).into(holder1.im1);
        }else {
            ViewHolder2 holder2= (ViewHolder2) viewHolder;
            holder2.tv11.setText(list.get(i).getAuthor_name());
            holder2.tv22.setText(list.get(i).getCategory());
            Glide.with(context).load(list.get(i).getThumbnail_pic_s()).into(holder2.im11);
            holder2.ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    click.onclick(viewHolder.itemView,list.get(i));
                }
            });
            holder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    item.onitemm(view,i);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else {
            return 1;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder{

        private ImageView im1;
        private TextView tv1;
        private TextView tv2;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            im1 = itemView.findViewById(R.id.im1);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.ttv1);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{

        private ImageView im11;
        private TextView tv11;
        private TextView tv22;
        private CheckBox ch;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            im11 = itemView.findViewById(R.id.reim1);
            tv11 = itemView.findViewById(R.id.retv1);
            tv22 = itemView.findViewById(R.id.retv2);
            ch = itemView.findViewById(R.id.ch);
        }

    }
    public onclick click;

    public void setClick(onclick click) {
        this.click = click;
    }
    public interface  onclick{
        void onclick(View view,Bean_Two.ResultBean.DataBean bean);
    }

    public onitemm item;

    public void setItem(onitemm item) {
        this.item = item;
    }
    public interface  onitemm{
        void onitemm(View view,int i);
    }
}
