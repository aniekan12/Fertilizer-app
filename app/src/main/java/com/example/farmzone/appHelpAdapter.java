package com.example.farmzone;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class appHelpAdapter extends RecyclerView.Adapter<appHelpAdapter.AppViewHolder> implements Filterable {

    Context mContext;
    List<AppHelpItem> mData;
    List<AppHelpItem> mDataFiltered;
    boolean isDark = false;

    public appHelpAdapter(Context mContext, List<AppHelpItem> mData, boolean isDark) {
        this.mContext = mContext;
        this.mData = mData;
        this.isDark = isDark;
        this.mDataFiltered  = mData;
    }

    public appHelpAdapter (Context mContext, List<AppHelpItem> mData)
    {
        this.mContext = mContext;
        this.mData = mData;
        this.mDataFiltered  = mData;
    }


    @NonNull
    @Override
    public appHelpAdapter.AppViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_news,viewGroup,false);

        return new AppViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull appHelpAdapter.AppViewHolder holder, int position) {


        //apply animation to views here
        //first we create animation for farm photo

        holder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));

        //create animation for the whole card
        //first create a reference to it

        holder.containers.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));


        //bind data here
        holder.tv_title.setText(mDataFiltered.get(position).getTItle());
        holder.tv_content.setText(mDataFiltered.get(position).getContent());
        holder.tv_date.setText(mDataFiltered.get(position).getDate());
        holder.img_user.setImageResource(mDataFiltered.get(position).getFarmPhoto());
    }

    @Override
    public int getItemCount() {
        return mDataFiltered.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String key = constraint.toString();
                if (key.isEmpty()) {

                    mDataFiltered = mData;
                }
                else{
                    List<AppHelpItem> lstFiltered = new ArrayList<>();
                    for (AppHelpItem row : mData) {

                        if (row.getTItle().toLowerCase().contains(key)) {
                            lstFiltered.add(row);
                        }
                    }

                    mDataFiltered = lstFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mDataFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mDataFiltered = (List<AppHelpItem>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public class AppViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_title,tv_content, tv_date;
        ImageView img_user;
        RelativeLayout containers;

        public AppViewHolder(@NonNull View itemView)
        {
            super(itemView);

            containers = itemView.findViewById(R.id.relativeLayout);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_description);
            tv_date = itemView.findViewById(R.id.tv_date);

            img_user = itemView.findViewById(R.id.img_farm);

            if (isDark) {
                setDarkTheme();
            }
        }

        private void setDarkTheme(){
            containers.setBackgroundResource(R.drawable.card_bg_dark);
        }

    }

}
