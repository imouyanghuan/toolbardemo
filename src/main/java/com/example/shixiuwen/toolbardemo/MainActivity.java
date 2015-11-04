package com.example.shixiuwen.toolbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

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
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.abc_ic_menu_selectall_mtrl_alpha);
        toolbar.setTitle("My Title");
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
        /**
         在Android 原生样式应用中，有一个特别漂亮的效果，在使用抽屉布局的时候，展开或
         关闭抽屉时，Toolbar的 navigation drawer（upButton） 有一个动画，由三个横
         线旋转成箭头

         这个效果其实是由 Toolbar+DrawerLayout 实现的。

         具体做法参见：http://www.bubuko.com/infodetail-652481.html
         */



        Button btnSure = (Button) findViewById(R.id.btn_sure);

        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Second.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
