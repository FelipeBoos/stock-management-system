package domain;

/**
 * Represents the possible states of an order
 */

public enum PedidoStatus {
    /**
     * Order is being created and can be edited
     */
    RASCUNHO,

    /**
     * Order has been confirmed and stock was updated
     */
    CONFIRMADO,

    /**
     * Order was canceled and cannot be modified
     */
    CANCELADO
}
