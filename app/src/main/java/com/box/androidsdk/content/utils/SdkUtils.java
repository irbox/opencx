package com.box.androidsdk.content.utils;

import android.view.View;
import java.util.AbstractMap;
import android.os.Handler;
import android.widget.Toast;
import android.os.Looper;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import ax.I3.a;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import android.net.NetworkInfo;
import android.net.Network;
import android.net.ConnectivityManager;
import android.content.res.AssetManager;
import ax.H3.b;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.content.Context;
import java.util.UUID;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import ax.H3.g;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.security.MessageDigest;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.HashMap;

public class SdkUtils
{
    protected static final int[] a;
    private static final char[] b;
    private static HashMap<Integer, Long> c;
    public static long d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    
    static {
        a = new int[] { -4056997, -1231017, -103524, -680300, -551424, -675045, -4733409, -14237055, -15359317, -11221777, -15620865, -9467905, -12627501, -10011977, -5552196 };
        b = "0123456789abcdef".toCharArray();
        SdkUtils.c = new HashMap<Integer, Long>() {
            private void b() {
                final long currentTimeMillis = System.currentTimeMillis();
                final long d = SdkUtils.d;
                for (final Map$Entry map$Entry : ((AbstractMap)this).entrySet()) {
                    if ((long)map$Entry.getValue() < currentTimeMillis - d) {
                        SdkUtils.c.remove((Object)map$Entry);
                    }
                }
            }
            
            public Long c(final Integer n, final Long n2) {
                final Long n3 = (Long)super.put((Object)n, (Object)n2);
                if (((AbstractMap)this).size() > 9) {
                    this.b();
                }
                return n3;
            }
        };
        SdkUtils.d = 3000L;
        SdkUtils.e = "%4.0f B";
        SdkUtils.f = "%4.1f KB";
        SdkUtils.g = "%4.1f MB";
        SdkUtils.h = "%4.1f GB";
        SdkUtils.i = "%4.1f TB";
        SdkUtils.j = "";
    }
    
    public static String b(final String[] array, final String s) {
        final StringBuilder sb = new StringBuilder();
        final int length = array.length;
        int n = 0;
        int n2;
        while (true) {
            n2 = length - 1;
            if (n >= n2) {
                break;
            }
            sb.append(array[n]);
            sb.append(s);
            ++n;
        }
        sb.append(array[n2]);
        return sb.toString();
    }
    
    public static void c(final InputStream inputStream, final OutputStream outputStream) throws IOException, InterruptedException {
        d(inputStream, outputStream, null);
    }
    
    private static void d(final InputStream inputStream, final OutputStream outputStream, final MessageDigest messageDigest) throws IOException, InterruptedException {
        final byte[] array = new byte[8192];
        while (true) {
            Object o2;
            final Object o = o2 = null;
            try {
                Label_0099: {
                    try {
                        final int read = inputStream.read(array);
                        if (read <= 0) {
                            break Label_0099;
                        }
                        o2 = o;
                        if (Thread.currentThread().isInterrupted()) {
                            throw new InterruptedException();
                        }
                        o2 = o;
                        outputStream.write(array, 0, read);
                        if (messageDigest != null) {
                            o2 = o;
                            messageDigest.update(array, 0, read);
                            continue;
                        }
                        continue;
                    }
                    finally {
                        if (o2 == null) {
                            outputStream.flush();
                        }
                        throw new InterruptedException();
                        final Exception ex;
                        while (true) {
                            iftrue(Label_0125:)(ex instanceof InterruptedException);
                            return;
                            outputStream.flush();
                            return;
                            iftrue(Label_0133:)(ex instanceof IOException);
                            continue;
                        }
                        Label_0133: {
                            throw (IOException)ex;
                        }
                        Label_0125:
                        throw (InterruptedException)ex;
                    }
                }
            }
            catch (final Exception ex2) {}
        }
    }
    
    public static String e(final InputStream inputStream, final OutputStream outputStream) throws NoSuchAlgorithmException, IOException, InterruptedException {
        final MessageDigest instance = MessageDigest.getInstance("SHA-1");
        d(inputStream, outputStream, instance);
        return new String(h(instance.digest()));
    }
    
