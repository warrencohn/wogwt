package your.app.gwt.eo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class PlotSummary_CustomFieldSerializer extends _PlotSummary_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, PlotSummary instance)
    throws SerializationException {
		_PlotSummary_CustomFieldSerializer.deserialize(streamReader, instance);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, PlotSummary instance)
	    throws SerializationException {
		_PlotSummary_CustomFieldSerializer.serialize(streamWriter, instance);
	}

}