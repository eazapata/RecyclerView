package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    ArrayList<String> mWordList;
    LayoutInflater minflater;


    public WordListAdapter(Context context, ArrayList<String> wordList) {
        minflater = LayoutInflater.from(context);
        this.mWordList = wordList;

    }


    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = minflater.inflate(R.layout.item,parent,false);
        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView wordItemView;
        WordListAdapter mAdapter;
        public WordViewHolder(@NonNull View itemView, WordListAdapter wordListAdapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            this.mAdapter = wordListAdapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            wordItemView.setText ("Clicked! "+ wordItemView.getText());
            mWordList.set(getLayoutPosition(), (String) wordItemView.getText());
        }
    }
}
