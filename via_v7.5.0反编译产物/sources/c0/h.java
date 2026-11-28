package c0;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f1906c;

    public h(c cVar, Context context, Uri uri) {
        super(cVar);
        this.f1905b = context;
        this.f1906c = uri;
    }

    @Override // c0.c
    public c a(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // c0.c
    public boolean b() {
        try {
            return DocumentsContract.deleteDocument(this.f1905b.getContentResolver(), this.f1906c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // c0.c
    public String e() {
        return g.b(this.f1905b, this.f1906c);
    }

    @Override // c0.c
    public Uri f() {
        return this.f1906c;
    }

    @Override // c0.c
    public boolean g(String str) {
        throw new UnsupportedOperationException();
    }
}
