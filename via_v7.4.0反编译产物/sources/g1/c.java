package g1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f6122c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    public final String f6123a;

    /* renamed from: b, reason: collision with root package name */
    public final List f6124b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f6125a = "";

        /* renamed from: b, reason: collision with root package name */
        public List f6126b = new ArrayList();

        public c a() {
            return new c(this.f6125a, Collections.unmodifiableList(this.f6126b));
        }

        public a b(List list) {
            this.f6126b = list;
            return this;
        }

        public a c(String str) {
            this.f6125a = str;
            return this;
        }
    }

    public c(String str, List list) {
        this.f6123a = str;
        this.f6124b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f6124b;
    }

    public String b() {
        return this.f6123a;
    }
}
