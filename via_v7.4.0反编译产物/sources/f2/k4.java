package f2;

import android.content.SharedPreferences;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k4 {

    /* renamed from: a, reason: collision with root package name */
    public final String f5411a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5412b;

    /* renamed from: c, reason: collision with root package name */
    public String f5413c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l4 f5414d;

    public k4(l4 l4Var, String str, String str2) {
        this.f5414d = l4Var;
        t1.f.d(str);
        this.f5411a = str;
    }

    public final String a() {
        if (!this.f5412b) {
            this.f5412b = true;
            this.f5413c = this.f5414d.o().getString(this.f5411a, null);
        }
        return this.f5413c;
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.f5414d.o().edit();
        editorEdit.putString(this.f5411a, str);
        editorEdit.apply();
        this.f5413c = str;
    }
}
