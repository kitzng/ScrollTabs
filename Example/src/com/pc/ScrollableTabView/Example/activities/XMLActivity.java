package com.pc.ScrollableTabView.Example.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.pc.ScrollableTabView.Example.R;
import com.pc.ScrollableTabView.Example.adapters.DefaultTabAdapter;
import com.pc.ScrollableTabView.Example.adapters.MyPagerAdapter;
import com.pc.ScrollableTabView.ScrollableTabView;

import java.util.Random;

/**
 * Created by Pietro Caselani
 */
public class XMLActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_layout);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        final ScrollableTabView tabs = (ScrollableTabView) findViewById(R.id.scrollTabs);
        tabs.setViewPager(pager);
        tabs.setTabAdapter(new DefaultTabAdapter());

        findViewById(R.id.button_divider_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int dividerColor = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                tabs.setDividerColor(dividerColor);
            }
        });

        findViewById(R.id.button_divider_visibility).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabs.setShowDivider(!tabs.isShowingSeparator());
            }
        });
    }
}