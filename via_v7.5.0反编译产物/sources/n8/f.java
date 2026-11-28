package n8;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.tuyafeng.support.utils.n;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f10713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.activity.result.b f10714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f10715c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(Uri uri);
    }

    public f(Fragment fragment) {
        this.f10713a = fragment;
        this.f10714b = fragment.w2(new s5.c(), new androidx.activity.result.a() { // from class: n8.e
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                this.f10712a.c((Uri) obj);
            }
        });
    }

    public void b(String[] strArr, a aVar) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        this.f10715c = aVar;
        try {
            this.f10714b.a(strArr);
        } catch (ActivityNotFoundException e10) {
            tc.a.j(e10);
            n.q(this.f10713a.G(), u.Ng);
        }
    }

    public final void c(Uri uri) {
        a aVar = this.f10715c;
        if (aVar == null) {
            return;
        }
        aVar.a(uri);
        this.f10715c = null;
    }
}
