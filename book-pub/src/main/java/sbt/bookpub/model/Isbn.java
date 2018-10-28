package sbt.bookpub.model;

import org.springframework.util.Assert;

public class Isbn {

    private String eanPrefix;
    private String registrationGroup;
    private String registrant;
    private String publication;
    private String checkDigit;

    public Isbn() {}

    public Isbn(String eanPrefix, String registrationGroup, String registrant, String publication, String checkDigit) {
        this.eanPrefix = eanPrefix;
        this.registrationGroup = registrationGroup;
        this.registrant = registrant;
        this.publication = publication;
        this.checkDigit = checkDigit;
    }

    public String getEanPrefix() {
        return eanPrefix;
    }

    public void setEanPrefix(String eanPrefix) {
        this.eanPrefix = eanPrefix;
    }

    public String getRegistrationGroup() {
        return registrationGroup;
    }

    public void setRegistrationGroup(String registrationGroup) {
        this.registrationGroup = registrationGroup;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getCheckDigit() {
        return checkDigit;
    }

    public void setCheckDigit(String checkDigit) {
        this.checkDigit = checkDigit;
    }

    public static Isbn parseFrom(String isbn) {
        Assert.notNull(isbn, "isbn should not be null");
        String[] arr = isbn.split("-");
        Assert.state(arr.length == 5, "isb should have 5 part");
        Assert.noNullElements(arr, "any part should not be null");
        return new Isbn(arr[0], arr[1], arr[2], arr[3], arr[4]);
    }

    @Override
    public String toString() {
        return String.format("%s-%s-%s-%s-%s", this.eanPrefix,
                this.registrationGroup,
                this.registrant,
                this.publication,
                this.checkDigit);
    }
}
