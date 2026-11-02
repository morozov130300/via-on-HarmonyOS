package jc;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f7954a = Pattern.compile("[\\\\&]");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f7955b = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f7956c = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f7957d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f7958e = Pattern.compile("[ \t\r\n]+");

    /* renamed from: f, reason: collision with root package name */
    public static final c f7959f = new C0092a();

    /* renamed from: g, reason: collision with root package name */
    public static final c f7960g = new b();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: jc.a$a, reason: collision with other inner class name */
    public static class C0092a implements c {
        @Override // jc.a.c
        public void a(String str, StringBuilder sb2) {
            if (str.charAt(0) == '\\') {
                sb2.append((CharSequence) str, 1, str.length());
            } else {
                sb2.append(jc.b.a(str));
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b implements c {
        @Override // jc.a.c
        public void a(String str, StringBuilder sb2) {
            if (str.startsWith("%")) {
                if (str.length() == 3) {
                    sb2.append(str);
                    return;
                } else {
                    sb2.append("%25");
                    sb2.append((CharSequence) str, 1, str.length());
                    return;
                }
            }
            for (byte b10 : str.getBytes(Charset.forName("UTF-8"))) {
                sb2.append('%');
                sb2.append(a.f7957d[(b10 >> 4) & 15]);
                sb2.append(a.f7957d[b10 & 15]);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        void a(String str, StringBuilder sb2);
    }

    public static String b(String str) {
        return f7958e.matcher(str.trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
    }

    public static String c(String str) {
        return b(str.substring(1, str.length() - 1));
    }

    public static String d(Pattern pattern, String str, c cVar) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 16);
        int iEnd = 0;
        do {
            sb2.append((CharSequence) str, iEnd, matcher.start());
            cVar.a(matcher.group(), sb2);
            iEnd = matcher.end();
        } while (matcher.find());
        if (iEnd != str.length()) {
            sb2.append((CharSequence) str, iEnd, str.length());
        }
        return sb2.toString();
    }

    public static String e(String str) {
        return f7954a.matcher(str).find() ? d(f7955b, str, f7959f) : str;
    }
}
