package jp.co.ponos.battlecats;


import jp.co.ponos.library.game.PurchaseDelegate;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.game.Utility;
import jp.co.ponos.library.purchase.w;
import jp.co.ponos.library.score.MyUtility;
import jp.co.ponos.library.twitter.Twitter;

class h extends jp.co.ponos.library.score.e {
   public void buy(int var1) {
      if (A.a().b) {
         MyUtility.getInstance();
         if (Utility.isConnected()) {
            if (var1 >= 0) {
               if (w.b().g()) {
                  w.b().a(A.a().k[var1]);
                  A.a().b = false;
               } else {
                  MyUtility.getInstance().addButton(MyUtility.getString("gmail_err"));
               }
            } else if (var1 == -2) {
               //com.tapjoy.g.a().b();
               A.a().b = false;
            }
         } else {
            MyUtility.getInstance().addButton(MyUtility.getString("network_unavailable"));
         }
      }

   }

   public void copyToClipboard(String var1) {
      MyUtility.getInstance().editClipboard(var1);
      MyUtility.getInstance().addButton(MyUtility.getString("Copied_txt"));
   }

   public void facebook(String var1) {
      A.a().menuType = 4;
      A.a().f = null;
      A.a().f = var1;
      MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/page.php?type=facebook&lang=%s", MyUtility.getAppli(), MyUtility.getString("lang")));
      int[] var2 = A.a().hC;
      int var10002 = var2[0]++;
      if (A.a().hC[0] >= 999999999) {
         A.a().hC[0] = 999999999;
      }

      A.a().ae();
   }

   public void facebook2() {
      MyUtility.getInstance().addWebClient();
      //jp.co.ponos.library.c.a.b().a((String)null, (String)null);
      A.a().i = 0;
      A.a().menuType = -1;
      int[] var1 = A.a().hC;
      int var10002 = var1[1]++;
      if (A.a().hC[1] >= 999999999) {
         A.a().hC[1] = 999999999;
      }

      A.a().ae();
      if (A.a().getSceneType() == SceneType.MAIN && A.a().screen == 0) {
         //jp.co.ponos.library.a.a.b().d();
      }

   }

   public void games() {
      if (A.a().getSceneType() == SceneType.MAIN && A.a().screen == 0) {
         //jp.co.ponos.library.a.a.b().d();
      }

      MyUtility.getInstance().addWebClient();
      A.a().t = true;
      A.a().i = 0;
      A.a().menuType = -1;
      MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
      MyUtility.getInstance().addAlertAppliPage("games", A.a().r);
   }

   public void getInviteCount(int var1) {
      A.a().hB = var1;
      A.a().ae();
   }

   public void getPresent(int var1) {
      MyUtility.getInstance();
      if (Utility.isConnected()) {
         MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
         String var2 = aString.format("type=get&pid=%s&present=%d&lang=%s", A.a().e, var1, MyUtility.getString("lang"));
         var2 = aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), var2, MyUtility.md5(aString.format("%s&check=adlmn", var2)));
         (new PurchaseDelegate()).a(var2, A.a().d);
      } else {
         MyUtility.getInstance().addButton(MyUtility.getString("network_unavailable"));
      }

   }

   public void line(String var1) {
      A.a().f = null;
      A.a().f = var1;
      MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/page.php?type=line&lang=%s", MyUtility.getAppli(), MyUtility.getString("lang")));
      int[] var2 = A.a().hC;
      int var10002 = var2[2]++;
      if (A.a().hC[2] >= 999999999) {
         A.a().hC[2] = 999999999;
      }

      A.a().ae();
      A.a().menuType = 6;
   }

   public void line2(String var1) {
      A.a().i = 0;
      A.a().menuType = -1;
      MyUtility.getInstance().addWebClient();
      MyUtility.getInstance().displayURL("http://line.naver.jp/msg/text/" + MyUtility.urlEncode(var1));
   }

   public void review(String var1) {
      if (A.a().getSceneType() == SceneType.MAIN && A.a().screen == 0) {
         //jp.co.ponos.library.a.a.b().d();
      }

      A.a().f = null;
      A.a().f = var1;
      MyUtility.getInstance().addWebClient();
      A.a().t = true;
      MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
      MyUtility.getInstance().addAlertAppliPage("review", A.a().r);
      A.a().i = 0;
      A.a().menuType = -1;
      int[] var2 = A.a().hC;
      int var10002 = var2[3]++;
      if (A.a().hC[3] >= 999999999) {
         A.a().hC[3] = 999999999;
      }

      A.a().ae();
   }

   public void twitter(String var1) {
      A.a().f = null;
      A.a().f = var1;
      MyUtility.getInstance().addWebClient();
      A.a().i = 0;
      A.a().menuType = -1;
      if (A.a().getSceneType() == SceneType.MAIN && A.a().screen == 0) {
         //jp.co.ponos.library.a.a.b().d();
      }

      var1 = aString.format(MyUtility.getString("twitter_txt3"), A.a().f);
      Twitter.getInstance().tweet(aString.format("%s %s %s", var1, MyUtility.getString("url_abbr"), MyUtility.getString("twitter_hash")), (String)null, (String)null);
      int[] var2 = A.a().hC;
      int var10002 = var2[1]++;
      if (A.a().hC[1] >= 999999999) {
         A.a().hC[1] = 999999999;
      }

      A.a().ae();
   }

   public void video() {
      if (A.a().getSceneType() == SceneType.MAIN && A.a().screen == 0) {
         //jp.co.ponos.library.a.a.b().d();
      }

      MyUtility.getInstance().addWebClient();
      A.a().t = true;
      A.a().i = 0;
      A.a().menuType = -1;
      MyUtility.getInstance().addProgressDialog(MyUtility.getString("connecting"));
      MyUtility.getInstance().addAlertAppliPage("video", A.a().r);
   }
}
