package bll;
import java.util.List;
import java.util.NoSuchElementException;
import dao.ProductDAO;
import model.Product;

/**
 * connects Product and ProdcutDAO
 */
public class ProductBll {

    private ProductDAO productDAO;

    public ProductBll() {
        //->instantiere nivel urmator
        productDAO = new ProductDAO();
    }

    public void addProduct(Product orderO) {
        //facem mereu lagatura spre DAO
        productDAO.insert(orderO);
    }

    public void deleteProduct(int id){

        productDAO.delete(id);
    }

    public List<Product> viewAllProducts(){

        List<Product> list = productDAO.viewAll();

        if (list == null) {
            throw new NoSuchElementException("Table is empty!!!");
        }
        return list;
    }

    public Product findProductById(int id) {

        Product byId = productDAO.findById(id);

        if (byId == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return byId;
    }

    public void updateProduct(Product t){

        productDAO.update(t);
    }



}
