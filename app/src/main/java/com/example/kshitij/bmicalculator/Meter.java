package com.example.kshitij.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Meter extends AppCompatActivity {

    private Button back, toMeter;
    private TextView meterResult;
    private EditText feet, inc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter);
        back=findViewById(R.id.back);
        toMeter=findViewById(R.id.toMeter);
        meterResult=findViewById(R.id.meterResult);
        feet=findViewById(R.id.feet);
        inc=findViewById(R.id.inc);



        toMeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Meter();

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Meter.this, detail.class);
                startActivity(intent);
                finish();
            }
        });



    }


    private void Meter(){
        double valueF=Double.parseDouble(feet.getText().toString());
        double valueI=Double.parseDouble(inc.getText().toString());
        double result1=valueF*0.305;
        double result2=valueI*2.54;
        double mainResult=result1+(result2/100);
        String rez=new Double(mainResult).toString();
        meterResult.setText(rez);


    }
}
