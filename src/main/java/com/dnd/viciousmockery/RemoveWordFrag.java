//package com.dnd.viciousmockery;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import androidx.fragment.app.DialogFragment;
//
//class RemoveWordFrag extends DialogFragment {
//
//    private RemoveWordFrag _thisFrag;
//    private Button _cancelButton;
//    private Button _removeButton;
//    private Spinner _spinnerType;
//    private Spinner _spinnerWord;
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.remove_word_frag, container, false);
//        _thisFrag = this;
//        _cancelButton = view.findViewById(R.id.buttonCancel);
//        _removeButton = view.findViewById(R.id.buttonSubmit);
//        _spinnerType = view.findViewById(R.id.spinnerType);
//        _spinnerWord = view.findViewById(R.id.spinnerWord);
//        _removeButton.setOnClickListener(new RemoveListener());
//        _cancelButton.setOnClickListener(new CancelListener());
//        _spinnerType.setOnItemSelectedListener(new SelectTypeListener());
////        ButterKnife.bind(this, view);
//        return view;
//    }
//
//    private class RemoveListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//
//        }
//    }
//
//    private class CancelListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//            _thisFrag.dismiss();
//        }
//    }
//
//    private class SelectTypeListener implements AdapterView.OnItemSelectedListener{
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    }
//}
