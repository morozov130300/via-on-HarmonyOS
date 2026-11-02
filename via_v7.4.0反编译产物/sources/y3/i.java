package y3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i extends h {
    public i(s3.a aVar) {
        super(aVar);
    }

    public abstract void h(StringBuilder sb2, int i10);

    public abstract int i(int i10);

    public final void j(StringBuilder sb2, int i10, int i11) {
        int iF = b().f(i10, i11);
        h(sb2, iF);
        int i12 = i(iF);
        int i13 = 100000;
        for (int i14 = 0; i14 < 5; i14++) {
            if (i12 / i13 == 0) {
                sb2.append('0');
            }
            i13 /= 10;
        }
        sb2.append(i12);
    }
}
