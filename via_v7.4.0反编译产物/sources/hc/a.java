package hc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public int f6869b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f6868a = new StringBuilder();

    public void a(CharSequence charSequence) {
        if (this.f6869b != 0) {
            this.f6868a.append('\n');
        }
        this.f6868a.append(charSequence);
        this.f6869b++;
    }

    public String b() {
        return this.f6868a.toString();
    }
}
