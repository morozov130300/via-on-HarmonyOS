package i6;

import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f7043a = new o();

    public final void a(k writer, m config, String cssUrl, String str, List list, String pageTitle, String bookmarkTitle, String searchTitle) {
        kotlin.jvm.internal.h.f(writer, "writer");
        kotlin.jvm.internal.h.f(config, "config");
        kotlin.jvm.internal.h.f(cssUrl, "cssUrl");
        kotlin.jvm.internal.h.f(pageTitle, "pageTitle");
        kotlin.jvm.internal.h.f(bookmarkTitle, "bookmarkTitle");
        kotlin.jvm.internal.h.f(searchTitle, "searchTitle");
        writer.b("");
        writer.a(t.f7048a.a(pageTitle, "<link rel=\"stylesheet\" href=\"" + cssUrl + "\">"));
        writer.a("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
        writer.a("<div class=\"search_part\">");
        writer.a("<a class=\"logo\" href=\"\" onclick=\"javascript:window.via.cmd(257);\" title=\"" + bookmarkTitle + "\">");
        if (str == null || str.length() == 0) {
            str = "<img class=\"smaller\" src=\"data:image/svg+xml;base64,PHN2ZyBmaWxsPSJub25lIiBoZWlnaHQ9IjkwIiB2aWV3Qm94PSIwIDAgMTI0IDkwIiB3aWR0aD0iMTI0IiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPjxwYXRoIGQ9Im0yMS43Mzg0IDI2LjY3MzljLjE5MzktMS42MTY1IDEuMzQ4My0yLjk1NDEgMi45MTktMy4zODI1bDExLjM3NTYtMy4xMDI0YzEuMjcyMy0uMzQ3IDIuNTI2Mi42MTA4IDIuNTI2MiAxLjkyOTV2MTcuODgxNWwtMjEuMDU5MiAyMnoiIGZpbGw9IiMwMGE1ZjYiLz48cGF0aCBkPSJtNjcgNy41IDMuNSAyMy0zMS43MTE0IDM3Ljg2NDRjLTEuMDc0OSAxLjI4MzQtMi44MzU0IDEuNzYxOC00LjQxMiAxLjE5ODdsLTE1LjUzNDktNS41NDgyYy0xLjM0ODQtLjQ4MTYtMS43Njg4LTIuMTgyNS0uOC0zLjIzNjd6IiBmaWxsPSIjZmYzZTAwIi8+PHBhdGggZD0ibTY2LjcyMTQgOC4yOTQzYy0uMTExNC0uNjUxMDkuNDI3OS0xLjIyOTM3IDEuMDg1Mi0xLjE2MzY0bDE3LjM5MjEgMS43MzkyMWMuNzkwNS4wNzkwNSAxLjQ1OTMuNjE4NTMgMS43MDM5IDEuMzc0NDNsMjAuOTEwNCA2NC42MzM1Yy4zNjcgMS4xMzI4LS4zMzEgMi4zMzI5LTEuNDk3IDIuNTc0MWwtMjIuNzYxIDQuNzA5MWMtMi4yMTY1LjQ1ODYtNC4zNzE2LTEuMDExNi00Ljc1MzItMy4yNDI2eiIgZmlsbD0iI2ZmYjcwMCIvPjwvc3ZnPg==\" />";
        }
        writer.a(str);
        writer.a("</a>");
        writer.a("<div class=\"search_bar_wrapper\"><form onsubmit=\"return search()\" class=\"search_bar\" title=\"" + searchTitle + "\">");
        writer.a("<button onclick=\"search()\" id=\"search_submit\" value=\"\" aria-label=\"" + searchTitle + "\">");
        writer.a("<div class=\"search icon\"></div>");
        writer.a("</button><span>");
        writer.a("<input class=\"search\" onfocus=\"showButton()\" onblur=\"hideButton()\" type=\"text\" value=\"\" autocomplete=\"off\" id=\"search_input\" title=\"" + searchTitle + "\">");
        writer.a("</span></form>");
        writer.a("<button type=\"button\" id=\"search_bar_trigger\" aria-label=\"" + searchTitle + "\"></button></div></div>");
        if (list != null && !list.isEmpty()) {
            writer.a("<div id=\"bookmark_part\"><div id=\"box_container\">");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                writer.a(c((n) it.next(), config.d(), config.e()));
            }
            writer.a("</div></div>");
        }
        writer.a("<script type=\"text/javascript\">function showButton(){document.getElementById(\"search_submit\").style.display=\"block\"}\nfunction hideButton(){\"\"==document.getElementById(\"search_input\").value&&(document.getElementById(\"search_submit\").style.display=\"none\")}\nfunction search(){var a=document.getElementById(\"search_input\");if(\"\"!=a.value){try{location.href='via://search?q='+encodeURIComponent(a.value);}catch(b){}a.value=\"\";document.getElementById(\"search_submit\").style.display=\"none\";document.activeElement.blur()}return!1}\nfunction fadeIn(a){if(a&&a.style)var b=Math.max(.05,parseFloat(a.style.opacity)),d=setInterval(function(){1<=b&&clearInterval(d);a.style.opacity=Math.min(1,b);b+=.1*b},6)}\nfunction callNativeSearch(){try{window.via.cmd(514)}catch(e){}}\nfunction triggerSearchBar(){var a=document.getElementById(\"search_bar_trigger\"),c=document.getElementById(\"content\");if(!a||!c||\"true\"==a.getAttribute(\"aria-disabled\"))return;a.setAttribute(\"aria-disabled\",\"true\");if(window.matchMedia&&window.matchMedia(\"(prefers-reduced-motion: reduce)\").matches){callNativeSearch();a.removeAttribute(\"aria-disabled\");return}var t=c.style.transform,o=c.style.opacity;requestAnimationFrame(function(){c.style.transform=\"translateY(72px)\";c.style.opacity=\"0.1\";setTimeout(function(){callNativeSearch();c.style.transform=t;c.style.opacity=o;setTimeout(function(){a.removeAttribute(\"aria-disabled\")},160)},120)})}\nfunction initSearchBarTrigger(){var a=document.getElementById(\"search_bar_trigger\"),f=document.querySelector(\".search_bar\");if(!a||!f||\"none\"==window.getComputedStyle(a).display)return;f.inert=!0;f.setAttribute(\"aria-hidden\",\"true\");for(var e=f.querySelectorAll(\"input,button\"),i=0;i<e.length;i++)e[i].disabled=!0;a.addEventListener(\"click\",triggerSearchBar,!1)}\nfunction isGestureDisabled(){return document.activeElement&&\"search_input\"==document.activeElement.id||window.via&&!window.via.cmd(515)?!0:0!=(document.documentElement.scrollTop||document.body.scrollTop)};\nfunction initGesture(f){var c=document.getElementById(\"content\"),d=!1,h=0,b=0,g=0,a=0;f.addEventListener(\"touchstart\",function(e){d=e.target&&\"search_bar_trigger\"==e.target.id||isGestureDisabled();d||(h=e.touches[0].screenY,a=b=0,document.body.style.overflow=\"visible\")},!1);f.addEventListener(\"touchmove\",function(e){d||(g=b,b=e.touches[0].screenY-h,a=Math.min(98,Math.max(0,a+b-g)),c.style.transform=\"translateY(\"+a+\"px)\",c.style.opacity=Math.max(.1,1-a/98),1<g!=1<b&&(document.body.style.overflow=1<b?\"hidden\":\"visible\"))},!1);f.addEventListener(\"touchend\",function(e){if(!d){if(0!==a){if(88.2<a)callNativeSearch();c.style.transform=\"translateY(0px)\";fadeIn(c)}document.body.style.overflow=\"visible\"}},!1)};\ninitSearchBarTrigger();initGesture(document.getElementById(\"gesture-indicator\"));initGesture(document.getElementById(\"content\"));</script>");
        writer.a("<script type=\"text/javascript\">var OpenSuggestion=function(){function m(b){function a(c){c=c.target.value;try{window.via.postMessage(__VIA_SECRET__,JSON.stringify({action:106,text:c}))}catch(g){}}b.addEventListener(\"input\",a);b.addEventListener(\"focus\",a);document.addEventListener(\"click\",function(c){b.contains(c.target)||k()},!1)}function n(b){e.innerHTML=\"\";if(b&&0!==b.length){d.style.display=\"block\";f.classList.add(h);for(var a=0;a<b.length;a++){var c=document.createElement(\"tr\"),g=document.createElement(\"td\");g.appendChild(document.createTextNode(b[a].toString()));\nc.onclick=function(){l(this.getElementsByTagName(\"td\")[0].textContent)};c.className=\"sug-item\";c.appendChild(g);e.appendChild(c)}}else k()}function k(){\"none\"!==d.style.display&&(d.style.display=\"none\",f.classList.remove(h))}var f,d,e,l,h;return{bind:function(b,a,c){if(b=document.getElementById(b)){l=c;h=a.formActiveClassName||\"sug-form-active\";for(a=b;a&&\"FORM\"!==a.tagName;)a=a.parentElement;a&&(f=a,d||(d=document.createElement(\"div\"),d.className=\"opSug_wpr\",d.style.display=\"none\",a=document.createElement(\"table\"),\ne=document.createElement(\"tbody\"),e.id=\"sug_tbody\",a.appendChild(e),d.appendChild(a),f.parentNode.insertBefore(d,f.nextSibling)),m(b))}},pushSuggestions:function(b){n(b)}}}();</script>");
        writer.a("<script type=\"text/javascript\">function show(str){var searchbox = document.getElementById(\"search_input\"); searchbox.value = str; searchbox.blur(); search();}var params = {\"formActiveClassName\":'search_bar_active' }; OpenSuggestion.bind(\"search_input\",params,show); </script>");
        writer.a("</div></body></html>");
        writer.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0548 A[LOOP:0: B:131:0x0548->B:133:0x0571, LOOP_START, PHI: r10
  0x0548: PHI (r10v22 int) = (r10v20 int), (r10v23 int) binds: [B:130:0x0546, B:133:0x0571] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x065a  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(k writer, m config) {
        boolean z10;
        boolean z11;
        String string;
        String str;
        String str2;
        Object objValueOf;
        boolean z12;
        String string2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i10;
        String strB;
        String string3;
        String str9;
        kotlin.jvm.internal.h.f(writer, "writer");
        kotlin.jvm.internal.h.f(config, "config");
        boolean zU = config.u();
        boolean zX = config.x();
        if (config.c() != null) {
            String strC = config.c();
            kotlin.jvm.internal.h.c(strC);
            z10 = strC.length() > 0;
        }
        String str10 = "#1b1b1b";
        String str11 = !zU ? "#fafafa" : "#1b1b1b";
        String str12 = !zU ? "rgba(255,255,255,0.1)" : "rgba(0,0,0,0.1)";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rgba(");
        sb2.append(!zU ? "255, 255, 255" : "0, 0, 0");
        sb2.append(", ");
        sb2.append(config.r());
        sb2.append(')');
        String string4 = sb2.toString();
        String str13 = "rgba(233, 233, 233, " + config.r() + ')';
        String str14 = "rgba(255, 255, 255, " + config.n() + ')';
        if (zU) {
            z11 = zU;
            string = "rgba(0, 0, 0, " + config.n() + ')';
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("rgba(255, 255, 255, ");
            z11 = zU;
            sb3.append(config.n());
            sb3.append(')');
            string = sb3.toString();
        }
        String str15 = ((double) config.n()) < 0.5d ? str11 : "#1b1b1b";
        if (!z11) {
            str = string;
            String str16 = ((double) config.n()) >= 0.5d ? "#1b1b1b" : "#afafaf";
            if (config.t()) {
                if (config.t()) {
                    str2 = str16;
                } else {
                    str2 = str16;
                    if (config.n() < 0.85d) {
                        objValueOf = Double.valueOf(0.85d);
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("rgba(255, 255, 255, ");
                    sb4.append(objValueOf);
                    z12 = zX;
                    sb4.append(')');
                    string2 = sb4.toString();
                    if (z11 && z10) {
                        str3 = "rgba(255, 255, 255, " + objValueOf + ')';
                    } else {
                        str3 = "rgba(0, 0, 0, " + objValueOf + ')';
                    }
                    str4 = (z11 && z10) ? "#1b1b1b" : "#afafaf";
                }
                objValueOf = Float.valueOf(config.n());
                StringBuilder sb42 = new StringBuilder();
                sb42.append("rgba(255, 255, 255, ");
                sb42.append(objValueOf);
                z12 = zX;
                sb42.append(')');
                string2 = sb42.toString();
                if (z11) {
                    str3 = "rgba(0, 0, 0, " + objValueOf + ')';
                    if (z11) {
                    }
                }
            } else {
                str2 = str16;
                z12 = zX;
                str10 = str15;
                string2 = str14;
                str4 = str2;
                str3 = str;
            }
            String str17 = !z12 ? "#afafaf" : str11;
            if (!z12) {
                str11 = "#afafaf";
            }
            String str18 = !z12 ? "rgba(255,255,255,0.1)" : str12;
            String str19 = z12 ? str12 : "rgba(255,255,255,0.1)";
            String str20 = !z12 ? str13 : string4;
            if (!z12) {
                string4 = str13;
            }
            String str21 = !z12 ? str : str14;
            if (!z12) {
                str14 = str;
            }
            String str22 = !z12 ? str2 : str15;
            if (!z12) {
                str15 = str2;
            }
            String str23 = !z12 ? str3 : string2;
            if (z12) {
                str3 = string2;
            }
            String str24 = !z12 ? str4 : str10;
            if (z12) {
                str4 = str10;
            }
            if (config.t()) {
                str5 = str4;
                str6 = "";
            } else {
                str5 = str4;
                str6 = "backdrop-filter: blur(10px);";
            }
            writer.b("");
            writer.a("* { padding:0; margin:0; box-sizing:border-box; user-drag:none; -webkit-user-drag:none; }");
            StringBuilder sb5 = new StringBuilder();
            String str25 = str3;
            sb5.append("html { height:100%; -webkit-focus-ring-color: transparent; -webkit-tap-highlight-color: ");
            sb5.append(str18);
            sb5.append("; font-family: ui-sans-serif,-apple-system,system-ui,Segoe UI,Helvetica,Apple Color Emoji,Arial,sans-serif,Segoe UI Emoji,Segoe UI Symbol; }");
            writer.a(sb5.toString());
            writer.a("body { min-height:100%; max-width:100%; width:600px; margin: auto; text-align: center; }");
            writer.a("#gesture-indicator { height:100%; width:100%; max-width:600px; position:absolute; top:0; bottom:0; z-index:0; overflow:hidden; word-break:break-all; }");
            writer.a("#content { position: absolute; max-width: 600px; width: 100%; }");
            StringBuilder sb6 = new StringBuilder();
            sb6.append(".logo { color: ");
            sb6.append(str17);
            sb6.append("; font-size: ");
            sb6.append(config.i());
            sb6.append("px; ");
            sb6.append(!config.v() ? "font-weight: bold;" : "");
            sb6.append(' ');
            sb6.append(!config.w() ? "font-style: italic;" : "");
            sb6.append(" white-space: normal; word-wrap: break-word; overflow: auto; text-decoration: none; }");
            writer.a(sb6.toString());
            if (config.k().length() <= 0) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("img.smaller {");
                if (config.m() != 0) {
                    str8 = str14;
                    StringBuilder sb8 = new StringBuilder();
                    str7 = string4;
                    sb8.append("width: ");
                    sb8.append(config.m());
                    sb8.append("px;");
                    string3 = sb8.toString();
                } else {
                    str7 = string4;
                    str8 = str14;
                    string3 = "";
                }
                sb7.append(string3);
                sb7.append(' ');
                if (config.j() != 0) {
                    str9 = "height: " + config.j() + "px;";
                } else {
                    str9 = "";
                }
                sb7.append(str9);
                sb7.append(" border-radius: ");
                sb7.append(config.l());
                sb7.append("px; object-fit: cover; }");
                writer.a(sb7.toString());
            } else {
                str7 = string4;
                str8 = str14;
            }
            if (z12) {
                writer.a("img.smaller, .overlay, .title { -webkit-filter: brightness(75%); filter: brightness(75%); }");
            }
            writer.a("span { display:block; overflow:hidden; padding-left:5px; vertical-align:middle; }");
            writer.a(".search_part { display:table; vertical-align:middle; width:90%; max-width:600px; margin:0 auto 20px; padding:0; }");
            writer.a(".search.icon { width: 12px; height: 12px; border: solid 2px currentColor; border-radius: 100%; -webkit-transform: rotate(-45deg); transform: rotate(-45deg); text-align: center; margin: auto; }");
            writer.a(".search.icon:before { content: ''; position: absolute; top: 10px; left: 3px; height: 5px; width: 2px; background-color: currentColor; }");
            writer.a(".search_bar_wrapper { position: relative; display: table; width: 100%; margin: 15px auto 0; }");
            writer.a(".search_bar { position: relative; display: table; width: 100%; margin: 0; }");
            writer.a("#search_input { height: 46px; padding: 0 12px; width: 100%; outline: none; border: none; font-size: 15px; background-color: transparent; }");
            writer.a("#search_submit { display: none; outline: none; height: 46px; width: 56px; float: right; font-size: 15px; font-weight: bold; border: none; background-color: transparent; padding: 0 10px; }");
            writer.a("#search_bar_trigger { position: absolute; inset: 0; z-index: 1; width: 100%; height: 46px; padding: 0; border: 0; border-radius: " + config.q() + "px; background: transparent; color: inherit; }");
            writer.a("#search_bar_trigger:focus-visible { outline: 2px solid currentColor; outline-offset: 2px; }");
            StringBuilder sb9 = new StringBuilder();
            sb9.append(".search_bar {");
            sb9.append(!config.p() ? "border-bottom" : "border");
            sb9.append(": ");
            sb9.append(config.s());
            sb9.append("px solid ");
            sb9.append(str20);
            sb9.append("; border-radius: ");
            sb9.append(config.q());
            sb9.append("px; background: ");
            sb9.append(str21);
            sb9.append("; ");
            sb9.append(str6);
            sb9.append(" }");
            writer.a(sb9.toString());
            writer.a(".search_bar { color: " + str22 + "; }");
            writer.a(".search.icon, #search_input, #search_submit { color: inherit; }");
            writer.a(".opSug_wpr { background: " + str23 + "; " + str6 + " border: " + config.s() + "px solid " + str20 + "; border-radius: 0 0 " + config.q() + "px " + config.q() + "px; overflow-y: scroll; line-height: normal; position: absolute; width: 100%; max-width: 600px; margin: -" + config.s() + "px 0 0; z-index: 9999; }");
            writer.a(".opSug_wpr::-webkit-scrollbar {width: 0;}");
            writer.a(".opSug_wpr table {background: none; padding: 0px; width: 100%; border-spacing: 0;}");
            writer.a(".opSug_wpr tr {padding: 0px; margin: 0px; display: table-row; vertical-align: inherit; border-color: inherit;}");
            writer.a(".opSug_wpr tr:hover {color: #FFF; background: #7B90E3;}");
            StringBuilder sb10 = new StringBuilder();
            sb10.append(".opSug_wpr td { color: ");
            sb10.append(str24);
            sb10.append("; font-size: 14px; padding: 10px 17px; background: none; text-align: left; vertical-align: middle; font: 14px verdana; text-decoration: none; text-indent: 0px;}");
            writer.a(sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append(".search_bar_active {border-radius: ");
            sb11.append(config.q());
            sb11.append("px ");
            sb11.append(config.q());
            sb11.append("px 0 0; }");
            writer.a(sb11.toString());
            writer.a(".search_bar_active { color: " + str24 + "; background: " + str23 + "; }");
            writer.a("#bookmark_part { text-align: center; max-width:600px; background-color: transparent; margin: 0 auto; padding: 0; border-radius: 0px; }");
            writer.a("#box_container { text-align: left; margin: 0 auto; font-size: 0; }");
            writer.a(".box { vertical-align: top; margin: 4px 9px 4px; width: " + config.h() + "px; border: 0; position: relative; display: inline-block; text-align: center; }");
            writer.a(".box a { width: 100%; height: 100%; position: absolute; left: 0; top: 0; }");
            writer.a(".overlay { position: absolute; left: 0; top: 0; border-radius: " + config.g() + "px; width: " + config.h() + "px; height: " + config.f() + "px; }");
            StringBuilder sb12 = new StringBuilder();
            sb12.append(".title { border-radius: ");
            sb12.append(config.g());
            sb12.append("px; color: ");
            sb12.append(!config.d() ? str17 : "#ffffff");
            sb12.append("; width: ");
            sb12.append(config.h());
            sb12.append("px; line-height: ");
            sb12.append(config.f());
            sb12.append("px; height: ");
            sb12.append(config.f());
            sb12.append("px; font-size: 15px; }");
            writer.a(sb12.toString());
            writer.a(".url { color: " + str17 + "; margin: 2px 0 0; width: " + config.h() + "px; height: 20px; line-height: 20px; white-space: normal; word-wrap: break-word; overflow: hidden; text-overflow: clip; ms-text-overflow: clip; font-size: 10px; }");
            int iH = config.h() + 18;
            i10 = 540 / iH;
            boolean zO = config.o();
            int i11 = 1;
            if (1 <= i10) {
                while (true) {
                    writer.a("@media only screen and (min-width: " + ((i11 + (zO ? 1 : 0)) * iH) + "px) { #box_container { width: " + (iH * i11) + "px } }");
                    if (i11 == i10) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            if (config.o()) {
                writer.a("#content { top: 18px; } .search_part { display: none; }");
            } else {
                writer.a("#content { top: 25%; transition: 0.14s; }");
                writer.a("@media only screen and (min-height:250px) { #content { top: 62px } }");
                writer.a("@media only screen and (min-height:350px) { #content { top: 87px } }");
                writer.a("@media only screen and (min-height:450px) { #content { top: 135px } }");
                writer.a("@media only screen and (min-height:650px) { #content { top: 195px } }");
                writer.a("@media only screen and (min-height:850px) { #content { top: 255px } }");
            }
            if (config.y()) {
                writer.a("html { direction: rtl; } #box_container { text-align: right; } #search_submit { float: left; }");
            }
            writer.a(".sort-ghost { opacity: 0.3; }");
            StringBuilder sb13 = new StringBuilder();
            sb13.append("@media (prefers-color-scheme:");
            sb13.append(!z12 ? "light" : "dark");
            sb13.append("){");
            writer.a(sb13.toString());
            writer.a("html { -webkit-tap-highlight-color: " + str19 + "; }");
            writer.a(".logo { color: " + str11 + "; }");
            writer.a(".opSug_wpr td { color: " + str15 + "; }");
            StringBuilder sb14 = new StringBuilder();
            sb14.append(".title { color: ");
            sb14.append(!config.d() ? str11 : "#ffffff");
            sb14.append("; }");
            writer.a(sb14.toString());
            writer.a(".url { color: " + str11 + "; }");
            StringBuilder sb15 = new StringBuilder();
            sb15.append(".search_bar { ");
            sb15.append(!config.p() ? "border-bottom" : "border");
            sb15.append(": ");
            sb15.append(config.s());
            sb15.append("px solid ");
            String str26 = str7;
            sb15.append(str26);
            sb15.append("; background: ");
            sb15.append(str8);
            sb15.append("; }");
            writer.a(sb15.toString());
            writer.a(".search_bar { color: " + str15 + "; }");
            if (!z12) {
                writer.a("img.smaller, .overlay, .title { -webkit-filter: brightness(75%); filter: brightness(75%); }");
            }
            writer.a(".opSug_wpr { background: " + str25 + "; border: " + config.s() + "px solid " + str26 + "; }");
            StringBuilder sb16 = new StringBuilder();
            sb16.append(".search_bar_active { color: ");
            String str27 = str5;
            sb16.append(str27);
            sb16.append("; background: ");
            sb16.append(str25);
            sb16.append("; }");
            writer.a(sb16.toString());
            writer.a(".opSug_wpr td { color: " + str27 + "; }");
            writer.a("}");
            strB = config.b();
            if (strB != null) {
                writer.a(strB);
            }
            writer.close();
        }
        str = string;
        if (config.t()) {
        }
        if (!z12) {
        }
        if (!z12) {
        }
        if (!z12) {
        }
        if (z12) {
        }
        if (!z12) {
        }
        if (!z12) {
        }
        if (!z12) {
        }
        if (!z12) {
        }
        if (!z12) {
        }
        if (!z12) {
        }
        if (!z12) {
        }
        if (z12) {
        }
        if (!z12) {
        }
        if (z12) {
        }
        if (config.t()) {
        }
        writer.b("");
        writer.a("* { padding:0; margin:0; box-sizing:border-box; user-drag:none; -webkit-user-drag:none; }");
        StringBuilder sb52 = new StringBuilder();
        String str252 = str3;
        sb52.append("html { height:100%; -webkit-focus-ring-color: transparent; -webkit-tap-highlight-color: ");
        sb52.append(str18);
        sb52.append("; font-family: ui-sans-serif,-apple-system,system-ui,Segoe UI,Helvetica,Apple Color Emoji,Arial,sans-serif,Segoe UI Emoji,Segoe UI Symbol; }");
        writer.a(sb52.toString());
        writer.a("body { min-height:100%; max-width:100%; width:600px; margin: auto; text-align: center; }");
        writer.a("#gesture-indicator { height:100%; width:100%; max-width:600px; position:absolute; top:0; bottom:0; z-index:0; overflow:hidden; word-break:break-all; }");
        writer.a("#content { position: absolute; max-width: 600px; width: 100%; }");
        StringBuilder sb62 = new StringBuilder();
        sb62.append(".logo { color: ");
        sb62.append(str17);
        sb62.append("; font-size: ");
        sb62.append(config.i());
        sb62.append("px; ");
        sb62.append(!config.v() ? "font-weight: bold;" : "");
        sb62.append(' ');
        sb62.append(!config.w() ? "font-style: italic;" : "");
        sb62.append(" white-space: normal; word-wrap: break-word; overflow: auto; text-decoration: none; }");
        writer.a(sb62.toString());
        if (config.k().length() <= 0) {
        }
        if (z12) {
        }
        writer.a("span { display:block; overflow:hidden; padding-left:5px; vertical-align:middle; }");
        writer.a(".search_part { display:table; vertical-align:middle; width:90%; max-width:600px; margin:0 auto 20px; padding:0; }");
        writer.a(".search.icon { width: 12px; height: 12px; border: solid 2px currentColor; border-radius: 100%; -webkit-transform: rotate(-45deg); transform: rotate(-45deg); text-align: center; margin: auto; }");
        writer.a(".search.icon:before { content: ''; position: absolute; top: 10px; left: 3px; height: 5px; width: 2px; background-color: currentColor; }");
        writer.a(".search_bar_wrapper { position: relative; display: table; width: 100%; margin: 15px auto 0; }");
        writer.a(".search_bar { position: relative; display: table; width: 100%; margin: 0; }");
        writer.a("#search_input { height: 46px; padding: 0 12px; width: 100%; outline: none; border: none; font-size: 15px; background-color: transparent; }");
        writer.a("#search_submit { display: none; outline: none; height: 46px; width: 56px; float: right; font-size: 15px; font-weight: bold; border: none; background-color: transparent; padding: 0 10px; }");
        writer.a("#search_bar_trigger { position: absolute; inset: 0; z-index: 1; width: 100%; height: 46px; padding: 0; border: 0; border-radius: " + config.q() + "px; background: transparent; color: inherit; }");
        writer.a("#search_bar_trigger:focus-visible { outline: 2px solid currentColor; outline-offset: 2px; }");
        StringBuilder sb92 = new StringBuilder();
        sb92.append(".search_bar {");
        sb92.append(!config.p() ? "border-bottom" : "border");
        sb92.append(": ");
        sb92.append(config.s());
        sb92.append("px solid ");
        sb92.append(str20);
        sb92.append("; border-radius: ");
        sb92.append(config.q());
        sb92.append("px; background: ");
        sb92.append(str21);
        sb92.append("; ");
        sb92.append(str6);
        sb92.append(" }");
        writer.a(sb92.toString());
        writer.a(".search_bar { color: " + str22 + "; }");
        writer.a(".search.icon, #search_input, #search_submit { color: inherit; }");
        writer.a(".opSug_wpr { background: " + str23 + "; " + str6 + " border: " + config.s() + "px solid " + str20 + "; border-radius: 0 0 " + config.q() + "px " + config.q() + "px; overflow-y: scroll; line-height: normal; position: absolute; width: 100%; max-width: 600px; margin: -" + config.s() + "px 0 0; z-index: 9999; }");
        writer.a(".opSug_wpr::-webkit-scrollbar {width: 0;}");
        writer.a(".opSug_wpr table {background: none; padding: 0px; width: 100%; border-spacing: 0;}");
        writer.a(".opSug_wpr tr {padding: 0px; margin: 0px; display: table-row; vertical-align: inherit; border-color: inherit;}");
        writer.a(".opSug_wpr tr:hover {color: #FFF; background: #7B90E3;}");
        StringBuilder sb102 = new StringBuilder();
        sb102.append(".opSug_wpr td { color: ");
        sb102.append(str24);
        sb102.append("; font-size: 14px; padding: 10px 17px; background: none; text-align: left; vertical-align: middle; font: 14px verdana; text-decoration: none; text-indent: 0px;}");
        writer.a(sb102.toString());
        StringBuilder sb112 = new StringBuilder();
        sb112.append(".search_bar_active {border-radius: ");
        sb112.append(config.q());
        sb112.append("px ");
        sb112.append(config.q());
        sb112.append("px 0 0; }");
        writer.a(sb112.toString());
        writer.a(".search_bar_active { color: " + str24 + "; background: " + str23 + "; }");
        writer.a("#bookmark_part { text-align: center; max-width:600px; background-color: transparent; margin: 0 auto; padding: 0; border-radius: 0px; }");
        writer.a("#box_container { text-align: left; margin: 0 auto; font-size: 0; }");
        writer.a(".box { vertical-align: top; margin: 4px 9px 4px; width: " + config.h() + "px; border: 0; position: relative; display: inline-block; text-align: center; }");
        writer.a(".box a { width: 100%; height: 100%; position: absolute; left: 0; top: 0; }");
        writer.a(".overlay { position: absolute; left: 0; top: 0; border-radius: " + config.g() + "px; width: " + config.h() + "px; height: " + config.f() + "px; }");
        StringBuilder sb122 = new StringBuilder();
        sb122.append(".title { border-radius: ");
        sb122.append(config.g());
        sb122.append("px; color: ");
        sb122.append(!config.d() ? str17 : "#ffffff");
        sb122.append("; width: ");
        sb122.append(config.h());
        sb122.append("px; line-height: ");
        sb122.append(config.f());
        sb122.append("px; height: ");
        sb122.append(config.f());
        sb122.append("px; font-size: 15px; }");
        writer.a(sb122.toString());
        writer.a(".url { color: " + str17 + "; margin: 2px 0 0; width: " + config.h() + "px; height: 20px; line-height: 20px; white-space: normal; word-wrap: break-word; overflow: hidden; text-overflow: clip; ms-text-overflow: clip; font-size: 10px; }");
        int iH2 = config.h() + 18;
        i10 = 540 / iH2;
        boolean zO2 = config.o();
        int i112 = 1;
        if (1 <= i10) {
        }
        if (config.o()) {
        }
        if (config.y()) {
        }
        writer.a(".sort-ghost { opacity: 0.3; }");
        StringBuilder sb132 = new StringBuilder();
        sb132.append("@media (prefers-color-scheme:");
        sb132.append(!z12 ? "light" : "dark");
        sb132.append("){");
        writer.a(sb132.toString());
        writer.a("html { -webkit-tap-highlight-color: " + str19 + "; }");
        writer.a(".logo { color: " + str11 + "; }");
        writer.a(".opSug_wpr td { color: " + str15 + "; }");
        StringBuilder sb142 = new StringBuilder();
        sb142.append(".title { color: ");
        sb142.append(!config.d() ? str11 : "#ffffff");
        sb142.append("; }");
        writer.a(sb142.toString());
        writer.a(".url { color: " + str11 + "; }");
        StringBuilder sb152 = new StringBuilder();
        sb152.append(".search_bar { ");
        sb152.append(!config.p() ? "border-bottom" : "border");
        sb152.append(": ");
        sb152.append(config.s());
        sb152.append("px solid ");
        String str262 = str7;
        sb152.append(str262);
        sb152.append("; background: ");
        sb152.append(str8);
        sb152.append("; }");
        writer.a(sb152.toString());
        writer.a(".search_bar { color: " + str15 + "; }");
        if (!z12) {
        }
        writer.a(".opSug_wpr { background: " + str252 + "; border: " + config.s() + "px solid " + str262 + "; }");
        StringBuilder sb162 = new StringBuilder();
        sb162.append(".search_bar_active { color: ");
        String str272 = str5;
        sb162.append(str272);
        sb162.append("; background: ");
        sb162.append(str252);
        sb162.append("; }");
        writer.a(sb162.toString());
        writer.a(".opSug_wpr td { color: " + str272 + "; }");
        writer.a("}");
        strB = config.b();
        if (strB != null) {
        }
        writer.close();
    }

    public final String c(n nVar, boolean z10, boolean z11) {
        String str;
        String strD = nVar.d();
        String str2 = "";
        if (strD == null) {
            strD = "";
        }
        String strE = nVar.e();
        if (strE == null) {
            strE = "";
        }
        String strA = nVar.a();
        boolean z12 = true;
        boolean z13 = strA == null || strA.length() == 0 || z10;
        String strB = nVar.b();
        if (strB != null && strB.length() != 0 && !z11) {
            z12 = false;
        }
        String str3 = "background: url('" + nVar.b() + "') no-repeat;background-size: cover;background-position:center center;";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<div class=\"box\"><p class=\"title\" aria-hidden=\"true\" ");
        if (z13) {
            str = "";
        } else {
            str = " style=\"background:" + nVar.a() + ";\"";
        }
        sb2.append(str);
        sb2.append('>');
        String strC = nVar.c();
        if (strC == null) {
            strC = "";
        }
        sb2.append(strC);
        sb2.append("</p><div class=\"overlay\"");
        if (!z12) {
            str2 = " style=\"" + str3 + '\"';
        }
        sb2.append(str2);
        sb2.append("></div><p class=\"url\" aria-hidden=\"true\">");
        sb2.append(strD);
        sb2.append("</p><a href=\"");
        sb2.append(strE);
        sb2.append("\" title=\"");
        sb2.append(strD);
        sb2.append("\"></a></div>");
        return sb2.toString();
    }
}
