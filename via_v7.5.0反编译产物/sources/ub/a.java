package ub;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.a0;
import okhttp3.h;
import okhttp3.i;
import okhttp3.q;
import okhttp3.y;
import wb.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f12943a;

    public abstract void a(q.a aVar, String str);

    public abstract void b(q.a aVar, String str, String str2);

    public abstract void c(i iVar, SSLSocket sSLSocket, boolean z10);

    public abstract int d(y.a aVar);

    public abstract boolean e(h hVar, wb.c cVar);

    public abstract Socket f(h hVar, okhttp3.a aVar, f fVar);

    public abstract boolean g(okhttp3.a aVar, okhttp3.a aVar2);

    public abstract wb.c h(h hVar, okhttp3.a aVar, f fVar, a0 a0Var);

    public abstract void i(h hVar, wb.c cVar);

    public abstract wb.d j(h hVar);

    public abstract IOException k(okhttp3.d dVar, IOException iOException);
}
