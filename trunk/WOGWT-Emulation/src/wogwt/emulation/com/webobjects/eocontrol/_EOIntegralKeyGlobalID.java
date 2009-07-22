package com.webobjects.eocontrol;

import java.util.Arrays;


public class _EOIntegralKeyGlobalID extends EOKeyGlobalID {

	private Number keyValue;
	
	public _EOIntegralKeyGlobalID(String entityName, Number keyValue) {
		super(entityName, _hashCode(entityName, keyValue));
		this.keyValue = keyValue;
	}

	public _EOIntegralKeyGlobalID(String entityName, Object[] keyValues) {
		super(entityName, _hashCode(entityName, (Number) keyValues[0]));
		this.keyValue = (Number) keyValues[0];
	}
	
	@Override
	public int keyCount() {
		return 1;
	}

	@Override
	public Object[] keyValues() {
		return new Object[] {keyValue};
	}
	
	private static int _hashCode(String entityName, Number keyValue) {
		return entityName.hashCode() + keyValue.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		_EOIntegralKeyGlobalID other = (_EOIntegralKeyGlobalID) obj;
		if (!entityName().equals(other.entityName()))
			return false;
		if (!keyValue.equals(other.keyValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "_EOIntegralKeyGlobalID(" + entityName() + ", " + keyValue + ")";
	}
	
}
