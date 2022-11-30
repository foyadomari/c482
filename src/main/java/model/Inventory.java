package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     *
     * @param newPart
     */
    public static void addPart(Part newPart){
        allParts.add(newPart);
    }
    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }
    public static Part lookupPart(int partId){
        for (Part part: allParts){
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }
    public static Product lookupProduct(int prodId){
        for (Product product: allProducts){
            if (product.getId() == prodId) {
                return product;
            }
        }
        return null;
    }
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> partFound = FXCollections.observableArrayList();
        for (Part part: allParts){
            if (part.getName().contains(partName)){
                partFound.add(part);
            }
        }
        return partFound;
    }
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> productFound = FXCollections.observableArrayList();
        for (Product product: allProducts){
            if (product.getName().contains(productName)){
                productFound.add(product);
            }
        }
        return productFound;
    }
    public static void updatePart(int index,Part selectedPart ){
        Inventory.getAllParts().set(index,selectedPart);
    }
    public static void updateProduct(int index, Product newProduct){
        Inventory.getAllProducts().set(index, newProduct);
    }
    public static boolean deletePart(Part selectedPart){
        if (allParts.contains(selectedPart)) {
            allParts.remove(selectedPart);
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean deleteProduct(Part selectedProduct){
        if (allProducts.contains(selectedProduct)) {
            allProducts.remove(selectedProduct);
            return true;
        }
        else {
            return false;
        }
    }

    public static ObservableList<Part> getAllParts(){
        return allParts;
    }
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }
}
