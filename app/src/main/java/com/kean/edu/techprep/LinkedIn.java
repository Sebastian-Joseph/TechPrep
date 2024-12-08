package com.kean.edu.techprep;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

public class LinkedIn extends AppCompatActivity {
    ImageView imageLink1;
    ImageView imageLink2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linked_in);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_home)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_resume)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_career)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_linkedin)));
        TabLayout.Tab linkedInTab = tabLayout.getTabAt(3);
        if (linkedInTab != null) {
            linkedInTab.select();
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        startActivity(new Intent(LinkedIn.this, MainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(LinkedIn.this, Resume.class));
                        break;
                    case 2:
                        startActivity(new Intent(LinkedIn.this, Careers.class));
                        break;
                    case 3:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        imageLink1 = findViewById(R.id.linkedin_1);
        imageLink2 = findViewById(R.id.linkedin_2);

        imageLink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/leeodden/"));
                startActivity(intent);
            }
        });

        imageLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/pamdidner/"));
                startActivity(intent);
            }
        });

    }
}
