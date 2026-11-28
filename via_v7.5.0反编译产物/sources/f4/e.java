package f4;

import java.net.URI;
import java.time.Duration;
import java.util.regex.Pattern;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f4465h = Pattern.compile("^[\\d]+$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f4467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f4468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URI f4469d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4471f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public StringBuffer f4470e = new StringBuffer();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4472g = "message";

    public e(URI uri, c cVar, b bVar, l lVar) {
        this.f4466a = cVar;
        this.f4469d = uri;
        this.f4467b = bVar;
        this.f4468c = lVar;
    }

    public final void a() {
        if (this.f4470e.length() == 0) {
            return;
        }
        String string = this.f4470e.toString();
        if (string.endsWith("\n")) {
            string = string.substring(0, string.length() - 1);
        }
        m mVar = new m(string, this.f4471f, this.f4469d);
        this.f4467b.b(this.f4471f);
        try {
            this.f4468c.a("Dispatching message: \"{}\", {}", this.f4472g, mVar);
            this.f4466a.d(this.f4472g, mVar);
        } catch (Exception e10) {
            this.f4468c.d("Message handler threw an exception: " + e10.toString());
            this.f4468c.b("Stack trace: {}", new k(e10));
            this.f4466a.onError(e10);
        }
        this.f4470e = new StringBuffer();
        this.f4472g = "message";
    }

    public final boolean b(String str) {
        return f4465h.matcher(str).matches();
    }

    public void c(String str) {
        this.f4468c.b("Parsing line: {}", str);
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
            this.f4466a.a(str);
        } catch (Exception e10) {
            this.f4466a.onError(e10);
        }
    }

    public final void e(String str, String str2) {
        if ("data".equals(str)) {
            StringBuffer stringBuffer = this.f4470e;
            stringBuffer.append(str2);
            stringBuffer.append("\n");
        } else {
            if (Name.MARK.equals(str)) {
                this.f4471f = str2;
                return;
            }
            if ("event".equals(str)) {
                this.f4472g = str2;
            } else if ("retry".equals(str) && b(str2)) {
                this.f4467b.a(Duration.ofMillis(Long.parseLong(str2)));
            }
        }
    }
}
