package r0;

import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: c, reason: collision with root package name */
    public static final Set f11476c = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final String f11477a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11478b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends l {
        public a(String str, String str2) {
            super(str, str2);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends l {
        public b(String str, String str2) {
            super(str, str2);
        }
    }

    public l(String str, String str2) {
        this.f11477a = str;
        this.f11478b = str2;
        f11476c.add(this);
    }
}
