package com.example.juexingzhe.testfragmenttablayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;


/**
 * Created by juexingzhe on 2017/6/24.
 */

public class MyFragmentTabLayout extends FragmentTabHost {

    private FragmentTabHost fragmentTabHost;
    private Drawable dividerDrawable;

    private FragmentTabLayoutAdapter fragmentTabLayoutAdapter;

    public MyFragmentTabLayout(Context context) {
        super(context);
        init();
    }

    public MyFragmentTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        readAttrs(context, attrs);
        init();
    }

    private void readAttrs(Context context, AttributeSet attributeSet){

    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.myfragment_tab_layout, this, true);

        fragmentTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);

        dividerDrawable = null;
    }

    public void setDividerDrawable(Drawable dividerDrawable) {
        this.dividerDrawable = dividerDrawable;
    }

    public MyFragmentTabLayout init(FragmentManager fragmentManager) {
        fragmentTabHost.setup(getContext(), fragmentManager, android.R.id.tabcontent);
        return this;
    }

    public MyFragmentTabLayout setFragmentTabLayoutAdapter(FragmentTabLayoutAdapter fragmentTabLayoutAdapter) {
        this.fragmentTabLayoutAdapter = fragmentTabLayoutAdapter;
        return this;
    }


    public MyFragmentTabLayout creat(){

        if (fragmentTabLayoutAdapter == null) return null;
        TabInfo tabInfo;
        for (int i = 0; i < fragmentTabLayoutAdapter.getCount(); i++){
            tabInfo = fragmentTabLayoutAdapter.getTabInfo(i);
            TabSpec tabSpec = fragmentTabHost.newTabSpec(tabInfo.getTabTag()).setIndicator(tabInfo.getTabView());
            fragmentTabHost.addTab(tabSpec, tabInfo.getFragmentClass(), tabInfo.getBundle());
            //fragmentTabHost.getTabWidget().setDividerDrawable(dividerDrawable);
            fragmentTabHost.setOnTabChangedListener(new OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    int currentTab = fragmentTabHost.getCurrentTab();
                    fragmentTabLayoutAdapter.onClick(currentTab);
                }
            });
        }

        return this;
    }


    public interface FragmentTabLayoutAdapter{

        int getCount();

        TabInfo getTabInfo(int pos);

        View createView(int pos);

        void onClick(int pos);

    }
}
