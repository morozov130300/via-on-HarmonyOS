package k6;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import k6.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h extends e {

    /* renamed from: a, reason: collision with root package name */
    public final TextView.BufferType f8155a;

    /* renamed from: b, reason: collision with root package name */
    public final lc.d f8156b;

    /* renamed from: c, reason: collision with root package name */
    public final m f8157c;

    /* renamed from: d, reason: collision with root package name */
    public final g f8158d;

    /* renamed from: e, reason: collision with root package name */
    public final List f8159e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8160f;

    public h(TextView.BufferType bufferType, e.b bVar, lc.d dVar, m mVar, g gVar, List list, boolean z10) {
        this.f8155a = bufferType;
        this.f8156b = dVar;
        this.f8157c = mVar;
        this.f8158d = gVar;
        this.f8159e = list;
        this.f8160f = z10;
    }

    @Override // k6.e
    public Spanned b(String str) {
        Spanned spannedD = d(c(str));
        return (TextUtils.isEmpty(spannedD) && this.f8160f && !TextUtils.isEmpty(str)) ? new SpannableStringBuilder(str) : spannedD;
    }

    public kc.t c(String str) {
        Iterator it = this.f8159e.iterator();
        while (it.hasNext()) {
            str = ((i) it.next()).a(str);
        }
        return this.f8156b.b(str);
    }

    public Spanned d(kc.t tVar) {
        Iterator it = this.f8159e.iterator();
        while (it.hasNext()) {
            ((i) it.next()).e(tVar);
        }
        l lVarA = this.f8157c.a();
        tVar.a(lVarA);
        Iterator it2 = this.f8159e.iterator();
        while (it2.hasNext()) {
            ((i) it2.next()).d(tVar, lVarA);
        }
        return lVarA.builder().m();
    }
}
