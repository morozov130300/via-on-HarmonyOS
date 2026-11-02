package u3;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final a f12815a;

    /* renamed from: b, reason: collision with root package name */
    public final List f12816b;

    public d(a aVar) {
        this.f12815a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f12816b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    public final b a(int i10) {
        if (i10 >= this.f12816b.size()) {
            List list = this.f12816b;
            b bVarI = (b) list.get(list.size() - 1);
            for (int size = this.f12816b.size(); size <= i10; size++) {
                a aVar = this.f12815a;
                bVarI = bVarI.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f12816b.add(bVarI);
            }
        }
        return (b) this.f12816b.get(i10);
    }

    public void b(int[] iArr, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i10;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b bVarA = a(i10);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrE = new b(this.f12815a, iArr2).j(i10, 1).b(bVarA)[1].e();
        int length2 = i10 - iArrE.length;
        for (int i11 = 0; i11 < length2; i11++) {
            iArr[length + i11] = 0;
        }
        System.arraycopy(iArrE, 0, iArr, length + length2, iArrE.length);
    }
}
