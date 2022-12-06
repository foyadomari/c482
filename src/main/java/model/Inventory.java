package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Inventory public class
 *
 * Stores the information for all parts and products
 *
 * @author Felice Oyadomari III
 */
public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    // Creates new Part ID starting at 1000
    public static AtomicInteger getUniquePartId = new AtomicInteger(1000);

    // Creates new Prod ID starting at 5000
    public static AtomicInteger getUniqueProdId = new AtomicInteger(5000);

    /**
     * Adds new part to part inventory
     *
     * @param newPart
     */
    public static void addPart(Part newPart){

        allParts.add(newPart);
    }

    /**
     * Adds new product to product inventory
     * @param newProduct
     */
    public static void addProduct(Product newProduct){

        allProducts.add(newProduct);
    }

    /**
     * Looks up part by its ID
     *
     * @param partId
     * @return requested part
     */
    public static Part lookupPart(int partId){
        for (Part part: allParts){
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    /**
     * Looks up product by its ID
     *
     * @param prodId
     * @return requested product
     */
    public static Product lookupProduct(int prodId){
        for (Product product: allProducts){
            if (product.getId() == prodId) {
                return product;
            }
        }
        return null;
    }

    /**
     * Looks up part by its name
     *
     * @param partName
     * @return requested part
     */
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> partFound = FXCollections.observableArrayList();
        for (Part part: allParts){
            if (part.getName().contains(partName)){
                partFound.add(part);
            }
        }
        return partFound;
    }

    /**
     * Looks up product by its name
     *
     * @param productName
     * @return requested product
     */
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> productFound = FXCollections.observableArrayList();
        for (Product product: allProducts){
            if (product.getName().contains(productName)){
                productFound.add(product);
            }
        }
        return productFound;
    }

    /**
     * Updates the part with new information
     *
     * @param index
     * @param selectedPart
     */
    public static void updatePart(int index,Part selectedPart ){

        Inventory.getAllParts().set(index,selectedPart);
    }

    /**
     * Updates the product with new information
     * @param index
     * @param selectedProduct
     */
    public static void updateProduct(int index, Product selectedProduct) {

        Inventory.getAllProducts().set(index, selectedProduct);
    }

    /**
     * Deletes the selected part from the inventory
     *
     * @param selectedPart
     * @return true if successful or false if not successful
     */
    public static boolean deletePart(Part selectedPart){
        if (allParts.contains(selectedPart)) {
            allParts.remove(selectedPart);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Deletes the selected product from the inventory
     *
     * @param selectedProduct
     * @return true if successful or false if not successful
     */
    public static boolean deleteProduct(Product selectedProduct){
        if (allProducts.contains(selectedProduct)) {
            allProducts.remove(selectedProduct);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Gets all the parts from the inventory
     *
     * @return all parts
     */
    public static ObservableList<Part> getAllParts(){
        return allParts;
    }

    /**
     * Gets all the products from the inventory
     *
     * @return all products
     */
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }
}
