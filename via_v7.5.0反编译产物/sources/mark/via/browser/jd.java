package mark.via.browser;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class jd {
    public static String a(Context context, int i10) {
        return "(function(){\"use strict\";if(document.head)e();else{var t=new MutationObserver(function(){if(document.head){t.disconnect();e()}});t.observe(document.documentElement,{childList:!0})}function e(){var t=document.getElementsByTagName(\"head\")[0];if(null!=t){var e=__WIDTH__,n=document.createElement(\"meta\");n.setAttribute(\"name\",\"viewport\");document.querySelectorAll('meta[name=\"viewport\"]').forEach(function(t){t.hasAttribute(\"data-width\")?n=t:t.remove()});var a,i,d=window.innerWidth;n.hasAttribute(\"data-width\")&&(d=n.getAttribute(\"data-width\"));n.setAttribute(\"content\",(a=e,i=d,\"width=\"+Math.max(a,i)+\", user-scalable=1\"));n.setAttribute(\"data-width\",d);t.appendChild(n)}}window.addEventListener(\"load\",function(t){e()})})();".replace("__WIDTH__", String.valueOf(i10));
    }

    public static String b(Context context) {
        return "void function t(){var e=document.querySelector(\"meta[name=viewport]\");if(e){for(var i=e.content.split(\",\"),n=[],a=0;a<i.length;a++){var r=i[a].trim();(r.startsWith(\"width\")||r.startsWith(\"initial-scale\")||r.startsWith(\"minimum-scale\"))&&n.push(r)}e.setAttribute(\"content\",n.join(\",\").trim())}else\"loading\"===document.readyState&&document.addEventListener(\"DOMContentLoaded\",t)}();";
    }
}
