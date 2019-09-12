package ke.co.mariashops.myroommvvm;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class ItemsEntity
{
    @PrimaryKey(autoGenerate = true)
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
    public ItemsEntity(@NonNull String imageUrl, @NonNull String iconTitle) {
        this.imageUrl = imageUrl;
        this.iconTitle = iconTitle;
    }


    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    @NonNull
    public String getIconTitle() {
        return iconTitle;
    }


    public void setId(@NonNull String id) {
        this.id = id;
    }
}
