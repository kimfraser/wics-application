package com.example.android.wicsapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kimbers on 11/22/17.
 */

public class ListAdapter extends ArrayAdapter<ListItem> {

    private Activity context;
    private List<ListItem>  eventsList;

    public ListAdapter(Activity context, List<ListItem> items) {
        super(context, R.layout.list_item, items);
        this.context = context;
        this.eventsList = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_item, null, true);

        TextView textViewTitle = (TextView) listViewItem.findViewById(R.id.mTitle);
        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.mDate);

        ListItem item = eventsList.get(position);
        String name = item.getEventName();
        textViewTitle.setText(name);
        textViewDate.setText(item.getEventDate());

        return listViewItem;
    }
}
