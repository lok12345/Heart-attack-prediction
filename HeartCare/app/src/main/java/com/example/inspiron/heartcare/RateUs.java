package com.example.inspiron.heartcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by inspiron on 02/05/2018.
 */
public class RateUs extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RateUs.this;

    private TextView textViewr;
    private RatingBar ratingBar;
    private AppCompatButton ratingSend;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rateus);
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("key");

        initViews();
        initListeners();
        initObjects();

        textViewr = (TextView) findViewById(R.id.textView2);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

    }

    private void initViews() {
        textViewr = (TextView) findViewById(R.id.textView2);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ratingSend = (AppCompatButton) findViewById(R.id.ratingSend);
    }
    private void initListeners() {
        ratingSend.setOnClickListener((View.OnClickListener) this);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.ratingSend) {
            Intent myIntent1 = new Intent(RateUs.this, HealthCheck.class);
            boolean value = false;
            myIntent1.putExtra("key", value);
            RateUs.this.startActivity(myIntent1);

        }
    }
}
