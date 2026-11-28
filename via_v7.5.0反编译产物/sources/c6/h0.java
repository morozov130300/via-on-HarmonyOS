package c6;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f2013a = new h0();

    public final void a(d0 writer, f0 config, String cssUrl, String str, List list, String pageTitle, String bookmarkTitle, String searchTitle) {
        kotlin.jvm.internal.h.f(writer, "writer");
        kotlin.jvm.internal.h.f(config, "config");
        kotlin.jvm.internal.h.f(cssUrl, "cssUrl");
        kotlin.jvm.internal.h.f(pageTitle, "pageTitle");
        kotlin.jvm.internal.h.f(bookmarkTitle, "bookmarkTitle");
        kotlin.jvm.internal.h.f(searchTitle, "searchTitle");
        writer.b("");
        writer.a(r0.f2099a.a(pageTitle, "<link rel=\"stylesheet\" href=\"" + cssUrl + "\">"));
        writer.a("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
        writer.a("<div class=\"search_part\">");
        writer.a("<a class=\"logo\" href=\"via://bookmarks\" title=\"" + bookmarkTitle + "\">");
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
                writer.a(c((g0) it.next(), config.d(), config.e()));
            }
            writer.a("</div></div>");
        }
        writer.a("<script type=\"text/javascript\">function showButton(){document.getElementById(\"search_submit\").style.display=\"block\"}\nfunction hideButton(){\"\"==document.getElementById(\"search_input\").value&&(document.getElementById(\"search_submit\").style.display=\"none\")}\nfunction search(){var a=document.getElementById(\"search_input\");if(\"\"!=a.value){try{location.href='via://search?q='+encodeURIComponent(a.value);}catch(b){}a.value=\"\";document.getElementById(\"search_submit\").style.display=\"none\";document.activeElement.blur()}return!1}\nfunction callNativeSearch(){location.href='via://search'}\nfunction initSearchBarTrigger(){var a=document.getElementById(\"search_bar_trigger\"),f=document.querySelector(\".search_bar\");if(!a||!f||\"none\"==window.getComputedStyle(a).display)return;f.inert=!0;f.setAttribute(\"aria-hidden\",\"true\");for(var e=f.querySelectorAll(\"input,button\"),i=0;i<e.length;i++)e[i].disabled=!0;a.addEventListener(\"click\",callNativeSearch,!1)}\nfunction initGesture(){var e,t,n=document.getElementById(\"content\");function a(a){var c=\"touchend\"===a.type&&t>88.2;if(null!=t){n.style.transition=\"\";n.style.transform=\"\";n.style.opacity=\"\"}e=null;t=null;c&&callNativeSearch()}document.body.addEventListener(\"touchstart\",function(t){a(t);var n=document.scrollingElement||document.documentElement;1===t.touches.length&&n.scrollTop<=0&&document.activeElement!==document.getElementById(\"search_input\")&&(e=t.touches[0])});document.body.addEventListener(\"touchmove\",function(a){if(e){var c=a.touches[0],l=c.screenY-e.screenY;if(null==t){var o=c.screenX-e.screenX;if(!o&&!l)return;Math.abs(o)>=Math.abs(l)&&a.cancelable&&a.preventDefault();if(l<=Math.abs(o)||!a.cancelable){e=null;return}n.style.transition=\"none\"}a.cancelable&&a.preventDefault();t=Math.max(0,Math.min(98,l));n.style.transform=\"translateY(\"+t+\"px)\";n.style.opacity=Math.max(.1,1-t/98)}},{passive:!1});document.body.addEventListener(\"touchend\",a);document.body.addEventListener(\"touchcancel\",a)}initSearchBarTrigger();initGesture();</script>");
        writer.a("<script type=\"text/javascript\">var OpenSuggestion=function(){function m(b){function a(c){c=c.target.value;try{window.via.postMessage(__VIA_SECRET__,JSON.stringify({action:106,text:c}))}catch(g){}}b.addEventListener(\"input\",a);b.addEventListener(\"focus\",a);document.addEventListener(\"click\",function(c){b.contains(c.target)||k()},!1)}function n(b){e.innerHTML=\"\";if(b&&0!==b.length){d.style.display=\"block\";f.classList.add(h);for(var a=0;a<b.length;a++){var c=document.createElement(\"tr\"),g=document.createElement(\"td\");g.appendChild(document.createTextNode(b[a].toString()));\nc.onclick=function(){l(this.getElementsByTagName(\"td\")[0].textContent)};c.className=\"sug-item\";c.appendChild(g);e.appendChild(c)}}else k()}function k(){\"none\"!==d.style.display&&(d.style.display=\"none\",f.classList.remove(h))}var f,d,e,l,h;return{bind:function(b,a,c){if(b=document.getElementById(b)){l=c;h=a.formActiveClassName||\"sug-form-active\";for(a=b;a&&\"FORM\"!==a.tagName;)a=a.parentElement;a&&(f=a,d||(d=document.createElement(\"div\"),d.className=\"opSug_wpr\",d.style.display=\"none\",a=document.createElement(\"table\"),\ne=document.createElement(\"tbody\"),e.id=\"sug_tbody\",a.appendChild(e),d.appendChild(a),f.parentNode.insertBefore(d,f.nextSibling)),m(b))}},pushSuggestions:function(b){n(b)}}}();</script>");
        writer.a("<script type=\"text/javascript\">function show(str){var searchbox = document.getElementById(\"search_input\"); searchbox.value = str; searchbox.blur(); search();}var params = {\"formActiveClassName\":'search_bar_active' }; OpenSuggestion.bind(\"search_input\",params,show); </script>");
        writer.a("</div></body></html>");
        writer.close();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0216  */
    /* JADX WARN: Code duplicated, block: B:101:0x0219  */
    /* JADX WARN: Code duplicated, block: B:104:0x0229  */
    /* JADX WARN: Code duplicated, block: B:105:0x022c  */
    /* JADX WARN: Code duplicated, block: B:108:0x024c  */
    /* JADX WARN: Code duplicated, block: B:110:0x025e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0279  */
    /* JADX WARN: Code duplicated, block: B:114:0x028b  */
    /* JADX WARN: Code duplicated, block: B:115:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:117:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:120:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:123:0x032e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0331  */
    /* JADX WARN: Code duplicated, block: B:127:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:128:0x04de  */
    /* JADX WARN: Code duplicated, block: B:131:0x0548 A[LOOP:0: B:131:0x0548->B:133:0x0573, LOOP_START, PHI: r1 r9
  0x0548: PHI (r1v105 int) = (r1v66 int), (r1v113 int) binds: [B:130:0x0546, B:133:0x0573] A[DONT_GENERATE, DONT_INLINE]
  0x0548: PHI (r9v5 int) = (r9v4 int), (r9v6 int) binds: [B:130:0x0546, B:133:0x0573] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:133:0x0573 A[LOOP:0: B:131:0x0548->B:133:0x0573, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:136:0x057e  */
    /* JADX WARN: Code duplicated, block: B:137:0x059d  */
    /* JADX WARN: Code duplicated, block: B:140:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:143:0x05be  */
    /* JADX WARN: Code duplicated, block: B:144:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:147:0x0625  */
    /* JADX WARN: Code duplicated, block: B:148:0x0627  */
    /* JADX WARN: Code duplicated, block: B:151:0x065d  */
    /* JADX WARN: Code duplicated, block: B:152:0x0660  */
    /* JADX WARN: Code duplicated, block: B:155:0x06a0  */
    /* JADX WARN: Code duplicated, block: B:158:0x070d  */
    /* JADX WARN: Code duplicated, block: B:161:0x0718  */
    /* JADX WARN: Code duplicated, block: B:164:0x0578 A[EDGE_INSN: B:164:0x0578->B:134:0x0578 BREAK  A[LOOP:0: B:131:0x0548->B:133:0x0573], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:40:0x0104  */
    /* JADX WARN: Code duplicated, block: B:43:0x0114  */
    /* JADX WARN: Code duplicated, block: B:44:0x0119  */
    /* JADX WARN: Code duplicated, block: B:48:0x013a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:50:0x014f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0163 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:54:0x0167  */
    /* JADX WARN: Code duplicated, block: B:56:0x016a  */
    /* JADX WARN: Code duplicated, block: B:57:0x016c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0170  */
    /* JADX WARN: Code duplicated, block: B:62:0x0173  */
    /* JADX WARN: Code duplicated, block: B:63:0x0175  */
    /* JADX WARN: Code duplicated, block: B:65:0x0178  */
    /* JADX WARN: Code duplicated, block: B:67:0x017b  */
    /* JADX WARN: Code duplicated, block: B:68:0x017e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0182  */
    /* JADX WARN: Code duplicated, block: B:73:0x0186  */
    /* JADX WARN: Code duplicated, block: B:74:0x0189  */
    /* JADX WARN: Code duplicated, block: B:77:0x018d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0191  */
    /* JADX WARN: Code duplicated, block: B:7:0x002b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0193  */
    /* JADX WARN: Code duplicated, block: B:83:0x0197  */
    /* JADX WARN: Code duplicated, block: B:85:0x019a  */
    /* JADX WARN: Code duplicated, block: B:86:0x019c  */
    /* JADX WARN: Code duplicated, block: B:88:0x019f  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:93:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:97:0x01bb  */
    /* JADX WARN: Instruction removed from duplicated block: B:110:0x025e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:114:0x028b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x014f, please report this as an issue */
    public final void b(d0 writer, f0 config) {
        boolean z10;
        String str;
        String str2;
        String str3;
        String str4;
        Object objValueOf;
        boolean z11;
        String string;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        int iH;
        int i10;
        boolean zO;
        int i11;
        String str19;
        String str20;
        String str21;
        String strB;
        int i12;
        String str22;
        String str23;
        kotlin.jvm.internal.h.f(writer, "writer");
        kotlin.jvm.internal.h.f(config, "config");
        boolean zV = config.v();
        boolean zY = config.y();
        if (config.c() != null) {
            String strC = config.c();
            kotlin.jvm.internal.h.c(strC);
            if (strC.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            z10 = false;
        }
        String str24 = "#1b1b1b";
        String str25 = !zV ? "#fafafa" : "#1b1b1b";
        String str26 = !zV ? "rgba(255,255,255,0.1)" : "rgba(0,0,0,0.1)";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rgba(");
        sb2.append(!zV ? "255, 255, 255" : "0, 0, 0");
        sb2.append(", ");
        sb2.append(config.r());
        sb2.append(')');
        String string2 = sb2.toString();
        String str27 = "rgba(233, 233, 233, " + config.r() + ')';
        String str28 = "rgba(255, 255, 255, " + config.n() + ')';
        if (zV) {
            str = "rgba(0, 0, 0, " + config.n() + ')';
        } else {
            str = "rgba(255, 255, 255, " + config.n() + ')';
        }
        String str29 = ((double) config.n()) < 0.5d ? str25 : "#1b1b1b";
        if (zV == 0) {
            str2 = str;
            str3 = ((double) config.n()) >= 0.5d ? "#1b1b1b" : "#afafaf";
            if (config.u()) {
                str4 = str3;
                z11 = zY;
                str24 = str29;
                string = str28;
                str6 = str4;
                str5 = str2;
            } else {
                if (config.u()) {
                    str4 = str3;
                } else {
                    str4 = str3;
                    if (config.n() >= 0.85d) {
                        objValueOf = Double.valueOf(0.85d);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("rgba(255, 255, 255, ");
                    sb3.append(objValueOf);
                    z11 = zY;
                    sb3.append(')');
                    string = sb3.toString();
                    if (zV == 0 || !z10) {
                        str5 = "rgba(0, 0, 0, " + objValueOf + ')';
                    } else {
                        str5 = "rgba(255, 255, 255, " + objValueOf + ')';
                    }
                    if (zV && z10) {
                        str6 = "#1b1b1b";
                    } else {
                        str6 = "#afafaf";
                    }
                }
                objValueOf = Float.valueOf(config.n());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("rgba(255, 255, 255, ");
                sb4.append(objValueOf);
                z11 = zY;
                sb4.append(')');
                string = sb4.toString();
                if (zV == 0) {
                    str5 = "rgba(0, 0, 0, " + objValueOf + ')';
                } else {
                    str5 = "rgba(0, 0, 0, " + objValueOf + ')';
                }
                if (zV) {
                    str6 = "#afafaf";
                } else {
                    str6 = "#afafaf";
                }
            }
            if (z11) {
                str7 = "#afafaf";
            } else {
                str7 = str25;
            }
            if (!z11) {
                str25 = "#afafaf";
            }
            if (z11) {
                str8 = "rgba(255,255,255,0.1)";
            } else {
                str8 = str26;
            }
            String str30 = z11 ? str26 : "rgba(255,255,255,0.1)";
            if (z11) {
                str9 = str27;
            } else {
                str9 = string2;
            }
            if (!z11) {
                string2 = str27;
            }
            if (z11) {
                str10 = str2;
            } else {
                str10 = str28;
            }
            if (!z11) {
                str28 = str2;
            }
            if (z11) {
                str11 = str4;
            } else {
                str11 = str29;
            }
            if (!z11) {
                str29 = str4;
            }
            if (z11) {
                str12 = str5;
            } else {
                str12 = string;
            }
            if (z11) {
                str5 = string;
            }
            if (z11) {
                str13 = str6;
            } else {
                str13 = str24;
            }
            if (z11) {
                str6 = str24;
            }
            if (config.u()) {
                str14 = "backdrop-filter: blur(10px);";
            } else {
                str14 = "";
            }
            writer.b("");
            writer.a("* { padding:0; margin:0; box-sizing:border-box; user-drag:none; -webkit-user-drag:none; }");
            StringBuilder sb5 = new StringBuilder();
            String str31 = str5;
            sb5.append("html { height:100%; overscroll-behavior-y:none; -webkit-focus-ring-color: transparent; -webkit-tap-highlight-color: ");
            sb5.append(str8);
            sb5.append("; -webkit-user-select: none; user-select: none; font-family: -apple-system,system-ui,sans-serif; }");
            writer.a(sb5.toString());
            writer.a("body { min-height:100%; max-width:100%; width:600px; margin: auto; text-align: center; }");
            writer.a("#gesture-indicator { height:100%; width:100%; max-width:600px; position:absolute; top:0; bottom:0; z-index:0; overflow:hidden; word-break:break-all; }");
            writer.a("#content { position: absolute; max-width: 600px; width: 100%; }");
            StringBuilder sb6 = new StringBuilder();
            sb6.append(".logo { position: relative; display: inline-block; max-width: 100%; vertical-align: middle; -webkit-tap-highlight-color: transparent; color: ");
            sb6.append(str7);
            sb6.append("; font-size: ");
            sb6.append(config.i());
            sb6.append("px; ");
            if (config.w()) {
                str15 = "font-weight: bold;";
            } else {
                str15 = "";
            }
            sb6.append(str15);
            sb6.append(' ');
            if (config.x()) {
                str16 = "font-style: italic;";
            } else {
                str16 = "";
            }
            sb6.append(str16);
            sb6.append(" white-space: normal; word-wrap: break-word; text-decoration: none; }");
            writer.a(sb6.toString());
            writer.a(".logo:active::after { content: ''; position: absolute; top: 0; right: 0; bottom: 0; left: 0; border-radius: 12px; background: currentColor; opacity: 0.12; pointer-events: none; }");
            if (config.k().length() > 0) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("img.smaller {");
                if (config.m() != 0) {
                    str22 = "width: " + config.m() + "px;";
                } else {
                    str22 = "";
                }
                sb7.append(str22);
                sb7.append(' ');
                if (config.j() != 0) {
                    str23 = "height: " + config.j() + "px;";
                } else {
                    str23 = "";
                }
                sb7.append(str23);
                sb7.append(" border-radius: ");
                sb7.append(config.l());
                sb7.append("px; object-fit: cover; }");
                writer.a(sb7.toString());
            } else {
                str28 = str28;
            }
            if (z11) {
                writer.a("img.smaller, .overlay, .title { -webkit-filter: brightness(75%); filter: brightness(75%); }");
            }
            writer.a("span { display:block; overflow:hidden; padding-left:5px; vertical-align:middle; }");
            writer.a(".search_part { display:table; vertical-align:middle; width:90%; max-width:600px; margin:0 auto 20px; padding:0; }");
            writer.a(".search.icon { width: 12px; height: 12px; border: solid 2px currentColor; border-radius: 100%; -webkit-transform: rotate(-45deg); transform: rotate(-45deg); text-align: center; margin: auto; }");
            writer.a(".search.icon:before { content: ''; position: absolute; top: 10px; left: 3px; height: 5px; width: 2px; background-color: currentColor; }");
            writer.a(".search_bar_wrapper { position: relative; display: table; width: 100%; margin: 15px auto 0; }");
            writer.a(".search_bar { position: relative; display: table; width: 100%; margin: 0; }");
            writer.a("input, button { font-family: inherit; }");
            writer.a("#search_input { -webkit-user-select: text; user-select: text; height: 46px; padding: 0 12px; width: 100%; outline: none; border: none; font-size: 15px; background-color: transparent; }");
            writer.a("#search_submit { display: none; outline: none; height: 46px; width: 56px; float: right; font-size: 15px; font-weight: bold; border: none; background-color: transparent; padding: 0 10px; }");
            writer.a("#search_bar_trigger { position: absolute; inset: 0; z-index: 1; width: 100%; height: 46px; padding: 0; border: 0; border-radius: " + config.q() + "px; background: transparent; color: inherit; }");
            writer.a("#search_bar_trigger:focus-visible { outline: 2px solid currentColor; outline-offset: 2px; }");
            StringBuilder sb8 = new StringBuilder();
            sb8.append(".search_bar {");
            if (config.p()) {
                str17 = "border-bottom";
            } else {
                str17 = "border";
            }
            sb8.append(str17);
            sb8.append(": ");
            sb8.append(config.s());
            sb8.append("px solid ");
            sb8.append(str9);
            sb8.append("; border-radius: ");
            sb8.append(config.q());
            sb8.append("px; background: ");
            sb8.append(str10);
            sb8.append("; ");
            sb8.append(str14);
            sb8.append(" }");
            writer.a(sb8.toString());
            writer.a(".search_bar { color: " + str11 + "; }");
            writer.a(".search.icon, #search_input, #search_submit { color: inherit; }");
            writer.a(".opSug_wpr { background: " + str12 + "; " + str14 + " border: " + config.s() + "px solid " + str9 + "; border-radius: 0 0 " + config.q() + "px " + config.q() + "px; overflow-y: scroll; line-height: normal; position: absolute; width: 100%; max-width: 600px; margin: -" + config.s() + "px 0 0; z-index: 9999; }");
            writer.a(".opSug_wpr::-webkit-scrollbar {width: 0;}");
            writer.a(".opSug_wpr table {background: none; padding: 0px; width: 100%; border-spacing: 0;}");
            writer.a(".opSug_wpr tr {padding: 0px; margin: 0px; display: table-row; vertical-align: inherit; border-color: inherit;}");
            writer.a(".opSug_wpr tr:hover {color: #FFF; background: #7B90E3;}");
            StringBuilder sb9 = new StringBuilder();
            sb9.append(".opSug_wpr td { color: ");
            sb9.append(str13);
            sb9.append("; font-size: 14px; padding: 10px 17px; background: none; text-align: left; vertical-align: middle; text-decoration: none; text-indent: 0px;}");
            writer.a(sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(".search_bar_active {border-radius: ");
            sb10.append(config.q());
            sb10.append("px ");
            sb10.append(config.q());
            sb10.append("px 0 0; }");
            writer.a(sb10.toString());
            writer.a(".search_bar_active { color: " + str13 + "; background: " + str12 + "; }");
            writer.a("#bookmark_part { text-align: center; max-width:600px; background-color: transparent; margin: 0 auto; padding: 0; border-radius: 0px; }");
            writer.a("#box_container { text-align: left; margin: 0 auto; font-size: 0; }");
            writer.a(".box { vertical-align: top; margin: 4px 9px 4px; width: " + config.h() + "px; border: 0; position: relative; display: inline-block; text-align: center; }");
            writer.a(".box a { width: 100%; height: 100%; position: absolute; left: 0; top: 0; }");
            writer.a(".overlay { position: absolute; left: 0; top: 0; border-radius: " + config.g() + "px; width: " + config.h() + "px; height: " + config.f() + "px; }");
            StringBuilder sb11 = new StringBuilder();
            sb11.append(".title { border-radius: ");
            sb11.append(config.g());
            sb11.append("px; color: ");
            if (config.d()) {
                str18 = str7;
            } else {
                str18 = "#ffffff";
            }
            sb11.append(str18);
            sb11.append("; width: ");
            sb11.append(config.h());
            sb11.append("px; line-height: ");
            sb11.append(config.f());
            sb11.append("px; height: ");
            sb11.append(config.f());
            sb11.append("px; font-size: 15px; }");
            writer.a(sb11.toString());
            writer.a(".url { color: " + str7 + "; margin: 2px 0 0; width: " + config.h() + "px; height: 20px; line-height: 20px; white-space: normal; word-wrap: break-word; overflow: hidden; text-overflow: clip; ms-text-overflow: clip; font-size: 10px; }");
            iH = config.h() + 18;
            i10 = 540 / iH;
            zO = config.o();
            i11 = 1;
            if (1 <= i10) {
                while (true) {
                    StringBuilder sb12 = new StringBuilder();
                    i12 = iH;
                    sb12.append("@media only screen and (min-width: ");
                    sb12.append((i11 + (zO ? 1 : 0)) * i12);
                    sb12.append("px) { #box_container { width: ");
                    sb12.append(i12 * i11);
                    sb12.append("px } }");
                    writer.a(sb12.toString());
                    if (i11 != i10) {
                        break;
                    }
                    i11++;
                    iH = i12;
                }
            }
            if (config.o()) {
                writer.a("#content { top: 25%; transition: 0.14s; }");
                writer.a("@media only screen and (min-height:250px) { #content { top: 62px } }");
                writer.a("@media only screen and (min-height:350px) { #content { top: 87px } }");
                writer.a("@media only screen and (min-height:450px) { #content { top: 135px } }");
                writer.a("@media only screen and (min-height:650px) { #content { top: 195px } }");
                writer.a("@media only screen and (min-height:850px) { #content { top: 255px } }");
            } else {
                writer.a("#content { top: 18px; transition: opacity .14s; } .search_part { display: none; }");
            }
            if (config.z()) {
                writer.a("html { direction: rtl; } #box_container { text-align: right; } #search_submit { float: left; }");
            }
            writer.a(".sort-ghost { opacity: 0.3; }");
            StringBuilder sb13 = new StringBuilder();
            sb13.append("@media (prefers-color-scheme:");
            if (z11) {
                str19 = "light";
            } else {
                str19 = "dark";
            }
            sb13.append(str19);
            sb13.append("){");
            writer.a(sb13.toString());
            writer.a("html { -webkit-tap-highlight-color: " + str30 + "; }");
            writer.a(".logo { color: " + str25 + "; }");
            writer.a(".opSug_wpr td { color: " + str29 + "; }");
            StringBuilder sb14 = new StringBuilder();
            sb14.append(".title { color: ");
            if (config.d()) {
                str20 = str25;
            } else {
                str20 = "#ffffff";
            }
            sb14.append(str20);
            sb14.append("; }");
            writer.a(sb14.toString());
            writer.a(".url { color: " + str25 + "; }");
            StringBuilder sb15 = new StringBuilder();
            sb15.append(".search_bar { ");
            if (config.p()) {
                str21 = "border-bottom";
            } else {
                str21 = "border";
            }
            sb15.append(str21);
            sb15.append(": ");
            sb15.append(config.s());
            sb15.append("px solid ");
            sb15.append(string2);
            sb15.append("; background: ");
            sb15.append(str28);
            sb15.append("; }");
            writer.a(sb15.toString());
            writer.a(".search_bar { color: " + str29 + "; }");
            if (!z11) {
                writer.a("img.smaller, .overlay, .title { -webkit-filter: brightness(75%); filter: brightness(75%); }");
            }
            writer.a(".opSug_wpr { background: " + str31 + "; border: " + config.s() + "px solid " + string2 + "; }");
            StringBuilder sb16 = new StringBuilder();
            sb16.append(".search_bar_active { color: ");
            String str32 = str6;
            sb16.append(str32);
            sb16.append("; background: ");
            sb16.append(str31);
            sb16.append("; }");
            writer.a(sb16.toString());
            writer.a(".opSug_wpr td { color: " + str32 + "; }");
            writer.a("}");
            if (config.t()) {
                writer.a("#search_bar_trigger { display: none; }");
            }
            strB = config.b();
            if (strB != null) {
                writer.a(strB);
            }
            writer.close();
        }
        str2 = str;
        if (config.u()) {
            str4 = str3;
            z11 = zY;
            str24 = str29;
            string = str28;
            str6 = str4;
            str5 = str2;
        } else {
            if (config.u()) {
                str4 = str3;
                if (config.n() >= 0.85d) {
                    objValueOf = Double.valueOf(0.85d);
                }
                StringBuilder sb17 = new StringBuilder();
                sb17.append("rgba(255, 255, 255, ");
                sb17.append(objValueOf);
                z11 = zY;
                sb17.append(')');
                string = sb17.toString();
                if (zV == 0) {
                    str5 = "rgba(0, 0, 0, " + objValueOf + ')';
                } else {
                    str5 = "rgba(0, 0, 0, " + objValueOf + ')';
                }
                if (zV) {
                    str6 = "#afafaf";
                } else {
                    str6 = "#afafaf";
                }
            } else {
                str4 = str3;
            }
            objValueOf = Float.valueOf(config.n());
            StringBuilder sb18 = new StringBuilder();
            sb18.append("rgba(255, 255, 255, ");
            sb18.append(objValueOf);
            z11 = zY;
            sb18.append(')');
            string = sb18.toString();
            if (zV == 0) {
                str5 = "rgba(0, 0, 0, " + objValueOf + ')';
            } else {
                str5 = "rgba(0, 0, 0, " + objValueOf + ')';
            }
            if (zV) {
                str6 = "#afafaf";
            } else {
                str6 = "#afafaf";
            }
        }
        if (z11) {
            str7 = "#afafaf";
        } else {
            str7 = str25;
        }
        if (!z11) {
            str25 = "#afafaf";
        }
        if (z11) {
            str8 = "rgba(255,255,255,0.1)";
        } else {
            str8 = str26;
        }
        if (z11) {
        }
        if (z11) {
            str9 = str27;
        } else {
            str9 = string2;
        }
        if (!z11) {
            string2 = str27;
        }
        if (z11) {
            str10 = str2;
        } else {
            str10 = str28;
        }
        if (!z11) {
            str28 = str2;
        }
        if (z11) {
            str11 = str4;
        } else {
            str11 = str29;
        }
        if (!z11) {
            str29 = str4;
        }
        if (z11) {
            str12 = str5;
        } else {
            str12 = string;
        }
        if (z11) {
            str5 = string;
        }
        if (z11) {
            str13 = str6;
        } else {
            str13 = str24;
        }
        if (z11) {
            str6 = str24;
        }
        if (config.u()) {
            str14 = "backdrop-filter: blur(10px);";
        } else {
            str14 = "";
        }
        writer.b("");
        writer.a("* { padding:0; margin:0; box-sizing:border-box; user-drag:none; -webkit-user-drag:none; }");
        StringBuilder sb19 = new StringBuilder();
        String str33 = str5;
        sb19.append("html { height:100%; overscroll-behavior-y:none; -webkit-focus-ring-color: transparent; -webkit-tap-highlight-color: ");
        sb19.append(str8);
        sb19.append("; -webkit-user-select: none; user-select: none; font-family: -apple-system,system-ui,sans-serif; }");
        writer.a(sb19.toString());
        writer.a("body { min-height:100%; max-width:100%; width:600px; margin: auto; text-align: center; }");
        writer.a("#gesture-indicator { height:100%; width:100%; max-width:600px; position:absolute; top:0; bottom:0; z-index:0; overflow:hidden; word-break:break-all; }");
        writer.a("#content { position: absolute; max-width: 600px; width: 100%; }");
        StringBuilder sb20 = new StringBuilder();
        sb20.append(".logo { position: relative; display: inline-block; max-width: 100%; vertical-align: middle; -webkit-tap-highlight-color: transparent; color: ");
        sb20.append(str7);
        sb20.append("; font-size: ");
        sb20.append(config.i());
        sb20.append("px; ");
        if (config.w()) {
            str15 = "font-weight: bold;";
        } else {
            str15 = "";
        }
        sb20.append(str15);
        sb20.append(' ');
        if (config.x()) {
            str16 = "font-style: italic;";
        } else {
            str16 = "";
        }
        sb20.append(str16);
        sb20.append(" white-space: normal; word-wrap: break-word; text-decoration: none; }");
        writer.a(sb20.toString());
        writer.a(".logo:active::after { content: ''; position: absolute; top: 0; right: 0; bottom: 0; left: 0; border-radius: 12px; background: currentColor; opacity: 0.12; pointer-events: none; }");
        if (config.k().length() > 0) {
            StringBuilder sb21 = new StringBuilder();
            sb21.append("img.smaller {");
            if (config.m() != 0) {
                str22 = "width: " + config.m() + "px;";
            } else {
                str22 = "";
            }
            sb21.append(str22);
            sb21.append(' ');
            if (config.j() != 0) {
                str23 = "height: " + config.j() + "px;";
            } else {
                str23 = "";
            }
            sb21.append(str23);
            sb21.append(" border-radius: ");
            sb21.append(config.l());
            sb21.append("px; object-fit: cover; }");
            writer.a(sb21.toString());
        } else {
            str28 = str28;
        }
        if (z11) {
            writer.a("img.smaller, .overlay, .title { -webkit-filter: brightness(75%); filter: brightness(75%); }");
        }
        writer.a("span { display:block; overflow:hidden; padding-left:5px; vertical-align:middle; }");
        writer.a(".search_part { display:table; vertical-align:middle; width:90%; max-width:600px; margin:0 auto 20px; padding:0; }");
        writer.a(".search.icon { width: 12px; height: 12px; border: solid 2px currentColor; border-radius: 100%; -webkit-transform: rotate(-45deg); transform: rotate(-45deg); text-align: center; margin: auto; }");
        writer.a(".search.icon:before { content: ''; position: absolute; top: 10px; left: 3px; height: 5px; width: 2px; background-color: currentColor; }");
        writer.a(".search_bar_wrapper { position: relative; display: table; width: 100%; margin: 15px auto 0; }");
        writer.a(".search_bar { position: relative; display: table; width: 100%; margin: 0; }");
        writer.a("input, button { font-family: inherit; }");
        writer.a("#search_input { -webkit-user-select: text; user-select: text; height: 46px; padding: 0 12px; width: 100%; outline: none; border: none; font-size: 15px; background-color: transparent; }");
        writer.a("#search_submit { display: none; outline: none; height: 46px; width: 56px; float: right; font-size: 15px; font-weight: bold; border: none; background-color: transparent; padding: 0 10px; }");
        writer.a("#search_bar_trigger { position: absolute; inset: 0; z-index: 1; width: 100%; height: 46px; padding: 0; border: 0; border-radius: " + config.q() + "px; background: transparent; color: inherit; }");
        writer.a("#search_bar_trigger:focus-visible { outline: 2px solid currentColor; outline-offset: 2px; }");
        StringBuilder sb22 = new StringBuilder();
        sb22.append(".search_bar {");
        if (config.p()) {
            str17 = "border-bottom";
        } else {
            str17 = "border";
        }
        sb22.append(str17);
        sb22.append(": ");
        sb22.append(config.s());
        sb22.append("px solid ");
        sb22.append(str9);
        sb22.append("; border-radius: ");
        sb22.append(config.q());
        sb22.append("px; background: ");
        sb22.append(str10);
        sb22.append("; ");
        sb22.append(str14);
        sb22.append(" }");
        writer.a(sb22.toString());
        writer.a(".search_bar { color: " + str11 + "; }");
        writer.a(".search.icon, #search_input, #search_submit { color: inherit; }");
        writer.a(".opSug_wpr { background: " + str12 + "; " + str14 + " border: " + config.s() + "px solid " + str9 + "; border-radius: 0 0 " + config.q() + "px " + config.q() + "px; overflow-y: scroll; line-height: normal; position: absolute; width: 100%; max-width: 600px; margin: -" + config.s() + "px 0 0; z-index: 9999; }");
        writer.a(".opSug_wpr::-webkit-scrollbar {width: 0;}");
        writer.a(".opSug_wpr table {background: none; padding: 0px; width: 100%; border-spacing: 0;}");
        writer.a(".opSug_wpr tr {padding: 0px; margin: 0px; display: table-row; vertical-align: inherit; border-color: inherit;}");
        writer.a(".opSug_wpr tr:hover {color: #FFF; background: #7B90E3;}");
        StringBuilder sb23 = new StringBuilder();
        sb23.append(".opSug_wpr td { color: ");
        sb23.append(str13);
        sb23.append("; font-size: 14px; padding: 10px 17px; background: none; text-align: left; vertical-align: middle; text-decoration: none; text-indent: 0px;}");
        writer.a(sb23.toString());
        StringBuilder sb110 = new StringBuilder();
        sb110.append(".search_bar_active {border-radius: ");
        sb110.append(config.q());
        sb110.append("px ");
        sb110.append(config.q());
        sb110.append("px 0 0; }");
        writer.a(sb110.toString());
        writer.a(".search_bar_active { color: " + str13 + "; background: " + str12 + "; }");
        writer.a("#bookmark_part { text-align: center; max-width:600px; background-color: transparent; margin: 0 auto; padding: 0; border-radius: 0px; }");
        writer.a("#box_container { text-align: left; margin: 0 auto; font-size: 0; }");
        writer.a(".box { vertical-align: top; margin: 4px 9px 4px; width: " + config.h() + "px; border: 0; position: relative; display: inline-block; text-align: center; }");
        writer.a(".box a { width: 100%; height: 100%; position: absolute; left: 0; top: 0; }");
        writer.a(".overlay { position: absolute; left: 0; top: 0; border-radius: " + config.g() + "px; width: " + config.h() + "px; height: " + config.f() + "px; }");
        StringBuilder sb111 = new StringBuilder();
        sb111.append(".title { border-radius: ");
        sb111.append(config.g());
        sb111.append("px; color: ");
        if (config.d()) {
            str18 = str7;
        } else {
            str18 = "#ffffff";
        }
        sb111.append(str18);
        sb111.append("; width: ");
        sb111.append(config.h());
        sb111.append("px; line-height: ");
        sb111.append(config.f());
        sb111.append("px; height: ");
        sb111.append(config.f());
        sb111.append("px; font-size: 15px; }");
        writer.a(sb111.toString());
        writer.a(".url { color: " + str7 + "; margin: 2px 0 0; width: " + config.h() + "px; height: 20px; line-height: 20px; white-space: normal; word-wrap: break-word; overflow: hidden; text-overflow: clip; ms-text-overflow: clip; font-size: 10px; }");
        iH = config.h() + 18;
        i10 = 540 / iH;
        zO = config.o();
        i11 = 1;
        if (1 <= i10) {
            while (true) {
                StringBuilder sb112 = new StringBuilder();
                i12 = iH;
                sb112.append("@media only screen and (min-width: ");
                sb112.append((i11 + (zO ? 1 : 0)) * i12);
                sb112.append("px) { #box_container { width: ");
                sb112.append(i12 * i11);
                sb112.append("px } }");
                writer.a(sb112.toString());
                if (i11 != i10) {
                    break;
                    break;
                } else {
                    i11++;
                    iH = i12;
                }
            }
        }
        if (config.o()) {
            writer.a("#content { top: 25%; transition: 0.14s; }");
            writer.a("@media only screen and (min-height:250px) { #content { top: 62px } }");
            writer.a("@media only screen and (min-height:350px) { #content { top: 87px } }");
            writer.a("@media only screen and (min-height:450px) { #content { top: 135px } }");
            writer.a("@media only screen and (min-height:650px) { #content { top: 195px } }");
            writer.a("@media only screen and (min-height:850px) { #content { top: 255px } }");
        } else {
            writer.a("#content { top: 18px; transition: opacity .14s; } .search_part { display: none; }");
        }
        if (config.z()) {
            writer.a("html { direction: rtl; } #box_container { text-align: right; } #search_submit { float: left; }");
        }
        writer.a(".sort-ghost { opacity: 0.3; }");
        StringBuilder sb113 = new StringBuilder();
        sb113.append("@media (prefers-color-scheme:");
        if (z11) {
            str19 = "light";
        } else {
            str19 = "dark";
        }
        sb113.append(str19);
        sb113.append("){");
        writer.a(sb113.toString());
        writer.a("html { -webkit-tap-highlight-color: " + str30 + "; }");
        writer.a(".logo { color: " + str25 + "; }");
        writer.a(".opSug_wpr td { color: " + str29 + "; }");
        StringBuilder sb114 = new StringBuilder();
        sb114.append(".title { color: ");
        if (config.d()) {
            str20 = str25;
        } else {
            str20 = "#ffffff";
        }
        sb114.append(str20);
        sb114.append("; }");
        writer.a(sb114.toString());
        writer.a(".url { color: " + str25 + "; }");
        StringBuilder sb115 = new StringBuilder();
        sb115.append(".search_bar { ");
        if (config.p()) {
            str21 = "border-bottom";
        } else {
            str21 = "border";
        }
        sb115.append(str21);
        sb115.append(": ");
        sb115.append(config.s());
        sb115.append("px solid ");
        sb115.append(string2);
        sb115.append("; background: ");
        sb115.append(str28);
        sb115.append("; }");
        writer.a(sb115.toString());
        writer.a(".search_bar { color: " + str29 + "; }");
        if (!z11) {
            writer.a("img.smaller, .overlay, .title { -webkit-filter: brightness(75%); filter: brightness(75%); }");
        }
        writer.a(".opSug_wpr { background: " + str33 + "; border: " + config.s() + "px solid " + string2 + "; }");
        StringBuilder sb116 = new StringBuilder();
        sb116.append(".search_bar_active { color: ");
        String str34 = str6;
        sb116.append(str34);
        sb116.append("; background: ");
        sb116.append(str33);
        sb116.append("; }");
        writer.a(sb116.toString());
        writer.a(".opSug_wpr td { color: " + str34 + "; }");
        writer.a("}");
        if (config.t()) {
            writer.a("#search_bar_trigger { display: none; }");
        }
        strB = config.b();
        if (strB != null) {
            writer.a(strB);
        }
        writer.close();
    }

    public final String c(g0 g0Var, boolean z10, boolean z11) {
        String str;
        String strD = g0Var.d();
        String str2 = "";
        if (strD == null) {
            strD = "";
        }
        String strE = g0Var.e();
        if (strE == null) {
            strE = "";
        }
        String strA = g0Var.a();
        boolean z12 = true;
        boolean z13 = strA == null || strA.length() == 0 || z10;
        String strB = g0Var.b();
        if (strB != null && strB.length() != 0 && !z11) {
            z12 = false;
        }
        String str3 = "background: url('" + g0Var.b() + "') no-repeat;background-size: cover;background-position:center center;";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<div class=\"box\"><p class=\"title\" aria-hidden=\"true\" ");
        if (z13) {
            str = "";
        } else {
            str = " style=\"background:" + g0Var.a() + ";\"";
        }
        sb2.append(str);
        sb2.append('>');
        String strC = g0Var.c();
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
