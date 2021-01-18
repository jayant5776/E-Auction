package com.cdac.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer>{

}
