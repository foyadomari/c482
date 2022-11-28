package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product extends Part {


    public Product(int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
    }
}
