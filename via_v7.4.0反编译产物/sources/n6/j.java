package n6;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f10223a;

    public j(Layout layout) {
        this.f10223a = new WeakReference(layout);
    }

    public static void a(Spannable spannable, Layout layout) {
        j[] jVarArr = (j[]) spannable.getSpans(0, spannable.length(), j.class);
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                spannable.removeSpan(jVar);
            }
        }
        spannable.setSpan(new j(layout), 0, spannable.length(), 18);
    }

    public static Layout c(Spanned spanned) {
        j[] jVarArr = (j[]) spanned.getSpans(0, spanned.length(), j.class);
        if (jVarArr == null || jVarArr.length <= 0) {
            return null;
        }
        return jVarArr[0].b();
    }

    public Layout b() {
        return (Layout) this.f10223a.get();
    }
}
