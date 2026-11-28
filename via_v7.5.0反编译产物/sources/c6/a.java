package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1955a = new a();

    public final String a(String bridge, String secret) {
        kotlin.jvm.internal.h.f(bridge, "bridge");
        kotlin.jvm.internal.h.f(secret, "secret");
        return "(function(e,t){if(void 0!==window.__setMarkerEnabled)return;var n=0,i=!1;function r(i){if(\"LEGACY\"!==e){i.secret=t;i.session=n;if(\"WEBKIT\"===e){var r=window.__viaDocument;i.document=r.id;if(102===i.action){r.markerRevision=(r.markerRevision||0)+1;i.revision=r.markerRevision}window.webkit.messageHandlers.viaAdMarking.postMessage(i)}else window.via2.postMessage(JSON.stringify(i))}else window.via.postMessage(t,JSON.stringify(i))}var o=!1,a=null,c=[],u=-1,s=null;const l=function(e){a=e.target;if(!0===o){i||e.target===c[u]&&\"touchstart\"!==e.type&&\"touchend\"!==e.type&&\"click\"!==e.type||d(e.target);e.cancelable&&e.preventDefault();e.stopImmediatePropagation()}};function f(e,t){var n=document.getElementById(\"__via_marker__\");if(!n){if(!e)return;(n=document.createElement(\"style\")).id=\"__via_marker__\";document.head.appendChild(n)}const i=e?e+(t?\"{display:none!important;}\":\"{outline:3px solid red!important;outline-offset:-3px!important;}\"):\"\";n.textContent!==i&&(n.textContent=i)}function d(e){if(!e||1!==e.nodeType||!document.documentElement.contains(e))return;const t=c.indexOf(e);if(t<0){c=[e];u=0}else u=t;f(s=m(e,[]).reverse().join(\">\"));r({action:102,host:location.host,filter:s})}function m(e,t=[]){if(!e||t.length>=3)return t;if(\"BODY\"===e.nodeName){t.push(\"body\");return t}const n=e.parentElement;if(\"object\"!=typeof e||null==e.getAttribute)return m(n,t);const i=e.getAttribute(\"id\");if(i&&document.getElementById(i)==e){t.push(\"#\"+w(i));return t}const r=function(e){if(!e)return null;const t=e.split(/[\\t\\n\\f\\r ]+/);var n=null,i=Infinity,r=0;for(const e of t)if(e){if(1===(r=document.getElementsByClassName(e).length))return e;if(r>0&&r<i){i=r;n=e}}return n}(e.getAttribute(\"class\"));if(r){t.push(\".\"+w(r));return t}const o=function(e,t){if(!e||!t)return null;var n,i=null,r=-1,o=0;const a=w(e);for(let e of t){if(!e||!e.value||!e.name)continue;const t=e.value.indexOf(\"?\"),c=t>5?e.value.slice(0,t):e.value;n=a+\"[\"+w(e.name)+(t>5?'^=\"':'=\"')+_(c)+'\"]';try{o=document.querySelectorAll(n).length}catch(e){if(\"SyntaxError\"!==e.name)throw e;continue}if(1===o)return n;if(o>0&&(r<0||o<r)){r=o;i=n}}return i}(e.localName,e.attributes);if(o){t.push(o);return t}t.push(w(e.localName));return m(n,t)}function w(e){var t=\"\";for(let n=0;n<e.length;n++){const i=e.charCodeAt(n);0===i?t+=\"�\":i>=48&&i<=57&&(0===n||1===n&&\"-\"===e[0])||i<32||127===i?t+=\"\\\\\"+i.toString(16)+\" \":i>=128||/[a-zA-Z0-9_-]/.test(e[n])&&\"-\"!==e?t+=e[n]:t+=\"\\\\\"+e[n]}return t}function _(e){return e.replace(/[\\0-\\x1f\\x7f\"\\\\]/g,function(e){return\"\\0\"===e?\"�\":\"\\\\\"+e.charCodeAt(0).toString(16)+\" \"})}window.__setMarkerPreview=function(e){f(s,e)};window.__clearMarker=function(){s=null;f(null);c=[];u=-1};window.__setMarkerPaused=function(e){i=e};window.__setMarkerEnabled=function(e,t){o!==e&&function(e){[\"touchstart\",\"touchend\",\"touchmove\",\"touchcancel\",\"click\"].forEach(function(t){e?window.addEventListener(t,l,{capture:!0,passive:!1}):window.removeEventListener(t,l,!0)})}(e);o=e;n=t||0;i=!1;!1===e?window.__clearMarker():d(a)};window.__getMarkerFilter=function(){s&&document.documentElement.contains(c[u])&&r({action:103,host:location.host,filter:s})};window.__markParent=function(){if(u>0)d(c[u-1]);else{var e=c[u];if(e&&e!==document.body&&e.parentElement){c.unshift(e.parentElement);d(e.parentElement)}}};window.__markChild=function(){if(u<c.length-1)d(c[u+1]);else{var e=c[u];if(e&&e.firstElementChild){c.push(e.firstElementChild);d(e.firstElementChild)}}};[\"touchstart\",\"click\"].forEach(function(e){document.addEventListener(e,l,{capture:!0,passive:!0})});\"LEGACY\"!==e&&window.addEventListener(\"pagehide\",function(){window.__setMarkerEnabled(!1)});if(\"FRAME\"===e){function p(){window.via2.postMessage(JSON.stringify({secret:t,action:117,url:location.href}))}window.addEventListener(\"pageshow\",function(e){e.persisted&&p()});p()}})(" + bridge + ',' + secret + ");";
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
        return "(function(){var e=document.getElementById(\"__via__marker_temp__\");if(e)e.appendChild(document.createTextNode(\"" + element + "{display:none !important}\"));else{(e=document.createElement(\"style\")).type=\"text/css\";e.charset=\"UTF-8\";e.id=\"__via__marker_temp__\";e.appendChild(document.createTextNode(\"" + element + "{display:none !important}\"));document.head.appendChild(e)}})();";
    }

    public final String f() {
        return "try{window.__getMarkerFilter()}catch(r){}";
    }

    public final String g() {
        return "try{window.__markChild()}catch(a){}";
    }
}
