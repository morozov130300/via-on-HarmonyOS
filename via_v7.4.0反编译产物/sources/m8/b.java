package m8;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {
    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("javascript:(function(){function updateStyle(style){var css=document.getElementById('__via_blocker_css__');if(css){css.innerText+=style;return}css=document.createElement('style');css.type='text/css';css.charset='UTF-8';css.id='__via_blocker_css__';css.appendChild(document.createTextNode(style));document.head.appendChild(css)}updateStyle(\"");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"') {
                sb2.append("\\");
            } else if (cCharAt >= '0' && cCharAt <= '9' && sb2.charAt(sb2.length() - 1) == '\\') {
                sb2.append('\\');
            }
            sb2.append(cCharAt);
        }
        sb2.append("\")})();");
        return sb2.toString();
    }

    public static String b(String str) {
        return "(function(){if(!document.getElementById('via_inject_css_blocker')){var css=document.createElement('link');css.id='via_inject_css_blocker';css.type='text/css';css.rel=\"stylesheet\";css.href='https://" + str + "/via_inject_blocker.css';var o=document.getElementsByTagName('head');if(o.length>0&&o[0].appendChild(css)){}}})();";
    }

    public static String c(String str) {
        return null;
    }
}
