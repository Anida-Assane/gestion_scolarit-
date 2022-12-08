package com.groupeisi.scolarites.presentation.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.scolarites.entities.User;


public class IUserImpl implements IUser {
	private DB db = new DB();
	private ResultSet rs;
	private int result;

	public int save(User user) {
		String sql = "INSERT INTO user VALUES(NULL,?,?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, user.getEmail());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
		
	}

	public int update(User user) {
		String sql = "Update user SET id=?, email=? , password=? where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, user.getId());
			db.getPstm().setString(2, user.getEmail());
			db.getPstm().setString(3, user.getPassword());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		String sql = "Delete from user where id=?";
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

	public User find(int id) {
		String sql = "Select * from user where id=?";
		User sc = new User();
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			while(rs.next()) {
				sc.setId(rs.getInt(1));
				sc.setEmail(rs.getString(2));
				sc.setPassword(rs.getString(3));
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sc;
	}

	public List<User> findAll() {
		List<User> lstUser = new ArrayList<User>();
		String sql = "Select * from user";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				User sc = new User();
				sc.setId(rs.getInt(1));
				sc.setEmail(rs.getString(2));
				sc.setPassword(rs.getString(3));
				lstUser.add(sc);
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstUser;
	}
	}

