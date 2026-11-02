package m9;

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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f8703a = "title";

    /* renamed from: b, reason: collision with root package name */
    public final String f8704b = "url";

    /* renamed from: c, reason: collision with root package name */
    public final String f8705c = "updated_at";

    /* renamed from: d, reason: collision with root package name */
    public final na.h f8706d;

    public m(na.h hVar) {
        this.f8706d = hVar;
    }

    @Override // m9.b
    public List a(c cVar) throws IOException {
        File fileA = cVar.a("tabs.txt");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        List<na.f> listG = this.f8706d.g();
        if (listG.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileA));
            try {
                for (na.f fVar : listG) {
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
            pc.a.i(e10);
            return arrayList;
        }
    }

    @Override // m9.b
    public void b(c cVar, int i10) throws IOException {
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
                            na.f fVar = new na.f(UUID.randomUUID().toString());
                            fVar.l(jSONObject.getString("url"));
                            if (fVar.f() != null && !fVar.f().isEmpty()) {
                                fVar.k(jSONObject.optString("title"));
                                fVar.j(jSONObject.optLong("updated_at", 0L));
                                arrayList.add(fVar);
                            }
                        } catch (JSONException e10) {
                            pc.a.j(e10, "Failed to parse line: %s", line);
                        }
                    }
                } finally {
                }
            }
            if (!arrayList.isEmpty()) {
                this.f8706d.e(arrayList);
            }
            bufferedReader.close();
        } catch (IOException e11) {
            pc.a.i(e11);
        }
    }
}
