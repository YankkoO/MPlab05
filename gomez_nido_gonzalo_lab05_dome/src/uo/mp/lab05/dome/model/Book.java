package uo.mp.lab05.dome.model;

import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

public class Book extends Item implements Borrowable {

    public final static double BOOK_TAX = 0.04; //4%

    private static final String ERR_ISBN_FORMAT = "ISBN format is not valid";

    private String writer;
    private String publisher;
    private String ISBN; //X00000
    private boolean borrowed;

    public Book(String theTitle, double thePrice, String writer,
            String publisher, String isbn) {

        super(theTitle, thePrice);

        this.writer = writer;
        this.publisher = publisher;
        setISBN(isbn);
    }

    /**
     * @return the writer
     */
    public String getWriter() {
        return writer;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @return the iSBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param writer the writer to set
     */
    public void setWriter(String writer) {

        ArgumentChecks.isNotNull(writer, "Invalid writer");
        ArgumentChecks.isNotBlank(writer, "Invalid writer");

        this.writer = writer;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {

        ArgumentChecks.isNotNull(publisher, "Invalid publisher");
        ArgumentChecks.isNotBlank(publisher, "Invalid publisher");

        this.publisher = publisher;
    }

    /**
     * @param iSBN the iSBN to set
     */
    public void setISBN(String iSBN) {

        //PARAM CHECKS
        ArgumentChecks.isNotBlank(iSBN, ERR_ISBN_FORMAT);
        ArgumentChecks.isNotNull(iSBN, ERR_ISBN_FORMAT);
        ArgumentChecks.isTrue(Character.isLetter(iSBN.charAt(0)),
                ERR_ISBN_FORMAT);
        ArgumentChecks.isTrue(iSBN.length() == 5, ERR_ISBN_FORMAT);

        this.ISBN = iSBN;
    }

    @Override
    public String getResponsible() {
        return getWriter();
    }

    @Override
    public double getFinalPrice() {
        return (getPrice() + (getPrice() * BOOK_TAX));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(ISBN, writer);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(ISBN, other.ISBN)
                && Objects.equals(writer, other.writer);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book [");
        builder.append(super.toString());
        builder.append(", writer=");
        builder.append(writer);
        builder.append(", publisher=");
        builder.append(publisher);
        builder.append(", ISBN=");
        builder.append(ISBN);
        builder.append(", borrowed=");
        builder.append(borrowed);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public void borrow() {
        if (isAvailable()) {
            this.borrowed = true;
        }
    }

    @Override
    public void giveBack() {
        if (this.borrowed) {
            this.borrowed = false;
        }
    }

    @Override
    public boolean isAvailable() {
        return isGotIt() && !this.borrowed;
    }

}
