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


public class ProductDAO {
    private  Connection con = null;

    public ProductDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean create(Product product ){
        String sql = "INSERT INTO produto {descricao, qtd, valor, categoria_id} VALUES {?,?,?,?}";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getDescription());
            stmt.setInt(2, product.getAmount());
            stmt.setDouble(3, product.getValue());
            stmt.setInt(4, product.getCategory().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Product> findAll(){
        //String sql = "SELECT p.id as pid, p.descricao as pdesc, qtd, valor, categoria_id, c.id as cid, c.descricao as cdesc FROM produto p INNER JOIN categoria c on c.id = p.cat";
        String sql= "SELECT * FROM vw_produto-categoria";
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        
        List<Product> products = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Product prod = new Product();
                
                prod.setId(rs.getInt("id"));
                prod.setDescription(rs.getString("pdesc"));
                prod.setAmount(rs.getInt("qtd"));
                prod.setValue(rs.getDouble("valor"));
                
                Category cat = new Category();
                cat.setId(rs.getInt("cid"));
                cat.setDescription(rs.getString("cdesc"));
                
                prod.setCategory(cat);
                
                products.add(prod);
            }
        }catch(SQLException ex){
                System.out.println("Error:"+ ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return products;
    }
}
