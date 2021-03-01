package com.csy6.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class WinFragment extends Fragment {
    private static final String WIN_NAME ="Admin";

    private static final String ARG_SCORES = "scores";
    private static final String ARG_NAME = "uname";


    public WinFragment() {
        // Required empty public constructor

    }


    public static WinFragment newInstance(String name, String scores) {
        WinFragment fragment = new WinFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_SCORES, scores);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_win, container, false);
        String name = getArguments().getString(ARG_NAME);
        String score = getArguments().getString(ARG_SCORES);
        TextView tv_Name = v.findViewById(R.id.tv_win);
        TextView tv_Score = v.findViewById(R.id.tv_scores_win);
        if(WIN_NAME.equals(name)){
            tv_Name.setText("You win!!!");
        } else {
            tv_Name.setText("You loose!!!");
        }
        tv_Score.setText(score);
        Button button = v.findViewById(R.id.btn_win);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return v;
    }
}