package com.groupeisi.scolarites.presentatio;

import java.io.IOException;
import java.util.List;

import com.groupeisi.scolarites.entities.User;
import com.groupeisi.scolarites.presentation.dao.DB;
import com.groupeisi.scolarites.presentation.dao.IUser;
import com.groupeisi.scolarites.presentation.dao.IUserImpl;



public class Main {
	public static void main(String[] args) throws IOException {
		IUser iUser = new IUserImpl();
		DB db = new DB();
		User user = new User();
		System.out.println(user.getEmail());
	}
}

