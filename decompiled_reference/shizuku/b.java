package com.alphainventor.filemanager.shizuku;

import java.util.ArrayList;
import java.util.List;
import com.alphainventor.filemanager.file.J;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import android.os.ParcelFileDescriptor;
import ax.X2.v;
import ax.X2.L;
import ax.c3.B;
import ax.p3.a;
import java.io.IOException;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;

class b
{
    private static final int a;
    private static ThreadPoolExecutor b;
    public static int c;
    public static int d;
    
    static {
        final int n = a = Runtime.getRuntime().availableProcessors();
        com.alphainventor.filemanager.shizuku.b.b = new ThreadPoolExecutor(n + 1, n * 4 + 1, 1L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue(256), (ThreadFactory)new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                return new Thread((ThreadGroup)null, (Runnable)new Runnable(this, runnable) {
                    final b$a c0;
                    final Runnable q;
                    
                    public void run() {
                        Process.setThreadPriority(2);
                        this.q.run();
                    }
                }, "Binder TaskExecutor", 32768L);
            }
        });
        com.alphainventor.filemanager.shizuku.b.c = 100;
        com.alphainventor.filemanager.shizuku.b.d = 110;
    }
    
    public static IllegalStateException a(final int n, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("error=");
        sb.append(n);
        sb.append(";msg=");
        sb.append(s);
        return new IllegalStateException(sb.toString());
    }
    
    public static boolean b(final String s) {
        final File file = new File(s);
        try {
            return file.createNewFile();
        }
        catch (final IOException ex) {
            return false;
        }
    }
    
    private static a c(final File file) {
        final a a = new a();
        a.q = file.getAbsolutePath();
        a.c0 = file.getName();
        final boolean exists = file.exists();
        a.d0 = exists;
        if (exists) {
            a.g0 = file.canRead();
            a.h0 = file.canWrite();
            a.e0 = file.isDirectory();
            try {
                a.i0 = file.length();
            }
            catch (final IllegalArgumentException ex) {
                a.i0 = -1L;
            }
            a.j0 = file.lastModified();
            try {
                a.f0 = B.R(file);
            }
            catch (final IOException ex2) {
                a.f0 = false;
            }
            return a;
        }
        a.i0 = -1L;
        a.j0 = -1L;
        return a;
    }
    
    public static boolean d(final String s) {
        return new File(s).delete();
    }
    
    public static c e(final IllegalStateException ex) {
        try {
            if (((Throwable)ex).getMessage() != null && ((Throwable)ex).getMessage().startsWith("error=")) {
                final String message = ((Throwable)ex).getMessage();
                final int index = message.indexOf(";");
                if (index > 0) {
                    return new c(Integer.parseInt(message.substring(0, index).substring(6)), message.substring(index + 1).substring(4));
                }
            }
            return null;
        }
        catch (final NumberFormatException | IndexOutOfBoundsException ex2) {
            return null;
        }
    }
    
    public static a f(final String s) {
        return h(s);
    }
    
    private static a g(final String s) {
        return c(new File(s));
    }
    
    public static a h(final String s) {
        try {
            final a g = g(s);
            final L l = v.l(s, new L());
            g.d0 = l.e;
            g.i0 = l.a;
            g.e0 = l.b;
            g.j0 = l.c;
            return g;
        }
        catch (final IOException ex) {
            throw a(com.alphainventor.filemanager.shizuku.b.c, ((Throwable)ex).getMessage());
        }
    }
    
    public static ParcelFileDescriptor i(final String s) {
        try {
            return ParcelFileDescriptor.open(new File(s), 268435456);
        }
        catch (final FileNotFoundException ex) {
            throw a(com.alphainventor.filemanager.shizuku.b.d, ((Throwable)ex).getMessage());
        }
    }
    
    public static int j(final String s, final boolean b) {
        final String[] list = new File(s).list((FilenameFilter)new FilenameFilter(b) {
            final boolean q;
            
            public boolean accept(final File file, final String s) {
                if (s != null) {
                    final boolean startsWith = s.startsWith(".");
                    if (this.q) {
                        if (J.k2(s)) {
                            return false;
                        }
                    }
                    else if (startsWith) {
                        return false;
                    }
                }
                return true;
            }
        });
        if (list == null) {
            return -2;
        }
        return list.length;
    }
    
    public static ParcelFileDescriptor k(final String s, final boolean b) {
        int n;
        if (b) {
            n = 704643072;
        }
        else {
            n = 671088640;
        }
        try {
            return ParcelFileDescriptor.open(new File(s), n);
        }
        catch (final IOException ex) {
            throw a(b.c, ((Throwable)ex).getMessage());
        }
    }
    
    public static ParcelFileDescriptor l(final String s) {
        try {
            return ParcelFileDescriptor.open(new File(s), 805306368);
        }
        catch (final FileNotFoundException ex) {
            throw a(com.alphainventor.filemanager.shizuku.b.d, ((Throwable)ex).getMessage());
        }
    }
    
    public static List<a> m(final String s) {
        final File[] listFiles = new File(s).listFiles();
        if (listFiles != null) {
            final ArrayList list = new ArrayList();
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                ((List)list).add((Object)c(listFiles[i]));
            }
            return (List<a>)list;
        }
        return null;
    }
    
    public static boolean n(final String s) {
        return new File(s).mkdir();
    }
    
    public static boolean o(final String s, final String s2) {
        try {
            return new File(s).renameTo(new File(s2));
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    public static boolean p(final String s, long lastModified) {
        if (lastModified < 0L) {
            return false;
        }
        try {
            final File file = new File(s);
            file.setLastModified(lastModified);
            final long n = file.lastModified() / 1000L;
            lastModified /= 1000L;
            if (n == lastModified) {
                return true;
            }
            return false;
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    public static class c
    {
        int a;
        String b;
        
        c(final int a, final String b) {
            this.a = a;
            this.b = b;
        }
    }
}
