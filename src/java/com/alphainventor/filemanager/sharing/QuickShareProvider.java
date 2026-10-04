package com.alphainventor.filemanager.sharing;

import android.database.Cursor;
import ax.Q2.b;
import android.content.ContentValues;
import android.net.Uri;
import java.util.Collection;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import ax.X2.Q;
import android.content.Context;
import java.util.ArrayList;
import com.alphainventor.filemanager.file.n;
import java.util.List;
import android.content.ContentProvider;

public class QuickShareProvider extends ContentProvider
{
    public static final String[] c;
    private static QuickShareProvider d;
    private static Boolean e;
    private final List<n> a;
    private n b;
    
    static {
        c = new String[] { "file_uri", "file_dir", "file_mime_type" };
    }
    
    public QuickShareProvider() {
        this.a = (List<n>)new ArrayList();
    }
    
    public static boolean a(final Context context) {
        if (context == null) {
            return false;
        }
        if (QuickShareProvider.e == null) {
            if (Q.u1()) {
                Label_0098: {
                    try {
                        final List queryIntentActivities = context.getPackageManager().queryIntentActivities(b(1), 65536);
                        if (queryIntentActivities.isEmpty()) {
                            break Label_0098;
                        }
                        final ActivityInfo activityInfo = ((ResolveInfo)queryIntentActivities.get(0)).activityInfo;
                        if (activityInfo == null) {
                            break Label_0098;
                        }
                        if (!"com.google.android.gms.nearby.sharing.send.SendActivity".equals((Object)activityInfo.name)) {
                            if (!"com.google.android.gms.nearby.sharing.main.MainActivity".equals((Object)activityInfo.name)) {
                                break Label_0098;
                            }
                        }
                    }
                    catch (final Exception ex) {
                        break Label_0098;
                    }
                    QuickShareProvider.e = Boolean.TRUE;
                }
                if (QuickShareProvider.e == null) {
                    QuickShareProvider.e = Boolean.FALSE;
                }
            }
            else {
                QuickShareProvider.e = Boolean.FALSE;
            }
        }
        return QuickShareProvider.e;
    }
    
    private static Intent b(final int n) {
        final Intent intent = new Intent();
        intent.setAction("com.google.android.gms.nearby.SEND_FOLDER");
        intent.putExtra("com.google.android.gms.nearby.SEND_FOLDER_CONTENT_URI", "content://com.cxinventor.file.explorer.foldershare.provider");
        intent.putExtra("com.google.android.gms.nearby.FILE_COUNT", n);
        intent.setPackage("com.google.android.gms");
        return intent;
    }
    
    public static QuickShareProvider c() {
        return QuickShareProvider.d;
    }
    
    public void d(final Context context, final n b, final List<n> list) {
        final List<n> a = this.a;
        synchronized (a) {
            this.b = b;
            this.a.clear();
            this.a.addAll((Collection)list);
            monitorexit(a);
            final Intent b2 = b(list.size());
            context.grantUriPermission("com.google.android.gms", Uri.parse("content://com.cxinventor.file.explorer.foldershare.provider"), 1);
            context.startActivity(b2);
        }
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        return 0;
    }
    
    public String getType(final Uri uri) {
        throw new UnsupportedOperationException("Operation not supported.");
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        return null;
    }
    
    public boolean onCreate() {
        ax.Q2.b.k(this.getContext());
        QuickShareProvider.d = this;
        return true;
    }
    
