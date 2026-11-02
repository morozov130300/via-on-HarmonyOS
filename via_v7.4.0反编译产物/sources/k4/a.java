package k4;

import android.text.TextUtils;
import com.thegrizzlylabs.sardineandroid.model.Allprop;
import com.thegrizzlylabs.sardineandroid.model.Prop;
import com.thegrizzlylabs.sardineandroid.model.Propfind;
import j4.b;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import l4.e;
import l4.g;
import m4.d;
import okhttp3.q;
import okhttp3.t;
import okhttp3.u;
import okhttp3.w;
import okhttp3.x;
import org.w3c.dom.Element;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public u f8128a;

    public a(u uVar) {
        this.f8128a = uVar;
    }

    @Override // j4.b
    public void a(String str) {
        h(new w.a().j(str).f("MKCOL", null).b());
    }

    @Override // j4.b
    public void b(String str, File file, String str2) {
        o(str, file, str2, false);
    }

    @Override // j4.b
    public boolean c(String str) {
        return ((Boolean) g(new w.a().j(str).f("HEAD", null).b(), new l4.a())).booleanValue();
    }

    @Override // j4.b
    public List d(String str) {
        return k(str, 1);
    }

    public final void e(Prop prop, Set set) {
        List<Element> any = prop.getAny();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            any.add(d.b((QName) it.next()));
        }
    }

    public final void f(q.a aVar, String str, String str2) {
        aVar.a("If", "<" + str + "> (<" + str2 + ">)");
    }

    public final Object g(w wVar, e eVar) {
        return eVar.a(this.f8128a.v(wVar).f());
    }

    @Override // j4.b
    public InputStream get(String str) {
        return i(str, Collections.EMPTY_MAP);
    }

    public final void h(w wVar) {
        g(wVar, new g());
    }

    public InputStream i(String str, Map map) {
        return j(str, q.h(map));
    }

    public InputStream j(String str, q qVar) {
        return (InputStream) g(new w.a().j(str).c().e(qVar).b(), new l4.b());
    }

    public List k(String str, int i10) {
        return m(str, i10, true);
    }

    public List l(String str, int i10, Set set) {
        Propfind propfind = new Propfind();
        Prop prop = new Prop();
        e(prop, set);
        propfind.setProp(prop);
        return n(str, i10, propfind);
    }

    public List m(String str, int i10, boolean z10) {
        if (!z10) {
            return l(str, i10, Collections.EMPTY_SET);
        }
        Propfind propfind = new Propfind();
        propfind.setAllprop(new Allprop());
        return n(str, i10, propfind);
    }

    public List n(String str, int i10, Propfind propfind) {
        return (List) g(new w.a().j(str).d("Depth", i10 < 0 ? "infinity" : Integer.toString(i10)).f("PROPFIND", x.d(t.d("text/xml"), d.g(propfind))).b(), new l4.d());
    }

    public void o(String str, File file, String str2, boolean z10) {
        p(str, file, str2, z10, null);
    }

    public void p(String str, File file, String str2, boolean z10, String str3) {
        x xVarC = x.c(str2 == null ? null : t.d(str2), file);
        q.a aVar = new q.a();
        if (z10) {
            aVar.a("Expect", "100-Continue");
        }
        if (!TextUtils.isEmpty(str3)) {
            f(aVar, str, str3);
        }
        q(str, xVarC, aVar.d());
    }

    public final void q(String str, x xVar, q qVar) {
        h(new w.a().j(str).h(xVar).e(qVar).b());
    }
}
