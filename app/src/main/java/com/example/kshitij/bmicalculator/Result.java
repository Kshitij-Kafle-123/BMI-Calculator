package com.example.kshitij.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private Button again;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

          txt=findViewById(R.id.output);



        Bundle data = getIntent().getExtras();
        double finalValue = data.getDouble("result");
        String bmiResult = new Double(finalValue).toString();
        txt.setText(bmiResult);




        again = findViewById(R.id.again);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Result.this, detail.class);
                startActivity(i);
                finish();
            }
        });
    }
}
