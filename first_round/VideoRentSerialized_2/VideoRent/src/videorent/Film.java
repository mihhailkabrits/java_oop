
package videorent;

import java.io.Serializable;

/**
 * The type Film.
 * Film class is for Film type objects. Film has a name and type
 */
public class Film implements Serializable{
    /**
     * The constant NEW_RELEASE.
     */
    public static final String NEW_RELEASE = "New Release";
    /**
     * The constant REGULAR_FILM.
     */
    public static final String REGULAR_FILM = "Regular film";
    /**
     * The constant OLD_FILM.
     */
    public static final String OLD_FILM = "Old film";
    /**
     * The constant PREMIUM_PRICE.
     */
    public static final int PREMIUM_PRICE = 4;
    /**
     * The constant BASIC_PRICE.
     */
    public static final int BASIC_PRICE = 3;
    /**
     * The Film type.
     */
    protected String filmType;
    /**
     * The Film name.
     */
    protected String filmName;
    /**
     * The Is rented.
     */
    protected boolean isRented;

    /**
     * Sets rented.
     */
    public void setRented() {
        this.isRented = !this.isRented;
    }

    /**
     * Gets is rented.
     *
     * @return the is rented
     */
    public boolean getIsRented() {
        return this.isRented;
    }

    /**
     * Gets film name.
     *
     * @return the film name
     */
    public String getFilmName() {
        return this.filmName;
    }

    /**
     * Sets film type.
     *
     * @param filmType the film type
     */
    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    /**
     * Sets film name.
     *
     * @param filmName the film name
     */
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    /**
     * Instantiates a new Film.
     *
     * @param filmName the film name
     * @param filmType the film type
     * @param isRented the is rented
     */
    public Film(String filmName, String filmType, boolean isRented) {
        this.filmName = filmName;
        this.filmType = filmType;
    }

    /**
     * Sets film data.
     *
     * @param nm the nm
     * @param tp the tp
     * @param tr the tr
     */
    void setFilmData(String nm, String tp, boolean tr) {
        this.filmName = nm;
        this.filmType = tp;
        this.isRented = tr;
    }

    /**
     * Instantiates a new Film.
     */
    Film() {
    }

    /**
     * Gets film type.
     *
     * @return the film type
     */
    public String getFilmType() {
        return this.filmType;
    }
    @Override
    public String toString() {
        return "File :" + filmName + "   Type: " + filmType + "   State: " + isRented;
    }
}

