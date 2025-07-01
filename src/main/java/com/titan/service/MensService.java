package com.titan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.titan.entity.Mens;


@Service
public interface MensService {

    Mens createAllProduct(Mens mens); // For old JSON-based requests

    Mens createAllProduct(String name, String dis, String pprice, MultipartFile photo); // New multipart method

    List<Mens> getAllProduct();

    Mens upadateProduct(Mens mens, Long id);

    Optional<Mens> findById(Long id);

    Optional<Mens> findByName(String name);

    void delateById(Long id);

    void deleteAll();
}
