package com.example.chris.factorialcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int num;
    int result;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Toast toast = Toast.makeText(getApplicationContext(), R.string.toastMessage, Toast.LENGTH_LONG);
        final EditText input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.result);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                num = Integer.parseInt(input.getText().toString());
                result = 1;
                if(num > 0){
                    //compute factorial
                    for(int i = num; i > 0; i--){
                        result *= i;
                    }
                    output.setText(Integer.toString(result));
                }else{
                    //output toast notification
                    toast.show();
                }

            }
        });
    }


    @Override
    public void onPause(){
        super.onPause();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("results", Integer.toString(result));
    }


    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        result = Integer.parseInt(savedInstanceState.getString("results"));
        output.setText(Integer.toString(result));
    }
}
