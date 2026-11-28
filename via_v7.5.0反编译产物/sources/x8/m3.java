package x8;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextToSpeech f14604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f14605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14606c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f14608e = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f14609f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f14610g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14607d = 0;

    public m3(Context context) {
        this.f14604a = new TextToSpeech(context, new TextToSpeech.OnInitListener() { // from class: x8.l3
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public final void onInit(int i10) {
                m3.a(this.f14599a, i10);
            }
        });
    }

    public static /* synthetic */ void a(m3 m3Var, int i10) {
        if (i10 != 0) {
            m3Var.f14607d = 3;
        } else {
            m3Var.f14607d = 1;
            m3Var.f();
            String str = m3Var.f14609f;
            if (str != null) {
                m3Var.h(str, m3Var.f14610g);
            }
        }
        m3Var.f14609f = null;
        m3Var.f14610g = null;
    }

    public int e() {
        return this.f14607d;
    }

    public final void f() {
        this.f14604a.setSpeechRate(this.f14608e);
        int language = this.f14604a.setLanguage(Locale.getDefault());
        if (language == -1 || language == -2) {
            tc.a.i("Language %s is not supported", s1.n(Locale.getDefault()));
        }
        this.f14604a.setOnUtteranceProgressListener(new a());
    }

    public void g(float f10) {
        this.f14608e = f10;
        int i10 = this.f14607d;
        if (i10 == 1 || i10 == 2) {
            this.f14604a.setSpeechRate(f10);
        }
    }

    public boolean h(String str, Runnable runnable) {
        if (str == null) {
            if (runnable != null) {
                runnable.run();
            }
            return true;
        }
        int i10 = this.f14607d;
        if (i10 == 3 || i10 == 4) {
            tc.a.i("cannot speak message, state: %d", Integer.valueOf(i10));
            return false;
        }
        if (i10 == 0) {
            this.f14609f = str;
            this.f14610g = runnable;
            return false;
        }
        this.f14607d = 2;
        this.f14605b = runnable;
        String string = UUID.randomUUID().toString();
        this.f14606c = string;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f14604a.speak(str, 0, null, string);
        } else {
            HashMap<String, String> map = new HashMap<>();
            map.put("utteranceId", this.f14606c);
            this.f14604a.speak(str, 0, map);
        }
        return true;
    }

    public void i() {
        if (this.f14607d == 2) {
            this.f14607d = 1;
        }
        this.f14605b = null;
        this.f14604a.stop();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends UtteranceProgressListener {
        public a() {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(String str) {
            m3.this.f14607d = 1;
            if (m3.this.f14605b == null || !str.equals(m3.this.f14606c)) {
                return;
            }
            m3.this.f14605b.run();
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(String str) {
            m3.this.f14607d = 1;
            if (m3.this.f14605b == null || !str.equals(m3.this.f14606c)) {
                return;
            }
            m3.this.f14605b.run();
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(String str) {
        }
    }
}
