package com.example.meetdevs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<Item> itemList;

    public CustomAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Item getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_list, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.id_imagen);
            holder.titleView = convertView.findViewById(R.id.id_textoTitulo);
            holder.textView = convertView.findViewById(R.id.id_textoTexto);
            holder.radioButton = convertView.findViewById(R.id.id_radioButton);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item currentItem = getItem(position);

        holder.imageView.setImageResource(currentItem.getId_imagen());
        holder.radioButton.setChecked(currentItem.isFavorito());
        holder.titleView.setText(currentItem.getTitulo());
        holder.textView.setText(currentItem.getTexto());

        holder.radioButton.setOnClickListener(v -> {
            currentItem.setFavorito(!currentItem.isFavorito());
            ((OnClickListener) context).onClick();
        });

        return convertView;
    }

    public static class ViewHolder {
        private ImageView imageView;
        private RadioButton radioButton;
        private TextView titleView;
        private TextView textView;
    }

}