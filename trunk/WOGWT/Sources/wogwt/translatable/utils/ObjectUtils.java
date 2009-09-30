package wogwt.translatable.utils;

public class ObjectUtils {

	private ObjectUtils() {
	}

	public static boolean equals(Object left, Object right) {
		if (left == null && right == null) {
			return true;
		}
		
		if (left != null) {
			return left.equals(right);
		} else {
			return right.equals(left);
		}
	}
	
}
