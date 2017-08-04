package com.hfad.converter;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.content.Intent;

public class ConvertDataActivity extends Activity {
    int from , to , rowNo;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_data);

        Spinner dropdown1 = (Spinner)findViewById(R.id.spinner1);
        String[] currencyList = new String[]{"Dollar", "Indian Rupees", "Pound"};
        String[] areaList = new String[]{"Square Foot","Square Meter","Inch"};
        rowNo = getIntent().getIntExtra("rowNo",0);
        if(rowNo==0)
             adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currencyList);
        else if(rowNo==1)
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, areaList);

        dropdown1.setAdapter(adapter);

        Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);

        dropdown2.setAdapter(adapter);

        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                 public void onItemSelected(AdapterView<?> parent,View v,
                                             int position,long d){
                     from = position;
                 }
                 public void onNothingSelected(AdapterView<?> arg0){

                 }
          }
        );

        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                                                public void onItemSelected(AdapterView<?> parent,View v,
                                                                           int position,long d){
                                                    to = position;
                                                }
                                                public void onNothingSelected(AdapterView<?> arg0){

                                                }
                                            }
        );


    }

    public void convertData(View v){
        double convertedValue= 0;
        Log.e("ConvertDataActivity","Button clicked");
        EditText editText = (EditText) findViewById(R.id.editText1);
        TextView textView = (TextView) findViewById(R.id.textView1);
        String value = editText.getText().toString();
        int intValue = Integer.parseInt(value);
        if(rowNo==0){
            if(to==0)
                convertedValue = toDollar(from,intValue);
            if(to==1)
                convertedValue = toRupees(from,intValue);
        }else if(rowNo==1){
            if(to==0)
                convertedValue = toSquareMeter(from,intValue);
  //          if(to==1)
               // convertedValue = toRupees(from,intValue);
        }


       textView.setText(String.valueOf(convertedValue));
    }

    public double toSquareMeter(int from,int value){
        double toValue = 0;
        switch(from){
            case 0:
                toValue = value * 1;
                break;
            case 1:
                toValue = value *(0.0929);
                break;
            case 2:
                toValue = (int) (value * (1.30));
                break;
        }
        return toValue ;
    }
    public int toDollar(int from,int value){
        int toValue = 0;
        switch(from){
            case 0:
                toValue = value * 1;
                break;
            case 1:
                toValue = value / 65;
                break;
            case 2:
                toValue = (int) (value * (1.30));
                break;
        }
        return toValue ;
    }
    public int toRupees(int from,int value){
        int toValue = 0;
        switch(from){
            case 0:
                toValue = value * 65;
                break;
            case 1:
                toValue = value * 1;
                break;
            case 2:
                toValue = value * 80;
                break;
        }
        return toValue ;
    }

}
