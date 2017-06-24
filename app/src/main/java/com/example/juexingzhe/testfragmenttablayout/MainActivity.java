package com.example.juexingzhe.testfragmenttablayout;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends FragmentActivity {


    private MyFragmentTabLayout fragmentTabHost;

    private Class fragmentClass[] = {Fragment1.class, Fragment2.class, Fragment3.class, Fragment4.class};
    private String textViewArray[] = {"Home", "Contact", "Find", "Center"};
    private Integer drawables[] = {R.drawable.tab_home_btn, R.drawable.tab_view_btn, R.drawable.tab_view_btn, R.drawable.tab_view_btn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        fragmentTabHost = (MyFragmentTabLayout) findViewById(R.id.tab_layout);
        fragmentTabHost.init(getSupportFragmentManager())
                .setFragmentTabLayoutAdapter(new DefaultFragmentTabAdapter(Arrays.asList(fragmentClass), Arrays.asList(textViewArray), Arrays.asList(drawables)){
                    @Override
                    public View createView(int pos) {
                        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_item, null);
                        ImageView imageView = (ImageView) view.findViewById(R.id.img);
                        imageView.setImageResource(drawables[pos]);
                        TextView textView = (TextView) view.findViewById(R.id.tab_text);
                        textView.setText(textViewArray[pos]);
                        return view;
                    }

                    @Override
                    public void onClick(int pos) {
                        Toast.makeText(MainActivity.this, textViewArray[pos] + " be clicked", Toast.LENGTH_SHORT).show();
                    }
                }).creat();
    }


}
