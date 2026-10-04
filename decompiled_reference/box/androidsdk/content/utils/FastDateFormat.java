package com.box.androidsdk.content.utils;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.text.DateFormatSymbols;
import java.util.List;
import java.text.FieldPosition;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Calendar;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.Locale;
import java.util.Map;
import java.text.Format;

public class FastDateFormat extends Format
{
    private static final Map d0;
    private static final Map e0;
    private static final Map f0;
    private static final Map g0;
    private static final Map h0;
    private static final long serialVersionUID = 1L;
    private transient int c0;
    private final Locale mLocale;
    private final boolean mLocaleForced;
    private final String mPattern;
    private final TimeZone mTimeZone;
    private final boolean mTimeZoneForced;
    private transient FastDateFormat.FastDateFormat$d[] q;
    
    static {
        d0 = (Map)new HashMap(7);
        e0 = (Map)new HashMap(7);
        f0 = (Map)new HashMap(7);
        g0 = (Map)new HashMap(7);
        h0 = (Map)new HashMap(7);
    }
    
    protected FastDateFormat(final String mPattern, final TimeZone timeZone, final Locale locale) {
        if (mPattern != null) {
            this.mPattern = mPattern;
            final boolean b = false;
            this.mTimeZoneForced = (timeZone != null);
            TimeZone default1;
            if ((default1 = timeZone) == null) {
                default1 = TimeZone.getDefault();
            }
            this.mTimeZone = default1;
            boolean mLocaleForced = b;
            if (locale != null) {
                mLocaleForced = true;
            }
            this.mLocaleForced = mLocaleForced;
            Locale default2;
            if ((default2 = locale) == null) {
                default2 = Locale.getDefault();
            }
            this.mLocale = default2;
            return;
        }
        throw new IllegalArgumentException("The pattern must not be null");
    }
    
    public static FastDateFormat i(final String s) {
        return j(s, null, null);
    }
    
    public static FastDateFormat j(final String s, final TimeZone timeZone, final Locale locale) {
        final Class<FastDateFormat> clazz;
        monitorenter(clazz = FastDateFormat.class);
        Label_0058: {
            try {
                final FastDateFormat fastDateFormat = new FastDateFormat(s, timeZone, locale);
                final Map d0 = FastDateFormat.d0;
                Object o = d0.get((Object)fastDateFormat);
                if (o == null) {
                    fastDateFormat.l();
                    d0.put((Object)fastDateFormat, (Object)fastDateFormat);
                    o = fastDateFormat;
                }
                break Label_0058;
            }
            finally {
                monitorexit(clazz);
                monitorexit(clazz);
                final Object o;
                return (FastDateFormat)o;
            }
        }
    }
    
