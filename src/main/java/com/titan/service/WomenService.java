package com.titan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.titan.entity.Women;

@Service
public interface WomenService {
	
	 Women createAllProduct(Women women); // For old JSON-based requests

	    Women createAllProduct(String name, String dis, String pprice, MultipartFile photo); // New multipart method

	    List<Women> getAllProduct();

	    Women upadateProduct(Women women, Long id);

	    Optional<Women> findById(Long id);

	    Optional<Women> findByName(String name);

	    void delateById(Long id);

	    void deleteAll();
}
