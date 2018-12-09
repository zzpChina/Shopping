package com.example.zzpcomputer.exercise;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class ProductAdapter extends ArrayAdapter {

    private int resourceId;
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        getItem(position);
        View view  = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        return view;
    }
}
