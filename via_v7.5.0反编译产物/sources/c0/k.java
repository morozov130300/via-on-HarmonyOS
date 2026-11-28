package c0;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f1908c;

    public k(c cVar, Context context, Uri uri) {
        super(cVar);
        this.f1907b = context;
        this.f1908c = uri;
    }

    public static Uri h(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // c0.c
    public c a(String str, String str2) {
        Uri uriH = h(this.f1907b, this.f1908c, str, str2);
        if (uriH != null) {
            return new k(this, this.f1907b, uriH);
        }
        return null;
    }

    @Override // c0.c
    public boolean b() {
        try {
            return DocumentsContract.deleteDocument(this.f1907b.getContentResolver(), this.f1908c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // c0.c
    public String e() {
        return g.b(this.f1907b, this.f1908c);
    }

    @Override // c0.c
    public Uri f() {
        return this.f1908c;
    }

    @Override // c0.c
    public boolean g(String str) {
        try {
            Uri uriRenameDocument = DocumentsContract.renameDocument(this.f1907b.getContentResolver(), this.f1908c, str);
            if (uriRenameDocument != null) {
                this.f1908c = uriRenameDocument;
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
