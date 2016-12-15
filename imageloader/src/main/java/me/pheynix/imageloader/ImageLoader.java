package me.pheynix.imageloader;

import android.graphics.Bitmap;
import android.os.Message;
import android.widget.ImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 加载图片
 * Created by dujigui on 12/15/16.
 */

public class ImageLoader {
    private static final  Object LOCK = new Object();
    private static volatile  ImageLoader INSTANCE = null;
    private Loader loader = new HttpLoader();
    private Cache cache = new DoubleCache();
    private ExecutorService services = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private Dispatcher dispatcher = new Dispatcher();

    public static ImageLoader getInstance(){
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ImageLoader();
                }
            }
        }
        return INSTANCE;
    }

    private ImageLoader() {
    }

    public void setLoader(Loader loader){
        this.loader = loader;
    }

    public void setCache(Cache cache){
        this.cache = cache;
    }

    public void load(final ImageView imageView, final String url){
        final ImageTask task = new ImageTask();
        task.source = url;
        task.target = imageView;

        imageView.setTag(url);
        services.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap result = null;
                if (cache != null) {
                    result = cache.get(url);
                }

                if (result == null && loader != null) {
                    result = loader.get(url);
                }

                if (result != null && url.equals(imageView.getTag())) {
                    cache.put(result, url);
                    task.result = result;
                    Message msg = dispatcher.obtainMessage(Dispatcher.TASK_SUCCESS, task);
                    dispatcher.sendMessage(msg);
                }
            }
        });
    }
}
