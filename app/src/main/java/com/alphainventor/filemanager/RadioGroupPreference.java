package com.alphainventor.filemanager;

import androidx.preference.h;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.RadioGroup;
import androidx.preference.Preference;

public class RadioGroupPreference extends Preference
{
    private RadioGroup R0;
    private RadioGroupPreference.RadioGroupPreference$a S0;
    
    public RadioGroupPreference(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public RadioGroup T0() {
        return this.R0;
    }
    
    public void U0(final RadioGroupPreference.RadioGroupPreference$a s0) {
        this.S0 = s0;
    }
    
    public void c0(final h h) {
        super.c0(h);
        this.R0 = (RadioGroup)h.N(2131362725);
        final RadioGroupPreference.RadioGroupPreference$a s0 = this.S0;
        if (s0 != null) {
            s0.a(h);
        }
    }
}
