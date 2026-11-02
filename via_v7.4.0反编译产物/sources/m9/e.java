package m9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements b {

    /* renamed from: a, reason: collision with root package name */
    public final w9.l f8683a;

    /* renamed from: b, reason: collision with root package name */
    public final y9.a f8684b;

    /* renamed from: c, reason: collision with root package name */
    public final ca.d f8685c;

    /* renamed from: d, reason: collision with root package name */
    public final u4.a f8686d;

    /* renamed from: e, reason: collision with root package name */
    public final p5.c f8687e;

    /* renamed from: f, reason: collision with root package name */
    public final o9.c f8688f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f8689g;

    public e(w9.l lVar, y9.a aVar, ca.d dVar, u4.a aVar2, p5.c cVar, o9.c cVar2, boolean z10) {
        this.f8683a = lVar;
        this.f8684b = aVar;
        this.f8685c = dVar;
        this.f8686d = aVar2;
        this.f8687e = cVar;
        this.f8688f = cVar2;
        this.f8689g = z10;
    }

    @Override // m9.b
    public List a(c cVar) throws IOException {
        File fileA = cVar.a("data-for-older-versions.txt");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), m8.a.f8676a));
            try {
                bufferedWriter.write(new JSONObject(l9.d.a(this.f8683a, this.f8684b, this.f8685c, this.f8686d, this.f8687e, this.f8688f, this.f8689g)).toString());
                bufferedWriter.flush();
                arrayList.add(new a(fileA));
                bufferedWriter.close();
                return arrayList;
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return arrayList;
        }
    }

    @Override // m9.b
    public void b(c cVar, int i10) {
    }
}
