package com.maning.myview;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Toast;

import com.maning.library.MClearEditText;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private MClearEditText mClearEditText;
    private MClearEditText et_password;
    private boolean isOpenEye = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mClearEditText = (MClearEditText) findViewById(R.id.mClearEditText);
        et_password = (MClearEditText) findViewById(R.id.et_password);

        mClearEditText.setOnClearClickListener(new MClearEditText.OnClearClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(mContext, "点击了清除按钮", Toast.LENGTH_SHORT).show();
            }
        });

        et_password.setOnClearClickListener(false, new MClearEditText.OnClearClickListener() {
            @Override
            public void onClick() {
                if (isOpenEye) {
                    et_password.setRightDrawable(getResources().getDrawable(R.drawable.icon_close_eye));
                    isOpenEye = false;
                    et_password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    et_password.setRightDrawable(getResources().getDrawable(R.drawable.icon_open_eye));
                    isOpenEye = true;
                    et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                et_password.setSelection(et_password.getText().toString().length());
            }
        });

    }
}
