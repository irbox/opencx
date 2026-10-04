package com.microsoft.graph.serializer;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.TypeAdapter;
import com.google.gson.Gson;
import ax.Q9.a;
import ax.Q9.b;
import ax.r8.w;

public class FallBackEnumTypeAdapter implements w
{
    private final b q;
    
    public FallBackEnumTypeAdapter() {
        this.q = (b)new a();
    }
    
    public <T> TypeAdapter<T> b(final Gson gson, final ax.x8.a<T> a) {
        final Class c = a.c();
        if (!c.isEnum()) {
            return null;
        }
        final HashMap hashMap = new HashMap();
        for (final Object o : c.getEnumConstants()) {
            ((Map)hashMap).put((Object)o.toString(), o);
        }
        return new TypeAdapter<T>(this, hashMap) {
            final Map a;
            final FallBackEnumTypeAdapter b;
            
            public T c(final JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                final String nextString = jsonReader.nextString();
                final Object value = this.a.get((Object)nextString);
                if (value == null) {
                    this.b.q.a(String.format("The following value %s could not be recognized as a member of the enum", new Object[] { nextString }));
                    return (T)this.a.get((Object)"unexpectedValue");
                }
                return (T)value;
            }
            
            public void e(final JsonWriter jsonWriter, final T t) throws IOException {
                if (t == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.value(t.toString());
            }
        };
    }
}
