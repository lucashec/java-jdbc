package model.dao;

import model.bean.Category;
import model.bean.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductDAOTest {
    
    public ProductDAOTest() {
    }

    @Test
    public void insertTest() {
        Category cat = new Category();
        cat.setId(1);
        
        Product prod = new Product();
        prod.setDescription("Test product");
        prod.setAmount(10);
        prod.setValue(10);
        prod.setCategory(cat);
        
        ProductDAO dao = new ProductDAO();
        
        if(dao.create(prod)){
            System.out.println("Created Successful");
        }else{
            fail("Create failed");
        }
    }
    
    @Test
    public void listTest() {
        
        ProductDAO dao = new ProductDAO();
        
        for(Product p: dao.findAll()){
            System.out.println("Descrição produto:" + p.getDescription()+"- Descrição categoria:"+ p.getCategory().getDescription());
        }
            
    }
    
}
