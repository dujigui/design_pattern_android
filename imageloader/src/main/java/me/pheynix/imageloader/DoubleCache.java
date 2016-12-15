package me.pheynix.imageloader;

import android.graphics.Bitmap;

/**
 * 缓存
 * Created by dujigui on 12/15/16.
 */

class DoubleCache implements Cache {
    private Cache memoryCache = new MemoryCache();
    private Cache diskCache = new DiskCache();

    @Override
    public void put(Bitmap bitmap, String url) {
        memoryCache.put(bitmap, url);
        diskCache.put(bitmap, url);
    }

    @Override
    public Bitmap get(String url) {
        Bitmap result = memoryCache.get(url);
        if (result == null) {
            result = diskCache.get(url);
        }
        return result;
    }
}
