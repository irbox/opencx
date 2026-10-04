package com.alphainventor.filemanager.viewer;

import android.net.Uri;
import java.util.ArrayList;

public class e
{
    private static e b;
    ArrayList<a> a;
    
    public static e b() {
        if (e.b == null) {
            e.b = new e();
        }
        return e.b;
    }
    
    public void a() {
        this.a = null;
    }
    
    public ArrayList<a> c() {
        final ArrayList<a> a = this.a;
        this.a = null;
        return a;
    }
    
    public void d(final ArrayList<a> a) {
        this.a = a;
    }
    
    public static class a
    {
        public Uri a;
        public Uri b;
        
        public a(final Uri a, final Uri b) {
            this.a = a;
            this.b = b;
        }
    }
}
