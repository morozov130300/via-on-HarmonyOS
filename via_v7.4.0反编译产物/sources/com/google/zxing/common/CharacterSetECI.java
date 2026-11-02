package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public enum CharacterSetECI {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");


    /* renamed from: e, reason: collision with root package name */
    public static final Map f4116e = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public static final Map f4117j = new HashMap();
    private final String[] otherEncodingNames;
    private final int[] values;

    static {
        for (CharacterSetECI characterSetECI : values()) {
            for (int i10 : characterSetECI.values) {
                f4116e.put(Integer.valueOf(i10), characterSetECI);
            }
            f4117j.put(characterSetECI.name(), characterSetECI);
            for (String str : characterSetECI.otherEncodingNames) {
                f4117j.put(str, characterSetECI);
            }
        }
    }

    CharacterSetECI(int i10) {
        this(new int[]{i10}, new String[0]);
    }

    CharacterSetECI(int i10, String... strArr) {
        this.values = new int[]{i10};
        this.otherEncodingNames = strArr;
    }

    CharacterSetECI(int[] iArr, String... strArr) {
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }

    public static CharacterSetECI getCharacterSetECI(Charset charset) {
        return (CharacterSetECI) f4117j.get(charset.name());
    }

    public static CharacterSetECI getCharacterSetECIByName(String str) {
        return (CharacterSetECI) f4117j.get(str);
    }

    public static CharacterSetECI getCharacterSetECIByValue(int i10) throws FormatException {
        if (i10 < 0 || i10 >= 900) {
            throw FormatException.getFormatInstance();
        }
        return (CharacterSetECI) f4116e.get(Integer.valueOf(i10));
    }

    public Charset getCharset() {
        return Charset.forName(name());
    }

    public int getValue() {
        return this.values[0];
    }
}
