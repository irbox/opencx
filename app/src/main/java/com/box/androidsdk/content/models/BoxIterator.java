package com.box.androidsdk.content.models;

import java.util.Collections;
import java.util.Iterator;
import ax.O4.d;
import java.util.ArrayList;

public abstract class BoxIterator<E extends BoxJsonObject> extends BoxJsonObject implements Iterable<E>
{
    private static final long serialVersionUID = 8036181424029520417L;
    
    public Long C() {
        return this.t("total_count");
    }
    
    public E D(final int n) {
        return this.E(this.I(), n);
    }
    
    public E E(final b<E> b, final int n) {
        return (E)this.G().get(n);
    }
    
    public ArrayList<E> G() {
        return this.s(this.I(), "entries");
    }
    
    protected abstract b<E> I();
    
    public Long J() {
        return this.t("offset");
    }
    
    @Override
    public void i(final d d) {
        super.i(d);
    }
    
    public Iterator<E> iterator() {
        if (this.G() == null) {
            return (Iterator<E>)Collections.EMPTY_LIST.iterator();
        }
        return (Iterator<E>)this.G().iterator();
    }
}
