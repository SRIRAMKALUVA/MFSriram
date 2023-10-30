package com.example.otsriramtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText startTime, endTime, timeToCheck;
    Button check;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTime = findViewById(R.id.input1);
        endTime = findViewById(R.id.input2);
        timeToCheck = findViewById(R.id.input3);
        check = findViewById(R.id.check);
        result = findViewById(R.id.result);



        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTimeInRange(getIntFromInput(startTime), getIntFromInput(endTime), getIntFromInput(timeToCheck))) {
                    result.setText("The entered hours is in the range");
                } else{
                    result.setText("The entered hours is not in the range");
                }
            }
        });
    }

    public int getIntFromInput(EditText editText){
        if (editText.getText().toString().equals("")){
            Toast.makeText(this, "Enter a value to continue", Toast.LENGTH_SHORT).show();
            return 0;
        }
        else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    public static boolean isTimeInRange(int startTime, int endTime, int timeToCheck) {
        if (startTime <= endTime) {
            // Case where the end time is greater than or equal to the start time.
            return timeToCheck >= startTime && timeToCheck < endTime;
        } else {
            // Special case where the end time is smaller than the start time (e.g., 22 - 6).
            // In this case, we split the range into two parts: [0, endTime) and [startTime, 24).
            return (timeToCheck >= startTime && timeToCheck < 24) || (timeToCheck >= 0 && timeToCheck <= endTime);
        }
    }

}