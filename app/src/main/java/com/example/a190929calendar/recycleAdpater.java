package com.example.a190929calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recycleAdpater extends RecyclerView.Adapter<recycleAdpater.ViewHolder> {

    private List<item> mlist;


    public recycleAdpater(List<item> list) {
        this.mlist = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    item item = mlist.get(position);
    holder.dayText.setText(item.getDay());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView dayText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dayText = itemView.findViewById(R.id.dayText);
        }
    }
}
