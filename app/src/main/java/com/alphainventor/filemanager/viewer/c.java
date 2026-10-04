package com.alphainventor.filemanager.viewer;

import com.alphainventor.filemanager.file.n;
import java.util.List;
import java.util.HashMap;

public class c
{
    static c b;
    HashMap<String, a> a;
    
    public c() {
        this.a = (HashMap<String, a>)new HashMap();
    }
    
    public static c b() {
        if (c.b == null) {
            c.b = new c();
        }
        return c.b;
    }
    
    public a a(final String s) {
        if (s == null) {
            return null;
        }
        return (a)this.a.remove((Object)s);
    }
    
    public void c(final String s, final List<n> list, final int n) {
        this.a.put((Object)s, (Object)new a(list, n));
    }
    
    public static class a
    {
        List<n> a;
        int b;
        
        a(final List<n> a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
}
