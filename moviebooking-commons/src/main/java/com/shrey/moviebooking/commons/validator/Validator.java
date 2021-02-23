package com.shrey.moviebooking.commons.validator;

/**
 * 
 * @author Shrey
 *
 * @param <T>
 */
public interface Validator<T> {

	boolean validate(T t);

}
