package com.example.tutorial_bt_findbt;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 0;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getView();
        setEvent();
        FunBTInit();

    }

    public void getView(){

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

    }

    public void setEvent(){

        button.setOnClickListener(bluetoothOnClickListener);

    }

    private View.OnClickListener bluetoothOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            FunBTRegisterTheBroadcastReceiver();

        }
    };

    //初始化藍芽設定: 檢查藍芽是否已打開
    private BluetoothAdapter bluetoothAdapter;
    private void FunBTInit(){

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter == null){
            // Device doesn't support Bluetooth
            Toast.makeText(getApplicationContext(), R.string.null_BT, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!bluetoothAdapter.isEnabled()){
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBTIntent, REQUEST_ENABLE_BT);
            Toast.makeText(getApplicationContext(), "開啟成功", Toast.LENGTH_SHORT).show();
        } else {
            //搜尋藍芽設備
            Toast.makeText(getApplicationContext(), "藍芽已開啟", Toast.LENGTH_SHORT).show();
        }

    }

    private void FunBTRegisterTheBroadcastReceiver(){

    }

}
