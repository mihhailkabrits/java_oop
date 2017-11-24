package videorent;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The type Inventory.
 * Stores all nessesery  data.
 * in HashMap objects a
 */
public class Inventory extends Rental implements Serializable{
    /**
     * The WriteInFile.
     */
    WriteInFile writeInFile = new WriteInFile();
    /**
     * The Film.
     */
    Film film = new Film();
    /**
     * The constant allCustomers.
     */
    public static Map allCustomers = new HashMap();
    /**
     * The constant allFilms.
     */
    public static Map allFilms = new HashMap();
    /**
     * The constant allRentals.
     */
    public static Map allRentals = new HashMap();

    /**
     * Instantiates a new Inventory.
     */
    public Inventory() {
    }

    /**
     * Adds rental.
     *
     * @param rental the rental
     */
/**
* --------------------------------------------------  FILMS -----------------------------------------------
* */
    /**
     * Add film.
     *
     * @param film the film
     */
    public void addFilm(Film film) {
        String tem = film.filmName;
        allFilms.put(tem, film);
        writeInFile.serialIn();

        Film value = (Film) allFilms.get(tem);
    }
    /**
     * Gets film state.
     *
     * @param film the film
     * @return the film state
     */
    public boolean getFilmState(Film film) {
        String tempFilmName = film.getFilmName();

        Film value = (Film) allFilms.get(tempFilmName);
        boolean tempState = value.getIsRented();
        return tempState;
    }   /**
     * Gets film type.
     *
     * @param filmNameInput the film name input
     * @return the film type
     */
    public String getFilmType(String filmNameInput) {
//        String tempFilmName = film.getFilmName();
        Film value = (Film) allFilms.get(filmNameInput);
        String filType = value.getFilmType();
        return filType;
    } /**
     * List all films.
     */
    public void listAllFilms() {
//        List<String> result = new ArrayList(allFilms.keySet());
//        System.out.println(result + " it is a complete film's list");
        writeInFile.unserOut();
    }   /**
     * List all films available.
     */
    public void listAllFilmsAvailable() {
        Set entrySet = allFilms.entrySet();
//        Iterator it = entrySet.iterator();

//        while (it.hasNext()) {
//            Map.Entry me = (Map.Entry) it.next();
//            Film fe = (Film) allFilms.get(me.getKey());
//            if (!fe.getIsRented()) {
//                System.out.println("Name of film: " + me.getKey()
////                        + " & " + " value is: " + fe.getFilmName()
//                );
//            }
//        }
        writeInFile.unserOutFiltered();
    }  /**
     * Delete film.
     *
     * @param filmToRemove the film to remove
     */
    public void deleteFilm(String filmToRemove) {
        Object removedElement1 = allFilms.remove(filmToRemove);
        writeInFile.serialIn();
    } /**
     * Change type of film.
     *
     * @param targetFilmName the target film name
     * @param newFilmType    the new film type
     */
    public void changeTypeOfFilm(String targetFilmName, String newFilmType) {
        Film value = (Film) allFilms.get(targetFilmName);
        value.setFilmType(newFilmType);
        String tem = this.film.filmName;
        allFilms.put(targetFilmName, value);
        writeInFile.serialIn();
        Film value2 = (Film) allFilms.get(targetFilmName);
    }/**
     * Change film state.
     *
     * @param tempName the temp name
     */
    public void changeFilmState(String tempName) {
        Film value = (Film) allFilms.get(tempName);
        value.setRented();
        allFilms.put(tempName, value);
        writeInFile.serialIn();
        Film value3 = (Film) allFilms.get(tempName);
    }
    /**
     * * --------------------------------------------------  RENTALS -----------------------------------------------
     *
     * @param rental the rental
     */
    public void addRental(Rental rental) {
    String tem = rental.getRentalFilmName();
    allRentals.put(tem, rental);
    writeInFile.serialRentalIn();
}
/**
 * --------------------------------------------------  CUSTOMERS -----------------------------------------------
 ** */
    /**
     * Add customer.
     *
     * @param customer the customer
     */
    public void addCustomer(Customer customer) {
        String tem = customer.getCustomerName();
        allCustomers.put(tem, customer);
        writeInFile.serialCustomerIn();
    }
    /**
     * Gets customer.
     *
     * @param customerName the customer name
     * @return the customer
     */
    public Customer getCustomer(String customerName) {
        return (Customer) allCustomers.get(customerName);
    }


    /**
     * Reset bonus points in db.
     *
     * @param rentalCustomerName the rental customer name
     * @param tempbonusPoints    the tempbonus points
     */
    public void resetBonusPointsInDB(String rentalCustomerName, int tempbonusPoints) {
        Customer value = (Customer) allCustomers.get(rentalCustomerName);
        value.bonusPoints = tempbonusPoints;
        allCustomers.put(this.customerName, value);
        writeInFile.serialCustomerIn();
    }
    /**
     * Add bonus points in db.
     *
     * @param rentalCustomerName the rental customer name
     * @param tempbonusPoints    the tempbonus points
     */
    public void addBonusPointsInDB(String rentalCustomerName, int tempbonusPoints) {
        Customer value = (Customer) allCustomers.get(rentalCustomerName);
        value.bonusPoints += tempbonusPoints;
        allCustomers.put(this.customerName, value);
        writeInFile.serialCustomerIn();
    }

    /**
     * Substract bonus points from db.
     *
     * @param tempName the temp name
     */
    public void substractBonusPointsFromDB(String tempName) {
        Customer value = (Customer) allCustomers.get(tempName);
        int tempPoints = value.getBonusPoints();
        if (tempPoints <= 25) {
            value.substractBonusPoints();
        } else {
            System.out.println("Not enough bonus points!");
        }

        allCustomers.put(tempName, value);
        writeInFile.serialCustomerIn();
    }/**
     * Gets bonus points from db.
     *
     * @param name the name
     * @return the bonus points from db
     */
    public int getBonusPointsFromDB(String name) {
        Customer value = (Customer) allCustomers.get(name);
        int tempPoints = value.getBonusPoints();
        this.bonusPoints = tempPoints;
        return this.bonusPoints;
    }
}
