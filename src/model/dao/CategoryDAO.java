package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Category;
import model.bean.Product;

public class CategoryDAO {
    
    private Connection con = null;

    public CategoryDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean create(Category category ){
        String sql = "INSERT INTO categoria {descricao} VALUES {?}";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, category.getDescription());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean update(Category category ){
        String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, category.getDescription());
            stmt.setInt(2, category.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public boolean delete(Category category ){
        String sql = "DELETE FROM categoria WHERE id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, category.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Category> findAll(){
        String sql = "SELECT * FROM";
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        
        List<Category> categories = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Category cat = new Category(); 
                cat.setDescription(rs.getString("descricao"));
                
                categories.add(cat);
            }
        }catch(SQLException ex){
                System.out.println("Error:"+ ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return categories;
    }
}
