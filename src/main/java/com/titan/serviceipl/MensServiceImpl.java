package com.titan.serviceipl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.titan.entity.Mens;

import com.titan.repo.MensRepo;
import com.titan.service.MensService;

@Service
public class MensServiceImpl implements MensService{
	
	@Autowired
	public MensRepo mensrepo;
	@Override
	public Mens createAllProduct(Mens mens) {
		// TODO Auto-generated method stub
		return mensrepo.save(mens);
	}

	@Override
	public Mens createAllProduct(String name, String dis, String pprice, MultipartFile photo) {
		// TODO Auto-generated method stub
		 Mens mens = new Mens();
	        mens.setName(name);
	        mens.setDis(dis);
	        mens.setPprice(pprice);

	        String imageName = name.replaceAll("\\s+", "") + "_" + System.currentTimeMillis() + ".jpg";
	        try {
	            Path uploadPath = Paths.get("src/main/resources/static/img");
	            if (!Files.exists(uploadPath)) {
	                Files.createDirectories(uploadPath);
	            }
	            Path filePath = uploadPath.resolve(imageName);
	            Files.write(filePath, photo.getBytes());
	            mens.setPhoto("img/" + imageName);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return mensrepo.save(mens);

	}

	@Override
	public List<Mens> getAllProduct() {
		// TODO Auto-generated method stub
		return mensrepo.findAll();
	}

	@Override
	public Mens upadateProduct(Mens mens, Long id) {
		// TODO Auto-generated method stub
		 return mensrepo.findById(id).map(menp -> {
	            menp.setName(mens.getName());
	            menp.setDis(mens.getDis());
	            menp.setPprice(mens.getPprice());
	            return mensrepo.save(menp);
	        }).orElseThrow(() -> new RuntimeException("Product is Not Found"));
	    }
	

	@Override
	public Optional<Mens> findById(Long id) {
		// TODO Auto-generated method stub
		return mensrepo.findById(id);
	}

	@Override
	public Optional<Mens> findByName(String name) {
		// TODO Auto-generated method stub
		return mensrepo.findByName(name);
	}

	@Override
	public void delateById(Long id) {
		// TODO Auto-generated method stub
		mensrepo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		mensrepo.deleteAll();
	}

	
}
