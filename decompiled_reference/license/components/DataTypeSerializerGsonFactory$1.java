package com.alphainventor.filemanager.license.components;

import com.alphainventor.filemanager.license.datatypes.ProductCatalogImpl;
import ax.Fa.d;
import com.alphainventor.filemanager.license.datatypes.LicensePurchasedImpl;
import ax.Fa.c;
import com.google.gson.TypeAdapter;
import ax.x8.a;
import com.google.gson.Gson;
import ax.r8.w;

class DataTypeSerializerGsonFactory$1 implements w
{
    public <T> TypeAdapter<T> b(final Gson gson, final a<T> a) {
        if (c.class.equals(a.c())) {
            return (TypeAdapter<T>)gson.n((Class)LicensePurchasedImpl.class);
        }
        if (d.class.equals(a.c())) {
            return (TypeAdapter<T>)gson.n((Class)ProductCatalogImpl.class);
        }
        return null;
    }
}
