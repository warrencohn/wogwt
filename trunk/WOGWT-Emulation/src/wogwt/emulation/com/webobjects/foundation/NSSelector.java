package com.webobjects.foundation;

import java.io.Serializable;

public class NSSelector<T> implements Serializable {

	private String name;
	private Class[] parameterTypes;
	
	public NSSelector(String name) {
		super();
		this.name = name;
	}
	
	public NSSelector(String name, Class[] parameterTypes) {
		this(name);
		this.parameterTypes = parameterTypes;
	}
	
	public String name() {
		return name;
	}
	
	public Class[] parameterTypes() {
		return parameterTypes;
	}
	
	public boolean implementedByClass(Class targetClass) {
		return false;
	}
	
	public boolean implementedByObject(Object target) {
		return false;
	}
	
	public T invoke(Object arg0, Object[] arg1) throws IllegalArgumentException {
		return null;
	}
	
	public T invoke(Object target) throws IllegalArgumentException {
		return null;
	}
	
	public T invoke(Object target, Object argument)
			throws IllegalArgumentException {
		return null;
	}
	
	public T invoke(Object target, Object argument1, Object argument2)
			throws IllegalArgumentException {
		return null;
	}
	
}
