package travelOffice.exceptions;

public class NoSuchCustomerException extends Exception {

    private final String MESSAGE = "Nie ma klienta o nazwisku ";

    public NoSuchCustomerException() {

    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
