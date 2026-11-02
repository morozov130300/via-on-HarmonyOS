package x5;

import java.util.NoSuchElementException;
import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f13610b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Object f13611a;

    public a() {
        this.f13611a = null;
    }

    public a(Object obj) {
        Objects.requireNonNull(obj);
        this.f13611a = obj;
    }

    public static a a() {
        return f13610b;
    }

    public static a e(Object obj) {
        return new a(obj);
    }

    public static a f(Object obj) {
        return obj == null ? a() : e(obj);
    }

    public Object b() {
        Object obj = this.f13611a;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public Object c() {
        return this.f13611a;
    }

    public boolean d() {
        return this.f13611a != null;
    }
}
