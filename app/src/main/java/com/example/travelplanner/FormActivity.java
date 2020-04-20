package com.example.travelplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class FormActivity extends Activity implements OnClickListener {

  private Button addTodoBtn;
  private EditText tripEditText;
  private EditText passenger1EditText;
  private EditText passenger2EditText;
  private EditText passenger3EditText;
  private EditText passenger4EditText;

  private DBManager dbManager;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setTitle("Add Trip");
    this.setContentView(R.layout.activity_form);

    tripEditText = (EditText) findViewById(R.id.trip_edittext);
    passenger1EditText = (EditText) findViewById(R.id.passenger1_edittext);
    passenger2EditText = (EditText) findViewById(R.id.passenger2_edittext);
    passenger3EditText = (EditText) findViewById(R.id.passenger3_edittext);
    passenger4EditText = (EditText) findViewById(R.id.passenger4_edittext);

    addTodoBtn = (Button) findViewById(R.id.add_trip);

    dbManager = new DBManager(this);
    dbManager.open();
    addTodoBtn.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.add_trip:
        final String trip = tripEditText.getText().toString();
        final String passenger1 = passenger1EditText.getText().toString();
        final String passenger2 = passenger2EditText.getText().toString();
        final String passenger3 = passenger3EditText.getText().toString();
        final String passenger4 = passenger4EditText.getText().toString();

        dbManager.insert(trip, passenger1, passenger2, passenger3, passenger4);

        Intent main = new Intent(FormActivity.this, MainActivity.class)
          .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(main);
        break;
    }
  }
}
