package com.example.lab6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Fragment_Leftb2 extends Fragment {
    Button btn1;
    EditText editText;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leftb2, container, false);
        btn1 = view.findViewById(R.id.buttonupdate);
        editText = view.findViewById(R.id.editTextTextPersonName);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_Right fragment_right = (Fragment_Right)getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_rightb2);
                fragment_right.textView.setText(editText.getText().toString());
            }
        });
        return view;
    }
}
