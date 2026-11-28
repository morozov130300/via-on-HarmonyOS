package s9;

import android.content.Context;
import android.text.TextUtils;
import com.tuyafeng.support.utils.l;
import com.tuyafeng.support.utils.x;
import la.s;
import x8.v0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static String a(String str, String str2, String str3) {
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

    public static String b(String str, String str2, boolean z10, String str3) {
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

    public static int c(Context context, String str) {
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
        if ("blank.html".equals(strSubstring)) {
            return 12;
        }
        return "images.html".equals(strSubstring) ? 13 : -1;
    }

    public static String d(String str) {
        return "<div class='hint'>" + str.replace("\n", "<br>") + "</div>";
    }

    public static String e(String str) {
        return "<script type=\"text/javascript\">" + str + "</script>";
    }

    public static String f(Context context, int i10) {
        boolean zD = l.d(context);
        u9.l lVarJ = s.j();
        g9.a aVarQ2 = lVarJ.Q2();
        boolean zE = lVarJ.e();
        boolean z10 = false;
        if (!aVarQ2.c() ? !x.C(lVarJ.f0()) : !aVarQ2.d()) {
            z10 = true;
        }
        String strD = lVarJ.d();
        if (strD != null) {
            strD.isEmpty();
        }
        String str = (zE || z10) ? "#fafafa" : "#1b1b1b";
        String str2 = (zE || z10) ? "#d5d5d5" : "#2b2b2b";
        String str3 = (zE || z10) ? "#e9e9e9" : "#313131";
        if (!zE) {
            x.g(lVarJ.f0());
        }
        String str4 = "color: " + str + ";";
        String str5 = "color: " + str2 + ";";
        String str6 = "color: " + str3 + ";";
        String str7 = (zE || z10) ? "rgba(255, 255, 255, 0.1)" : "rgba(0, 0, 0, 0.1)";
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

    public static String g(String str) {
        return h(str, null);
    }

    public static String h(String str, String str2) {
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

    public static String i(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<style>");
        for (String str : strArr) {
            sb2.append(str);
        }
        sb2.append("</style>");
        return sb2.toString();
    }

    public static boolean j(Context context, String str) {
        return c(context, str) == 1;
    }

    public static boolean k(int i10) {
        return (i10 == 0 || i10 == -1) ? false : true;
    }

    public static boolean l(Context context, String str) {
        return k(c(context, str));
    }

    public static boolean m(int i10, String str) {
        String strP = s.j().p();
        if (i10 == 1) {
            return "about:home".equals(strP) || "about:links".equals(strP);
        }
        if (i10 == 2) {
            return "about:bookmarks".equals(strP);
        }
        if (i10 == 12) {
            return "about:blank".equals(strP);
        }
        if (str != null) {
            if (!str.equalsIgnoreCase(strP)) {
                if (str.equalsIgnoreCase(strP + "/")) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean n(Context context, String str) {
        return m(c(context, str), str);
    }
}
