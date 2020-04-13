package com.example.travelplanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends Activity {

  EditText editText;
  EditText editText2;
  EditText editText3;
  EditText editText4;
  EditText editText5;
  Button but1;

  EditText tripID;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_form);

    editText = (EditText)findViewById(R.id.editText);
    editText2 = (EditText)findViewById(R.id.editText2);
    editText3 = (EditText)findViewById(R.id.editText3);
    editText4 = (EditText)findViewById(R.id.editText4);
    editText5 = (EditText)findViewById(R.id.editText5);
    but1 = (Button)findViewById(R.id.but1);

    but1.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        String msg = editText.getText().toString();
        Toast.makeText(FormActivity.this, "Trip name is "+msg, Toast.LENGTH_SHORT).show();

        String msg2 = editText2.getText().toString();
        Toast.makeText(FormActivity.this, "Passenger 1 is "+msg2, Toast.LENGTH_SHORT).show();

        String msg3 = editText3.getText().toString();
        Toast.makeText(FormActivity.this, "Passenger 2 is "+msg3, Toast.LENGTH_SHORT).show();

        String msg4 = editText4.getText().toString();
        Toast.makeText(FormActivity.this, "Passenger 3 is "+msg4, Toast.LENGTH_SHORT).show();

        String msg5 = editText5.getText().toString();
        Toast.makeText(FormActivity.this, "Passenger 4 is "+msg5, Toast.LENGTH_SHORT).show();
      }
    });
    }

  public void addEvent(View view) {
    DBHelper dbHandler = new DBHelper(this, null, null, 1);
    int id = Integer.parseInt(tripID.getText().toString());
    String title = editText.getText().toString();
    String passenger1 = editText2.getText().toString();
    String passenger2 = editText3.getText().toString();
    String passenger3 = editText4.getText().toString();
    String passenger4 = editText5.getText().toString();
    DisplayEvent event = new DisplayEvent(id, title, passenger1, passenger2, passenger3, passenger4);

    dbHandler.addHandler(event);
    tripID.setText("");
    editText.setText("");
    editText2.setText("");
    editText3.setText("");
    editText4.setText("");
    editText5.setText("");
  }
}
