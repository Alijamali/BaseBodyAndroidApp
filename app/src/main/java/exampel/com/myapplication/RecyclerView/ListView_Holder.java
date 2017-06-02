package exampel.com.myapplication.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import exampel.com.myapplication.R;

/**
 * Created by Ali on 24/05/2017.
 */

public class ListView_Holder extends RecyclerView.ViewHolder implements OnClickListener {

    public TextView list_title, list_location, list_date;
    public ImageView list_imageView;
    public RelativeLayout listLayout;
    private ClickListener clickListener;

    public ListView_Holder(View view) {
        super(view);

        // Find all views ids
        this.list_title = (TextView) view.findViewById(R.id.list_title);
        this.list_location = (TextView) view.findViewById(R.id.list_location);
        this.list_date = (TextView) view
                .findViewById(R.id.list_dateconstructed);
        this.list_imageView = (ImageView) view
                .findViewById(R.id.list_imageview);
        this.listLayout = (RelativeLayout) view.findViewById(R.id.list_layout);
        // Implement click listener over views that we need
        this.listLayout.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (clickListener != null){
            clickListener.onClick(view ,getAdapterPosition());
        }
    }
    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }
}
