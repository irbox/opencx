package com.microsoft.graph.generated;

import ax.r8.f;
import ax.T9.e;
import ax.r8.l;
import ax.s8.c;
import ax.s8.a;
import com.microsoft.graph.extensions.Extension;
import java.util.List;
import ax.T9.d;

public class BaseExtensionCollectionResponse implements d
{
    @a
    @c("value")
    public List<Extension> a;
    @a(serialize = false)
    @c("@odata.nextLink")
    public String b;
    private transient com.microsoft.graph.serializer.a c;
    private transient l d;
    private transient e e;
    
    public BaseExtensionCollectionResponse() {
        this.c = new com.microsoft.graph.serializer.a((d)this);
    }
    
    public final com.microsoft.graph.serializer.a c() {
        return this.c;
    }
    
    public void d(final e e, final l d) {
        this.e = e;
        this.d = d;
        if (d.x("value")) {
            final f u = d.u("value");
            for (int i = 0; i < u.size(); ++i) {
                ((BaseExtension)this.a.get(i)).d(this.e, (l)u.s(i));
            }
        }
    }
}
