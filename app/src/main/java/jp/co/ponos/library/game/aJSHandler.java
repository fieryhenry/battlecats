package jp.co.ponos.library.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.library.b.aq */
/* loaded from: classes.dex */
public class aJSHandler extends DialogFragment {
    String a;
    String b;
    boolean c;
    aBrowserOption d;
    final /* synthetic */ aUtility e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aJSHandler(aUtility autility) {
        this.e = autility;
        autility.d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, boolean z) {
        a(str, z, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, boolean z, aBrowserOption abrowseroption) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            this.a = str;
        } else {
            this.a = "file:///android_asset/" + str;
        }
        this.c = z;
        this.d = abrowseroption;
    }

    @Override // jp.co.ponos.library.game.DialogFragment
    public boolean loadURL() {
        FrameLayout.LayoutParams layoutParams;
        View ajsimagebutton = null;
        FrameLayout.LayoutParams layoutParams2 = null;
        if (this.e.webView == null) {
            this.e.webView = new WebView(aGlobal.instance.context);
            this.e.webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            this.e.webView.addJavascriptInterface(this.e.i, "ponos");
            this.e.webView.setWebViewClient(new WebClientHandler(this.e, this.c));
            this.e.webView.requestFocus();
            if (this.a != null) {
                this.e.webView.getSettings().setJavaScriptEnabled(this.c && (this.a.startsWith("http://www.ponos.co.jp/") || this.a.startsWith("http://www.ponos.net/") || this.a.startsWith("https://www.ponos.co.jp/") || this.a.startsWith("https://www.ponos.net/") || this.a.startsWith("file://android_asset/") || this.a.startsWith("data:text/html")));
                this.e.webView.loadUrl(this.a);
            } else if (this.b != null) {
                this.e.webView.getSettings().setJavaScriptEnabled(this.c);
                this.e.webView.loadDataWithBaseURL("file:///android_asset/", this.b, "text/html", "utf-8", null);
            } else {
                this.e.webView.getSettings().setJavaScriptEnabled(false);
            }
            this.e.f = new FrameLayout(aGlobal.instance.context);
            this.e.f.setBackgroundColor(-16777216);
            if (this.d == null) {
                this.e.f.addView(this.e.webView);
            } else {
                Display defaultDisplay = ((WindowManager) aGlobal.instance.context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
                float f = aGlobal.getInstance().getContext().getResources().getDisplayMetrics().density / 1.7f;
                int i = aSettings.getInstance().j ? 64 : 88;
                this.e.f.addView(this.e.webView, -1, (int) (defaultDisplay.getHeight() - (i * f)));
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) (i * f));
                layoutParams3.gravity = 80;
                FrameLayout frameLayout = new FrameLayout(aGlobal.instance.context);
                if (this.d.e == null) {
                    frameLayout.setBackgroundColor(-16777216);
                    layoutParams = layoutParams3;
                } else {
                    try {
                        ImageView imageView = new ImageView(aGlobal.instance.context);
                        InputStream openRawResource = aGlobal.instance.context.getResources().openRawResource(aAssetLoader.assetLoader.getDrawable(aString.getFileNameWithoutExtension(this.d.e)));
                        Bitmap decodeStream = BitmapFactory.decodeStream(openRawResource);
                        openRawResource.close();
                        imageView.setImageBitmap(decodeStream);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        layoutParams = new FrameLayout.LayoutParams(-1, (int) (decodeStream.getHeight() * f));
                        try {
                            layoutParams.gravity = 80;
                            this.e.f.addView(imageView, layoutParams);
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        layoutParams = layoutParams3;
                    }
                }
                this.e.f.addView(frameLayout, layoutParams);
                for (int i2 = 0; i2 < this.d.a; i2++) {
                    if (this.d.b[i2] == 0 || this.d.b[i2] == 1) {
                        if (this.d.b[i2] == 0) {
                            ajsimagebutton = new aJSButton(this, aGlobal.instance.context, i2);
                            ((Button) ajsimagebutton).setText(this.d.d[i2]);
                            ((Button) ajsimagebutton).setTextSize(18.0f);
                            ajsimagebutton.setOnClickListener(new WebViewClickHandler(this));
                            layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                        } else {
                            try {
                                ajsimagebutton = new aJSImageButton(this, aGlobal.instance.context, i2);
                                ajsimagebutton.setBackgroundColor(0);
                                InputStream openRawResource2 = aGlobal.instance.context.getResources().openRawResource(aAssetLoader.assetLoader.getDrawable(aString.getFileNameWithoutExtension(this.d.d[i2])));
                                Bitmap decodeStream2 = BitmapFactory.decodeStream(openRawResource2);
                                openRawResource2.close();
                                ((ImageButton) ajsimagebutton).setImageBitmap(decodeStream2);
                                ((ImageButton) ajsimagebutton).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                ajsimagebutton.setOnClickListener(new WebViewClickHandler2(this));
                                layoutParams2 = new FrameLayout.LayoutParams((int) (decodeStream2.getWidth() * f), (int) (decodeStream2.getHeight() * f));
                            } catch (Exception e3) {
                            }
                        }
                        if (this.d.c[i2] == 1) {
                            layoutParams2.gravity = 81;
                        } else if (this.d.c[i2] == 2) {
                            layoutParams2.gravity = 85;
                        } else {
                            layoutParams2.gravity = 83;
                        }
                        if (this.d.b[i2] == 0) {
                            frameLayout.addView(ajsimagebutton, layoutParams2);
                        } else {
                            this.e.f.addView(ajsimagebutton, layoutParams2);
                        }
                    }
                }
            }
            if (this.d == null || !this.d.f) {
                this.e.j = false;
            } else {
                this.e.j = true;
            }
            aGlobal.instance.n.addView(this.e.f);
            aGlobal.instance.b(new BackHandler(this.e));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, boolean z, aBrowserOption abrowseroption) {
        this.b = str;
        this.c = z;
        this.d = abrowseroption;
    }
}
