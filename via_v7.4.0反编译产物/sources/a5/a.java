package a5;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import w4.b;
import x4.c;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f81a;

    public a(Context context) {
        this.f81a = context;
    }

    @Override // x4.c
    public List a() throws Throwable {
        BufferedReader bufferedReader;
        IOException e10;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.f81a.getAssets().open("simple.txt"), "UTF-8"));
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            b5.c.b(bufferedReader);
                            return arrayList;
                        }
                        b bVarV = b5.c.v(line);
                        if (bVarV != null) {
                            arrayList.add(bVarV);
                        }
                    } catch (IOException e11) {
                        e10 = e11;
                        e10.printStackTrace();
                        b5.c.b(bufferedReader);
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    b5.c.b(bufferedReader2);
                    throw th;
                }
            }
        } catch (IOException e12) {
            bufferedReader = null;
            e10 = e12;
        } catch (Throwable th2) {
            th = th2;
            b5.c.b(bufferedReader2);
            throw th;
        }
    }
}
