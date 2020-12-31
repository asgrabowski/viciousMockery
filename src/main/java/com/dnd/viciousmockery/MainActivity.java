package com.dnd.viciousmockery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView _textViewInsult;
    private List<String> _basicAdjInsultList;
    private List<String> _basicAdjComplimentList;
    private List<String> _basicNounInsultList;
    private List<String> _basicNounComplimentList;
    private Activity _thisActivity;

    public static void start(Context baseContext) {
        Intent intent = new Intent(baseContext, MainActivity.class);
        baseContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        createTables();
        _thisActivity = this;
        _textViewInsult = findViewById(R.id.textviewInsult);
        Button buttonGenerateInsult = findViewById(R.id.buttonGenerateInsult);
        Button buttonGenerateCompliment = findViewById(R.id.buttonGenerateCompliment);
        Button buttonAddWord = findViewById(R.id.buttonAddNewWord);
        Button buttonRemoveWord = findViewById(R.id.buttonRemoveWords);
        Button buttonViewList = findViewById(R.id.buttonViewList);
        _basicAdjInsultList = new ArrayList<>();
        _basicNounInsultList = new ArrayList<>();
        _basicAdjComplimentList = new ArrayList<>();
        _basicNounComplimentList = new ArrayList<>();
        fillAdjectiveInsultList();
        fillNounInsultList();
        fillNounComplimentsList();
        fillAdjectiveComplimentsList();
        buttonGenerateInsult.setOnClickListener(new GenerateInsultListener(this));
        buttonGenerateCompliment.setOnClickListener(new GenerateComplimentListener(this));
        buttonAddWord.setOnClickListener(new AddWordListener());
        buttonRemoveWord.setOnClickListener(new RemoveWordListener(this));
        buttonViewList.setOnClickListener(new GoToListListener(this));
    }


    private void fillAdjectiveInsultList(){
        _basicAdjInsultList.add("Silly");
        _basicAdjInsultList.add("Stinky");
        _basicAdjInsultList.add("Slimy");
        _basicAdjInsultList.add("Hairless");
        _basicAdjInsultList.add("Peerless");
        _basicAdjInsultList.add("Shameful");
        _basicAdjInsultList.add("Blubbering");
        _basicAdjInsultList.add("Smelly");
        _basicAdjInsultList.add("Foul");
        _basicAdjInsultList.add("Revolting");
        _basicAdjInsultList.add("Disgusting");
        _basicAdjInsultList.add("Immoral");
        _basicAdjInsultList.add("Repugnant");
        _basicAdjInsultList.add("Repulsive");
        _basicAdjInsultList.add("Wicked");
        _basicAdjInsultList.add("Grimy");
        _basicAdjInsultList.add("Awful");
        _basicAdjInsultList.add("Dreadful");
        _basicAdjInsultList.add("Ghastly");
        _basicAdjInsultList.add("Filthy");
        _basicAdjInsultList.add("Loathsome");
        _basicAdjInsultList.add("Nauseating");
        _basicAdjInsultList.add("Sickening");
        _basicAdjInsultList.add("Unclean");
        _basicAdjInsultList.add("Rancid");
        _basicAdjInsultList.add("Unpalatable");
        _basicAdjInsultList.add("Unwashed");
        _basicAdjInsultList.add("Stupid");
        _basicAdjInsultList.add("Despicable");
        _basicAdjInsultList.add("Obscene");
        _basicAdjInsultList.add("Skanky");
        _basicAdjInsultList.add("Putrid");
        _basicAdjInsultList.add("Hideous");
        _basicAdjInsultList.add("Thick");
        _basicAdjInsultList.add("Dumb");
        _basicAdjInsultList.add("Fat");
        _basicAdjInsultList.add("Paralyzed");
        _basicAdjInsultList.add("Stinking");
        _basicAdjInsultList.add("Racist");
        _basicAdjInsultList.add("Troublesome");
        _basicAdjInsultList.add("Fragrant");
        _basicAdjInsultList.add("Utter");
        _basicAdjInsultList.add("Disgraceful");
        _basicAdjInsultList.add("Monstrous");
        _basicAdjInsultList.add("Gruesome");
        _basicAdjInsultList.add("Evil");
        _basicAdjInsultList.add("Freakish");
        _basicAdjInsultList.add("Mutated");
        _basicAdjInsultList.add("Frightening");
        _basicAdjInsultList.add("Trembling");
        _basicAdjInsultList.add("Yellow");
        _basicAdjInsultList.add("Gutless");
        _basicAdjInsultList.add("Spineless");
        _basicAdjInsultList.add("Cowardly");
        _basicAdjInsultList.add("Shy");
        _basicAdjInsultList.add("Scared");
        _basicAdjInsultList.add("Bashful");
        _basicAdjInsultList.add("Nervous");
        _basicAdjInsultList.add("Cringey");
        _basicAdjInsultList.add("Candy-assed");
        _basicAdjInsultList.add("Wet");
        _basicAdjInsultList.add("Sticky");
        _basicAdjInsultList.add("Sloppy");
        _basicAdjInsultList.add("Tacky");
        _basicAdjInsultList.add("Simple");
        _basicAdjInsultList.add("Amateur");
        _basicAdjInsultList.add("Unskilled");
        _basicAdjInsultList.add("Clumsy");
        _basicAdjInsultList.add("Inept");
        _basicAdjInsultList.add("Incompetent");
        _basicAdjInsultList.add("Useless");
        _basicAdjInsultList.add("Blundering");
        _basicAdjInsultList.add("Crude");
        _basicAdjInsultList.add("Outstanding");
        _basicAdjInsultList.add("Exceptional");
        _basicAdjInsultList.add("Professional");
        _basicAdjInsultList.add("Magnificent");
        _basicAdjInsultList.add("Drooling");
        _basicAdjInsultList.add("Brainless");
        _basicAdjInsultList.add("Lobotomized");
        _basicAdjInsultList.add("Remarkable");
        _basicAdjInsultList.add("Unequaled");
        _basicAdjInsultList.add("Extraordinary");
        _basicAdjInsultList.add("Phenomenal");
        _basicAdjInsultList.add("Special");
        _basicAdjInsultList.add("Atypical");
        _basicAdjInsultList.add("Abnormal");
        _basicAdjInsultList.add("Unrivaled");
        _basicAdjInsultList.add("Average");
        _basicAdjInsultList.add("Ordinary");
        _basicAdjInsultList.add("Uninspired");
        _basicAdjInsultList.add("Second-rate");
        _basicAdjInsultList.add("Bland");
        _basicAdjInsultList.add("Intolerable");
        _basicAdjInsultList.add("Forgettable");
        _basicAdjInsultList.add("Lackluster");
        _basicAdjInsultList.add("Hopeless");
        _basicAdjInsultList.add("Expert");
        _basicAdjInsultList.add("Below average");
        _basicAdjInsultList.add("Droopy");
        _basicAdjInsultList.add("Sour");
        _basicAdjInsultList.add("Bitter");
        _basicAdjInsultList.add("Salty");
        _basicAdjInsultList.add("Fatty");
        _basicAdjInsultList.add("Diseased");
        _basicAdjInsultList.add("Leathery");
        _basicAdjInsultList.add("Lumpy");
        _basicAdjInsultList.add("Sweaty");
        _basicAdjInsultList.add("Moist");
        _basicAdjInsultList.add("Soggy");
        _basicAdjInsultList.add("Damp");
        _basicAdjInsultList.add("Clammy");
        _basicAdjInsultList.add("Dry");
        _basicAdjInsultList.add("Inbred");
        _basicAdjInsultList.add("Tubby");
        _basicAdjInsultList.add("Shitty");
        _basicAdjInsultList.add("Chunky");
        _basicAdjInsultList.add("Crunchy");
        _basicAdjInsultList.add("Rotten");
        _basicAdjInsultList.add("Good-for-nothing");
        _basicAdjInsultList.add("Wimpy");
        _basicAdjInsultList.add("Weak");
        _basicAdjInsultList.add("Mother-fucking");
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.fillBaseAdjectives(_basicAdjInsultList, false);
    }

    private void fillAdjectiveComplimentsList(){
        _basicAdjComplimentList.add("Magnificent");
        _basicAdjComplimentList.add("Sexy");
        _basicAdjComplimentList.add("Beautiful");
        _basicAdjComplimentList.add("Strong");
        _basicAdjComplimentList.add("Brilliant");
        _basicAdjComplimentList.add("Perfect");
        _basicAdjComplimentList.add("Stunning");
        _basicAdjComplimentList.add("Pretty");
        _basicAdjComplimentList.add("Handsome");
        _basicAdjComplimentList.add("Lovely");
        _basicAdjComplimentList.add("Graceful");
        _basicAdjComplimentList.add("Exquisite");
        _basicAdjComplimentList.add("Ravishing");
        _basicAdjComplimentList.add("Irresistible");
        _basicAdjComplimentList.add("Elegant");
        _basicAdjComplimentList.add("Impeccable");
        _basicAdjComplimentList.add("Alluring");
        _basicAdjComplimentList.add("Attractive");
        _basicAdjComplimentList.add("Charming");
        _basicAdjComplimentList.add("Glamorous");
        _basicAdjComplimentList.add("Powerful");
        _basicAdjComplimentList.add("Spirited");
        _basicAdjComplimentList.add("Fit");
        _basicAdjComplimentList.add("Brawny");
        _basicAdjComplimentList.add("Athletic");
        _basicAdjComplimentList.add("Jacked");
        _basicAdjComplimentList.add("Rugged");
        _basicAdjComplimentList.add("Burly");
        _basicAdjComplimentList.add("Buff");
        _basicAdjComplimentList.add("Fierce");
        _basicAdjComplimentList.add("Warm");
        _basicAdjComplimentList.add("Honorable");
        _basicAdjComplimentList.add("Chivalrous");
        _basicAdjComplimentList.add("Polite");
        _basicAdjComplimentList.add("Noble");
        _basicAdjComplimentList.add("Peerless");
        _basicAdjComplimentList.add("Flawless");
        _basicAdjComplimentList.add("Faultless");
        _basicAdjComplimentList.add("Virtuous");
        _basicAdjComplimentList.add("Exemplary");
        _basicAdjComplimentList.add("Ideal");
        _basicAdjComplimentList.add("Righteous");
        _basicAdjComplimentList.add("Voluptuous");
        _basicAdjComplimentList.add("Radiant");
        _basicAdjComplimentList.add("Stellar");
        _basicAdjComplimentList.add("Masterful");
        _basicAdjComplimentList.add("Professional");
        _basicAdjComplimentList.add("Remarkable");
        _basicAdjComplimentList.add("Extraordinary");
        _basicAdjComplimentList.add("Exceptional");
        _basicAdjComplimentList.add("Amazing");
        _basicAdjComplimentList.add("Astonishing");
        _basicAdjComplimentList.add("Astounding");
        _basicAdjComplimentList.add("Incredible");
        _basicAdjComplimentList.add("Wonderful");
        _basicAdjComplimentList.add("Sensational");
        _basicAdjComplimentList.add("Unbelievable");
        _basicAdjComplimentList.add("Unforgettable");
        _basicAdjComplimentList.add("Eye-catching");
        _basicAdjComplimentList.add("Fantastic");
        _basicAdjComplimentList.add("Impressive");
        _basicAdjComplimentList.add("Terrific");
        _basicAdjComplimentList.add("Unreal");
        _basicAdjComplimentList.add("Talented");
        _basicAdjComplimentList.add("Admirable");
        _basicAdjComplimentList.add("Glorious");
        _basicAdjComplimentList.add("Epic");
        _basicAdjComplimentList.add("Fabled");
        _basicAdjComplimentList.add("Precious");
        _basicAdjComplimentList.add("Adorable");
        _basicAdjComplimentList.add("One of a kind");
        _basicAdjComplimentList.add("Elite");
        _basicAdjComplimentList.add("Unrivaled");
        _basicAdjComplimentList.add("Unparalleled");
        _basicAdjComplimentList.add("Unequaled");
        _basicAdjComplimentList.add("Transcendent");
        _basicAdjComplimentList.add("Supreme");
        _basicAdjComplimentList.add("Gifted");
        _basicAdjComplimentList.add("Deadly");
        _basicAdjComplimentList.add("Highbrow");
        _basicAdjComplimentList.add("Magical");
        _basicAdjComplimentList.add("Mother-fucking");
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.fillBaseAdjectives(_basicAdjComplimentList, true);
    }

    private void fillNounComplimentsList(){
        _basicNounComplimentList.add("work of art");
        _basicNounComplimentList.add("beast");
        _basicNounComplimentList.add("beauty");
        _basicNounComplimentList.add("mother-fucker");
        _basicNounComplimentList.add("beast");
        _basicNounComplimentList.add("hunk");
        _basicNounComplimentList.add("soul");
        _basicNounComplimentList.add("creature");
        _basicNounComplimentList.add("individual");
        _basicNounComplimentList.add("gentleman");
        _basicNounComplimentList.add("maverick");
        _basicNounComplimentList.add("diety");
        _basicNounComplimentList.add("god");
        _basicNounComplimentList.add("goddess");
        _basicNounComplimentList.add("prince");
        _basicNounComplimentList.add("warrior");
        _basicNounComplimentList.add("champion");
        _basicNounComplimentList.add("phenom");
        _basicNounComplimentList.add("son-of-a-bitch");
        _basicNounComplimentList.add("sorceress");
        _basicNounComplimentList.add("hero");
        _basicNounComplimentList.add("legend");
        _basicNounComplimentList.add("boss");
        _basicNounComplimentList.add("scholar");
        _basicNounComplimentList.add("champ");
        _basicNounComplimentList.add("sport");
        _basicNounComplimentList.add("slugger");
        _basicNounComplimentList.add("milf");
        _basicNounComplimentList.add("conqueror");
        _basicNounComplimentList.add("myth");
        _basicNounComplimentList.add("star");
        _basicNounComplimentList.add("genius");
        _basicNounComplimentList.add("icon");
        _basicNounComplimentList.add("prodigy");
        _basicNounComplimentList.add("spectacle");
        _basicNounComplimentList.add("mastermind");
        _basicNounComplimentList.add("wizard");
        _basicNounComplimentList.add("angel");
        _basicNounComplimentList.add("jewel");
        _basicNounComplimentList.add("gem");
        _basicNounComplimentList.add("treasure");
        _basicNounComplimentList.add("saint");
        _basicNounComplimentList.add("darling");
        _basicNounComplimentList.add("savant");
        _basicNounComplimentList.add("artist");
        _basicNounComplimentList.add("brainbox");
        _basicNounComplimentList.add("alpha");
        _basicNounComplimentList.add("masterpiece");
        _basicNounComplimentList.add("diamond");
        _basicNounComplimentList.add("killer");
        _basicNounComplimentList.add("duelist");
        _basicNounComplimentList.add("swashbuckler");
        _basicNounComplimentList.add("crusader");
        _basicNounComplimentList.add("buccaneer");
        _basicNounComplimentList.add("lionheart");
        _basicNounComplimentList.add("luminary");
        _basicNounComplimentList.add("dignitary");
        _basicNounComplimentList.add("lion");
        _basicNounComplimentList.add("globetrotter");
        _basicNounComplimentList.add("pioneer");
        _basicNounComplimentList.add("innovator");
        _basicNounComplimentList.add("trailblazer");
        _basicNounComplimentList.add("pathfinder");
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.fillBaseNouns(_basicNounComplimentList, true);
    }

    private void fillNounInsultList(){
        _basicNounInsultList.add("buffoon");
        _basicNounInsultList.add("oaf");
        _basicNounInsultList.add("goose");
        _basicNounInsultList.add("fool");
        _basicNounInsultList.add("goat-fucker");
        _basicNounInsultList.add("cock-sucker");
        _basicNounInsultList.add("child");
        _basicNounInsultList.add("dimwit");
        _basicNounInsultList.add("dunce");
        _basicNounInsultList.add("pervert");
        _basicNounInsultList.add("prick");
        _basicNounInsultList.add("blockhead");
        _basicNounInsultList.add("jackass");
        _basicNounInsultList.add("bonehead");
        _basicNounInsultList.add("schmuck");
        _basicNounInsultList.add("bozo");
        _basicNounInsultList.add("spud");
        _basicNounInsultList.add("dolt");
        _basicNounInsultList.add("idiot");
        _basicNounInsultList.add("ass");
        _basicNounInsultList.add("imbecile");
        _basicNounInsultList.add("dullard");
        _basicNounInsultList.add("fathead");
        _basicNounInsultList.add("muttonhead");
        _basicNounInsultList.add("dummy");
        _basicNounInsultList.add("knucklehead");
        _basicNounInsultList.add("cretin");
        _basicNounInsultList.add("moron");
        _basicNounInsultList.add("numbskull");
        _basicNounInsultList.add("goat");
        _basicNounInsultList.add("cow");
        _basicNounInsultList.add("ding-dong");
        _basicNounInsultList.add("lummox");
        _basicNounInsultList.add("meatball");
        _basicNounInsultList.add("putz");
        _basicNounInsultList.add("chowderhead");
        _basicNounInsultList.add("potato");
        _basicNounInsultList.add("vegetable");
        _basicNounInsultList.add("whale");
        _basicNounInsultList.add("slimeball");
        _basicNounInsultList.add("sissy");
        _basicNounInsultList.add("chicken");
        _basicNounInsultList.add("wimp");
        _basicNounInsultList.add("tomato");
        _basicNounInsultList.add("eggplant");
        _basicNounInsultList.add("puppy");
        _basicNounInsultList.add("mutant");
        _basicNounInsultList.add("raccoon");
        _basicNounInsultList.add("abortion");
        _basicNounInsultList.add("fetus");
        _basicNounInsultList.add("chickenshit");
        _basicNounInsultList.add("shithole");
        _basicNounInsultList.add("fuckhead");
        _basicNounInsultList.add("fuck-face");
        _basicNounInsultList.add("dope");
        _basicNounInsultList.add("slut");
        _basicNounInsultList.add("simpleton");
        _basicNounInsultList.add("ninny");
        _basicNounInsultList.add("amateur");
        _basicNounInsultList.add("ham");
        _basicNounInsultList.add("demon");
        _basicNounInsultList.add("stump");
        _basicNounInsultList.add("shitter");
        _basicNounInsultList.add("lump");
        _basicNounInsultList.add("tumor");
        _basicNounInsultList.add("growth");
        _basicNounInsultList.add("cyst");
        _basicNounInsultList.add("pile of excrement");
        _basicNounInsultList.add("mound of horseshit");
        _basicNounInsultList.add("cum puddle");
        _basicNounInsultList.add("cum bubble");
        _basicNounInsultList.add("bungler");
        _basicNounInsultList.add("butterfingers");
        _basicNounInsultList.add("poop licker");
        _basicNounInsultList.add("spunk guzzler");
        _basicNounInsultList.add("mouth breather");
        _basicNounInsultList.add("skank");
        _basicNounInsultList.add("baby");
        _basicNounInsultList.add("pumpkin");
        _basicNounInsultList.add("ball of dough");
        _basicNounInsultList.add("strawberry");
        _basicNounInsultList.add("cucumber");
        _basicNounInsultList.add("banana");
        _basicNounInsultList.add("fatty");
        _basicNounInsultList.add("cabbage");
        _basicNounInsultList.add("radish");
        _basicNounInsultList.add("yam");
        _basicNounInsultList.add("salad");
        _basicNounInsultList.add("sack of wine");
        _basicNounInsultList.add("onion");
        _basicNounInsultList.add("napkin");
        _basicNounInsultList.add("saltine");
        _basicNounInsultList.add("baguette");
        _basicNounInsultList.add("bread stick");
        _basicNounInsultList.add("bag of cats");
        _basicNounInsultList.add("bag of dicks");
        _basicNounInsultList.add("bag of socks");
        _basicNounInsultList.add("sock");
        _basicNounInsultList.add("cum rag");
        _basicNounInsultList.add("slob");
        _basicNounInsultList.add("rat");
        _basicNounInsultList.add("rodent");
        _basicNounInsultList.add("scoundrel");
        _basicNounInsultList.add("egg");
        _basicNounInsultList.add("hamster");
        _basicNounInsultList.add("lady-boy");
        _basicNounInsultList.add("boy-lady");
        _basicNounInsultList.add("toddler");
        _basicNounInsultList.add("skunk");
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.fillBaseNouns(_basicNounInsultList, false);
    }


    private class GenerateInsultListener implements View.OnClickListener{

        private Context mContext;

        public GenerateInsultListener(Context context){
            mContext = context;
        }

        @Override
        public void onClick(View v) {
            DatabaseHelper helper = new DatabaseHelper(mContext);
            int numberOfAdjectives = new Random().nextInt(2)+1;
            Adjective adjective1 = helper.getRandomInsultAdjective();
            Adjective adjective2 = null;
            Noun noun = helper.getRandomInsultNoun();
//            int randomAdjective1 = new Random().nextInt(helper.getAdjectiveTableSize())+1;
//            int randomAdjective2 = 0;
            if(numberOfAdjectives > 1){
                do {
                    adjective2 = helper.getRandomInsultAdjective();
//                    randomAdjective2 = new Random().nextInt(helper.getAdjectiveTableSize())+1;
                } while(adjective1.Adjective.trim().equals(adjective2.Adjective.trim()));
            }
//            int randomNoun = new Random().nextInt(helper.getNounTableSize())+1;
//            Noun noun = helper.getNoun(randomNoun);
//            Adjective adjective1 = helper.getAdjective(randomAdjective1);
            if(numberOfAdjectives == 1){
                _textViewInsult.setText(adjective1.Adjective+" "+noun.Noun+"!");
            }
            else {
//                Adjective adjective2 = helper.getAdjective(randomAdjective2);
                _textViewInsult.setText(adjective1.Adjective+", "+adjective2.Adjective.toLowerCase()+" "+noun.Noun+"!");
            }
        }
    }

    private class AddWordListener implements View.OnClickListener{


        public AddWordListener(){
        }

        @Override
        public void onClick(View v) {
            String FRAG_TAG = "FRAGADDWORD";
            androidx.fragment.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment prev = getSupportFragmentManager().findFragmentByTag(FRAG_TAG);
            if(prev != null) {
                ft.remove(prev);
                ft.addToBackStack(null);
            }
            DialogFragment dialog = new AddWordFrag();
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
            dialog.show(ft, FRAG_TAG);
        }
    }

    private class RemoveWordListener implements View.OnClickListener{

        Context mContext;

        public RemoveWordListener(Context context){
            mContext = context;
        }

        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

            builder.setMessage("Are you sure you want to remove all of your custom words?")
                    .setTitle("Remove Custom Words")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseHelper helper = new DatabaseHelper(mContext);
                            helper.removeAllWords();
                            helper = new DatabaseHelper(mContext);
                            helper.fillBaseNouns(_basicNounInsultList, false);
                            helper = new DatabaseHelper(mContext);
                            helper.fillBaseAdjectives(_basicAdjInsultList, false);
                            helper = new DatabaseHelper(mContext);
                            helper.fillBaseNouns(_basicNounComplimentList, true);
                            helper = new DatabaseHelper(mContext);
                            helper.fillBaseAdjectives(_basicAdjComplimentList, true);
                            Toast.makeText(mContext, "Removed Custom Words", Toast.LENGTH_LONG).show();
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

    private void createTables(){
        DatabaseHelper helper = new DatabaseHelper(this);
    }


    private class GenerateComplimentListener implements View.OnClickListener {

        private Context mContext;

        public GenerateComplimentListener(Context context){
            mContext = context;
        }

        @Override
        public void onClick(View v) {
            DatabaseHelper helper = new DatabaseHelper(mContext);
            Adjective adjective1 = helper.getRandomComplimentAdjective();
            Noun noun = helper.getRandomComplimentNoun();
            _textViewInsult.setText(adjective1.Adjective+" "+noun.Noun+"!");
        }
    }

    private class GoToListListener implements View.OnClickListener {
        public GoToListListener(MainActivity mainActivity) {

        }

        @Override
        public void onClick(View v) {
            List<String> totalNouns = new ArrayList<>();
            List<String> totalAdjs = new ArrayList<>();
            for(String s : _basicAdjComplimentList){
                totalAdjs.add(s);
            }
            for(String s : _basicAdjInsultList){
                totalAdjs.add(s);
            }
            for(String s : _basicNounComplimentList){
                totalNouns.add(s);
            }
            for(String s : _basicNounInsultList){
                totalNouns.add(s);
            }
            ActivityWordList.start(_thisActivity, totalNouns, totalAdjs);
        }
    }
}
