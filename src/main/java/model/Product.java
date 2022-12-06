package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Product public class
 */
public class Product {

    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    private static int Id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**
     * Product model constructor
     *
     * @param id = product ID
     * @param name = product name
     * @param price = product price
     * @param stock = product inventory level
     * @param min = product minimum inventory level
     * @param max = product maximum inventory level
     */
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.Id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * Gets the product's ID
     *
     * @return product ID
     */
    public static int getId() {
        return Id;
    }

    /**
     * Sets the product's ID
     * @param id
     */
    public static void setId(int id) {
        Id = id;
    }

    /**
     * Gets the product's name
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the product's price
     * @return product's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product's price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the product's inventory level
     * @return the inventory level
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the product's inventory level
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets the product's minimum inventory level
     * @return the minimum inventory level
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets the product's minimum inventory level
     * @param min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Gets the product's maximum inventory level
     * @return the maximum inventory level
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets the product's maximum inventory level
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Adds the associated parts to the associated parts list
     * @param part
     */
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }

    /**
     * Deletes the associated parts from the associated parts list
     * @param selectedAssociatedPart
     * @return true if successful or false if unsuccessful
     */
    public boolean deleteAssociatedPart(Part selectedAssociatedPart){
        if (associatedParts.contains(selectedAssociatedPart)){
            associatedParts.remove(selectedAssociatedPart);
            return true;
        }
        else
            return false;
    }

    /**
     * Gets product's associated parts
     * @return the product's associated parts
     */
    public ObservableList<Part> getAllAssociatedParts(){
        return associatedParts;
    }

}
