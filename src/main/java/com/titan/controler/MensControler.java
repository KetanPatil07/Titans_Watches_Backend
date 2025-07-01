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

import com.titan.service.MensService;


@RestController
@RequestMapping("/Mens")
@CrossOrigin(origins = "*")
public class MensControler {

    private static final Logger logger = LoggerFactory.getLogger(MensControler.class);
    private static final String IMAGE_FOLDER_PATH = "src/main/resources/static/img";
    
    @Autowired
    public  MensService menservice;
    

    @PostMapping("/AddProduct")
    public Mens createAllProduct(@RequestParam("name") String name,
                                   @RequestParam("dis") String dis,
                                   @RequestParam("pprice") String pprice,
                                   @RequestParam("photo") MultipartFile photo) {
        return menservice.createAllProduct(name, dis, pprice, photo);
    }

    @GetMapping("/AllProduct")
    public List<Mens> getAllProduct() {
        return menservice.getAllProduct();
    }

    @PutMapping("/UpdateProduct/{id}")
    public Mens updateProduct(@RequestBody Mens mens, @PathVariable Long id) {
        return menservice.upadateProduct(mens, id);
    }

    @GetMapping("/{id}")
    public Optional<Mens> findById(@PathVariable Long id) {
        return menservice.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Mens> findByName(@PathVariable String name) {
        return menservice.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
    	menservice.delateById(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
    	menservice.deleteAll();
    }
}
