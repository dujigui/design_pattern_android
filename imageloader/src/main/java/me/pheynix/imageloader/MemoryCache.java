package me.pheynix.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 内存缓存
 * Created by dujigui on 12/15/16.
 */

class MemoryCache implements Cache {
    private LruCache<String, Bitmap> lruCache = new CacheContainer();
    private KeyGenerator keyGenerator = new MD5Key();

    @Override
    public void put(Bitmap bitmap, String url) {
        lruCache.put(keyGenerator.generate(url), bitmap);
    }

    @Override
    public Bitmap get(String url) {
        return lruCache.get(keyGenerator.generate(url));
    }


    private class CacheContainer extends LruCache<String, Bitmap> {
        CacheContainer() {
            this((int) (Runtime.getRuntime().maxMemory() / 1024));
        }

        CacheContainer(int maxSize) {
            super(maxSize);
        }

        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getRowBytes() * value.getHeight() / 1024;
        }
    }
}
