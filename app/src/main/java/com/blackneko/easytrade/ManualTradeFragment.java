package com.blackneko.easytrade;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ManualTradeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManualTradeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ManualTradeViewModel viewModel;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View View;

    public ManualTradeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ManualTradeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ManualTradeFragment newInstance(String param1, String param2) {
        ManualTradeFragment fragment = new ManualTradeFragment();
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

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_mtrade, container, false);
        final TextInputEditText input1 = view.findViewById(R.id.texti1);
        final TextInputEditText input2 = view.findViewById(R.id.texti2);
        final TextInputEditText input3 = view.findViewById(R.id.texti3);
        final TextInputEditText input4 = view.findViewById(R.id.texti4);
        final TextView tview1 = view.findViewById(R.id.textVM1);
        final TextView tview2 = view.findViewById(R.id.textVM2);
        final TextView tview3 = view.findViewById(R.id.textVM3);
        final TextView tview4 = view.findViewById(R.id.textVM4);
        final SeekBar seekBar = view.findViewById(R.id.seekBar);

        viewModel = ViewModelProviders.of(this).get(ManualTradeViewModel.class);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                try {
                    viewModel.setMyProgressBar(String.valueOf(seekBar.getProgress()),
                            input1.getText().toString());
                }
                catch (Exception e){
                    Snackbar.make(view,"Verifique el precio de compra",Snackbar.LENGTH_SHORT).show();
                    seekBar.setProgress(0);
                }
                }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//Observer Progress Bar and input2
        final Observer<String> progressBarObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                input2.setText(s);
            }
        };
//Observer del boton Get
        final Observer<String[]> observer = new Observer<String[]>() {
            @Override
            public void onChanged(String[] manualTradeResult) {
                tview1.setText(manualTradeResult[0]);
                tview2.setText(manualTradeResult[1]);
                tview3.setText(manualTradeResult[2]);
                tview4.setText(manualTradeResult[3]);
            }
        };

        //Conectando observers

        viewModel.getMyProgressBar().observe(this, progressBarObserver);
        viewModel.getManualTradeArray().observe(this, observer);

        //Definiendo funcion del boton get

        view.findViewById(R.id.buttonGetM).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    viewModel.obtener(input1.getText().toString(), input2.getText().toString(),
                            input3.getText().toString(), input4.getText().toString());
                }
                catch (Exception e){
                    Snackbar.make(view,"Verifique los valores",Snackbar.LENGTH_SHORT).show();
                                  }
            }
        });
        view.findViewById(R.id.buttonSetC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                seekBar.setProgress(0);
                tview1.setText("");
                tview2.setText("");
                tview3.setText("");
                tview4.setText("");
                input1.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");

            }
        });

        return view;
    }
}