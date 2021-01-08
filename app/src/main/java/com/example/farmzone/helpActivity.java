package com.example.farmzone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class helpActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext, btnGetStarted;
    int position = 0;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        //make the activity full screen
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //   WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //HIDE THE ACTION BAR
        //getSupportActionBar().hide();

        //when activity is about to open, we check if its been opened before or not
        if (restorePrefData()) {
            Intent intent = new Intent(getApplicationContext(),Register.class);
            startActivity(intent);
            finish();
        }

        //ini views
        btnNext = findViewById(R.id.btn_next);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnGetStarted = findViewById(R.id.btn_getstarted);

        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);

        //fill list screen
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("First of it's kind","Farmzone is the first app that will guide farmers on fertilizer application and the right amount to add to a particular crop",R.drawable.no1));
        mList.add(new ScreenItem("Easy Access","The app can be accessed from anywhere in the world with a smartphone and internet connection. Your data is online!",R.drawable.access));
        mList.add(new ScreenItem("Quick Response","The app has been streamlined to offer quick response to farmers anyday-anytime.",R.drawable.img2));

        //setup viewpager
        screenPager = findViewById(R.id.screen_viewpagerr);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //setup tabLayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);

        //next button click Listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = screenPager.getCurrentItem();
                if(position < mList.size())
                {
                    position++;
                    screenPager.setCurrentItem(position);
                }
                if(position == mList.size()-1) { // when we reach the last screen

                    //show the get started button and hide the indicator and the next button

                    loadLastScreen();

                }
            }
        });

        //tablayout add change listener
        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition()==mList.size()-1)
                {
                    loadLastScreen();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Get started button on click listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                //checking if the user has gone through the onboard before
                savePrefsData();
                finish();
            }
        });
    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened",false);
        return isIntroActivityOpenedBefore;
    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }


    //show the get started  button and hide the indicator and the next button

    private void loadLastScreen() {

        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.VISIBLE);

        //Animation for getstarted button
        btnGetStarted.setAnimation(btnAnim);
    }
}
