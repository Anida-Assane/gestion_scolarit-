package com.groupeisi.scolarites.presentation.dao;

import java.util.List;

import com.groupeisi.scolarites.entities.Inscription;


public interface IInscription {
	public int save(Inscription inscription);
    public int update(Inscription inscription);
    public int delete(int id);
    public Inscription find(int id);
    public List<Inscription> findAll();

}
