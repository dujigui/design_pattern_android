package me.pheynix.designpattern.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

/**
 * base fragment
 * Created by dujigui on 10/14/16.
 */
public abstract class BaseFragment extends Fragment {
    protected String toolbarTitle;

    /**
     * 将{@link Toolbar}设置为{@link AppCompatActivity}的ActionBar
     */
    public void setupToolbar(Toolbar toolbar){
        try {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }catch (Exception e){
            e.printStackTrace();
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    public final void setActivityTitle(@NonNull String title) {
        try {
            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

            if (actionBar != null) {
                actionBar.setTitle(toolbarTitle = title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden && !TextUtils.isEmpty(toolbarTitle)) {
            setActivityTitle(toolbarTitle);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(toolbarTitle)) {
            setActivityTitle(toolbarTitle);
        }
    }


    public View find(int resId) {
        return getView() == null ? null : getView().findViewById(resId);
    }

}
