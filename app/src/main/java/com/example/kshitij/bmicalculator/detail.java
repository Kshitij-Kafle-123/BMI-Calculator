package com.example.kshitij.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class detail extends AppCompatActivity {

    private Button resultshow, meter;
    private EditText age, height, weight;

    double bmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        resultshow = findViewById(R.id.submit);
        meter=findViewById(R.id.meter);



      resultshow.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              calculateBmi();
          }
      });
      meter.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(detail.this, Meter.class);
              startActivity(intent);
              finish();
          }
      });


    }

    private void calculateBmi() {
        if (isNotFieldEmpty(weight) && isNotFieldEmpty(height)) {
            double w = Double.parseDouble(weight.getText().toString());
            double h = Double.parseDouble(height.getText().toString());
            bmi = w / (h * h);



            Intent intent = new Intent(detail.this, Result.class);
            Bundle data = new Bundle();
            data.putDouble("result", bmi);
            intent.putExtras(data);

            startActivity(intent);
        }
    }



    public Boolean isNotFieldEmpty(EditText view) {
        if (view.getText().toString().length() > 0) {
            return true;
        } else {
            view.setError("Field Required");
            return false;
        }
    }
}
