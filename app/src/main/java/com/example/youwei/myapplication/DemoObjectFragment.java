package com.example.youwei.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by YouWei on 2016/7/21.
 */
public class DemoObjectFragment extends Fragment {
    public static final String ARG_OBJECT = "object";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection_object, container, false);
        Bundle args = getArguments();
        TextView tv = (TextView) view.findViewById(R.id.text1);
        tv.setText(Integer.toString(args.getInt(ARG_OBJECT)));
        return view;
    }
}
