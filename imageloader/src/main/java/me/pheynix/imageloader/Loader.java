package me.pheynix.imageloader;

import android.graphics.Bitmap;

/**
 * 加载器抽象
 * Created by dujigui on 12/15/16.
 */

public interface Loader {
    Bitmap get(String url);
}
