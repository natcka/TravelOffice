package travelOffice.exceptions;

public class NoSuchTripExcepton extends Exception {

    private final String MESSAGE = "W bazie nie ma wycieczki do ";

    public NoSuchTripExcepton() {

    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
