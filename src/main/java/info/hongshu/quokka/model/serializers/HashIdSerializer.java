package info.hongshu.quokka.model.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import info.hongshu.quokka.service.HashidService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class HashIdSerializer extends JsonSerializer<Long> {
    @Autowired
    private HashidService hashidService;

    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(hashidService.encode(value));
    }
}
