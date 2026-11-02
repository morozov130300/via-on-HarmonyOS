package z8;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q3 {

    /* renamed from: a, reason: collision with root package name */
    public final TextToSpeech f14741a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f14742b;

    /* renamed from: c, reason: collision with root package name */
    public String f14743c;

    /* renamed from: e, reason: collision with root package name */
    public float f14745e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public String f14746f = null;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f14747g = null;

    /* renamed from: d, reason: collision with root package name */
    public int f14744d = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends UtteranceProgressListener {
        public a() {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(String str) {
            q3.this.f14744d = 1;
            if (q3.this.f14742b == null || !str.equals(q3.this.f14743c)) {
                return;
            }
            q3.this.f14742b.run();
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(String str) {
            q3.this.f14744d = 1;
            if (q3.this.f14742b == null || !str.equals(q3.this.f14743c)) {
                return;
            }
            q3.this.f14742b.run();
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(String str) {
        }
    }

    public q3(Context context) {
        this.f14741a = new TextToSpeech(context, new TextToSpeech.OnInitListener() { // from class: z8.p3
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public final void onInit(int i10) {
                q3.a(this.f14735a, i10);
            }
        });
    }

    public static /* synthetic */ void a(q3 q3Var, int i10) {
        if (i10 != 0) {
            q3Var.f14744d = 3;
        } else {
            q3Var.f14744d = 1;
            q3Var.f();
            String str = q3Var.f14746f;
            if (str != null) {
                q3Var.h(str, q3Var.f14747g);
            }
        }
        q3Var.f14746f = null;
        q3Var.f14747g = null;
    }

    public int e() {
        return this.f14744d;
    }

    public final void f() {
        this.f14741a.setSpeechRate(this.f14745e);
        int language = this.f14741a.setLanguage(Locale.getDefault());
        if (language == -1 || language == -2) {
            pc.a.h("Language %s is not supported", t1.n(Locale.getDefault()));
        }
        this.f14741a.setOnUtteranceProgressListener(new a());
    }

    public void g(float f10) {
        this.f14745e = f10;
        int i10 = this.f14744d;
        if (i10 == 1 || i10 == 2) {
            this.f14741a.setSpeechRate(f10);
        }
    }

    public boolean h(String str, Runnable runnable) {
        if (str == null) {
            if (runnable != null) {
                runnable.run();
            }
            return true;
        }
        int i10 = this.f14744d;
        if (i10 == 3 || i10 == 4) {
            pc.a.h("cannot speak message, state: %d", Integer.valueOf(i10));
            return false;
        }
        if (i10 == 0) {
            this.f14746f = str;
            this.f14747g = runnable;
            return false;
        }
        this.f14744d = 2;
        this.f14742b = runnable;
        String string = UUID.randomUUID().toString();
        this.f14743c = string;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f14741a.speak(str, 0, null, string);
        } else {
            HashMap<String, String> map = new HashMap<>();
            map.put("utteranceId", this.f14743c);
            this.f14741a.speak(str, 0, map);
        }
        return true;
    }

    public void i() {
        if (this.f14744d == 2) {
            this.f14744d = 1;
        }
        this.f14742b = null;
        this.f14741a.stop();
    }
}
