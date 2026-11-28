package c6;

import java.util.List;
import org.chromium.support_lib_boundary.ProcessGlobalConfigConstants;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f2100c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2102b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final List a(String str, String str2, boolean z10) {
            List listC = e7.n.c();
            boolean zS = kotlin.text.x.s(str, "CN", true);
            if (zS) {
                listC.add(-2);
            }
            listC.add(-1);
            if (kotlin.text.x.s(str2, "ru", true)) {
                listC.add(-7);
            }
            if (!zS) {
                listC.add(-2);
            }
            listC.add(-3);
            if (zS) {
                if (z10) {
                    listC.add(-12);
                }
                listC.add(-6);
                listC.add(-11);
                listC.add(-4);
                listC.add(-5);
            } else {
                listC.add(-8);
                listC.add(-9);
            }
            listC.add(-10);
            return e7.n.a(listC);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0016  */
        public final int b(String str) {
            boolean z10;
            x xVar = x.f2131a;
            h1 h1VarC = xVar.c();
            if (!xVar.b()) {
                z10 = kotlin.text.x.s(str, "CN", true) ? false : true;
            }
            String strF = z10 ? h1VarC.f() : h1VarC.g();
            int iHashCode = strF.hashCode();
            if (iHashCode == 3138) {
                if (!strF.equals("bd")) {
                }
            }
            if (iHashCode != 3148) {
                if (iHashCode != 3296) {
                    if (iHashCode != 3339) {
                        if (iHashCode != 3495) {
                            if (iHashCode != 3668) {
                                if (iHashCode != 3674) {
                                    if (iHashCode != 3712) {
                                        if (iHashCode == 3855 && strF.equals("yh")) {
                                            return -8;
                                        }
                                    } else if (strF.equals("tt")) {
                                        return -11;
                                    }
                                } else if (strF.equals("sm")) {
                                    return -4;
                                }
                            } else if (strF.equals("sg")) {
                                return -6;
                            }
                        } else if (strF.equals("mt")) {
                            return -12;
                        }
                    } else if (strF.equals("hs")) {
                        return -5;
                    }
                } else if (strF.equals("gg")) {
                    return -1;
                }
            } else if (strF.equals("bn")) {
                return -3;
            }
            return z10 ? -1 : -2;
        }

        public final boolean c(long j10) {
            return j10 > 0 || j10 <= -999;
        }

        public final r1 d(long j10, String str, String str2) {
            int iB;
            if (-12 > j10 || j10 >= 0) {
                iB = (str == null || str.length() == 0) ? b(str2) : -999;
            } else {
                iB = (int) j10;
            }
            return new r1(iB, str, null);
        }

        public final int e(long j10, int i10) {
            if (j10 == -1) {
                return 1;
            }
            if (j10 == -2) {
                return 2;
            }
            if (j10 == -3) {
                return 3;
            }
            if (j10 == -5) {
                return 4;
            }
            return i10;
        }

        public a() {
        }
    }

    public /* synthetic */ r1(int i10, String str, kotlin.jvm.internal.f fVar) {
        this(i10, str);
    }

    public static /* synthetic */ String d(r1 r1Var, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str4 = "";
        }
        return r1Var.c(str, str2, str3, str4);
    }

    public final String a() {
        switch (this.f2101a) {
            case -12:
                return "metaso";
            case -11:
                return "toutiao";
            case -10:
                return "duckduckgo";
            case -9:
                return "startpage";
            case -8:
                return "yahoo";
            case -7:
                return "yandex";
            case -6:
                return "sougou";
            case -5:
                return "haosou";
            case -4:
                return "shenma";
            case -3:
                return "bing";
            case -2:
                return "baidu";
            case ProcessGlobalConfigConstants.UI_THREAD_STARTUP_MODE_DEFAULT /* -1 */:
                return "google";
            default:
                return "unknown";
        }
    }

    public final String b(String pageUrl) {
        kotlin.jvm.internal.h.f(pageUrl, "pageUrl");
        String strE = e(false);
        y1 y1Var = y1.f2139a;
        String strG = y1Var.g(pageUrl, strE);
        if (strG != null && strG.length() != 0) {
            return strG;
        }
        String strE2 = e(true);
        if (kotlin.jvm.internal.h.a(strE2, strE)) {
            return null;
        }
        return y1Var.g(pageUrl, strE2);
    }

    public final String c(String str, String str2, String str3, String str4) {
        if (str3 == null || str3.length() == 0) {
            return str + str2;
        }
        if (a2.f1958a.t(str3)) {
            return str3;
        }
        return str + str4 + str3 + '&' + str2;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    public final String e(boolean z10) {
        String strL;
        String strI;
        h1 h1VarC = x.f2131a.c();
        switch (this.f2101a) {
            case -12:
                return d(this, "https://metaso.cn/?", "q=", h1VarC.j(), null, 8, null);
            case -11:
                return d(this, "https://so.toutiao.com/search?", "keyword=", h1VarC.m(), null, 8, null);
            case -10:
                return "https://duckduckgo.com/?q=";
            case -9:
                return "https://startpage.com/do/search?query=";
            case -8:
                return d(this, "https://search.yahoo.com/search?", "p=", h1VarC.n(), null, 8, null);
            case -7:
                return z10 ? "https://yandex.com/search/?text=" : "https://yandex.com/search/touch/?text=";
            case -6:
                return (z10 && ((strL = h1VarC.l()) == null || strL.length() == 0)) ? "https://www.sogou.com/web?query=" : c("https://wap.sogou.com/web/sl?", "keyword=", h1VarC.l(), "bid=sogou-mobb-");
            case -5:
                return (z10 && ((strI = h1VarC.i()) == null || strI.length() == 0)) ? "https://www.so.com/s?q=" : d(this, "https://m.so.com/s?", "q=", h1VarC.i(), null, 8, null);
            case -4:
                return c("https://yz.m.sm.cn/s?", "q=", h1VarC.k(), "from=");
            case -3:
                return d(this, "https://www.bing.com/search?", "q=", h1VarC.e(), null, 8, null);
            case -2:
                String str = z10 ? "https://www.baidu.com/s?ie=utf-8&" : "https://m.baidu.com/s?";
                String strD = h1VarC.d();
                if (strD == null) {
                    strD = "1022282z";
                } else {
                    if (strD.length() <= 0) {
                        strD = null;
                    }
                    if (strD == null) {
                        strD = "1022282z";
                    }
                }
                return c(str, "word=", strD, "from=");
            case ProcessGlobalConfigConstants.UI_THREAD_STARTUP_MODE_DEFAULT /* -1 */:
                return d(this, "https://www.google.com/search?", "q=", h1VarC.h(), null, 8, null);
            default:
                String str2 = this.f2102b;
                if (str2 != null) {
                    return str2;
                }
                throw new IllegalArgumentException("Required value was null.");
        }
    }

    public r1(int i10, String str) {
        this.f2101a = i10;
        this.f2102b = str;
    }
}
