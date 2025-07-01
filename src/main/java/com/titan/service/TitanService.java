package com.titan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.titan.entity.Titan;

@Service
public interface TitanService {

    Titan createAllProduct(Titan titan); // For old JSON-based requests

    Titan createAllProduct(String name, String dis, String pprice, MultipartFile photo); // New multipart method

    List<Titan> getAllProduct();

    Titan upadateProduct(Titan titan, Long id);

    Optional<Titan> findById(Long id);

    Optional<Titan> findByName(String name);

    void delateById(Long id);

    void deleteAll();
}
