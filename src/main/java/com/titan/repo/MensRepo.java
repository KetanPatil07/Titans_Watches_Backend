package com.titan.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titan.entity.Mens;

@Repository
public interface MensRepo extends JpaRepository<Mens, Long>{
	Optional<Mens>findByName(String name);
}
