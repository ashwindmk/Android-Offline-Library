package com.example.ashwin.offlinelibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ashwin.offlinelibrary.models.Book;

import java.util.ArrayList;

/**
 * Created by ashwin on 8/8/17.
 */

public class BooksRecyclerAdapter extends RecyclerView.Adapter<BooksRecyclerAdapter.BookViewHolder> {

    private ArrayList<Book> mBooksList;

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;

        public BookViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.title);
        }
    }

    public BooksRecyclerAdapter(ArrayList<Book> booksList) {
        mBooksList = booksList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = mBooksList.get(position);
        holder.mTitle.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        return mBooksList.size();
    }
}
