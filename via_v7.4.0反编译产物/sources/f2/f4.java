package f2;

import android.content.SharedPreferences;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f4 {

    /* renamed from: a, reason: collision with root package name */
    public final String f5172a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5173b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5174c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5175d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l4 f5176e;

    public f4(l4 l4Var, String str, boolean z10) {
        this.f5176e = l4Var;
        t1.f.d(str);
        this.f5172a = str;
        this.f5173b = z10;
    }

    public final void a(boolean z10) {
        SharedPreferences.Editor editorEdit = this.f5176e.o().edit();
        editorEdit.putBoolean(this.f5172a, z10);
        editorEdit.apply();
        this.f5175d = z10;
    }

    public final boolean b() {
        if (!this.f5174c) {
            this.f5174c = true;
            this.f5175d = this.f5176e.o().getBoolean(this.f5172a, this.f5173b);
        }
        return this.f5175d;
    }
}
