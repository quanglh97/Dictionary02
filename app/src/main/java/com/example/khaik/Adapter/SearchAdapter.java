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
import com.example.khaik.Model.Word;
import com.example.khaik.ResoultActivity;
import com.example.khaik.hihi21042018.R;


import java.util.ArrayList;


public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> implements Filterable{
    private Context context;
    private    ArrayList<Word> word;
    private  ArrayList<Word> tempWord;
    //private    ArrayList<Friend> friend;
    //private  ArrayList<Friend> tempFriend;
    public static ArrayList<Word> afterFilter;
    private CustomFilter csFilter;

//    public SearchAdapter(Context context, ArrayList<Friend> friend) {
//        this.context = context;
//        this.friend = friend;
//        this.tempFriend = friend;
//    }
    public SearchAdapter(Context context, ArrayList<Word> word) {
        this.context = context;
        this.word = word;
        this.tempWord = word;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item, parent, false);

        return new SearchViewHolder(itemView, context, tempWord);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.WORD.setText(word.get(position).getmWord());
        holder.MEAN.setText(word.get(position).getmMean());
    }

    @Override
    public int getItemCount() {
        return word.size();
    }

    @Override
    public Filter getFilter() {
        if (csFilter == null)
        {
            csFilter = new CustomFilter();
        }

        return csFilter;
    }

    class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0)
            {
                constraint = constraint.toString().toUpperCase();
                ArrayList<Word> filters = new ArrayList<>();
                for (int i = 0; i < tempWord.size(); i++) {
                    if (tempWord.get(i).getmWord().toUpperCase().contains(constraint)) {
                        Word word = new Word(tempWord.get(i).getmWord(),tempWord.get(i).getmMean());
                        filters.add(word);
                    }
                }

                results.count = filters.size();
                results.values = filters;
            }else {
                results.count = tempWord.size();
                results.values = tempWord;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            word = (ArrayList<Word>)results.values;
            afterFilter = word;
            notifyDataSetChanged();
        }
    }
}

class SearchViewHolder extends ViewHolder implements View.OnClickListener, View.OnLongClickListener{
    private Context context;
    public TextView WORD;
    public TextView MEAN;
    private ArrayList<Word> listWord ;

    public SearchViewHolder(View itemView, Context context, ArrayList<Word> listWord) {
        super(itemView);
        WORD  = (TextView) itemView.findViewById(R.id.tv_WORD);
        MEAN = (TextView) itemView.findViewById(R.id.tv_MEAN);
        this.listWord = listWord;

        this.context = context;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        Word word = SearchAdapter.afterFilter.get(position);
        Intent intent = new Intent(context, ResoultActivity.class);
        intent.putExtra("chose", word);
        this.context.startActivity(intent);

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
