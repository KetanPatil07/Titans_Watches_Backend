package com.titan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.titan.entity.Kids;


@Service
public interface KidsServices {
	
    Kids createAllProduct(Kids kids); // For old JSON-based requests

    Kids createAllProduct(String name, String dis, String pprice, MultipartFile photo); // New multipart method

    List<Kids> getAllProduct();

    Kids upadateProduct(Kids kids, Long id);

    Optional<Kids> findById(Long id);

    Optional<Kids> findByName(String name);

    void delateById(Long id);

    void deleteAll();
}
