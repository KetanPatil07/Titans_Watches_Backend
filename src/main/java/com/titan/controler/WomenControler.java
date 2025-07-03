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

import com.titan.entity.Mens;
import com.titan.entity.Women;
import com.titan.service.WomenService;

@RestController
@RequestMapping("/Women")
@CrossOrigin(origins = "*")
public class WomenControler {

	  private static final Logger logger = LoggerFactory.getLogger(WomenControler.class);
	    private static final String IMAGE_FOLDER_PATH = "src/main/resources/static/img";
	    
	    @Autowired
	    public WomenService womenservice;
	    

	    @PostMapping("/AddProduct")
	    public Women createAllProduct(@RequestParam("name") String name,
	                                   @RequestParam("dis") String dis,
	                                   @RequestParam("pprice") String pprice,
	                                   @RequestParam("photo") MultipartFile photo) {
	        return womenservice.createAllProduct(name, dis, pprice, photo);
	    }

	    @GetMapping("/AllProduct")
	    public List<Women> getAllProduct() {
	        return womenservice.getAllProduct();
	    }

	    @PutMapping("/UpdateProduct/{id}")
	    public Women updateProduct(@RequestBody Women women, @PathVariable Long id) {
	        return womenservice.upadateProduct(women, id);
	    }

	    @GetMapping("/{id}")
	    public Optional<Women> findById(@PathVariable Long id) {
	        return womenservice.findById(id);
	    }

	    @GetMapping("/name/{name}")
	    public Optional<Women> findByName(@PathVariable String name) {
	        return womenservice.findByName(name);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteById(@PathVariable Long id) {
	    	womenservice.delateById(id);
	    }

	    @DeleteMapping("/deleteall")
	    public void deleteAll() {
	    	womenservice.deleteAll();
	    }
}
