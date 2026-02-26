package domain.exception;

/**
 * Exception thrown when a requested entity cannot be found.
 * 
 * Commonly used when searching by ID or unique identifiers.
 */

public class NotFoundException extends BusinessException {
    public NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException of(String entity, Object id) {
        return new NotFoundException(entity + " not found: " + id);
    }
}
