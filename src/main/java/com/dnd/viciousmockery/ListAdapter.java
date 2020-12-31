package com.dnd.viciousmockery;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class ListAdapter extends ArrayAdapter<WordItem> {

    private LayoutInflater _inflater;

    public ListAdapter(@NonNull Context context, int resource, List<WordItem> items) {
        super(context, 0, items);
        _inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = getItem(position).getView(_inflater, convertView);
        return view;
    }
}
