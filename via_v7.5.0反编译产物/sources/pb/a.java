package pb;

import android.content.Context;
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
import k9.l;
import la.s;
import mark.via.browser.kd;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;
import qb.d;
import qb.h;
import rb.c;
import rb.f;
import x8.c1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public qb.a f11646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f11647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f11648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11649i;

    public a(Context context, String str, String str2, String str3, String str4) {
        this.f11641a = context;
        this.f11642b = str;
        this.f11643c = str2;
        this.f11644d = str3;
        this.f11645e = str4;
        i();
    }

    @Override // pb.b
    public long a() {
        List list = this.f11648h;
        long jMax = 0;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.f11648h.iterator();
            while (it.hasNext()) {
                jMax = Math.max(((rb.d) it.next()).a(), jMax);
            }
        }
        return jMax;
    }

    @Override // pb.b
    public List b(boolean z10) {
        if (!z10 && System.currentTimeMillis() - this.f11649i < 180000) {
            return Collections.EMPTY_LIST;
        }
        List list = this.f11648h;
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11648h.iterator();
        while (it.hasNext()) {
            f fVarE = ((rb.d) it.next()).e();
            if (fVarE != null) {
                arrayList.add(fVarE);
            }
        }
        if (arrayList.isEmpty()) {
            this.f11647g.g();
            this.f11649i = System.currentTimeMillis();
        }
        return arrayList;
    }

    @Override // pb.b
    public List c(boolean z10) {
        if (!z10 && System.currentTimeMillis() - this.f11649i < 180000) {
            return Collections.EMPTY_LIST;
        }
        List list = this.f11648h;
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11648h.iterator();
        while (it.hasNext()) {
            f fVarD = ((rb.d) it.next()).d();
            if (fVarD != null) {
                arrayList.add(fVarD);
            }
        }
        if (arrayList.isEmpty()) {
            this.f11647g.g();
            this.f11649i = System.currentTimeMillis();
        }
        return arrayList;
    }

    @Override // pb.b
    public qb.a d() {
        return this.f11646f;
    }

    @Override // pb.b
    public List e(boolean z10) {
        if (!z10 && System.currentTimeMillis() - this.f11649i < 180000) {
            return Collections.EMPTY_LIST;
        }
        List list = this.f11648h;
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11648h.iterator();
        while (it.hasNext()) {
            f fVarB = ((rb.d) it.next()).b();
            if (fVarB != null) {
                arrayList.add(fVarB);
            }
        }
        if (arrayList.isEmpty()) {
            this.f11647g.g();
            this.f11649i = System.currentTimeMillis();
        }
        return arrayList;
    }

    @Override // pb.b
    public void f(qb.a aVar) {
        qb.a aVar2;
        if (this.f11647g != null && (aVar2 = this.f11646f) != null && (aVar == null || !aVar2.d().equals(aVar.d()))) {
            this.f11647g.f();
            this.f11649i = 0L;
        }
        j(aVar);
        h(aVar);
    }

    @Override // pb.b
    public List g(boolean z10) {
        if (!z10 && System.currentTimeMillis() - this.f11649i < 180000) {
            return Collections.EMPTY_LIST;
        }
        List list = this.f11648h;
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11648h.iterator();
        while (it.hasNext()) {
            f fVarC = ((rb.d) it.next()).c();
            if (fVarC != null) {
                arrayList.add(fVarC);
            }
        }
        if (arrayList.isEmpty()) {
            this.f11647g.g();
            this.f11649i = System.currentTimeMillis();
        }
        return arrayList;
    }

    public final void h(qb.a aVar) {
        String str = this.f11644d;
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(this.f11644d);
        if (aVar == null) {
            c1.f(file);
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter.write(aVar.j(this.f11642b, this.f11643c).toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e10) {
            tc.a.j(e10);
        }
    }

    public final void i() {
        String next;
        JSONObject jSONObjectOptJSONObject;
        String str = this.f11644d;
        if (str != null && !str.isEmpty()) {
            File file = new File(this.f11644d);
            if (file.isFile()) {
                this.f11646f = null;
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
                                        this.f11646f = qb.a.a(jSONObject, this.f11642b, this.f11643c);
                                    } else {
                                        Iterator<String> itKeys = jSONObject.keys();
                                        if (itKeys.hasNext() && (jSONObjectOptJSONObject = jSONObject.optJSONObject((next = itKeys.next()))) != null) {
                                            this.f11646f = new qb.a(next, 16, 1, qb.f.b(jSONObjectOptJSONObject, this.f11642b, this.f11643c));
                                        }
                                    }
                                } catch (JSONException e10) {
                                    tc.a.j(e10);
                                }
                                if (this.f11646f != null) {
                                    break;
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    bufferedReader.close();
                } catch (IOException e11) {
                    tc.a.j(e11);
                }
                j(this.f11646f);
                return;
            }
        }
        this.f11646f = null;
        j(null);
    }

    public final void j(qb.a aVar) {
        this.f11646f = aVar;
        if (aVar == null) {
            this.f11648h = null;
            this.f11647g = null;
            return;
        }
        this.f11647g = new h(aVar.d(), (qb.f) aVar.e(), this.f11645e);
        int iB = aVar.b();
        if (iB == 0) {
            this.f11648h = null;
            return;
        }
        this.f11648h = new ArrayList();
        if ((iB & 16) == 16) {
            this.f11648h.add(new rb.a(16, s.d(), this.f11647g));
        }
        if ((iB & 64) == 64) {
            this.f11648h.add(new rb.b(64, s.f(), this.f11647g));
        }
        if ((iB & 32) == 32) {
            this.f11648h.add(new c(32, this.f11647g, new l(this.f11641a, s.j(), s.f(), s.c(), kd.c().f(), s.k())));
        }
    }
}
