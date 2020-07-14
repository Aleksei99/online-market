package by.work.web.controller;

import by.work.database.entity.Product;
import by.work.database.entity.Subcategory;
import by.work.database.entity.User;
import by.work.service.ProductService;
import by.work.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SellerAdd {

    private final ProductService productService;
    private final SubCategoryService subCategoryService;

    @Autowired
    public SellerAdd(ProductService productService, SubCategoryService subCategoryService) {
        this.productService = productService;
        this.subCategoryService = subCategoryService;
    }

    @ModelAttribute("product")
    public Product getProduct(){
        Product product = new Product();
        return product;
    }

    @ModelAttribute("subCategories")
    public List<Subcategory> getSubCategories(){
        Iterable<Subcategory> all = subCategoryService.getAll();
        List<Subcategory> subcategories = new ArrayList<>();
        for(Subcategory item: all){
            subcategories.add(item);
        }
        return subcategories;
    }

    @GetMapping("/seller/add")
    public String getPage(){
        return "addProduct";
    }

    @PostMapping("/Product/add")
    public String saveProduct(Product product, HttpSession httpSession, @RequestParam(value = "subCategoryID",required = false) Long id){
        User user = (User) httpSession.getAttribute("currentUser");
        Subcategory subcategory = subCategoryService.getSubCategory(id);
        productService.save(new Product(product.getBrand(),product.getName(),product.getPrice(),subcategory,user,product.getDescription()));
        return "redirect:/seller/add";
    }
}
