
package videorent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The type Rental.
 * Rental is derived from Film and Customer classes
 */
public class Rental extends Customer implements Serializable{
    /**
     * The All customers.
//     */
////    public Map allCustomers = new HashMap();
    /**
     * The All films.
     */
    public Map allFilms = new HashMap();
    private double sumStartRentalPrice;
    private double sumEndRentalPrice;
    private double sumPayWithBonusPointsPrice;
    private  double bonusPointsPrice;

    /**
     * The constant PREMIUM_PRICE.
     */
    public static final int PREMIUM_PRICE = 4;
    /**
     * The constant BASIC_PRICE.
     */
    public static final int BASIC_PRICE = 3;
    private double extraPrice;
    private String rentalFilmName;
    private String rentalFilmType;
    private String rentalCustomerName;
    private int rentalBonusPoints;
    private  double rentalPrice;
    private int bonusPointsForRental;
    /**
     * The Price.
     */
    protected double price;
    /**
     * The Rental period.
     */
    protected int rentalPeriod;

    /**
     * Gets rental period.
     *
     * @return the rental period
     */
    public int getRentalPeriod() {
        return this.rentalPeriod;
    }

    /**
     * Gets rental film name.
     *
     * @return the rental film name
     */
    public String getRentalFilmName() {
        return this.rentalFilmName;
    }

    /**
     * Instantiates a new Rental.
     */
    public Rental() {
    }

    /**
     * Gets rental film type.
     *
     * @return the rental film type
     */
//    public String getRentalFilmType() {
//        return this.rentalFilmType;
//    }

    /**
     * Sets rental period.
     *
     * @param rentalPeriod the rental period
     */
    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    /**
     * Instantiates a new Rental.
     *
     * @param film         the film
     * @param customer     the customer
     * @param rentalPeriod the rental period
     */
    Rental(Film film, Customer customer, int rentalPeriod) {
        this.rentalFilmName = film.getFilmName();
        this.rentalFilmType = film.getFilmType();
        this.rentalCustomerName = customer.getCustomerName();
        this.bonusPoints = customer.getBonusPoints();
        this.rentalPeriod = rentalPeriod;
        this.price = calculatePrice();
    }

    /**
     * Make rental.
     *
     * @param filmNameInput     the film name input
     * @param customerNameInput the customer name input
     * @param period            the period
     * @return the double
     */
    public double makeRental(String filmNameInput, String customerNameInput, int period) {
        Inventory inventory = new Inventory();
        String tempFilmName = filmNameInput;
        Film fi = (Film) Inventory.allFilms.get(tempFilmName);
        String fiType = fi.filmType;
        inventory.getFilmState(fi);
        String tempClientName = customerNameInput;
        Customer cust = (Customer) Inventory.allCustomers.get(tempClientName);
        inventory.changeFilmState(tempFilmName);

        Rental rental = new Rental(fi, cust, period);
        this.rentalFilmName = fi.getFilmName();
        this.rentalCustomerName = cust.getCustomerName();
        this.bonusPoints = cust.getBonusPoints();
        this.price = calculatePrice();
        this.rentalPeriod = rental.rentalPeriod;
        this.rentalFilmType = fiType;


        rentalPrice = calculatePrice();
        inventory.addBonusPointsInDB(tempClientName, getBonusPoints()
        );

        System.out.println("*" + rentalFilmName + " (" + rentalFilmType + ") " + rentalPeriod
                + " days " +  rentalPrice + " EUR" + " Bonus points: " +
                inventory.getBonusPointsFromDB(tempClientName));
        sumPrice();


        inventory.addRental(rental);

        return rentalPrice;
    }

