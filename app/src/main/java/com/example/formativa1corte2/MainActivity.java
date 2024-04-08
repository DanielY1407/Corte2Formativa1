package com.example.formativa1corte2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frm_home;
    BottomNavigationView nav_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ImageViewFragment imageViewFragment = new ImageViewFragment();
        SpinnerFragment spinnerFragment = new SpinnerFragment();
        //LoadFragment(ImageView);

        frm_home = findViewById(R.id.frm_home);
        nav_btn = findViewById(R.id.nav_btn);
        nav_btn.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.nav_ImageView){
                    LoadFragment(imageViewFragment);
                    return false;
                } else if (menuItem.getItemId()== R.id.nav_Spinner) {
                    LoadFragment(spinnerFragment);
                }
                return false;

            }
        });


    }

    public void LoadFragment(Fragment fr) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frm_home, fr);
        transaction.commit();
    }
}