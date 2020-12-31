package com.dnd.viciousmockery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class AddWordFrag extends DialogFragment {

    private Button _cancelButton;
    private Button _submitButton;
    private Spinner _spinnerType;
    private EditText _editTextNewWord;
    private AddWordFrag _thisFrag;
    private Switch _switchCompliment;


    static AddWordFrag newInstance() {
        AddWordFrag f = new AddWordFrag();
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_word_frag, container, false);
        _thisFrag = this;
        _cancelButton = view.findViewById(R.id.buttonCancel);
        _submitButton = view.findViewById(R.id.buttonSubmit);
        _spinnerType = view.findViewById(R.id.spinnerType);
        _editTextNewWord = view.findViewById(R.id.editTextNewWord);
        _switchCompliment = view.findViewById(R.id.switchCompliment);
        _submitButton.setOnClickListener(new SubmitListener());
        _cancelButton.setOnClickListener(new CancelListener());
//        ButterKnife.bind(this, view);
        return view;
    }

    private class SubmitListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(_editTextNewWord.getText().toString().trim().length()>0){
                String type = _spinnerType.getSelectedItem().toString();
                boolean submitted = false;
                if(type.equals("Adjective")){
                    DatabaseHelper helper = new DatabaseHelper(getActivity());
                    String newWord = _editTextNewWord.getText().toString().trim();
                    newWord = newWord.toLowerCase();
                    if(newWord.length()>1){
                        newWord = newWord.substring(0, 1).toUpperCase()+newWord.substring(1);
                    }
                    else {
                        newWord = newWord.toUpperCase();
                    }
                    submitted = helper.addAdjective(new Adjective(newWord, _switchCompliment.isChecked()));
                }else {
                    DatabaseHelper helper = new DatabaseHelper(getActivity());
                    String newWord = _editTextNewWord.getText().toString().trim().toLowerCase();
                    submitted = helper.addNoun(new Noun(newWord,  _switchCompliment.isChecked()));
                }
                if(submitted)
                    Toast.makeText(getActivity(), "Successfully Added", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(), "Submission Failed. Entry May Already Be Saved.", Toast.LENGTH_LONG).show();
                _thisFrag.dismiss();
            }
        }
    }

    private class CancelListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            _thisFrag.dismiss();
        }
    }
}
