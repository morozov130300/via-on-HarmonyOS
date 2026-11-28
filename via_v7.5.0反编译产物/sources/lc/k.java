package lc;

import java.util.regex.Pattern;
import oc.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends qc.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern[][] f7695e = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.l f7696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f7697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public lc.a f7699d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends qc.b {
        @Override // qc.e
        public qc.f a(qc.h hVar, qc.g gVar) {
            int iC = hVar.c();
            CharSequence line = hVar.getLine();
            if (hVar.b() < 4 && line.charAt(iC) == '<') {
                for (int i10 = 1; i10 <= 7; i10++) {
                    if (i10 != 7 || !(gVar.a().f() instanceof v)) {
                        Pattern pattern = k.f7695e[i10][0];
                        Pattern pattern2 = k.f7695e[i10][1];
                        if (pattern.matcher(line.subSequence(iC, line.length())).find()) {
                            return qc.f.d(new k(pattern2)).b(hVar.getIndex());
                        }
                    }
                }
            }
            return qc.f.c();
        }
    }

    @Override // qc.a, qc.d
    public void c() {
        this.f7696a.n(this.f7699d.b());
        this.f7699d = null;
    }

    @Override // qc.d
    public oc.a f() {
        return this.f7696a;
    }

    @Override // qc.d
    public qc.c g(qc.h hVar) {
        if (this.f7698c) {
            return qc.c.d();
        }
        return (hVar.a() && this.f7697b == null) ? qc.c.d() : qc.c.b(hVar.getIndex());
    }

    @Override // qc.a, qc.d
    public void h(CharSequence charSequence) {
        this.f7699d.a(charSequence);
        Pattern pattern = this.f7697b;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.f7698c = true;
    }

    public k(Pattern pattern) {
        this.f7696a = new oc.l();
        this.f7698c = false;
        this.f7699d = new lc.a();
        this.f7697b = pattern;
    }
}
