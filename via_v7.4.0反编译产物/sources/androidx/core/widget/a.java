package androidx.core.widget;

import android.os.Build;
import android.widget.EdgeEffect;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    public static class C0011a {
        public static void a(EdgeEffect edgeEffect, float f10, float f11) {
            edgeEffect.onPull(f10, f11);
        }
    }

    public static void a(EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0011a.a(edgeEffect, f10, f11);
        } else {
            edgeEffect.onPull(f10);
        }
    }
}