    /**
     * Calculate price double.
     *
     * @return the double
     */
    public double calculatePrice() {

        if (Objects.equals(rentalFilmType, "New Release")) {

            setBonusPoints(2);



            price = PREMIUM_PRICE * rentalPeriod;
            ///////////REGULAR  FILMS-----------------------------

        } else if (Objects.equals(rentalFilmType, "Regular Film")) {
            setBonusPoints(1);
            if (rentalPeriod >= 3){

                price = (BASIC_PRICE + ((rentalPeriod - 3) * BASIC_PRICE));
            } else {

                price = BASIC_PRICE;}

            ///////////////////////////OLD FILMS



        } else if (Objects.equals(rentalFilmType, "Old Film")) {
            setBonusPoints(1);
            if (rentalPeriod >= 5){

                price = (BASIC_PRICE + ((rentalPeriod - 5) * BASIC_PRICE));}
            else {
                price = BASIC_PRICE;}

            ///////////////////////////OLD FILMS



        }
//    }
        return price;
    }

    /**
     * Pay with bonus points double.
     *
     * @param filmNameInput the name
     * @param custNameInput the cust name input
     * @param rentalPeriod  the rental period
     * @return the double
     */
    public double payWithBonusPoints(String filmNameInput, String custNameInput, int rentalPeriod){
        Inventory inventory = new Inventory();
//        Map allCustomers = new HashMap<String, Customer>();
//        Map allCustomers = new HashMap<String, Customer>();
        Customer cust = (Customer) inventory.allCustomers.get(custNameInput);
        String custName = cust.getCustomerName();
        Film fi = (Film) inventory.allFilms.get(filmNameInput);
        String fiType = fi.getFilmType();

        inventory.changeFilmState(filmNameInput);
        int tempbonusPoints = inventory.getBonusPointsFromDB(custNameInput);
        int tempPeriod = rentalPeriod;

        if (Objects.equals(fiType, NEW_RELEASE) && tempbonusPoints >= 25){


            while (tempbonusPoints > 25 && tempPeriod > 0){

                tempbonusPoints -= 25;
                tempPeriod -= 1;}
            bonusPointsPrice = PREMIUM_PRICE * tempPeriod;

            System.out.println(fi.getFilmName() + "(" + fi.getFilmType() +
                    ") " + rentalPeriod + " days");
            System.out.println("Paid with "+ (inventory.getBonusPointsFromDB(custNameInput) - tempbonusPoints)
                    +  "  bonus points!");
        }



        else if (!Objects.equals(fiType, NEW_RELEASE)){
            System.out.println("You can't pay with bonus points for this entry!");
        } else if (tempbonusPoints < 25){
            System.out.println("You do not have enough bonus points tu use! Must pay with cash!");
        }


        System.out.println("Remaining Bonus POints :  " + tempbonusPoints);

        inventory.resetBonusPointsInDB(custName, tempbonusPoints);
        inventory.addBonusPointsInDB(custName,2);
        sumPrice();
        return bonusPointsPrice ;
    }

    /**
     * End rental double.
     *
     * @param filmNameInput      the name
     * @param actualRentalPeriod the actual rental period
     * @return the double
     */
    public double endRental(String filmNameInput, int actualRentalPeriod) {

        Inventory inventory = new Inventory();

        Film fi = (Film) inventory.allFilms.get(filmNameInput);
        String type = fi.getFilmType();

        boolean bu = fi.getIsRented();
        inventory.changeFilmState(filmNameInput);
        Rental re = (Rental) inventory.allRentals.get(filmNameInput);
        int rentalPeriod = re.rentalPeriod;
        if (actualRentalPeriod > rentalPeriod) {
            int extraPeriod = actualRentalPeriod - rentalPeriod;
            if (type == "New Release") {
                extraPrice = PREMIUM_PRICE * extraPeriod;
            } else {
                extraPrice = BASIC_PRICE * extraPeriod;
            }
            System.out.println(filmNameInput + " " + "(" + type + ") " + extraPeriod + " extra days "  + extraPrice + " EUR");
        }
        sumPrice();
        return extraPrice;}

    /**
     * Sum price double.
     *
     * @return the double
     */
    public double sumPrice(){
        sumPayWithBonusPointsPrice += bonusPointsPrice;
        sumStartRentalPrice += this.rentalPrice;
        sumEndRentalPrice += this.extraPrice;
        return sumStartRentalPrice;
    }

