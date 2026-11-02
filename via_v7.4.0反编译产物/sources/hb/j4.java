package hb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j4 extends o8.g {
    public static /* synthetic */ void g3(j4 j4Var, List list, View view, int i10, a6.q qVar) {
        j4Var.getClass();
        z8.b0.P(j4Var.I(), ((n9.b) list.get(qVar.c())).g());
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new n9.b("https://github.com/androidx/androidx", "AndroidX - AndroidX", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/google/dagger", "Dagger - Google", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/ReactiveX/RxJava", "RxJava - ReactiveX", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/ReactiveX/RxAndroid", "RxAndroid - ReactiveX", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/uber/AutoDispose", "AutoDispose - Uber", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/square/okhttp", "OkHttp - Square", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/square/leakcanary/", "LeakCanary - Square", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/shwenzhang/AndResGuard", "AndResGuard - shwenzhang", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/Tencent/VasDolly", "VasDolly - Tencent", "BSD 3-Clause License"));
        arrayList.add(new n9.b("https://github.com/JakeWharton/timber", "Timber - Jake Wharton", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/promeG/TinyPinyin", "TinyPinyin - promeG", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/zxing/zxing", "ZXing - ZXing", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/rburgst/okhttp-digest", "okhttp-digest - rburgst", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/thegrizzlylabs/sardine-android", "sardine-android - The Grizzly Labs", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/AirBashX/UserScript", "AutoUnfold - AirBashX", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/mozilla/readability", "readability - mozilla", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/afollestad/drag-select-recyclerview", "drag-select-recyclerview - afollestad", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/fengyuanchen/viewerjs", "Viewer.js - Chen Fengyuan", "MIT License"));
        arrayList.add(new n9.b("https://github.com/xnx3/translate", "translate - xnx3", "MIT License"));
        arrayList.add(new n9.b("https://github.com/launchdarkly/okhttp-eventsource", "okhttp-eventsource - LaunchDarkly", "Apache License 2.0"));
        arrayList.add(new n9.b("https://github.com/noties/Markwon", "Markwon - Dimitry", "Apache License 2.0"));
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            n9.b bVar = (n9.b) arrayList.get(i10);
            arrayList2.add(new a6.q(i10, bVar.e(), bVar.b()));
        }
        y5.f fVar = new y5.f(arrayList2);
        fVar.K(a6.q.class, new a6.s(new y5.g() { // from class: hb.i4
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                j4.g3(this.f6586a, arrayList, view2, i11, (a6.q) obj);
            }
        }));
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setAdapter(fVar);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.f14186u9);
    }
}
