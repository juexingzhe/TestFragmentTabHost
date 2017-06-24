# TestFragmentTabHost

a custom FragmentTabHost:


add in xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.juexingzhe.testfragmenttablayout.MainActivity"
    android:orientation="vertical">

    <com.example.juexingzhe.testfragmenttablayout.MyFragmentTabLayout
        android:id="@+id/tab_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>


</LinearLayout>

then init in your activity
```
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
```

ok, that is all!

for more detail, see http://www.jianshu.com/p/bb44cbf15b11
