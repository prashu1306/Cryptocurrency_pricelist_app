package com.example.user.cryptocurrency_pricelist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {

    Context context;
    ArrayList<FetchData.ListView2> items;
    LayoutInflater inflater;

    public CustomListAdapter(Activity context, ArrayList<FetchData.ListView2> items) {
        super();
        this.items = items;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        FetchData.ListView2 item = items.get(position);
        View view = convertView;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);

        }
        TextView name = view.findViewById(R.id.txt_view1);
        TextView price_usd = view.findViewById(R.id.txt_view2);
        TextView percent_change_1h = view.findViewById(R.id.txt_view3);

        name.setText(item.name);
        price_usd.setText(item.price_usd);
        percent_change_1h.setText(item.percent_change_1h);
        return view;
    }
}