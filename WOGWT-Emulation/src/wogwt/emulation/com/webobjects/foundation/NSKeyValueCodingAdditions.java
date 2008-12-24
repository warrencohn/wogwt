package com.webobjects.foundation;

public interface NSKeyValueCodingAdditions extends NSKeyValueCoding {

	public static final String KeyPathSeparator = ".";
	public static final String NOT_SUPPORTED = "Key value coding in WOGWT is not supported for arbitrary classes.";
		
	public static class DefaultImplementation {
		public static String firstPartOfKeyPath(String keyPath) {
			int dotIndex = keyPath.indexOf(NSKeyValueCodingAdditions.KeyPathSeparator);
			if (dotIndex == -1) {
				return keyPath;
			} else {
				return keyPath.substring(0, dotIndex);
			}	
		}
		
		public static String restOfKeyPath(String keyPath) {
			int dotIndex = keyPath.indexOf(NSKeyValueCodingAdditions.KeyPathSeparator);
			if (dotIndex == -1 || keyPath.length()-1 <= dotIndex) {
				return null;
			} else {
				return keyPath.substring(dotIndex+1);
			}	
		}
		
		public static void takeValueForKeyPath(Object object, Object value, String keyPath) {
			if (!(object instanceof NSKeyValueCodingAdditions)) {
				throw new IllegalStateException(NOT_SUPPORTED);
			}
			
			String firstKey;
			String restOfKeyPath = null;
			int dotIndex = keyPath.indexOf(NSKeyValueCodingAdditions.KeyPathSeparator);
			if (dotIndex == -1) {
				firstKey = keyPath;
			} else {
				firstKey = keyPath.substring(0, dotIndex);
				if (keyPath.length()-1 > dotIndex) {
					restOfKeyPath = keyPath.substring(dotIndex+1);
				}
			}

			if (restOfKeyPath != null) {
				Object firstValue = ((NSKeyValueCodingAdditions)object).valueForKey(firstKey);

				if (firstValue != null && 
						(firstValue instanceof NSKeyValueCodingAdditions)) {
					((NSKeyValueCodingAdditions)firstValue).takeValueForKeyPath(value, restOfKeyPath);
				}
			} else {
				((NSKeyValueCodingAdditions)object).takeValueForKey(value, firstKey);
			}
		}
		
		public static Object valueForKeyPath(Object object, String keyPath) {
			if (!(object instanceof NSKeyValueCodingAdditions)) {
				throw new IllegalStateException(NOT_SUPPORTED);
			}
			
			String firstKey;
			String restOfKeyPath = null;
			int dotIndex = keyPath.indexOf(NSKeyValueCodingAdditions.KeyPathSeparator);
			if (dotIndex == -1) {
				firstKey = keyPath;
			} else {
				firstKey = keyPath.substring(0, dotIndex);
				if (keyPath.length()-1 > dotIndex) {
					restOfKeyPath = keyPath.substring(dotIndex+1);
				}
			}

			Object firstValue = ((NSKeyValueCodingAdditions)object).valueForKey(firstKey);
			if (firstValue != null && 
					(firstValue instanceof NSKeyValueCodingAdditions)
					&& restOfKeyPath != null) {
				return ((NSKeyValueCodingAdditions)firstValue).valueForKeyPath(restOfKeyPath);
			} else {
				return firstValue;
			}
		}
	}
	
	// Since this behavior isn't supported, it's better not to define the class so it becomes a compile-time error
//	public static class Utility {
//		public static void takeValueForKeyPath(Object object, Object value, String keyPath) {
//			if (object instanceof NSKeyValueCodingAdditions) {
//				((NSKeyValueCodingAdditions)object).takeValueForKeyPath(value, keyPath);
//			} else {
//				throw new IllegalStateException(NOT_SUPPORTED);
//			}
//		}
//		
//		public static Object valueForKeyPath(Object object, String keyPath) {
//			if (object instanceof NSKeyValueCodingAdditions) {
//				return ((NSKeyValueCodingAdditions)object).valueForKeyPath(keyPath);
//			} else {
//				throw new IllegalStateException(NOT_SUPPORTED);
//			}
//		}
//	}
	
	public void takeValueForKeyPath(Object value, String keyPath);
	public Object valueForKeyPath(String keyPath);
	
}
