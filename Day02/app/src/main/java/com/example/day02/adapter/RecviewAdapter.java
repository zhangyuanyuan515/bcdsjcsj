package com.example.day02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day02.R;
import com.example.day02.bean.Bean;
import com.example.day02.bean.Bean_Two;

import java.util.ArrayList;

public class RecviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Bean_Two.ResultBean.DataBean> list;

    public RecviewAdapter(Context context, ArrayList<Bean_Two.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View view=View.inflate(context,R.layout.recview_item1,null);
             ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        } if (i==1){
            View view=View.inflate(context,R.layout.recview_item2,null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        } if (i==2){
            View view=View.inflate(context,R.layout.recview_item3,null);
            ViewHolder3 holder3 = new ViewHolder3(view);
            return holder3;
        }else {
            View view=View.inflate(context,R.layout.recview_item4,null);
            ViewHolder4 holder4 = new ViewHolder4(view);
            return holder4;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
         int viewType = getItemViewType(i);
        if (viewType==0){
            ViewHolder1 viewHolder1= (ViewHolder1) viewHolder;
            Glide.with(context).load(list.get(i).getThumbnail_pic_s()).into(viewHolder1.im);
        }else if (viewType==1){
            ViewHolder2 viewHolder2= (ViewHolder2) viewHolder;
            viewHolder2.tv.setText(list.get(i).getAuthor_name());
            viewHolder2.tv1.setText(list.get(i).getCategory());
            Glide.with(context).load(list.get(i).getThumbnail_pic_s02()).into(viewHolder2.im2);
            Glide.with(context).load(list.get(i).getThumbnail_pic_s03()).into(viewHolder2.im3);
        }else if (viewType==2){
            ViewHolder3 viewHolder3= (ViewHolder3) viewHolder;
            viewHolder3.tv2.setText(list.get(i).getCategory());
            Glide.with(context).load(list.get(i).getThumbnail_pic_s03()).into(viewHolder3.im4);
        }else {
            ViewHolder4 viewHolder4= (ViewHolder4) viewHolder;
            viewHolder4.tv3.setText(list.get(i).getCategory());
            Glide.with(context).load(list.get(i).getThumbnail_pic_s03()).into(viewHolder4.im5);
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
        if (position%4==0){
            return 0;
        }else if (position%4==3){
            return 1;
        }else if (position%4==1){
            return 2;
        }else {
            return 3;
        }
    }

    class  ViewHolder1 extends RecyclerView.ViewHolder{

        private ImageView im;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.im);
        }
    }
    class  ViewHolder2 extends RecyclerView.ViewHolder{

        private ImageView im2;
        private ImageView im3;
        private TextView tv;
        private TextView tv1;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            im2 = itemView.findViewById(R.id.im2);
            im3 = itemView.findViewById(R.id.im3);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }
    class  ViewHolder3 extends RecyclerView.ViewHolder{

        private ImageView im4;
        private TextView tv2;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            im4 = itemView.findViewById(R.id.im4);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
    class  ViewHolder4 extends RecyclerView.ViewHolder{
        private ImageView im5;
        private TextView tv3;

        public ViewHolder4(@NonNull View itemView) {
            super(itemView);
            im5 = itemView.findViewById(R.id.im5);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
    private onclick click;

    public void setClick(onclick click) {
        this.click = click;
    }
    public interface  onclick{
        void onclick(View view,int i);

    }
}
