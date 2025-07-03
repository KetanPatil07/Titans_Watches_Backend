package com.titan.controler;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.titan.entity.Kids;
import com.titan.service.KidsServices;

@RestController
@RequestMapping("/Kids")
@CrossOrigin(origins = "*")
public class KidsController {
	
	 private static final Logger logger = LoggerFactory.getLogger(KidsController.class);
	    private static final String IMAGE_FOLDER_PATH = "src/main/resources/static/img";
	    
	    @Autowired
	    public KidsServices kidsservice;
	    
	    @PostMapping("/AddProduct")
	    public Kids createAllProduct(@RequestParam("name") String name,
	                                   @RequestParam("dis") String dis,
	                                   @RequestParam("pprice") String pprice,
	                                   @RequestParam("photo") MultipartFile photo) {
	        return kidsservice.createAllProduct(name, dis, pprice, photo);
	    }

	    @GetMapping("/AllProduct")
	    public List<Kids> getAllProduct() {
	        return kidsservice.getAllProduct();
	    }

	    @PutMapping("/UpdateProduct/{id}")
	    public Kids updateProduct(@RequestBody Kids mens, @PathVariable Long id) {
	        return kidsservice.upadateProduct(mens, id);
	    }

	    @GetMapping("/{id}")
	    public Optional<Kids> findById(@PathVariable Long id) {
	        return kidsservice.findById(id);
	    }

	    @GetMapping("/name/{name}")
	    public Optional<Kids> findByName(@PathVariable String name) {
	        return kidsservice.findByName(name);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteById(@PathVariable Long id) {
	    	kidsservice.delateById(id);
	    }

	    @DeleteMapping("/deleteall")
	    public void deleteAll() {
	    kidsservice.deleteAll();
	    }
	    
}
