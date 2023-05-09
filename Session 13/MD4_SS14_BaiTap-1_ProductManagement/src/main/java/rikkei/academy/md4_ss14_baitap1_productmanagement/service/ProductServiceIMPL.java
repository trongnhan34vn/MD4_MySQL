package rikkei.academy.md4_ss14_baitap1_productmanagement.service;

import rikkei.academy.md4_ss14_baitap1_productmanagement.config.ConnectionDB;
import rikkei.academy.md4_ss14_baitap1_productmanagement.model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService{
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        String QUERY = "SELECT * FROM Product";
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setDescription(resultSet.getString("Description"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setPrice(resultSet.getFloat("Price"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getId()) == null) {
            // create
            createProduct(product);
        } else {
            // update
            updateProduct(product);
        }
    }

    private void updateProduct (Product product) {
        String QUERY = "{CALL updateProduct(?,?,?,?,?)}";
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement callableStatement = conn.prepareCall(QUERY);
            callableStatement.setInt(1, product.getId());
            callableStatement.setString(2, product.getName());
            callableStatement.setString(3, product.getDescription());
            callableStatement.setInt(4, product.getQuantity());
            callableStatement.setFloat(5, product.getPrice());
            callableStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    private void createProduct(Product product) {
        String QUERY = "{CALL createProduct(?,?,?,?)}";
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement callableStatement = conn.prepareCall(QUERY);
            callableStatement.setString(1, product.getName());
            callableStatement.setString(2, product.getDescription());
            callableStatement.setInt(3, product.getQuantity());
            callableStatement.setFloat(4, product.getPrice());
            callableStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void remove(int id) {
        String QUERY = "{CALL removeById(?)}";
        Connection conn = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement callableStatement = conn.prepareCall(QUERY);
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public Product findById(int id) {
        String QUERY = "{CALL findById(?)}";
        Connection conn = null;
        Product product = null;
        try {
            conn = ConnectionDB.getConnection();
            CallableStatement callableStatement = conn.prepareCall(QUERY);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("ID"));
                product.setName(resultSet.getString("Name"));
                product.setDescription(resultSet.getString("Description"));
                product.setQuantity(resultSet.getInt("Quantity"));
                product.setPrice(resultSet.getFloat("Price"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return product;
    }
}
