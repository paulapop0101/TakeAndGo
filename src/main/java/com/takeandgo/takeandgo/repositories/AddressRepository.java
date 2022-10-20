package com.takeandgo.takeandgo.repositories;

import com.takeandgo.takeandgo.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
