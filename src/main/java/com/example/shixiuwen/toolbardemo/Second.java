package com.example.shixiuwen.toolbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.shixiuwen.toolbardemo.R;

/**
 * Created by shixiuwen on 15-10-29.
 */
public class Second extends ActionBarActivity {

    private Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()){
                case R.id.action_edit:
                    msg +="Click edit";
                    break;
                case R.id.action_share:
                    msg +="Click share";
                    break;
                case R.id.action_settings:
                    msg +="Click settings";
                    break;

            }
            if(!msg.equals("")){
                Toast.makeText(Second.this, msg, Toast.LENGTH_SHORT).show();
            }

            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.abc_ic_menu_cut_mtrl_alpha);
        toolbar.setTitle("Second Page");
        toolbar.setSubtitle("Sub title");

        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);

        //Navigation有自己独立的点击事件，通常用作返回
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
