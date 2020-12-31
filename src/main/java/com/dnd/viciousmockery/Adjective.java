package com.dnd.viciousmockery;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Adjectives")
public class Adjective {

    public Adjective(String adjective, boolean compliment){
        Adjective = adjective;
        Compliment = compliment;
    }

    public Adjective(){

    }

    @DatabaseField (columnName = "id", generatedId = true, allowGeneratedIdInsert = true)
    public int Id;

    @DatabaseField (columnName = "adjective")
    public String Adjective;

    @DatabaseField (columnName = "compliment")
    public boolean Compliment;
}
