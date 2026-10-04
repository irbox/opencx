package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;

public class BaseVideo implements d
{
    @a
    @c("@odata.type")
    public String a;
    private transient com.microsoft.graph.serializer.a b;
    @a
    @c("audioBitsPerSample")
    public Integer c;
    @a
    @c("audioChannels")
    public Integer d;
    @a
    @c("audioFormat")
    public String e;
    @a
    @c("audioSamplesPerSecond")
    public Integer f;
    @a
    @c("bitrate")
    public Integer g;
    @a
    @c("duration")
    public Long h;
    @a
    @c("fourCC")
    public String i;
    @a
    @c("frameRate")
    public Double j;
    @a
    @c("height")
    public Integer k;
    @a
    @c("width")
    public Integer l;
    private transient l m;
    private transient e n;
    
    public final com.microsoft.graph.serializer.a c() {
        return this.b;
    }
    
    public void d(final e n, final l m) {
        this.n = n;
        this.m = m;
    }
}
