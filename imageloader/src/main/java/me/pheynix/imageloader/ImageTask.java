package me.pheynix.imageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * 下载任务
 * Created by dujigui on 12/15/16.
 */

class ImageTask implements Task {
    String source;
    Bitmap result;
    ImageView target;

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public Bitmap getResult() {
        return result;
    }

    @Override
    public ImageView getTarget() {
        return target;
    }
}
