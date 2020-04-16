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

    but1.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        String value = editText.getText().toString().trim();
        SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("value", value);
        editor.apply();
        Intent intent = new Intent(FormActivity.this, MainActivity.class);
        startActivity(intent);
     }
   });
  }
}
