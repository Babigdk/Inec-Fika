package com.yaro.babigdk.inecfika;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainFrame extends AppCompatActivity {

    private TextView usedandunused;

    private EditText  first, second, third, fourth, fiveth, six, sev, eight;
    private String txt1, txt2, txt3, txt4, txt5, txt6, txt7;
     private int sum;
    private int validVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);

          first = (EditText) findViewById(R.id.voters_register);
          second = (EditText) findViewById(R.id.accrd);
          third = (EditText) findViewById(R.id.issued_paper);
          fourth = (EditText) findViewById(R.id.unused_paper);
          fiveth = (EditText) findViewById(R.id.spoiled_paper);
          six = (EditText) findViewById(R.id.rej_paper);
          sev = (EditText) findViewById(R.id.valid_vote);
          eight = (EditText) findViewById(R.id.used_paper);


         Button resul = (Button) findViewById(R.id.result);

        resul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                compute();
            }
        });
    }
    public void compute() {
        initialization();
        if(!validate()){
            Toast.makeText(this, "One or more field are empty!" , Toast.LENGTH_SHORT).show();
        }
        else{
            onSigUpSuccess();

        }
    }

    public void onSigUpSuccess(){
        int txt55 = Integer.parseInt(txt5);
        int txt66 = Integer.parseInt(txt6);
        int txt77 = Integer.parseInt(txt7);
        int txt22 = Integer.parseInt(txt2);

            validVote = txt22 - txt66;

            sev.setText(Integer.toString(validVote));

            sum = txt55 + txt66 + validVote;
            eight.setText(Integer.toString(sum));

    }
    public boolean validate(){
         boolean valid = true;
        if(txt1.isEmpty()){
            first.setError("Field is required");
            valid = false;
        }
        if(txt2.isEmpty()){
            second.setError("Field is required");
            valid = false;
        }
        if(txt3.isEmpty()){
            third.setError("Field is required");
            valid = false;
        }
        if(txt4.isEmpty()){
            fourth.setError("Field is required");
            valid = false;
        }
        if(txt5.isEmpty()){
            fiveth.setError("Field is required");
            valid = false;
        }
        if(txt6.isEmpty()){
            six.setError("Field is required");
            valid = false;
        }

        return  valid;

    }
    public void initialization(){
            txt1 = first.getText().toString().trim();
             txt2 =  second.getText().toString().trim();
             txt3 =  third.getText().toString().trim();
             txt4 =  fourth.getText().toString().trim();
             txt5 =  fiveth.getText().toString().trim();
             txt6 =  six.getText().toString().trim();
             txt7 =  sev.getText().toString().trim();

        }


    public void onReset(View v){

        EditText first = (EditText) findViewById(R.id.voters_register);
        EditText second = (EditText) findViewById(R.id.accrd);
        EditText third = (EditText) findViewById(R.id.issued_paper);
        EditText fourth = (EditText) findViewById(R.id.unused_paper);
        EditText fiveth = (EditText) findViewById(R.id.spoiled_paper);
        EditText six = (EditText) findViewById(R.id.rej_paper);
        EditText sev = (EditText) findViewById(R.id.valid_vote);
        EditText eight = (EditText) findViewById(R.id.used_paper);

        first.setText("");
        second.setText("");
        third.setText("");
        fourth.setText("");
        fiveth.setText("");
        six.setText("");
        sev.setText("0");
        eight.setText("0");

    }
}
