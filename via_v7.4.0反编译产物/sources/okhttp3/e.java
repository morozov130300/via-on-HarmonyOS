package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f10562c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    public final Set f10563a;

    /* renamed from: b, reason: collision with root package name */
    public final cc.c f10564b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f10565a = new ArrayList();

        public e a() {
            return new e(new LinkedHashSet(this.f10565a), null);
        }
    }

    public e(Set set, cc.c cVar) {
        this.f10563a = set;
        this.f10564b = cVar;
    }

    public static String c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + d((X509Certificate) certificate).base64();
    }

    public static ByteString d(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void a(String str, List list) {
        List listB = b(str);
        if (listB.isEmpty()) {
            return;
        }
        cc.c cVar = this.f10564b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (listB.size() > 0) {
                n.g.a(listB.get(0));
                throw null;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate pinning failure!");
        sb2.append("\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i11 = 0; i11 < size2; i11++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i11);
            sb2.append("\n    ");
            sb2.append(c(x509Certificate));
            sb2.append(": ");
            sb2.append(x509Certificate.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(str);
        sb2.append(":");
        int size3 = listB.size();
        for (int i12 = 0; i12 < size3; i12++) {
            n.g.a(listB.get(i12));
            sb2.append("\n    ");
            sb2.append((Object) null);
        }
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    public List b(String str) {
        List list = Collections.EMPTY_LIST;
        Iterator it = this.f10563a.iterator();
        if (!it.hasNext()) {
            return list;
        }
        n.g.a(it.next());
        throw null;
    }

    public e e(cc.c cVar) {
        return ub.c.q(this.f10564b, cVar) ? this : new e(this.f10563a, cVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return ub.c.q(this.f10564b, eVar.f10564b) && this.f10563a.equals(eVar.f10563a);
    }

    public int hashCode() {
        cc.c cVar = this.f10564b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f10563a.hashCode();
    }
}
