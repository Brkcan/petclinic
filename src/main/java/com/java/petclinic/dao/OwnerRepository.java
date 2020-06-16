package com.java.petclinic.dao;

import java.util.List;

import com.java.petclinic.model.Owner;


public interface OwnerRepository {
	
	public List<Owner> findAll();
	
	public Owner findById(Long id);
	
	public List<Owner> findByLastName(String lastName);
	
	public void create(Owner owner);
	
	public Owner update(Owner owner);
	
	public void delete(Long id);

}
