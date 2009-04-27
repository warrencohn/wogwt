package com.webobjects.eocontrol;

import com.webobjects.foundation.NSValidation;

public interface EOValidation extends NSValidation {

	public void validateClientUpdate() throws ValidationException;
	public void validateForDelete() throws ValidationException;
	public void validateForInsert() throws ValidationException;
	public void validateForSave() throws ValidationException;
	public void validateForUpdate() throws ValidationException;
	
}
