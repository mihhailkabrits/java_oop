
package videorent;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Customer.
 * Customer class have fields name and bonus points
 * for Customer objects
 */
public class Customer extends Film implements Serializable{
    /**
     * The Rental period.
     */
    protected int rentalPeriod;
    /**
     * The Customer name.
     */
    protected String customerName;
    /**
     * The Bonus points.
     */
    protected int bonusPoints;
    /**
     * The Price.
     */
    protected int price;
    /**
     * The All customers.
     */
    static ArrayList<Customer> allCustomers = new ArrayList();
    /**
     * The Film.
     */
    Film film = new Film();

    /**
     * Instantiates a new Customer.
     *
     * @param customerName the customer name
     * @param bonusPoints  the bonus points
     */
    public Customer(String customerName, int bonusPoints) {
        this.customerName = customerName;
        this.bonusPoints = bonusPoints;
    }

    /**
     * Gets customer name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * Instantiates a new Customer.
     */
    Customer() {
    }

    /**
     * Gets bonus points.
     *
     * @return the bonus points
     */
    public int getBonusPoints() {
        return this.bonusPoints;
    }

    public String getFilmType() {
        return super.filmType;
    }

    /**
     * Sets bonus points.
     *
     * @param tempPoints the temp points
     * @return the bonus points
     */
    public int setBonusPoints(int tempPoints) {
        bonusPoints = tempPoints;
        return bonusPoints;
    }

    /**
     * Substract bonus points.
     */
    public void substractBonusPoints() {
        this.bonusPoints -= 25;
    }
}

