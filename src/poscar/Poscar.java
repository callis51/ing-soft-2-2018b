package poscar;

import db.Db;
import db.Connector;
import db.ConFile;
//import gui.Window;

import java.io.IOException;

public class Poscar {

    private String FILE_DB = "con_db.txt";

	public Db db;
    public Connector con;
    public ConFile filedb;
//	public Window win;

	public void Poscar(){}

	public static void main(String[] args){
		Poscar app = new Poscar();
        app.start();
	}

    public void start(){

		filedb = new ConFile(FILE_DB);

		try{
			if ( filedb.fileExists() ){
				db = filedb.loadfile();
				if ( db == null ){
					// TODO raise error wrong dbfile
					// TODO raise form to create database
				}
				else if ( db.check() ){

				}

				if ( Connector.tryConnect(db)){
					//dbfile correct
					// open interface to insert dbfile data
					System.out.println("well");
				} else {
					//dbfile wrong connection
				}
			} else{
				// create dbfile
				// open interface to insert dbfile data
			}
		} catch( IOException e){
			System.out.println( e.getMessage());
		}
    }
}

/*
si el archivo de configuracion de la base de datos no existe
entonces crear archivo para conectarse a la base de datos
    mostrar la forma de creear conexcion a la db
        la db no existe, desea crear la db

si no se puede conectar a la baase de datos entocnces
entonces mostrar la forma de conexion a la base de datos


si se puede conectar a la base de datos pero no existe

crear la base de datos y mostrar mensajes de esto
*/
