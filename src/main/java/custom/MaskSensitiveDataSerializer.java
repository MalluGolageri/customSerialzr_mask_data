package custom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MaskSensitiveDataSerializer extends StdSerializer<String> {
    private static final long serialVersionUID = 1L;

    public MaskSensitiveDataSerializer() {
        super(String.class);
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        // Masking data; for our example we are adding 'MASK'
        gen.writeString("*****");
    }
}
