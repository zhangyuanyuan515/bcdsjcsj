package com.example.zuoye2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zuoye2.R;
import com.example.zuoye2.bean.Bean;
import com.example.zuoye2.bean.Bean_Two;

import java.util.ArrayList;

public class RecviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private  ArrayList<Bean_Two.ResultBean.DataBean> list;

    public RecviewAdapter(Context context, ArrayList<Bean_Two.ResultBean.DataBean> list) {
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
        }if (i==1){
            View view=View.inflate(context,R.layout.recview_item2,null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        }else {
            View view=View.inflate(context,R.layout.recview_item3,null);
            ViewHolder3 holder3 = new ViewHolder3(view);
            return holder3;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
         int viewType = getItemViewType(i);
         if (viewType==0){
             ViewHolder1 holder1= (ViewHolder1) viewHolder;
             holder1.tv1.setText(list.get(i).getAuthor_name());
             holder1.tv2.setText(list.get(i).getCategory());
             Glide.with(context).load(list.get(i).getThumbnail_pic_s()).into(holder1.im1);
         }else if (viewType==1){
             ViewHolder2 holder2= (ViewHolder2) viewHolder;
             holder2.t2.setText(list.get(i).getCategory());
             Glide.with(context).load(list.get(i).getThumbnail_pic_s02()).into(holder2.im2);
         }else {
             ViewHolder3 holder3= (ViewHolder3) viewHolder;
             holder3.tv3.setText(list.get(i).getCategory());
             holder3.tv4.setText(list.get(i).getAuthor_name());
             Glide.with(context).load(list.get(i).getThumbnail_pic_s02()).into(holder3.im3);
             Glide.with(context).load(list.get(i).getThumbnail_pic_s()).into(holder3.im4);
         }

         viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 click.onclick(view,i);
             }
         });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%3==0){
            return 0;
        }else if (position%3==1){
            return 1;
        }else {
            return 2;
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

        private ImageView im2;
        private TextView t2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            im2 = itemView.findViewById(R.id.im2);
            t2 = itemView.findViewById(R.id.tv2);
        }

    }
    class ViewHolder3 extends RecyclerView.ViewHolder{

        private  ImageView im3;
        private  ImageView im4;
        private TextView tv3;
        private TextView tv4;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            im3 = itemView.findViewById(R.id.im3);
            im4 = itemView.findViewById(R.id.imm3);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tvv3);
        }
    }
    public  onclick click;

    public void setClick(onclick click) {
        this.click = click;
    }
    public interface  onclick{
        void onclick(View view,int i);
    }
}
