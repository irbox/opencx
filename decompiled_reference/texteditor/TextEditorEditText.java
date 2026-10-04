package com.alphainventor.filemanager.texteditor;

import android.widget.TextView;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.EditorInfo;
import android.util.AttributeSet;
import android.content.Context;
import androidx.appcompat.widget.l;

public class TextEditorEditText extends l
{
    public TextEditorEditText(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public int getAutofillType() {
        return 0;
    }
    
    public InputConnection onCreateInputConnection(final EditorInfo editorInfo) {
        return (InputConnection)new a(super.onCreateInputConnection(editorInfo), true);
    }
    
    class a extends InputConnectionWrapper
    {
        final TextEditorEditText a;
        
        public a(final TextEditorEditText a, final InputConnection inputConnection, final boolean b) {
            this.a = a;
            super(inputConnection, b);
        }
        
        public boolean deleteSurroundingText(final int n, final int n2) {
            if (n == 1 && n2 == 0 && ((TextView)this.a).getSelectionStart() == 0) {
                return this.sendKeyEvent(new KeyEvent(0, 67)) && this.sendKeyEvent(new KeyEvent(1, 67));
            }
            if (n == 0 && n2 == 1 && ((TextView)this.a).getSelectionStart() == ((TextView)this.a).length()) {
                return this.sendKeyEvent(new KeyEvent(0, 112)) && this.sendKeyEvent(new KeyEvent(1, 112));
            }
            return super.deleteSurroundingText(n, n2);
        }
    }
}
