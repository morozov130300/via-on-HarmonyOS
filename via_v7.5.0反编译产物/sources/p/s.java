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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent[] f11517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ComponentName f11518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f11519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f11520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f11521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IconCompat f11522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a1[] f11524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set f11525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o.l f11526l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11527m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11528n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PersistableBundle f11529o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f11530p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f11531q;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f11532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set f11534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map f11535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Uri f11536e;

        public a(Context context, String str) {
            s sVar = new s();
            this.f11532a = sVar;
            sVar.f11515a = context;
            sVar.f11516b = str;
        }

        public s a() {
            if (TextUtils.isEmpty(this.f11532a.f11519e)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            s sVar = this.f11532a;
            Intent[] intentArr = sVar.f11517c;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.f11533b) {
                if (sVar.f11526l == null) {
                    sVar.f11526l = new o.l(sVar.f11516b);
                }
                this.f11532a.f11527m = true;
            }
            if (this.f11534c != null) {
                s sVar2 = this.f11532a;
                if (sVar2.f11525k == null) {
                    sVar2.f11525k = new HashSet();
                }
                this.f11532a.f11525k.addAll(this.f11534c);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f11535d != null) {
                    s sVar3 = this.f11532a;
                    if (sVar3.f11529o == null) {
                        sVar3.f11529o = new PersistableBundle();
                    }
                    for (String str : this.f11535d.keySet()) {
                        Map map = (Map) this.f11535d.get(str);
                        this.f11532a.f11529o.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                        for (String str2 : map.keySet()) {
                            List list = (List) map.get(str2);
                            this.f11532a.f11529o.putStringArray(str + "/" + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                        }
                    }
                }
                if (this.f11536e != null) {
                    s sVar4 = this.f11532a;
                    if (sVar4.f11529o == null) {
                        sVar4.f11529o = new PersistableBundle();
                    }
                    this.f11532a.f11529o.putString("extraSliceUri", u.a.a(this.f11536e));
                }
            }
            return this.f11532a;
        }

        public a b(IconCompat iconCompat) {
            this.f11532a.f11522h = iconCompat;
            return this;
        }

        public a c(Intent intent) {
            return d(new Intent[]{intent});
        }

        public a d(Intent[] intentArr) {
            this.f11532a.f11517c = intentArr;
            return this;
        }

        public a e(CharSequence charSequence) {
            this.f11532a.f11519e = charSequence;
            return this;
        }
    }

    public Intent a(Intent intent) {
        Intent[] intentArr = this.f11517c;
        intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f11519e.toString());
        if (this.f11522h != null) {
            Drawable activityIcon = null;
            if (this.f11523i) {
                PackageManager packageManager = this.f11515a.getPackageManager();
                ComponentName componentName = this.f11518d;
                if (componentName != null) {
                    try {
                        activityIcon = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (activityIcon == null) {
                    activityIcon = this.f11515a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.f11522h.a(intent, activityIcon, this.f11515a);
        }
        return intent;
    }

    public final PersistableBundle b() {
        if (this.f11529o == null) {
            this.f11529o = new PersistableBundle();
        }
        a1[] a1VarArr = this.f11524j;
        if (a1VarArr != null && a1VarArr.length > 0) {
            this.f11529o.putInt("extraPersonCount", a1VarArr.length);
            if (this.f11524j.length > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("extraPerson_");
                sb2.append(1);
                a1 a1Var = this.f11524j[0];
                throw null;
            }
        }
        o.l lVar = this.f11526l;
        if (lVar != null) {
            this.f11529o.putString("extraLocusId", lVar.a());
        }
        this.f11529o.putBoolean("extraLongLived", this.f11527m);
        return this.f11529o;
    }

    public String c() {
        return this.f11516b;
    }

    public boolean d(int i10) {
        return (i10 & this.f11531q) != 0;
    }

    public ShortcutInfo e() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.f11515a, this.f11516b).setShortLabel(this.f11519e).setIntents(this.f11517c);
        IconCompat iconCompat = this.f11522h;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.q(this.f11515a));
        }
        if (!TextUtils.isEmpty(this.f11520f)) {
            intents.setLongLabel(this.f11520f);
        }
        if (!TextUtils.isEmpty(this.f11521g)) {
            intents.setDisabledMessage(this.f11521g);
        }
        ComponentName componentName = this.f11518d;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set set = this.f11525k;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.f11528n);
        PersistableBundle persistableBundle = this.f11529o;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            a1[] a1VarArr = this.f11524j;
            if (a1VarArr != null && a1VarArr.length > 0) {
                int length = a1VarArr.length;
                Person[] personArr = new Person[length];
                if (length > 0) {
                    a1 a1Var = a1VarArr[0];
                    throw null;
                }
                intents.setPersons(personArr);
            }
            o.l lVar = this.f11526l;
            if (lVar != null) {
                intents.setLocusId(lVar.c());
            }
            intents.setLongLived(this.f11527m);
        } else {
            intents.setExtras(b());
        }
        return intents.build();
    }
}
