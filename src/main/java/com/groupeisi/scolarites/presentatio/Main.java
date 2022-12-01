package com.groupeisi.scolarites.presentatio;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.groupeisi.scolarites.entities.User;
import com.groupeisi.scolarites.presentation.dao.IUserDao;
import com.groupeisi.scolarites.presentation.dao.UserImpl;

public class Main {
         private static Logger logger = Logger.getLogger(Main.class);
         public static void mai(String[] args) {
        	 BasicConfigurator.configure();
        	 IUserDao userdao = new UserImpl() {
			};
        	 User user = new User();
        	 user.setEmail("isi@groupeisi.com");
        	 user.setPassword("passer1234#@!");
        	 int result = userdao.create(user);
        	 logger.debug(result);
         }
}

