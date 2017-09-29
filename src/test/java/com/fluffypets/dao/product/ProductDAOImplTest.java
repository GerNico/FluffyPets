package com.fluffypets.dao.product;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

public class ProductDAOImplTest {
//    @Test
//    public void selectByCategoryAndPrice() {
//        ProductDAO productDAO = ControllersFactory.getProductDao();
//        List<Product> products=productDAO.selectByCategoryAndPrice(new ArrayList<>(),0,20);
//        List<String> productNames=products.stream().map(Product::getName).collect(Collectors.toList());
//        assertTrue(productNames.contains("yellow Lucky Cat"));
//        assertTrue(productNames.contains("Chestnut Bear"));
//    }

//    @Test
//    public void testProductCRUD() {
//        CategoryDAO categoryDAO = DaoFactory.getCategoryDao();
//        ProductDAO productDAO = DaoFactory.getProductDao();
//        Category plushBears = new Category(1, "Plussssh bears", "plush toy it should be bear");
//        Category plushDisney = new Category(2, "Plussssh W. Disney Cartons", "plush toy it should from carton");
//
//        Category expectedCategory = categoryDAO.get(plushBears);
//        assertNull("this testing category should be absent", expectedCategory);
//        expectedCategory = categoryDAO.get(plushDisney);
//        assertNull("this testing category should be present", expectedCategory);
//
//        plushBears = categoryDAO.create(plushBears);
//        plushDisney = categoryDAO.create(plushDisney);
//
//        Product plushPanda = new Product(1, "plusssssh Panda", "Chingen Panda Corp.", new BigDecimal(99.99)
//                , " nice 9 inch toll panda", "someURL", plushBears);
//        Product plushIceBear = new Product(1, "plusssssh ice bear", "Chingen Panda Corp.", new BigDecimal(89.99)
//                , " nice 8 inch toll bear", "someURL2", plushBears);
//        Product plushMickyMouse = new Product(1, "plusssssh Micky Mouse", "Canton MakeAll Corp.", new BigDecimal(129.99)
//                , " nice 7 inch toll Micky", "someURL2", plushDisney);
//
//        Product expectedProduct = productDAO.get(plushPanda);
//        assertNull("this testing product should be absent", expectedProduct);
//        expectedProduct = productDAO.get(plushIceBear);
//        assertNull("this testing product should be absent", expectedProduct);
//        expectedProduct = productDAO.get(plushMickyMouse);
//        assertNull("this testing product should be absent", expectedProduct);
//
//        plushIceBear = productDAO.create(plushIceBear);
//        plushPanda = productDAO.create(plushPanda);
//        plushMickyMouse = productDAO.create(plushMickyMouse);
//
//        expectedProduct = productDAO.get(plushIceBear);
//        assertEquals("testing product was not created", plushIceBear, expectedProduct);
//        expectedProduct = productDAO.get(plushPanda);
//        assertEquals("testing product was not created", plushPanda, expectedProduct);
//        expectedProduct = productDAO.get(plushMickyMouse);
//        assertEquals("testing product was not created", plushMickyMouse, expectedProduct);
//
//        List<Product> productList;
//
//        productList=productDAO.getAll();
//        assertTrue(productList.contains(plushPanda));
//        assertTrue(productList.contains(plushIceBear));
//
//        productDAO.delete(plushIceBear);
//        productDAO.delete(plushPanda);
//        productDAO.delete(plushMickyMouse);
//
//        categoryDAO.delete(plushBears);
//        categoryDAO.delete(plushDisney);
//
//    }

}