package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import nc.c;
import nc.d;
import oc.q;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class LinkReferenceDefinitionParser {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuilder f11501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f11502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f11504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public StringBuilder f11505h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f11498a = State.START_DEFINITION;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f11499b = new StringBuilder();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f11500c = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11506i = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11508a;

        static {
            int[] iArr = new int[State.values().length];
            f11508a = iArr;
            try {
                iArr[State.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11508a[State.START_DEFINITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11508a[State.LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11508a[State.DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11508a[State.START_TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11508a[State.TITLE.ordinal()] = 6;
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
        this.f11503f = charSequence.charAt(iM) == '<' ? charSequence.subSequence(iM + 1, iA - 1).toString() : charSequence.subSequence(iM, iA).toString();
        int iM2 = d.m(charSequence, iA, charSequence.length());
        if (iM2 >= charSequence.length()) {
            this.f11506i = true;
            this.f11499b.setLength(0);
        } else if (iM2 == iA) {
            return -1;
        }
        this.f11498a = State.START_TITLE;
        return iM2;
    }

    public final void b() {
        if (this.f11506i) {
            String strE = nc.a.e(this.f11503f);
            StringBuilder sb2 = this.f11505h;
            this.f11500c.add(new q(this.f11502e, strE, sb2 != null ? nc.a.e(sb2.toString()) : null));
            this.f11501d = null;
            this.f11506i = false;
            this.f11502e = null;
            this.f11503f = null;
            this.f11505h = null;
        }
    }

    public List c() {
        b();
        return this.f11500c;
    }

    public CharSequence d() {
        return this.f11499b;
    }

    public final int e(CharSequence charSequence, int i10) {
        int i11;
        int iC = c.c(charSequence, i10);
        if (iC == -1) {
            return -1;
        }
        this.f11501d.append(charSequence, i10, iC);
        if (iC >= charSequence.length()) {
            this.f11501d.append('\n');
            return iC;
        }
        if (charSequence.charAt(iC) != ']' || (i11 = iC + 1) >= charSequence.length() || charSequence.charAt(i11) != ':' || this.f11501d.length() > 999) {
            return -1;
        }
        String strB = nc.a.b(this.f11501d.toString());
        if (strB.isEmpty()) {
            return -1;
        }
        this.f11502e = strB;
        this.f11498a = State.DESTINATION;
        return d.m(charSequence, iC + 2, charSequence.length());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:? A[LOOP:0: B:6:0x0015->B:23:?, LOOP_END, SYNTHETIC] */
    public void f(CharSequence charSequence) {
        if (this.f11499b.length() != 0) {
            this.f11499b.append('\n');
        }
        this.f11499b.append(charSequence);
        int iG = 0;
        while (iG < charSequence.length()) {
            switch (a.f11508a[this.f11498a.ordinal()]) {
                case 1:
                    return;
                case 2:
                    iG = g(charSequence, iG);
                    if (iG == -1) {
                        this.f11498a = State.PARAGRAPH;
                        return;
                    }
                    break;
                case 3:
                    iG = e(charSequence, iG);
                    if (iG == -1) {
                        this.f11498a = State.PARAGRAPH;
                        return;
                    }
                    break;
                case 4:
                    iG = a(charSequence, iG);
                    if (iG == -1) {
                        this.f11498a = State.PARAGRAPH;
                        return;
                    }
                    break;
                case 5:
                    iG = h(charSequence, iG);
                    if (iG == -1) {
                        this.f11498a = State.PARAGRAPH;
                        return;
                    }
                    break;
                case 6:
                    iG = i(charSequence, iG);
                    if (iG == -1) {
                        this.f11498a = State.PARAGRAPH;
                        return;
                    }
                    break;
                default:
                    if (iG == -1) {
                        this.f11498a = State.PARAGRAPH;
                        return;
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
        this.f11498a = State.LABEL;
        this.f11501d = new StringBuilder();
        int i11 = iM + 1;
        if (i11 >= charSequence.length()) {
            this.f11501d.append('\n');
        }
        return i11;
    }

    public final int h(CharSequence charSequence, int i10) {
        int iM = d.m(charSequence, i10, charSequence.length());
        if (iM >= charSequence.length()) {
            this.f11498a = State.START_DEFINITION;
            return iM;
        }
        this.f11504g = (char) 0;
        char cCharAt = charSequence.charAt(iM);
        if (cCharAt == '\"' || cCharAt == '\'') {
            this.f11504g = cCharAt;
        } else if (cCharAt == '(') {
            this.f11504g = ')';
        }
        if (this.f11504g == 0) {
            b();
            this.f11498a = State.START_DEFINITION;
            return iM;
        }
        this.f11498a = State.TITLE;
        this.f11505h = new StringBuilder();
        int i11 = iM + 1;
        if (i11 == charSequence.length()) {
            this.f11505h.append('\n');
        }
        return i11;
    }

    public final int i(CharSequence charSequence, int i10) {
        int iE = c.e(charSequence, i10, this.f11504g);
        if (iE == -1) {
            return -1;
        }
        this.f11505h.append(charSequence.subSequence(i10, iE));
        if (iE >= charSequence.length()) {
            this.f11505h.append('\n');
            return iE;
        }
        int iM = d.m(charSequence, iE + 1, charSequence.length());
        if (iM != charSequence.length()) {
            return -1;
        }
        this.f11506i = true;
        b();
        this.f11499b.setLength(0);
        this.f11498a = State.START_DEFINITION;
        return iM;
    }
}
