package com.alphainventor.filemanager.widget;

import android.view.View;
import android.widget.TextView;
import android.text.StaticLayout;
import android.text.Layout$Alignment;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import ax.c3.d0;
import android.widget.TextView$BufferType;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.content.Context;
import android.text.SpannableString;
import androidx.appcompat.widget.x;

public class GridFilenameTextView extends x
{
    private SpannableString h;
    private b i;
    private boolean j;
    private boolean k;
    private boolean l;
    private CharSequence m;
    private String n;
    private boolean o;
    
    public GridFilenameTextView(final Context context, final AttributeSet set) {
        this(context, set, 16842884);
    }
    
    public GridFilenameTextView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.h = new SpannableString((CharSequence)"...");
        this.k = true;
        this.i = new b();
    }
    
    private boolean t(final String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        final int index = s.indexOf(46);
        return index != 0 && index >= 0;
    }
    
    private void u() {
        if (!this.t(this.n)) {
            this.k = false;
            this.j = false;
            return;
        }
        final int maxLines = ((TextView)this).getMaxLines();
        CharSequence text;
        final CharSequence charSequence = text = this.m;
        if (maxLines != -1) {
            text = this.i.d(charSequence, this.n);
        }
        boolean j = false;
        Label_0096: {
            if (!text.equals(this.m)) {
                j = true;
                this.l = true;
                try {
                    ((TextView)this).setText(text);
                    break Label_0096;
                }
                finally {
                    this.l = false;
                }
            }
            j = false;
        }
        this.k = false;
        this.j = j;
    }
    
    protected void onDraw(final Canvas canvas) {
        if (this.o && this.k) {
            this.u();
        }
        super.onDraw(canvas);
    }
    
    public void setText(final CharSequence m, final TextView$BufferType textView$BufferType) {
        if (!this.l) {
            String string;
            if ((this.m = m) != null) {
                string = m.toString();
            }
            else {
                string = null;
            }
            this.n = string;
            this.k = true;
        }
        super.setText(m, textView$BufferType);
    }
    
    public void setUseFilenameEllipsize(final boolean o) {
        this.o = o;
    }
    
    private class b
    {
        final GridFilenameTextView a;
        
        private b(final GridFilenameTextView a) {
            this.a = a;
        }
        
        protected CharSequence a(final CharSequence charSequence, String s) {
            final Layout b = this.b(charSequence);
            final int lastIndex = s.lastIndexOf(46);
            if (lastIndex < 0) {
                return charSequence;
            }
            final int lineEnd = b.getLineEnd(((TextView)this.a).getMaxLines() - 1);
            final int length = charSequence.length();
            int length2;
            if ((length2 = length - lineEnd + 1) < this.a.h.length()) {
                length2 = this.a.h.length();
            }
            s = d0.f(s);
            if (!TextUtils.isEmpty((CharSequence)s)) {
                final int n = length - (length2 + s.length());
                if (n >= 0) {
                    s = TextUtils.substring(charSequence, 0, n).trim();
                    final String trim = TextUtils.substring(charSequence, lastIndex + 1, length).trim();
                    while (true) {
                        final CharSequence concat = TextUtils.concat(new CharSequence[] { (CharSequence)s, (CharSequence)this.a.h, (CharSequence)trim });
                        if (this.c(concat)) {
                            if (charSequence instanceof Spanned) {
                                final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)s);
                                final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder((CharSequence)trim);
                                final Spanned spanned = (Spanned)charSequence;
                                TextUtils.copySpansFrom(spanned, 0, s.length(), (Class)null, (Spannable)spannableStringBuilder, 0);
                                TextUtils.copySpansFrom(spanned, length - trim.length(), length, (Class)null, (Spannable)spannableStringBuilder2, 0);
                                return TextUtils.concat(new CharSequence[] { (CharSequence)spannableStringBuilder, (CharSequence)this.a.h, (CharSequence)spannableStringBuilder2 });
                            }
                            return concat;
                        }
                        else {
                            final int length3 = s.length();
                            if (length3 == 0) {
                                break;
                            }
                            s = s.substring(0, length3 - 1).trim();
                        }
                    }
                }
            }
            return charSequence;
        }
        
        protected Layout b(final CharSequence charSequence) {
            return (Layout)new StaticLayout(charSequence, ((TextView)this.a).getPaint(), ((View)this.a).getWidth() - ((TextView)this.a).getCompoundPaddingLeft() - ((TextView)this.a).getCompoundPaddingRight(), Layout$Alignment.ALIGN_NORMAL, ((TextView)this.a).getLineSpacingMultiplier(), ((TextView)this.a).getLineSpacingExtra(), false);
        }
        
        public boolean c(final CharSequence charSequence) {
            return this.b(charSequence).getLineCount() <= ((TextView)this.a).getMaxLines();
        }
        
        public CharSequence d(final CharSequence charSequence, final String s) {
            CharSequence a = charSequence;
            if (!this.c(charSequence)) {
                a = this.a(charSequence, s);
            }
            return a;
        }
    }
}
