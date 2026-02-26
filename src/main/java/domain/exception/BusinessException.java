package domain.exception;

/**
 * Base exception for business rule violations.
 * 
 * Thrown when an operation is not allowed according to domain rules.
 * Examples:
 * - Invalid state transitions
 * - Forbidden operations
 * - Domain constraints violations
 */

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
