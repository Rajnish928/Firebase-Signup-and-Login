package com.example.firebaseloginproject;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Main3Activity extends AppCompatActivity implements PaymentResultListener {
    public TextView t;


    Button pay1,pay2;
    int payamount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        t = (TextView) findViewById(R.id.txt);
        pay1 = (Button) findViewById(R.id.cod);
        pay2 = (Button) findViewById(R.id.online);

        payamount = getIntent().getIntExtra("total amount = ", 0);

        t.setText(String.valueOf(payamount));
        pay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startPayment();
            }


        });

        pay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }


        private void startPayment() {

            payamount = getIntent().getIntExtra("total amount = ",0);

            Checkout checkout = new Checkout();
            checkout.setImage(R.mipmap.ic_launcher);
            final Activity activity= this;
            try {
                JSONObject options = new JSONObject();
                options.put("items ","Order number");

                options.put("currency","INR");
                options.put("amount",payamount*100);
                checkout.open(activity,options);
            }catch (JSONException e){
                e.printStackTrace();

            }
        }





    @Override
    public void onPaymentSuccess(String s) {

        Toast.makeText(Main3Activity.this,"Payment Sucess",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(Main3Activity.this,"Payment Fail ",Toast.LENGTH_LONG).show();

    }
}
