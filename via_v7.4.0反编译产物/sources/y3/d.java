package y3;

import com.google.zxing.NotFoundException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends h {
    public d(s3.a aVar) {
        super(aVar);
    }

    @Override // y3.j
    public String d() throws NotFoundException {
        if (c().n() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 8);
        int iF = b().f(48, 2);
        sb2.append("(393");
        sb2.append(iF);
        sb2.append(')');
        int iF2 = b().f(50, 10);
        if (iF2 / 100 == 0) {
            sb2.append('0');
        }
        if (iF2 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(iF2);
        sb2.append(b().c(60, null).b());
        return sb2.toString();
    }
}
