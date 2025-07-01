package com.titan.serviceipl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.titan.entity.Titan;
import com.titan.repo.TitanRepo;
import com.titan.service.TitanService;

@Service
public class TitanserviceImpl implements TitanService {

    @Autowired
    public TitanRepo titanrepo;

    @Override
    public Titan createAllProduct(String name, String dis, String pprice, MultipartFile photo) {
        Titan titan = new Titan();
        titan.setName(name);
        titan.setDis(dis);
        titan.setPprice(pprice);

        String imageName = name.replaceAll("\\s+", "") + "_" + System.currentTimeMillis() + ".jpg";
        try {
            Path uploadPath = Paths.get("src/main/resources/static/img");
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath = uploadPath.resolve(imageName);
            Files.write(filePath, photo.getBytes());
            titan.setPhoto("img/" + imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return titanrepo.save(titan);
    }

    @Override
    public Titan createAllProduct(Titan titan) {
        return titanrepo.save(titan);
    }

    @Override
    public List<Titan> getAllProduct() {
        return titanrepo.findAll();
    }

    @Override
    public Optional<Titan> findById(Long id) {
        return titanrepo.findById(id);
    }

    @Override
    public Optional<Titan> findByName(String name) {
        return titanrepo.findByName(name);
    }

    @Override
    public void delateById(Long id) {
        titanrepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        titanrepo.deleteAll();
    }

    @Override
    public Titan upadateProduct(Titan titan, Long id) {
        return titanrepo.findById(id).map(product -> {
            product.setName(titan.getName());
            product.setDis(titan.getDis());
            product.setPprice(titan.getPprice());
            return titanrepo.save(product);
        }).orElseThrow(() -> new RuntimeException("Product is Not Found"));
    }
}
