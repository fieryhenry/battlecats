package jp.co.ponos.battlecats;

//import jp.co.ponos.library.ads.aAd;
import jp.co.ponos.library.game.SoundType;
import jp.co.ponos.library.game.aPresentRenderer;
import jp.co.ponos.library.game.aSound;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.score.MyUtility;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: jp.co.ponos.battlecats.o */
/* loaded from: classes.dex */
public class PresentRenderer extends aPresentRenderer {
    int a(boolean[] zArr) {
        return zArr.length;
    }

    @Override // jp.co.ponos.library.game.aPresentRenderer
    public void a() {
        A.a().e = null;
        A.a().zoom.reset();
        A.a().M = false;
        A.a().pointerDown = false;
        A.a().P = false;
        A.a().pointerUp = false;
        A.a().O = false;
    }

    @Override // jp.co.ponos.library.game.aPresentRenderer
    public void a(int i) {
        a(true);
    }

    @Override // jp.co.ponos.library.game.aPresentRenderer
    public void a(String str) {
        a(false);
    }

    public void a(boolean z) {
        if (MyUtility.getInstance().getURL() == null) {
            A.a().i = 0;
            A.a().menuType = -1;
            if (z) {
                aSound.getInstance().play(SoundType.BUTTON_PRESS);
            }
            MyUtility.getInstance().addWebClient();
        } else if (A.a().menuType == 0) {
            A.a().i = 0;
            A.a().menuType = -1;
            if (z) {
                aSound.getInstance().play(SoundType.BUTTON_PRESS);
            }
            MyUtility.getInstance().addWebClient();
        } else if (A.a().menuType == 1) {
            if (aString.indexOf(MyUtility.getInstance().getURL(), "type=top") == -1) {
                String format = aString.format("type=top&pid=%s&lang=%s", A.a().e, MyUtility.getString("lang"));
                MyUtility.getInstance().addAssetGetter(aString.format("%s/battlecats/friend.php?%s&check=%s", MyUtility.getAppli(), format, MyUtility.md5(aString.format("%s&check=adlmn", format))));
                if (z) {
                    aSound.getInstance().play(SoundType.BUTTON_PRESS);
                    return;
                }
                return;
            }
            MyUtility.getInstance().addWebClient();
            A.a().i = 0;
            A.a().menuType = -1;
            int W = A.a().getScene();
            A.a();
            if (W == 100) {
                int i = A.a().fD;
                A.a();
                if (i == 0) {
                    //aAd.b().d();
                }
            }
            if (z) {
                aSound.getInstance().play(SoundType.BUTTON_PRESS);
            }
        } else if (A.a().menuType == 2) {
            A.a().i = 0;
            A.a().menuType = -1;
            if (A.a().getScene() == 100 && A.a().fD == 0) {
                //aAd.b().d();
            }
            if (z) {
                aSound.getInstance().play(SoundType.BUTTON_PRESS);
            }
            MyUtility.getInstance().addWebClient();
        } else if (A.a().menuType == 3) {
            A.a().i = 0;
            A.a().menuType = -1;
            if (A.a().getScene() == 100 && A.a().fD == 0) {
                //aAd.b().d();
            }
            if (z) {
                aSound.getInstance().play(SoundType.BUTTON_PRESS);
            }
            MyUtility.getInstance().addWebClient();
        } else if (A.a().menuType == 4) {
            A.a().i = 0;
            A.a().menuType = -1;
            if (A.a().getScene() == 100 && A.a().fD == 0) {
                //aAd.b().d();
            }
            if (z) {
                aSound.getInstance().play(SoundType.BUTTON_PRESS);
            }
            MyUtility.getInstance().addWebClient();
        } else if (A.a().menuType == 5) {
            A.a().i = 0;
            A.a().menuType = -1;
            if (A.a().getScene() == 100 && A.a().fD == 0) {
                //aAd.b().d();
            }
            if (z) {
                aSound.getInstance().play(SoundType.BUTTON_PRESS);
            }
            MyUtility.getInstance().addWebClient();
        } else if (A.a().menuType != 6) {
            A.a().i = 0;
            A.a().menuType = -1;
            MyUtility.getInstance().addWebClient();
        } else {
            A.a().i = 0;
            A.a().menuType = -1;
            if (A.a().getScene() == 100 && A.a().fD == 0) {
                //aAd.b().d();
            }
            if (z) {
                aSound.getInstance().play(SoundType.BUTTON_PRESS);
            }
            MyUtility.getInstance().addWebClient();
        }
    }

    @Override // jp.co.ponos.library.game.aPresentRenderer
    public void b(String str) {
        if (A.a().menuType == 1) {
            if (aString.indexOf(str, "type=present") >= 0) {
                for (int i = 0; i < a(A.a().bF); i++) {
                    if (!A.a().bF[i]) {
                        MyUtility.getInstance().runFunction("setPresent(" + i + ")");
                    }
                }
                MyUtility.getInstance().runFunction("setPresent(-1)");
            }
        } else if (A.a().menuType == 4) {
            if (aString.indexOf(str, "type=facebook") >= 0) {
                MyUtility.getInstance().runFunction("setDefaultText('" + aString.format(MyUtility.getString("facebook_txt3"), A.a().f, MyUtility.getString("url_abbr")) + "')");
            }
        } else if (A.a().menuType != 5) {
            if (A.a().menuType != 6 || aString.indexOf(str, "type=line") < 0) {
                return;
            }
            MyUtility.getInstance().runFunction("setDefaultText('" + aString.format(MyUtility.getString("line_txt1"), A.a().f, MyUtility.getString("url_abbr")) + "')");
        } else if (A.a().battleData[0] < 48) {
            if (aString.indexOf(str, "type=facebook") >= 0) {
                MyUtility.getInstance().runFunction("setDefaultText('" + aString.format(MyUtility.getString("facebook_txt1"), A.a().stageNameText[Game.cm[A.a().battleData[0]]], MyUtility.getString("url_abbr")) + "')");
            }
        } else {
            String format = aString.format("%s\\n%s", MyUtility.getString("facebook_txt2"), MyUtility.getString("url_abbr"));
            if (aString.indexOf(str, "type=facebook") >= 0) {
                MyUtility.getInstance().runFunction("setDefaultText('" + format + "')");
            }
        }
    }
}
