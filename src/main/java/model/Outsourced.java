package model;

/**
 * Outsourced public class
 *
 * Inherits from the Part class for parts that are Outsourced
 *
 * @author Felice Oyadomari III
 */

public class Outsourced extends Part{

    private String companyName;

    /**
     * Outsourced model constructor
     *
     * @param id = part ID
     * @param name = part name
     * @param price = part price
     * @param stock = part inventory level
     * @param min = part minimum inventory level
     * @param max = part maximum inventory level
     * @param companyName = Company name of part
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * Gets the part's company name
     *
     * @return the company's name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the part's company name
     *
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
