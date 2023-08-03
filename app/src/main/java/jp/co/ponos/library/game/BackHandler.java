package jp.co.ponos.library.game;

/* renamed from: jp.co.ponos.library.b.ah */
/* loaded from: classes.dex */
class BackHandler extends aBackKeyController {
    final /* synthetic */ aUtility a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackHandler(aUtility autility) {
        this.a = autility;
    }

    @Override // jp.co.ponos.library.game.aBackKeyController
    public boolean a() {
        if (this.a.b != null && !this.a.j) {
            this.a.b.a(this.a.getURL());
            return true;
        } else if (this.a.canGoBack()) {
            this.a.goBack();
            return true;
        } else {
            this.a.addWebClient();
            return true;
        }
    }
}
