package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.Notebook;
import com.microsoft.graph.extensions.OnenoteSection;
import java.util.List;
import java.util.Calendar;
import com.microsoft.graph.extensions.PageLinks;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.OnenoteEntitySchemaObjectModel;

public class BaseOnenotePage extends OnenoteEntitySchemaObjectModel implements d
{
    @a
    @c("title")
    public String l;
    @a
    @c("createdByAppId")
    public String m;
    @a
    @c("links")
    public PageLinks n;
    @a
    @c("contentUrl")
    public String o;
    @a
    @c("lastModifiedDateTime")
    public Calendar p;
    @a
    @c("level")
    public Integer q;
    @a
    @c("order")
    public Integer r;
    @a
    @c("userTags")
    public List<String> s;
    @a
    @c("parentSection")
    public OnenoteSection t;
    @a
    @c("parentNotebook")
    public Notebook u;
    private transient l v;
    private transient e w;
    
    public void d(final e w, final l v) {
        this.w = w;
        this.v = v;
    }
}
