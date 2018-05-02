package com.shahzaib.punjaabi;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.shahzaib.punjaabi.Adapters.ViewPagerAdapter;
import com.shahzaib.punjaabi.Fragments.ColorsFragment;
import com.shahzaib.punjaabi.Fragments.FamilyFragment;
import com.shahzaib.punjaabi.Fragments.NumbersFragment;
import com.shahzaib.punjaabi.Fragments.PhrasesFragment;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //**** Add fragments in view pager adapter
        adapter.addFragment(new NumbersFragment(),"Numbers");
        adapter.addFragment(new FamilyFragment(),"Family");
        adapter.addFragment(new PhrasesFragment(),"Phrases");
        adapter.addFragment(new ColorsFragment(),"Colors");



        //****** Add adapter to viewPager & also connect viewPager with tabLayout
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
