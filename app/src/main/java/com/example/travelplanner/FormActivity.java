package com.example.travelplanner;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends Activity {
  Button but1;
  SharedPreferences sp;
  SharedPreferences.Editor editor;

  EditText editText;
  EditText editText2;
  EditText editText3;
  EditText editText4;
  EditText editText5;

  ///EditText tripID;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_form);

    but1 = (Button) findViewById(R.id.but1);
    editText = (EditText) findViewById(R.id.editText);
    editText2 = (EditText) findViewById(R.id.editText2);
    editText3 = (EditText) findViewById(R.id.editText3);
    editText4 = (EditText) findViewById(R.id.editText4);
    editText5 = (EditText) findViewById(R.id.editText5);

    sp = getSharedPreferences("TravelPlanner", MODE_PRIVATE);
    editor = sp.edit();
    if (sp.contains("name")) {
      editText.setText(sp.getString("name", "null"));
    }
    if (sp.contains("name")) {
      editText2.setText(sp.getString("name", "null"));
    }
    if (sp.contains("name")) {
      editText3.setText(sp.getString("name", "null"));
    }
    if (sp.contains("name")) {
      editText4.setText(sp.getString("name", "null"));
    }
    if (sp.contains("name")) {
      editText5.setText(sp.getString("name", "null"));
    }
  }

  public void createTrip(View view) {
    if(view.getId() == R.id.but1) {
      editor.putString("name", editText.getText().toString());
      editor.commit();
      Toast.makeText(getApplicationContext(), "Trip saved", Toast.LENGTH_LONG).show();
    }
  }
    /*but1.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {*/
        /*String msg = editText.getText().toString();
        Toast.makeText(FormActivity.this, "Trip name is "+msg, Toast.LENGTH_SHORT).show();

        String msg2 = editText2.getText().toString();
        Toast.makeText(FormActivity.this, "Passenger 1 is "+msg2, Toast.LENGTH_SHORT).show();

        String msg3 = editText3.getText().toString();
        Toast.makeText(FormActivity.this, "Passenger 2 is "+msg3, Toast.LENGTH_SHORT).show();

        String msg4 = editText4.getText().toString();
        Toast.makeText(FormActivity.this, "Passenger 3 is "+msg4, Toast.LENGTH_SHORT).show();

        String msg5 = editText5.getText().toString();
        Toast.makeText(FormActivity.this, "Passenger 4 is "+msg5, Toast.LENGTH_SHORT).show();*/
      }
   /* });
    }
}*/
