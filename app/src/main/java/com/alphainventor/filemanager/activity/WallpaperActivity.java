package com.alphainventor.filemanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import android.content.Context;
import android.app.WallpaperManager;
import android.os.Bundle;
import ax.n.c;

public class WallpaperActivity extends c
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = ((Activity)this).getIntent();
        try {
            final WallpaperManager instance = WallpaperManager.getInstance((Context)this);
            if (instance != null && intent.getData() != null) {
                ((Context)this).startActivity(instance.getCropAndSetWallpaperIntent(intent.getData()));
            }
            else {
                Toast.makeText((Context)this, 2131951927, 1).show();
            }
        }
        catch (final Exception ex) {
            Toast.makeText((Context)this, 2131951927, 1).show();
        }
        ((Activity)this).finish();
    }
}
