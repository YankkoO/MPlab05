package uo.mp.lab04.dome.model;

public interface Borrowable {

    void borrow();

    void giveBack();

    boolean isAvailable();
}
