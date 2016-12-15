package me.pheynix.designpattern.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.pheynix.designpattern.R;
import me.pheynix.designpattern.fragment.ImageFragment;

public class ImageActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, ImageActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_container, ImageFragment.newInstance(), ImageFragment.class.getName())
                .commit();
    }
}
