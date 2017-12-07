package com.example.admin.multilayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.multilayout.R;
import com.example.admin.multilayout.model.TestModel;

import java.util.List;

/**
 * com.example.admin.multilayout
 *
 * @author Swg
 * @date 2017/12/7 11:16
 */
public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<TestModel> list;
    /**
     * 设定喜爱的栏目，默认为炉石传说
     */
    private static final String TAG_LOVE = "炉石传说";
    private static final int LOVE = 1;
    private static final int UN_LOVE = 0;

    public MyAdapter(Context context, List<TestModel> list) {
        this.context = context;
        this.list = list;
    }

    private class MyFirstViewHolder extends RecyclerView.ViewHolder {
        private ImageView firstIv;
        private TextView firstTv;

        private TextView getFirstTv() {
            return firstTv;
        }



        private ImageView getFirstIv() {

            return firstIv;
        }

        private MyFirstViewHolder(View itemView) {
            super(itemView);
            firstIv = itemView.findViewById(R.id.item_first_iv);
            firstTv = itemView.findViewById(R.id.item_first_tv);
        }
    }

    private class MySecondViewHolder extends RecyclerView.ViewHolder {
        private ImageView secondIv;
        private TextView secondTitle, secondContent;

        private ImageView getSecondIv() {
            return secondIv;
        }


        private TextView getSecondTitle() {
            return secondTitle;
        }


        private TextView getSecondContent() {
            return secondContent;
        }

        private MySecondViewHolder(View itemView) {
            super(itemView);
            secondContent = itemView.findViewById(R.id.item_second_content);
            secondIv = itemView.findViewById(R.id.item_second_iv);
            secondTitle = itemView.findViewById(R.id.item_second_title);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v;
        if (viewType == LOVE) {
            v = layoutInflater.inflate(R.layout.item_second, parent, false);
            return new MySecondViewHolder(v);
        } else {
            v = layoutInflater.inflate(R.layout.item_first, parent, false);
            return new MyFirstViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyFirstViewHolder) {
            ((MyFirstViewHolder) holder).getFirstTv().setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getImg()).into(((MyFirstViewHolder) holder).getFirstIv());
        } else {
            ((MySecondViewHolder) holder).getSecondTitle().setText(list.get(position).getTitle());
            ((MySecondViewHolder) holder).getSecondContent().setText(list.get(position).getContent());
            Glide.with(context).load(list.get(position).getImg()).into(((MySecondViewHolder) holder).getSecondIv());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTag().equals(TAG_LOVE)) {
            return LOVE;
        } else {
            return UN_LOVE;
        }
    }
}
