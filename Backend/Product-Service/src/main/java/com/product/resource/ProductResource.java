package com.product.resource;

import com.product.model.Product;
import com.product.service.ProductService;
import com.product.service.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("product")
public class ProductResource {
    @Autowired
    FileUploadHelper fileUploadHelper;

    @Autowired
    ProductService productService;


    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file)
    {

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain a File");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Jpeg content is allowed");
            }
            boolean f = fileUploadHelper.uploadFile(file);
            if (f) {
                String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString();
//				return  ResponseEntity.ok("File is successfull upload");
                System.out.println(url);
                return ResponseEntity.ok(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong try again");
    }




    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.addProducts(product);
          return ResponseEntity.ok("Product Added successfully");
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

//	@GetMapping("/getAllProducts")
//	public List<Product> getAllProducts()
//	{
//		return ResponseEntity.ok(productService.getAllProducts());
//	}

    @GetMapping("/getProduct/id/{productId}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("productId") String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/getProduct/type/{productType}")
    public ResponseEntity<List<Product>> getProductByType(@PathVariable("productType") String type) {
        return ResponseEntity.ok(productService.getProductByType(type));
    }

    @GetMapping("/getProduct/name/{productName}")
    public ResponseEntity<Optional<Product>> getProductByName(@PathVariable("productName") String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/getProduct/category/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category) {
        return ResponseEntity.ok(productService.getProductByCategory(category));
    }


    @PutMapping("/updateProduct")
    ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }


    @DeleteMapping("/deleteProduct/{productId}")
    void deleteProduct(@PathVariable("productId") String id) {

        productService.deleteProductById(id);
    }


}
