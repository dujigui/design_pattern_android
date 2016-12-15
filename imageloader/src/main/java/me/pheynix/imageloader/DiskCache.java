package me.pheynix.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 磁盘缓存
 * Created by dujigui on 12/15/16.
 */

class DiskCache implements Cache {
    private File cacheDir;
    private KeyGenerator keyGenerator = new MD5Key();

    DiskCache() {
        File externalDir = Environment.getExternalStorageDirectory();
        cacheDir = new File(externalDir, ".image_cache");
        if (!cacheDir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            cacheDir.mkdir();
        }
    }

    @Override
    public void put(Bitmap bitmap, String url) {
        File file = new File(cacheDir, keyGenerator.generate(url));
        if (file.exists()) {
            return;
        }else {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Bitmap get(String url) {
        File file = new File(cacheDir, keyGenerator.generate(url));
        return file.exists() ? BitmapFactory.decodeFile(file.getPath()) : null;
    }
}
