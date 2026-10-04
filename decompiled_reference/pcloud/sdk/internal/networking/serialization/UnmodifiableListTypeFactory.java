package com.pcloud.sdk.internal.networking.serialization;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import j$.util.DesugarCollections;
import java.util.List;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;
import ax.x8.a;
import com.google.gson.Gson;
import ax.r8.w;

public class UnmodifiableListTypeFactory implements w
{
    public <T> TypeAdapter<T> b(final Gson gson, final a<T> a) {
        return new TypeAdapter<T>(this, gson.o((w)this, (a)a), a) {
            final TypeAdapter a;
            final a b;
            final UnmodifiableListTypeFactory c;
            
            public T c(final JsonReader jsonReader) throws IOException {
                Object o = this.a.c(jsonReader);
                if (List.class.isAssignableFrom(this.b.c())) {
                    o = DesugarCollections.unmodifiableList((List)o);
                }
                return (T)o;
            }
            
            public void e(final JsonWriter jsonWriter, final T t) throws IOException {
                this.a.e(jsonWriter, (Object)t);
            }
        };
    }
}
