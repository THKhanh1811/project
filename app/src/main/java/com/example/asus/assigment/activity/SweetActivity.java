package com.example.asus.assigment.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.assigment.Adapter.Adapter_tablayout_Sweet;
import com.example.asus.assigment.R;

public class SweetActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    ListView listViewFragment_activity_main;
    Toolbar toolbar;

    TextView txttitle_actionbar;

    String titleActionbar = "Sweet";

    NavigationView navigationView;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdisplay();
        initaddcontroll();
        changeStatusbar();
        actionbar();


    }

    private void actionbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.icons_menu);
        txttitle_actionbar.setText(titleActionbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.START);

            }
        });
    }

    private void changeStatusbar() {
        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.color_statusbar));
    }

    private void initaddcontroll() {
        mViewPager= (ViewPager) findViewById(R.id.viewpager_activity_main);
        mViewPager.setAdapter(new Adapter_tablayout_Sweet(getSupportFragmentManager()));
        TabLayout tablayout= (TabLayout) findViewById(R.id.tablayout_activity_main);
        tablayout.setupWithViewPager(mViewPager);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        navigationView= (NavigationView) findViewById(R.id.NavigationView_activity_main);

        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);

        txttitle_actionbar=(TextView)findViewById(R.id.txttitle_actionbar);

    }

    private void initdisplay() {
    }
}
