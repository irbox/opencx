package com.pcloud.sdk.internal.networking.serialization;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import com.google.gson.stream.JsonReader;
import ax.xc.h;
import com.google.gson.TypeAdapter;

public class ByteStringTypeAdapter extends TypeAdapter<h>
{
    public h f(final JsonReader jsonReader) throws IOException {
        return h.j(jsonReader.nextString());
    }
    
    public void g(final JsonWriter jsonWriter, final h h) throws IOException {
        jsonWriter.value(h.t());
    }
}
