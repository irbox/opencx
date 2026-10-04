package com.socialnmobile.dav.util;

import java.lang.reflect.AccessibleObject;
import com.google.gson.stream.JsonWriter;
import ax.r8.r;
import com.google.gson.stream.JsonToken;
import ax.t8.h;
import ax.t8.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.IOException;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Type;
import ax.t8.j;
import com.google.gson.TypeAdapter;
import ax.x8.a;
import java.lang.reflect.Field;
import com.google.gson.Gson;
import ax.t8.c;
import com.google.gson.internal.Excluder;
import ax.r8.d;
import ax.r8.w;

public final class MyReflectiveTypeAdapterFactory implements w
{
    private final d c0;
    private final Excluder d0;
    private final Class e0;
    private final c q;
    
    public MyReflectiveTypeAdapterFactory(final c q, final d c0, final Excluder d0, final Class e0) {
        this.q = q;
        this.c0 = c0;
        this.d0 = d0;
        this.e0 = e0;
    }
    
    private b c(final Gson gson, final Field field, final String s, final a<?> a, final boolean b, final boolean b2) {
        return (b)new b(this, s, b, b2, gson, field, a, j.a((Type)a.c())) {
            final TypeAdapter<?> d = i.g(e, f, (a<?>)g);
            final Gson e;
            final Field f;
            final a g;
            final boolean h;
            final MyReflectiveTypeAdapterFactory i;
            
            @Override
            void a(final JsonReader jsonReader, final Object o) throws IOException, IllegalAccessException {
                final Object c = this.d.c(jsonReader);
                if ((c != null || !this.h) && this.f.get(o) == null) {
                    this.f.set(o, c);
                }
            }
        };
    }
    
    static boolean e(final Field field, final boolean b, final Excluder excluder) {
        return !excluder.d(field.getType(), b) && !excluder.i(field, b);
    }
    
    private Map<String, b> f(final Gson gson, final a<?> a, final Class<?> clazz) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!clazz.isInterface()) {
            final Type d = a.d();
            Class c = clazz;
            for (a b = a; c != Object.class; c = b.c()) {
                for (final Field field : c.getDeclaredFields()) {
                    final boolean d2 = this.d(field, true);
                    final boolean d3 = this.d(field, false);
                    if (d2 || d3) {
                        ((AccessibleObject)field).setAccessible(true);
                        final b c2 = this.c(gson, field, this.i(field), (a<?>)a.b(ax.t8.b.o(b.d(), c, field.getGenericType())), d2, d3);
                        final b b2 = (b)((Map)linkedHashMap).put((Object)c2.a, (Object)c2);
                        if (b2 != null) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append((Object)d);
                            sb.append(" declares multiple JSON fields named ");
                            sb.append(b2.a);
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                }
                b = a.b(ax.t8.b.o(b.d(), c, c.getGenericSuperclass()));
            }
        }
        return (Map<String, b>)linkedHashMap;
    }
    
    private TypeAdapter<?> g(final Gson gson, final Field field, final a<?> a) {
        return (TypeAdapter<?>)gson.m((a)a);
    }
    
    static String h(final d d, final Field field) {
        final ax.s8.c c = (ax.s8.c)field.getAnnotation((Class)ax.s8.c.class);
        if (c == null) {
            return d.d(field);
        }
        return c.value();
    }
    
    private String i(final Field field) {
        return h(this.c0, field);
    }
    
    public <T> TypeAdapter<T> b(final Gson gson, final a<T> a) {
        final Class c = a.c();
        if (!Object.class.isAssignableFrom(c)) {
            return null;
        }
        if (!this.e0.isAssignableFrom(c)) {
            return null;
        }
        return new Adapter<T>(this.q.a((a)a), (Map)this.f(gson, a, c));
    }
    
    public boolean d(final Field field, final boolean b) {
        return e(field, b, this.d0);
    }
    
    public static final class Adapter<T> extends TypeAdapter<T>
    {
        private final h<T> a;
        private final Map<String, b> b;
        
        private Adapter(final h<T> a, final Map<String, b> b) {
            this.a = a;
            this.b = b;
        }
        
        public T c(final JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            while (true) {
                final Object a = this.a.a();
            Label_0094:
                while (true) {
                    Label_0087: {
                        try {
                            jsonReader.beginObject();
                            Block_6: {
                                while (jsonReader.hasNext()) {
                                    final b b = (b)this.b.get((Object)jsonReader.nextName());
                                    if (b == null) {
                                        break Label_0087;
                                    }
                                    if (!b.c) {
                                        break Block_6;
                                    }
                                    b.a(jsonReader, a);
                                }
                                break Label_0094;
                            }
                        }
                        catch (final IllegalAccessException ex) {
                            throw new AssertionError((Object)ex);
                        }
                        catch (final IllegalStateException ex2) {
                            throw new r((Throwable)ex2);
                        }
                    }
                    jsonReader.skipValue();
                    continue;
                }
                jsonReader.endObject();
                return (T)a;
            }
        }
        
        public void e(final JsonWriter jsonWriter, final T t) throws IOException {
            ax.Qd.a.a("This class should not be used for write");
        }
    }
    
    abstract static class b
    {
        final String a;
        final boolean b;
        final boolean c;
        
        protected b(final String a, final boolean b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        abstract void a(final JsonReader p0, final Object p1) throws IOException, IllegalAccessException;
    }
}
