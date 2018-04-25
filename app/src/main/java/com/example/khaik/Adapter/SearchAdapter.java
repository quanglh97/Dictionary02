package com.example.khaik.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.khaik.Model.Friend;
import com.example.khaik.ResoultActivity;
import com.example.khaik.hihi21042018.R;


import java.util.ArrayList;


public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> implements Filterable{
    private Context context;
    private    ArrayList<Friend> friend;
    private  ArrayList<Friend> tempFriend;
    public static ArrayList<Friend> afterFilter;
    private CustomFilter csFilter;

    public SearchAdapter(Context context, ArrayList<Friend> friend) {
        this.context = context;
        this.friend = friend;
        this.tempFriend = friend;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item, parent, false);

        return new SearchViewHolder(itemView, context, tempFriend);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.TENSV.setText(friend.get(position).getTENSV());
        holder.MASSV.setText(friend.get(position).getMSSV());
    }

    @Override
    public int getItemCount() {
        return friend.size();
    }

    @Override
    public Filter getFilter() {
        if (csFilter == null)
        {
            csFilter = new CustomFilter();
        }

        return csFilter;
    }

    class CustomFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0)
            {
                constraint = constraint.toString().toUpperCase();
                ArrayList<Friend> filters = new ArrayList<>();
                for (int i = 0; i < tempFriend.size(); i++) {
                    if (tempFriend.get(i).getMSSV().toUpperCase().contains(constraint)) {
                        Friend friend = new Friend(tempFriend.get(i).getMSSV(),tempFriend.get(i).getTENSV());
                        filters.add(friend);
                    }
                }

                results.count = filters.size();
                results.values = filters;
            }else {
                results.count = tempFriend.size();
                results.values = tempFriend;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            friend = (ArrayList<Friend>)results.values;
            afterFilter = friend;
            notifyDataSetChanged();
        }
    }
}

class SearchViewHolder extends ViewHolder implements View.OnClickListener, View.OnLongClickListener{
    private Context context;
    public TextView TENSV;
    public TextView MASSV;
    private ArrayList<Friend> listFriend;

    public SearchViewHolder(View itemView, Context context, ArrayList<Friend> listFriend) {
        super(itemView);
        TENSV = (TextView) itemView.findViewById(R.id.tv_TENSV);
        MASSV = (TextView) itemView.findViewById(R.id.tv_MSSV);
        this.listFriend = listFriend;

        this.context = context;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        Friend friend = SearchAdapter.afterFilter.get(position);
        Intent intent = new Intent(context, ResoultActivity.class);
        intent.putExtra("chose", friend);
        this.context.startActivity(intent);

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
