package com.example.travelplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);

    BottomNavigationView navView = findViewById(R.id.nav_view);
    View mTextMessage = findViewById(R.id.message);
    navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
          case R.id.navigation_home:
            Intent dash = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(dash);

          case R.id.navigation_dashboard:
            Intent home = new Intent(ProfileActivity.this, MapsActivity.class);
            startActivity(home);
            break;

          case R.id.navigation_notifications:
            Intent notifi = new Intent(ProfileActivity.this, ProfileActivity.class);
            startActivity(notifi);
            break;
        }
        return false;
      }
    });
  }
}
