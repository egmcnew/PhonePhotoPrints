package com.example.phonephotoprints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double btn1Cost = .19;
    double btn2Cost = .49;
    double btn3Cost = .79;
    int numEntered;
    double finalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_photo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText numberPrints = (EditText) findViewById(R.id.numPrints);
        final RadioButton radio1 = (RadioButton) findViewById(R.id.btn1);
        final RadioButton radio2 = (RadioButton) findViewById(R.id.btn2);
        final RadioButton radio3 = (RadioButton) findViewById(R.id.btn3);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener(){
            final TextView finalResult = ((TextView)findViewById(R.id.result));
            @Override
            public void onClick(View v) {
                numEntered = Integer.parseInt(numberPrints.getText().toString());
                DecimalFormat currency = new DecimalFormat("#.##");
                if (numEntered <= 50) {
                    if (radio1.isChecked()) {
                        finalCost = btn1Cost * numEntered;
                        finalResult.setText("The order cost is $" + currency.format(finalCost));
                    } else if (radio2.isChecked()) {
                        finalCost = btn2Cost * numEntered;
                        finalResult.setText("The order cost is $" + currency.format(finalCost));
                    } else {
                        finalCost = btn3Cost * numEntered;
                        finalResult.setText("The order cost is $" + currency.format(finalCost));
                    }
                }else{
                    finalResult.setText("Max order is 50");

                }
            }
        });




    }
}
