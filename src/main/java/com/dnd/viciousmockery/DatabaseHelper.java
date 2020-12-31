package com.dnd.viciousmockery;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private Context _context;
    private Dao<Noun, Integer> _nounDao                                         = null;
    private Dao<Adjective, Integer> _adjectiveDao                               = null;

    public DatabaseHelper(Context context) {
        super(context, "viciousmockery.db", null, 5);
        _context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        createDatabases(connectionSource);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        createDatabases(connectionSource);
        Cursor cursor = database.rawQuery("SELECT * FROM Adjectives", null); // grab cursor for all data
        int deleteStateColumnIndex = cursor.getColumnIndex("compliment");  // see if the column is there
        if (deleteStateColumnIndex < 0) {
            // missing_column not there - add it
            database.execSQL("ALTER TABLE Adjectives ADD COLUMN compliment INTEGER");
            database.execSQL("ALTER TABLE Nouns ADD COLUMN compliment INTEGER");        }
    }

    @Override
    public void close() {
        _nounDao = null;
        _adjectiveDao = null;

        DaoManager.clearCache();
        super.close();
    }

    private void createDatabases(ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Adjective.class);
            TableUtils.createTableIfNotExists(connectionSource, Noun.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Noun, Integer> getNounDao() throws SQLException{
        if (_nounDao == null) {
            _nounDao = getDao(Noun.class);
        }
        return _nounDao;
    }

    public Dao<Adjective, Integer> getAdjectiveDao() throws SQLException{
        if (_adjectiveDao == null) {
            _adjectiveDao = getDao(Adjective.class);
        }
        return _adjectiveDao;
    }

    public void fillBaseAdjectives(List<String> adjectives, boolean compliment){
        try{
            Dao<Adjective, Integer> daoAdjective = getAdjectiveDao();
            for(String adjective : adjectives){
                Adjective adj = new Adjective(adjective, compliment);
                QueryBuilder<Adjective, Integer> qb = daoAdjective.queryBuilder();
                qb.where().eq("adjective", adjective).and().eq("compliment", compliment);
                boolean exists = qb.queryForFirst() != null;
                if(!exists)
                    daoAdjective.create(adj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            clearORM(this);
        }
    }

    public void fillBaseNouns(List<String> nouns, boolean compliment){
        try{
            Dao<Noun, Integer> daoNoun = getNounDao();
            for(String n : nouns){
                Noun noun = new Noun(n, compliment);
                QueryBuilder<Noun, Integer> qb = daoNoun.queryBuilder();
                qb.where().eq("noun", noun.Noun).and().eq("compliment", noun.Compliment);
                boolean exists = qb.queryForFirst() != null;
                if(!exists)
                    daoNoun.create(noun);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            clearORM(this);
        }
    }

    public boolean addNoun(Noun noun){
        boolean retVal = false;
        try{
            Dao<Noun, Integer> daoNoun = getNounDao();
            QueryBuilder<Noun, Integer> qb = daoNoun.queryBuilder();
            qb.where().eq("noun", noun.Noun).and().eq("compliment", noun.Compliment);
            boolean exists = qb.queryForFirst() != null;
            if(!exists){
                daoNoun.create(noun);
                retVal = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            clearORM(this);
        }
        return retVal;
    }

    public boolean addAdjective(Adjective adjective){
        boolean retVal = false;
        try{
            Dao<Adjective, Integer> adjectiveDao = getAdjectiveDao();
            QueryBuilder<Adjective, Integer> qb = adjectiveDao.queryBuilder();
            qb.where().eq("adjective", adjective.Adjective).and().eq("compliment", adjective.Compliment);
            boolean exists = qb.queryForFirst() != null;
            if(!exists){
                adjectiveDao.create(adjective);
                retVal = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            clearORM(this);
        }
        return retVal;
    }

    public int getAdjectiveTableSize(){
        int retVal = 0;
        try {
            Dao<Adjective, Integer> adjectiveDao = getAdjectiveDao();
            retVal = (int) adjectiveDao.countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public int getNounTableSize(){
        int retVal = 0;
        try {
            Dao<Noun, Integer> nounDao = getNounDao();
            retVal = (int) nounDao.countOf();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public Noun getNoun(int id){
        Noun retVal = null;
        try{
            Dao<Noun, Integer> nounDao = getNounDao();
            QueryBuilder<Noun, Integer> qb = nounDao.queryBuilder();
            qb.where().eq("id", id);
            retVal = qb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public Adjective getAdjective(int id){
        Adjective retVal = null;
        try{
            Dao<Adjective, Integer> adjectiveDao = getAdjectiveDao();
            QueryBuilder<Adjective, Integer> qb = adjectiveDao.queryBuilder();
            qb.where().eq("id", id);
            retVal = qb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public Adjective getRandomInsultAdjective(){
        Adjective retVal = null;
        try {
            Dao<Adjective, Integer> adjectiveDao = getAdjectiveDao();
            QueryBuilder<Adjective, Integer> qb = adjectiveDao.queryBuilder();
            qb.where().ne("compliment", true);
            qb.orderByRaw("RANDOM()");
            retVal = qb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public Adjective getRandomComplimentAdjective(){
        Adjective retVal = null;
        try {
            Dao<Adjective, Integer> adjectiveDao = getAdjectiveDao();
            QueryBuilder<Adjective, Integer> qb = adjectiveDao.queryBuilder();
            qb.where().eq("compliment", true);
            qb.orderByRaw("RANDOM()");
            retVal = qb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public Noun getRandomInsultNoun(){
        Noun retVal = null;
        try {
            Dao<Noun, Integer> nounDao = getNounDao();
            QueryBuilder<Noun, Integer> qb = nounDao.queryBuilder();
            qb.where().ne("compliment", true);
            qb.orderByRaw("RANDOM()");
            retVal = qb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public Noun getRandomComplimentNoun(){
        Noun retVal = null;
        try {
            Dao<Noun, Integer> nounDao = getNounDao();
            QueryBuilder<Noun, Integer> qb = nounDao.queryBuilder();
            qb.where().eq("compliment", true);
            qb.orderByRaw("RANDOM()");
            retVal = qb.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    private void clearORM(DatabaseHelper dbHelper) {
        clearDaoCache();
        if(dbHelper != null) dbHelper.close();
    }

    private void clearDaoCache() {
        DaoManager.clearCache();
    }

    public void deleteCustomWords() {


    }

    public void removeAllWords() {
        try{
            Dao<Adjective, Integer> adjectiveDao = getAdjectiveDao();
            List<Adjective> adjectives = adjectiveDao.queryForAll();
            adjectiveDao.delete(adjectives);
            Dao<Noun, Integer> nounDao = getNounDao();
            List<Noun> nouns = nounDao.queryForAll();
            nounDao.delete(nouns);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            clearORM(this);
        }
    }

    public List<Noun> getAllCustomNouns(List<String> baseNounList) {
        List<Noun> retVal = new ArrayList<>();
        try {
            Dao<Noun, Integer> nounDao = getNounDao();
            QueryBuilder<Noun, Integer> qb = nounDao.queryBuilder();
            qb.where().notIn("noun", baseNounList);
            retVal = qb.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public List<Adjective> getAllCustomAdjectives(List<String> baseAdjectiveList) {
        List<Adjective> retVal = new ArrayList<>();
        try {
            Dao<Adjective, Integer> adjectiveDao = getAdjectiveDao();
            QueryBuilder<Adjective, Integer> qb = adjectiveDao.queryBuilder();
            qb.where().notIn("adjective", baseAdjectiveList);
            retVal = qb.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public void deleteWord(String word, boolean noun) {
        try{
            if(word != null){
                if(noun){
                    Dao<Noun, Integer> nounDao = getNounDao();
                    QueryBuilder<Noun, Integer> qb = nounDao.queryBuilder();
                    qb.where().eq("noun", word);
                    Noun result = qb.queryForFirst();
                    if(result != null)
                        nounDao.delete(result);
                }
                else {
                    Dao<Adjective, Integer> adjectiveDao = getAdjectiveDao();
                    QueryBuilder<Adjective, Integer> qb = adjectiveDao.queryBuilder();
                    qb.where().eq("adjective", word);
                    Adjective result = qb.queryForFirst();
                    if(result != null)
                        adjectiveDao.delete(result);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            clearORM(this);
        }
    }
}
