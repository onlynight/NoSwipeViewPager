package com.github.onlynight.noswipeviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lion on 2017/3/14.
 */

public class DemoFragment extends Fragment {

    private TextView textTitle;

    private String title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View contentView = inflater.inflate(R.layout.fragment_demo, container, false);
        textTitle = (TextView) contentView.findViewById(R.id.textTitle);
        if (title != null) {
            textTitle.setText(title);
        }
        return contentView;
    }

    public void updateTitle(String title) {
        if (textTitle != null) {
            textTitle.setText(title);
        }
        this.title = title;
    }
}
