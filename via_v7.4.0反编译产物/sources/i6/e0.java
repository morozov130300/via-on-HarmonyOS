package i6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f6989a = new e0();

    public final String a(String langs, String fallback) {
        kotlin.jvm.internal.h.f(langs, "langs");
        kotlin.jvm.internal.h.f(fallback, "fallback");
        return "(function(){if(window.__via_translator__)window.__via_translator__.showBanner(!0);else{window.googleTranslateElementInit=function(){window.__via_translator__||(window.__via_translator__=new google.translate.TranslateElement({autoDisplay:!1,floatPosition:0,multilanguagePage:!0,includedLanguages:\"" + langs + "\",pageLanguage:\"auto\"}));window.__via_translator__.showBanner(!0)};var e=document.createElement(\"script\");e.src=\"https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\";document.getElementsByTagName(\"head\")[0].appendChild(e)}document.addEventListener(\"securitypolicyviolation\",function e(n){" + fallback + ";document.removeEventListener(\"securitypolicyviolation\",e)})})();";
    }

    public final String b(String lang, String fallback) {
        kotlin.jvm.internal.h.f(lang, "lang");
        kotlin.jvm.internal.h.f(fallback, "fallback");
        return "(function(){var e=\"via-translate-bridge\",t=document.getElementById(e);if(t)if(\"undefined\"!=typeof translate)\"" + lang + "\"!=translate.to&&translate.changeLanguage(\"" + lang + "\");else{var n=document.createElement(\"script\");n.id=e;n.src=t.src;n.onload=t.onload;t.parentNode.replaceChild(n,t)}else{(t=document.createElement(\"script\")).id=e;t.src=\"https://fastly.jsdelivr.net/gh/xnx3/translate@v3.14.0/translate.js/translate.min.js\";t.onload=function(){translate.selectLanguageTag.show=!1;translate.service.use(\"client.edge\");translate.changeLanguage(\"" + lang + "\")};document.head.appendChild(t)}document.addEventListener(\"securitypolicyviolation\",function e(t){" + fallback + ";document.removeEventListener(\"securitypolicyviolation\",e)})})();";
    }
}
