package y3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends f {
    public b(s3.a aVar) {
        super(aVar);
    }

    @Override // y3.i
    public void h(StringBuilder sb2, int i10) {
        if (i10 < 10000) {
            sb2.append("(3202)");
        } else {
            sb2.append("(3203)");
        }
    }

    @Override // y3.i
    public int i(int i10) {
        return i10 < 10000 ? i10 : i10 - 10000;
    }
}
