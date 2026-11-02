package t1;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f12049a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12050b;

    public h(Context context) {
        f.h(context);
        Resources resources = context.getResources();
        this.f12049a = resources;
        this.f12050b = resources.getResourcePackageName(q1.i.f11252a);
    }

    public String a(String str) {
        int identifier = this.f12049a.getIdentifier(str, "string", this.f12050b);
        if (identifier == 0) {
            return null;
        }
        return this.f12049a.getString(identifier);
    }
}
