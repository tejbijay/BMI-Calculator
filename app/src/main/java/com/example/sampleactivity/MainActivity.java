

package com.example.sampleactivity;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e1 = (EditText) findViewById(R.id.KGweight);
        final EditText e2 = (EditText) findViewById(R.id.HeightEnter);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);

        findViewById(R.id.Calculate).setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }


                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;


                float bmiValue = calculateBMI(weight, height);


                String bmiInterpretation = interpretBMI(bmiValue);

                tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });

    }


    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }


    private String interpretBMI(float bmiValue) {

        if (bmiValue < 15) {
            return "Severely underweight :( :(";
        } else if (bmiValue < 20) {

            return "You're Underweight :(";
        } else if (bmiValue < 30) {

            return "Congrats you're Normal";
        } else if (bmiValue < 35) {

            return "You're Overweight";
        } else {
            return "You're Obese";
        }
    }
}