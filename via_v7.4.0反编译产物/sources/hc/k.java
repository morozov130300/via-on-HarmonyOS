package hc;

import java.util.regex.Pattern;
import kc.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends mc.a {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern[][] f6917e = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};

    /* renamed from: a, reason: collision with root package name */
    public final kc.l f6918a;

    /* renamed from: b, reason: collision with root package name */
    public final Pattern f6919b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6920c;

    /* renamed from: d, reason: collision with root package name */
    public hc.a f6921d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends mc.b {
        @Override // mc.e
        public mc.f a(mc.h hVar, mc.g gVar) {
            int iC = hVar.c();
            CharSequence line = hVar.getLine();
            if (hVar.b() < 4 && line.charAt(iC) == '<') {
                for (int i10 = 1; i10 <= 7; i10++) {
                    if (i10 != 7 || !(gVar.a().e() instanceof v)) {
                        Pattern pattern = k.f6917e[i10][0];
                        Pattern pattern2 = k.f6917e[i10][1];
                        if (pattern.matcher(line.subSequence(iC, line.length())).find()) {
                            return mc.f.d(new k(pattern2)).b(hVar.getIndex());
                        }
                    }
                }
            }
            return mc.f.c();
        }
    }

    public k(Pattern pattern) {
        this.f6918a = new kc.l();
        this.f6920c = false;
        this.f6921d = new hc.a();
        this.f6919b = pattern;
    }

    @Override // mc.a, mc.d
    public void b() {
        this.f6918a.n(this.f6921d.b());
        this.f6921d = null;
    }

    @Override // mc.d
    public kc.a e() {
        return this.f6918a;
    }

    @Override // mc.d
    public mc.c g(mc.h hVar) {
        return this.f6920c ? mc.c.d() : (hVar.a() && this.f6919b == null) ? mc.c.d() : mc.c.b(hVar.getIndex());
    }

    @Override // mc.a, mc.d
    public void h(CharSequence charSequence) {
        this.f6921d.a(charSequence);
        Pattern pattern = this.f6919b;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.f6920c = true;
    }
}
