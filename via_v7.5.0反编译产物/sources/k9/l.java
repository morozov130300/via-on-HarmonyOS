package k9;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tuyafeng.support.utils.p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import u9.n;
import x8.c1;
import x8.d1;
import x8.v0;
import x8.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f7238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w9.a f7239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u4.a f7240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qa.c f7241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z9.d f7242f;

    public l(Context context, u9.l lVar, w9.a aVar, u4.a aVar2, qa.c cVar, z9.d dVar) {
        this.f7237a = context;
        this.f7238b = lVar;
        this.f7239c = aVar;
        this.f7240d = aVar2;
        this.f7241e = cVar;
        this.f7242f = dVar;
    }

    @Override // k9.b
    public List a(c cVar) {
        File fileA = cVar.a("settings.txt");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        List arrayList = new ArrayList();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), k8.a.f7218a));
            try {
                arrayList.add(new a(fileA));
                e(bufferedWriter);
                c(bufferedWriter, arrayList);
                g(bufferedWriter);
                h(bufferedWriter);
                f(bufferedWriter, arrayList, cVar);
                d(bufferedWriter, arrayList, cVar.c());
                bufferedWriter.flush();
                bufferedWriter.close();
                return arrayList;
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
            return arrayList;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // k9.b
    public void b(c cVar, int i10) throws Throwable {
        int i11;
        File fileA = cVar.a("settings.txt");
        if (fileA == null || !fileA.isFile()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileA), k8.a.f7218a));
            i11 = 0;
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            if (i11 > 0) {
                                n.e().n(true).o(true);
                            }
                            if (arrayList.size() > 0) {
                                tc.a.a("restore settings data", new Object[0]);
                                n(arrayList);
                            }
                            if (arrayList2.size() > 0) {
                                tc.a.a("restore site confs", new Object[0]);
                                o(arrayList2);
                            }
                            if (this.f7237a != null && (i11 > 0 || !arrayList2.isEmpty())) {
                                new Handler(this.f7237a.getMainLooper()).post(new Runnable() { // from class: k9.k
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        z.T();
                                    }
                                });
                            }
                            if (arrayList3.size() > 0) {
                                tc.a.a("restore scripts", new Object[0]);
                                m(arrayList3, cVar);
                            }
                            File fileA2 = cVar.a("filters-custom.txt");
                            if (!arrayList4.isEmpty() || (fileA2 != null && fileA2.isFile())) {
                                tc.a.a("restore filters", new Object[0]);
                                l(arrayList4, cVar);
                                return;
                            }
                            return;
                        }
                        c6.m mVarF = c6.k.f(line);
                        if (mVarF != null) {
                            String strB = mVarF.b();
                            switch (strB.hashCode()) {
                                case -907685685:
                                    if (strB.equals("script")) {
                                        arrayList3.add((JSONObject) mVarF.a());
                                    }
                                    break;
                                case -854547461:
                                    if (strB.equals("filters")) {
                                        arrayList4.add((JSONObject) mVarF.a());
                                    }
                                    break;
                                case 533878381:
                                    if (strB.equals("settingsData")) {
                                        arrayList.add((JSONObject) mVarF.a());
                                    }
                                    break;
                                case 674694923:
                                    if (strB.equals("siteConf")) {
                                        arrayList2.add((JSONObject) mVarF.a());
                                    }
                                    break;
                                case 1434631203:
                                    if (strB.equals("settings")) {
                                        k((JSONObject) mVarF.a(), cVar);
                                        i11++;
                                    }
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
                } catch (IOException e10) {
                    e = e10;
                    tc.a.j(e);
                }
            }
        } catch (IOException e11) {
            e = e11;
            i11 = 0;
        }
    }

    public final void c(Writer writer, List list) {
        int iIndexOf;
        int iIndexOf2;
        try {
            JSONObject jSONObjectP2 = this.f7238b.P2(false);
            String strD = this.f7238b.d();
            if (strD != null) {
                File file = new File(strD);
                if (file.isFile()) {
                    jSONObjectP2.put("backgroundPath", file.getName());
                    list.add(new a(file));
                }
            }
            String strD0 = this.f7238b.d0();
            if (this.f7238b.S1() == 1 && strD0 != null && (iIndexOf2 = strD0.indexOf(34, (iIndexOf = strD0.indexOf("file://")))) > iIndexOf && iIndexOf > 0) {
                File file2 = new File(strD0.substring(iIndexOf + 7, iIndexOf2));
                if (file2.isFile()) {
                    jSONObjectP2.put("logoPath", file2.getName());
                    list.add(new a(file2));
                }
            }
            p(writer, "settings", jSONObjectP2);
        } catch (IOException e10) {
            e = e10;
            tc.a.j(e);
        } catch (JSONException e11) {
            e = e11;
            tc.a.j(e);
        }
    }

    public final void d(BufferedWriter bufferedWriter, List list, boolean z10) {
        for (w4.c cVar : this.f7240d.f()) {
            if (!TextUtils.isEmpty(cVar.g())) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", cVar.g());
                    if (!TextUtils.isEmpty(cVar.f())) {
                        jSONObject.put("title", cVar.f());
                    }
                    if (cVar.h()) {
                        jSONObject.put("enabled", true);
                    }
                    File file = TextUtils.isEmpty(cVar.a()) ? null : new File(cVar.a());
                    if (!z10 && file != null && file.isFile() && file.length() > 0) {
                        String str = "filters-" + i(cVar.f()) + v0.g(cVar.g()) + ".txt";
                        jSONObject.put("path", str);
                        list.add(new a(file, str));
                        jSONObject.put("size", cVar.e());
                        jSONObject.put("lastUpdated", cVar.c());
                    }
                    p(bufferedWriter, "filters", jSONObject);
                } catch (IOException e10) {
                    e = e10;
                    tc.a.j(e);
                } catch (JSONException e11) {
                    e = e11;
                    tc.a.j(e);
                }
            }
        }
        if (z10) {
            return;
        }
        File file2 = new File(this.f7240d.d());
        if (file2.exists()) {
            list.add(new a(file2, "filters-custom.txt"));
        }
    }

    public final void e(Writer writer) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dataVersion", 1);
            jSONObject.put("appVersion", 20261125);
            p(writer, "meta", jSONObject);
        } catch (IOException | JSONException e10) {
            tc.a.j(e10);
        }
    }

    public final void f(Writer writer, List list, c cVar) throws Throwable {
        List<ra.c> listQ = this.f7241e.q();
        Collections.reverse(listQ);
        for (ra.c cVar2 : listQ) {
            String strB = this.f7241e.B(cVar2.e());
            if (strB != null && !strB.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("scriptId", strB);
                    if (!TextUtils.isEmpty(cVar2.b())) {
                        jSONObject.put("url", cVar2.b());
                    }
                    if (!TextUtils.isEmpty(cVar2.g())) {
                        jSONObject.put("name", cVar2.g());
                    }
                    if (cVar2.j()) {
                        jSONObject.put("enabled", true);
                    }
                    ra.e eVarO = this.f7241e.o(cVar2.e());
                    if (eVarO != null) {
                        jSONObject.put("userOverrides", ra.e.l(eVarO));
                    }
                    File fileA = cVar.a("script-" + i(cVar2.g()) + cVar2.e() + ".txt");
                    if (fileA == null) {
                        if (cVar.c() && TextUtils.isEmpty(cVar2.b())) {
                            String strF = this.f7241e.f(cVar2.e());
                            if (!TextUtils.isEmpty(strF)) {
                                jSONObject.put("code", d1.a(strF));
                                jSONObject.put("lastUpdated", cVar2.f());
                            }
                        }
                        p(writer, "script", jSONObject);
                    } else {
                        String strF2 = this.f7241e.f(cVar2.e());
                        if (TextUtils.isEmpty(strF2)) {
                            p(writer, "script", jSONObject);
                        } else {
                            c1.Q(fileA, strF2);
                            jSONObject.put("path", fileA.getName());
                            jSONObject.put("lastUpdated", cVar2.f());
                            list.add(new a(fileA));
                            p(writer, "script", jSONObject);
                        }
                    }
                } catch (IOException e10) {
                    e = e10;
                    tc.a.j(e);
                } catch (JSONException e11) {
                    e = e11;
                    tc.a.j(e);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0049 A[Catch: IOException -> 0x0038, JSONException -> 0x003a, TryCatch #2 {IOException -> 0x0038, JSONException -> 0x003a, blocks: (B:6:0x0026, B:8:0x0031, B:19:0x0049, B:20:0x004e, B:15:0x003c, B:17:0x0043), top: B:24:0x0026 }] */
    public final void g(Writer writer) {
        List<ga.c> listE = this.f7239c.z().e();
        int iO0 = this.f7238b.o0();
        int iM1 = this.f7238b.M1();
        for (ga.c cVar : listE) {
            try {
                JSONObject jSONObjectW = cVar.w();
                if (cVar.h() == 1 && iO0 == cVar.d()) {
                    jSONObjectW.put("selected", true);
                } else if (cVar.h() == 2 && iM1 == cVar.d()) {
                    jSONObjectW.put("selected", true);
                }
                p(writer, "settingsData", jSONObjectW);
            } catch (IOException e10) {
                e = e10;
                tc.a.j(e);
            } catch (JSONException e11) {
                e = e11;
                tc.a.j(e);
            }
        }
    }

    public final void h(Writer writer) {
        for (Map.Entry entry : this.f7242f.f().entrySet()) {
            if (entry.getKey() != null && !((String) entry.getKey()).isEmpty() && !((y9.b) entry.getValue()).r()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObjectL = y9.c.l((y9.b) entry.getValue());
                    if (((y9.b) entry.getValue()).j() > 0) {
                        jSONObjectL.put("uafallback", w9.d.d().c(((y9.b) entry.getValue()).j()));
                    }
                    jSONObject.put((String) entry.getKey(), jSONObjectL);
                    p(writer, "siteConf", jSONObject);
                } catch (IOException e10) {
                    e = e10;
                    tc.a.j(e);
                } catch (JSONException e11) {
                    e = e11;
                    tc.a.j(e);
                }
            }
        }
    }

    public final String i(String str) {
        String strJ;
        if (str == null || str.isEmpty() || (strJ = p.j(str.trim().replaceAll("[\\\\/:*?\"<>|\\s]", "-").replaceAll("\\-{2,}", "-").toLowerCase(Locale.ROOT), 128)) == null || strJ.isEmpty()) {
            return "";
        }
        return strJ + "-";
    }

    public final void j(Map map) {
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            ga.c cVarG = this.f7239c.z().g((String) entry.getValue(), 2);
            if (cVarG != null) {
                map2.put((Integer) entry.getKey(), Integer.valueOf(cVarG.d()));
            }
        }
        u9.l lVar = this.f7238b;
        lVar.m1(j.c(lVar.h1(), map2));
        u9.l lVar2 = this.f7238b;
        lVar2.f2(j.b(lVar2.I1(), map2));
        u9.l lVar3 = this.f7238b;
        lVar3.S0(j.b(lVar3.D(), map2));
    }

    public final void k(JSONObject jSONObject, c cVar) {
        File fileA;
        String strL;
        File fileA2;
        String strL2;
        try {
            if (jSONObject.opt("sharedWebFlags") instanceof Number) {
                jSONObject.put("webflag", c6.i.f2031a.b(this.f7238b.n2().a(), jSONObject.getInt("sharedWebFlags"), 25208955));
            }
            if (jSONObject.opt("sharedAppFlags") instanceof Number) {
                jSONObject.put("appflag", c6.i.f2031a.b(this.f7238b.v().a(), jSONObject.getInt("sharedAppFlags"), 42082));
            }
            if (jSONObject.opt("sharedSuggestions") instanceof Number) {
                jSONObject.put("searchsuggestion", c6.i.f2031a.b(this.f7238b.X1(), jSONObject.getInt("sharedSuggestions"), 63));
            }
        } catch (JSONException e10) {
            tc.a.j(e10);
        }
        if (jSONObject.has("backgroundPath")) {
            jSONObject.remove("bghome");
        }
        if (jSONObject.has("logoPath")) {
            jSONObject.remove("taghome");
            jSONObject.remove("logochioce");
        }
        this.f7238b.k1(jSONObject);
        String strOptString = jSONObject.optString("backgroundPath");
        if (!strOptString.isEmpty() && (fileA2 = cVar.a(strOptString)) != null && fileA2.isFile() && (strL2 = c1.l(this.f7237a)) != null) {
            File file = new File(strL2, "backup-background");
            if (c1.a(fileA2, file)) {
                h9.a.a(this.f7237a);
                this.f7238b.H1(file.getAbsolutePath());
                n.e().u(true).t(true);
            }
        }
        String strOptString2 = jSONObject.optString("logoPath");
        if (strOptString2.isEmpty() || (fileA = cVar.a(strOptString2)) == null || !fileA.isFile() || (strL = c1.l(this.f7237a)) == null) {
            return;
        }
        File file2 = new File(strL, "backup-logo");
        if (c1.a(fileA, file2)) {
            this.f7238b.l(1);
            this.f7238b.B0("<img class=\"smaller\" src=\"file://" + file2 + "\" />");
            n.e().u(true).t(true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0178 A[EDGE_INSN: B:105:0x0178->B:68:0x0178 BREAK  A[LOOP:3: B:89:0x016c->B:106:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0172 A[Catch: all -> 0x0176, TRY_LEAVE, TryCatch #1 {all -> 0x0176, blocks: (B:62:0x016c, B:64:0x0172), top: B:89:0x016c, outer: #5 }] */
    public final void l(List list, c cVar) throws Throwable {
        BufferedReader bufferedReader;
        String line;
        BufferedReader bufferedReader2;
        HashMap map = new HashMap();
        List<w4.c> listF = this.f7240d.f();
        for (w4.c cVar2 : listF) {
            map.put(cVar2.g(), cVar2);
        }
        Iterator it = list.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            String strOptString = jSONObject.optString("url");
            if (!strOptString.isEmpty()) {
                w4.c cVar3 = (w4.c) map.get(strOptString);
                String strOptString2 = jSONObject.optString("title");
                w4.c cVar4 = new w4.c();
                cVar4.p(strOptString);
                if (!TextUtils.isEmpty(strOptString2)) {
                    cVar4.o(strOptString2);
                }
                cVar4.j(jSONObject.optBoolean("enabled", false));
                cVar4.n(jSONObject.optInt("size", 0));
                File fileA = cVar.a(jSONObject.optString("path", UUID.randomUUID().toString()));
                if (cVar3 == null) {
                    cVar4.k(c1.z(this.f7237a, UUID.randomUUID() + ".txt"));
                    if (fileA == null || !fileA.isFile()) {
                        cVar4.n(0);
                    } else {
                        c1.a(fileA, new File(cVar4.a()));
                    }
                    map.put(strOptString, cVar4);
                    listF.add(cVar4);
                } else {
                    cVar3.j(cVar4.h());
                    if (((fileA == null || !fileA.isFile()) ? 0L : jSONObject.optLong("lastUpdated", 1L)) > cVar3.c()) {
                        cVar3.n(cVar4.e());
                        c1.a(fileA, new File(cVar3.a()));
                    }
                }
                z10 = true;
            }
        }
        tc.a.a("filter data changed: %s", Boolean.valueOf(z10));
        if (z10) {
            this.f7240d.q(listF);
        }
        File file = new File(this.f7240d.d());
        File fileA2 = cVar.a("filters-custom.txt");
        if (fileA2 == null || !fileA2.exists() || !file.exists()) {
            if (fileA2 == null || !fileA2.exists()) {
                return;
            }
            tc.a.a("restore filters, copy custom filters", new Object[0]);
            String strO = c1.O(fileA2);
            if (strO != null) {
                this.f7240d.p(strO);
                return;
            }
            return;
        }
        tc.a.a("restore filters, combine custom filters", new Object[0]);
        HashSet hashSet = new HashSet();
        try {
            bufferedReader2 = new BufferedReader(new FileReader(fileA2));
            bufferedReader2.close();
        } catch (IOException e10) {
            tc.a.j(e10);
        }
        try {
            while (true) {
                try {
                    String line2 = bufferedReader2.readLine();
                    if (line2 == null) {
                        break;
                    } else {
                        hashSet.add(line2);
                    }
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            line = bufferedReader.readLine();
                            if (line != null) {
                                break;
                            } else {
                                hashSet.add(line);
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
                    this.f7240d.p(TextUtils.join("\n", hashSet));
                } catch (Throwable th3) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
                tc.a.j(e10);
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                line = bufferedReader.readLine();
                if (line != null) {
                    break;
                    break;
                }
                hashSet.add(line);
                tc.a.j(e);
                this.f7240d.p(TextUtils.join("\n", hashSet));
            }
            bufferedReader.close();
        } catch (IOException e11) {
            tc.a.j(e11);
        }
        this.f7240d.p(TextUtils.join("\n", hashSet));
    }

    public final void m(List list, c cVar) throws Throwable {
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            String strOptString = jSONObject.optString("scriptId");
            String strOptString2 = jSONObject.optString("url");
            ra.c cVarH = this.f7241e.h(strOptString, null);
            if (cVarH == null && !strOptString2.isEmpty()) {
                cVarH = this.f7241e.h(null, strOptString2);
            }
            long jOptLong = jSONObject.optLong("lastUpdated", 1L);
            boolean zOptBoolean = jSONObject.optBoolean("enabled", false);
            if (cVarH == null || jOptLong > cVarH.f()) {
                String strOptString3 = jSONObject.optString("code");
                if (strOptString3.isEmpty()) {
                    File fileA = cVar.a(jSONObject.optString("path", UUID.randomUUID().toString()));
                    if (fileA != null && fileA.isFile()) {
                        strOptString3 = c1.O(fileA);
                    }
                } else {
                    try {
                        strOptString3 = d1.b(strOptString3);
                    } catch (IOException unused) {
                    }
                }
                String strOptString4 = jSONObject.optString("name");
                ra.a aVarE = ra.a.e(strOptString3, strOptString2);
                if (aVarE != null) {
                    aVarE.c().s(jOptLong);
                } else if (!TextUtils.isEmpty(strOptString2) && cVarH == null) {
                    aVarE = new ra.a(new ra.c(), new ra.b());
                    aVarE.a().A(strOptString);
                    ra.c cVarC = aVarE.c();
                    if (strOptString4.isEmpty()) {
                        strOptString4 = strOptString2;
                    }
                    cVarC.t(strOptString4);
                    aVarE.c().m(strOptString2);
                }
                String strOptString5 = jSONObject.optString("userOverrides");
                if (!strOptString5.isEmpty()) {
                    aVarE.a().B(strOptString5);
                }
                i10++;
                aVarE.f(zOptBoolean);
                if (cVarH == null) {
                    this.f7241e.a(aVarE);
                } else {
                    this.f7241e.p(cVarH.e(), aVarE);
                }
            } else if (zOptBoolean != cVarH.j()) {
                this.f7241e.l(cVarH.e(), zOptBoolean);
            }
        }
        if (i10 > 0) {
            tc.a.a("download all scripts dependencies", new Object[0]);
            qa.c cVar2 = this.f7241e;
            Objects.requireNonNull(cVar2);
            x8.h.b(new j9.g(cVar2));
        }
    }

    public final void n(List list) {
        ga.c cVarG;
        ArrayList arrayList = new ArrayList();
        ArrayList<ga.c> arrayList2 = new ArrayList();
        int iV = this.f7238b.V();
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        String strA = null;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            ga.c cVarN = ga.c.n(jSONObject);
            if (cVarN != null) {
                arrayList.add(cVarN);
                if (cVarN.h() == 1 && cVarN.d() == iV) {
                    strA = cVarN.a();
                }
                if (cVarN.h() == 2 && cVarN.d() > 0) {
                    map.put(Integer.valueOf(cVarN.d()), cVarN.a());
                }
                if (jSONObject.optBoolean("selected", false)) {
                    arrayList2.add(cVarN);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f7239c.z().h(arrayList);
        }
        w9.d.d().a();
        if (strA != null && (cVarG = this.f7239c.z().g(strA, 1)) != null) {
            this.f7238b.F2(cVarG.d());
        }
        j(map);
        if (arrayList2.isEmpty()) {
            return;
        }
        for (ga.c cVar : arrayList2) {
            ga.c cVarG2 = this.f7239c.z().g(cVar.a(), cVar.h());
            if (cVarG2 != null) {
                if (cVarG2.h() == 1) {
                    this.f7238b.g2(cVarG2.a());
                    this.f7238b.J(cVarG2.d());
                } else if (cVarG2.h() == 2) {
                    this.f7238b.p1(cVarG2.a());
                    this.f7238b.s(cVarG2.d());
                }
            }
        }
    }

    public final void o(List list) {
        String next;
        JSONObject jSONObjectOptJSONObject;
        y9.b bVarJ;
        HashMap map = new HashMap();
        for (ga.c cVar : this.f7239c.z().b(1)) {
            map.put(cVar.a(), cVar);
        }
        HashMap map2 = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys.hasNext() && (bVarJ = y9.c.j((jSONObjectOptJSONObject = jSONObject.optJSONObject((next = itKeys.next()))))) != null && next != null && !next.isEmpty()) {
                if (bVarJ.j() > 0 && (bVarJ instanceof y9.a)) {
                    String strOptString = jSONObjectOptJSONObject.optString("uafallback");
                    ga.c cVar2 = (ga.c) map.get(strOptString);
                    if (cVar2 != null) {
                        ((y9.a) bVarJ).e0(cVar2.d());
                    } else if (strOptString.isEmpty()) {
                        ((y9.a) bVarJ).e0(-1000);
                    } else {
                        y9.a aVar = (y9.a) bVarJ;
                        aVar.e0(-999);
                        aVar.Q(strOptString);
                    }
                }
                if (jSONObjectOptJSONObject.optBoolean("sharedSite") && (bVarJ instanceof y9.a)) {
                    next = y9.c.f(next.toLowerCase(Locale.ROOT));
                    if (next != null && !next.isEmpty()) {
                        y9.b bVarD = this.f7242f.d(next, true);
                        if (bVarD != null) {
                            y9.a aVarC = y9.c.c(bVarD);
                            c6.i iVar = c6.i.f2031a;
                            int iF = iVar.f(bVarJ.d(), true);
                            aVarC.T(iVar.b(bVarD.d(), bVarJ.d(), iF));
                            aVarC.V(iVar.b(bVarD.e(), bVarJ.e(), iF));
                            if (jSONObjectOptJSONObject.has("textsize")) {
                                aVarC.d0(bVarJ.i(0));
                            }
                            if (bVarJ.j() != -1000) {
                                aVarC.e0(bVarJ.j());
                                aVarC.Q(bVarJ.c(null));
                            }
                            bVarJ = aVarC;
                        }
                    }
                }
                map2.put(next, bVarJ);
            }
        }
        if (map2.size() > 0) {
            this.f7242f.a(map2);
        }
    }

    public final void p(Writer writer, String str, JSONObject jSONObject) throws IOException {
        if (str == null || str.isEmpty() || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        writer.write(c6.k.g(str, jSONObject));
        writer.write("\n");
    }
}
