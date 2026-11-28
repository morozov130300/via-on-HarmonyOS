package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Iterator {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f7345p = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f7346c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7347e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7349n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7350o;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public a() {
        }
    }

    public f(CharSequence string) {
        kotlin.jvm.internal.h.f(string, "string");
        this.f7346c = string;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f7347e = 0;
        int i10 = this.f7349n;
        int i11 = this.f7348m;
        this.f7348m = this.f7350o + i10;
        return this.f7346c.subSequence(i11, i10).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i10;
        int i11;
        int i12 = this.f7347e;
        if (i12 != 0) {
            return i12 == 1;
        }
        if (this.f7350o < 0) {
            this.f7347e = 2;
            return false;
        }
        int length = this.f7346c.length();
        int length2 = this.f7346c.length();
        for (int i13 = this.f7348m; i13 < length2; i13++) {
            char cCharAt = this.f7346c.charAt(i13);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i10 = (cCharAt == '\r' && (i11 = i13 + 1) < this.f7346c.length() && this.f7346c.charAt(i11) == '\n') ? 2 : 1;
                length = i13;
                this.f7347e = 1;
                this.f7350o = i10;
                this.f7349n = length;
                return true;
            }
        }
        i10 = -1;
        this.f7347e = 1;
        this.f7350o = i10;
        this.f7349n = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
