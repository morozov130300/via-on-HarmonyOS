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
import u9.n;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w9.a f7233a;

    public g(w9.a aVar) {
        this.f7233a = aVar;
    }

    @Override // k9.b
    public List a(c cVar) {
        File fileA = cVar.a("history.txt");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        List<l9.b> listR = this.f7233a.r();
        if (listR.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileA));
            try {
                for (l9.b bVar : listR) {
                    bufferedWriter.write(c6.i.f2031a.h(bVar.g(), bVar.e(), bVar.f()));
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
        } catch (IOException e10) {
            tc.a.j(e10);
            return arrayList;
        }
    }

    @Override // k9.b
    public void b(c cVar, int i10) {
        File fileA = cVar.a("history.txt");
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
                    c6.j jVarD = c6.i.f2031a.d(line);
                    if (jVarD != null) {
                        l9.b bVar = new l9.b(jVarD.b(), jVarD.a());
                        bVar.p(jVarD.c());
                        arrayList.add(bVar);
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
                if (i10 == 1) {
                    this.f7233a.w();
                }
                this.f7233a.x(arrayList);
            }
            n.e().u(true);
            bufferedReader.close();
        } catch (IOException e10) {
            tc.a.j(e10);
        }
    }
}
