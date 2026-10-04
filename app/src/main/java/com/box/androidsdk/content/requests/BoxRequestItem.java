package com.box.androidsdk.content.requests;

import java.util.AbstractMap;
import com.box.androidsdk.content.BoxException;
import android.text.TextUtils;
import java.util.Locale;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxJsonObject;

public abstract class BoxRequestItem<E extends BoxJsonObject, R extends BoxRequest<E, R>> extends BoxRequest<E, R>
{
    protected static String e0 = "fields";
    protected StringBuffer mHintHeader;
    protected String mId;
    
    public BoxRequestItem(final Class<E> clazz, final String mId, final String s, final BoxSession boxSession) {
        super(clazz, s, boxSession);
        this.mId = null;
        this.mHintHeader = new StringBuffer();
        super.mContentType = ContentTypes.q;
        this.mId = mId;
    }
    
    public R E(final String... array) {
        if (array.length == 1 && array[0] == null) {
            super.mQueryMap.remove((Object)BoxRequestItem.e0);
            return (R)this;
        }
        if (array.length > 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append(array[0]);
            for (int i = 1; i < array.length; ++i) {
                sb.append(String.format(Locale.ENGLISH, ",%s", new Object[] { array[i] }));
            }
            super.mQueryMap.put((Object)BoxRequestItem.e0, (Object)sb.toString());
        }
        return (R)this;
    }
    
    @Override
    protected void f() {
        super.f();
        if (!TextUtils.isEmpty((CharSequence)this.mHintHeader)) {
            ((AbstractMap)super.mHeaderMap).put((Object)"x-rep-hints", (Object)this.mHintHeader.toString());
        }
    }
    
    @Override
    protected void u(final BoxResponse<E> boxResponse) throws BoxException {
        super.u(boxResponse);
        super.q(boxResponse);
    }
}
