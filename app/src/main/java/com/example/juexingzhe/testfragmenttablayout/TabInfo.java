package com.example.juexingzhe.testfragmenttablayout;

import android.os.Bundle;
import android.view.View;

/**
 * Created by juexingzhe on 2017/6/24.
 */

public class TabInfo {

    String tabTag;

    View tabView;

    Class fragmentClass;

    Bundle bundle;

    int backgroundRes;

    private void setTabTag(String tabTag) {
        this.tabTag = tabTag;
    }

    private void setTabView(View tabView) {
        this.tabView = tabView;
    }

    private void setFragmentClass(Class fragmentClass) {
        this.fragmentClass = fragmentClass;
    }

    private void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    private void setBackgroundRes(int backgroundRes){
        this.backgroundRes = backgroundRes;
    }

    public String getTabTag() {
        return tabTag;
    }

    public View getTabView() {
        return tabView;
    }

    public Class getFragmentClass() {
        return fragmentClass;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public static class Builder{
        String tabTag;

        View tabView;

        Class fragmentClass;

        Bundle bundle;

        int backgroundRes = -1;

        private TabInfo tabInfo;

        public Builder(String tabTag, View tabView, Class fragmentClass) {
            this(tabTag, tabView, fragmentClass, null);
        }

        public Builder(String tabTag, View tabView, Class fragmentClass, Bundle bundle) {
            this.tabTag = tabTag;
            this.tabView = tabView;
            this.fragmentClass = fragmentClass;
            this.bundle = bundle;
        }

        public Builder setTabTag(String tabTag){
            this.tabTag = tabTag;
            return this;
        }

        public Builder setTabView(View tabView){
            this.tabView = tabView;
            return this;
        }

        public Builder setFragmentClass(Class fragmentClass){
            this.fragmentClass = fragmentClass;
            return this;
        }

        public Builder setBundle(Bundle bundle){
            this.bundle = bundle;
            return this;
        }

        public Builder setBackgroundRes(int backgroundRes){
            this.backgroundRes = backgroundRes;
            return this;
        }

        public TabInfo build(){
            tabInfo = new TabInfo();
            tabInfo.setTabTag(tabTag);
            tabInfo.setBundle(bundle);
            tabInfo.setTabView(tabView);
            tabInfo.setFragmentClass(fragmentClass);
            if (backgroundRes == -1){
                backgroundRes = R.drawable.selector_tab_background;
                tabInfo.setBackgroundRes(backgroundRes);
            }

            return tabInfo;

        }
    }

}
