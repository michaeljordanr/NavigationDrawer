package com.example.michael.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PlanetAdapter extends BaseAdapter{

    private List<Planet> planets;
    private OnItemClickListener listener;

    public PlanetAdapter(Context context, OnItemClickListener listener) {
        planets = Planet.buildPlanets(context);
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int position) {
        return planets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder vh;
        final Planet p = planets.get(position);

        if(view == null){
            LayoutInflater vi = LayoutInflater.from(parent.getContext());
            view = vi.inflate(R.layout.drawer_list_item, parent, false);

            vh = new ViewHolder();
            vh.mTextView = (TextView) view.findViewById(R.id.text1);
            vh.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(p);
                }
            });
            view.setTag(vh);
        }else{
            vh = (ViewHolder) view.getTag();
        }

        vh.mTextView.setText(p.getName());
        return view;
    }

    public interface OnItemClickListener{
        public void onClick(Planet planet);
    }

    public static class ViewHolder {
        public TextView mTextView;
    }
}
