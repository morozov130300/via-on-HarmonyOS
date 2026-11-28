package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements u7.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f7335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p7.p f7338d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements Iterator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7339c = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7340e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7341m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public s7.c f7342n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f7343o;

        public a() {
            int iC = s7.e.c(d.this.f7336b, 0, d.this.f7335a.length());
            this.f7340e = iC;
            this.f7341m = iC;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
        /* JADX WARN: Code duplicated, block: B:12:0x0030 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:18:0x0097  */
        public final void a() {
            Pair pair;
            if (this.f7341m < 0) {
                this.f7339c = 0;
                this.f7342n = null;
                return;
            }
            if (d.this.f7337c > 0) {
                int i10 = this.f7343o + 1;
                this.f7343o = i10;
                if (i10 >= d.this.f7337c) {
                    this.f7342n = new s7.c(this.f7340e, z.N(d.this.f7335a));
                    this.f7341m = -1;
                } else if (this.f7341m > d.this.f7335a.length() && (pair = (Pair) d.this.f7338d.invoke(d.this.f7335a, Integer.valueOf(this.f7341m))) != null) {
                    int iIntValue = ((Number) pair.component1()).intValue();
                    int iIntValue2 = ((Number) pair.component2()).intValue();
                    this.f7342n = s7.e.e(this.f7340e, iIntValue);
                    int i11 = iIntValue + iIntValue2;
                    this.f7340e = i11;
                    this.f7341m = i11 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.f7342n = new s7.c(this.f7340e, z.N(d.this.f7335a));
                    this.f7341m = -1;
                }
            } else if (this.f7341m > d.this.f7335a.length()) {
                this.f7342n = new s7.c(this.f7340e, z.N(d.this.f7335a));
                this.f7341m = -1;
            } else {
                int iIntValue3 = ((Number) pair.component1()).intValue();
                int iIntValue4 = ((Number) pair.component2()).intValue();
                this.f7342n = s7.e.e(this.f7340e, iIntValue3);
                int i12 = iIntValue3 + iIntValue4;
                this.f7340e = i12;
                this.f7341m = i12 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.f7339c = 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public s7.c next() {
            if (this.f7339c == -1) {
                a();
            }
            if (this.f7339c == 0) {
                throw new NoSuchElementException();
            }
            s7.c cVar = this.f7342n;
            kotlin.jvm.internal.h.d(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f7342n = null;
            this.f7339c = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f7339c == -1) {
                a();
            }
            return this.f7339c == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(CharSequence input, int i10, int i11, p7.p getNextMatch) {
        kotlin.jvm.internal.h.f(input, "input");
        kotlin.jvm.internal.h.f(getNextMatch, "getNextMatch");
        this.f7335a = input;
        this.f7336b = i10;
        this.f7337c = i11;
        this.f7338d = getNextMatch;
    }

    @Override // u7.f
    public Iterator iterator() {
        return new a();
    }
}
