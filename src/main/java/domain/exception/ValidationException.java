package domain.exception;

/**
 * Exception thrown when input data validation fails.
 * 
 * Used for invalid or missing fields before applying business rules.
 * Examples:
 * - Empty names
 * - Negative values
 * - Invalid formats
 */
public class ValidationException extends BusinessException{
    public ValidationException(String message) {
        super(message);
    }
}
