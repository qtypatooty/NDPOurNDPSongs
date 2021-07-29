package sg.edu.rp.c346.id20006949.ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songlist;
    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        songlist = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView catitle = rowView.findViewById(R.id.catitle);
        TextView casingers = rowView.findViewById(R.id.casingers);
        TextView cayears = rowView.findViewById(R.id.cayears);
        RatingBar ratingBar = rowView.findViewById(R.id.ratingBar);

        // Obtain the Android Version information based on the position
        Song currentVersion = songlist.get(position);

        // Set values to the TextView to display the corresponding information
        catitle.setText(currentVersion.getTitle());
        casingers.setText(currentVersion.getSingers());
        cayears.setText(currentVersion.getYear()+"");
        ratingBar.setRating(currentVersion.getStar());
        ImageView ivNew = rowView.findViewById(R.id.ivNew);
        if(currentVersion.getYear()>=2019){
            ivNew.setImageResource(R.drawable.new_image);
            ivNew.setVisibility(View.VISIBLE);
        }else{
            ivNew.setVisibility(View.INVISIBLE);
        }
        return rowView;
    }

}
