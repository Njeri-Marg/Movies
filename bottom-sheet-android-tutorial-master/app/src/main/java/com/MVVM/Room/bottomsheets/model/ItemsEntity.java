package com.thetechnocafe.Room.bottomsheets.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;



@Entity
public class ItemsEntity  {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public String id;


    @NonNull
    @ColumnInfo(name = "imageUrl")
    private String imageUrl;

    @NonNull
    @ColumnInfo(name = "iconTitle")
    private String iconTitle;


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    @NonNull
    public String getIconTitle() {
        return iconTitle;
    }

    public ItemsEntity(String id, String imageUrl, String iconTitle)
    {
        this.id = id;
        this.imageUrl = imageUrl;
        this.iconTitle = iconTitle;
    }



    @Override
    public String toString() {
        return "ItemsEntity{" +
                "id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", iconTitle='" + iconTitle + '\'' +
                '}';
    }
}
