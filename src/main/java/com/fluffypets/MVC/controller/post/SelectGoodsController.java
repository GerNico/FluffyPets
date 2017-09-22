package com.fluffypets.MVC.controller.post;

import com.fluffypets.MVC.controller.Controller;
import com.fluffypets.MVC.model.Category;
import com.fluffypets.MVC.model.Product;
import com.fluffypets.MVC.model.enumes.Prices;
import com.fluffypets.MVC.servlets.Request;
import com.fluffypets.MVC.servlets.ViewModel;
import com.fluffypets.servicies.CategoryService;
import com.fluffypets.servicies.ProductService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

public class SelectGoodsController implements Controller,AutoCloseable {

    private ProductService productService;
    private CategoryService categoryService;

    public SelectGoodsController(ProductService productService,CategoryService categoryService) {
        this.productService = productService;
        this.categoryService=categoryService;
    }

    @Override
    public ViewModel process(Request request, ViewModel vm) {
        List<Category> categories=categoryService.getAll();
        StringJoiner sj=new StringJoiner(",");
        categories.stream().filter(category ->request.containsAtribute(category.getName()))
                .map(Category::getId).forEach(categId ->sj.add(categId.toString()));

        if (sj.toString().equals("")) categories.forEach(category -> sj.add(category.getId().toString()));
        String priceLabel=request.getAttribute("selectedPrice");

        Optional<Prices> priceSel=Arrays.stream(Prices.values()).filter(value->value.getLabel().equals(priceLabel)).findAny();

        List<Product> products=productService.getAllSelected(sj.toString(),priceSel.get().getMin(),priceSel.get().getMax());
        vm.setAttribute("products",products);
        vm.setView("home");
        return vm;
    }

    @Override
    public void close() throws Exception {
        productService.close();
        categoryService.close();
    }
}