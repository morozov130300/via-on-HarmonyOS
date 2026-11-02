package u9;

import android.content.Context;
import android.text.TextUtils;
import g6.l;
import g6.y;
import pa.r;
import x7.u;
import z8.c0;
import z8.f;
import z8.v0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static String a(Context context) {
        String str;
        String str2;
        boolean zB = l.b(context);
        aa.c cVarY = r.j().y();
        if (c0.h() && zB) {
            str = "<h1>" + context.getString(u.I3) + "</h1><p>" + "\u6211\u4eec\u5229\u7528\u6709\u9650\u7684\u4e1a\u4f59\u65f6\u95f4\u8bbe\u8ba1\u4e86 Via\uff0c\u867d\u7136\u5b83\u5e76\u4e0d\u90a3\u4e48\u7f8e\u597d\uff0c\u4f46\u6b63\u52aa\u529b\u524d\u884c\u3002\n\u5982\u679c\u4f60\u559c\u6b22\u6211\u4eec\u7684\u4f5c\u54c1\uff0c\u53ef\u4ee5\u6350\u8d60\u6765\u652f\u6301\u6211\u4eec\u3002\n\n\u6240\u6709\u7684\u6350\u8d60\u90fd\u5c06\u7528\u6765\uff1a\u63d0\u5347\u6211\u4eec\u7684\u73af\u5883\u914d\u7f6e\u4ee5\u53ca\u79ef\u6781\u6027\u3002\n\n\u652f\u4ed8\u5b9d: 2376688759@qq.com\nPayPal: wiar1824@gmail.com".replace("\n", "</p><p>") + "</p>";
        } else {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<h1>");
        sb2.append(context.getString(u.T5));
        sb2.append("</h1><p>");
        sb2.append(f.c().replace("\n", "</p><p>"));
        sb2.append("</p><h1>");
        sb2.append(context.getString(u.f14205w2));
        sb2.append("</h1>");
        if (c0.k()) {
            str2 = "<p><a href=\"http://viayoo.com/\">" + context.getString(u.f13910a9) + "</a></p>";
        } else {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append(zB ? "<p><a href=\"http://viayoo.com/contact/qqgroup/\">\u5b98\u65b9\u9e45\u7fa4</a></p>" : "");
        sb2.append("<p><a href=\"https://t.me/viatg\">Telegram</a></p><p><a href=\"https://github.com/tuyafeng/Via\">");
        sb2.append(context.getString(u.f13963e6));
        sb2.append("</a></p><p><a href=\"");
        sb2.append(cVarY.e());
        sb2.append("\">");
        sb2.append(context.getString(u.Cf));
        sb2.append("</a></p><p><a href=\"");
        sb2.append(cVarY.b());
        sb2.append("\">");
        sb2.append(context.getString(u.Aa));
        sb2.append("</a></p>");
        sb2.append(str);
        sb2.append("<br><br><br>");
        return sb2.toString();
    }

    public static String b(String str, String str2, String str3) {
        String str4 = "";
        String strReplaceAll = str2.replaceAll("<.*?>", "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<div class=\"box\">");
        if (!TextUtils.isEmpty(str3)) {
            str4 = "<div class=\"icon_handle\"><div class=\"" + str3 + " icon\"></div></div>";
        }
        sb2.append(str4);
        sb2.append("<a href=\"");
        sb2.append(v0.c(str));
        sb2.append("\" title=\"");
        sb2.append(strReplaceAll);
        sb2.append("\"></a><p class=\"title\">");
        sb2.append(strReplaceAll);
        sb2.append("</p></div>");
        return sb2.toString();
    }

    public static String c(String str, String str2, boolean z10, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<div class=\"box");
        String str4 = "";
        sb2.append(z10 ? " block" : "");
        sb2.append("\"><a href=\"");
        sb2.append(str);
        sb2.append("\" title=\"");
        sb2.append(str);
        sb2.append("\"></a><p class=\"title\">");
        sb2.append(str3);
        sb2.append("<font class=\"tag\">");
        sb2.append(z10 ? "block" : "load");
        sb2.append("</font>");
        if (!str2.isEmpty()) {
            str4 = "<font class=\"res tag\">" + str2 + "</font>";
        }
        sb2.append(str4);
        sb2.append("</p><p class=\"url\">");
        sb2.append(str);
        sb2.append("</p></div>");
        return sb2.toString();
    }

    public static int d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String str2 = "file://" + context.getFilesDir().getPath() + "/";
        if (!str.startsWith(str2)) {
            return -1;
        }
        String strSubstring = str.substring(str2.length());
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf > 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        int iIndexOf2 = strSubstring.indexOf(35);
        if (iIndexOf2 > 0) {
            strSubstring = strSubstring.substring(0, iIndexOf2);
        }
        if ("homepage.html".equals(strSubstring) || "homepage2.html".equals(strSubstring)) {
            return 1;
        }
        if ("bookmarks.html".equals(strSubstring)) {
            return 2;
        }
        if ("folder.html".equals(strSubstring)) {
            return 11;
        }
        if ("history.html".equals(strSubstring)) {
            return 3;
        }
        if ("catalog.html".equals(strSubstring)) {
            return 5;
        }
        if ("log.html".equals(strSubstring)) {
            return 6;
        }
        if ("res.html".equals(strSubstring)) {
            return 10;
        }
        if ("save.html".equals(strSubstring)) {
            return 7;
        }
        if ("about.html".equals(strSubstring)) {
            return 4;
        }
        if ("blank.html".equals(strSubstring)) {
            return 12;
        }
        return "images.html".equals(strSubstring) ? 13 : -1;
    }

    public static String e(String str) {
        return "<div class='hint'>" + str.replace("\n", "<br>") + "</div>";
    }

    public static String f(String str) {
        return "<script type=\"text/javascript\">" + str + "</script>";
    }

    public static String g(Context context, int i10) {
        boolean zD = l.d(context);
        w9.l lVarJ = r.j();
        i9.a aVarM2 = lVarJ.M2();
        boolean zD2 = lVarJ.d();
        boolean z10 = false;
        if (!aVarM2.c() ? !y.C(lVarJ.c0()) : !aVarM2.d()) {
            z10 = true;
        }
        String strC = lVarJ.c();
        if (strC != null) {
            strC.isEmpty();
        }
        String str = (zD2 || z10) ? "#fafafa" : "#1b1b1b";
        String str2 = (zD2 || z10) ? "#d5d5d5" : "#2b2b2b";
        String str3 = (zD2 || z10) ? "#e9e9e9" : "#313131";
        if (!zD2) {
            y.g(lVarJ.c0());
        }
        String str4 = "color: " + str + ";";
        String str5 = "color: " + str2 + ";";
        String str6 = "color: " + str3 + ";";
        String str7 = (zD2 || z10) ? "rgba(255, 255, 255, 0.1)" : "rgba(0, 0, 0, 0.1)";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("* {padding:0;margin:0;box-sizing:border-box;}");
        sb2.append("html{height:100%;-webkit-tap-highlight-color:");
        sb2.append(str7);
        sb2.append(";-webkit-focus-ring-color: rgba(0, 0, 0, 0);}");
        sb2.append("body{min-height:100%;");
        sb2.append("max-width:100%; width: 600px;margin: auto;text-align: center;}");
        if (zD) {
            sb2.append("html{direction:rtl;}");
        }
        sb2.append("body{");
        sb2.append("background: transparent;");
        sb2.append("}");
        if (i10 == 1) {
            sb2.append("#content {text-align:left;}");
            sb2.append(".box {vertical-align:middle;position:relative;display: block;padding: 20px 14px;border-bottom: 0px solid ");
            sb2.append(str7);
            sb2.append("}");
            sb2.append(".box a {width: 100%;height: 100%;position: absolute;left: 0;top: 0;}");
            sb2.append(".title {padding-left: 28px;");
            sb2.append(str4);
            sb2.append("font-size: 15px;");
            sb2.append("white-space: nowrap; overflow: hidden;");
            sb2.append("text-overflow: ellipsis;");
            sb2.append("margin:auto;}");
            sb2.append(".url {display: none;}");
            sb2.append(".hint {");
            sb2.append(str5);
            sb2.append("font-size: 15px;");
            sb2.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
            sb2.append("text-overflow: ellipsis;");
            sb2.append("padding: 50px 5px;text-align: center;margin: auto; line-height: 1.8em;}");
            sb2.append(".tag.icon {");
            sb2.append(str6);
            sb2.append(" position: absolute; margin-left: 3px; margin-top: 5px; width: 7px; height: 7px; border-radius: 1px 1px 1px 0; border-left: solid 1px currentColor; border-top: solid 1px currentColor; } .tag.icon:before {content: ''; position: absolute; left: 1px; top: 1px; width: 9px; height: 10px; border-radius: 1px; border-left: solid 1px currentColor; border-right: solid 1px currentColor; border-bottom: solid 1px currentColor; -webkit-transform: rotate(-45deg); transform: rotate(-45deg); } .tag.icon:after {content: ''; position: absolute; left: 3px; top: 3px; width: 2px; height: 2px; border-radius: 50%; background-color: currentColor; }");
            sb2.append(".icon_handle {width:50px;/*height:100%;position:absolute;top:0;left:0;*/ z-index: 999; }");
            sb2.append(".bookmark.icon{");
            sb2.append(str6);
            sb2.append("position:absolute;margin-left:5px;margin-top:3px;width:12px;height:15px;border-radius:1px 1px 0 0;border-top:solid 1px currentColor;border-left:solid 1px currentColor;border-right:solid 1px currentColor}.bookmark.icon:before{content:'';position:absolute;top:10px;left:1px;width:7px;height:7px;border-top:solid 1px currentColor;border-left:solid 1px currentColor;-webkit-transform:rotate(45deg);transform:rotate(45deg)}");
            sb2.append(".clock.icon {");
            sb2.append(str6);
            sb2.append(" position: absolute; margin-left: 1px; margin-top: 5px; width: 15px; height: 15px; border: solid 1px currentColor; border-radius: 8px;} .clock.icon:before {content: ''; position: absolute; top: 7px; left: 6.5px; width: 4.5px; height: 1px; background-color: currentColor; -webkit-transform-origin: 0% 0%; transform-origin: 0% 0%; transform:rotate(45deg);} .clock.icon:after {content: ''; position: absolute; top: 2px; left: 5.8px; width: 1px; height: 6px; background-color: currentColor; -webkit-transform-origin: 0% 0%; transform-origin: 0% 0%;}");
            sb2.append(".btn {padding: 12px 20px; color: #ffffff; border-radius: 2px; border: 0; outline: none;");
            sb2.append("font-size: 15px;");
            sb2.append("; margin: 10px;}");
            sb2.append(".sort-ghost {opacity: 0.3;}");
            if (zD) {
                sb2.append("#content {text-align: right;}.title{padding-left:0px;padding-right: 28px;}");
            }
        } else if (i10 == 5) {
            sb2.append("div{");
            sb2.append(str4);
            sb2.append("max-width:800px; padding-left:5%; padding-right:5%; text-align:left;}");
            sb2.append("div>h1{");
            sb2.append("font-size: 20px;");
            sb2.append(" padding-top:55px; padding-bottom:45px; text-align: left; }");
            sb2.append("div>p{ text-align: left; line-height: 1.8em; text-indent:2em;");
            sb2.append("font-size: 15px;");
            sb2.append("}");
            sb2.append("a{color: #6f8de1; ");
            sb2.append("font-size: 15px;");
            sb2.append(" line-height: 1.8em; text-decoration:none; }");
            if (zD) {
                sb2.append("div,h1,p,div>h1,div>p{text-align:right;}");
            }
        } else if (i10 == 6) {
            sb2.append(".box {margin: 12px 0; text-align: left; vertical-align:middle;position:relative;display: block;padding-top:10px; padding-bottom:10px; padding-left:10px; padding-right:10px;}");
            sb2.append(".box a {width: 100%;height: 100%;position: absolute;left: 0;top: 0;}");
            sb2.append("span, .url, .box {word-break: break-all;}");
            sb2.append(".block{opacity:0.5;}.tag{background:#cd8282;padding:0 8px;margin:0 4px;color:white;font-size:12px;}.res{background:#5c91cb;}");
            sb2.append(".title {");
            sb2.append(str5);
            sb2.append("font-size: 15px;");
            sb2.append(" padding: 4px 0px;}");
            sb2.append(".url {line-height: 1.2em; max-height: 4.8em;");
            sb2.append("font-size: 15px;");
            sb2.append(str4);
            sb2.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
            sb2.append("text-overflow: ellipsis;");
            sb2.append("}");
            sb2.append(".hint {line-height: 1.8em; ");
            sb2.append(str5);
            sb2.append("font-size: 15px;");
            sb2.append(" white-space: normal; word-wrap: break-word; overflow: auto;");
            sb2.append("text-overflow: ellipsis;");
            sb2.append(" padding: 50px 5px; text-align: center; margin: auto;}");
            sb2.append("#filter-box{padding:10px}#filter{border: 1px solid ");
            sb2.append(str7);
            sb2.append(";border-radius:2px;-webkit-appearance:none;-moz-appearance:none;appearance:none;background:transparent;padding:5px;width:100%;");
            sb2.append("font-size: 15px;");
            sb2.append(str4);
            sb2.append("}");
            if (zD) {
                sb2.append(".box{text-align:right;}");
            }
        }
        return sb2.toString();
    }

    public static String h(String str) {
        return i(str, null);
    }

    public static String i(String str, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<!DOCTYPE html><html><head><meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/><meta name=\"color-scheme\" content=\"light dark\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no, minimal-ui\">");
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = "<title>" + str + "</title>";
        }
        sb2.append(str3);
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append("</head>");
        return sb2.toString();
    }

    public static String j(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<style>");
        for (String str : strArr) {
            sb2.append(str);
        }
        sb2.append("</style>");
        return sb2.toString();
    }

    public static boolean k(Context context, String str) {
        return d(context, str) == 1;
    }

    public static boolean l(int i10) {
        return (i10 == 0 || i10 == -1) ? false : true;
    }

    public static boolean m(Context context, String str) {
        return l(d(context, str));
    }

    public static boolean n(int i10, String str) {
        String strN = r.j().n();
        if (i10 == 1) {
            return "about:home".equals(strN) || "about:links".equals(strN);
        }
        if (i10 == 2) {
            return "about:bookmarks".equals(strN);
        }
        if (i10 == 12) {
            return "about:blank".equals(strN);
        }
        if (str != null) {
            if (!str.equalsIgnoreCase(strN)) {
                if (str.equalsIgnoreCase(strN + "/")) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean o(Context context, String str) {
        return n(d(context, str), str);
    }
}