    /**
     * Add bonus points for rental int.
     *
     * @param bonusPoints the bonus points
     * @return the int
     */
//    public int addBonusPointsForRental(int bonusPoints){
//
//        bonusPointsForRental += bonusPoints;
//        return bonusPointsForRental;
//    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        WriteInFile writeInFile = new WriteInFile();
        Inventory inventory = new Inventory();
        Film fm1 = new Film();
        Rental rental1 = new Rental();
        ///ADDING CUSTOMERS TO DB
        Customer cu2 = new Customer("Bob", 100);
        Customer cu3 = new Customer("Josh", 28);
        Customer cu1 = new Customer("John", 0);
        inventory.addCustomer(cu1);
        inventory.addCustomer(cu2);
        inventory.addCustomer(cu3);
//        ADDING FILMS TO DB
//        inventory.addFilm(new Film("AAAAAA", "Old Film", false));
//        inventory.addFilm(new Film("UUUUUU", "Regular Film", false));
        inventory.addFilm(new Film("LO___OL", "Old Film", false));
        inventory.addFilm(new Film("RA___AR", "Old Film", false));
        inventory.addFilm(new Film("Matrix", "New Release", false));
        inventory.addFilm(new Film("Out of Africa", "Old Film", false));
        inventory.addFilm(new Film("BO___OB", "Old Film", false));
        inventory.addFilm(new Film("Matrix 11", "New Release", false));
        inventory.addFilm(new Film("Spider man", "Regular Film", false));
        inventory.addFilm(new Film("Spider man 2", "Regular Film", false));
//        Film fm2 = new Film();
//        Film fm3 = new Film();
//        Film fm4 = new Film();
//        new HashMap();
//        new HashMap();

//        new Customer();

//        new Rental(fm3, cu2, 5);
//        new Rental(fm4, cu2, 2);
//        new Rental(fm2, cu2, 7);

        System.out.println("----------------------- REGULAR RENTAL -----------------------------------------------");
        rental1.makeRental("Spider man","Bob",5);
        rental1.makeRental("Matrix 11","Bob",1);
        rental1.makeRental("Spider man 2","Bob",2);
        rental1.makeRental("Out of Africa","Bob",7);
        System.out.println("Total price: " + rental1.sumStartRentalPrice);

        System.out.println("--------------------- LATE RETURN -------------------------------------------------------");
        rental1.endRental("Matrix 11",3);
        rental1.endRental("Spider man",6);
        System.out.println(("Total price: " + rental1.sumEndRentalPrice));
        System.out.println("------------------------ PAY WITH BONUS POINTS -------------------------------------------------------");
        rental1.payWithBonusPoints("Matrix 11","Josh",1);
        System.out.println(("Total price: " + rental1.sumPayWithBonusPointsPrice));
        System.out.println("---------- INVENTORY LIST ALL FILMS  ------------------------------------");
        inventory.listAllFilms();
        System.out.println("--------- ADD FILM  ------------------------");
        inventory.addFilm(new Film("Newly Added Film", "Old Film", false));
        System.out.println("---------------------------------");
//        inventory.listAllFilms();
        System.out.println("--------- DELETE FILM ------------------------");
        inventory.deleteFilm("RA___AR");
        inventory.deleteFilm("LO___OL");
        System.out.println("---------------------------------");
        inventory.listAllFilms();
        System.out.println("---------- CHANGE TYPE OF FILM --------------------");
        System.out.println("Before: " + inventory.getFilmType("Out of Africa"));
        inventory.changeTypeOfFilm("Out of Africa", "New Release");
        System.out.println("After:  " + inventory.getFilmType("Out of Africa"));
        System.out.println("---------- All available films --------------------");
        inventory.listAllFilmsAvailable();
//        writeInFile.serialIn();
//        writeInFile.unserOut();
        writeInFile.unserOutFiltered();
    }
}
