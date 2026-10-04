package com.alphainventor.filemanager.file;

import com.microsoft.graph.generated.BaseUploadSession;
import ax.b3.j;
import java.io.InputStream;
import java.io.IOException;
import ax.L9.e;
import ax.S9.c;
import java.util.List;
import java.security.InvalidParameterException;
import com.microsoft.graph.extensions.UploadSession;
import ax.L9.a;
import ax.c3.G;
import ax.N9.e0;

public class E<UploadType>
{
    private final e0 a;
    private final G b;
    private final String c;
    private final long d;
    private final ax.L9.a<UploadType> e;
    private int f;
    
    public E(final UploadSession uploadSession, final e0 a, final G b, final long d, final Class<UploadType> clazz) {
        if (uploadSession == null) {
            throw new InvalidParameterException("Upload session is null.");
        }
        if (a == null) {
            throw new InvalidParameterException("OneDrive client is null.");
        }
        if (b == null) {
            throw new InvalidParameterException("Input stream is null.");
        }
        if (d > 0L) {
            this.a = a;
            this.f = 0;
            this.b = b;
            this.d = d;
            this.c = ((BaseUploadSession)uploadSession).e;
            this.e = (ax.L9.a<UploadType>)new ax.L9.a((Class)clazz);
            return;
        }
        throw new InvalidParameterException("Stream size should larger than 0.");
    }
    
    public void a(final List<c> list, final ax.u3.c c, final e<UploadType> e, int... array) throws IOException, j {
        int n;
        if (array.length > 0) {
            n = array[0];
        }
        else {
            n = 5242880;
        }
        int n2;
        if (array.length > 1) {
            n2 = array[1];
        }
        else {
            n2 = 3;
        }
        if (n % 327680 != 0) {
            throw new IllegalArgumentException("Chunk size must be a multiple of 320 KiB");
        }
        if (n > 62914560) {
            throw new IllegalArgumentException("Please set chunk size smaller than 60 MiB");
        }
        final InputStream b = this.b.b();
        if (b == null) {
            throw new IOException("no input stream");
        }
        array = (int[])(Object)new a(this.b, b);
        Label_0275: {
            while (true) {
                Object a;
                try {
                    final int f = this.f;
                    final long n3 = f;
                    final long d = this.d;
                    if (n3 >= d) {
                        break;
                    }
                    final int n4 = (int)Math.min((long)n, d - f);
                    a = new F(this.c, this.a, list, (a)(Object)array, n4, c, n2, this.f, this.d, e);
                    a = ((F)a).a(this.e);
                    this.f += n4;
                    if (((ax.N9.e)a).e()) {
                        final long d2 = this.d;
                        e.a(d2, d2);
                        ((ax.L9.c)e).c(((ax.N9.e)a).c());
                        break;
                    }
                }
                finally {
                    break Label_0275;
                }
                if (((ax.N9.e)a).a()) {
                    e.a((long)this.f, this.d);
                }
                else {
                    if (((ax.N9.e)a).d()) {
                        ((ax.L9.c)e).b(((ax.N9.e)a).b());
                        break;
                    }
                    continue;
                }
            }
            ((a)(Object)array).b.close();
            return;
        }
        ((a)(Object)array).b.close();
    }
    
    public static class a
    {
        G a;
        InputStream b;
        
        a(final G a, final InputStream b) {
            this.a = a;
            this.b = b;
        }
    }
}
