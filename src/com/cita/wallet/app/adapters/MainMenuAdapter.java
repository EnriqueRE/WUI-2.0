package com.cita.wallet.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cita.wallet.app.R;
import com.cita.wallet.app.models.MainMenuItem;

import java.util.ArrayList;

/**
 * Base adapter that creates fills the layout for the main menu
 * Created by admin on 5/27/14.
 */
public class MainMenuAdapter extends BaseAdapter {

    ArrayList<MainMenuItem> menuItems;

    private LayoutInflater mInflater;

    public MainMenuAdapter(Context context, ArrayList<MainMenuItem> menuItems) {

        // Cache the LayoutInflate to avoid asking for a new one each time.
        mInflater = LayoutInflater.from(context);
        this.menuItems = menuItems;

    }

    @Override
    /**
     * @see android.widget.ListAdapter#getCount()
     */
    public int getCount() {
        return menuItems.size();
    }

    @Override
    /**
     * @see android.widget.ListAdapter#getItem(int)
     */
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    /**
     * Use the array index as a unique id.
     *
     * @see android.widget.ListAdapter#getItemId(int)
     */
    public long getItemId(int position) {
        return position;
    }

    @Override
    /**
     * Make a view to hold each row.
     *
     * @see android.widget.ListAdapter#getView(int, android.view.View,
     *      android.view.ViewGroup)
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        // A ViewHolder keeps references to children views to avoid unneccessary
        // calls
        // to findViewById() on each row.
        ViewHolder holder;

        // When convertView is not null, we can reuse it directly, there is no
        // need
        // to reinflate it. We only inflate a new View when the convertView
        // supplied
        // by ListView is null.
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.main_menu_item, null);

            // Creates a ViewHolder and store references to the two children
            // views
            // we want to bind data to.
            holder = new ViewHolder();
            // TODO store references to your views
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.icon = (ImageView) convertView
                    .findViewById(R.id.icon);

            convertView.setTag(holder);
        } else {
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(menuItems.get(position).getTitle());
        holder.icon.setImageResource(menuItems.get(position).getImgResource());

        return convertView;
    }

    static class ViewHolder {
        TextView title;
        ImageView icon;
    }

}
