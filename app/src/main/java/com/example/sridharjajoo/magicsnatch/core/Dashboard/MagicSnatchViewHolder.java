package com.example.sridharjajoo.magicsnatch.core.Dashboard;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.sridharjajoo.magicsnatch.R;

public class MagicSnatchViewHolder extends RecyclerView.ViewHolder {

    public ImageView furnitureImg;

    public MagicSnatchViewHolder(View itemView) {
        super(itemView);
        furnitureImg = (ImageView) itemView.findViewById(R.id.furniture_image);
    }
}
