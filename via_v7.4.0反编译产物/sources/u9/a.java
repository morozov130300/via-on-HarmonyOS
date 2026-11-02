package u9;

import android.content.Context;
import i6.i0;
import pa.r;
import x7.u;
import z8.w2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static String a(Context context, String str, String str2) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        boolean zD = r.j().d();
        String str3 = zD ? "#000" : "#fff";
        String str4 = zD ? "#303030" : "#e0e0e6";
        return "<html><head><meta name=\"color-scheme\" content=\"light dark\"><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=true, minimal-ui\"><title>" + i0.f7006a.f(str) + "</title><style>body{background:" + str3 + ";color:" + (zD ? "#fff" : "#000") + ";text-align:center;margin:auto;padding:40px;box-sizing:border-box}.icon{width:100px;height:100px;text-align:center;margin:auto;fill:#dd4747}.btn{background-color:#5a5a5a;color:#fff;padding:8px 12px;border:none;border-radius:8px;stroke:none;size:15px;text-decoration:none;margin-top:36px;max-width:120px;font-size:15px}.text{font-size:15px;margin:16px 0 8px}.code{background-color:" + str4 + ";font-family:monospace;font-size:13px;white-space:normal;word-break:break-all;padding:4px;margin:0 0 16px;line-height:1.5}.op{margin-top:32px}</style></head><body><div class=\"icon\"><svg viewBox=\"0 0 1794 1664\"><path d=\"m 1025.0139,1375 0,-190 q 0,-14 -9.5,-23.5 -9.5,-9.5 -22.5,-9.5 l -192,0 q -13,0 -22.5,9.5 -9.5,9.5 -9.5,23.5 l 0,190 q 0,14 9.5,23.5 9.5,9.5 22.5,9.5 l 192,0 q 13,0 22.5,-9.5 9.5,-9.5 9.5,-23.5 z m -2,-374 18,-459 q 0,-12 -10,-19 -13,-11 -24,-11 l -220,0 q -11,0 -24,11 -10,7 -10,21 l 17,457 q 0,10 10,16.5 10,6.5 24,6.5 l 185,0 q 14,0 23.5,-6.5 9.5,-6.5 10.5,-16.5 z m -14,-934 768,1408 q 35,63 -2,126 -17,29 -46.5,46 -29.5,17 -63.5,17 l -1536,0 q -34,0 -63.5,-17 -29.5,-17 -46.5,-46 -37,-63 -2,-126 L 785.01389,67 q 17,-31 47,-49 30,-18 65,-18 35,0 65,18 30,18 47,49 z\"></path></svg></div><p class=\"text\">" + context.getString(u.md) + "</p><p class=\"code\">" + str + "</p><p class=\"text\">" + context.getString(u.nd) + "</p><p class=\"code\">" + str2 + "</p><div class=\"op\"><a class=\"btn\" href=\"" + w2.c(str) + "\">" + context.getString(u.f14231y2) + "</a></div></body></html>";
    }
}
