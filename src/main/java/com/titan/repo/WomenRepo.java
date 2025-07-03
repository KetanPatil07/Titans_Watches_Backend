package com.titan.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titan.entity.Women;
@Repository
public interface WomenRepo extends JpaRepository<Women, Long>{
	Optional<Women>findByName(String name);
}
