package com.commit451.okyo.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.commit451.okyo.Okyo;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File(getCacheDir(), "hi.txt");
        try {
            file.createNewFile();
            Okyo.writeStringToFile("hi", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
