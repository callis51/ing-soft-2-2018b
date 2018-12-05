package db;

public class Db{

    public String host, port, user, pass, database;

    public Db(){
    }

    // validate if the database is null
    public boolean check(){
        return ( pass != "");
    }
}
