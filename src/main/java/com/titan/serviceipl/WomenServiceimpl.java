package com.titan.serviceipl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.titan.entity.Women;
import com.titan.repo.WomenRepo;
import com.titan.service.WomenService;

@Service
public class WomenServiceimpl implements WomenService{
	@Autowired
	public WomenRepo womenrepo;
	@Override
	public Women createAllProduct(Women women) {
		// TODO Auto-generated method stub
		return womenrepo.save(women);
	}

	@Override
	public Women createAllProduct(String name, String dis, String pprice, MultipartFile photo) {
		// TODO Auto-generated method stub
		 Women women = new Women();
		 women.setName(name);
		 women.setDis(dis);
		 women.setPprice(pprice);

	        String imageName = name.replaceAll("\\s+", "") + "_" + System.currentTimeMillis() + ".jpg";
	        try {
	            Path uploadPath = Paths.get("src/main/resources/static/img");
	            if (!Files.exists(uploadPath)) {
	                Files.createDirectories(uploadPath);
	            }
	            Path filePath = uploadPath.resolve(imageName);
	            Files.write(filePath, photo.getBytes());
	            women.setPhoto("img/" + imageName);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return womenrepo.save(women);
	}

	@Override
	public List<Women> getAllProduct() {
		// TODO Auto-generated method stub
		return womenrepo.findAll();
	}

	@Override
	public Women upadateProduct(Women women, Long id) {
		// TODO Auto-generated method stub
		return womenrepo.findById(id).map(womenp -> {
			womenp.setName(women.getName());
			womenp.setDis(women.getDis());
			womenp.setPprice(women.getPprice());
            return womenrepo.save(womenp);
        }).orElseThrow(() -> new RuntimeException("Product is Not Found"));
	}

	@Override
	public Optional<Women> findById(Long id) {
		// TODO Auto-generated method stub
		return womenrepo.findById(id);
	}

	@Override
	public Optional<Women> findByName(String name) {
		// TODO Auto-generated method stub
		return womenrepo.findByName(name);
	}

	@Override
	public void delateById(Long id) {
		// TODO Auto-generated method stub
		womenrepo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		womenrepo.deleteAll();
	}

}
