package com.kean.edu.techprep;

<<<<<<< HEAD
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resume);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
=======
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class Resume extends AppCompatActivity {

    private ImageView lastClickedView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_home)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_resume)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_career)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_linkedin)));
        TabLayout.Tab resumeTab = tabLayout.getTabAt(1);
        if (resumeTab != null) {
            resumeTab.select();
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        startActivity(new Intent(Resume.this, MainActivity.class));
                        break;
                    case 1:
                        break;
                    case 2:
                        startActivity(new Intent(Resume.this, Careers.class));
                        break;
                    case 3:
                        startActivity(new Intent(Resume.this, LinkedIn.class));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
    public void onTemplateClick(View view) {
        ImageView clickedView = (ImageView) view;
        if (lastClickedView != null && lastClickedView != clickedView) {
            ObjectAnimator.ofFloat(lastClickedView, "scaleX", 1.0f).setDuration(200).start();
            ObjectAnimator.ofFloat(lastClickedView, "scaleY", 1.0f).setDuration(200).start();
        }
        ObjectAnimator.ofFloat(clickedView, "scaleX", 1.2f).setDuration(200).start();
        ObjectAnimator.ofFloat(clickedView, "scaleY", 1.2f).setDuration(200).start();
        lastClickedView = clickedView;
    }
}
>>>>>>> master
