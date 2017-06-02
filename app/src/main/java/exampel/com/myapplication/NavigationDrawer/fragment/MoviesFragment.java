package exampel.com.myapplication.NavigationDrawer.fragment;


import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;
import exampel.com.myapplication.R;
import exampel.com.myapplication.RecyclerView.Item;
import exampel.com.myapplication.RecyclerView.ListView_Recycler_Adapter;


public class MoviesFragment extends Fragment {
    private static View view;
    private static RecyclerView listRecyclerView;
    private static ArrayList<Item> listArrayList;
    private static ListView_Recycler_Adapter adapter;
    // Images array for images
    private static final int[] images = { R.drawable.a1,
            R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a7,
            R.drawable.a8, R.drawable.a9 };

    // String array for title, location, year
    String[] getTitle, getLocation, getYear;
    private static RelativeLayout bottomLayout;
    private static LinearLayoutManager mLayoutManager;

    // Variables for scroll listener
    private boolean userScrolled = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;


    public MoviesFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= (View) inflater.inflate(R.layout.fragment_movies,container,false);
        init();
        populatRecyclerView();
        implementScrollListener();
        return view;
    }

    private void init() {
        bottomLayout = (RelativeLayout) view
                .findViewById(R.id.loadItemsLayout_recyclerView);
        // Getting the string array from strings.xml
        getTitle = getActivity().getResources().getStringArray(R.array.title);
        getLocation = getActivity().getResources().getStringArray(R.array.location);
        getYear = getActivity().getResources().getStringArray(R.array.constructed_year);
        mLayoutManager = new LinearLayoutManager(getActivity());
        listRecyclerView = (RecyclerView) view.findViewById(R.id.linear_recyclerview);
        listRecyclerView.setItemAnimator(new DefaultItemAnimator());
        listRecyclerView.setHasFixedSize(true);
        listRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void populatRecyclerView() {
        listArrayList=new ArrayList<Item>();
        for (int i=0 ;i<getTitle.length ; i++){
            listArrayList.add(new Item(getTitle[i],getLocation[i],getYear[i],images[i]));
        }
        adapter = new ListView_Recycler_Adapter(getActivity(),listArrayList);
        listRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



    private void implementScrollListener() {

        listRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    userScrolled=true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = mLayoutManager.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                pastVisiblesItems = mLayoutManager
                        .findFirstVisibleItemPosition();
                if (userScrolled
                        && (visibleItemCount + pastVisiblesItems) == totalItemCount) {
                    userScrolled = false;

                    updateRecyclerView();
                }
            }
        });
    }
    void updateRecyclerView(){
        bottomLayout.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Loop for 3 items
                for (int i = 0; i < 3; i++) {
                    int value = new RandomNumberGenerator().RandomGenerator();// Random
                    // value
                    // add random data to arraylist
                    listArrayList.add(new Item(getTitle[value],
                            getLocation[value], getYear[value], images[value]));
                }
                adapter.notifyDataSetChanged();// notify adapter

                // Toast for task completion
                Toast.makeText(getActivity(), "Items Updated.",
                        Toast.LENGTH_SHORT).show();

                // After adding new data hide the view.
                bottomLayout.setVisibility(View.GONE);
            }
        },500);
    }
    public class RandomNumberGenerator {
        // Random generator method this will generate int nos.
        public int RandomGenerator() {
            Random random = new Random();
            int randomNum = random.nextInt(9);
            return randomNum;
        }

    }

}
