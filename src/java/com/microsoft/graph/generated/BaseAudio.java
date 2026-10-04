package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseAudio implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("album")
    public String c;
    @a
    @c("albumArtist")
    public String d;
    @a
    @c("artist")
    public String e;
    @a
    @c("bitrate")
    public Long f;
    @a
    @c("composers")
    public String g;
    @a
    @c("copyright")
    public String h;
    @a
    @c("disc")
    public Integer i;
    @a
    @c("discCount")
    public Integer j;
    @a
    @c("duration")
    public Long k;
    @a
    @c("genre")
    public String l;
    @a
    @c("hasDrm")
    public Boolean m;
    @a
    @c("isVariableBitrate")
    public Boolean n;
    @a
    @c("title")
    public String o;
    @a
    @c("track")
    public Integer p;
    @a
    @c("trackCount")
    public Integer q;
    @a
    @c("year")
    public Integer r;
    private transient l s;
    private transient e t;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e t, final l s) {
        this.t = t;
        this.s = s;
    }
}
