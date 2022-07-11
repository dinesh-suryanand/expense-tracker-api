package in.dinesh.expencetrackerapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final Long serialVersionID = 1l;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
