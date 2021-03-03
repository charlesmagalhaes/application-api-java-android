package com.example.myapplicationlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button estados;
    private Button regiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estados = (Button) findViewById(R.id.bntSelecionarRegiao);
        regiao = (Button) findViewById(R.id.btnSelecionarEstado);

        estados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StatesActivity.class);
                startActivity(intent);
            }
        });

        regiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityRegion.class);
                startActivity(intent);
            }
        });


    }
}
