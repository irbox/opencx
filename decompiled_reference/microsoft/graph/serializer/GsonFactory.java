package com.microsoft.graph.serializer;

import java.util.AbstractCollection;
import ax.r8.w;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import ax.T9.c;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import com.google.gson.a;
import java.text.ParseException;
import ax.r8.m;
import ax.r8.g;
import ax.r8.h;
import ax.r8.o;
import ax.r8.i;
import ax.r8.p;
import java.lang.reflect.Type;
import java.util.Calendar;
import ax.r8.q;
import com.google.gson.Gson;
import ax.Q9.b;

final class GsonFactory
{
    public static Gson a(final b b) {
        final q<Calendar> q = (q<Calendar>)new q<Calendar>(b) {
            final b a;
            
            public i b(final Calendar calendar, final Type type, final p p3) {
                if (calendar == null) {
                    return null;
                }
                try {
                    return (i)new o(ax.T9.b.b(calendar));
                }
                catch (final Exception ex) {
                    final b a = this.a;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Parsing issue on ");
                    sb.append((Object)calendar);
                    a.b(sb.toString(), (Throwable)ex);
                    return null;
                }
            }
        };
        final h<Calendar> h = (h<Calendar>)new h<Calendar>(b) {
            final b a;
            
            public Calendar b(final i i, final Type type, final g g) throws m {
                if (i == null) {
                    return null;
                }
                try {
                    return ax.T9.b.a(i.k());
                }
                catch (final ParseException ex) {
                    final b a = this.a;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Parsing issue on ");
                    sb.append(i.k());
                    a.b(sb.toString(), (Throwable)ex);
                    return null;
                }
            }
        };
        return new a().c().d((Type)Calendar.class, (Object)q).d((Type)Calendar.class, (Object)h).d((Type)GregorianCalendar.class, (Object)q).d((Type)GregorianCalendar.class, (Object)h).d((Type)byte[].class, (Object)new h<byte[]>(b) {
            final b a;
            
            public byte[] b(final i i, final Type type, final g g) throws m {
                if (i == null) {
                    return null;
                }
                try {
                    return ax.T9.a.a(i.k());
                }
                catch (final ParseException ex) {
                    final b a = this.a;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Parsing issue on ");
                    sb.append(i.k());
                    a.b(sb.toString(), (Throwable)ex);
                    return null;
                }
            }
        }).d((Type)byte[].class, (Object)new q<byte[]>(b) {
            final b a;
            
            public i b(final byte[] array, final Type type, final p p3) {
                if (array == null) {
                    return null;
                }
                try {
                    return (i)new o(ax.T9.a.b(array));
                }
                catch (final Exception ex) {
                    final b a = this.a;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Parsing issue on ");
                    sb.append((Object)array);
                    a.b(sb.toString(), (Throwable)ex);
                    return null;
                }
            }
        }).d((Type)ax.R9.a.class, (Object)new q<ax.R9.a>() {
            public i b(final ax.R9.a a, final Type type, final p p3) {
                if (a == null) {
                    return null;
                }
                return (i)new o(a.toString());
            }
        }).d((Type)ax.R9.a.class, (Object)new h<ax.R9.a>(b) {
            final b a;
            
            public ax.R9.a b(final i i, final Type type, final g g) throws m {
                if (i == null) {
                    return null;
                }
                try {
                    return ax.R9.a.a(i.k());
                }
                catch (final ParseException ex) {
                    final b a = this.a;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Parsing issue on ");
                    sb.append(i.k());
                    a.b(sb.toString(), (Throwable)ex);
                    return null;
                }
            }
        }).d((Type)EnumSet.class, (Object)new q<EnumSet>() {
            public i b(final EnumSet set, final Type type, final p p3) {
                if (set != null && ((AbstractCollection)set).size() != 0) {
                    return (i)c.b(set);
                }
                return null;
            }
        }).d((Type)EnumSet.class, (Object)new h<EnumSet>() {
            public EnumSet b(final i i, final Type type, final g g) throws m {
                if (i == null) {
                    return null;
                }
                return c.a(type, i.k());
            }
        }).d((Type)Duration.class, (Object)new q<Duration>() {
            public i b(final Duration duration, final Type type, final p p3) {
                return (i)new o(duration.toString());
            }
        }).d((Type)Duration.class, (Object)new h<Duration>() {
            public Duration b(final i i, final Type type, final g g) throws m {
                try {
                    return DatatypeFactory.newInstance().newDuration(i.toString());
                }
                catch (final Exception ex) {
                    return null;
                }
            }
        }).e((w)new FallBackEnumTypeAdapter()).b();
    }
}
