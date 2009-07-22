package wogwt.translatable;

import com.google.gwt.user.client.rpc.IsSerializable;


public class FakeNull implements IsSerializable {

	public static final FakeNull NullValue = new FakeNull();
	
	public FakeNull() {
		super();
	}
	
	public Object clone() {
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof FakeNull;
	}
	
	@Override
	public String toString() {
		return "FakeNull";
	}
	
}
