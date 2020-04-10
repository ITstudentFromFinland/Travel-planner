package com.example.travelplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BottomNavigationView navView = findViewById(R.id.nav_view);
    View mTextMessage = findViewById(R.id.message);
    navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
          case R.id.navigation_home:
            Intent dash = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(dash);

          case R.id.navigation_dashboard:
            Intent home = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(home);
            break;

          case R.id.navigation_notifications:
            Intent notifi = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(notifi);
            break;
        }
        return false;
      }
    });
  }
}
