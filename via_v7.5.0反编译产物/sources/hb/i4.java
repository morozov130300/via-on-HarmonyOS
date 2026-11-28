package hb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i4 extends m8.f {
    public static /* synthetic */ void f3(i4 i4Var, List list, View view, int i10, v5.q qVar) {
        i4Var.getClass();
        x8.z.O(i4Var.G(), ((l9.b) list.get(qVar.c())).g());
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new l9.b("https://github.com/androidx/androidx", "AndroidX - AndroidX", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/google/dagger", "Dagger - Google", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/ReactiveX/RxJava", "RxJava - ReactiveX", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/ReactiveX/RxAndroid", "RxAndroid - ReactiveX", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/uber/AutoDispose", "AutoDispose - Uber", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/square/okhttp", "OkHttp - Square", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/square/leakcanary/", "LeakCanary - Square", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/shwenzhang/AndResGuard", "AndResGuard - shwenzhang", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/Tencent/VasDolly", "VasDolly - Tencent", "BSD 3-Clause License"));
        arrayList.add(new l9.b("https://github.com/JakeWharton/timber", "Timber - Jake Wharton", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/promeG/TinyPinyin", "TinyPinyin - promeG", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/zxing/zxing", "ZXing - ZXing", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/rburgst/okhttp-digest", "okhttp-digest - rburgst", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/thegrizzlylabs/sardine-android", "sardine-android - The Grizzly Labs", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/AirBashX/UserScript", "AutoUnfold - AirBashX", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/mozilla/readability", "readability - mozilla", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/afollestad/drag-select-recyclerview", "drag-select-recyclerview - afollestad", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/fengyuanchen/viewerjs", "Viewer.js - Chen Fengyuan", "MIT License"));
        arrayList.add(new l9.b("https://github.com/xnx3/translate", "translate - xnx3", "MIT License"));
        arrayList.add(new l9.b("https://github.com/launchdarkly/okhttp-eventsource", "okhttp-eventsource - LaunchDarkly", "Apache License 2.0"));
        arrayList.add(new l9.b("https://github.com/noties/Markwon", "Markwon - Dimitry", "Apache License 2.0"));
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            l9.b bVar = (l9.b) arrayList.get(i10);
            arrayList2.add(new v5.q(i10, bVar.e(), bVar.b()));
        }
        t5.f fVar = new t5.f(arrayList2);
        fVar.K(v5.q.class, new v5.s(new t5.g() { // from class: hb.h4
            @Override // t5.g
            public final void a(View view2, int i11, Object obj) {
                i4.f3(this.f5887a, arrayList, view2, i11, (v5.q) obj);
            }
        }));
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setAdapter(fVar);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.F9);
    }
}
