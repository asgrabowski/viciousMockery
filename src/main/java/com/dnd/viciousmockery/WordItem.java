package com.dnd.viciousmockery;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class WordItem implements IWordItem{

    private TextView _textviewWord;
    private Button _buttonDelete;
    private Context _context;
    private String _word;
    private boolean _compliment;

    public WordItem(String word, boolean compliment, Context context){
        _word = word;
        _context = context;
        _compliment = compliment;
    }

    @Override
    public View getView(LayoutInflater inflater, View view) {
        view = inflater.inflate(R.layout.word_item, null);
        _textviewWord = view.findViewById(R.id.textviewWord);
        TextView compliment = view.findViewById(R.id.textviewCompliment);
        _buttonDelete = view.findViewById(R.id.buttonDelete);
        if(_word!= null){
            _textviewWord.setText(_word);
            compliment.setText(_compliment ? "Compliment" : "Insult");
        }
        _buttonDelete.setOnClickListener(new DeleteListener(_context));
        return view;
    }

    private class DeleteListener implements View.OnClickListener {

        private Context _context;

        public DeleteListener(Context context){
            _context = context;
        }

        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(_context);

            builder.setMessage("Are you sure you want to delete this word?")
                    .setTitle("Remove Word")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseHelper helper = new DatabaseHelper(_context);
                            boolean noun = ((ActivityWordList)_context).getSwitchSetting();
                            helper.deleteWord(_word, noun);
                            if(_context instanceof ActivityWordList)
                                ((ActivityWordList) _context).setList(noun);
                            Toast.makeText(_context, "Removed Word", Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
