package com.mymarket.mvp.shared.exception;

/**
 * Thrown when attempting to add an element that already exists.
 *
 * @since 1.0
 * @author Pedro Lucas
 */
public class ElementAlreadyPresentException extends RuntimeException {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 2840412177337797635L;

    /**
     * Constructs an ElementAlreadyPresentException with the name of the element.
     *
     * @param elementName The name of the element.
     */
    public ElementAlreadyPresentException(String elementName) {
        super(elementName + " already present.");
    }

    /**
     * Constructs an ElementAlreadyPresentException with the element.
     *
     * @param elementName The element.
     */
    public ElementAlreadyPresentException(int elementName) {
        super(elementName + " already present.");
    }
}