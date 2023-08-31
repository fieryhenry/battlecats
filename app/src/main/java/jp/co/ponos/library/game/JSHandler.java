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
import android.widget.ImageView.ScaleType;
import java.io.InputStream;

class JSHandler extends DialogFragment {
   String a;
   String b;
   boolean c;
   BrowserOption d;
   // $FF: synthetic field
   final Utility e;

   JSHandler(Utility var1) {
      this.e = var1;
      var1.d = true;
   }

   // $FF: synthetic method
   static Utility a(JSHandler var0) {
      return var0.e;
   }

   void a(String var1, boolean var2) {
      this.a(var1, var2, (BrowserOption)null);
   }

   void a(String var1, boolean var2, BrowserOption var3) {
      if (!var1.startsWith("http://") && !var1.startsWith("https://")) {
         this.a = "file:///android_asset/" + var1;
      } else {
         this.a = var1;
      }

      this.c = var2;
      this.d = var3;
   }

   public boolean loadURL() {
      if (this.e.webView == null) {
         this.e.webView = new WebView(Global.instance.context);
         this.e.webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
         this.e.webView.addJavascriptInterface(this.e.jsInterface, "ponos");
         this.e.webView.setWebViewClient(new WebClientHandler(this.e, this.c));
         this.e.webView.requestFocus();
         if (this.a == null) {
            if (this.b != null) {
               this.e.webView.getSettings().setJavaScriptEnabled(this.c);
               this.e.webView.loadDataWithBaseURL("file:///android_asset/", this.b, "text/html", "utf-8", (String)null);
            } else {
               this.e.webView.getSettings().setJavaScriptEnabled(false);
            }
         } else {
            if (this.c && (this.a.startsWith(Utility.decrypt(Utility.md5("j"), "n1YWtEyyCucWHkS9zWji/YPWxT5CpfXA7f5g8MlDmts=")) || this.a.startsWith(Utility.decrypt(Utility.md5("k"), "Hcoe0xz75+nMtUQDEtbp9LUKTgAiKi72O37lwU5pG7U=")) || this.a.startsWith(Utility.decrypt(Utility.md5("l"), "IwadsMddagoWqNh5PFRTqJLpXOr3Im1AONvor8XK7FI=")) || this.a.startsWith(Utility.decrypt(Utility.md5("m"), "/IfjXRARE9nwKQVYuWTXh/GB9kmn5jI3u3JIS4/x6M4=")) || this.a.startsWith(Utility.decrypt(Utility.md5("n"), "wpH8/+yzkbQWOCGl9xLdGKmU2bCTVeSqUOhpQPOKUvo=")) || this.a.startsWith(Utility.decrypt(Utility.md5("o"), "9sFIVYgf22gbbuH/13FxPA==")))) {
               this.e.webView.getSettings().setJavaScriptEnabled(true);
            } else {
               this.e.webView.getSettings().setJavaScriptEnabled(false);
            }

            this.e.webView.loadUrl(this.a);
         }

         this.e.frameLayout = new FrameLayout(Global.instance.context);
         this.e.frameLayout.setBackgroundColor(-16777216);
         if (this.d == null) {
            this.e.frameLayout.addView(this.e.webView);
         } else {
            Display display = ((WindowManager) Global.instance.context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            float screenDensity = Global.getInstance().getContext().getResources().getDisplayMetrics().density / 1.7F;
            int var3;
            if (Settings.getInstance().normalScreen) {
               var3 = 64;
            } else {
               var3 = 88;
            }

            this.e.frameLayout.addView(this.e.webView, -1, (int)((float)display.getHeight() - (float)var3 * screenDensity));
            FrameLayout.LayoutParams var11 = new FrameLayout.LayoutParams(-1, (int)((float)var3 * screenDensity));
            var11.gravity = 80;
            FrameLayout var4 = new FrameLayout(Global.instance.context);
            FrameLayout.LayoutParams var13;
            if (this.d.e == null) {
               var4.setBackgroundColor(-16777216);
            } else {
               label118: {
                  ImageView var6;
                  try {
                     var6 = new ImageView(Global.instance.context);
                     InputStream var5 = Global.instance.context.getResources().openRawResource(AssetLoader.assetLoader.getDrawable(aString.getFileNameWithoutExtension(this.d.e)));
                     Bitmap var7 = BitmapFactory.decodeStream(var5);
                     var5.close();
                     var6.setImageBitmap(var7);
                     var6.setScaleType(ScaleType.CENTER_CROP);
                     var13 = new FrameLayout.LayoutParams(-1, (int)((float)var7.getHeight() * screenDensity));
                  } catch (Exception var10) {
                     break label118;
                  }

                  try {
                     var13.gravity = 80;
                     this.e.frameLayout.addView(var6, var13);
                  } catch (Exception var9) {
                     var11 = var13;
                     break label118;
                  }

                  var11 = var13;
               }
            }

            this.e.frameLayout.addView(var4, var11);

            for(var3 = 0; var3 < this.d.a; ++var3) {
               if (this.d.b[var3] == 0 || this.d.b[var3] == 1) {
                  Object var12;
                  if (this.d.b[var3] == 0) {
                     var12 = new JSButton(this, Global.instance.context, var3);
                     ((Button)var12).setText(this.d.d[var3]);
                     ((Button)var12).setTextSize(18.0F);
                     ((View)var12).setOnClickListener(new WebViewClickHandler(this));
                     var13 = new FrameLayout.LayoutParams(-2, -1);
                  } else {
                     try {
                        var12 = new JSImageButton(this, Global.instance.context, var3);
                        ((View)var12).setBackgroundColor(0);
                        InputStream var15 = Global.instance.context.getResources().openRawResource(AssetLoader.assetLoader.getDrawable(aString.getFileNameWithoutExtension(this.d.d[var3])));
                        Bitmap var14 = BitmapFactory.decodeStream(var15);
                        var15.close();
                        ((ImageButton)var12).setImageBitmap(var14);
                        ((ImageButton)var12).setScaleType(ScaleType.CENTER_CROP);
                        WebViewClickHandler2 var16 = new WebViewClickHandler2(this);
                        ((View)var12).setOnClickListener(var16);
                        var13 = new FrameLayout.LayoutParams((int)((float)var14.getWidth() * screenDensity), (int)((float)var14.getHeight() * screenDensity));
                     } catch (Exception var8) {
                        continue;
                     }
                  }

                  if (this.d.c[var3] == 1) {
                     var13.gravity = 81;
                  } else if (this.d.c[var3] == 2) {
                     var13.gravity = 85;
                  } else {
                     var13.gravity = 83;
                  }

                  if (this.d.b[var3] == 0) {
                     var4.addView((View)var12, var13);
                  } else {
                     this.e.frameLayout.addView((View)var12, var13);
                  }
               }
            }
         }

         if (this.d != null && this.d.f) {
            this.e.j = true;
         } else {
            this.e.j = false;
         }

         Global.instance.frameLayout.addView(this.e.frameLayout);
         Global.instance.setBackKeyController2(new BackHandler(this.e));
      }

      return true;
   }

   void b(String var1, boolean var2, BrowserOption var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
   }
}
