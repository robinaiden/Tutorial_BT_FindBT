package com.example.tutorial_bt_findbt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getView();
        setEvent();

    }

    public void getView(){

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

    }

    public void setEvent(){

        button.setOnClickListener(this);

    }

}
