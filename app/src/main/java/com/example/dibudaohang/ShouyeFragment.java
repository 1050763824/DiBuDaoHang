package com.example.dibudaohang;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.dibudaohang.fragment.RemenFragment;
import com.example.dibudaohang.fragment.TuijianFragment;
import com.example.dibudaohang.fragment.XinwenFragment;
import com.example.dibudaohang.fragment.ZhiboFragment;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ShouyeFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<View> mViewList;
    private List<String> mTitleList;





//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//
//        return inflater.inflate(R.layout.shouye_fragment, container, false);
//    }
//
//
//    public void oncreate() {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.shouye_fragment);
//
//
//            mTabLayout = (TabLayout) getView().findViewById(R.id.tab);
//            View zhibo = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.shouye_fragment, null);
//            View tuijian = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.fragment_tuijian, null);
//            View remen = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.fragment_remen, null);
//            View xinwen = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.fragment_xinwen, null);
//
//            mViewList = new ArrayList<>();
//            mViewList.add(zhibo);
//            mViewList.add(tuijian);
//            mViewList.add(remen);
//            mViewList.add(xinwen);
//
//
//            mTitleList = new ArrayList<>();
//            mTitleList.add("首页");
//            mTitleList.add("通讯录");
//            mTitleList.add("发现");
//            mTitleList.add("发现");
//
//
//
//            mViewPager = (ViewPager) getView().findViewById(R.id.viewpager);
//            mViewPager.setAdapter(new PagerAdapter() {
//                @Override
//                public int getCount() {
//                    return mViewList.size();
//                }
//
//                @Override
//                public boolean isViewFromObject(View view, Object object) {
//                    return view == object;
//                }
//
//                @Override
//                public void destroyItem(ViewGroup container, int position, Object object) {
//                    container.removeView(mViewList.get(position));
//                }
//
//                @Override
//                public Object instantiateItem(ViewGroup container, int position) {
//                    container.addView(mViewList.get(position));
//                    return mViewList.get(position);
//                }
//
//                @Override
//                public CharSequence getPageTitle(int position) {
//                    return mTitleList.get(position);
//                }
//            });
//
//            mTabLayout.setupWithViewPager(mViewPager);
//
//            //TabLayout监听
//            mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                @Override
//                public void onTabSelected(TabLayout.Tab tab) {
//                    //切换tab时不使用ViewPager动画效果
//                    mViewPager.setCurrentItem(tab.getPosition(),false);
//                }
//
//                @Override
//                public void onTabUnselected(TabLayout.Tab tab) {
//
//                }
//
//                @Override
//                public void onTabReselected(TabLayout.Tab tab) {
//
//                }
//            });
//
//
//
//        }


    private View contextView;// 总视图

    private TabLayout tabLayout;

    private ViewPager viewpager;

    ArrayList fragmentList = new ArrayList<Fragment>();

    String[] temp = {"直播","推荐","热门","新闻"};
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contextView = inflater.inflate(R.layout.shouye_fragment, container, false);
        tabLayout = contextView.findViewById(R.id.tab);
        viewpager = contextView.findViewById(R.id.viewpager);
        return contextView;

    }



    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // fragment中嵌套fragment, Manager需要用(getChildFragmentManager())
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getChildFragmentManager());
        initFragment();
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(mPagerAdapter);
    }



    private void initFragment() {
        fragmentList.add(new ZhiboFragment());
        fragmentList.add(new TuijianFragment());
        fragmentList.add(new RemenFragment());
        fragmentList.add(new XinwenFragment());


    }





    class MPagerAdapter extends FragmentPagerAdapter {
        public MPagerAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override

        public Fragment getItem(int position) {
            return (Fragment) fragmentList.get(position);
        }



        @Override

        public int getCount() {
            return fragmentList.size();
        }



        @Override

        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);

        }

        //返回tablayout的标题文字;
        @Override

        public CharSequence getPageTitle(int position) {
            return temp[position];
        }

    }

}







