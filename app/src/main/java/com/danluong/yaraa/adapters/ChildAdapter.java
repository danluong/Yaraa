package com.danluong.yaraa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.danluong.yaraa.R;
import com.danluong.yaraa.models.listing.Child;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dluong on 8/10/2015.
 */
public class ChildAdapter extends ArrayAdapter<Child> {
    public ChildAdapter(Context context, List<Child> objects) {
        super(context, 0, objects);
    }

    // View lookup cache
    static class ViewHolder {
        @Bind(R.id.textview_heading)
        TextView title;
        @Bind(R.id.textview_subheading)
        TextView author;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Child element = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.title.setText(element.getData().getTitle());
        viewHolder.author.setText(element.getData().getAuthor());
        // Return the completed view to render on screen
        return convertView;

    }
}
