package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.User;
import com.microsoft.graph.extensions.ItemReference;
import java.util.Calendar;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.IdentitySet;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseBaseItem extends Entity implements d
{
    @a
    @c("createdBy")
    public IdentitySet f;
    @a
    @c("createdDateTime")
    public Calendar g;
    @a
    @c("description")
    public String h;
    @a
    @c("eTag")
    public String i;
    @a
    @c("lastModifiedBy")
    public IdentitySet j;
    @a
    @c("lastModifiedDateTime")
    public Calendar k;
    @a
    @c("name")
    public String l;
    @a
    @c("parentReference")
    public ItemReference m;
    @a
    @c("webUrl")
    public String n;
    @a
    @c("createdByUser")
    public User o;
    @a
    @c("lastModifiedByUser")
    public User p;
    private transient l q;
    private transient e r;
    
    public void d(final e r, final l q) {
        this.r = r;
        this.q = q;
    }
}
