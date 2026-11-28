package s5;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12209b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12210a;

    public a() {
        this.f12210a = null;
    }

    public static a a() {
        return f12209b;
    }

    public static a e(Object obj) {
        return new a(obj);
    }

    public static a f(Object obj) {
        return obj == null ? a() : e(obj);
    }

    public Object b() {
        Object obj = this.f12210a;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public Object c() {
        return this.f12210a;
    }

    public boolean d() {
        return this.f12210a != null;
    }

    public a(Object obj) {
        Objects.requireNonNull(obj);
        this.f12210a = obj;
    }
}
