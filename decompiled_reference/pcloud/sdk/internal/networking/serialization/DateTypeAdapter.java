package com.pcloud.sdk.internal.networking.serialization;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import com.google.gson.stream.JsonReader;
import java.util.Date;
import com.google.gson.TypeAdapter;

public class DateTypeAdapter extends TypeAdapter<Date>
{
    public Date f(final JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NUMBER) {
            return new Date(jsonReader.nextLong() * 1000L);
        }
        return null;
    }
    
    public void g(final JsonWriter jsonWriter, final Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(date.getTime());
    }
}
