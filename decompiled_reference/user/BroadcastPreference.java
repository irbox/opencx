package com.alphainventor.filemanager.user;

import android.util.AttributeSet;
import android.content.Context;
import android.preference.Preference$OnPreferenceClickListener;
import android.preference.Preference;

public class BroadcastPreference extends Preference implements Preference$OnPreferenceClickListener
{
    public BroadcastPreference(final Context context, final AttributeSet set) {
        super(context, set);
        this.setOnPreferenceClickListener((Preference$OnPreferenceClickListener)this);
    }
    
    public boolean onPreferenceClick(final Preference preference) {
        this.getContext().sendBroadcast(this.getIntent());
        return true;
    }
}
