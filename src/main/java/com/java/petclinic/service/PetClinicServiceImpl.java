package com.java.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.petclinic.dao.OwnerRepository;
import com.java.petclinic.exception.OwnerNotFoundException;
import com.java.petclinic.model.Owner;


@Service
@Transactional(rollbackFor = Exception.class)
public class PetClinicServiceImpl implements PetClinicService {

	private OwnerRepository ownerRepository;

	
	@Autowired
	public void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Owner> findOwners() {
		return ownerRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Owner> findOwners(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Owner findOwner(Long id) throws OwnerNotFoundException {
		Owner owner = ownerRepository.finById(id);
		if (owner == null)
			throw new OwnerNotFoundException("owner not found with id  =  " + id);
		return owner;
	}

	@Override
	public void createOwner(Owner owner) {
		ownerRepository.create(owner);
	}

	@Override
	public void update(Owner owner) {
		ownerRepository.update(owner);
	}

	@Override
	public void delete(Long id) {
		ownerRepository.delete(id);
	}


}
