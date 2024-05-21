package com.example.customizetheme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ImageButton btnTheme1;
    private ImageButton btnTheme2;
    private ImageButton btnTheme3;
    private ImageButton btnTheme4;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i(TAG, "onCreate: ");

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int selectedTheme = sharedPreferences.getInt("SelectedTheme", 0);
        setCustomizeTheme(selectedTheme);

        btnTheme1 = findViewById(R.id.btnTheme1);
        btnTheme2 = findViewById(R.id.btnTheme2);
        btnTheme3 = findViewById(R.id.btnTheme3);
        btnTheme4 = findViewById(R.id.btnTheme4);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        btnTheme1.setOnClickListener(view -> {
            Log.i(TAG, "onCreate: btn1");
            editor.putInt("SelectedTheme", 1);
            editor.apply();
            setCustomizeTheme(1);
            findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.theme1colorPrimary)); // Change background color
        });
        btnTheme2.setOnClickListener(view -> {
            Log.i(TAG, "onCreate: btn2");
            editor.putInt("SelectedTheme", 2);
            editor.apply();
            setCustomizeTheme(2);
            findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.theme2colorPrimary));
        });
        btnTheme3.setOnClickListener(view -> {
            Log.i(TAG, "onCreate: btn3");
            editor.putInt("SelectedTheme", 3);
            editor.apply();
            setCustomizeTheme(3);
            findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.theme3colorPrimary));
        });
        btnTheme4.setOnClickListener(view -> {
            Log.i(TAG, "onCreate: btn4");
            editor.putInt("SelectedTheme", 4);
            editor.apply();
            setCustomizeTheme(4);
            findViewById(R.id.main).setBackgroundColor(getResources().getColor(R.color.theme4colorPrimary));
        });
//        startActivity(new Intent(MainActivity.this, MainActivity.class));
//        finish();
    }

    private void setCustomizeTheme(int selectedTheme) {
        Log.i(TAG, "setCustomizeTheme: ");
        switch (selectedTheme) {
            case 1:
                MainActivity.this.setTheme(R.style.CustomizeTheme1);
                break;
            case 2:
                MainActivity.this.setTheme(R.style.CustomizeTheme2);
                break;
            case 3:
                MainActivity.this.setTheme(R.style.CustomizeTheme3);
                break;
            case 4:
                MainActivity.this.setTheme(R.style.CustomizeTheme4);
                break;
        }
    }


}