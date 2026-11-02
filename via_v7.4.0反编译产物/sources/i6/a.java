package i6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6979a = new a();

    public final String a(String secret) {
        kotlin.jvm.internal.h.f(secret, "secret");
        return "(function(){if(void 0!==window.__setMarkerEnabled)return;var e=!1,t=null,n=!1,r=[],i=-1;const o=function(n){t=n;if(!0===e){s(n);n.preventDefault()}};(function(){var e=document.getElementById(\"__via_marker__\");if(!e){(e=document.createElement(\"style\")).type=\"text/css\";e.charset=\"UTF-8\";e.id=\"__via_marker__\";e.appendChild(document.createTextNode(\"\"));document.head.appendChild(e)}})();function l(e){const t=document.getElementById(\"__via_marker__\");t&&(t.innerText=e?e+\"{border:5px solid red!important;}\":\"\")}function u(){return a(i)}function a(e){return e<0||e>=r.length?null:r[e]}function c(e,t){if(t){e=Math.min(Math.max(0,e),r.length);r.splice(e,0,t)}}function f(e){document.removeEventListener(e,o);document.addEventListener(e,o,!1)}function s(e){var t=e||event,n=t.srcElement?t.srcElement:t.target;d(n=n||e)}function d(e){if(!e)return;const t=(o=e)?r.indexOf(o):-1;var o;if(t<0){r=[e];i=0}else i=t;const u=m(e,[]).reverse().join(\">\");l(u);if(!0===n){try{var a=location.host;a&&window.via.postMessage(\"" + secret + "\",JSON.stringify({action:103,host:a,filter:u}))}catch(e){}n=!1}else window.via.postMessage(\"" + secret + "\",JSON.stringify({action:102,filter:u}))}function m(e,t=[]){if(!e||t.length>=3)return t;if(\"BODY\"===e.nodeName){t.push(\"body\");return t}const n=e.parentElement;if(\"object\"!=typeof e||null==e.getAttribute)return m(n,t);const r=e.getAttribute(\"id\");if(r&&document.getElementById(r)==e){t.push(\"#\"+r);return t}const i=function(e){if(!e)return null;const t=e.split(\" \");var n=null,r=Infinity,i=0;for(const e of t)if(e&&(i=document.getElementsByClassName(e).length)>0&&i<r){r=i;n=e}return n}(e.getAttribute(\"class\"));if(i){t.push(\".\"+i);return t}const o=function(e,t){if(!e||!t)return null;var n,r,i=null,o=-1,l=0;for(let u of t)if(u&&u.value&&u.name){n=(r=u.value.indexOf(\"?\"))>5?e+\"[\"+u.name+'^=\"'+u.value.slice(0,r).replaceAll('\"',\"'\")+'\"]':e+\"[\"+u.name+'=\"'+u.value.replaceAll('\"',\"'\")+'\"]';if((l=document.querySelectorAll(n).length)>0&&(o<0||l<o)){o=l;i=n}}return i}(e.localName,e.attributes);if(o){t.push(o);return t}t.push(e.localName);return m(n,t)}window.__setMarkerEnabled=function(n){e=n;!1===n?l(null):t&&s(t)};window.__getMarkerFilter=function(){var e=u();if(e){n=!0;d(e)}};window.__markParent=function(){if(i>0)d(a(i-1));else{var e=u();if(e&&e.parentNode){c(0,e.parentNode);d(e.parentNode)}}};window.__markChild=function(){if(i<r.length-1)d(a(i+1));else{var e=u();if(e&&e.firstElementChild){c(i+1,e.firstElementChild);d(e.firstElementChild)}}};f(\"touchstart\");f(\"touchend\");f(\"touchmove\");f(\"touchcancel\");f(\"touchdown\");f(\"click\")})();";
    }

    public final String b() {
        return "try{window.__setMarkerEnabled(!1)}catch(a){}";
    }

    public final String c() {
        return "try{window.__setMarkerEnabled(!0)}catch(a){}";
    }

    public final String d() {
        return "try{window.__markParent()}catch(a){}";
    }

    public final String e(String element) {
        kotlin.jvm.internal.h.f(element, "element");
        return "(function(){var e=document.getElementById(\"__via__marker_temp__\");if(e)e.innerText+=\"" + element + "{display:none !important}\";else{(e=document.createElement(\"style\")).type=\"text/css\";e.charset=\"UTF-8\";e.id=\"__via__marker_temp__\";e.appendChild(document.createTextNode(\"" + element + "{display:none !important}\"));document.head.appendChild(e)}})();";
    }

    public final String f() {
        return "try{window.__getMarkerFilter()}catch(r){}";
    }

    public final String g() {
        return "try{window.__markChild()}catch(a){}";
    }
}
