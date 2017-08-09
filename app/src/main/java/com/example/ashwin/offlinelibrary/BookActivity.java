package com.example.ashwin.offlinelibrary;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BookActivity extends AppCompatActivity {

    private String mContent = "";
    private String mFilename = "";
    private String mTitle = "Library";

    private TextView mContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Bundle bundle = getIntent().getExtras();
        mFilename = bundle.getString("filename", "");
        mTitle = bundle.getString("title", "Library");

        initViews();
    }

    private void initViews() {
        initHeader();
        initTextView();
        initContent();
    }

    private void initHeader() {
        getSupportActionBar().setTitle(mTitle);
    }

    private void initTextView() {
        mContentTextView = (TextView) findViewById(R.id.content_textview);
    }

    private void initContent() {
        AssetManager assetManager = getResources().getAssets();
        try {
            StringBuilder buf = new StringBuilder();
            InputStream json = assetManager.open(mFilename);
            BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }

            in.close();

            mContent = buf.toString();
            mContentTextView.setText(mContent);
        } catch (Exception e) {
            e.printStackTrace();
            mContentTextView.setText("Error");
        }
    }
}
