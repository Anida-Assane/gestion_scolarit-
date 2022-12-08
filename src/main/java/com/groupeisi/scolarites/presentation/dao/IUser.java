package com.groupeisi.scolarites.presentation.dao;

import java.util.List;
import com.groupeisi.scolarites.entities.User;

public interface IUser {
	public int save(User user);
    public int update(User user);
    public int delete(int id);
    public User find(int id);
    public List<User> findAll();
}
