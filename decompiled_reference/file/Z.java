package com.alphainventor.filemanager.file;

import ax.c3.b;
import java.text.DateFormat;
import ax.Z2.t;
import android.system.StructStat;
import android.system.Os;
import java.text.ParseException;
import ax.u3.r;
import java.util.Date;
import android.os.Build$VERSION;
import ax.c3.K;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.ArrayList;
import ax.X2.Q;
import ax.c3.d0;
import java.util.Random;
import java.io.File;
import android.content.Context;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class z
{
    private static final Logger d;
    private static final SimpleDateFormat e;
    private static final SimpleDateFormat f;
    private static final SimpleDateFormat g;
    private static final SimpleDateFormat h;
    private static final SimpleDateFormat i;
    private static z j;
    private static z k;
    private static final HashSet<String> l;
    private boolean a;
    private Boolean b;
    private Pattern c;
    
    static {
        d = Logger.getLogger("FileManager.LocalFileRootAccess");
        final Locale us = Locale.US;
        e = new SimpleDateFormat("yyyy-MM-dd HH:mm", us);
        f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", us);
        g = new SimpleDateFormat("yyyyMMdd.HHmmss", us);
        h = new SimpleDateFormat("yyyyMMddHHmm.ssSSS", us);
        i = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", us);
        l = new HashSet((Collection)Arrays.asList((Object[])new String[] { "ext_data_rw", "ext_obb_rw", "media_rw", "external_storage" }));
    }
    
    z(final boolean a) {
        this.a = a;
        this.c = Pattern.compile("\u001b\\[[;\\d]*m");
    }
    
    private static String B(final int n) {
        return String.format("%o", new Object[] { n });
    }
    
    private FileOutputStream E(final n n) {
        final String e = n.E();
        a t;
        if (this.m(e)) {
            t = this.t(e);
        }
        else {
            t = null;
        }
        try {
            return new c(e, I(n.x()).getAbsolutePath(), t);
        }
        catch (final IOException ex) {
            ((Throwable)ex).printStackTrace();
            return null;
        }
    }
    
    private FileOutputStream F(final String s, final boolean b) {
        final int p2 = this.p(s);
        if (p2 < 0) {
            return null;
        }
        final boolean n = N(p2, 2);
        if (!n && !this.d(s, p2 | 0x2)) {
            return null;
        }
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(s, b);
            if (!n) {
                this.d(s, p2);
            }
            return fileOutputStream;
        }
        catch (final IOException ex) {
            if (!n) {
                this.d(s, p2);
            }
            return null;
        }
        finally {
            if (!n) {
                this.d(s, p2);
            }
        }
    }
    
    private static File I(final Context context) {
        final File cacheDir = context.getCacheDir();
        File file;
        do {
            file = new File(cacheDir, String.valueOf(new Random().nextLong()));
        } while (file.exists());
        return file;
    }
    
    public static long J(final String s) {
        try {
            return ((DateFormat)z.e).parse(s).getTime();
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
            return 0L;
        }
    }
    
    private static boolean L(final String s) {
        return "sh".equals((Object)d0.k(s));
    }
    
    private boolean M(final Context context) {
        if (this.b == null) {
            if (Q.Q0()) {
                this.b = (this.l("ls -lan --full-time /", 10000L) != null);
            }
            else {
                this.b = Boolean.FALSE;
            }
        }
        return this.b;
    }
    
    private static boolean N(final int n, final int n2) {
        return (n & n2) == n2;
    }
    
    private static p Q(final ArrayList<String> list) {
        int n = 0;
    Label_0070_Outer:
        while (true) {
            Label_0076: {
                if (n >= list.size()) {
                    break Label_0076;
                }
                final String s = (String)list.get(n);
                while (true) {
                    if (s.startsWith("total")) {
                        break Label_0070;
                    }
                    final String[] split = s.split("\\s+");
                    if (split.length < 4) {
                        break Label_0070;
                    }
                    final String s2 = split[0];
                    try {
                        return new p(split[2], split[3], s2);
                        ++n;
                        continue Label_0070_Outer;
                        return null;
                    }
                    catch (final Exception ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private b R(String r, String s, final boolean b, final boolean b2) {
        Pattern pattern;
        if (b2) {
            pattern = Pattern.compile("\\s\\d\\d:\\d\\d:\\d\\d(\\.\\d{9})?\\s[+-]\\d\\d\\d\\d\\s");
        }
        else {
            pattern = Pattern.compile("\\s\\d\\d:\\d\\d\\s");
        }
        final Matcher matcher = pattern.matcher((CharSequence)s);
        int end;
        int start;
        if (matcher.find()) {
            end = matcher.end();
            start = matcher.start();
        }
        else {
            end = -1;
            start = -1;
        }
        if (start > 0 && end > 0) {
            Label_0753: {
                String[] split = null;
                int length = 0;
                boolean startsWith;
                boolean startsWith2 = false;
                String s3;
                long n2;
                String s4;
                while (true) {
                    while (true) {
                        String substring = null;
                        Label_0192: {
                            try {
                                substring = s.substring(end);
                                split = s.substring(0, end).split("\\s+");
                                length = split.length;
                                final String s2 = split[0];
                                startsWith = s2.startsWith("d");
                                startsWith2 = s2.startsWith("l");
                                final long n = -1L;
                                if (!startsWith) {
                                    break Label_0192;
                                }
                                final String substring2 = s.substring(end);
                                if (!substring2.equals((Object)".")) {
                                    s = substring2;
                                    if (!substring2.equals((Object)"..")) {
                                        s3 = null;
                                        n2 = n;
                                        s4 = s;
                                        break;
                                    }
                                }
                            }
                            catch (final Exception ex) {
                                break Label_0753;
                            }
                            return null;
                        }
                        if (startsWith2) {
                            final String[] split2 = substring.split("\\s->\\s", 2);
                            s4 = split2[0];
                            s3 = split2[1];
                            n2 = -1L;
                            break;
                        }
                        s = s.substring(end);
                        if (b2) {
                            final long n = Long.valueOf(split[length - 4]);
                            continue;
                        }
                        final long n = Long.valueOf(split[length - 3]);
                        continue;
                    }
                }
                if (b2) {
                    final int n3 = length - 2;
                    final int index = split[n3].indexOf(".");
                    if (index >= 0) {
                        s = split[n3].substring(0, index);
                        final StringBuilder sb = new StringBuilder();
                        sb.append(split[length - 3]);
                        sb.append(" ");
                        sb.append(s);
                        sb.append(" ");
                        sb.append(split[length - 1]);
                        s = sb.toString();
                    }
                    else {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append(split[length - 3]);
                        sb2.append(" ");
                        sb2.append(split[n3]);
                        sb2.append(" ");
                        sb2.append(split[length - 1]);
                        s = sb2.toString();
                    }
                }
                else {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(split[length - 2]);
                    sb3.append(" ");
                    sb3.append(split[length - 1]);
                    s = sb3.toString();
                }
                long n4;
                if (b2) {
                    n4 = v(s);
                }
                else {
                    n4 = J(s);
                }
                long n5 = n2;
                boolean b3 = startsWith;
                Label_0618: {
                    if (startsWith2) {
                        n5 = n2;
                        b3 = startsWith;
                        if (s3 != null) {
                            File file;
                            if (s3.startsWith("/")) {
                                file = new File(s3);
                            }
                            else {
                                if (!b) {
                                    r = d0.r(r);
                                }
                                file = new File(r, s3);
                            }
                            boolean b4;
                            if (file.exists()) {
                                b3 = (b4 = file.isDirectory());
                                if (!b3) {
                                    n5 = file.length();
                                    break Label_0618;
                                }
                            }
                            else {
                                n5 = n2;
                                b3 = startsWith;
                                if (!this.m(file.getAbsolutePath())) {
                                    break Label_0618;
                                }
                                b3 = (b4 = this.K(file.getAbsolutePath()));
                                if (!b3) {
                                    n5 = this.s(file.getAbsolutePath());
                                    break Label_0618;
                                }
                            }
                            n5 = 0L;
                            return new b(s4, b4, startsWith2, true, false, n5, n4);
                        }
                    }
                }
                boolean b4 = b3;
                return new b(s4, b4, startsWith2, true, false, n5, n4);
            }
            final Exception ex;
            ((Throwable)ex).printStackTrace();
            return null;
        }
        if (!s.toLowerCase().startsWith("total")) {
            final Logger d = z.d;
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Invalid line of ls  :");
            sb4.append(s);
            d.severe(sb4.toString());
        }
        return null;
    }
    
    private static int S(final String s) {
        if (s.length() != 10) {
            return -1;
        }
        int n;
        if (s.charAt(1) == 'r') {
            n = 256;
        }
        else {
            n = 0;
        }
        int n2 = n;
        if (s.charAt(2) == 'w') {
            n2 = (n | 0x80);
        }
        int n3;
        if (s.charAt(3) == 'x') {
            n3 = (n2 | 0x40);
        }
        else if (s.charAt(3) == 's') {
            n3 = (n2 | 0x840);
        }
        else {
            n3 = n2;
            if (s.charAt(3) == 'S') {
                n3 = (n2 | 0x800);
            }
        }
        int n4 = n3;
        if (s.charAt(4) == 'r') {
            n4 = (n3 | 0x20);
        }
        int n5 = n4;
        if (s.charAt(5) == 'w') {
            n5 = (n4 | 0x10);
        }
        int n6;
        if (s.charAt(6) == 'x') {
            n6 = (n5 | 0x8);
        }
        else if (s.charAt(6) == 's') {
            n6 = (n5 | 0x408);
        }
        else {
            n6 = n5;
            if (s.charAt(6) == 'S') {
                n6 = (n5 | 0x400);
            }
        }
        int n7 = n6;
        if (s.charAt(7) == 'r') {
            n7 = (n6 | 0x4);
        }
        int n8 = n7;
        if (s.charAt(8) == 'w') {
            n8 = (n7 | 0x2);
        }
        if (s.charAt(9) == 'x') {
            return n8 | 0x1;
        }
        return n8;
    }
    
    private static int T(final String s) {
        if (s.length() != 10) {
            return 0;
        }
        if (s.charAt(0) == 'd') {
            return 16384;
        }
        if (s.charAt(0) == 'l') {
            return 40960;
        }
        if (s.charAt(0) == 'p') {
            return 4096;
        }
        return 0;
    }
    
    private void W(final String s, final boolean b) {
        final p o = this.o(d0.r(s));
        if (o != null) {
            final String b2 = o.b;
            if (b2 != null) {
                final boolean contains = z.l.contains((Object)b2);
                int n = 1528;
                final int n2 = 432;
                if (contains) {
                    final String a = o.a;
                    if (a != null) {
                        this.f(s, a, o.b);
                        if (!b || !o.a.startsWith("u0_a")) {
                            if (b) {
                                n = 504;
                            }
                            else {
                                n = 432;
                            }
                        }
                        this.d(s, n);
                    }
                }
                else if (o.b.startsWith("u0_a")) {
                    final String a2 = o.a;
                    if (a2 != null) {
                        this.f(s, a2, o.b);
                        if (!b || !o.b.endsWith("_cache")) {
                            if (b) {
                                n = 504;
                            }
                            else {
                                n = 432;
                            }
                        }
                        this.d(s, n);
                    }
                }
                else {
                    this.f(s, "root", "root");
                    int n3 = 0;
                    Label_0239: {
                        if (!b) {
                            n3 = n2;
                            if (!L(s)) {
                                break Label_0239;
                            }
                        }
                        n3 = 504;
                    }
                    this.d(s, n3);
                }
            }
        }
    }
    
    public static z X() {
        if (z.k == null) {
            z.k = new z(false);
        }
        return z.k;
    }
    
    public static z Y() {
        if (z.j == null) {
            z.j = new z(true);
        }
        return z.j;
    }
    
    private boolean d(final String s, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("chmod ");
        sb.append(B(n));
        sb.append(" ");
        sb.append(k(s));
        return this.l(sb.toString(), 2000L) != null;
    }
    
    private boolean e(final String s, final int n, final int n2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("chown ");
        sb.append(n);
        sb.append(":");
        sb.append(n2);
        sb.append(" ");
        sb.append(k(s));
        return this.l(sb.toString(), 2000L) != null;
    }
    
    private boolean f(final String s, final String s2, final String s3) {
        final StringBuilder sb = new StringBuilder();
        sb.append("chown ");
        sb.append(s2);
        sb.append(":");
        sb.append(s3);
        sb.append(" ");
        sb.append(k(s));
        return this.l(sb.toString(), 2000L) != null;
    }
    
    private static String k(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("'");
        sb.append(s.replaceAll("'", "'\"'\"'"));
        sb.append("'");
        return sb.toString();
    }
    
    private static long v(final String s) {
        try {
            return ((DateFormat)z.f).parse(s).getTime();
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
            return 0L;
        }
    }
    
    private FileInputStream x(final String s, final long n, final a a) {
        int n2;
        if (a != null) {
            n2 = a.c;
        }
        else {
            n2 = this.p(s);
        }
        if (n2 < 0) {
            return null;
        }
        final boolean n3 = N(n2, 4);
        if (!n3 && !this.d(s, n2 | 0x4)) {
            return null;
        }
        Label_0093: {
            try {
                final FileInputStream fileInputStream = new FileInputStream(s);
                if (n > 0L) {
                    fileInputStream.skip(n);
                }
                break Label_0093;
            }
            catch (final IOException ex) {
                if (!n3) {
                    this.d(s, n2);
                }
                return null;
            }
            finally {
                if (!n3) {
                    this.d(s, n2);
                }
                iftrue(Label_0106:)(n3);
                this.d(s, n2);
                Label_0106: {
                    return;
                }
            }
        }
    }
    
    public FileInputStream A(final n n, final long n2) {
        final String e = n.E();
        final File cacheDir = n.x().getCacheDir();
        File file;
        do {
            file = new File(cacheDir, String.valueOf(new Random().nextLong()));
        } while (file.exists());
        final String absolutePath = file.getAbsolutePath();
        final StringBuilder sb = new StringBuilder();
        sb.append("ln -f ");
        sb.append(k(e));
        sb.append(" ");
        sb.append(k(absolutePath));
        if (this.l(sb.toString(), 2000L) == null) {
            return null;
        }
        final FileInputStream x = this.x(absolutePath, n2, null);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("rm ");
        sb2.append(k(absolutePath));
        this.l(sb2.toString(), 2000L);
        return x;
    }
    
    public int C(final String s, final boolean b) {
        ArrayList<String> list;
        if (Q.a1()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("ls -1A ");
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append("/");
            sb.append(k(sb2.toString()));
            list = this.l(sb.toString(), 10000L);
        }
        else {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("ls -lan ");
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(s);
            sb4.append("/");
            sb3.append(k(sb4.toString()));
            list = this.l(sb3.toString(), 10000L);
        }
        if (list == null) {
            return -1;
        }
        int i = 0;
        int n = 0;
        while (i < list.size()) {
            final String s2 = (String)list.get(i);
            if (!d0.C(s2)) {
                if ((!s2.endsWith(" .") && !s2.endsWith(" ..")) || this.R(s, s2, true, false) != null) {
                    if (b || !s2.startsWith(".")) {
                        if (Q.a1() || !s2.startsWith("total")) {
                            ++n;
                        }
                    }
                }
            }
            ++i;
        }
        return n;
    }
    
    public FileOutputStream D(final n n, final boolean b) {
        final FileOutputStream h = this.H(n, b);
        if (h == null) {
            return this.G(n, b);
        }
        return h;
    }
    
    public FileOutputStream G(final n n, final boolean b) {
        if (b) {
            return null;
        }
        final String t = n.T();
        final int p2 = this.p(t);
        if (p2 < 0) {
            return null;
        }
        final boolean n2 = N(p2, 3);
        if (!n2 && !this.d(t, p2 | 0x3)) {
            return null;
        }
        final FileOutputStream e = this.E(n);
        if (!n2) {
            this.d(t, p2);
        }
        return e;
    }
    
    public FileOutputStream H(final n n, final boolean b) {
        final String e = n.E();
        final boolean m = this.m(e);
        if (!m && !this.h(e)) {
            return null;
        }
        final String absolutePath = I(n.x()).getAbsolutePath();
        final StringBuilder sb = new StringBuilder();
        sb.append("ln -f ");
        sb.append(k(e));
        sb.append(" ");
        sb.append(k(absolutePath));
        if (this.l(sb.toString(), 2000L) == null) {
            if (!m) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("rm ");
                sb2.append(k(e));
                this.l(sb2.toString(), 2000L);
            }
            return null;
        }
        final FileOutputStream f = this.F(absolutePath, b);
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("rm ");
        sb3.append(k(absolutePath));
        this.l(sb3.toString(), 2000L);
        return f;
    }
    
    public boolean K(String s) {
        if (Q.Q1()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("test -d ");
            sb.append(k(s));
            sb.append(" && echo YES || echo NO");
            final ArrayList<String> l = this.l(sb.toString(), 10000L);
            return l != null && l.size() > 0 && "YES".equals(l.get(0));
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("ls -land ");
        sb2.append(k(s));
        final ArrayList<String> i = this.l(sb2.toString(), 10000L);
        if (i == null) {
            return false;
        }
        int j = 0;
        while (j < i.size()) {
            s = (String)i.get(j);
            if (s.startsWith("total")) {
                ++j;
            }
            else {
                if (s.length() > 0 && s.charAt(0) == 'd') {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    
    public ArrayList<y> O(final x x, final K k, final String s) {
        final ArrayList list = new ArrayList();
        String string = "/";
        if (!"/".equals((Object)s)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("/");
            string = sb.toString();
        }
        final boolean m = this.M(((m)x).p());
        int i = 0;
        String s2;
        boolean b;
        if (m) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("ls -lan --full-time ");
            sb2.append(k(string));
            s2 = sb2.toString();
            b = true;
        }
        else {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("ls -lan ");
            sb3.append(k(string));
            s2 = sb3.toString();
            b = false;
        }
        final ArrayList<String> l = this.l(s2, 10000L);
        if (l == null) {
            return null;
        }
        while (i < l.size()) {
            final String s3 = (String)l.get(i);
            if (!s3.startsWith("total")) {
                final b r = this.R(s, this.c.matcher((CharSequence)s3).replaceAll(""), true, b);
                if (r != null) {
                    list.add((Object)new y(x, new File(s, r.a), k, r.b, r.c, r.d, r.e, r.f, r.g));
                }
            }
            ++i;
        }
        return (ArrayList<y>)list;
    }
    
    public boolean P(final String s, final String s2, final boolean b) {
        String s3;
        if (b) {
            s3 = "mv -f";
        }
        else {
            s3 = "mv";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(s3);
        sb.append(" ");
        sb.append(k(s));
        sb.append(" ");
        sb.append(k(s2));
        return this.l(sb.toString(), 2000L) != null;
        final Throwable t;
        t.printStackTrace();
        return false;
    }
    
    public void U(final String s, final long n) {
        if (Build$VERSION.SDK_INT >= 23) {
            final String format = ((DateFormat)z.h).format(new Date(n));
            final StringBuilder sb = new StringBuilder();
            sb.append("touch -t ");
            sb.append(format);
            sb.append(" ");
            sb.append(k(s));
            this.l(sb.toString(), 10000L);
            return;
        }
        final String format2 = ((DateFormat)z.g).format(new Date(n));
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("touch -t ");
        sb2.append(format2);
        sb2.append(" ");
        sb2.append(k(s));
        this.l(sb2.toString(), 10000L);
    }
    
    public void V(final String s, final p p2) {
        final String c = p2.c;
        if (c != null) {
            final int s2 = S(c);
            if (s2 >= 0) {
                this.d(s, s2);
            }
        }
        final String a = p2.a;
        if (a != null) {
            final String b = p2.b;
            if (b != null) {
                this.f(s, a, b);
            }
        }
    }
    
    public boolean g(final String s, final String s2, long n) {
        try {
            final long n2 = n / 1024L / 1024L;
            n = 2000L;
            if (n2 > 0L) {
                n = 2000L * n2;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("cp ");
            sb.append(k(s));
            sb.append(" ");
            sb.append(k(s2));
            return this.l(sb.toString(), n) != null;
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
            return false;
        }
    }
    
    public boolean h(final String s) {
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("touch ");
            sb.append(k(s));
            if (this.l(sb.toString(), 2000L) == null) {
                return false;
            }
            this.W(s, false);
            return true;
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
            return false;
        }
    }
    
    public boolean i(final String s) {
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("mkdir ");
            sb.append(k(s));
            if (this.l(sb.toString(), 2000L) == null) {
                return false;
            }
            this.W(s, true);
            return true;
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
            return false;
        }
    }
    
    public boolean j(final String s) {
        String s2;
        if (this.K(s)) {
            s2 = "rmdir";
        }
        else {
            s2 = "rm";
        }
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append(s2);
            sb.append(" ");
            sb.append(k(s));
            return this.l(sb.toString(), 2000L) != null;
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
            return false;
        }
    }
    
    ArrayList<String> l(final String s, final long n) {
        if (this.a) {
            return (ArrayList<String>)r.d(s, n);
        }
        return (ArrayList<String>)r.h(s, n);
    }
    
    public boolean m(final String s) {
        if (Q.Q1()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("test -e ");
            sb.append(k(s));
            sb.append(" && echo YES || echo NO");
            final ArrayList<String> l = this.l(sb.toString(), 10000L);
            return l != null && l.size() > 0 && "YES".equals(l.get(0));
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("ls -land ");
        sb2.append(k(s));
        return this.l(sb2.toString(), 10000L) != null;
    }
    
    public long n(final String s) {
        Label_0117: {
            if (!Q.I1()) {
                break Label_0117;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("stat -c\"%y|%Y\" ");
            sb.append(k(s));
            final ArrayList<String> l = this.l(sb.toString(), 10000L);
            if (l == null || l.size() <= 0) {
                return 0L;
            }
            final String[] split = ((String)l.get(0)).split("\\|");
            try {
                return ((DateFormat)z.i).parse(split[0]).getTime();
            }
            catch (final ParseException ex) {
                final String[] array = split;
                final int n = array.length;
                final int n2 = 1;
                if (n > n2) {
                    final String[] array2 = split;
                    final int n3 = 1;
                    final String s2 = array2[n3];
                    final Long n4 = Long.valueOf(s2);
                    final long longValue = n4;
                    final long longValue2 = longValue;
                    final long n5 = 1000L;
                    return longValue2 * n5;
                }
                return 0L;
            }
            try {
                final String[] array = split;
                final int n = array.length;
                final int n2 = 1;
                if (n > n2) {
                    final String[] array2 = split;
                    final int n3 = 1;
                    final String s2 = array2[n3];
                    final Long n4 = Long.valueOf(s2);
                    final long longValue2;
                    final long longValue = longValue2 = n4;
                    final long n5 = 1000L;
                    return longValue2 * n5;
                }
                return 0L;
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("ls -land ");
                sb2.append(k(s));
                final ArrayList<String> i = this.l(sb2.toString(), 10000L);
                iftrue(Label_0166:)(i != null);
                return 0L;
            Label_0168:
                while (true) {
                    int n7 = 0;
                Block_13:
                    while (true) {
                        final String s3 = (String)i.get(n7);
                        iftrue(Label_0202:)(!s3.startsWith("total"));
                        break Block_13;
                        Label_0166: {
                            n7 = 0;
                        }
                        break Label_0168;
                        Label_0202:
                        final b r = this.R(s, s3, false, false);
                        iftrue(Block_13:)(r == null);
                        return r.g;
                        iftrue(Label_0230:)(n7 >= i.size());
                        continue;
                    }
                    ++n7;
                    continue Label_0168;
                }
                Label_0230: {
                    return 0L;
                }
            }
            catch (final NumberFormatException ex2) {
                return 0L;
            }
        }
    }
    
    public p o(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("ls -lad ");
        sb.append(k(s));
        final ArrayList<String> l = this.l(sb.toString(), 10000L);
        if (l == null) {
            return null;
        }
        return Q(l);
    }
    
    public int p(final String s) {
        if (Q.P1()) {
            try {
                return Os.stat(s).st_mode & 0x1FF;
            }
            catch (final Exception ex) {}
        }
        if (Q.I1()) {
            return this.r(s);
        }
        return this.q(s);
    }
    
    public int q(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("ls -land ");
        sb.append(k(s));
        final ArrayList<String> l = this.l(sb.toString(), 10000L);
        if (l == null) {
            return -1;
        }
        for (int i = 0; i < l.size(); ++i) {
            final String s2 = (String)l.get(i);
            if (!s2.startsWith("total")) {
                return S(s2.split("\\s+")[0]);
            }
        }
        return -1;
    }
    
    public int r(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("stat -c%a ");
        sb.append(k(s));
        final ArrayList<String> l = this.l(sb.toString(), 10000L);
        if (l == null || l.size() <= 0) {
            return -1;
        }
        try {
            return Integer.valueOf((String)l.get(0), 8) & 0x1FF;
        }
        catch (final NumberFormatException ex) {
            return -1;
        }
    }
    
    public long s(final String s) {
        Label_0077: {
            if (!Q.I1()) {
                break Label_0077;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("stat -c%s ");
            sb.append(k(s));
            final ArrayList<String> l = this.l(sb.toString(), 10000L);
            if (l == null || l.size() <= 0) {
                return 0L;
            }
            try {
                return Long.valueOf((String)l.get(0));
                while (true) {
                    int n = 0;
                    final ArrayList<String> i;
                    iftrue(Label_0190:)(n >= i.size());
                    final String s2 = (String)i.get(n);
                    iftrue(Label_0162:)(!s2.startsWith("total"));
                    Block_7: {
                        break Block_7;
                        final b r;
                        Label_0162: {
                            r = this.R(s, s2, false, false);
                        }
                        iftrue(Label_0184:)(r == null);
                        return r.f;
                        Label_0126:
                        n = 0;
                        continue;
                    }
                    Label_0184: {
                        break Label_0184;
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("ls -land ");
                        sb2.append(k(s));
                        i = this.l(sb2.toString(), 10000L);
                        iftrue(Label_0126:)(i != null);
                        return 0L;
                    }
                    ++n;
                    continue;
                }
                Label_0190: {
                    return 0L;
                }
            }
            catch (final NumberFormatException ex) {
                return 0L;
            }
        }
    }
    
    public a t(final String s) {
        Label_0043: {
            if (!Q.P1()) {
                break Label_0043;
            }
            try {
                final StructStat stat = Os.stat(s);
                final int st_mode = stat.st_mode;
                return new a(stat.st_uid, stat.st_gid, z.a.c(st_mode), st_mode & 0x1FF);
                return this.u(s);
            }
            catch (final Exception ex) {
                return this.u(s);
            }
        }
    }
    
    public a u(String l) {
        final StringBuilder sb = new StringBuilder();
        sb.append("ls -land ");
        sb.append(k(l));
        l = (String)this.l(sb.toString(), 10000L);
        if (l == null) {
            return null;
        }
        int n = 0;
    Label_0149_Outer:
        while (true) {
            Label_0155: {
                if (n >= ((ArrayList)l).size()) {
                    break Label_0155;
                }
                final String s = (String)((ArrayList)l).get(n);
                while (true) {
                    if (s.startsWith("total")) {
                        break Label_0149;
                    }
                    final String[] split = s.split("\\s+");
                    if (split.length < 4) {
                        break Label_0149;
                    }
                    final String s2 = split[0];
                    try {
                        return new a(Integer.parseInt(split[2]), Integer.parseInt(split[3]), T(s2), S(s2));
                        ++n;
                        continue Label_0149_Outer;
                        return null;
                    }
                    catch (final Exception ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    public FileInputStream w(final n n, final long n2) {
        final a t = this.t(n.E());
        if (t == null || t.e() || t.d()) {
            return null;
        }
        FileInputStream fileInputStream;
        if ((fileInputStream = this.A(n, n2)) == null) {
            fileInputStream = this.y(n, n2, t);
        }
        if (fileInputStream == null) {
            return this.z(n, n2);
        }
        return fileInputStream;
    }
    
    public FileInputStream y(final n n, final long n2, final a a) {
        final String t = n.T();
        final String r = d0.r(t);
        final int p3 = this.p(t);
        if (p3 < 0) {
            return null;
        }
        int p4;
        if ("/".equals((Object)t)) {
            p4 = 0;
        }
        else {
            p4 = this.p(r);
        }
        int n3 = 1;
        int d = 1;
    Label_0255:
        while (true) {
            try {
                final boolean n4 = N(p3, 1);
                Label_0116: {
                    if (!n4) {
                        try {
                            d = (this.d(t, p3 | 0x1) ? 1 : 0);
                            if (d == 0) {
                                if (!n4) {
                                    this.d(t, p3);
                                }
                                return null;
                            }
                            break Label_0116;
                        }
                        finally {
                            d = (n4 ? 1 : 0);
                        }
                        n3 = 1;
                        break Label_0255;
                    }
                }
                if (p4 > 0) {
                    final boolean n5 = N(p4, 1);
                    if ((n3 = (n5 ? 1 : 0)) == 0) {
                        d = (n5 ? 1 : 0);
                        try {
                            final boolean d2 = this.d(r, p4 | 0x1);
                            n3 = (n5 ? 1 : 0);
                            if (!d2) {
                                if (!n4) {
                                    this.d(t, p3);
                                }
                                if (!n5) {
                                    this.d(r, p4);
                                }
                                return null;
                            }
                        }
                        finally {
                            n3 = d;
                            d = (n4 ? 1 : 0);
                            break Label_0255;
                        }
                    }
                }
                d = n3;
                final FileInputStream x = this.x(n.E(), n2, a);
                if (!n4) {
                    this.d(t, p3);
                }
                if (n3 == 0) {
                    this.d(r, p4);
                }
                return x;
            }
            finally {
                continue;
            }
            break;
        }
        if (d == 0) {
            this.d(t, p3);
        }
        if (n3 == 0) {
            this.d(r, p4);
        }
    }
    
    public FileInputStream z(n n, final long n2) {
        final File z = n.Z();
        final String absolutePath = z.getAbsolutePath();
        Label_0099: {
            if (!this.g(n.E(), absolutePath, ((ax.c3.b)n).p())) {
                break Label_0099;
            }
            Label_0091: {
                try {
                    this.d(absolutePath, 511);
                    n = (n)new FileInputStream(absolutePath);
                    if (n2 != 0L) {
                        try {
                            ((FileInputStream)n).skip(n2);
                        }
                        catch (final IOException ex) {
                            break Label_0091;
                        }
                    }
                    t.b().c(z);
                    t.b().a();
                    return (FileInputStream)n;
                }
                catch (final IOException ex2) {
                    n = null;
                }
            }
            if (n == null) {
                break Label_0099;
            }
            try {
                ((FileInputStream)n).close();
                return null;
            }
            catch (final IOException ex3) {
                return null;
            }
        }
    }
    
    static class a
    {
        int a;
        int b;
        int c;
        int d;
        
        a(final int a, final int b, final int d, final int c) {
            this.a = a;
            this.b = b;
            this.d = d;
            this.c = c;
        }
        
        static int c(final int n) {
            return n & 0xF000;
        }
        
        private boolean d() {
            return this.d == 16384;
        }
        
        private boolean e() {
            return this.d == 4096;
        }
    }
    
    private static class b
    {
        String a;
        boolean b;
        boolean c;
        boolean d;
        boolean e;
        long f;
        long g;
        
        b(final String a, final boolean b, final boolean c, final boolean d, final boolean e, final long f, final long g) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
        }
    }
    
    class c extends FileOutputStream implements AutoCloseable
    {
        private String c0;
        private a d0;
        private boolean e0;
        final z f0;
        private String q;
        
        c(final z f0, final String c0, final String q, final a d0) throws IOException {
            this.f0 = f0;
            super(q);
            this.e0 = false;
            this.c0 = c0;
            this.q = q;
            this.d0 = d0;
        }
        
        public void close() throws IOException {
            super.close();
            if (this.e0) {
                return;
            }
            this.e0 = true;
            if (!this.f0.P(this.q, this.c0, true)) {
                throw new IOException("Move temp file to the path failed");
            }
            final a d0 = this.d0;
            if (d0 != null) {
                this.f0.d(this.c0, d0.c);
                final z f0 = this.f0;
                final String c0 = this.c0;
                final a d2 = this.d0;
                f0.e(c0, d2.a, d2.b);
                return;
            }
            this.f0.W(this.c0, false);
        }
    }
}
