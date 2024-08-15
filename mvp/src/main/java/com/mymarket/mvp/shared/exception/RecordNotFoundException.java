package com.mymarket.mvp.shared.exception;

/**
 * Thrown when a record is not found.
 *
 * @since 1.0
 * @author Pedro Lucas
 *
 */
public class RecordNotFoundException extends IllegalArgumentException {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = -4238720296810908657L;

    /**
     * Constructs a RecordNotFoundException with the specified detail message.
     *
     * @param message the detail message.
     */
    public RecordNotFoundException(String message) {
        super(message + " not found.");
    }

    /**
     * Constructs a RecordNotFoundException with the specified record id.
     *
     * @param id the record id.
     */
    public RecordNotFoundException(Long id) {
        super("Record with the given id " + id + " not found.");
    }
}