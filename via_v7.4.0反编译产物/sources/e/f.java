package e;

import android.content.Context;
import android.content.Intent;
import e.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import k7.i;
import k7.t;
import k7.x;
import kotlin.Pair;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f extends e.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4694a = new a(null);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Intent a(String[] input) {
            kotlin.jvm.internal.h.f(input, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            kotlin.jvm.internal.h.e(intentPutExtra, "Intent(ACTION_REQUEST_PE\u2026EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }
    }

    @Override // e.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] input) {
        kotlin.jvm.internal.h.f(context, "context");
        kotlin.jvm.internal.h.f(input, "input");
        return f4694a.a(input);
    }

    @Override // e.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a.C0063a b(Context context, String[] input) {
        kotlin.jvm.internal.h.f(context, "context");
        kotlin.jvm.internal.h.f(input, "input");
        if (input.length == 0) {
            return new a.C0063a(kotlin.collections.a.d());
        }
        for (String str : input) {
            if (o.a.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(t7.e.a(x.a(input.length), 16));
        for (String str2 : input) {
            Pair pairA = j7.d.a(str2, Boolean.TRUE);
            linkedHashMap.put(pairA.getFirst(), pairA.getSecond());
        }
        return new a.C0063a(linkedHashMap);
    }

    @Override // e.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i10, Intent intent) {
        if (i10 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return kotlin.collections.a.d();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i11 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i11 == 0));
            }
            return kotlin.collections.a.g(t.B(i.i(stringArrayExtra), arrayList));
        }
        return kotlin.collections.a.d();
    }
}
