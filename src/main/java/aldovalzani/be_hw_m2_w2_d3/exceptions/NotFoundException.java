package aldovalzani.be_hw_m2_w2_d3.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Il record con id " + id + " non è stato trovato!");
    }
}
