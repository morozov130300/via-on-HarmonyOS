package c6;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f2009a = new g1();

    public static final d7.h g(p7.l lVar, String str, String str2) {
        Integer numK;
        lVar.invoke(Integer.valueOf((str == null || (numK = kotlin.text.w.k(str)) == null) ? 0 : numK.intValue()));
        return d7.h.f3935a;
    }

    public static final d7.h j(p7.l lVar, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            if (lVar != null) {
                lVar.invoke(0);
            }
        } else if (lVar != null) {
            lVar.invoke(2);
        }
        return d7.h.f3935a;
    }

    public static final d7.h l(p7.l lVar, String str, String str2) {
        if ((str2 != null && str2.length() != 0) || str == null || str.length() == 0) {
            str = "";
        }
        lVar.invoke(str);
        return d7.h.f3935a;
    }

    public static final d7.h p(p7.l lVar, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            if (lVar != null) {
                lVar.invoke(Boolean.TRUE);
            }
        } else if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        return d7.h.f3935a;
    }

    public final void e(c2 c2Var, int i10, int i11, String str) {
        if (c2Var == null) {
            return;
        }
        if (i10 == 0) {
            i10 = -1;
        }
        c2.a.a(c2Var, b1.f1962a.c(m(i10, Math.min(84, Math.max(8, i11)), str)), null, 2, null);
    }

    public final void f(c2 c2Var, final p7.l lVar) {
        if (lVar == null || c2Var == null) {
            return;
        }
        if (!c2Var.isJavaScriptEnabled()) {
            lVar.invoke(0);
            return;
        }
        String url = c2Var.getUrl();
        if (a2.f1958a.t(url)) {
            c2Var.a(q(url) ? b1.f1962a.h() : b1.f1962a.i(), new p7.p() { // from class: c6.e1
                @Override // p7.p
                public final Object invoke(Object obj, Object obj2) {
                    return g1.g(lVar, (String) obj, (String) obj2);
                }
            });
        } else {
            lVar.invoke(0);
        }
    }

    public final void h(c2 c2Var, p7.l lVar) {
        if (c2Var == null || !c2Var.isJavaScriptEnabled()) {
            if (lVar != null) {
                lVar.invoke(1);
            }
        } else {
            c2.a.a(c2Var, b1.f1962a.b(), null, 2, null);
            if (lVar != null) {
                lVar.invoke(0);
            }
        }
    }

    public final void i(c2 c2Var, final p7.l lVar) {
        if (c2Var == null) {
            return;
        }
        if (!c2Var.isJavaScriptEnabled()) {
            if (lVar != null) {
                lVar.invoke(1);
                return;
            }
            return;
        }
        if (a2.f1958a.t(c2Var.getUrl())) {
            b1 b1Var = b1.f1962a;
            c2.a.a(c2Var, b1Var.d("@media print{body{overflow:auto!important}body>*{display:none!important}.via-reader-body{display:block!important;position:static!important}}.via-reader-body{position:fixed;left:0;right:0;top:0;bottom:0;overflow:auto;z-index:2147483647!important;color:#000}.via-reader-body *{background-color:transparent!important}.via-reader-header{text-align:start;margin:0 16px 32px}.via-reader-header>h1{font-size:1.4em;font-weight:700;line-height:1.8;width:100%;padding:32px 0 0;margin:0;text-indent:0!important}.via-reader-header>div{opacity:.8;font-size:.8em}.via-reader-header>div>a{color:#0269c8}.via-reader-content{font-size:1em;line-height:1.2;margin:10px 16px 0;overflow-wrap:break-word}.via-reader-content a,.via-reader-content a:active,.via-reader-content a:hover,.via-reader-content a:visited{color:#0269c8}.via-reader-content h1,.via-reader-content h2,.via-reader-content h3,.via-reader-content h4,.via-reader-content h5{margin-top:16px;margin-bottom:16px;font-weight:700;line-height:1.8}.via-reader-content h1{font-size:1.4em}.via-reader-content h2{font-size:1.2em}.via-reader-content h3{font-size:1.1em}.via-reader-content *{max-width:100%;height:auto}.via-reader-content p{font-size:1em;line-height:1.8;padding:0 0 20px}.via-reader-content .wp-caption,.via-reader-content figure{width:100%;margin:0 0 32px}.via-reader-content .wp-caption img,.via-reader-content figure img,.via-reader-content p>a:only-child>img:only-child,.via-reader-content p>img:only-child{margin-left:auto;margin-right:auto}.via-reader-content .caption,.via-reader-content .wp-caption-text,.via-reader-content figcaption{font-size:.9em;margin:0;padding-top:4px}.via-reader-content code,.via-reader-content pre{white-space:pre-wrap;margin-bottom:3px;font-family:monospace!important}.via-reader-content code{padding:2px 4px;font-size:.9em;background-color:#f9f2f4;border-radius:4px}.via-reader-content pre{padding:9px;font-size:.9em;border:1px solid #ccc;border-radius:4px}.via-reader-content blockquote{margin:0 0 20px;padding:0;padding-inline-start:16px;border:0;border-left:2px solid}.via-reader-content ol,.via-reader-content ul{margin:0 0 20px;padding:0;line-height:1.5}.via-reader-content ul{padding-inline-start:30px;list-style:disc!important}.via-reader-content ol{padding-inline-start:35px;list-style:decimal!important}.via-reader-content img.emoji,.via-reader-content img.wp-smiley{border-width:0;width:1em;margin:0 .07em;padding:0}.via-reader-content table{border-collapse:collapse;border:1px solid hsla(0,0%,50.2%,.5)}.via-reader-content td,.via-reader-content th{border:1px solid hsla(0,0%,50.2%,.5);padding:2px}"), null, 2, null);
            c2Var.a(b1Var.j(), new p7.p() { // from class: c6.d1
                @Override // p7.p
                public final Object invoke(Object obj, Object obj2) {
                    return g1.j(lVar, (String) obj, (String) obj2);
                }
            });
        } else if (lVar != null) {
            lVar.invoke(4);
        }
    }

    public final void k(c2 c2Var, final p7.l lVar) {
        if (c2Var == null || lVar == null) {
            return;
        }
        c2Var.a(b1.f1962a.a(), new p7.p() { // from class: c6.c1
            @Override // p7.p
            public final Object invoke(Object obj, Object obj2) {
                return g1.l(lVar, (String) obj, (String) obj2);
            }
        });
    }

    public final String m(int i10, int i11, String str) {
        String strZ;
        y yVar = y.f2138a;
        int i12 = yVar.a(i10) ? -16777216 : -1;
        int iB = i10 == -1 ? -16777216 : yVar.b(i10, -16777216, 0.3f);
        int i13 = yVar.a(iB) ? -16777216 : -1;
        String string = Integer.toString(i10 & 16777215, kotlin.text.a.a(16));
        kotlin.jvm.internal.h.e(string, "toString(...)");
        String strE0 = kotlin.text.z.e0(string, 6, '0');
        String string2 = Integer.toString(i12 & 16777215, kotlin.text.a.a(16));
        kotlin.jvm.internal.h.e(string2, "toString(...)");
        String strE1 = kotlin.text.z.e0(string2, 6, '0');
        String string3 = Integer.toString(iB & 16777215, kotlin.text.a.a(16));
        kotlin.jvm.internal.h.e(string3, "toString(...)");
        String strE2 = kotlin.text.z.e0(string3, 6, '0');
        String string4 = Integer.toString(16777215 & i13, kotlin.text.a.a(16));
        kotlin.jvm.internal.h.e(string4, "toString(...)");
        String strE3 = kotlin.text.z.e0(string4, 6, '0');
        String strValueOf = String.valueOf(i11);
        if (str == null || (strZ = kotlin.text.x.z(str, "\n", "\\n", false, 4, null)) == null) {
            strZ = "";
        }
        return ".via-reader-body,.via-reader-body>div{background-color: #" + strE0 + " !important;}.via-reader-body {color: #" + strE1 + " !important;font-size: " + strValueOf + "px !important;}@media (prefers-color-scheme: dark) {.via-reader-body,.via-reader-body>div{background-color: #" + strE2 + " !important;}.via-reader-body {color: #" + strE3 + " !important;}}" + strZ;
    }

    public final String n(boolean z10) {
        return b1.f1962a.e(String.valueOf(z10));
    }

    public final void o(c2 c2Var, final p7.l lVar) {
        if (c2Var == null) {
            if (lVar != null) {
                lVar.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (a2.f1958a.t(c2Var.getUrl())) {
            b1 b1Var = b1.f1962a;
            c2.a.a(c2Var, b1Var.f(), null, 2, null);
            c2Var.a(b1Var.g(), new p7.p() { // from class: c6.f1
                @Override // p7.p
                public final Object invoke(Object obj, Object obj2) {
                    return g1.p(lVar, (String) obj, (String) obj2);
                }
            });
        } else if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
    }

    public final boolean q(String str) {
        String lowerCase;
        if (str != null && str.length() != 0) {
            String strD = a2.f1958a.d(str);
            if (strD != null) {
                lowerCase = strD.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (kotlin.jvm.internal.h.a("js", lowerCase)) {
                return false;
            }
            if ((!kotlin.text.z.I(str, ".baidu.com/", false, 2, null) || !kotlin.text.z.I(str, "/s?", false, 2, null)) && ((!kotlin.text.z.I(str, ".bing.com/", false, 2, null) || !kotlin.text.z.I(str, "/search?", false, 2, null)) && ((!kotlin.text.z.I(str, ".sogou.com/", false, 2, null) || !kotlin.text.z.I(str, "/sl?", false, 2, null)) && ((!kotlin.text.z.I(str, ".so.com/", false, 2, null) || !kotlin.text.z.I(str, "/s?", false, 2, null)) && ((!kotlin.text.z.I(str, ".google.com/", false, 2, null) || !kotlin.text.z.I(str, "/search?", false, 2, null)) && ((!kotlin.text.z.I(str, ".metaso.cn/", false, 2, null) || !kotlin.text.z.I(str, "/search/", false, 2, null)) && !kotlin.text.z.I(str, "://tool.lu/", false, 2, null) && !kotlin.text.x.r(str, ".user.js", false, 2, null))))))) {
                return false;
            }
        }
        return true;
    }
}
