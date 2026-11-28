package c0;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f1904a;

    public c(c cVar) {
        this.f1904a = cVar;
    }

    public static c c(Context context, Uri uri) {
        return new h(null, context, uri);
    }

    public static c d(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new k(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
        }
        return null;
    }

    public abstract c a(String str, String str2);

    public abstract boolean b();

    public abstract String e();

    public abstract Uri f();

    public abstract boolean g(String str);
}
