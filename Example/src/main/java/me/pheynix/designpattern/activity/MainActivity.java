package me.pheynix.designpattern.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.pheynix.designpattern.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLoadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoadImage = (Button) findViewById(R.id.btn_load_image);

        btnLoadImage.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_load_image:
                ImageActivity.start(this);
                break;
        }
    }
}
