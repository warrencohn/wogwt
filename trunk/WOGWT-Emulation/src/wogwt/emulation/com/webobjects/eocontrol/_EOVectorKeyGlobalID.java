package com.webobjects.eocontrol;

import java.util.Arrays;

public class _EOVectorKeyGlobalID extends EOKeyGlobalID {

	/* this differs from WO which uses Object[] because doing so would
	   cause every class to be brought in for serialization */
	protected Number[] _values;
	
	public _EOVectorKeyGlobalID(String entityName, Object[] keyValues) {
		super(entityName, _hashCode(entityName, keyValues));
		_values = (Number[]) keyValues;
	}

	@Override
	public int keyCount() {
		return _values.length;
	}

	@Override
	public Object[] keyValues() {
		return _values;
	}

	private static int _hashCode(String entityName, Object[] keyValues) {
		int result = entityName.hashCode();
		for (int i = 0; i < keyValues.length; i++) {
			if (keyValues[i] != null) {
				result += keyValues[i].hashCode();
			}
		}
		return result;
	}
	
	@Override
	public Object clone() {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		_EOVectorKeyGlobalID other = (_EOVectorKeyGlobalID) obj;
		if (!entityName().equals(other.entityName()))
			return false;
		if (!Arrays.equals(_values, other._values))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "_EOVectorKeyGlobalID(" + entityName() + ", " + Arrays.toString(_values) + ")";
	}
	
}
