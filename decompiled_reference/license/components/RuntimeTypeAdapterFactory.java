package com.alphainventor.filemanager.license.components;

import java.util.Iterator;
import ax.r8.o;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import ax.r8.i;
import ax.r8.m;
import ax.t8.l;
import com.google.gson.stream.JsonReader;
import java.util.Map$Entry;
import java.util.LinkedHashMap;
import com.google.gson.TypeAdapter;
import ax.x8.a;
import com.google.gson.Gson;
import java.util.Map;
import ax.r8.w;

public final class RuntimeTypeAdapterFactory<T> implements w
{
    private final String c0;
    private final Map<String, Class<?>> d0;
    private final Map<Class<?>, String> e0;
    private final Class<?> q;
    
    public <R> TypeAdapter<R> b(final Gson gson, final a<R> a) {
        if (a.c() != this.q) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (final Map$Entry map$Entry : this.d0.entrySet()) {
            final TypeAdapter o = gson.o((w)this, a.a((Class)map$Entry.getValue()));
            ((Map)linkedHashMap).put((Object)map$Entry.getKey(), (Object)o);
            ((Map)linkedHashMap2).put((Object)map$Entry.getValue(), (Object)o);
        }
        return (TypeAdapter<R>)new TypeAdapter<R>(this, linkedHashMap, linkedHashMap2) {
            final Map a;
            final Map b;
            final RuntimeTypeAdapterFactory c;
            
            public R c(final JsonReader jsonReader) throws IOException {
                final i a = l.a(jsonReader);
                final i y = a.h().y(this.c.c0);
                if (y == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("cannot deserialize ");
                    sb.append((Object)this.c.q);
                    sb.append(" because it does not define a field named ");
                    sb.append(this.c.c0);
                    throw new m(sb.toString());
                }
                final String k = y.k();
                final TypeAdapter typeAdapter = (TypeAdapter)this.a.get((Object)k);
                if (typeAdapter != null) {
                    return (R)typeAdapter.a(a);
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("cannot deserialize ");
                sb2.append((Object)this.c.q);
                sb2.append(" subtype named ");
                sb2.append(k);
                sb2.append("; did you forget to register a subtype?");
                throw new m(sb2.toString());
            }
            
            public void e(final JsonWriter jsonWriter, final R r) throws IOException {
                final Class<?> class1 = r.getClass();
                final String s = (String)this.c.e0.get((Object)class1);
                final TypeAdapter typeAdapter = (TypeAdapter)this.b.get((Object)class1);
                if (typeAdapter == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("cannot serialize ");
                    sb.append(class1.getName());
                    sb.append("; did you forget to register a subtype?");
                    throw new m(sb.toString());
                }
                final ax.r8.l h = typeAdapter.d((Object)r).h();
                if (!h.x(this.c.c0)) {
                    final ax.r8.l l = new ax.r8.l();
                    l.r(this.c.c0, (i)new o(s));
                    for (final Map$Entry map$Entry : h.s()) {
                        l.r((String)map$Entry.getKey(), (i)map$Entry.getValue());
                    }
                    ax.t8.l.b((i)l, jsonWriter);
                    return;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("cannot serialize ");
                sb2.append(class1.getName());
                sb2.append(" because it already defines a field named ");
                sb2.append(this.c.c0);
                throw new m(sb2.toString());
            }
        }.b();
    }
}
