package com.blackneko.easytrade;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;


public class GridBotFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    GridBotViewModel viewModel;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GridBotFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GridBotFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GridBotFragment newInstance(String param1, String param2) {
        GridBotFragment fragment = new GridBotFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View gridBotView = inflater.inflate(R.layout.fragment_gbot, container, false);
        viewModel = ViewModelProviders.of(this).get(GridBotViewModel.class);
        final TextInputEditText inputgb1 = gridBotView.findViewById(R.id.textg1);
        final TextInputEditText inputgb2 = gridBotView.findViewById(R.id.textg2);
        final TextInputEditText inputgb3 = gridBotView.findViewById(R.id.textg3);
        final TextInputEditText inputgb4 = gridBotView.findViewById(R.id.textg4);
        final TextView tv1 = gridBotView.findViewById(R.id.textVG1);
        final TextView tv2 = gridBotView.findViewById(R.id.textVG2);
        final TextView tv3 = gridBotView.findViewById(R.id.textVG3);
        final TextView tv4 = gridBotView.findViewById(R.id.textVG4);
        final TextView tv5 = gridBotView.findViewById(R.id.textVG5);
        final TextView tv6 = gridBotView.findViewById(R.id.textVG6);

        Button btshow = gridBotView.findViewById(R.id.btshow);

        btshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    viewModel.setGridBotArray(inputgb1.getText().toString(), inputgb2.getText().toString()
                            , inputgb3.getText().toString(), inputgb4.getText().toString());
                }
                catch (Exception e){
                    Snackbar.make(view,"Verifique los valores",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        final Observer<String[]> myObserver = new Observer<String[]>() {
            @Override
            public void onChanged(String[] strings) {
                tv1.setText(strings[0]);
                tv2.setText(strings[1]);
                tv3.setText(strings[2]);
                tv4.setText(strings[3]);
                tv5.setText(strings[4]);
                tv6.setText(strings[5]);
            }

        };
        viewModel.getGridBotArray().observe(getViewLifecycleOwner(),myObserver);
        gridBotView.findViewById(R.id.buttonclean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv1.setText("");
                tv2.setText("");
                tv3.setText("");
                tv4.setText("");
                tv5.setText("");
                tv6.setText("");
                inputgb1.setText("");
                inputgb2.setText("");
                inputgb3.setText("");
                inputgb4.setText("");

            }
        });
        return gridBotView;
    }
}


