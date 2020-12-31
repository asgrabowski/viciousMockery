package com.dnd.viciousmockery;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Nouns")
public class Noun {

    public Noun(String noun, boolean compliment){
        Noun = noun;
        Compliment = compliment;
    }

    public Noun(){

    }

    @DatabaseField (columnName = "id", generatedId = true, allowGeneratedIdInsert = true)
    public int Id;

    @DatabaseField (columnName = "noun")
    public String Noun;

    @DatabaseField (columnName = "compliment")
    public boolean Compliment;
}
