package exampel.com.myapplication.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import exampel.com.myapplication.R;

/**
 * Created by Ali on 24/05/2017.
 */

public class ListView_Recycler_Adapter extends RecyclerView.Adapter<ListView_Holder> {

    private ArrayList<Item> arrayList;
    private Context context;

    public ListView_Recycler_Adapter( Context context, ArrayList<Item> arrayList){
        this.context=context;
        this.arrayList=arrayList;

    }
    @Override
    public ListView_Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mLayout=LayoutInflater.from(parent.getContext());

        ViewGroup viewGroup =(ViewGroup) mLayout.inflate(R.layout.list_customview,parent,false);
        ListView_Holder listView_holder=new ListView_Holder(viewGroup);
        return listView_holder;
    }

    @Override
    public void onBindViewHolder(ListView_Holder holder, int position) {

        final Item item =arrayList.get(position);
        ListView_Holder mainHolder=(ListView_Holder) holder;
        Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),item.getImage());

        mainHolder.list_title.setText(item.getTitle());
        mainHolder.list_location.setText(item.getLocation());
        mainHolder.list_date.setText(item.getYear());
        mainHolder.list_imageView.setImageBitmap(bitmap);
        mainHolder.setClickListener(new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch(view.getId()){
                    case R.id.list_layout:
                        Toast.makeText(context, "You have clicked " + item.getTitle(),
                                Toast.LENGTH_LONG).show();
                        break;
                }
            }
            @Override
            public void onLongClick(View view, int position) {
            }
        });

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }
}
