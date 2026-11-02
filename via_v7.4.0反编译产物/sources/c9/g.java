package c9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public String f2992a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f2993b;

    public g(String str, CharSequence charSequence) {
        this.f2992a = str;
        this.f2993b = charSequence;
    }

    @Override // c9.a0
    public CharSequence a() {
        return this.f2993b;
    }

    public void b(CharSequence charSequence) {
        this.f2993b = charSequence;
    }

    @Override // c9.a0
    public String getId() {
        return this.f2992a;
    }
}
