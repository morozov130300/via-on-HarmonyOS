package b0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class g {
    public static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                d.a(autoCloseable);
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static String b(Context context, Uri uri) {
        return c(context, uri, "_display_name", null);
    }

    public static String c(Context context, Uri uri, String str, String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uri, new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst() || cursorQuery.isNull(0)) {
                    a(cursorQuery);
                    return str2;
                }
                String string = cursorQuery.getString(0);
                a(cursorQuery);
                return string;
            } catch (Exception e10) {
                Log.w("DocumentFile", "Failed query: " + e10);
                a(cursorQuery);
                return str2;
            }
        } catch (Throwable th) {
            a(cursorQuery);
            throw th;
        }
    }
}
