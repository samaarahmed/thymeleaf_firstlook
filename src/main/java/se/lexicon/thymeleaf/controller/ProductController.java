package se.lexicon.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import se.lexicon.thymeleaf.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

List<Product> productList;

public ProductController (){
    this.productList = new ArrayList<>(
            Arrays.asList(new Product(UUID.randomUUID().toString(),"Milk",
                    "lektosfri milk 3,0 fat", BigDecimal.valueOf(15),true),
                    new Product(UUID.randomUUID().toString(),"Bread",
                            "Brown bread with 50% fullkorn",BigDecimal.valueOf(20),true)
            ));

}
    @GetMapping(value = "/product")
    public String showProductsView(Model model){
        model.addAttribute("productItems", productList);
        return "product";
    }
    @GetMapping(value = "/product/add")
    public String showProductForm(){
        return "addproduct";
    }


    @PostMapping(value = "/product/add/process")

    public String processProductForm(String name, String description, BigDecimal price, Boolean available){

    Product product = new Product(UUID.randomUUID().toString(),name,description,price,available);
    productList.add(product);
    return "redirect:/product";


    }



}
