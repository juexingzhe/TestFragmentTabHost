package com.example.juexingzhe.testfragmenttablayout;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juexingzhe on 2017/6/24.
 */

public class DefaultFragmentTabAdapter implements MyFragmentTabLayout.FragmentTabLayoutAdapter {

    private List<Class> fragmentclass = new ArrayList<>();
    private List<String> fragmentTag = new ArrayList<>();
    private List<Integer> drawables = new ArrayList<>();

    public DefaultFragmentTabAdapter(List<Class> fragmentclass, List<String> fragmentTag, List<Integer> drawables) {
        this.fragmentclass = fragmentclass;
        this.fragmentTag = fragmentTag;
        this.drawables = drawables;
    }

    @Override
    public int getCount() {
        return fragmentTag.size();
    }

    @Override
    public TabInfo getTabInfo(int pos) {
        return new TabInfo.Builder(fragmentTag.get(pos), createView(pos), fragmentclass.get(pos)).build();
    }

    @Override
    public View createView(int pos) {
        return null;
    }

    @Override
    public void onClick(int pos) {

    }
}
