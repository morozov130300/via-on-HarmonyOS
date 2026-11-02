package b0;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.io.FileNotFoundException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends c {

    /* renamed from: b, reason: collision with root package name */
    public Context f1777b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f1778c;

    public k(c cVar, Context context, Uri uri) {
        super(cVar);
        this.f1777b = context;
        this.f1778c = uri;
    }

    public static Uri h(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // b0.c
    public c a(String str, String str2) {
        Uri uriH = h(this.f1777b, this.f1778c, str, str2);
        if (uriH != null) {
            return new k(this, this.f1777b, uriH);
        }
        return null;
    }

    @Override // b0.c
    public boolean b() {
        try {
            return DocumentsContract.deleteDocument(this.f1777b.getContentResolver(), this.f1778c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // b0.c
    public String e() {
        return g.b(this.f1777b, this.f1778c);
    }

    @Override // b0.c
    public Uri f() {
        return this.f1778c;
    }

    @Override // b0.c
    public boolean g(String str) throws FileNotFoundException {
        try {
            Uri uriRenameDocument = DocumentsContract.renameDocument(this.f1777b.getContentResolver(), this.f1778c, str);
            if (uriRenameDocument != null) {
                this.f1778c = uriRenameDocument;
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
