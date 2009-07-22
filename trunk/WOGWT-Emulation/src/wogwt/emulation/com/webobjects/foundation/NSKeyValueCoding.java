package com.webobjects.foundation;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public interface NSKeyValueCoding {

	public void takeValueForKey(Object value, String key);
	public Object valueForKey(String key);
	
	public interface ErrorHandling {
		
		public Object handleQueryWithUnboundKey(String key);
		public void handleTakeValueForUnboundKey(Object value, String key);
		public void unableToSetNullForKey(String key);
		
	}
	
	public static final Null NullValue = new Null();
	
	public static final class Null<T> implements Serializable, Cloneable, IsSerializable {

		public Null() {
			super();
		}
		
		public Object clone() {
			return this;
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj != null && obj instanceof Null;
		}
		
		@Override
		public String toString() {
			return "NSKeyValueCoding.NullValue";
		}
		
	}
	
	public static class UnknownKeyException extends RuntimeException {
		
		public static final transient String TargetObjectUserInfoKey = "NSTargetObjectUserInfoKey";
		public static final transient String UnknownUserInfoKey = "NSUnknownUserInfoKey";
		private String _key;
		private Object _object;
		
		public UnknownKeyException(String message, Object object, String key) {
			super(message);
		}
		
		public String key() {
			return _key;
		}
		
		public Object object() {
			return _object;
		}
		
		@Override
		public String toString() {
			return super.toString();
		}
	}
}
