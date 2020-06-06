package com.java.petclinic.service;

import java.util.List;

import com.java.petclinic.exception.OwnerNotFoundException;
import com.java.petclinic.model.Owner;


public interface PetClinicService {

	public List<Owner> findOwners();
	
	public List<Owner> findOwners(String lastName);
	
	public Owner findOwner(Long id) throws OwnerNotFoundException;
	
	public void createOwner(Owner owner);
	
	public void update (Owner owner);
	
	public void delete(Long id);
	
}
