package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtPercent, editTip, editTotal;
    EditText editBase;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPercent = findViewById(R.id.txtPercent);
        editBase = findViewById(R.id.editBase);
        editTip = findViewById(R.id.editTip);
        editTotal = findViewById(R.id.editTotal);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(15);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    txtPercent.setText(progress+"%");
                    computeTipTotal();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        editBase.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                computeTipTotal();
            }
        });




    }

    public void computeTipTotal(){
        if(editBase.getText().toString().equals("")){
            editTip.setText("");
            editTotal.setText("");
            return;
        }
        double baseAmt = Double.parseDouble(editBase.getText().toString());
        double tipPercent = seekBar.getProgress();
        double tip = baseAmt*tipPercent/100;
        double total = baseAmt+tip;
        editTip.setText(""+tip);
        editTotal.setText(""+total);

    }


}