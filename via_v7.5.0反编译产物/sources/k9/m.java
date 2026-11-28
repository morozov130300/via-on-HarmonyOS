package k9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7243a = "title";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7244b = "url";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7245c = "updated_at";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ka.h f7246d;

    public m(ka.h hVar) {
        this.f7246d = hVar;
    }

    @Override // k9.b
    public List a(c cVar) {
        File fileA = cVar.a("tabs.txt");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        List<ka.f> listG = this.f7246d.g();
        if (listG.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileA));
            try {
                for (ka.f fVar : listG) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("title", fVar.e());
                    jSONObject.put("url", fVar.f());
                    jSONObject.put("updated_at", fVar.d());
                    bufferedWriter.write(jSONObject.toString());
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                arrayList.add(new a(fileA));
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
        } catch (IOException | JSONException e10) {
            tc.a.j(e10);
            return arrayList;
        }
    }

    @Override // k9.b
    public void b(c cVar, int i10) {
        File fileA = cVar.a("tabs.txt");
        if (fileA == null || !fileA.isFile()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileA));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (!line.isEmpty()) {
                        try {
                            JSONObject jSONObject = new JSONObject(line);
                            ka.f fVar = new ka.f(UUID.randomUUID().toString());
                            fVar.l(jSONObject.getString("url"));
                            if (fVar.f() != null && !fVar.f().isEmpty()) {
                                fVar.k(jSONObject.optString("title"));
                                fVar.j(jSONObject.optLong("updated_at", 0L));
                                arrayList.add(fVar);
                            }
                        } catch (JSONException e10) {
                            tc.a.k(e10, "Failed to parse line: %s", line);
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
                tc.a.j(e);
            }
            if (!arrayList.isEmpty()) {
                this.f7246d.e(arrayList);
            }
            bufferedReader.close();
        } catch (IOException e11) {
            tc.a.j(e11);
        }
    }
}
