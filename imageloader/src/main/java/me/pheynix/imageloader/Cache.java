package me.pheynix.imageloader;

import android.graphics.Bitmap;

/**
 * 缓存抽象
 * Created by dujigui on 12/15/16.
 */

public interface Cache {
    void put(Bitmap bitmap, String url);
    Bitmap get(String url);
}
