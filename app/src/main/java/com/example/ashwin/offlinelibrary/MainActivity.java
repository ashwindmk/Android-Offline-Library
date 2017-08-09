package com.example.ashwin.offlinelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ashwin.offlinelibrary.models.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Book> mBooksList = new ArrayList<>();

    private BooksRecyclerAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLibrary();

        initViews();
    }

    private void initLibrary() {
        Book book = new Book("The Maze Runner", "maze_runner.txt");
        mBooksList.add(book);

        book = new Book("Game Of Thrones", "game_of_thrones.txt");
        mBooksList.add(book);

        book = new Book("Death Cure", "death_cure.txt");
        mBooksList.add(book);

        book = new Book("Escape Plan", "escape_plan.txt");
        mBooksList.add(book);
    }

    private void initViews() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new BooksRecyclerAdapter(mBooksList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Book book = mBooksList.get(position);
                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                intent.putExtra("filename", book.getFilename());
                intent.putExtra("title", book.getTitle());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                // Do nothing
            }
        }));
    }
}
