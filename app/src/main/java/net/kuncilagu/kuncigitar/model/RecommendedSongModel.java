package net.kuncilagu.kuncigitar.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class RecommendedSongModel implements Serializable {
    public int image;
    public Drawable imageDrw;
    public String title;
    public String brief;

    public RecommendedSongModel(int image, String title) {
        this.image = image;
        this.title = title;
    }
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
