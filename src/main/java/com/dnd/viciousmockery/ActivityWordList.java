package com.dnd.viciousmockery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityWordList extends AppCompatActivity {

    private ListView _listView;
    private List<String> _baseNounList;
    private List<String> _baseAdjList;
    private Switch _switchWordType;
    private Activity _thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
    }



    @Override
    protected void onResume() {
        super.onResume();
        try {
            _thisActivity = this;
            _listView = findViewById(R.id.listviewWords);
            _baseAdjList = getIntent().getStringArrayListExtra("ADJ_LIST");
            _baseNounList = getIntent().getStringArrayListExtra("NOUN_LIST");
            Button buttonClose = findViewById(R.id.buttonCancel);
            _switchWordType = findViewById(R.id.switchWordType);
            buttonClose.setOnClickListener(new CancelClickListener());
            _switchWordType.setOnCheckedChangeListener(new ChangeListListener());
            setList(false);
        }
        catch (Exception e){
            TextView error = findViewById(R.id.errorText);
            error.setText(e.getMessage());
            error.setVisibility(View.VISIBLE);
        }
    }

    public static void start(Context context, List<String> nounList, List<String> adjList){
        Intent intent = new Intent(context, ActivityWordList.class);
        intent.putStringArrayListExtra("NOUN_LIST", (ArrayList<String>) nounList);
        intent.putStringArrayListExtra("ADJ_LIST", (ArrayList<String>) adjList);
        context.startActivity(intent);
    }

    public boolean getSwitchSetting() {
        return _switchWordType.isChecked();
    }

    private class CancelClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            MainActivity.start(_thisActivity);
        }
    }

    public void setList(boolean noun){
        try {
            DatabaseHelper helper = new DatabaseHelper(this);
            List<WordItem> wordList = new ArrayList<>();
            if(noun){
                List<Noun> nounList = helper.getAllCustomNouns(_baseNounList);
                if(nounList != null && nounList.size() > 0){
                    for(Noun n : nounList){
                        WordItem item = new WordItem(n.Noun, n.Compliment, _thisActivity);
                        wordList.add(item);
                    }
                }
            }
            else {
                List<Adjective> adjList = helper.getAllCustomAdjectives(_baseAdjList);
                if(adjList != null && adjList.size() > 0){
                    for(Adjective adj : adjList){
                        WordItem item = new WordItem(adj.Adjective, adj.Compliment, _thisActivity);
                        wordList.add(item);
                    }
                }
            }
            ListAdapter adapter = new ListAdapter(this, R.layout.word_item, wordList);
            _listView.setAdapter(adapter);
        }
        catch (Exception e){

        }

    }

    private class ChangeListListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            setList(isChecked);
        }
    }
}
