package e6;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView.BufferType f4239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pc.d f4240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f4241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f4242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f4243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4244f;

    public h(TextView.BufferType bufferType, e.b bVar, pc.d dVar, m mVar, g gVar, List list, boolean z10) {
        this.f4239a = bufferType;
        this.f4240b = dVar;
        this.f4241c = mVar;
        this.f4242d = gVar;
        this.f4243e = list;
        this.f4244f = z10;
    }

    @Override // e6.e
    public Spanned b(String str) {
        Spanned spannedD = d(c(str));
        return (TextUtils.isEmpty(spannedD) && this.f4244f && !TextUtils.isEmpty(str)) ? new SpannableStringBuilder(str) : spannedD;
    }

    public oc.t c(String str) {
        Iterator it = this.f4243e.iterator();
        while (it.hasNext()) {
            str = ((i) it.next()).c(str);
        }
        return this.f4240b.b(str);
    }

    public Spanned d(oc.t tVar) {
        Iterator it = this.f4243e.iterator();
        while (it.hasNext()) {
            ((i) it.next()).a(tVar);
        }
        l lVarA = this.f4241c.a();
        tVar.a(lVarA);
        Iterator it2 = this.f4243e.iterator();
        while (it2.hasNext()) {
            ((i) it2.next()).b(tVar, lVarA);
        }
        return lVarA.builder().m();
    }
}
