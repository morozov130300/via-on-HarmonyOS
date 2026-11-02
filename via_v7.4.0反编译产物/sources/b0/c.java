package b0;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final c f1774a;

    public c(c cVar) {
        this.f1774a = cVar;
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
