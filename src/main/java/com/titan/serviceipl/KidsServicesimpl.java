package com.titan.serviceipl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.titan.entity.Kids;
import com.titan.repo.KidsRepo;
import com.titan.service.KidsServices;

@Service
public class KidsServicesimpl implements KidsServices{
	
	@Autowired
	public KidsRepo kidsrepo;
	
	@Override
	public Kids createAllProduct(Kids kids) {
		// TODO Auto-generated method stub
		return kidsrepo.save(kids);
	}

	@Override
	public Kids createAllProduct(String name, String dis, String pprice, MultipartFile photo) {
		// TODO Auto-generated method stub
		 Kids kids = new Kids();
	        kids.setName(name);
	        kids.setDis(dis);
	        kids.setPprice(pprice);

	        String imageName = name.replaceAll("\\s+", "") + "_" + System.currentTimeMillis() + ".jpg";
	        try {
	            Path uploadPath = Paths.get("src/main/resources/static/img");
	            if (!Files.exists(uploadPath)) {
	                Files.createDirectories(uploadPath);
	            }
	            Path filePath = uploadPath.resolve(imageName);
	            Files.write(filePath, photo.getBytes());
	           kids.setPhoto("img/" + imageName);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return kidsrepo.save(kids);

	}

	@Override
	public List<Kids> getAllProduct() {
		// TODO Auto-generated method stub
		return kidsrepo.findAll();
	}

	@Override
	public Kids upadateProduct(Kids kids, Long id) {
		// TODO Auto-generated method stub
		return kidsrepo.findById(id).map(kidp -> {
            kidp.setName(kids.getName());
            kidp.setDis(kids.getDis());
            kidp.setPprice(kids.getPprice());
            return kidsrepo.save(kidp);
        }).orElseThrow(() -> new RuntimeException("Product is Not Found"));
	}

	@Override
	public Optional<Kids> findById(Long id) {
		// TODO Auto-generated method stub
		return kidsrepo.findById(id);
	}

	@Override
	public Optional<Kids> findByName(String name) {
		// TODO Auto-generated method stub
		return kidsrepo.findByName(name);
	}

	@Override
	public void delateById(Long id) {
		// TODO Auto-generated method stub
		kidsrepo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		kidsrepo.deleteAll();
	}

}
