package com.microsoft.graph.generated;

import ax.T9.e;
import ax.r8.l;
import com.microsoft.graph.extensions.PersonType;
import com.microsoft.graph.extensions.Location;
import java.util.List;
import ax.s8.c;
import ax.s8.a;
import ax.T9.d;
import com.microsoft.graph.extensions.Entity;

public class BasePerson extends Entity implements d
{
    @a
    @c("displayName")
    public String f;
    @a
    @c("givenName")
    public String g;
    @a
    @c("surname")
    public String h;
    @a
    @c("birthday")
    public String i;
    @a
    @c("personNotes")
    public String j;
    @a
    @c("isFavorite")
    public Boolean k;
    @a
    @c("scoredEmailAddresses")
    public List<Object> l;
    @a
    @c("phones")
    public List<Object> m;
    @a
    @c("postalAddresses")
    public List<Location> n;
    @a
    @c("websites")
    public List<Object> o;
    @a
    @c("jobTitle")
    public String p;
    @a
    @c("companyName")
    public String q;
    @a
    @c("yomiCompany")
    public String r;
    @a
    @c("department")
    public String s;
    @a
    @c("officeLocation")
    public String t;
    @a
    @c("profession")
    public String u;
    @a
    @c("personType")
    public PersonType v;
    @a
    @c("userPrincipalName")
    public String w;
    @a
    @c("imAddress")
    public String x;
    private transient l y;
    private transient e z;
    
    public void d(final e z, final l y) {
        this.z = z;
        this.y = y;
    }
}
