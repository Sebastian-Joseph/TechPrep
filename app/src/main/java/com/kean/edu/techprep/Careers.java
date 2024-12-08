package com.kean.edu.techprep;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

public class Careers extends AppCompatActivity {
    TextView linkText1;
    TextView linkText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_careers);

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
        TabLayout.Tab careerTab = tabLayout.getTabAt(2);
        if (careerTab != null) {
            careerTab.select();
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        startActivity(new Intent(Careers.this, MainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(Careers.this, Resume.class));
                        break;
                    case 2:
                        break;
                    case 3:
                        startActivity(new Intent(Careers.this, LinkedIn.class));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });


        linkText1 = findViewById(R.id.textView6);
        linkText2 = findViewById(R.id.textView16);

        SpannableString spannableString1 = new SpannableString("Software Engineer");
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.computerscience.org/careers/software-engineer/"));
                startActivity(browserIntent);
            }
        };
        spannableString1.setSpan(clickableSpan1, 0, spannableString1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        linkText1.setText(spannableString1);
        linkText1.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString spannableString2 = new SpannableString("Data Scientist");
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coursera.org/articles/what-is-data-science"));
                startActivity(browserIntent);
            }
        };
        spannableString2.setSpan(clickableSpan2, 0, spannableString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        linkText2.setText(spannableString2);
        linkText2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
