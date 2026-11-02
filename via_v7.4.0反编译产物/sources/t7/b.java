package t7;

import java.util.NoSuchElementException;
import k7.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends v {

    /* renamed from: e, reason: collision with root package name */
    public final int f12277e;

    /* renamed from: j, reason: collision with root package name */
    public final int f12278j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12279k;

    /* renamed from: l, reason: collision with root package name */
    public int f12280l;

    public b(int i10, int i11, int i12) {
        this.f12277e = i12;
        this.f12278j = i11;
        boolean z10 = false;
        if (i12 <= 0 ? i10 >= i11 : i10 <= i11) {
            z10 = true;
        }
        this.f12279k = z10;
        this.f12280l = z10 ? i10 : i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12279k;
    }

    @Override // k7.v
    public int nextInt() {
        int i10 = this.f12280l;
        if (i10 != this.f12278j) {
            this.f12280l = this.f12277e + i10;
            return i10;
        }
        if (!this.f12279k) {
            throw new NoSuchElementException();
        }
        this.f12279k = false;
        return i10;
    }
}
