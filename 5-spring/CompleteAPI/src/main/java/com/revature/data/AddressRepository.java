package com.revature.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	public Set<Address> findByOwnersUsername(String username);

}
