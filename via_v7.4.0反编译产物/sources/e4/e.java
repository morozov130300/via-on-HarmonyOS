package e4;

import java.net.URI;
import java.time.Duration;
import java.util.regex.Pattern;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f4749h = Pattern.compile("^[\\d]+$");

    /* renamed from: a, reason: collision with root package name */
    public final c f4750a;

    /* renamed from: b, reason: collision with root package name */
    public final b f4751b;

    /* renamed from: c, reason: collision with root package name */
    public final l f4752c;

    /* renamed from: d, reason: collision with root package name */
    public final URI f4753d;

    /* renamed from: f, reason: collision with root package name */
    public String f4755f;

    /* renamed from: e, reason: collision with root package name */
    public StringBuffer f4754e = new StringBuffer();

    /* renamed from: g, reason: collision with root package name */
    public String f4756g = "message";

    public e(URI uri, c cVar, b bVar, l lVar) {
        this.f4750a = cVar;
        this.f4753d = uri;
        this.f4751b = bVar;
        this.f4752c = lVar;
    }

    public final void a() {
        if (this.f4754e.length() == 0) {
            return;
        }
        String string = this.f4754e.toString();
        if (string.endsWith("\n")) {
            string = string.substring(0, string.length() - 1);
        }
        m mVar = new m(string, this.f4755f, this.f4753d);
        this.f4751b.b(this.f4755f);
        try {
            this.f4752c.a("Dispatching message: \"{}\", {}", this.f4756g, mVar);
            this.f4750a.c(this.f4756g, mVar);
        } catch (Exception e10) {
            this.f4752c.d("Message handler threw an exception: " + e10.toString());
            this.f4752c.b("Stack trace: {}", new k(e10));
            this.f4750a.onError(e10);
        }
        this.f4754e = new StringBuffer();
        this.f4756g = "message";
    }

    public final boolean b(String str) {
        return f4749h.matcher(str).matches();
    }

    public void c(String str) {
        this.f4752c.b("Parsing line: {}", str);
        if (str.trim().isEmpty()) {
            a();
            return;
        }
        if (str.startsWith(":")) {
            d(str.substring(1).trim());
            return;
        }
        int iIndexOf = str.indexOf(":");
        if (iIndexOf == -1) {
            e(str.trim(), "");
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (!strSubstring2.isEmpty() && strSubstring2.charAt(0) == ' ') {
            strSubstring2 = strSubstring2.replaceFirst(" ", "");
        }
        e(strSubstring, strSubstring2);
    }

    public final void d(String str) {
        try {
            this.f4750a.a(str);
        } catch (Exception e10) {
            this.f4750a.onError(e10);
        }
    }

    public final void e(String str, String str2) {
        if ("data".equals(str)) {
            StringBuffer stringBuffer = this.f4754e;
            stringBuffer.append(str2);
            stringBuffer.append("\n");
        } else {
            if (Name.MARK.equals(str)) {
                this.f4755f = str2;
                return;
            }
            if ("event".equals(str)) {
                this.f4756g = str2;
            } else if ("retry".equals(str) && b(str2)) {
                this.f4751b.a(Duration.ofMillis(Long.parseLong(str2)));
            }
        }
    }
}
