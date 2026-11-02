package j3;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final FileChannel f7545a;

    /* renamed from: b, reason: collision with root package name */
    public final FileLock f7546b;

    public a(FileChannel fileChannel, FileLock fileLock) {
        this.f7545a = fileChannel;
        this.f7546b = fileLock;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(Context context, String str) throws IOException {
        FileChannel channel;
        FileLock fileLockLock;
        try {
            channel = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            try {
                fileLockLock = channel.lock();
            } catch (IOException | Error | OverlappingFileLockException e10) {
                e = e10;
                fileLockLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException e11) {
            e = e11;
            channel = null;
            fileLockLock = null;
        }
        try {
            return new a(channel, fileLockLock);
        } catch (IOException e12) {
            e = e12;
            Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
            if (fileLockLock != null) {
                try {
                    fileLockLock.release();
                } catch (IOException unused) {
                }
            }
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused2) {
                }
            }
            return null;
        } catch (Error e13) {
            e = e13;
            Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
            if (fileLockLock != null) {
            }
            if (channel != null) {
            }
            return null;
        } catch (OverlappingFileLockException e14) {
            e = e14;
            Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
            if (fileLockLock != null) {
            }
            if (channel != null) {
            }
            return null;
        }
    }

    public void b() throws IOException {
        try {
            this.f7546b.release();
            this.f7545a.close();
        } catch (IOException e10) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e10);
        }
    }
}
