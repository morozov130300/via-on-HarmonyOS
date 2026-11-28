package k8;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return "javascript:(function(){function updateStyle(style){var css=document.getElementById('__via_blocker_css__');if(css){css.innerText+=style;return}css=document.createElement('style');css.type='text/css';css.charset='UTF-8';css.id='__via_blocker_css__';css.appendChild(document.createTextNode(style));(document.head||document.documentElement).appendChild(css)}updateStyle(" + JSONObject.quote(str) + ")})();";
    }

    public static String b(String str) {
        return "(function(){if(!document.getElementById('via_inject_css_blocker')){var css=document.createElement('link');css.id='via_inject_css_blocker';css.type='text/css';css.rel=\"stylesheet\";css.href='https://" + str + "/via_inject_blocker.css';(document.head||document.documentElement).appendChild(css);}})();";
    }

    public static String c(String str) {
        return null;
    }
}
