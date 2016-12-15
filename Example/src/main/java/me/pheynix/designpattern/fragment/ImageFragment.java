package me.pheynix.designpattern.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

import me.pheynix.designpattern.R;
import me.pheynix.designpattern.base.BaseFragment;
import me.pheynix.imageloader.ImageLoader;


public class ImageFragment extends BaseFragment implements View.OnClickListener {
    private ImageView imageView;
    private String[] images = new String[]{
            "http://ww2.sinaimg.cn/large/610dc034gw1farbzjliclj20u00u076w.jpg",
            "http://ww2.sinaimg.cn/large/610dc034gw1faq15nnc0xj20u00u0wlq.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1faoucp1idej20u011h0va.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1fanrdyaxi6j20u00k1ta9.jpg",
            "http://ww4.sinaimg.cn/large/610dc034gw1fac4t2zhwsj20sg0izahf.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1faaywuvd20j20u011gdli.jpg"
    };

    public static ImageFragment newInstance() {
        return new ImageFragment();
    }


    public ImageFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = (ImageView) find(R.id.iv_image);
        imageView.setOnClickListener(this);
        ImageLoader.getInstance().load(imageView, images[0]);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_image:
                Random random = new Random();
                int i = random.nextInt(images.length);
                ImageLoader.getInstance().load(imageView, images[i]);
                break;
        }
    }
}
