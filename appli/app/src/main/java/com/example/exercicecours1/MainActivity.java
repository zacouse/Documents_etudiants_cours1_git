package com.example.exercicecours1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int max = 10;

    private EditText inputNumber1;
    private EditText inputNumber2;
    private Button buttonTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber1 = findViewById(R.id.editText_number1);
        inputNumber2 = findViewById(R.id.editText_number2);
        buttonTry = findViewById(R.id.button_tryNumber);

        setListenner();
    }

    private void setListenner(){
        buttonTry.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Compare();
            }
        });
        inputNumber1.setOnFocusChangeListener(new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                ResetColor();
            }
        });
        inputNumber2.setOnFocusChangeListener(new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                ResetColor();
            }
        });
    }

    private void Compare()
    {
        if(Integer.parseInt(inputNumber1.getText().toString()) > Integer.parseInt(inputNumber2.getText().toString()))
        {
            ShowToast("Nombre 1 est plus grand");
            inputNumber1.setBackgroundColor(0xFF00FF00);
            //inputNumber1.getBackground().setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.MULTIPLY));
        }
        else if(Integer.parseInt(inputNumber1.getText().toString()) < Integer.parseInt(inputNumber2.getText().toString()))
        {
            ShowToast("Nombre 2 est plus grand");
            inputNumber2.setBackgroundColor(0xFF00FF00);
            //inputNumber1.getBackground().setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.colorGreen), PorterDuff.Mode.MULTIPLY));
        }
        else
        {
            ShowToast("Les 2 nombres sont égaux");
        }
    }

    private void ResetColor(){
        inputNumber1.setBackgroundColor(0x00000000);
        inputNumber2.setBackgroundColor(0x00000000);
        if(inputNumber1.getText() == null || inputNumber1.getText().toString() == "")
        {
            inputNumber1.setText("0");
        }
        if(inputNumber2.getText() == null || inputNumber2.getText().toString() == "")
        {
            inputNumber2.setText("0");
        }
        //inputNumber1.getBackground().setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY));
        //inputNumber2.getBackground().setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY));
    }

    private void ShowToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
