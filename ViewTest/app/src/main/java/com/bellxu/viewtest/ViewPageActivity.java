package com.bellxu.viewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActivity extends AppCompatActivity implements View.OnClickListener {

    private View view1;
    private View view2;

    private ArrayList<View> viewList;
    private ViewPager viewPager;
    private Button tab1;
    private Button tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        LayoutInflater lf = getLayoutInflater().from(this);
        view1 = lf.inflate(R.layout.layout1, null);
        view2 = lf.inflate(R.layout.layout2, null);
        tab1 = (Button) findViewById(R.id.tab1);
        tab2 = (Button) findViewById(R.id.tab2);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewPager=(ViewPager) findViewById(R.id.pager);



        viewPager.setAdapter(new MyViewPagerAdapter(viewList));
        viewPager.setCurrentItem(0);
//        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());//设置页面切换时候的监听器(可选，用了之后要重写它的回调方法处理页面切换时候的事务)

    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews;
        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
        }
        //直接继承PagerAdapter，至少必须重写下面的四个方法，否则会报错
        @Override
        public void destroyItem(ViewGroup container, int position, Object object)  {
            container.removeView(mListViews.get(position));//删除页卡
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position){
            //这个方法用来实例化页卡
            container.addView(mListViews.get(position), 0);//添加页卡
            return mListViews.get(position);
        }
        @Override
        public int getCount() {
            return  mListViews.size();//返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;//官方提示这样写
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab2:
                viewPager.setCurrentItem(1);
                break;
        }
    }
}
