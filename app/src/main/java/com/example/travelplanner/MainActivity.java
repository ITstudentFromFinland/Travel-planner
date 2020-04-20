package com.example.travelplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  private DBManager dbManager;
  private ListView listView;
  private SimpleCursorAdapter adapter;

  final String[] from = new String[]{DBHelper._ID, DBHelper.TRIP, DBHelper.PASSENGER1, DBHelper.PASSENGER2,
    DBHelper.PASSENGER3, DBHelper.PASSENGER4};

  final int[] to = new int[]{R.id.trip_edittext, R.id.passenger1_edittext, R.id.passenger2_edittext, R.id.passenger3_edittext, R.id.passenger4_edittext};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    dbManager = new DBManager(this);
    dbManager.open();
    Cursor cursor = dbManager.fetch();

    listView = (ListView) findViewById(R.id.list_view);
    listView.setEmptyView(findViewById(R.id.empty));

    adapter = new SimpleCursorAdapter(this, R.layout.activity_form, cursor, from, to, 0);
    adapter.notifyDataSetChanged();

    listView.setAdapter(adapter);

    BottomNavigationView navView = findViewById(R.id.nav_view);
    View mTextMessage = findViewById(R.id.message);
    navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
          case R.id.navigation_home:
            Intent dash = new Intent(MainActivity.this, MainActivity.class);
            startActivity(dash);

            case R.id.navigation_dashboard:
              Intent home = new Intent(MainActivity.this, MapsActivity.class);
              startActivity(home);
              break;

              case R.id.navigation_notifications:
                Intent notifi = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(notifi);
                break;
        }
        return false;
      }
    });

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EditText titleEditText = (EditText) view.findViewById(R.id.trip_edittext);
        EditText passenger1EditText = (EditText) view.findViewById(R.id.passenger1_edittext);
        EditText passenger2EditText = (EditText) view.findViewById(R.id.passenger2_edittext);
        EditText passenger3EditText = (EditText) view.findViewById(R.id.passenger3_edittext);
        EditText passenger4EditText = (EditText) view.findViewById(R.id.passenger4_edittext);

        String title = titleEditText.getText().toString();
        String passenger1 = passenger1EditText.getText().toString();
        String passenger2 = passenger2EditText.getText().toString();
        String passenger3 = passenger3EditText.getText().toString();
        String passenger4 = passenger4EditText.getText().toString();

        Intent modify_intent = new Intent(getApplicationContext(), ModifyTrip.class);
        modify_intent.putExtra("title", title);
        modify_intent.putExtra("passenger1", passenger1);
        modify_intent.putExtra("passenger2", passenger2);
        modify_intent.putExtra("passenger3", passenger3);
        modify_intent.putExtra("passenger4", passenger4);

        startActivity(modify_intent);
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.add_trip) {

      Intent add_trip = new Intent(this, FormActivity.class);
      startActivity(add_trip);
    }
    return super.onOptionsItemSelected(item);
  }
}
