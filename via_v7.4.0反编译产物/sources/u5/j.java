package u5;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import t5.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12870a = "j";

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Comparator {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ v f12871e;

        public a(v vVar) {
            this.f12871e = vVar;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(v vVar, v vVar2) {
            return Float.compare(j.this.c(vVar2, this.f12871e), j.this.c(vVar, this.f12871e));
        }
    }

    public List a(List list, v vVar) {
        if (vVar == null) {
            return list;
        }
        Collections.sort(list, new a(vVar));
        return list;
    }

    public v b(List list, v vVar) {
        List listA = a(list, vVar);
        String str = f12870a;
        Log.i(str, "Viewfinder size: " + vVar);
        Log.i(str, "Preview in order of preference: " + listA);
        return (v) listA.get(0);
    }

    public abstract float c(v vVar, v vVar2);

    public abstract Rect d(v vVar, v vVar2);
}
