package com.example.sridharjajoo.magicsnatch.core.Dashboard;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sridharjajoo.magicsnatch.R;

import java.util.ArrayList;

public class MagicSnatchFurnitureAdapter extends RecyclerView.Adapter<MagicSnatchViewHolder> {

    private ArrayList<Drawable> furnitureList;

    public MagicSnatchFurnitureAdapter(ArrayList<Drawable> furnitureList) {
        this.furnitureList = furnitureList;
    }

    @NonNull
    @Override
    public MagicSnatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.furnitureitem, parent, false);
        return new MagicSnatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MagicSnatchViewHolder holder, int position) {
        Drawable currentImage = furnitureList.get(position);
        holder.furnitureImg.setImageDrawable(currentImage);
    }

    @Override
    public int getItemCount() {
        return furnitureList.size();
    }
}
