package uo.mp.lab05.dome.model;

public interface Borrowable {

    void borrow();

    void giveBack();

    boolean isAvailable();
}
