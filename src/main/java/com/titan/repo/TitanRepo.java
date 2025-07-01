package com.titan.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titan.entity.Titan;

@Repository
public interface TitanRepo extends JpaRepository<Titan, Long>{
	Optional<Titan>findByName(String name);
}
