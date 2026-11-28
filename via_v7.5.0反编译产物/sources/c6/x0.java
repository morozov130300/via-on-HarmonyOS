package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f2135a = new x0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2136b = "(function () {\n    var urls = [], seen = Object.create(null);\n    for (var i = 0; i < document.images.length; i++) {\n        var image = document.images[i], url = image.currentSrc || image.src;\n        if (url && !seen[url] && image.width >= 100 && image.height >= 100) {\n            seen[url] = true;\n            urls.push(url);\n        }\n    }\n    return urls;\n})()";

    public final String a(String title, String emptyMessage) {
        kotlin.jvm.internal.h.f(title, "title");
        kotlin.jvm.internal.h.f(emptyMessage, "emptyMessage");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n        (function () {\n            var urls = ");
        sb2.append(f2136b);
        sb2.append(";\n            if (!urls.length) { alert(");
        b2 b2Var = b2.f1963a;
        sb2.append(b2Var.o(emptyMessage));
        sb2.append("); return; }\n            var tab = window.open('');\n            if (!tab) return;\n            var data = urls.map(function (url, index) {\n                return '<figure><img ' + (index === 0 ? \"fetchpriority='high'\" : \"loading='lazy'\") + ' src=\"' + url.replace(/&/g, '&amp;').replace(/\"/g, '&quot;').replace(/</g, '&lt;') + '\"/></figure>';\n            }).join('');\n            tab.document.write(");
        sb2.append(b2Var.o(b(title)));
        sb2.append(" + data + ");
        sb2.append(b2Var.o("</main><script>\n        var gallery = document.getElementById('images');\n        function update(image) {\n            image.parentNode.className = image.complete ? (image.naturalWidth ? '' : 'failed') : 'pending';\n        }\n        for (var i = 0; i < gallery.children.length; i++) {\n            var image = gallery.children[i].firstElementChild;\n            image.onload = image.onerror = function () { update(this); };\n            update(image);\n        }\n        var requestedImage;\n        gallery.onclick = function (event) {\n            if (event.target.tagName !== 'IMG') return;\n            var loading = !!requestedImage;\n            requestedImage = event.target;\n            if (loading) return;\n\n            var base = 'https://fastly.jsdelivr.net/npm/viewerjs@1.15.2/dist/viewer.min.';\n            var style = document.createElement('link'), script = document.createElement('script');\n            style.rel = 'stylesheet';\n            style.href = base + 'css';\n            script.src = base + 'js';\n            style.crossOrigin = script.crossOrigin = 'anonymous';\n            style.integrity = 'sha384-BSBuKICRQ2XNfYlPRYkFjFP6NUWgmM8f2CtD4N71dVMc2o1OE0vyD3Aqsy7fuB4j';\n            script.integrity = 'sha384-59EfRojZgdfp9RBZ6XG8oNLPZrUi/M5VSZOJRMiVzE3Nace4pbWfz8qwpCDRgl3o';\n            var ready = 0;\n            style.onload = script.onload = function () {\n                if (++ready !== 2) return;\n                gallery.onclick = null;\n                var viewer = new Viewer(gallery, {toolbar:{zoomIn:true,zoomOut:true,oneToOne:true,reset:true,prev:true,next:true,rotateLeft:true}});\n                viewer.view(Array.prototype.indexOf.call(gallery.children, requestedImage.parentNode));\n                requestedImage = null;\n            };\n            style.onerror = script.onerror = function () {\n                style.onload = script.onload = style.onerror = script.onerror = null;\n                style.remove();\n                script.remove();\n                requestedImage = null;\n            };\n            document.head.insertBefore(style, document.head.querySelector('style'));\n            document.head.appendChild(script);\n        };\n        </script></body></html>"));
        sb2.append(");\n            tab.document.close();\n            tab.focus();\n        })();\n    ");
        return kotlin.text.q.i(sb2.toString());
    }

    public final String b(String str) {
        return kotlin.text.q.i("\n        <!doctype html><html><head><meta charset=\"utf-8\">\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n        <meta name=\"color-scheme\" content=\"light dark\"><title>" + b0.f1960a.d(str) + "</title>\n        <style>\n        body{margin:0;background:#fff;color:#58606a}\n        figure{margin:0;text-align:center;background:#f2f3f5}\n        figure.pending,figure.failed{min-height:120px;position:relative}\n        .pending:before{content:\"\";position:absolute;top:50%;left:50%;margin:-12px;border:2px solid currentColor;\n          border-right-color:transparent;border-radius:50%;width:20px;height:20px;animation:spin 1s linear infinite}\n        @keyframes spin{to{transform:rotate(360deg)}}\n        @media(prefers-reduced-motion:reduce){.pending:before{animation:none}}\n        #images img{display:block;max-width:100%;margin:auto}\n        .failed{display:flex;align-items:center;justify-content:center}\n        @media(prefers-color-scheme:dark){body{background:#111;color:#bec4cc}figure{background:#202124}}\n        .viewer-backdrop{background-color:rgba(0,0,0,.9)}\n        .viewer-toolbar>ul>li{width:32px;height:32px;padding:4px;box-sizing:border-box}\n        </style></head><body><main id=\"images\">\n    ");
    }
}
