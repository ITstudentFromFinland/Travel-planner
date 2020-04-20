package com.example.travelplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ModifyTrip extends Activity implements OnClickListener {
  private EditText titleText;
  private Button updateBtn, deleteBtn;
  private EditText passenger1Text;
  private EditText passenger2Text;
  private EditText passenger3Text;
  private EditText passenger4Text;

  private long _id;
  private DBManager dbManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setTitle("Modify Trip");

    setContentView(R.layout.activity_modify_trip);

    dbManager = new DBManager(this);
    dbManager.open();

    titleText = (EditText) findViewById(R.id.trip_edittext);
    passenger1Text = (EditText) findViewById(R.id.passenger1_edittext);
    passenger2Text = (EditText) findViewById(R.id.passenger2_edittext);
    passenger3Text = (EditText) findViewById(R.id.passenger3_edittext);
    passenger4Text = (EditText) findViewById(R.id.passenger4_edittext);

    updateBtn = (Button) findViewById(R.id.btn_update);
    deleteBtn = (Button) findViewById(R.id.btn_delete);

    Intent intent = new Intent();
    String id = intent.getStringExtra("id");
    String name = intent.getStringExtra("title");
    String passenger1 = intent.getStringExtra("passenger1");
    String passenger2 = intent.getStringExtra("passenger2");
    String passenger3 = intent.getStringExtra("passenger3");
    String passenger4 = intent.getStringExtra("passenger4");

    _id = Long.parseLong(id);

    titleText.setText(name);
    passenger1Text.setText(passenger1);
    passenger2Text.setText(passenger2);
    passenger3Text.setText(passenger3);
    passenger4Text.setText(passenger4);

    updateBtn.setOnClickListener(this);
    deleteBtn.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_update:
        String title = titleText.getText().toString();
        String passenger1 = passenger1Text.getText().toString();
        String passenger2 = passenger2Text.getText().toString();
        String passenger3 = passenger3Text.getText().toString();
        String passenger4 = passenger4Text.getText().toString();

        dbManager.update(_id, title, passenger1, passenger2, passenger3, passenger4);
        this.returnHome();
        break;

      case R.id.btn_delete:
        dbManager.delete(_id);
        this.returnHome();
        break;
    }
      }

      public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), MainActivity.class)
          .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
  }
}
