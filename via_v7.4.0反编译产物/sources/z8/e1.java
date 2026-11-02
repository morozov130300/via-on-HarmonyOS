package z8;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final char[] f14689a = new char[1];

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f14690b = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public InputStreamReader f14691c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f14692d = -1;

    /* renamed from: e, reason: collision with root package name */
    public String f14693e = null;

    public static void g(StringBuilder sb2) {
        int length = sb2.length();
        int i10 = 0;
        while (i10 < length && Character.isWhitespace(sb2.charAt(i10))) {
            i10++;
        }
        while (i10 < length && Character.isWhitespace(sb2.charAt(length - 1))) {
            length--;
        }
        sb2.delete(length, sb2.length());
        sb2.delete(0, i10);
    }

    public String a() {
        return this.f14693e;
    }

    public String b(String str) {
        if (this.f14693e != null && str != null && !str.isEmpty() && this.f14693e.length() >= str.length() && this.f14693e.charAt(0) == '<') {
            String str2 = this.f14693e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            Locale locale = Locale.ROOT;
            sb2.append(str.toUpperCase(locale));
            sb2.append("=\"");
            int iIndexOf = str2.indexOf(sb2.toString());
            if (iIndexOf < 0) {
                iIndexOf = this.f14693e.indexOf(" " + str.toLowerCase(locale) + "=\"");
            }
            if (iIndexOf > 0 && this.f14693e.length() > iIndexOf + 1) {
                int length = iIndexOf + str.length() + 3;
                int iIndexOf2 = this.f14693e.indexOf("\" ", length);
                if (iIndexOf2 < 0) {
                    iIndexOf2 = this.f14693e.indexOf("\">", length);
                }
                if (iIndexOf2 > length) {
                    return this.f14693e.substring(length, iIndexOf2).replace("\\\"", "\"");
                }
            }
        }
        return null;
    }

    public final int c(String str) {
        if (str == null || str.isEmpty()) {
            throw new NullPointerException("element == null || element.isEmpty()");
        }
        if (str.charAt(0) == '<' && str.charAt(str.length() - 1) == '>') {
            return str.charAt(1) == '/' ? 3 : 2;
        }
        return 4;
    }

    public int d() {
        if (this.f14692d == -1) {
            this.f14692d = 0;
            return 0;
        }
        while (this.f14691c.read(this.f14689a) != -1) {
            if (this.f14689a[0] == '<' && e()) {
                this.f14690b.append(this.f14689a[0]);
                return this.f14692d;
            }
            this.f14690b.append(this.f14689a[0]);
            if (this.f14689a[0] == '>' && e()) {
                return this.f14692d;
            }
        }
        return 1;
    }

    public final boolean e() {
        char c10;
        g(this.f14690b);
        int length = this.f14690b.length();
        if (length == 0) {
            return false;
        }
        char cCharAt = '<';
        if (this.f14690b.charAt(0) == '<') {
            int i10 = 1;
            while (true) {
                c10 = '-';
                if (i10 >= length || !((cCharAt = this.f14690b.charAt(i10)) == ':' || cCharAt == '!' || cCharAt == '-' || cCharAt == '/' || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= '0' && cCharAt <= '9'))))) {
                    break;
                }
                i10++;
            }
            if (cCharAt == ' ') {
                cCharAt = this.f14690b.charAt(length - 1);
            }
            if (cCharAt != '>') {
                return false;
            }
            int i11 = 0;
            while (i10 < length - 1) {
                char cCharAt2 = this.f14690b.charAt(i10);
                if (cCharAt2 == '\\') {
                    i10++;
                } else if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    if (i11 % 2 == 0) {
                        c10 = cCharAt2;
                    }
                    if (cCharAt2 == c10) {
                        i11++;
                    }
                }
                i10++;
            }
            if (i11 % 2 != 0) {
                return false;
            }
        }
        String string = this.f14690b.toString();
        this.f14693e = string;
        this.f14692d = c(string);
        this.f14690b.delete(0, length);
        return true;
    }

    public void f(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("inputStream == null");
        }
        this.f14691c = new InputStreamReader(inputStream);
        this.f14692d = 0;
    }
}
