package com.example.halfm_1.tabbedview;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends FragmentActivity {

ViewPager pager;
    PagerTabStrip tab;
    Context c;
Cursor cursor;
  android.app.Fragment f1;
static tab1 fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentAdapter fa=new FragmentAdapter(getSupportFragmentManager());
        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(fa);
        tab=(PagerTabStrip)findViewById(R.id.tab);
       // f1=(android.app.Fragment)getFragmentManager().findFragmentById(R.id.tab1);

fragment=(tab1) getSupportFragmentManager().findFragmentById(R.id.tab1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }


    public void searchBtn(View v){
        Log.e("string", "main");
      //  fragment.search(v);


    }

 public Cursor  setCursor(){

return cursor;


 }


}
