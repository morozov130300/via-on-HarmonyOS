package k5;

import android.content.Context;
import android.net.Uri;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u implements o {

    /* renamed from: a, reason: collision with root package name */
    public Context f8136a;

    public u(Context context) {
        this.f8136a = context.getApplicationContext();
    }

    @Override // k5.o
    public c a(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("File uri can not be null or empty");
        }
        Uri uri = Uri.parse(str);
        if (uri == null || uri.getPath() == null) {
            throw new IllegalArgumentException("Invalid uri string");
        }
        return n.e(this.f8136a.getContentResolver(), uri);
    }
}
