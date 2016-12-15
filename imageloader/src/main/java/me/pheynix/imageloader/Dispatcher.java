package me.pheynix.imageloader;

import android.os.Handler;
import android.os.Message;

/**
 * 分发结果
 * Created by dujigui on 12/15/16.
 */

class Dispatcher extends Handler{
    static final int TASK_SUCCESS = 0x01;

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        switch (msg.what) {
            case TASK_SUCCESS:
                Task task = (Task) msg.obj;
                task.getTarget().setImageBitmap(task.getResult());
                break;
        }
    }
}
