package com.maning.myview;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.maning.library.MClearEditText;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private MClearEditText mClearEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;


        mClearEditText = (MClearEditText) findViewById(R.id.mClearEditText);

        mClearEditText.setOnClearClickListener(new MClearEditText.OnClearClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(mContext, "点击了清除按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
