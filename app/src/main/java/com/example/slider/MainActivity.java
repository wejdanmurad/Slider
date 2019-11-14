package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ViewPager sliderPager;
    private TabLayout indicator;
    private SlidePagerAdapter adapter;
    private List<slide> listSlides;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);


        listSlides = new ArrayList<>(5);
        listSlides.add(new slide(R.drawable.moana, "Moana"));
        listSlides.add(new slide(R.drawable.moana, "Moana"));
        listSlides.add(new slide(R.drawable.moana, "Moana"));
        listSlides.add(new slide(R.drawable.moana, "Moana"));
        listSlides.add(new slide(R.drawable.moana, "Moana"));


        adapter = new SlidePagerAdapter(this, listSlides);
        sliderPager.setAdapter(adapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 4000, 3000);

        indicator.setupWithViewPager(sliderPager, true);


    }

    //Timer class
    class SliderTimer extends TimerTask {


        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem() < listSlides.size() - 1) {
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem() + 1);
                    } else {
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
