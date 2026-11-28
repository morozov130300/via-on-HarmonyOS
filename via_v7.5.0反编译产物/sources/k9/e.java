package k9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.l f7224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w9.a f7225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z9.d f7226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u4.a f7227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qa.c f7228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m9.c f7229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7230g;

    public e(u9.l lVar, w9.a aVar, z9.d dVar, u4.a aVar2, qa.c cVar, m9.c cVar2, boolean z10) {
        this.f7224a = lVar;
        this.f7225b = aVar;
        this.f7226c = dVar;
        this.f7227d = aVar2;
        this.f7228e = cVar;
        this.f7229f = cVar2;
        this.f7230g = z10;
    }

    @Override // k9.b
    public List a(c cVar) {
        File fileA = cVar.a("data-for-older-versions.txt");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), k8.a.f7218a));
            try {
                bufferedWriter.write(new JSONObject(j9.d.a(this.f7224a, this.f7225b, this.f7226c, this.f7227d, this.f7228e, this.f7229f, this.f7230g)).toString());
                bufferedWriter.flush();
                arrayList.add(new a(fileA));
                bufferedWriter.close();
                return arrayList;
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Exception e10) {
            tc.a.j(e10);
            return arrayList;
        }
    }

    @Override // k9.b
    public void b(c cVar, int i10) {
    }
}
