package exampel.com.myapplication.NavigationDrawer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import exampel.com.myapplication.R;
import exampel.com.myapplication.RecyclerView.ClickListener;
import exampel.com.myapplication.RecyclerView.Data;
import exampel.com.myapplication.RecyclerView.DividerItemDecoration;
import exampel.com.myapplication.RecyclerView.Item;
import exampel.com.myapplication.RecyclerView.Recycler_View_Adapter;


public class HomeFragment extends Fragment {

    private List<Item> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Recycler_View_Adapter mAdapter;
    private static final int[] images = { R.drawable.a1,
            R.drawable.a2, R.drawable.a3, R.drawable.a4,
            R.drawable.a5, R.drawable.a6, R.drawable.a7,
            R.drawable.a8, R.drawable.a9 };

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new Recycler_View_Adapter(movieList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
        return view;
    }

    private void prepareMovieData() {
        Item movie = new Item("Inside Out", "Animation, Kids & Family", "2015",R.drawable.a1);
        movieList.add(movie);

        movie = new Item("Inside Out", "Animation, Kids & Family", "2015",R.drawable.a2);
        movieList.add(movie);

        movie = new Item("Star Wars: Episode VII - The Force Awakens", "Action", "2015",R.drawable.a3);
        movieList.add(movie);

        movie = new Item("Shaun the Sheep", "Animation", "2015",R.drawable.a4);
        movieList.add(movie);

        movie = new Item("The Martian", "Science Fiction & Fantasy", "2015",R.drawable.a5);
        movieList.add(movie);

        movie = new Item("Mission: Impossible Rogue Nation", "Action", "2015",R.drawable.a6);
        movieList.add(movie);

        movie = new Item("Up", "Animation", "2009",R.drawable.a7);
        movieList.add(movie);

        movie = new Item("Star Trek", "Science Fiction", "2009",R.drawable.a8);
        movieList.add(movie);

        movie = new Item("The LEGO Movie", "Animation", "2014",R.drawable.a9);
        movieList.add(movie);

        movie = new Item("Iron Man", "Action & Adventure", "2008",R.drawable.a1);
        movieList.add(movie);

        movie = new Item("Aliens", "Science Fiction", "1986",R.drawable.a2);
        movieList.add(movie);

        movie = new Item("Chicken Run", "Animation", "2000",R.drawable.a3);
        movieList.add(movie);

        movie = new Item("Back to the Future", "Science Fiction", "1985",R.drawable.a4);
        movieList.add(movie);

        movie = new Item("Raiders of the Lost Ark", "Action & Adventure", "1981",R.drawable.a5);
        movieList.add(movie);

        movie = new Item("Goldfinger", "Action & Adventure", "1965",R.drawable.a6);
        movieList.add(movie);

        movie = new Item("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014",R.drawable.a7);
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}