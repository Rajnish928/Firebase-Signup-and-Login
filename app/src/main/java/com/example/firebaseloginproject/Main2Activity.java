package com.example.firebaseloginproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private Button pay;
    private EditText t ,e,e1,e2;
    int x,y,z,a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        e = (EditText)findViewById(R.id.num1);
        e1= (EditText)findViewById(R.id.num2);
        e2= (EditText)findViewById(R.id.num3);
        pay=(Button)findViewById(R.id.pay);
        String s;

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                x = Integer.parseInt(e.getText().toString());
                y = Integer.parseInt(e1.getText().toString());
                z = Integer.parseInt(e2.getText().toString());


                a = (200*x)+(y*120)+(z*40);

                Intent i = new Intent(Main2Activity.this,Main3Activity.class);


                i.putExtra("total amount = ",a);
                startActivity(i);

            }
        });



    }
}
