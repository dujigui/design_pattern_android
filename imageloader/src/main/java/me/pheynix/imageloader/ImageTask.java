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

    @Override
    public void setSource(String url) {
        this.source = url;
    }

    @Override
    public void setResult(Bitmap bitmap) {
        this.result = bitmap;
    }

    @Override
    public void setTarget(ImageView imageView) {
        this.target = imageView;
    }
}