    public Cursor query(final Uri p0, final String[] p1, final String p2, final String[] p3, final String p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   android/content/ContentProvider.getCallingPackage:()Ljava/lang/String;
        //     4: astore_1       
        //     5: aload_1        
        //     6: ifnull          285
        //     9: aload_1        
        //    10: ldc             "com.google.android.gms"
        //    12: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    15: ifeq            285
        //    18: new             Landroid/database/MatrixCursor;
        //    21: dup            
        //    22: getstatic       com/alphainventor/filemanager/sharing/QuickShareProvider.c:[Ljava/lang/String;
        //    25: invokespecial   android/database/MatrixCursor.<init>:([Ljava/lang/String;)V
        //    28: astore_3       
        //    29: aload_0        
        //    30: getfield        com/alphainventor/filemanager/sharing/QuickShareProvider.a:Ljava/util/List;
        //    33: astore_1       
        //    34: aload_1        
        //    35: dup            
        //    36: astore          8
        //    38: monitorenter   
        //    39: aload_0        
        //    40: getfield        com/alphainventor/filemanager/sharing/QuickShareProvider.b:Lcom/alphainventor/filemanager/file/n;
        //    43: ifnull          275
        //    46: aload_0        
        //    47: getfield        com/alphainventor/filemanager/sharing/QuickShareProvider.a:Ljava/util/List;
        //    50: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    55: astore          4
        //    57: aload           4
        //    59: invokeinterface java/util/Iterator.hasNext:()Z
        //    64: ifeq            275
        //    67: aload           4
        //    69: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    74: checkcast       Lcom/alphainventor/filemanager/file/n;
        //    77: astore_2       
        //    78: aload_2        
        //    79: instanceof      Lax/c3/k;
        //    82: ifeq            228
        //    85: aload_2        
        //    86: checkcast       Lax/c3/k;
        //    89: astore          7
        //    91: aload           7
        //    93: invokestatic    ax/c3/u.v:(Lax/c3/k;)Landroid/net/Uri;
        //    96: astore          5
        //    98: aload_0        
        //    99: invokevirtual   android/content/ContentProvider.getContext:()Landroid/content/Context;
        //   102: ldc             "com.google.android.gms"
        //   104: aload           5
        //   106: iconst_1       
        //   107: invokevirtual   android/content/Context.grantUriPermission:(Ljava/lang/String;Landroid/net/Uri;I)V
        //   110: goto            117
        //   113: astore_2       
        //   114: goto            280
        //   117: aload           7
        //   119: invokevirtual   com/alphainventor/filemanager/file/n.T:()Ljava/lang/String;
        //   122: astore          7
        //   124: aload_0        
        //   125: getfield        com/alphainventor/filemanager/sharing/QuickShareProvider.b:Lcom/alphainventor/filemanager/file/n;
        //   128: invokevirtual   com/alphainventor/filemanager/file/n.E:()Ljava/lang/String;
        //   131: astore          6
        //   133: aload           6
        //   135: aload           7
        //   137: invokestatic    ax/c3/d0.I:(Ljava/lang/String;Ljava/lang/String;)Z
        //   140: ifeq            185
        //   143: aload           6
        //   145: aload           7
        //   147: invokestatic    ax/c3/d0.n:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   150: astore          6
        //   152: aload_3        
        //   153: iconst_3       
        //   154: anewarray       Ljava/lang/String;
        //   157: dup            
        //   158: iconst_0       
        //   159: aload           5
        //   161: invokevirtual   android/net/Uri.toString:()Ljava/lang/String;
        //   164: aastore        
        //   165: dup            
        //   166: iconst_1       
        //   167: aload           6
        //   169: aastore        
        //   170: dup            
        //   171: iconst_2       
        //   172: aload_2        
        //   173: invokeinterface ax/c3/b.s:()Ljava/lang/String;
        //   178: aastore        
        //   179: invokevirtual   android/database/MatrixCursor.addRow:([Ljava/lang/Object;)V
        //   182: goto            57
        //   185: aload           6
        //   187: aload           7
        //   189: invokestatic    ax/c3/d0.G:(Ljava/lang/String;Ljava/lang/String;)Z
        //   192: ifeq            57
        //   195: aload_3        
        //   196: iconst_3       
        //   197: anewarray       Ljava/lang/String;
        //   200: dup            
        //   201: iconst_0       
        //   202: aload           5
        //   204: invokevirtual   android/net/Uri.toString:()Ljava/lang/String;
        //   207: aastore        
        //   208: dup            
        //   209: iconst_1       
        //   210: ldc             ""
        //   212: aastore        
        //   213: dup            
        //   214: iconst_2       
        //   215: aload_2        
        //   216: invokeinterface ax/c3/b.s:()Ljava/lang/String;
        //   221: aastore        
        //   222: invokevirtual   android/database/MatrixCursor.addRow:([Ljava/lang/Object;)V
        //   225: goto            57
        //   228: aload_2        
        //   229: ifnull          57
        //   232: new             Ljava/lang/StringBuilder;
        //   235: astore          5
        //   237: aload           5
        //   239: invokespecial   java/lang/StringBuilder.<init>:()V
        //   242: aload           5
        //   244: ldc_w           "Invalid file info class:"
        //   247: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   250: pop            
        //   251: aload           5
        //   253: aload_2        
        //   254: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   257: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   260: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   263: pop            
        //   264: aload           5
        //   266: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   269: invokestatic    ax/u3/b.g:(Ljava/lang/String;)V
        //   272: goto            57
        //   275: aload           8
        //   277: monitorexit    
        //   278: aload_3        
        //   279: areturn        
        //   280: aload           8
        //   282: monitorexit    
        //   283: aload_2        
        //   284: athrow         
        //   285: aconst_null    
        //   286: areturn        
        //   287: astore          6
        //   289: goto            117
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  39     57     113    285    Any
        //  57     98     113    285    Any
        //  98     110    287    292    Ljava/lang/Exception;
        //  98     110    113    285    Any
        //  117    182    113    285    Any
        //  185    225    113    285    Any
        //  232    272    113    285    Any
        //  275    278    113    285    Any
        //  280    283    113    285    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0117:
        //     at q5.p.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:150)
        //     at q5.p.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:470)
        //     at u5.m.d(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:30)
        //     at u5.i.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:23)
        //     at u5.i.f(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:159)
        //     at u5.i.j(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:619)
        //     at u5.i.k(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:13)
        //     at u5.i.i(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:29)
        //     at s5.b.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:90)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:367)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:162)
        //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
        //     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
        //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1100)
        //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        //     at java.lang.Thread.run(Thread.java:1571)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        return 0;
    }
}
