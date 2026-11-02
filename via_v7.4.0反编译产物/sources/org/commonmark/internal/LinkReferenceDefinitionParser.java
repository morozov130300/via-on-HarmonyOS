package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import jc.c;
import jc.d;
import kc.q;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class LinkReferenceDefinitionParser {

    /* renamed from: d, reason: collision with root package name */
    public StringBuilder f10879d;

    /* renamed from: e, reason: collision with root package name */
    public String f10880e;

    /* renamed from: f, reason: collision with root package name */
    public String f10881f;

    /* renamed from: g, reason: collision with root package name */
    public char f10882g;

    /* renamed from: h, reason: collision with root package name */
    public StringBuilder f10883h;

    /* renamed from: a, reason: collision with root package name */
    public State f10876a = State.START_DEFINITION;

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f10877b = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public final List f10878c = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public boolean f10884i = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10886a;

        static {
            int[] iArr = new int[State.values().length];
            f10886a = iArr;
            try {
                iArr[State.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10886a[State.START_DEFINITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10886a[State.LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10886a[State.DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10886a[State.START_TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10886a[State.TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public final int a(CharSequence charSequence, int i10) {
        int iM = d.m(charSequence, i10, charSequence.length());
        int iA = c.a(charSequence, iM);
        if (iA == -1) {
            return -1;
        }
        this.f10881f = charSequence.charAt(iM) == '<' ? charSequence.subSequence(iM + 1, iA - 1).toString() : charSequence.subSequence(iM, iA).toString();
        int iM2 = d.m(charSequence, iA, charSequence.length());
        if (iM2 >= charSequence.length()) {
            this.f10884i = true;
            this.f10877b.setLength(0);
        } else if (iM2 == iA) {
            return -1;
        }
        this.f10876a = State.START_TITLE;
        return iM2;
    }

    public final void b() {
        if (this.f10884i) {
            String strE = jc.a.e(this.f10881f);
            StringBuilder sb2 = this.f10883h;
            this.f10878c.add(new q(this.f10880e, strE, sb2 != null ? jc.a.e(sb2.toString()) : null));
            this.f10879d = null;
            this.f10884i = false;
            this.f10880e = null;
            this.f10881f = null;
            this.f10883h = null;
        }
    }

    public List c() {
        b();
        return this.f10878c;
    }

    public CharSequence d() {
        return this.f10877b;
    }

    public final int e(CharSequence charSequence, int i10) {
        int i11;
        int iC = c.c(charSequence, i10);
        if (iC == -1) {
            return -1;
        }
        this.f10879d.append(charSequence, i10, iC);
        if (iC >= charSequence.length()) {
            this.f10879d.append('\n');
            return iC;
        }
        if (charSequence.charAt(iC) != ']' || (i11 = iC + 1) >= charSequence.length() || charSequence.charAt(i11) != ':' || this.f10879d.length() > 999) {
            return -1;
        }
        String strB = jc.a.b(this.f10879d.toString());
        if (strB.isEmpty()) {
            return -1;
        }
        this.f10880e = strB;
        this.f10876a = State.DESTINATION;
        return d.m(charSequence, iC + 2, charSequence.length());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[LOOP:0: B:6:0x0015->B:23:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(CharSequence charSequence) {
        if (this.f10877b.length() != 0) {
            this.f10877b.append('\n');
        }
        this.f10877b.append(charSequence);
        int iG = 0;
        while (iG < charSequence.length()) {
            switch (a.f10886a[this.f10876a.ordinal()]) {
                case 1:
                    return;
                case 2:
                    iG = g(charSequence, iG);
                    if (iG != -1) {
                        this.f10876a = State.PARAGRAPH;
                        return;
                    }
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    iG = e(charSequence, iG);
                    if (iG != -1) {
                    }
                    break;
                case 4:
                    iG = a(charSequence, iG);
                    if (iG != -1) {
                    }
                    break;
                case 5:
                    iG = h(charSequence, iG);
                    if (iG != -1) {
                    }
                    break;
                case 6:
                    iG = i(charSequence, iG);
                    if (iG != -1) {
                    }
                    break;
                default:
                    if (iG != -1) {
                    }
                    break;
            }
        }
    }

    public final int g(CharSequence charSequence, int i10) {
        int iM = d.m(charSequence, i10, charSequence.length());
        if (iM >= charSequence.length() || charSequence.charAt(iM) != '[') {
            return -1;
        }
        this.f10876a = State.LABEL;
        this.f10879d = new StringBuilder();
        int i11 = iM + 1;
        if (i11 >= charSequence.length()) {
            this.f10879d.append('\n');
        }
        return i11;
    }

    public final int h(CharSequence charSequence, int i10) {
        int iM = d.m(charSequence, i10, charSequence.length());
        if (iM >= charSequence.length()) {
            this.f10876a = State.START_DEFINITION;
            return iM;
        }
        this.f10882g = (char) 0;
        char cCharAt = charSequence.charAt(iM);
        if (cCharAt == '\"' || cCharAt == '\'') {
            this.f10882g = cCharAt;
        } else if (cCharAt == '(') {
            this.f10882g = ')';
        }
        if (this.f10882g == 0) {
            b();
            this.f10876a = State.START_DEFINITION;
            return iM;
        }
        this.f10876a = State.TITLE;
        this.f10883h = new StringBuilder();
        int i11 = iM + 1;
        if (i11 == charSequence.length()) {
            this.f10883h.append('\n');
        }
        return i11;
    }

    public final int i(CharSequence charSequence, int i10) {
        int iE = c.e(charSequence, i10, this.f10882g);
        if (iE == -1) {
            return -1;
        }
        this.f10883h.append(charSequence.subSequence(i10, iE));
        if (iE >= charSequence.length()) {
            this.f10883h.append('\n');
            return iE;
        }
        int iM = d.m(charSequence, iE + 1, charSequence.length());
        if (iM != charSequence.length()) {
            return -1;
        }
        this.f10884i = true;
        b();
        this.f10877b.setLength(0);
        this.f10876a = State.START_DEFINITION;
        return iM;
    }
}
