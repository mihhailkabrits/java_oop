package videorent;

import java.io.*;
import java.util.*;

import static videorent.Inventory.allCustomers;
import static videorent.Inventory.allFilms;
import static videorent.Inventory.allRentals;

/**
 * The type Write in file.
 */
public class WriteInFile implements Serializable {

    /**
     * Serializing FILM containing Hashmap objects and saving to filmHashMap.ser file
     */
    public void serialIn(){
//        System.out.println("writeInFile print + " + allFilms);
        try
        {
            FileOutputStream fos =
                    new FileOutputStream("filmHashMap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(allFilms);
            oos.close();
            fos.close();

        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    /**
     * Deserialized FILM Hashmap file output.
     */
    public void unserOut(){
        HashMap<String, Film> mapUnser = null;
        try
        {
            FileInputStream fis = new FileInputStream("filmHashMap.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            mapUnser = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }


        System.out.println("Deserialized HashMap..");
        // Display content using Iterator
        Set set = mapUnser.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key: " + mentry.getKey() + " UNSERIAL Value: ");
            System.out.println(mentry.getValue());
        }
    }

    /**
     * Deserialized and filtered  Film hashmap file data.
     */
    public void unserOutFiltered(){
        HashMap<String, Film> mapUnserFiltered = null;
        try
        {
            FileInputStream fis2 = new FileInputStream("filmHashMap.ser");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            mapUnserFiltered = (HashMap) ois2.readObject();
            ois2.close();
            fis2.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        Set set = mapUnserFiltered.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterator.next();

            Film fe = (Film) mapUnserFiltered.get(mentry2.getKey());
            if (!fe.getIsRented()) {
            System.out.print(" FREE UNSERIAL film : " + mentry2.getKey());
//            System.out.println(mentry2.getValue());
        }



            }
        }

    /**
     * -------------------------------- SERIALIZE CUSTOMER ------------------------------------------
     *



     *
     *
     */

    /**
     * Serializing  Customer objects and saving to customerHashMap.ser
     */
    public void serialCustomerIn(){
//        System.out.println("writeInFile print + " + allFilms);
        try
        {
            FileOutputStream fos =
                    new FileOutputStream("customerHashMap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(allCustomers);
            oos.close();
            fos.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    /**
     * Deserializing customer out.
     */
    public void serialCustomerOut(){
        HashMap<String, Customer> mapUnserCustomer = null;
        try
        {
            FileInputStream fis = new FileInputStream("customerHashMap.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            mapUnserCustomer = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }


        System.out.println("customerHashMap HashMap..");
        // Display content using Iterator
        Set set = mapUnserCustomer.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterator.next();
            System.out.print("key: " + mentry2.getKey() + " UNSERIAL Value: ");
            System.out.println(mentry2.getValue());
        }
    }

    /**
     * -------------------------------------- SERIALIZE RENTALS-----------------------------------------
     */

    /**
     * Serializing Rentals objects containing hashmap and saving into rentalsHashMap.ser
     */
    public void serialRentalIn(){
//        System.out.println("writeInFile print + " + allFilms);
    try
    {
        FileOutputStream fos =
                new FileOutputStream("rentalsHashMap.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(allRentals);
        oos.close();
        fos.close();
    }catch(IOException ioe)
    {
        ioe.printStackTrace();
    }
}

    /**
     * Deserializing rentalsHashMap.ser
     */
    public void serialRentalOut(){
        HashMap<String, Rental> mapUnserRental = null;
        try
        {
            FileInputStream fis = new FileInputStream("rentalsHashMap.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            mapUnserRental = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }


        System.out.println("rentalsHashMap HashMap..");
        // Display content using Iterator
        Set set = mapUnserRental.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry3 = (Map.Entry) iterator.next();
            System.out.print("key: " + mentry3.getKey() + " UNSERIAL Value: ");
            System.out.println(mentry3.getValue());
        }
    }

    }


