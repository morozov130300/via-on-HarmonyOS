package c8;

import android.content.Context;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class sa {
    public static String a(Context context, float f10, float f11) {
        Locale locale = Locale.ROOT;
        return "javascript:(function(){var a=__RX__,c=__RY__;a=Math.max(0,Math.min(1,a));c=Math.max(0,Math.min(1,c));if(window.visualViewport){var b=window.visualViewport;a=b.offsetLeft+a*b.width;b=b.offsetTop+c*b.height}else a*=window.innerWidth,b=c*window.innerHeight;c=document.elementFromPoint(a,b)||document;a=new MouseEvent(\"contextmenu\",{bubbles:!0,cancelable:!1,view:window,button:2,buttons:0,clientX:a,clientY:b});c.dispatchEvent(a)})();".replace("__RX__", String.format(locale, "%.2f", Float.valueOf(f10))).replace("__RY__", String.format(locale, "%.2f", Float.valueOf(f11)));
    }

    public static String b(Context context, String str) {
        return "(function(){let n=\"via-dl1\";if(!window[n]){window[n]=!0;(function(){\"loading\"===document.readyState?document.addEventListener(\"DOMContentLoaded\",function(){e()}):e();(function(){const n=document.createElement;document.createElement=function(e,o){if(\"string\"!=typeof e)return n.call(document,e,o);const c=o?n.call(document,e,o):n.call(document,e);\"a\"===e.toLowerCase()&&t(c);return c}})()})()}function t(n){n&&n.addEventListener(\"click\",function(){const t=n.getAttribute(\"download\");if(!t||\"undefined\"==t||\"null\"==t)return;const e=n.href;if(e&&!(e.length>1048576))try{window.via.postMessage(\"__SECRET__\",JSON.stringify({action:104,url:e,name:t}))}catch(n){}})}function e(){const n=document.querySelectorAll(\"a[download]\");for(let e=0;e<n.length;e++)t(n[e])}})();".replace("__SECRET__", str);
    }

    public static String c(Context context) {
        return null;
    }
}
