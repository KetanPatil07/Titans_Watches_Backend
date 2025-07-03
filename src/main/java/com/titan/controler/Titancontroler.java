// === CONTROLLER ===
package com.titan.controler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.titan.entity.Titan;
import com.titan.service.TitanService;

@RestController
@RequestMapping("/titan")
@CrossOrigin(origins = "*")
public class Titancontroler {

    private static final Logger logger = LoggerFactory.getLogger(Titancontroler.class);
    private static final String IMAGE_FOLDER_PATH = "src/main/resources/static/img";

    @Autowired
    public TitanService titanservice;

    @PostMapping("/AddProduct")
    public Titan createAllProduct(@RequestParam("name") String name,
                                   @RequestParam("dis") String dis,
                                   @RequestParam("pprice") String pprice,
                                   @RequestParam("photo") MultipartFile photo) {
        return titanservice.createAllProduct(name, dis, pprice, photo);
    }

    @GetMapping("/AllProduct")
    public List<Titan> getAllProduct() {
        return titanservice.getAllProduct();
    }

    @PutMapping("/UpdateProduct/{id}")
    public Titan updateProduct(@RequestBody Titan titan, @PathVariable Long id) {
        return titanservice.upadateProduct(titan, id);
    }

    @GetMapping("/{id}")
    public Optional<Titan> findById(@PathVariable Long id) {
        return titanservice.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Titan> findByName(@PathVariable String name) {
        return titanservice.findByName(name);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public void deleteById(@PathVariable Long id) {
        titanservice.delateById(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        titanservice.deleteAll();
    }
} 
