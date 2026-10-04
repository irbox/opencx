package com.alphainventor.filemanager.receiver;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class BootReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        StorageCheckReceiver.b(context, true);
    }
}
