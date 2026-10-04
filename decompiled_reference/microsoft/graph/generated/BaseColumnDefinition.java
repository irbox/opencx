package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.TextColumn;
import com.microsoft.graph.extensions.PersonOrGroupColumn;
import com.microsoft.graph.extensions.NumberColumn;
import com.microsoft.graph.extensions.LookupColumn;
import com.microsoft.graph.extensions.DefaultColumnValue;
import com.microsoft.graph.extensions.DateTimeColumn;
import com.microsoft.graph.extensions.CurrencyColumn;
import com.microsoft.graph.extensions.ChoiceColumn;
import com.microsoft.graph.extensions.CalculatedColumn;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.BooleanColumn;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BaseColumnDefinition extends Entity implements d
{
    @a
    @c("boolean")
    public BooleanColumn f;
    @a
    @c("calculated")
    public CalculatedColumn g;
    @a
    @c("choice")
    public ChoiceColumn h;
    @a
    @c("columnGroup")
    public String i;
    @a
    @c("currency")
    public CurrencyColumn j;
    @a
    @c("dateTime")
    public DateTimeColumn k;
    @a
    @c("defaultValue")
    public DefaultColumnValue l;
    @a
    @c("description")
    public String m;
    @a
    @c("displayName")
    public String n;
    @a
    @c("enforceUniqueValues")
    public Boolean o;
    @a
    @c("hidden")
    public Boolean p;
    @a
    @c("indexed")
    public Boolean q;
    @a
    @c("lookup")
    public LookupColumn r;
    @a
    @c("name")
    public String s;
    @a
    @c("number")
    public NumberColumn t;
    @a
    @c("personOrGroup")
    public PersonOrGroupColumn u;
    @a
    @c("readOnly")
    public Boolean v;
    @a
    @c("required")
    public Boolean w;
    @a
    @c("text")
    public TextColumn x;
    private transient l y;
    private transient e z;
    
    public void d(final e z, final l y) {
        this.z = z;
        this.y = y;
    }
}
