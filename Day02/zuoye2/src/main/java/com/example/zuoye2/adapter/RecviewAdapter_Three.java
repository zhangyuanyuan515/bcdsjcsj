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
import com.example.zuoye2.bean.Bean_Three;
import com.example.zuoye2.bean.Bean_Two;

import java.util.ArrayList;

public class RecviewAdapter_Three extends RecyclerView.Adapter<RecviewAdapter_Three.ViewHolder> {
    private Context context;
    private ArrayList<Bean_Three> list;

    public RecviewAdapter_Three(Context context, ArrayList<Bean_Three> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecviewAdapter_Three.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.recview_item,null);
         ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecviewAdapter_Three.ViewHolder viewHolder, int i) {
        viewHolder.tv1.setText(list.get(i).getAuthor_name());
        viewHolder.tv2.setText(list.get(i).getCategory());
        Glide.with(context).load(list.get(i).getThumbnail_pic_s02()).into(viewHolder.im1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView im1;
        private TextView tv1;
        private TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im1 = itemView.findViewById(R.id.im1);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.ttv1);
        }
    }

    public RecviewAdapter_Two.onclick click;

    public void setClick(RecviewAdapter_Two.onclick click) {
        this.click = click;
    }
    public interface  onclick{
        void onclick(View view,Bean_Three bean);
    }
}
