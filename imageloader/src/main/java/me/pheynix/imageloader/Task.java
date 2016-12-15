package me.pheynix.imageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * 一个下载任务
 * Created by dujigui on 12/15/16.
 */

interface Task {
    String getSource();

    Bitmap getResult();

    ImageView getTarget();

    void setSource(String url);

    void setResult(Bitmap bitmap);

    void setTarget(ImageView imageView);
}
