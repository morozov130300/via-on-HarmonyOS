package m9;

import android.content.Context;
import android.text.TextUtils;
import g6.p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
import w9.n;
import z8.c1;
import z8.d1;
import z8.v0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8697a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f8698b;

    /* renamed from: c, reason: collision with root package name */
    public final y9.a f8699c;

    /* renamed from: d, reason: collision with root package name */
    public final u4.a f8700d;

    /* renamed from: e, reason: collision with root package name */
    public final p5.c f8701e;

    /* renamed from: f, reason: collision with root package name */
    public final ca.d f8702f;

    public l(Context context, w9.l lVar, y9.a aVar, u4.a aVar2, p5.c cVar, ca.d dVar) {
        this.f8697a = context;
        this.f8698b = lVar;
        this.f8699c = aVar;
        this.f8700d = aVar2;
        this.f8701e = cVar;
        this.f8702f = dVar;
    }

    @Override // m9.b
    public List a(c cVar) throws IOException {
        File fileA = cVar.a("settings.txt");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        List arrayList = new ArrayList();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), m8.a.f8676a));
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
            } finally {
            }
        } catch (IOException e10) {
            pc.a.i(e10);
            return arrayList;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @Override // m9.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(c cVar, int i10) throws Throwable {
        int i11;
        BufferedReader bufferedReader;
        String line;
        File fileA = cVar.a("settings.txt");
        if (fileA == null || !fileA.isFile()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileA), m8.a.f8676a));
            i11 = 0;
        } catch (IOException e10) {
            e = e10;
            i11 = 0;
        }
        while (true) {
            try {
                try {
                    line = bufferedReader.readLine();
                } finally {
                }
            } catch (IOException e11) {
                e = e11;
                pc.a.i(e);
                if (i11 > 0) {
                }
                if (arrayList.size() > 0) {
                }
                if (arrayList2.size() > 0) {
                }
                if (arrayList3.size() > 0) {
                }
                if (arrayList4.size() <= 0) {
                }
            }
            if (line == null) {
                bufferedReader.close();
                if (i11 > 0) {
                    n.e().p(true).q(true);
                }
                if (arrayList.size() > 0) {
                    pc.a.a("restore settings data", new Object[0]);
                    o(arrayList);
                }
                if (arrayList2.size() > 0) {
                    pc.a.a("restore site confs", new Object[0]);
                    p(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    pc.a.a("restore scripts", new Object[0]);
                    n(arrayList3, cVar);
                }
                if (arrayList4.size() <= 0) {
                    pc.a.a("restore filters", new Object[0]);
                    m(arrayList4, cVar);
                    return;
                }
                return;
            }
            w.d dVarJ = j(line);
            if (dVarJ != null) {
                String str = (String) dVarJ.f13207a;
                switch (str.hashCode()) {
                    case -907685685:
                        if (!str.equals("script")) {
                            break;
                        } else {
                            arrayList3.add((JSONObject) dVarJ.f13208b);
                            break;
                        }
                    case -854547461:
                        if (!str.equals("filters")) {
                            break;
                        } else {
                            arrayList4.add((JSONObject) dVarJ.f13208b);
                            break;
                        }
                    case 533878381:
                        if (!str.equals("settingsData")) {
                            break;
                        } else {
                            arrayList.add((JSONObject) dVarJ.f13208b);
                            break;
                        }
                    case 674694923:
                        if (!str.equals("siteConf")) {
                            break;
                        } else {
                            arrayList2.add((JSONObject) dVarJ.f13208b);
                            break;
                        }
                    case 1434631203:
                        if (!str.equals("settings")) {
                            break;
                        } else {
                            l((JSONObject) dVarJ.f13208b, cVar);
                            i11++;
                            break;
                        }
                }
            }
        }
    }

    public final void c(Writer writer, List list) throws JSONException {
        int iIndexOf;
        int iIndexOf2;
        try {
            JSONObject jSONObjectL2 = this.f8698b.L2(false);
            String strC = this.f8698b.c();
            if (strC != null) {
                File file = new File(strC);
                if (file.isFile()) {
                    jSONObjectL2.put("backgroundPath", file.getName());
                    list.add(new a(file));
                }
            }
            String strA0 = this.f8698b.a0();
            if (this.f8698b.R1() == 1 && strA0 != null && (iIndexOf2 = strA0.indexOf(34, (iIndexOf = strA0.indexOf("file://")))) > iIndexOf && iIndexOf > 0) {
                File file2 = new File(strA0.substring(iIndexOf + 7, iIndexOf2));
                if (file2.isFile()) {
                    jSONObjectL2.put("logoPath", file2.getName());
                    list.add(new a(file2));
                }
            }
            q(writer, "settings", jSONObjectL2);
        } catch (IOException e10) {
            e = e10;
            pc.a.i(e);
        } catch (JSONException e11) {
            e = e11;
            pc.a.i(e);
        }
    }

    public final void d(BufferedWriter bufferedWriter, List list, boolean z10) throws JSONException {
        for (w4.c cVar : this.f8700d.f()) {
            if (!TextUtils.isEmpty(cVar.e())) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", cVar.e());
                    if (!TextUtils.isEmpty(cVar.d())) {
                        jSONObject.put("title", cVar.d());
                    }
                    if (cVar.f()) {
                        jSONObject.put("enabled", true);
                    }
                    File file = TextUtils.isEmpty(cVar.a()) ? null : new File(cVar.a());
                    if (!z10 && file != null && file.isFile() && file.length() > 0) {
                        String str = "filters-" + i(cVar.d()) + v0.g(cVar.e()) + ".txt";
                        jSONObject.put("path", str);
                        list.add(new a(file, str));
                        jSONObject.put("size", cVar.c());
                        jSONObject.put("lastUpdated", cVar.b());
                    }
                    q(bufferedWriter, "filters", jSONObject);
                } catch (IOException e10) {
                    e = e10;
                    pc.a.i(e);
                } catch (JSONException e11) {
                    e = e11;
                    pc.a.i(e);
                }
            }
        }
        if (z10) {
            return;
        }
        File file2 = new File(this.f8700d.d());
        if (file2.exists()) {
            list.add(new a(file2, "filters-custom.txt"));
        }
    }

    public final void e(Writer writer) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dataVersion", 1);
            jSONObject.put("appVersion", 20260920);
            q(writer, "meta", jSONObject);
        } catch (IOException | JSONException e10) {
            pc.a.i(e10);
        }
    }

    public final void f(Writer writer, List list, c cVar) throws Throwable {
        List<r5.c> listO = this.f8701e.o();
        Collections.reverse(listO);
        for (r5.c cVar2 : listO) {
            String strB = this.f8701e.B(cVar2.e());
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
                    r5.e eVarN = this.f8701e.n(cVar2.e());
                    if (eVarN != null) {
                        jSONObject.put("userOverrides", r5.e.l(eVarN));
                    }
                    File fileA = cVar.a("script-" + i(cVar2.g()) + cVar2.e() + ".txt");
                    if (fileA == null) {
                        if (cVar.c() && TextUtils.isEmpty(cVar2.b())) {
                            String strG = this.f8701e.g(cVar2.e());
                            if (!TextUtils.isEmpty(strG)) {
                                jSONObject.put("code", d1.a(strG));
                                jSONObject.put("lastUpdated", cVar2.f());
                            }
                        }
                        q(writer, "script", jSONObject);
                    } else {
                        String strG2 = this.f8701e.g(cVar2.e());
                        if (TextUtils.isEmpty(strG2)) {
                            q(writer, "script", jSONObject);
                        } else {
                            c1.Q(fileA, strG2);
                            jSONObject.put("path", fileA.getName());
                            jSONObject.put("lastUpdated", cVar2.f());
                            list.add(new a(fileA));
                            q(writer, "script", jSONObject);
                        }
                    }
                } catch (IOException e10) {
                    e = e10;
                    pc.a.i(e);
                } catch (JSONException e11) {
                    e = e11;
                    pc.a.i(e);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0049 A[Catch: IOException -> 0x0038, JSONException -> 0x003a, TryCatch #2 {IOException -> 0x0038, JSONException -> 0x003a, blocks: (B:6:0x0026, B:8:0x0031, B:19:0x0049, B:20:0x004e, B:15:0x003c, B:17:0x0043), top: B:24:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(Writer writer) throws JSONException {
        List<ja.c> listE = this.f8699c.z().e();
        int iL0 = this.f8698b.l0();
        int iM1 = this.f8698b.M1();
        for (ja.c cVar : listE) {
            try {
                JSONObject jSONObjectW = cVar.w();
                if (cVar.h() != 1 || iL0 != cVar.d()) {
                    if (cVar.h() == 2 && iM1 == cVar.d()) {
                        jSONObjectW.put("selected", true);
                    }
                    q(writer, "settingsData", jSONObjectW);
                }
            } catch (IOException e10) {
                e = e10;
                pc.a.i(e);
            } catch (JSONException e11) {
                e = e11;
                pc.a.i(e);
            }
        }
    }

    public final void h(Writer writer) throws JSONException {
        for (Map.Entry entry : this.f8702f.h().entrySet()) {
            if (entry.getKey() != null && !((String) entry.getKey()).isEmpty() && !((ba.b) entry.getValue()).r()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObjectL = ba.c.l((ba.b) entry.getValue());
                    if (((ba.b) entry.getValue()).j() > 0) {
                        jSONObjectL.put("uafallback", y9.d.c().b(((ba.b) entry.getValue()).j()));
                    }
                    jSONObject.put((String) entry.getKey(), jSONObjectL);
                    q(writer, "siteConf", jSONObject);
                } catch (IOException e10) {
                    e = e10;
                    pc.a.i(e);
                } catch (JSONException e11) {
                    e = e11;
                    pc.a.i(e);
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

    public final w.d j(String str) {
        String next;
        JSONObject jSONObjectOptJSONObject;
        if (str.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys.hasNext() && (next = itKeys.next()) != null && !next.isEmpty() && (jSONObjectOptJSONObject = jSONObject.optJSONObject(next)) != null && jSONObjectOptJSONObject.length() != 0) {
                return w.d.a(next, jSONObjectOptJSONObject);
            }
            return null;
        } catch (JSONException e10) {
            pc.a.i(e10);
        }
        return null;
    }

    public final void k(Map map) {
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            ja.c cVarF = this.f8699c.z().f((String) entry.getValue(), 2);
            if (cVarF != null) {
                map2.put((Integer) entry.getKey(), Integer.valueOf(cVarF.d()));
            }
        }
        w9.l lVar = this.f8698b;
        lVar.l1(j.c(lVar.f1(), map2));
        w9.l lVar2 = this.f8698b;
        lVar2.e2(j.b(lVar2.I1(), map2));
        w9.l lVar3 = this.f8698b;
        lVar3.P0(j.b(lVar3.C(), map2));
    }

    public final void l(JSONObject jSONObject, c cVar) {
        File fileA;
        String strL;
        File fileA2;
        String strL2;
        this.f8698b.j1(jSONObject);
        String strOptString = jSONObject.optString("backgroundPath");
        if (!strOptString.isEmpty() && (fileA2 = cVar.a(strOptString)) != null && fileA2.isFile() && (strL2 = c1.l(this.f8697a)) != null) {
            File file = new File(strL2, fileA2.getName());
            if (c1.a(fileA2, file)) {
                j9.a.a(this.f8697a);
                this.f8698b.F1(file.getAbsolutePath());
                n.e().w(true).v(true);
            }
        }
        String strOptString2 = jSONObject.optString("logoPath");
        if (strOptString2.isEmpty() || (fileA = cVar.a(strOptString2)) == null || !fileA.isFile() || (strL = c1.l(this.f8697a)) == null || !c1.a(fileA, new File(strL, fileA.getName()))) {
            return;
        }
        this.f8698b.k(1);
        this.f8698b.z0("<img class=\"smaller\" src=\"file://" + fileA + "\" />");
        n.e().w(true).v(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(List list, c cVar) throws IOException {
        BufferedReader bufferedReader;
        HashMap map = new HashMap();
        List<w4.c> listF = this.f8700d.f();
        for (w4.c cVar2 : listF) {
            map.put(cVar2.e(), cVar2);
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
                cVar4.n(strOptString);
                if (!TextUtils.isEmpty(strOptString2)) {
                    cVar4.m(strOptString2);
                }
                cVar4.h(jSONObject.optBoolean("enabled", false));
                cVar4.l(jSONObject.optInt("size", 0));
                File fileA = cVar.a(jSONObject.optString("path", UUID.randomUUID().toString()));
                if (cVar3 == null) {
                    cVar4.i(c1.x(this.f8697a, UUID.randomUUID() + ".txt"));
                    if (fileA == null || !fileA.isFile()) {
                        cVar4.l(0);
                    } else {
                        c1.a(fileA, new File(cVar4.a()));
                    }
                    map.put(strOptString, cVar4);
                    listF.add(cVar4);
                } else {
                    cVar3.h(cVar4.f());
                    if (((fileA == null || !fileA.isFile()) ? 0L : jSONObject.optLong("lastUpdated", 1L)) > cVar3.b()) {
                        cVar3.l(cVar4.c());
                        c1.a(fileA, new File(cVar3.a()));
                    }
                }
                z10 = true;
            }
        }
        pc.a.a("filter data changed: %s", Boolean.valueOf(z10));
        if (z10) {
            this.f8700d.o(listF);
        }
        File file = new File(this.f8700d.d());
        File fileA2 = cVar.a("filters-custom.txt");
        if (fileA2 == null || !fileA2.exists() || !file.exists()) {
            if (fileA2 != null && fileA2.exists()) {
                pc.a.a("restore filters, copy custom filters", new Object[0]);
                c1.a(fileA2, file);
            }
            if (z10) {
                return;
            }
            pc.a.a("restore filters, reload filters", new Object[0]);
            u4.a aVar = this.f8700d;
            Objects.requireNonNull(aVar);
            z8.h.b(new k(aVar));
            return;
        }
        pc.a.a("restore filters, combine custom filters", new Object[0]);
        HashSet hashSet = new HashSet();
        try {
            bufferedReader = new BufferedReader(new FileReader(fileA2));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        hashSet.add(line);
                    }
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e10) {
            pc.a.i(e10);
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line2 = bufferedReader.readLine();
                    if (line2 == null) {
                        break;
                    } else {
                        hashSet.add(line2);
                    }
                } finally {
                }
            }
            bufferedReader.close();
        } catch (IOException e11) {
            pc.a.i(e11);
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    bufferedWriter.write((String) it2.next());
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } finally {
            }
        } catch (IOException e12) {
            pc.a.i(e12);
        }
        z10 = true;
        if (z10) {
        }
    }

    public final void n(List list, c cVar) throws Throwable {
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            String strOptString = jSONObject.optString("scriptId");
            String strOptString2 = jSONObject.optString("url");
            r5.c cVarI = this.f8701e.i(strOptString, strOptString2);
            long jOptLong = jSONObject.optLong("lastUpdated", 1L);
            boolean zOptBoolean = jSONObject.optBoolean("enabled", false);
            if (cVarI == null || jOptLong >= cVarI.f()) {
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
                r5.a aVarF = r5.a.f(strOptString3, strOptString2);
                if (aVarF == null) {
                    if (!TextUtils.isEmpty(strOptString2) && cVarI == null) {
                        aVarF = new r5.a(new r5.c(), new r5.b());
                        aVarF.a().B(strOptString);
                        r5.c cVarD = aVarF.d();
                        if (strOptString4.isEmpty()) {
                            strOptString4 = strOptString2;
                        }
                        cVarD.t(strOptString4);
                        aVarF.d().m(strOptString2);
                    }
                }
                String strOptString5 = jSONObject.optString("userOverrides");
                if (!strOptString5.isEmpty()) {
                    aVarF.a().C(strOptString5);
                }
                i10++;
                aVarF.g(zOptBoolean);
                if (cVarI == null) {
                    this.f8701e.h(aVarF);
                } else {
                    this.f8701e.p(cVarI.e(), aVarF);
                }
            } else if (zOptBoolean != cVarI.j()) {
                this.f8701e.l(cVarI.e(), zOptBoolean);
            }
        }
        if (i10 > 0) {
            pc.a.a("download all scripts dependencies", new Object[0]);
            p5.c cVar2 = this.f8701e;
            Objects.requireNonNull(cVar2);
            z8.h.b(new l9.g(cVar2));
        }
    }

    public final void o(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<ja.c> arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            ja.c cVarN = ja.c.n(jSONObject);
            if (cVarN != null) {
                arrayList.add(cVarN);
                if (cVarN.h() == 2 && cVarN.d() > 0) {
                    map.put(Integer.valueOf(cVarN.d()), cVarN.a());
                }
                if (jSONObject.optBoolean("selected", false)) {
                    arrayList2.add(cVarN);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f8699c.z().g(arrayList);
        }
        k(map);
        if (arrayList2.isEmpty()) {
            return;
        }
        for (ja.c cVar : arrayList2) {
            ja.c cVarF = this.f8699c.z().f(cVar.a(), cVar.h());
            if (cVarF != null) {
                if (cVarF.h() == 1) {
                    this.f8698b.I(cVarF.d());
                } else if (cVarF.h() == 2) {
                    this.f8698b.q(cVarF.d());
                }
            }
        }
    }

    public final void p(List list) {
        String next;
        JSONObject jSONObjectOptJSONObject;
        ba.b bVarJ;
        HashMap map = new HashMap();
        for (ja.c cVar : this.f8699c.z().c(1)) {
            map.put(cVar.a(), cVar);
        }
        HashMap map2 = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys.hasNext() && (bVarJ = ba.c.j((jSONObjectOptJSONObject = jSONObject.optJSONObject((next = itKeys.next()))))) != null && next != null && !next.isEmpty()) {
                if (bVarJ.j() > 0 && (bVarJ instanceof ba.a)) {
                    String strOptString = jSONObjectOptJSONObject.optString("uafallback");
                    ja.c cVar2 = (ja.c) map.get(strOptString);
                    if (cVar2 != null) {
                        ((ba.a) bVarJ).e0(cVar2.d());
                    } else if (strOptString.isEmpty()) {
                        ((ba.a) bVarJ).e0(-1000);
                    } else {
                        ba.a aVar = (ba.a) bVarJ;
                        aVar.e0(-999);
                        aVar.Q(strOptString);
                    }
                }
                map2.put(next, bVarJ);
            }
        }
        if (map2.size() > 0) {
            this.f8702f.a(map2);
        }
    }

    public final void q(Writer writer, String str, JSONObject jSONObject) throws JSONException, IOException {
        if (str == null || str.isEmpty() || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(str, jSONObject);
        writer.write(jSONObject2.toString());
        writer.write("\n");
    }
}
