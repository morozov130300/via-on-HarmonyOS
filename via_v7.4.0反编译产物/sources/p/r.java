package p;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n.a1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public Context f10890a;

    /* renamed from: b, reason: collision with root package name */
    public String f10891b;

    /* renamed from: c, reason: collision with root package name */
    public Intent[] f10892c;

    /* renamed from: d, reason: collision with root package name */
    public ComponentName f10893d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f10894e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f10895f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f10896g;

    /* renamed from: h, reason: collision with root package name */
    public IconCompat f10897h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10898i;

    /* renamed from: j, reason: collision with root package name */
    public a1[] f10899j;

    /* renamed from: k, reason: collision with root package name */
    public Set f10900k;

    /* renamed from: l, reason: collision with root package name */
    public o.l f10901l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10902m;

    /* renamed from: n, reason: collision with root package name */
    public int f10903n;

    /* renamed from: o, reason: collision with root package name */
    public PersistableBundle f10904o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10905p = true;

    /* renamed from: q, reason: collision with root package name */
    public int f10906q;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final r f10907a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10908b;

        /* renamed from: c, reason: collision with root package name */
        public Set f10909c;

        /* renamed from: d, reason: collision with root package name */
        public Map f10910d;

        /* renamed from: e, reason: collision with root package name */
        public Uri f10911e;

        public a(Context context, String str) {
            r rVar = new r();
            this.f10907a = rVar;
            rVar.f10890a = context;
            rVar.f10891b = str;
        }

        public r a() {
            if (TextUtils.isEmpty(this.f10907a.f10894e)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            r rVar = this.f10907a;
            Intent[] intentArr = rVar.f10892c;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.f10908b) {
                if (rVar.f10901l == null) {
                    rVar.f10901l = new o.l(rVar.f10891b);
                }
                this.f10907a.f10902m = true;
            }
            if (this.f10909c != null) {
                r rVar2 = this.f10907a;
                if (rVar2.f10900k == null) {
                    rVar2.f10900k = new HashSet();
                }
                this.f10907a.f10900k.addAll(this.f10909c);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f10910d != null) {
                    r rVar3 = this.f10907a;
                    if (rVar3.f10904o == null) {
                        rVar3.f10904o = new PersistableBundle();
                    }
                    for (String str : this.f10910d.keySet()) {
                        Map map = (Map) this.f10910d.get(str);
                        this.f10907a.f10904o.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                        for (String str2 : map.keySet()) {
                            List list = (List) map.get(str2);
                            this.f10907a.f10904o.putStringArray(str + "/" + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                        }
                    }
                }
                if (this.f10911e != null) {
                    r rVar4 = this.f10907a;
                    if (rVar4.f10904o == null) {
                        rVar4.f10904o = new PersistableBundle();
                    }
                    this.f10907a.f10904o.putString("extraSliceUri", t.a.a(this.f10911e));
                }
            }
            return this.f10907a;
        }

        public a b(IconCompat iconCompat) {
            this.f10907a.f10897h = iconCompat;
            return this;
        }

        public a c(Intent intent) {
            return d(new Intent[]{intent});
        }

        public a d(Intent[] intentArr) {
            this.f10907a.f10892c = intentArr;
            return this;
        }

        public a e(CharSequence charSequence) {
            this.f10907a.f10894e = charSequence;
            return this;
        }
    }

    public Intent a(Intent intent) throws PackageManager.NameNotFoundException {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.f10892c[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f10894e.toString());
        if (this.f10897h != null) {
            Drawable activityIcon = null;
            if (this.f10898i) {
                PackageManager packageManager = this.f10890a.getPackageManager();
                ComponentName componentName = this.f10893d;
                if (componentName != null) {
                    try {
                        activityIcon = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (activityIcon == null) {
                    activityIcon = this.f10890a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.f10897h.a(intent, activityIcon, this.f10890a);
        }
        return intent;
    }

    public final PersistableBundle b() {
        if (this.f10904o == null) {
            this.f10904o = new PersistableBundle();
        }
        a1[] a1VarArr = this.f10899j;
        if (a1VarArr != null && a1VarArr.length > 0) {
            this.f10904o.putInt("extraPersonCount", a1VarArr.length);
            if (this.f10899j.length > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("extraPerson_");
                sb2.append(1);
                a1 a1Var = this.f10899j[0];
                throw null;
            }
        }
        o.l lVar = this.f10901l;
        if (lVar != null) {
            this.f10904o.putString("extraLocusId", lVar.a());
        }
        this.f10904o.putBoolean("extraLongLived", this.f10902m);
        return this.f10904o;
    }

    public String c() {
        return this.f10891b;
    }

    public boolean d(int i10) {
        return (i10 & this.f10906q) != 0;
    }

    public ShortcutInfo e() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.f10890a, this.f10891b).setShortLabel(this.f10894e).setIntents(this.f10892c);
        IconCompat iconCompat = this.f10897h;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.q(this.f10890a));
        }
        if (!TextUtils.isEmpty(this.f10895f)) {
            intents.setLongLabel(this.f10895f);
        }
        if (!TextUtils.isEmpty(this.f10896g)) {
            intents.setDisabledMessage(this.f10896g);
        }
        ComponentName componentName = this.f10893d;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set set = this.f10900k;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.f10903n);
        PersistableBundle persistableBundle = this.f10904o;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            a1[] a1VarArr = this.f10899j;
            if (a1VarArr != null && a1VarArr.length > 0) {
                int length = a1VarArr.length;
                Person[] personArr = new Person[length];
                if (length > 0) {
                    a1 a1Var = a1VarArr[0];
                    throw null;
                }
                intents.setPersons(personArr);
            }
            o.l lVar = this.f10901l;
            if (lVar != null) {
                intents.setLocusId(lVar.c());
            }
            intents.setLongLived(this.f10902m);
        } else {
            intents.setExtras(b());
        }
        return intents.build();
    }
}
