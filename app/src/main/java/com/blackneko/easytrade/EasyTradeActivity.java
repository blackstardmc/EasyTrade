package com.blackneko.easytrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class EasyTradeActivity extends AppCompatActivity {
    private ViewPager2 myViewPager;
    private TabLayout myTabLayout;


    private final String[] TAB_TITLES={"Manual","Grid Bot"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
            }

    public void configView(){
        myViewPager = findViewById(R.id.myViewPager);
        myTabLayout=findViewById(R.id.myTabLayout);
        FragmentStateAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        myViewPager.setAdapter(viewPagerAdapter);



        new TabLayoutMediator(myTabLayout, myViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(TAB_TITLES[position]);
            }


        }).attach();


    }
    @Override
    public void onBackPressed() {
        if (myViewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            myViewPager.setCurrentItem(myViewPager.getCurrentItem() - 1);
        }


    }
    }
