package exampel.com.myapplication.RecyclerView;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import exampel.com.myapplication.R;

/**
 * Created by Ali on 30/05/2017.
 */

public class View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

    CardView cv;
    TextView title;
    TextView description;
    ImageView imageView;
    ClickListener clickListener;

    View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
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
