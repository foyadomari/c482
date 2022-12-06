package model;

/**
 * InHouse public class
 *
 * Inherits from the Part class for parts that are In-House
 *
 * @author Felice Oyadomari III
 */
public class InHouse extends Part{

    private int machineId;

    /**
     * InHouse model constructor
     *
     * @param id = part ID
     * @param name = part Name
     * @param price = part price
     * @param stock = part inventory level
     * @param min = part minimum inventory level
     * @param max = part maximum inventory level
     * @param machineId = machine ID
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /**
     *
     * @return the Machine ID
     */
    public int getMachineId() {

        return machineId;
    }

    /**
     * Sets the Machine ID
     *
     * @param machineId
     */
    public void setMachineId(int machineId) {

        this.machineId = machineId;
    }
}
