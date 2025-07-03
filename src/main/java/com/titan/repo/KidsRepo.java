package com.titan.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titan.entity.Kids;

@Repository
public interface KidsRepo extends JpaRepository<Kids, Long>{
	Optional<Kids>findByName(String name);
}
