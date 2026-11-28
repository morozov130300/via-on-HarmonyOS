package k4;

import com.thegrizzlylabs.sardineandroid.model.Lockdiscovery;
import com.thegrizzlylabs.sardineandroid.model.Propstat;
import com.thegrizzlylabs.sardineandroid.model.Resourcetype;
import com.thegrizzlylabs.sardineandroid.model.Response;
import com.thegrizzlylabs.sardineandroid.model.Supportedlock;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n4.c;
import n4.d;
import org.w3c.dom.Element;
import xb.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7190d = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URI f7191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0086a f7193c;

    /* JADX INFO: renamed from: k4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0086a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Date f7194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Date f7195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f7196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f7197d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f7198e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f7199f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f7200g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Long f7201h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map f7202i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Lockdiscovery f7203j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Supportedlock f7204k;

        public C0086a(Response response) {
            this.f7194a = d.e(a.this.p(response));
            this.f7195b = d.e(a.this.v(response));
            this.f7196c = a.this.n(response);
            this.f7201h = Long.valueOf(a.this.m(response));
            this.f7197d = a.this.s(response);
            this.f7198e = a.this.r(response);
            this.f7199f = a.this.x(response);
            this.f7200g = a.this.l(response);
            this.f7202i = a.this.q(response);
            this.f7203j = a.this.t(response);
            this.f7204k = a.this.z(response);
        }
    }

    public a(Response response) {
        this.f7191a = new URI(response.getHref());
        this.f7192b = y(response);
        this.f7193c = new C0086a(response);
    }

    public final String l(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                Resourcetype resourcetype = propstat2.getProp().getResourcetype();
                return (resourcetype == null || resourcetype.getCollection() == null) ? propstat2.getProp().getGetcontentlanguage() : "httpd/unix-directory";
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        r0 = r0.getProp().getGetcontentlength();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long m(com.thegrizzlylabs.sardineandroid.model.Response r7) {
        /*
            r6 = this;
            java.util.List r7 = r7.getPropstat()
            boolean r0 = r7.isEmpty()
            r1 = -1
            if (r0 == 0) goto Ld
            return r1
        Ld:
            java.util.Iterator r7 = r7.iterator()
        L11:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L49
            java.lang.Object r0 = r7.next()
            com.thegrizzlylabs.sardineandroid.model.Propstat r0 = (com.thegrizzlylabs.sardineandroid.model.Propstat) r0
            com.thegrizzlylabs.sardineandroid.model.Prop r3 = r0.getProp()
            if (r3 == 0) goto L11
            com.thegrizzlylabs.sardineandroid.model.Prop r0 = r0.getProp()
            java.lang.String r0 = r0.getGetcontentlength()
            if (r0 == 0) goto L11
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.NumberFormatException -> L32
            return r0
        L32:
            java.lang.String r3 = k4.a.f7190d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Failed to parse content length "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            n4.c.a(r3, r0)
            goto L11
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.a.m(com.thegrizzlylabs.sardineandroid.model.Response):long");
    }

    public final String n(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                Resourcetype resourcetype = propstat2.getProp().getResourcetype();
                if (resourcetype != null && resourcetype.getCollection() != null) {
                    return "httpd/unix-directory";
                }
                if (propstat2.getProp().getGetcontenttype() != null) {
                    return propstat2.getProp().getGetcontenttype();
                }
            }
        }
        return "application/octet-stream";
    }

    public Date o() {
        return this.f7193c.f7194a;
    }

    public final String p(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getCreationdate();
            }
        }
        return null;
    }

    public final Map q(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                for (Element element : propstat2.getProp().getAny()) {
                    map.put(d.f(element), element.getTextContent());
                }
            }
        }
        return map;
    }

    public final String r(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getDisplayname();
            }
        }
        return null;
    }

    public final String s(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getGetetag();
            }
        }
        return null;
    }

    public final Lockdiscovery t(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getLockdiscovery();
            }
        }
        return null;
    }

    public String toString() {
        return w();
    }

    public Date u() {
        return this.f7193c.f7195b;
    }

    public final String v(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getGetlastmodified();
            }
        }
        return null;
    }

    public String w() {
        return this.f7191a.getPath();
    }

    public final List x(Response response) {
        Resourcetype resourcetype;
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null && (resourcetype = propstat2.getProp().getResourcetype()) != null) {
                if (resourcetype.getCollection() != null) {
                    arrayList.add(d.c("collection"));
                }
                if (resourcetype.getPrincipal() != null) {
                    arrayList.add(d.c("principal"));
                }
                Iterator<Element> it = resourcetype.getAny().iterator();
                while (it.hasNext()) {
                    arrayList.add(d.f(it.next()));
                }
            }
        }
        return arrayList;
    }

    public final int y(Response response) {
        String status = response.getStatus();
        if (status == null || status.isEmpty()) {
            return 200;
        }
        try {
            return k.a(response.getStatus()).f14694b;
        } catch (IOException unused) {
            c.a(f7190d, "Failed to parse status line: " + status);
            return -1;
        }
    }

    public final Supportedlock z(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        for (Propstat propstat2 : propstat) {
            if (propstat2.getProp() != null) {
                return propstat2.getProp().getSupportedlock();
            }
        }
        return null;
    }
}
