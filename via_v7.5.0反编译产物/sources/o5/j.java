package o5;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import n5.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10969a = "j";

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Comparator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f10970c;

        public a(v vVar) {
            this.f10970c = vVar;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(v vVar, v vVar2) {
            return Float.compare(j.this.c(vVar2, this.f10970c), j.this.c(vVar, this.f10970c));
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
        String str = f10969a;
        Log.i(str, "Viewfinder size: " + vVar);
        Log.i(str, "Preview in order of preference: " + listA);
        return (v) listA.get(0);
    }

    public abstract float c(v vVar, v vVar2);

    public abstract Rect d(v vVar, v vVar2);
}
