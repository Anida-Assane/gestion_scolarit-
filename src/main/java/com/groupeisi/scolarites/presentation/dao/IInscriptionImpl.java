package com.groupeisi.scolarites.presentation.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.scolarites.entities.Inscription;
import com.groupeisi.scolarites.entities.User;

public class IInscriptionImpl {
	private DB db = new DB();
	private ResultSet rs;
	private int result;

	public int save(Inscription inscription) {
		String sql = "INSERT INTO inscription VALUES(NULL,?,?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, inscription.getClasse());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
		
	}

	public int update(Inscription inscription) {
		String sql = "Update inscription SET id=?, date=? , classe=? where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, inscription.getId());
			db.getPstm().setDate(2, (Date) inscription.getDate());
			db.getPstm().setString(3, inscription.getClasse());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		String sql = "Delete from inscription where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public Inscription find(int id) {
		String sql = "Select * from inscription where id=?";
		Inscription sc = new Inscription();
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			while(rs.next()) {
				sc.setId(rs.getInt(1));
				//sc.setDate(rs.getString(2));
				sc.setClasse(rs.getString(3));
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sc;
	}

	public List<Inscription> findAll() {
		List<Inscription> lstInsrciption = new ArrayList<Inscription>();
		String sql = "Select * from inscription";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				Inscription sc = new Inscription();
				sc.setId(rs.getInt(1));
				//sc.setDate(rs.getString(2));
				sc.setClasse(rs.getString(3));
				lstInsrciption.add(sc);
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstInsrciption;
	}
	

}
