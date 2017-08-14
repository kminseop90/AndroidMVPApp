package com.example.owner.mvpsampleapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.owner.mvpsampleapp.adapter.holder.BaseViewHolder;
import com.example.owner.mvpsampleapp.adapter.holder.UserHorizontalViewHolder;
import com.example.owner.mvpsampleapp.adapter.holder.UserVerticalViewHolder;
import com.example.owner.mvpsampleapp.model.vo.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private ArrayList<User> users = new ArrayList<>();
    public static final int VIEW_TYPE_VERTICAL = 0;
    public static final int VIEW_TYPE_HORIZENTAL = 1;
    public static final int VIEW_COUNT = 2;

    public void setUser(ArrayList<User> users) {
        this.users.clear();
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_VERTICAL) {
            return UserVerticalViewHolder.newInstance(parent);
        } else {
            return UserHorizontalViewHolder.newInstance(parent);
        }

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBindView(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0) {
            return VIEW_TYPE_VERTICAL;
        } else {
            return VIEW_TYPE_HORIZENTAL;
        }
    }
}
