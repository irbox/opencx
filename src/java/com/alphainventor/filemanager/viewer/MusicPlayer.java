package com.alphainventor.filemanager.viewer;

import android.app.Activity;
import ax.Ha.b;
import android.content.Context;
import android.widget.Toast;
import android.os.Bundle;
import ax.n.c;

public class MusicPlayer extends c
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final b b = ax.Ha.c.h().f().b("MUSIC PLAYER ACTIVITY LAUNCHED");
        final StringBuilder sb = new StringBuilder();
        sb.append("data : ");
        sb.append((Object)((Activity)this).getIntent().getData());
        b.g((Object)sb.toString()).h();
        Toast.makeText((Context)this, 2131951927, 1).show();
        ((Activity)this).finish();
    }
}
