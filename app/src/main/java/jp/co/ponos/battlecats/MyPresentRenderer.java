package jp.co.ponos.battlecats;

//import com.tapjoy.ab;
import jp.co.ponos.library.game.SoundType;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.game.WebClientViewer;
import jp.co.ponos.library.game.Sound;
import jp.co.ponos.library.score.MyUtility;

class MyPresentRenderer extends WebClientViewer {
   int a(boolean[] var1) {
      return var1.length;
   }
   @Override
   public void a() {
      A.a().e = null;
      A.a().zoom.reset();
      A.a().pointerDownNow = false;
      A.a().isPressEvent = false;
      A.a().pointerUp = false;
      A.a().isReleaseEvent = false;
      A.a().pointerDown = false;
   }
   @Override
   public void a(int var1) {
      this.a(true);
   }
   @Override
   public void canGoBack(String var1) {
      this.a(false);
   }

   public void a(boolean var1) {
      if (MyUtility.getInstance().getURL() == null) {
         A.a().i = 0;
         A.a().menuType = -1;
         if (var1) {
            Sound.getInstance().play(SoundType.BUTTON_PRESS);
         }

         MyUtility.getInstance().addWebClient();
      } else if (A.a().menuType == 0) {
         A.a().i = 0;
         A.a().menuType = -1;
         if (var1) {
            Sound.getInstance().play(SoundType.BUTTON_PRESS);
         }

         MyUtility.getInstance().addWebClient();
         //com.tapjoy.g.a().a((ab)jp.co.ponos.library.b.e.a().c());
         //com.tapjoy.g.a().a((com.tapjoy.q)jp.co.ponos.library.b.e.a().c());
      } else if (A.a().menuType == 1) {
         if (aString.indexOf(MyUtility.getInstance().getURL(), "type=top") == -1) {
            String var2 = aString.format("type=top&pid=%s&lang=%s", A.a().e, MyUtility.getString("lang"));
            var2 = aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), var2, MyUtility.md5(aString.format("%s&check=adlmn", var2)));
            MyUtility.getInstance().addAssetGetter(var2);
            if (var1) {
               Sound.getInstance().play(SoundType.BUTTON_PRESS);
            }
         } else {
            MyUtility.getInstance().addWebClient();
            A.a().i = 0;
            A.a().menuType = -1;
            SceneType sceneType = A.a().getSceneType();
            A.a();
            if (sceneType == SceneType.MAIN) {
               ScreenType screenType = A.a().getScreenType();
               A.a();
               if (screenType == ScreenType.TITLE) {
                  //jp.co.ponos.library.a.a.b().d();
               }
            }

            if (var1) {
               Sound.getInstance().play(SoundType.BUTTON_PRESS);
            }
         }
      } else if (A.a().menuType == 2) {
         A.a().i = 0;
         A.a().menuType = -1;
         if (A.a().getSceneType() == SceneType.MAIN && A.a().getScreenType() == ScreenType.TITLE) {
            //jp.co.ponos.library.a.a.b().d();
         }

         if (var1) {
            Sound.getInstance().play(SoundType.BUTTON_PRESS);
         }

         MyUtility.getInstance().addWebClient();
      } else if (A.a().menuType == 3) {
         A.a().i = 0;
         A.a().menuType = -1;
         if (A.a().getSceneType() == SceneType.MAIN && A.a().getScreenType() == ScreenType.TITLE) {
            //jp.co.ponos.library.a.a.b().d();
         }

         if (var1) {
            Sound.getInstance().play(SoundType.BUTTON_PRESS);
         }

         MyUtility.getInstance().addWebClient();
      } else if (A.a().menuType == 4) {
         A.a().i = 0;
         A.a().menuType = -1;
         if (A.a().getSceneType() == SceneType.MAIN && A.a().getScreenType() == ScreenType.TITLE) {
            //jp.co.ponos.library.a.a.b().d();
         }

         if (var1) {
            Sound.getInstance().play(SoundType.BUTTON_PRESS);
         }

         MyUtility.getInstance().addWebClient();
      } else if (A.a().menuType == 5) {
         A.a().i = 0;
         A.a().menuType = -1;
         if (A.a().getSceneType() == SceneType.MAIN && A.a().getScreenType() == ScreenType.TITLE) {
            //jp.co.ponos.library.a.a.b().d();
         }

         if (var1) {
            Sound.getInstance().play(SoundType.BUTTON_PRESS);
         }

         MyUtility.getInstance().addWebClient();
      } else if (A.a().menuType == 6) {
         A.a().i = 0;
         A.a().menuType = -1;
         if (A.a().getSceneType() == SceneType.MAIN && A.a().getScreenType() == ScreenType.TITLE) {
            //jp.co.ponos.library.a.a.b().d();
         }

         if (var1) {
            Sound.getInstance().play(SoundType.BUTTON_PRESS);
         }

         MyUtility.getInstance().addWebClient();
      } else {
         A.a().i = 0;
         A.a().menuType = -1;
         MyUtility.getInstance().addWebClient();
      }

   }
   @Override
   public void b(String var1) {
      int var2 = 0;
      if (A.a().menuType == 1) {
         if (aString.indexOf(var1, "type=present") >= 0) {
            for(; var2 < this.a(A.a().bF); ++var2) {
               if (!A.a().bF[var2]) {
                  MyUtility.getInstance().runFunction("setPresent(" + var2 + ")");
               }
            }

            MyUtility.getInstance().runFunction("setPresent(-1)");
         }
      } else if (A.a().menuType == 4) {
         if (aString.indexOf(var1, "type=facebook") >= 0) {
            var1 = aString.format(MyUtility.getString("facebook_txt3"), A.a().f, MyUtility.getString("url_abbr"));
            MyUtility.getInstance().runFunction("setDefaultText('" + var1 + "')");
         }
      } else if (A.a().menuType == 5) {
         if (A.a().bM[0] >= 48) {
            String var3 = aString.format("%s\\n%s", MyUtility.getString("facebook_txt2"), MyUtility.getString("url_abbr"));
            if (aString.indexOf(var1, "type=facebook") >= 0) {
               MyUtility.getInstance().runFunction("setDefaultText('" + var3 + "')");
            }
         } else if (aString.indexOf(var1, "type=facebook") >= 0) {
            var1 = aString.format(MyUtility.getString("facebook_txt1"), A.a().stageNamesText[Game.cm[A.a().bM[0]]], MyUtility.getString("url_abbr"));
            MyUtility.getInstance().runFunction("setDefaultText('" + var1 + "')");
         }
      } else if (A.a().menuType == 6 && aString.indexOf(var1, "type=line") >= 0) {
         var1 = aString.format(MyUtility.getString("line_txt1"), A.a().f, MyUtility.getString("url_abbr"));
         MyUtility.getInstance().runFunction("setDefaultText('" + var1 + "')");
      }

   }
}