    static String k(final TimeZone timeZone, final boolean b, final int n, final Locale locale) {
        final Class<FastDateFormat> clazz;
        monitorenter(clazz = FastDateFormat.class);
        Label_0076: {
            try {
                final FastDateFormat.FastDateFormat$g fastDateFormat$g = new FastDateFormat.FastDateFormat$g(timeZone, b, n, locale);
                final Map h0 = FastDateFormat.h0;
                String displayName;
                if ((displayName = (String)h0.get((Object)fastDateFormat$g)) == null) {
                    displayName = timeZone.getDisplayName(b, n, locale);
                    h0.put((Object)fastDateFormat$g, (Object)displayName);
                }
                break Label_0076;
            }
            finally {
                monitorexit(clazz);
                monitorexit(clazz);
                return;
            }
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.l();
    }
    
    protected StringBuffer b(final Calendar calendar, final StringBuffer sb) {
        final FastDateFormat.FastDateFormat$d[] q = this.q;
        for (int length = q.length, i = 0; i < length; ++i) {
            q[i].b(sb, calendar);
        }
        return sb;
    }
    
    public String c(final Date time) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone);
        ((Calendar)gregorianCalendar).setTime(time);
        return this.b((Calendar)gregorianCalendar, new StringBuffer(this.c0)).toString();
    }
    
    public StringBuffer d(final long n, final StringBuffer sb) {
        return this.h(new Date(n), sb);
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof FastDateFormat)) {
            return false;
        }
        final FastDateFormat fastDateFormat = (FastDateFormat)o;
        final String mPattern = this.mPattern;
        final String mPattern2 = fastDateFormat.mPattern;
        if (mPattern == mPattern2 || mPattern.equals((Object)mPattern2)) {
            final TimeZone mTimeZone = this.mTimeZone;
            final TimeZone mTimeZone2 = fastDateFormat.mTimeZone;
            if (mTimeZone == mTimeZone2 || mTimeZone.equals(mTimeZone2)) {
                final Locale mLocale = this.mLocale;
                final Locale mLocale2 = fastDateFormat.mLocale;
                if ((mLocale == mLocale2 || mLocale.equals((Object)mLocale2)) && this.mTimeZoneForced == fastDateFormat.mTimeZoneForced && this.mLocaleForced == fastDateFormat.mLocaleForced) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public StringBuffer f(final Calendar calendar, final StringBuffer sb) {
        Calendar calendar2 = calendar;
        if (this.mTimeZoneForced) {
            calendar.getTime();
            calendar2 = (Calendar)calendar.clone();
            calendar2.setTimeZone(this.mTimeZone);
        }
        return this.b(calendar2, sb);
    }
    
    public StringBuffer format(final Object o, final StringBuffer sb, final FieldPosition fieldPosition) {
        if (o instanceof Date) {
            return this.h((Date)o, sb);
        }
        if (o instanceof Calendar) {
            return this.f((Calendar)o, sb);
        }
        if (o instanceof Long) {
            return this.d((long)o, sb);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Unknown class: ");
        String name;
        if (o == null) {
            name = "<null>";
        }
        else {
            name = o.getClass().getName();
        }
        sb2.append(name);
        throw new IllegalArgumentException(sb2.toString());
    }
    
    public StringBuffer h(final Date time, final StringBuffer sb) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone);
        ((Calendar)gregorianCalendar).setTime(time);
        return this.b((Calendar)gregorianCalendar, sb);
    }
    
    public int hashCode() {
        return this.mPattern.hashCode() + this.mTimeZone.hashCode() + (this.mTimeZoneForced ? 1 : 0) + this.mLocale.hashCode() + (this.mLocaleForced ? 1 : 0);
    }
    
    protected void l() {
        final List m = this.m();
        final FastDateFormat.FastDateFormat$d[] q = (FastDateFormat.FastDateFormat$d[])m.toArray((Object[])new FastDateFormat.FastDateFormat$d[m.size()]);
        this.q = q;
        int length = q.length;
        int c0 = 0;
        while (--length >= 0) {
            c0 += this.q[length].a();
        }
        this.c0 = c0;
    }
    
    protected List m() {
        final DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        final ArrayList list = new ArrayList();
        final String[] eras = dateFormatSymbols.getEras();
        final String[] months = dateFormatSymbols.getMonths();
        final String[] shortMonths = dateFormatSymbols.getShortMonths();
        final String[] weekdays = dateFormatSymbols.getWeekdays();
        final String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        final String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int n2;
        for (int length = this.mPattern.length(), i = 0; i < length; i = n2 + 1) {
            final int[] array = { i };
            final String n = this.n(this.mPattern, array);
            n2 = array[0];
            final int length2 = n.length();
            if (length2 == 0) {
                break;
            }
            final char char1 = n.charAt(0);
            Object o = null;
            Label_0756: {
                if (char1 != 'y') {
                    if (char1 != 'z') {
                        Label_0340: {
                            switch (char1) {
                                default: {
                                    switch (char1) {
                                        default: {
                                            final StringBuilder sb = new StringBuilder();
                                            sb.append("Illegal pattern component: ");
                                            sb.append(n);
                                            throw new IllegalArgumentException(sb.toString());
                                        }
                                        case 72: {
                                            o = this.o(11, length2);
                                            break Label_0340;
                                        }
                                        case 71: {
                                            o = new FastDateFormat.FastDateFormat$f(0, eras);
                                            break Label_0340;
                                        }
                                        case 70: {
                                            o = this.o(8, length2);
                                            break Label_0340;
                                        }
                                        case 69: {
                                            String[] array2;
                                            if (length2 < 4) {
                                                array2 = shortWeekdays;
                                            }
                                            else {
                                                array2 = weekdays;
                                            }
                                            o = new FastDateFormat.FastDateFormat$f(7, array2);
                                            break Label_0340;
                                        }
                                        case 68: {
                                            o = this.o(6, length2);
                                            break Label_0340;
                                        }
                                    }
                                    break;
                                }
                                case 119: {
                                    o = this.o(3, length2);
                                    break;
                                }
                                case 115: {
                                    o = this.o(13, length2);
                                    break;
                                }
                                case 109: {
                                    o = this.o(12, length2);
                                    break;
                                }
                                case 107: {
                                    o = new FastDateFormat.FastDateFormat$k(this.o(11, length2));
                                    break;
                                }
                                case 104: {
                                    o = new FastDateFormat.FastDateFormat$j(this.o(10, length2));
                                    break;
                                }
                                case 100: {
                                    o = this.o(5, length2);
                                    break;
                                }
                                case 97: {
                                    o = new FastDateFormat.FastDateFormat$f(9, amPmStrings);
                                    break;
                                }
                                case 90: {
                                    if (length2 == 1) {
                                        o = FastDateFormat.FastDateFormat$i.c;
                                        break;
                                    }
                                    o = FastDateFormat.FastDateFormat$i.b;
                                    break;
                                }
                                case 87: {
                                    o = this.o(4, length2);
                                    break;
                                }
                                case 83: {
                                    o = this.o(14, length2);
                                    break;
                                }
                                case 77: {
                                    if (length2 >= 4) {
                                        o = new FastDateFormat.FastDateFormat$f(2, months);
                                        break;
                                    }
                                    if (length2 == 3) {
                                        o = new FastDateFormat.FastDateFormat$f(2, shortMonths);
                                        break;
                                    }
                                    if (length2 == 2) {
                                        o = l.a;
                                        break;
                                    }
                                    o = FastDateFormat.o.a;
                                    break;
                                }
                                case 75: {
                                    o = this.o(10, length2);
                                    break;
                                }
                                case 39: {
                                    final String substring = n.substring(1);
                                    if (substring.length() == 1) {
                                        o = new FastDateFormat.FastDateFormat$a(substring.charAt(0));
                                        break;
                                    }
                                    o = new FastDateFormat.FastDateFormat$e(substring);
                                    break;
                                }
                            }
                        }
                        break Label_0756;
                    }
                    if (length2 >= 4) {
                        o = new FastDateFormat.FastDateFormat$h(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1);
                    }
                    else {
                        o = new FastDateFormat.FastDateFormat$h(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
                    }
                }
                else if (length2 >= 4) {
                    o = this.o(1, length2);
                }
                else {
                    o = FastDateFormat.n.a;
                }
            }
            ((List)list).add(o);
        }
        return (List)list;
    }
    
    protected String n(final String s, final int[] array) {
        final StringBuffer sb = new StringBuffer();
        int n = array[0];
        final int length = s.length();
        final char char1 = s.charAt(n);
        int n3;
        if ((char1 >= 'A' && char1 <= 'Z') || (char1 >= 'a' && char1 <= 'z')) {
            sb.append(char1);
            while (true) {
                final int n2 = n + 1;
                n3 = n;
                if (n2 >= length) {
                    break;
                }
                n3 = n;
                if (s.charAt(n2) != char1) {
                    break;
                }
                sb.append(char1);
                n = n2;
            }
        }
        else {
            sb.append('\'');
            int n4 = 0;
            while (true) {
                n3 = n;
                if (n >= length) {
                    break;
                }
                final char char2 = s.charAt(n);
                if (char2 == '\'') {
                    final int n5 = n + 1;
                    if (n5 < length && s.charAt(n5) == '\'') {
                        sb.append(char2);
                        n = n5;
                    }
                    else {
                        n4 ^= 0x1;
                    }
                }
                else {
                    if (n4 == 0 && ((char2 >= 'A' && char2 <= 'Z') || (char2 >= 'a' && char2 <= 'z'))) {
                        n3 = n - 1;
                        break;
                    }
                    sb.append(char2);
                }
                ++n;
            }
        }
        array[0] = n3;
        return sb.toString();
    }
    
    protected FastDateFormat$b o(final int n, final int n2) {
        if (n2 == 1) {
            return (FastDateFormat$b)new p(n);
        }
        if (n2 != 2) {
            return (FastDateFormat$b)new FastDateFormat.FastDateFormat$c(n, n2);
        }
        return (FastDateFormat$b)new m(n);
    }
    
    public Object parseObject(final String s, final ParsePosition parsePosition) {
        parsePosition.setIndex(0);
        parsePosition.setErrorIndex(0);
        return null;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FastDateFormat[");
        sb.append(this.mPattern);
        sb.append("]");
        return sb.toString();
    }
    
    private static class l implements FastDateFormat$b
    {
        static final l a;
        
        static {
            a = new l();
        }
        
        l() {
        }
        
        public int a() {
            return 2;
        }
        
        public void b(final StringBuffer sb, final Calendar calendar) {
            this.c(sb, calendar.get(2) + 1);
        }
        
        public final void c(final StringBuffer sb, final int n) {
            sb.append((char)(n / 10 + 48));
            sb.append((char)(n % 10 + 48));
        }
    }
    
    private static class m implements FastDateFormat$b
    {
        private final int a;
        
        m(final int a) {
            this.a = a;
        }
        
        public int a() {
            return 2;
        }
        
        public void b(final StringBuffer sb, final Calendar calendar) {
            this.c(sb, calendar.get(this.a));
        }
        
        public final void c(final StringBuffer sb, final int n) {
            if (n < 100) {
                sb.append((char)(n / 10 + 48));
                sb.append((char)(n % 10 + 48));
                return;
            }
            sb.append(Integer.toString(n));
        }
    }
    
    private static class n implements FastDateFormat$b
    {
        static final n a;
        
        static {
            a = new n();
        }
        
        n() {
        }
        
        public int a() {
            return 2;
        }
        
        public void b(final StringBuffer sb, final Calendar calendar) {
            this.c(sb, calendar.get(1));
        }
        
        public final void c(final StringBuffer sb, final int n) {
            sb.append((char)(n / 10 + 48));
            sb.append((char)(n % 10 + 48));
        }
    }
    
    private static class o implements FastDateFormat$b
    {
        static final o a;
        
        static {
            a = new o();
        }
        
        o() {
        }
        
        public int a() {
            return 2;
        }
        
        public void b(final StringBuffer sb, final Calendar calendar) {
            this.c(sb, calendar.get(2) + 1);
        }
        
        public final void c(final StringBuffer sb, final int n) {
            if (n < 10) {
                sb.append((char)(n + 48));
                return;
            }
            sb.append((char)(n / 10 + 48));
            sb.append((char)(n % 10 + 48));
        }
    }
    
    private static class p implements FastDateFormat$b
    {
        private final int a;
        
        p(final int a) {
            this.a = a;
        }
        
        public int a() {
            return 4;
        }
        
        public void b(final StringBuffer sb, final Calendar calendar) {
            this.c(sb, calendar.get(this.a));
        }
        
        public final void c(final StringBuffer sb, final int n) {
            if (n < 10) {
                sb.append((char)(n + 48));
                return;
            }
            if (n < 100) {
                sb.append((char)(n / 10 + 48));
                sb.append((char)(n % 10 + 48));
                return;
            }
            sb.append(Integer.toString(n));
        }
    }
}
