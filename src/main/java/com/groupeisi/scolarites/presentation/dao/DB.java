package com.groupeisi.scolarites.presentation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	//Pour l'execution des requetes préparées
	private PreparedStatement pstm;
	//Pour l'ouverture de la connexion a la base de données
	private Connection cnx;
	//Pour la récuperation des resultats des requetes de type SELECT
	private ResultSet rs;
	//Pour la récuperation des requetes de type INSERT ,UPDATE et DELETE
	private int result;
	
	public void openConnection () {
		String url = "jdbc:mysql://localhost:3306/scolaritesdb";
		String userMysql = "root";
		String passwordMysql = "";
		try {
			cnx = DriverManager.getConnection(url, userMysql, passwordMysql);
			System.out.println("Connexion ok");
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
}
