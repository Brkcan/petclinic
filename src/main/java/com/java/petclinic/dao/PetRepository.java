package com.java.petclinic.dao;

import java.util.List;

import com.java.petclinic.model.Pet;


public interface PetRepository {

	public Pet findById(Long id);
	
	public List<Pet> findByOwnerId(Long ownerId);
	
	public void create(Pet pet);
	
	public Pet update(Pet pet);
	
	public void delete(Long id);
	
	public void deleteByOwnerId(Long ownerId);
}
