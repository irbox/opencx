package com.box.androidsdk.content.models;

public class BoxIteratorBoxEntity<E extends BoxEntity> extends BoxIterator<E>
{
    private static final long serialVersionUID = 8036181424029520417L;
    private transient b<E> q;
    
    @Override
    protected b<E> I() {
        final b<E> q = this.q;
        if (q != null) {
            return q;
        }
        return this.q = (b<E>)BoxEntity.E();
    }
}
