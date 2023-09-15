package com.example.myfiletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("game", MODE_PRIVATE);
        editor = sp.edit();
    }
    public void test1(View view) {
        //取得初始資料
        String username = sp.getString("username","brad");
        boolean isSound = sp.getBoolean("sound",true);
        int stage = sp.getInt("stage",1);
        Log.v("brad",username + ":" + isSound + ":" + stage);
    }
    public void test2(View view) {
        //將資料寫入檔案
        //寫法一
//        editor.putString("username","ry_user");
//        editor.putBoolean("sound",false);
//        editor.putInt("stage",7);
//        editor.commit();    //執行寫入的動作
        //匿名寫法
        editor.putString("username","gameplay").putBoolean("sound",false).putInt("stage",7)
                        .commit();
        Toast.makeText(this, "Save OK", Toast.LENGTH_SHORT).show();
    }

    public void test3(View view) {
        try {
            FileOutputStream fout = openFileOutput("data.txt",MODE_PRIVATE);
            fout.write("Hello, RY".getBytes());
            fout.flush(); //資料抽取
            fout.close();
            Toast.makeText(this,"Save OK",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void test4(View view) {
    }
}

