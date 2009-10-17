package java.math;

import java.util.HashMap;
import java.util.Map;

public class Messages {

	private static final Map<String, String> messages = new HashMap<String,String>();
	static {
		messages.put("math.00", "Invalid rounding mode");
		messages.put("math.01", "power of ten too big");
		messages.put("math.02", "Scale out of range.");
		messages.put("math.03", "Infinite or NaN");
		messages.put("math.04", "Division by zero");
		messages.put("math.05", "Non-terminating decimal expansion; no exact representable decimal result.");
		messages.put("math.06", "Division impossible");
		messages.put("math.07", "Invalid Operation");
		messages.put("math.08", "Rounding necessary");
		messages.put("math.09", "Overflow");
		messages.put("math.0A", "Underflow");
		messages.put("math.0B", "null unscaled value");
		messages.put("math.0C", "Digits < 0");
		messages.put("math.0D", "null RoundingMode");
		messages.put("math.0E", "bad string format");
		messages.put("math.0F", "bad precision value");
		messages.put("math.10", "null roundingMode");
		messages.put("math.1B", "numBits must be non-negative");
		messages.put("math.1C", "bitLength < 2");
		messages.put("math.11", "Radix out of range");
		messages.put("math.12", "Zero length BigInteger");
		messages.put("math.13", "Invalid signum value");
		messages.put("math.14", "signum-magnitude mismatch");
		messages.put("math.15", "Negative bit address");
		messages.put("math.16", "Negative exponent");
		messages.put("math.17", "BigInteger divide by zero");
		messages.put("math.18", "BigInteger: modulus not positive");
		messages.put("math.19", "BigInteger not invertible.");
		messages.put("math.1A", "start < 0: {0}");
	}
	
	public static String getString(String msg) {
		return messages.get(msg);
	}

	public static String getString(String msg, Object arg) {
		return messages.get(msg);
	}

}
