package b0;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h extends c {

    /* renamed from: b, reason: collision with root package name */
    public Context f1775b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f1776c;

    public h(c cVar, Context context, Uri uri) {
        super(cVar);
        this.f1775b = context;
        this.f1776c = uri;
    }

    @Override // b0.c
    public c a(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // b0.c
    public boolean b() {
        try {
            return DocumentsContract.deleteDocument(this.f1775b.getContentResolver(), this.f1776c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // b0.c
    public String e() {
        return g.b(this.f1775b, this.f1776c);
    }

    @Override // b0.c
    public Uri f() {
        return this.f1776c;
    }

    @Override // b0.c
    public boolean g(String str) {
        throw new UnsupportedOperationException();
    }
}
