package pb;

import android.content.Context;
import c8.lc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m9.l;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;
import pa.r;
import qb.d;
import qb.h;
import rb.c;
import rb.f;
import z8.c1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11152a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11153b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11154c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11155d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11156e;

    /* renamed from: f, reason: collision with root package name */
    public qb.a f11157f;

    /* renamed from: g, reason: collision with root package name */
    public d f11158g;

    /* renamed from: h, reason: collision with root package name */
    public List f11159h;

    /* renamed from: i, reason: collision with root package name */
    public long f11160i;

    public a(Context context, String str, String str2, String str3, String str4) throws IOException {
        this.f11152a = context;
        this.f11153b = str;
        this.f11154c = str2;
        this.f11155d = str3;
        this.f11156e = str4;
        i();
    }

    @Override // pb.b
    public long a() {
        List list = this.f11159h;
        long jMax = 0;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.f11159h.iterator();
            while (it.hasNext()) {
                jMax = Math.max(((rb.d) it.next()).a(), jMax);
            }
        }
        return jMax;
    }

    @Override // pb.b
    public List b(boolean z10) {
        if (!z10 && System.currentTimeMillis() - this.f11160i < 180000) {
            return Collections.EMPTY_LIST;
        }
        List list = this.f11159h;
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11159h.iterator();
        while (it.hasNext()) {
            f fVarD = ((rb.d) it.next()).d();
            if (fVarD != null) {
                arrayList.add(fVarD);
            }
        }
        if (arrayList.isEmpty()) {
            this.f11158g.g();
            this.f11160i = System.currentTimeMillis();
        }
        return arrayList;
    }

    @Override // pb.b
    public List c(boolean z10) {
        if (!z10 && System.currentTimeMillis() - this.f11160i < 180000) {
            return Collections.EMPTY_LIST;
        }
        List list = this.f11159h;
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11159h.iterator();
        while (it.hasNext()) {
            f fVarC = ((rb.d) it.next()).c();
            if (fVarC != null) {
                arrayList.add(fVarC);
            }
        }
        if (arrayList.isEmpty()) {
            this.f11158g.g();
            this.f11160i = System.currentTimeMillis();
        }
        return arrayList;
    }

    @Override // pb.b
    public qb.a d() {
        return this.f11157f;
    }

    @Override // pb.b
    public List e(boolean z10) {
        if (!z10 && System.currentTimeMillis() - this.f11160i < 180000) {
            return Collections.EMPTY_LIST;
        }
        List list = this.f11159h;
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11159h.iterator();
        while (it.hasNext()) {
            f fVarE = ((rb.d) it.next()).e();
            if (fVarE != null) {
                arrayList.add(fVarE);
            }
        }
        if (arrayList.isEmpty()) {
            this.f11158g.g();
            this.f11160i = System.currentTimeMillis();
        }
        return arrayList;
    }

    @Override // pb.b
    public void f(qb.a aVar) throws IOException {
        qb.a aVar2;
        if (this.f11158g != null && (aVar2 = this.f11157f) != null && (aVar == null || !aVar2.d().equals(aVar.d()))) {
            this.f11158g.f();
            this.f11160i = 0L;
        }
        j(aVar);
        h(aVar);
    }

    @Override // pb.b
    public List g(boolean z10) {
        if (!z10 && System.currentTimeMillis() - this.f11160i < 180000) {
            return Collections.EMPTY_LIST;
        }
        List list = this.f11159h;
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11159h.iterator();
        while (it.hasNext()) {
            f fVarB = ((rb.d) it.next()).b();
            if (fVarB != null) {
                arrayList.add(fVarB);
            }
        }
        if (arrayList.isEmpty()) {
            this.f11158g.g();
            this.f11160i = System.currentTimeMillis();
        }
        return arrayList;
    }

    public final void h(qb.a aVar) throws IOException {
        String str = this.f11155d;
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(this.f11155d);
        if (aVar == null) {
            c1.f(file);
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter.write(aVar.j(this.f11153b, this.f11154c).toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter.close();
            } finally {
            }
        } catch (IOException e10) {
            pc.a.i(e10);
        }
    }

    public final void i() throws IOException {
        String next;
        JSONObject jSONObjectOptJSONObject;
        String str = this.f11155d;
        if (str != null && !str.isEmpty()) {
            File file = new File(this.f11155d);
            if (file.isFile()) {
                this.f11157f = null;
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (!line.isEmpty()) {
                                try {
                                    JSONObject jSONObject = new JSONObject(line);
                                    if (jSONObject.has(Name.MARK)) {
                                        this.f11157f = qb.a.a(jSONObject, this.f11153b, this.f11154c);
                                    } else {
                                        Iterator<String> itKeys = jSONObject.keys();
                                        if (itKeys.hasNext() && (jSONObjectOptJSONObject = jSONObject.optJSONObject((next = itKeys.next()))) != null) {
                                            this.f11157f = new qb.a(next, 16, 1, qb.f.b(jSONObjectOptJSONObject, this.f11153b, this.f11154c));
                                        }
                                    }
                                } catch (JSONException e10) {
                                    pc.a.i(e10);
                                }
                                if (this.f11157f != null) {
                                    break;
                                }
                            }
                        } finally {
                        }
                    }
                    bufferedReader.close();
                } catch (IOException e11) {
                    pc.a.i(e11);
                }
                j(this.f11157f);
                return;
            }
        }
        this.f11157f = null;
        j(null);
    }

    public final void j(qb.a aVar) {
        this.f11157f = aVar;
        if (aVar == null) {
            this.f11159h = null;
            this.f11158g = null;
            return;
        }
        this.f11158g = new h(aVar.d(), (qb.f) aVar.e(), this.f11156e);
        int iB = aVar.b();
        if (iB == 0) {
            this.f11159h = null;
            return;
        }
        this.f11159h = new ArrayList();
        if ((iB & 16) == 16) {
            this.f11159h.add(new rb.a(16, r.d(), this.f11158g));
        }
        if ((iB & 64) == 64) {
            this.f11159h.add(new rb.b(64, r.f(), this.f11158g));
        }
        if ((iB & 32) == 32) {
            this.f11159h.add(new c(32, this.f11158g, new l(this.f11152a, r.j(), r.f(), r.c(), lc.c().d(), r.k())));
        }
    }
}
