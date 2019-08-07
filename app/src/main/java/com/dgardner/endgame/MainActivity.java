package com.dgardner.endgame;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] api = {"Marvel Subreddit", "Pinterest"};

    public Spinner spinner;
    public static EditText enterText;
    public static Button searchButton;
    public static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterText = (EditText) findViewById(R.id.EditTextID);
        textView = (TextView)findViewById(R.id.textViewID);
        searchButton = (Button) findViewById(R.id.searchButtonID);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FetchReddit pull = new FetchReddit();
                pull.execute();
            }
        });


        spinner = (Spinner) findViewById(R.id.spinnerID);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Connector
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, api);
        /////////////////////////////////////////////////////////////////////////////////////////////Set To Spinner
        spinner.setAdapter(dataAdapter);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ////////////////////////////////////////////////////////////////////////////////////////////When user selects item
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(MainActivity.this, "You can search through : " + api[position], Toast.LENGTH_LONG).show();

                if (!(spinner.getSelectedItem().toString().equals("Marvel Subreddit"))){
                    startActivity(new Intent(MainActivity.this, FetchReddit.class));

                } if (spinner.getSelectedItem().toString().equals("Pnterest")){
                    startActivity((new Intent(MainActivity.this, FetchPinterest.class)));


                }else if (spinner.getSelectedItem().toString().equals("")){

                    Toast.makeText(MainActivity.this, "You have not made a selection: " +api[position], Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


    }
}
