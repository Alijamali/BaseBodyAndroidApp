package exampel.com.myapplication.NavigationDrawer.activity;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import exampel.com.myapplication.NavigationDrawer.fragment.HomeFragment;
import exampel.com.myapplication.NavigationDrawer.fragment.MoviesFragment;
import exampel.com.myapplication.NavigationDrawer.fragment.PhotosFragment;
import exampel.com.myapplication.R;

public class AboutUsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    int[] ICONS ={R.drawable.ic_1 ,
            R.drawable.ic_2,
            R.drawable.ic_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        viewPager=(ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout=(TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(ICONS[0]);
        tabLayout.getTabAt(1).setIcon(ICONS[1]);
        tabLayout.getTabAt(2).setIcon(ICONS[2]);
    }

    void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(),"Home");
        adapter.addFragment(new MoviesFragment(),"Movies");
        adapter.addFragment(new PhotosFragment(),"Photo");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        final List<Fragment> fragmentList=new ArrayList<>();
        final List<String> listNameFrag=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        void addFragment(Fragment fragment, String title){
            fragmentList.add(fragment);
            listNameFrag.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }


}
