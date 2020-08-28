package model.dao;

import model.bean.Category;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CategoryDAOTest {
    
    public CategoryDAOTest() {
    }

    @Test
    public void insertTest() {
        Category cat = new Category("Clothes");
        CategoryDAO dao = new CategoryDAO();
        
        if(dao.create(cat)){
            System.out.println("Create Successful");
        }else{
            fail("Error: Create failed");
        }
    }
    
     @Test
    public void updateTest() {
        Category cat = new Category("Shoes");
        cat.setId(1);
        CategoryDAO dao = new CategoryDAO();
        
        if(dao.update(cat)){
            System.out.println("Update Successful");
        }else{
            fail("Error: Update falied");
        }
    }
    public void deleteTest() {
        Category cat = new Category();
        cat.setId(1);
        CategoryDAO dao = new CategoryDAO();
        
        if(dao.delete(cat)){
            System.out.println("Delete Successful");
        }else{
            fail("Error: Delete falied");
        }
    }
    
}