    public static ThreadPoolExecutor f(final int n, final int n2, final long n3, final TimeUnit timeUnit) {
        return (ThreadPoolExecutor)new g(n, n2, n3, timeUnit, (BlockingQueue)new LinkedBlockingQueue(), (ThreadFactory)new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                return new Thread(runnable);
            }
        });
    }
    
    public static boolean g(final File file) {
        if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            int i = 0;
            if (listFiles == null) {
                return false;
            }
            while (i < listFiles.length) {
                g(listFiles[i]);
                ++i;
            }
        }
        return file.delete();
    }
    
    private static char[] h(final byte[] array) {
        final int length = array.length;
        final char[] array2 = new char[length << 1];
        int n = 0;
        int n2 = 0;
        while (true) {
            final int n3 = n2;
            if (n >= length) {
                break;
            }
            final char[] b = SdkUtils.b;
            final byte b2 = array[n];
            array2[n3] = b[(b2 & 0xF0) >>> 4];
            n2 = n3 + 2;
            array2[n3 + 1] = b[b2 & 0xF];
            ++n;
        }
        return array2;
    }
    
    public static String i() {
        return UUID.randomUUID().toString();
    }
    
    public static String j(Context ex, final String s) {
        final AssetManager assets = ((Context)ex).getAssets();
        ex = null;
        Label_0168: {
            Object string = null;
            BufferedReader bufferedReader = null;
            Label_0137: {
                try {
                    string = new StringBuilder();
                    final Object o = new BufferedReader((Reader)new InputStreamReader(assets.open(s)));
                    int n = 1;
                    while (true) {
                        ex = (Exception)o;
                        try {
                            try {
                                final String line = ((BufferedReader)o).readLine();
                                if (line != null) {
                                    if (n != 0) {
                                        n = 0;
                                    }
                                    else {
                                        ex = (Exception)o;
                                        ((StringBuilder)string).append('\n');
                                    }
                                    ex = (Exception)o;
                                    ((StringBuilder)string).append(line);
                                    continue;
                                }
                                break;
                            }
                            finally {}
                        }
                        catch (final IOException string) {
                            break Label_0137;
                        }
                        break;
                    }
                    ex = (Exception)o;
                    string = ((StringBuilder)string).toString();
                    try {
                        ((BufferedReader)o).close();
                        return (String)string;
                    }
                    catch (final Exception ex) {
                        ax.H3.b.b("getAssetFile", s, (Throwable)ex);
                        return (String)string;
                    }
                }
                catch (final IOException string) {
                    bufferedReader = null;
                }
                finally {
                    break Label_0168;
                }
            }
            ax.H3.b.b("getAssetFile", s, (Throwable)string);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (final Exception ex2) {
                    ax.H3.b.b("getAssetFile", s, (Throwable)ex2);
                }
            }
            return null;
        }
        if (ex != null) {
            try {
                ((BufferedReader)ex).close();
            }
            catch (final Exception ex3) {
                ax.H3.b.b("getAssetFile", s, (Throwable)ex3);
            }
        }
    }
    
    public static boolean k(final String s) {
        return s == null || s.trim().length() == 0;
    }
    
    public static boolean l(final String s) {
        return s == null || s.length() == 0;
    }
    
    public static boolean m(final Context context) {
        return n((ConnectivityManager)context.getApplicationContext().getSystemService("connectivity"));
    }
    
    private static boolean n(final ConnectivityManager connectivityManager) {
        final Network[] allNetworks = connectivityManager.getAllNetworks();
        if (allNetworks != null) {
            for (int length = allNetworks.length, i = 0; i < length; ++i) {
                final NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i]);
                if (networkInfo != null && networkInfo.isConnected() && (networkInfo.getType() == 1 || networkInfo.getType() == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void o(final Context context, final TextView textView, final int n) {
        String string;
        if (n >= 100) {
            string = "+99";
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append("+");
            sb.append(Integer.toString(n));
            string = sb.toString();
        }
        p(textView);
        textView.setTextColor(-1);
        textView.setText((CharSequence)string);
    }
    
    public static void p(final TextView textView) {
        r(textView, -14997455, -1);
    }
    
    public static void q(final TextView textView, final int n) {
        final int[] a = SdkUtils.a;
        r(textView, a[n % a.length], -1);
    }
    
    public static void r(final TextView textView, final int n, final int n2) {
        final GradientDrawable background = (GradientDrawable)((View)textView).getResources().getDrawable(ax.I3.a.b);
        ((Drawable)background).setColorFilter(n, PorterDuff$Mode.MULTIPLY);
        background.setStroke(3, n2);
        ((View)textView).setBackground((Drawable)background);
    }
    
    public static void s(final Context context, final TextView textView, final String s) {
        char char1 = '\0';
        char char2 = '\0';
        Label_0060: {
            if (s != null) {
                final String[] split = s.split(" ");
                if (split[0].length() > 0) {
                    char1 = split[0].charAt(0);
                }
                else {
                    char1 = '\0';
                }
                if (split.length > 1) {
                    char2 = split[split.length - 1].charAt(0);
                    break Label_0060;
                }
            }
            char2 = '\0';
        }
        q(textView, char1 + char2);
        final StringBuilder sb = new StringBuilder();
        sb.append(char1);
        sb.append("");
        sb.append(char2);
        textView.setText((CharSequence)sb.toString());
        textView.setTextColor(-1);
    }
    
    public static void t(final Context context, final int n, final int n2) {
        final Long n3 = (Long)SdkUtils.c.get((Object)n);
        if (n3 != null && n3 + SdkUtils.d > System.currentTimeMillis()) {
            return;
        }
        final Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread().equals(mainLooper.getThread())) {
            SdkUtils.c.put((Object)n, (Object)System.currentTimeMillis());
            Toast.makeText(context, n, n2).show();
            return;
        }
        new Handler(mainLooper).post((Runnable)new Runnable(n, context, n2) {
            final Context c0;
            final int d0;
            final int q;
            
            public void run() {
                SdkUtils.c.put((Object)this.q, (Object)System.currentTimeMillis());
                Toast.makeText(this.c0, this.q, this.d0).show();
            }
        });
    }
}
