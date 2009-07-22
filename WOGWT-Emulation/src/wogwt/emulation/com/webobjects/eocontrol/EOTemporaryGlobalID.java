package com.webobjects.eocontrol;

import java.util.Arrays;

public class EOTemporaryGlobalID extends EOGlobalID {

	public static int UniqueBinaryKeyLength = 24;
	
	public static EOTemporaryGlobalID _gidForRawBytes(byte[] bytes) {
		return new EOTemporaryGlobalID(bytes);
	}
	
	private byte[] _bytes;
	//private int _hashCode;
	
	public EOTemporaryGlobalID() {
		super();
	}
	
	protected EOTemporaryGlobalID(byte[] globallyUniqueBytes) {
		super();
		_bytes = globallyUniqueBytes;
	}

	public boolean isTemporary() {
		return true;
	}

	public byte[] _rawBytes() {
		return _bytes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(_bytes);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EOTemporaryGlobalID other = (EOTemporaryGlobalID) obj;
		if (!Arrays.equals(_bytes, other._bytes))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EOTemporaryGlobalID(" + Arrays.toString(_bytes) + ")";
	}
	
}
