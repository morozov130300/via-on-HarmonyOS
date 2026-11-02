package i6;

import i6.k0;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c0 f6985a = new c0();

    public static final j7.f h(q7.l lVar, String str, String str2) {
        Integer numB;
        lVar.invoke(Integer.valueOf((str == null || (numB = v7.k.b(str)) == null) ? 0 : numB.intValue()));
        return j7.f.f7594a;
    }

    public static final j7.f k(q7.l lVar, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            if (lVar != null) {
                lVar.invoke(0);
            }
        } else if (lVar != null) {
            lVar.invoke(2);
        }
        return j7.f.f7594a;
    }

    public static final j7.f m(q7.l lVar, String str, String str2) {
        if ((str2 != null && str2.length() != 0) || str == null || str.length() == 0) {
            str = "";
        }
        lVar.invoke(str);
        return j7.f.f7594a;
    }

    public static final j7.f p(q7.l lVar, String str, String str2) {
        if ((str2 != null && str2.length() != 0) || str == null || str.length() == 0) {
            str = "";
        }
        lVar.invoke(str);
        return j7.f.f7594a;
    }

    public static final j7.f r(q7.l lVar, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            if (lVar != null) {
                lVar.invoke(Boolean.TRUE);
            }
        } else if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        return j7.f.f7594a;
    }

    public final void f(k0 k0Var, int i10, int i11, String str) {
        if (k0Var == null) {
            return;
        }
        if (i10 == 0) {
            i10 = -1;
        }
        k0.a.a(k0Var, w.f7050a.c(n(i10, Math.min(84, Math.max(8, i11)), str)), null, 2, null);
    }

    public final void g(k0 k0Var, final q7.l lVar) {
        if (lVar == null || k0Var == null) {
            return;
        }
        if (!k0Var.a()) {
            lVar.invoke(0);
            return;
        }
        String url = k0Var.getUrl();
        if (i0.f7006a.s(url)) {
            k0Var.b(s(url) ? w.f7050a.h() : w.f7050a.i(), new q7.p() { // from class: i6.z
                @Override // q7.p
                public final Object a(Object obj, Object obj2) {
                    return c0.h(lVar, (String) obj, (String) obj2);
                }
            });
        } else {
            lVar.invoke(0);
        }
    }

    public final void i(k0 k0Var, q7.l lVar) {
        if (k0Var == null || !k0Var.a()) {
            if (lVar != null) {
                lVar.invoke(1);
            }
        } else {
            k0.a.a(k0Var, w.f7050a.b(), null, 2, null);
            if (lVar != null) {
                lVar.invoke(0);
            }
        }
    }

    public final void j(k0 k0Var, final q7.l lVar) {
        if (k0Var == null) {
            return;
        }
        if (!k0Var.a()) {
            if (lVar != null) {
                lVar.invoke(1);
                return;
            }
            return;
        }
        if (i0.f7006a.s(k0Var.getUrl())) {
            w wVar = w.f7050a;
            k0.a.a(k0Var, wVar.d("@media print{body{overflow:auto!important}body>*{display:none!important}.via-reader-body{display:block!important;position:static!important}}.via-reader-body{position:fixed;left:0;right:0;top:0;bottom:0;overflow:auto;z-index:2147483647!important;color:#000}.via-reader-body *{background-color:transparent!important}.via-reader-header{text-align:start;margin:0 16px 32px}.via-reader-header>h1{font-size:1.4em;font-weight:700;line-height:1.8;width:100%;padding:32px 0 0;margin:0;text-indent:0!important}.via-reader-header>div{opacity:.8;font-size:.8em}.via-reader-header>div>a{color:#0269c8}.via-reader-content{font-size:1em;line-height:1.2;margin:10px 16px 0;overflow-wrap:break-word}.via-reader-content a,.via-reader-content a:active,.via-reader-content a:hover,.via-reader-content a:visited{color:#0269c8}.via-reader-content h1,.via-reader-content h2,.via-reader-content h3,.via-reader-content h4,.via-reader-content h5{margin-top:16px;margin-bottom:16px;font-weight:700;line-height:1.8}.via-reader-content h1{font-size:1.4em}.via-reader-content h2{font-size:1.2em}.via-reader-content h3{font-size:1.1em}.via-reader-content *{max-width:100%;height:auto}.via-reader-content p{font-size:1em;line-height:1.8;padding:0 0 20px}.via-reader-content .wp-caption,.via-reader-content figure{width:100%;margin:0 0 32px}.via-reader-content .wp-caption img,.via-reader-content figure img,.via-reader-content p>a:only-child>img:only-child,.via-reader-content p>img:only-child{margin-left:auto;margin-right:auto}.via-reader-content .caption,.via-reader-content .wp-caption-text,.via-reader-content figcaption{font-size:.9em;margin:0;padding-top:4px}.via-reader-content code,.via-reader-content pre{white-space:pre-wrap;margin-bottom:3px;font-family:monospace!important}.via-reader-content code{padding:2px 4px;font-size:.9em;background-color:#f9f2f4;border-radius:4px}.via-reader-content pre{padding:9px;font-size:.9em;border:1px solid #ccc;border-radius:4px}.via-reader-content blockquote{margin:0 0 20px;padding:0;padding-inline-start:16px;border:0;border-left:2px solid}.via-reader-content ol,.via-reader-content ul{margin:0 0 20px;padding:0;line-height:1.5}.via-reader-content ul{padding-inline-start:30px;list-style:disc!important}.via-reader-content ol{padding-inline-start:35px;list-style:decimal!important}.via-reader-content img.emoji,.via-reader-content img.wp-smiley{border-width:0;width:1em;margin:0 .07em;padding:0}.via-reader-content table{border-collapse:collapse;border:1px solid hsla(0,0%,50.2%,.5)}.via-reader-content td,.via-reader-content th{border:1px solid hsla(0,0%,50.2%,.5);padding:2px}"), null, 2, null);
            k0Var.b(wVar.j(), new q7.p() { // from class: i6.b0
                @Override // q7.p
                public final Object a(Object obj, Object obj2) {
                    return c0.k(lVar, (String) obj, (String) obj2);
                }
            });
        } else if (lVar != null) {
            lVar.invoke(4);
        }
    }

    public final void l(k0 k0Var, final q7.l lVar) {
        if (k0Var == null || lVar == null) {
            return;
        }
        k0Var.b(w.f7050a.a(), new q7.p() { // from class: i6.y
            @Override // q7.p
            public final Object a(Object obj, Object obj2) {
                return c0.m(lVar, (String) obj, (String) obj2);
            }
        });
    }

    public final String n(int i10, int i11, String str) {
        String strJ;
        g gVar = g.f6992a;
        int i12 = gVar.a(i10) ? -16777216 : -1;
        int iB = gVar.b(i10, -16777216, 0.3f);
        int i13 = gVar.a(iB) ? -16777216 : -1;
        String string = Integer.toString(i10 & 16777215, v7.a.a(16));
        kotlin.jvm.internal.h.e(string, "toString(...)");
        String strE = v7.m.E(string, 6, '0');
        String string2 = Integer.toString(i12 & 16777215, v7.a.a(16));
        kotlin.jvm.internal.h.e(string2, "toString(...)");
        String strE2 = v7.m.E(string2, 6, '0');
        String string3 = Integer.toString(iB & 16777215, v7.a.a(16));
        kotlin.jvm.internal.h.e(string3, "toString(...)");
        String strE3 = v7.m.E(string3, 6, '0');
        String string4 = Integer.toString(16777215 & i13, v7.a.a(16));
        kotlin.jvm.internal.h.e(string4, "toString(...)");
        String strE4 = v7.m.E(string4, 6, '0');
        String strValueOf = String.valueOf(i11);
        if (str == null || (strJ = v7.l.j(str, "\n", "\\n", false, 4, null)) == null) {
            strJ = "";
        }
        return ".via-reader-body,.via-reader-body>div{background-color: #" + strE + " !important;}.via-reader-body {color: #" + strE2 + " !important;font-size: " + strValueOf + "px !important;}@media (prefers-color-scheme: dark) {.via-reader-body,.via-reader-body>div{background-color: #" + strE3 + " !important;}.via-reader-body {color: #" + strE4 + " !important;}}" + strJ;
    }

    public final void o(k0 k0Var, final q7.l lVar) {
        if (k0Var == null || lVar == null) {
            return;
        }
        k0Var.b(w.f7050a.e(), new q7.p() { // from class: i6.x
            @Override // q7.p
            public final Object a(Object obj, Object obj2) {
                return c0.p(lVar, (String) obj, (String) obj2);
            }
        });
    }

    public final void q(k0 k0Var, final q7.l lVar) {
        if (k0Var == null) {
            if (lVar != null) {
                lVar.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (i0.f7006a.s(k0Var.getUrl())) {
            w wVar = w.f7050a;
            k0.a.a(k0Var, wVar.f(), null, 2, null);
            k0Var.b(wVar.g(), new q7.p() { // from class: i6.a0
                @Override // q7.p
                public final Object a(Object obj, Object obj2) {
                    return c0.r(lVar, (String) obj, (String) obj2);
                }
            });
        } else if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
    }

    public final boolean s(String str) {
        String lowerCase;
        if (str != null && str.length() != 0) {
            String strC = i0.f7006a.c(str);
            if (strC != null) {
                lowerCase = strC.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (kotlin.jvm.internal.h.a("js", lowerCase)) {
                return false;
            }
            if ((!v7.m.p(str, ".baidu.com/", false, 2, null) || !v7.m.p(str, "/s?", false, 2, null)) && ((!v7.m.p(str, ".bing.com/", false, 2, null) || !v7.m.p(str, "/search?", false, 2, null)) && ((!v7.m.p(str, ".sogou.com/", false, 2, null) || !v7.m.p(str, "/sl?", false, 2, null)) && ((!v7.m.p(str, ".so.com/", false, 2, null) || !v7.m.p(str, "/s?", false, 2, null)) && ((!v7.m.p(str, ".google.com/", false, 2, null) || !v7.m.p(str, "/search?", false, 2, null)) && ((!v7.m.p(str, ".metaso.cn/", false, 2, null) || !v7.m.p(str, "/search/", false, 2, null)) && !v7.m.p(str, "://tool.lu/", false, 2, null) && !v7.l.f(str, ".user.js", false, 2, null))))))) {
                return false;
            }
        }
        return true;
    }
}
