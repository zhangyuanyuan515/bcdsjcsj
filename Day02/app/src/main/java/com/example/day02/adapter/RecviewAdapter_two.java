package com.example.day02.adapter;

import android.content.Context;
import android.content.Intent;
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

public class RecviewAdapter_two extends RecyclerView.Adapter<RecviewAdapter_two.ViewHolder> {
    private Context context;
    ArrayList<Bean_Two.ResultBean.DataBean> list;

    public RecviewAdapter_two(Context context, ArrayList<Bean_Two.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecviewAdapter_two.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.recvire_item5,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecviewAdapter_two.ViewHolder viewHolder, final int i) {
        Glide.with(context).load(list.get(i).getThumbnail_pic_s03()).circleCrop().into(viewHolder.im);
        Glide.with(context).load(list.get(i).getThumbnail_pic_s()).into(viewHolder.im1);
        viewHolder.tv.setText(list.get(i).getCategory());
        viewHolder.tv1.setText(list.get(i).getAuthor_name());

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

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView im;
        private ImageView im1;
        private TextView tv;
        private TextView tv1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.imm);
            im1 = itemView.findViewById(R.id.imm1);
            tv = itemView.findViewById(R.id.tvv);
            tv1 = itemView.findViewById(R.id.tvv1);
        }
    }
    private RecviewAdapter.onclick click;

    public void setClick(RecviewAdapter.onclick click) {
        this.click = click;
    }
    public interface  onclick{
        void onclick(View view,int i);

    }
}
