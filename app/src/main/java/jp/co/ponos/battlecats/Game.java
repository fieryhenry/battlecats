package jp.co.ponos.battlecats;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import jp.co.ponos.library.ads.aAd;
import jp.co.ponos.library.game.AnimTransformer;
import jp.co.ponos.library.game.DataStreams.aAssetTextStream;
import jp.co.ponos.library.game.DataStreams.aFileStream;
import jp.co.ponos.library.game.DataStreams.aResourceFileStream;
import jp.co.ponos.library.game.MyApplicationBase;
import jp.co.ponos.library.game.aMath;
import jp.co.ponos.library.game.aModel;
import jp.co.ponos.library.game.aModelAnimation;
import jp.co.ponos.library.game.aPoint;
import jp.co.ponos.library.game.aSound;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.game.aTexture;
import jp.co.ponos.library.game.aTextureRenderer;
import jp.co.ponos.library.game.aUnknown2;
import jp.co.ponos.library.score.MyUtility;

/* renamed from: jp.co.ponos.battlecats.e */
/* loaded from: classes.dex */
public class Game extends MyApplicationBase {
    int D;
    int currentXTouch;
    int touchX;
    int G;
    int prevXTouch;
    int currentYTouch;
    int touchY;
    int K;
    int prevYTouch;
    boolean M;
    boolean pointerDown;
    boolean O;
    boolean P;
    boolean pointerUp;
    boolean R;
    boolean S;
    int scene;
    int scene2;
    int V;
    int W;
    Calendar calendar;
    aModel aJ;
    int catfood;
    int currentEnergy;
    double aQ;
    int hour;
    int minute;
    int second;
    int aU;
    int aV;
    int aW;
    int aX;
    int aY;
    int aZ;
    aTexture popupTexture;
    aTexture newTexture;
    aTexture arrowTexture;
    boolean b;
    int bI;
    int bP;
    int ba;
    int bb;
    int bd;
    int be;
    int bf;
    int bg;
    int bh;
    int bi;
    int bj;
    int bl;
    int bn;
    int bo;
    int ca;
    int ct;
    int dA;
    int dE;
    int dF;
    int dG;
    int dH;
    int mapScrollState;
    int selectedStage;
    int mapCatPosition;
    int dT;
    int dU;
    boolean dV;
    int dW;
    int dX;
    int dY;
    int dZ;
    String godNameText;
    int dx;
    int dy;
    int dz;
    String e;
    boolean eC;
    int eG;
    int eN;
    int eP;
    int eQ;
    int eR;
    int eS;
    boolean eX;
    int pointerID;
    int eZ;
    int ea;
    boolean eb;
    int ec;
    int ed;
    boolean ee;
    boolean ef;
    int eg;
    int eo;
    int ew;
    boolean ex;
    int ey;
    int ez;
    String f;
    int fD;
    int fE;
    int fF;
    int fI;
    int fJ;
    int fK;
    int fL;
    int fP;
    boolean fT;
    int fU;
    int fV;
    int fX;
    int fY;
    int fZ;
    int fa;
    int fh;
    int fi;
    int fl;
    int fm;
    boolean fn;
    int fr;
    int ft;
    int fu;
    int year;

    /* renamed from: g */
    int menuType;
    int gH;
    boolean gI;
    boolean gJ;
    int gK;
    boolean gL;
    int gM;
    boolean gN;
    boolean gO;
    int gQ;
    int gR;
    boolean gU;
    int gW;
    boolean gu;
    int gw;
    int gx;
    int boxScale;
    int gz;
    boolean h;
    int hA;
    int hB;
    int hF;
    int hG;
    int hH;
    boolean isScrolling;
    int hl;
    int hp;
    boolean hr;
    int hs;
    int hv;
    int hy;
    int hz;
    int i;
    boolean j;
    boolean n;
    boolean o;
    int regionState;
    int q;
    boolean t;
    boolean u;
    boolean v;
    int w;
    int zoomLevel;
    static int[] l = new int[8];
    static int[] m = new int[8];
    static int[] X = new int[10];
    static int[] Y = new int[10];
    static int[] Z = new int[11];
    static int[] aa = new int[11];
    static int[] ab = new int[4];
    static int[][] ac = (int[][]) Array.newInstance(Integer.TYPE, 10, 10);
    static int[] ad = new int[11];
    static int[] aB = new int[4];
    static int[][] ck = (int[][]) Array.newInstance(Integer.TYPE, 48, 4);
    static int[][] cl = (int[][]) Array.newInstance(Integer.TYPE, 48, 2);
    static int[] cm = new int[49];
    static int[] cn = new int[153];
    static int[] co = new int[24];
    static int[] cp = new int[12];
    static int[] cq = new int[13];
    static int[] cr = new int[35];
    static int[] cs = new int[44];
    static int[] cu = new int[15];
    static int[] cv = new int[34];
    static int cw = 160;
    static int[] cx = new int[12];
    static int[] cy = new int[11];
    static int[][] cz = (int[][]) Array.newInstance(Integer.TYPE, 11, 7);
    static int[] cA = new int[11];
    static int[] cB = new int[11];
    static int[] cC = new int[11];
    static int[] ds = new int[24];
    static int[] dt = new int[23];
    static int[] du = new int[14];
    static int[] dv = new int[6];
    static int[] eO = new int[5];
    static int[] eT = new int[8];
    static int[] fb = new int[10];
    static int[][] fe = (int[][]) Array.newInstance(Integer.TYPE, 49, 3);
    static int[] fM = new int[12];
    static int[] fN = new int[7];
    static int[] fO = new int[7];
    static int hn = 2000;
    PresentRenderer c = new PresentRenderer();
    MyPresentHandler d = new MyPresentHandler();
    String[] purchaseIDs = new String[8];
    aUnknown2 r = new aUnknown2();
    aUnknown2 s = new aUnknown2();
    aPoint x = new aPoint();
    Zoom zoom = new Zoom();
    AnimTransformer a2 = new AnimTransformer();
    AnimTransformer b2 = new AnimTransformer();
    MyScore c2 = new MyScore();
    aTexture[] uiTextures = new aTexture[30];
    aTexture[] settingsMenuTexture = new aTexture[4];
    aTexture[] textTextures = new aTexture[100];
    aTexture[] textTextures2 = new aTexture[15];
    aTexture[] tutorialTextTextures = new aTexture[8];
    aTexture[] warningTextures = new aTexture[1];
    aTexture[] uniTextures = new aTexture[11];
    aTexture[] openingTexture = new aTexture[1];
    aModel[] openingModel = new aModel[1];
    aModelAnimation[] openingAnim = new aModelAnimation[1];
    aTexture[] unitTexturesF = new aTexture[26];
    aTexture[] unitTexturesC = new aTexture[26];
    aModel[] unitSlotModels = new aModel[10];
    aModelAnimation[][] unitSlotAnims = (aModelAnimation[][]) Array.newInstance(aModelAnimation.class, 10, 4);
    aTexture[] enemyTextures = new aTexture[30];
    aModel[] enemySlotModels = new aModel[10];
    aModelAnimation[][] enemySlotAnims = (aModelAnimation[][]) Array.newInstance(aModelAnimation.class, 10, 4);
    aTexture[] godTexture = new aTexture[1];
    aModel[][] godModel = (aModel[][]) Array.newInstance(aModel.class, 4, 2);
    aModelAnimation[][] godAnim = (aModelAnimation[][]) Array.newInstance(aModelAnimation.class, 4, 2);
    aTexture[] catBaseTexture = new aTexture[1];
    aModel[] catBaseModel = new aModel[2];
    aModelAnimation[][] catBaseAnim = (aModelAnimation[][]) Array.newInstance(aModelAnimation.class, 2, 3);
    aTexture[] stampTextures = new aTexture[2];
    aModel[] stampModels = new aModel[2];
    aModelAnimation[] stampAnims = new aModelAnimation[2];
    aTexture[] legendTextures = new aTexture[2];
    aModelAnimation[] legendAnims = new aModelAnimation[2];
    int[] years = new int[2];
    int[] months = new int[2];
    int[] days = new int[2];
    int[] bc = new int[3];
    int[] slotCatIDs = new int[10];
    int[] bm = new int[30];
    int[] bp = new int[10];
    int[] bq = new int[10];
    int[][] br = (int[][]) Array.newInstance(Integer.TYPE, 10, 49);
    int[][] bs = (int[][]) Array.newInstance(Integer.TYPE, 10, 49);
    int[] bt = new int[30];
    int[] bu = new int[26];
    int[] bv = new int[26];
    int[] bw = new int[26];
    int[] bx = new int[11];
    int[] by = new int[5];
    int[] bz = new int[5];
    int[] bA = new int[6];
    int[] bB = new int[10];
    int[] bC = new int[20];
    int[] bD = new int[1];
    int[] bE = new int[1];
    boolean[] bF = new boolean[11];
    int[] stageEoCStats = new int[48];
    int[][] bH = (int[][]) Array.newInstance(Integer.TYPE, 201, 3);
    int[][] unitBuyStats = (int[][]) Array.newInstance(Integer.TYPE, 26, 16);
    int[] boxCatIDs = new int[26];
    int[] bL = new int[26];
    int[] battleData = new int[34];
    int[] bN = new int[3];
    int[][] bO = (int[][]) Array.newInstance(Integer.TYPE, 10, 11);
    int[][] bQ = (int[][]) Array.newInstance(Integer.TYPE, 20, 2);
    int[][][] unitBattleStats = (int[][][]) Array.newInstance(Integer.TYPE, 2, 51, 38);
    int[][][] bS = (int[][][]) Array.newInstance(Integer.TYPE, 2, 56, 3);
    int[][] bT = (int[][]) Array.newInstance(Integer.TYPE, 6, 5);
    int[] bU = new int[2];
    int[] bV = new int[6];
    int[][] stageStats = (int[][]) Array.newInstance(Integer.TYPE, 20, 8);
    int[][][] unitStats = (int[][][]) Array.newInstance(Integer.TYPE, 28, 2, 14);
    int[][] enemyStats = (int[][]) Array.newInstance(Integer.TYPE, 32, 13);
    int[][] bZ = (int[][]) Array.newInstance(Integer.TYPE, 52, 2);
    int[] cb = new int[2];
    int[][] cc = (int[][]) Array.newInstance(Integer.TYPE, 100, 5);
    int[][] cd = (int[][]) Array.newInstance(Integer.TYPE, 10, 5);
    int[][] ce = (int[][]) Array.newInstance(Integer.TYPE, 100, 4);
    int[][][] cf = (int[][][]) Array.newInstance(Integer.TYPE, 100, 2, 8);
    int[][][] cg = (int[][][]) Array.newInstance(Integer.TYPE, 50, 2, 8);
    int[][][] ch = (int[][][]) Array.newInstance(Integer.TYPE, 50, 2, 8);
    int[][] ci = (int[][]) Array.newInstance(Integer.TYPE, 50, 4);
    int[] cj = new int[5];
    String[] warning1Text = new String[15];
    String[][] warning2Text = (String[][]) Array.newInstance(String.class, 18, 4);
    String[] stageNameText = new String[100];
    String[] treasure1Text = new String[49];
    String[] treasure2Text = new String[11];
    String[][] treasure3Text = (String[][]) Array.newInstance(String.class, 23, 3);
    String[] openingText = new String[73];
    String[] endingText = new String[77];
    String[][] mainMenuWText = (String[][]) Array.newInstance(String.class, 10, 5);
    String[][] mainMenuPText = (String[][]) Array.newInstance(String.class, 2, 5);
    String[][] mainMenuUText = (String[][]) Array.newInstance(String.class, 5, 5);
    String[][] mainMenuTText = (String[][]) Array.newInstance(String.class, 2, 5);
    String[][] mainMenuBText = (String[][]) Array.newInstance(String.class, 4, 5);
    String[][] enemyPictureBookText = (String[][]) Array.newInstance(String.class, 30, 5);
    String[] enemyPictureBookQuestionText = new String[5];
    String[][] unitExplanationOffText = (String[][]) Array.newInstance(String.class, 2, 4);
    String[][][] unitExplanationText = (String[][][]) Array.newInstance(String.class, 26, 2, 4);
    String[] godExplanationText = new String[4];
    String[][] catExplanationText = (String[][]) Array.newInstance(String.class, 10, 4);
    String[][] stageFirstMessageText = (String[][]) Array.newInstance(String.class, 3, 4);
    String[] challengeModeText = new String[4];
    String[] pageNameText = new String[9];
    String[] firstLoseText = new String[2];
    String[][][] loseText = (String[][][]) Array.newInstance(String.class, 3, 1, 4);
    String[] optionText = new String[3];
    String[] itemNameText = new String[11];
    String[][] itemExplanationText = (String[][]) Array.newInstance(String.class, 11, 3);
    String[][] mainMenuPopupText = (String[][]) Array.newInstance(String.class, 8, 4);
    String[][] tutorialText = (String[][]) Array.newInstance(String.class, 10, 12);
    String[][] endingMessageText = (String[][]) Array.newInstance(String.class, 2, 4);
    String[][] god1Text = (String[][]) Array.newInstance(String.class, 2, 2);
    String[][] god2Text = (String[][]) Array.newInstance(String.class, 33, 2);
    String[][] god3Text = (String[][]) Array.newInstance(String.class, 1, 2);
    String[][] god4Text = (String[][]) Array.newInstance(String.class, 1, 2);
    String[] godItemNameText = new String[4];
    String[][] godItemExplanationText = (String[][]) Array.newInstance(String.class, 4, 2);

    /* renamed from: do  reason: not valid java name */
    String[][] popupMessageText = (String[][]) Array.newInstance(String.class, 3, 10);
    String[][] categoryExplanation = (String[][]) Array.newInstance(String.class, 2, 4);
    String[] stampMessageText = new String[20];
    String[][] giftMessageText = (String[][]) Array.newInstance(String.class, 2, 4);
    int[] dw = new int[2];
    int[] dB = new int[4];
    int[] dC = new int[4];
    int[] dD = new int[4];
    int[] currentStageBox = new int[4];
    int[] mapOffsetX = new int[3];
    int[] mapOffsetY = new int[3];
    int[] dL = new int[2];
    int[] dM = new int[200];
    int[] dN = new int[200];
    int[] dO = new int[200];
    int[] dP = new int[2];
    int[] eh = new int[5];
    int[] ei = new int[3];
    int[] ej = new int[1];
    int[] scrollAmount = new int[3];
    int[] el = new int[1];
    int[] em = new int[4];
    int[] en = new int[4];
    float[] ep = new float[3];
    int[] eq = new int[50];
    int[] er = new int[50];
    int[] es = new int[50];
    boolean[] et = new boolean[50];
    int[] eu = new int[50];
    int[] ev = new int[50];
    int[][] eA = (int[][]) Array.newInstance(Integer.TYPE, 4, 5);
    int[][][] eB = (int[][][]) Array.newInstance(Integer.TYPE, 50, 2, 3);
    int[] eD = new int[7];
    boolean[] eE = new boolean[14];
    int[] eF = new int[26];
    int[] gameStats1 = new int[10];
    int[] eI = new int[2];
    int[][] eJ = (int[][]) Array.newInstance(Integer.TYPE, 10, 4);
    int[] eK = new int[10];
    int[] eL = new int[10];
    boolean[] eM = new boolean[10];
    int[] slotEnemyIDs = new int[10];
    int[] slotFormIDs = new int[10];
    int[] eW = new int[10];
    int[] fc = new int[2];
    int[] fd = new int[2];
    int[] ff = new int[6];
    int[][] fg = (int[][]) Array.newInstance(Integer.TYPE, 10, 2);
    int[][] fj = (int[][]) Array.newInstance(Integer.TYPE, 10, 4);
    int[] fk = new int[11];
    int[] fo = new int[3];
    int[] fp = new int[10];
    int[] fq = new int[4];
    int[] fs = new int[3];
    int[][] fw = (int[][]) Array.newInstance(Integer.TYPE, 17, 4);
    int[] fx = new int[17];
    int[] fy = new int[10];
    int[] fz = new int[2];
    int[][] fA = (int[][]) Array.newInstance(Integer.TYPE, 2, 4);
    int[][] fB = (int[][]) Array.newInstance(Integer.TYPE, 13, 4);
    int[] fC = new int[13];
    int[] fG = new int[4];
    int[] fH = new int[3];
    int[] fQ = new int[11];
    int[] fR = new int[2];
    int[] currentBox = new int[6];
    int[] fW = new int[10];
    int[] ga = new int[2];
    int[] gb = new int[10];
    int[] gc = new int[6];
    int[] gd = new int[2];
    int[] ge = new int[2];
    int[] gf = new int[2];
    int[] gg = new int[2];
    int[] gh = new int[4];
    int[] gi = new int[4];
    int[] gj = new int[4];
    int[][] gk = (int[][]) Array.newInstance(Integer.TYPE, 2, 3);
    int[][] gl = (int[][]) Array.newInstance(Integer.TYPE, 2, 8);
    int[] gm = new int[2];
    int[][] gn = (int[][]) Array.newInstance(Integer.TYPE, 2, 3);
    int[][] boxSize = (int[][]) Array.newInstance(Integer.TYPE, 60, 2);
    boolean[] gp = new boolean[17];
    boolean[] gq = new boolean[15];
    boolean[] gr = new boolean[15];
    boolean[] gs = new boolean[2];
    boolean[] gt = new boolean[1];
    int[] gv = new int[3];
    int[] gA = new int[6];
    int[] gB = new int[5];
    int[] boxCounts = new int[4];
    int[] gD = new int[4];
    int[] gE = new int[20];
    boolean[] gF = new boolean[2];
    int[] gG = new int[20];
    int[] gP = new int[4];
    int[] gS = new int[11];
    int[] gT = new int[11];
    int[] gV = new int[4];
    int[][] gX = (int[][]) Array.newInstance(Integer.TYPE, 1, 4);
    int[] gY = new int[6];
    int[] gZ = new int[1];
    boolean[] ha = new boolean[2];
    float[] hb = new float[3];
    int[] hc = new int[29];
    int[] hd = new int[2];
    int[] he = new int[3];
    int[] hf = new int[2];
    int[] hg = new int[2];
    int[] hh = new int[20];
    int[] hi = new int[20];
    int[][] hj = (int[][]) Array.newInstance(Integer.TYPE, 10, 4);
    int[] hk = new int[10];
    int[] hm = new int[4];
    int[][] stampStats = (int[][]) Array.newInstance(Integer.TYPE, 31, 2);
    int[] hq = new int[4];
    int[] ht = new int[2];
    int[] hu = new int[2];
    int[] hw = new int[3];
    int[] hx = new int[8];
    int[] hC = new int[4];
    int[] hD = new int[11];
    int[] hE = new int[4];
    SimpleDateFormat hJ = new SimpleDateFormat("yyyyMMddHHmmss");
    SimpleDateFormat hK = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    int[] hL = {5, 5, 5, 5, 5, 1, 5, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 2, 2, 2, 2, 2, 2, 2, 2};

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConstants() {
        fb = new int[]{159, 289, 419, 549, 679, 171, 301, 431, 561, 691};
        eT = new int[]{0, 0, 1, 1, 2, 2, 3, 3};
        co = new int[]{0, -125, -125, -75, -75, -25, -25, 0, 0, 25, 25, 75, 75, 125, 125, -50, -50, -25, -25, 25, 25, 50, 50};
        cp = new int[]{0, 0, -100, -100, -50, -50, 0, 0, 50, 50, 100, 100};
        cq = new int[]{960, 960, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        cr = new int[]{-54, -54, -54, -54, -54, -54, -54, -54, -54, -24, 6, 36, 66, 96, 90, 87, 86, 85, 86, 87, 90, 96, 95, 94, 95, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96};
        cs = new int[]{-132, -94, -57, -20, 17, 54, 92, 129, 167, 204, 242, 235, 227, 224, 220, 219, 217, 216, 215, 216, 217, 218, 220, 223, 227, 234, 242, 241, 240, 239, 237, 238, 240, 241, 242, 242, 242, 242, 242, 242, 242, 242, 242, 242};
        cu = new int[]{640, 640, 640, 640, 640, 532, 492, 384, 276, 274, 272, 274, 276, 298, 320};
        cv = new int[]{312, 314, 316, 316, 316, 318, 320, 320, 320, 320, 320, 320, 320, 320, 320, 316, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312};
        fM = new int[]{1, 6, 12, 32, 52, 92, 132, 192, 252, 368, 480, 2000};
        fN = new int[]{72, 40, 8, 4, 2, 1};
        fO = new int[]{104, 40, 8, 4, 2, 1};
        ck = new int[][]{new int[]{3270, 589, 521, 493}, new int[]{2766, 1165, 205, 193}, new int[]{2641, 1295, 149, 228}, new int[]{2802, 1455, 157, 237}, new int[]{2481, 1614, 123, 195}, new int[]{2586, 1745, 156, 171}, new int[]{2495, 1957, 206, 161}, new int[]{2399, 2167, 133, 170}, new int[]{2325, 2065, 106, 129}, new int[]{2194, 2086, 142, 145}, new int[]{2165, 2200, 128, 73}, new int[]{2230, 2292, 104, 51}, new int[]{2327, 2367, 128, 157}, new int[]{2127, 2336, 100, 78}, new int[]{2152, 1942, 249, 251}, new int[]{1962, 2120, 152, 244}, new int[]{2030, 2257, 103, 111}, new int[]{1893, 2383, 186, 135}, new int[]{1886, 1976, 111, 100}, new int[]{1775, 2128, 150, 177}, new int[]{1707, 2302, 129, 113}, new int[]{1701, 2014, 127, 208}, new int[]{1615, 2086, 167, 133}, new int[]{1539, 2272, 78, 123}, new int[]{1562, 2395, 118, 203}, new int[]{1457, 2418, 75, 118}, new int[]{1452, 2232, 134, 152}, new int[]{1406, 2336, 77, 104}, new int[]{1337, 2461, 110, 125}, new int[]{1302, 2207, 136, 206}, new int[]{1191, 2084, 154, 79}, new int[]{1095, 2160, 129, 122}, new int[]{897, 2093, 187, 177}, new int[]{890, 2206, 157, 124}, new int[]{664, 2247, 158, 113}, new int[]{1094, 2353, 101, 58}, new int[]{1124, 2412, 120, 94}, new int[]{909, 2387, 178, 167}, new int[]{903, 2493, 192, 153}, new int[]{477, 2331, 128, 133}, new int[]{573, 2485, 133, 131}, new int[]{502, 2670, 133, 192}, new int[]{401, 2609, 155, 142}, new int[]{327, 2694, 126, 170}, new int[]{320, 2374, 91, 88}, new int[]{263, 2469, 118, 111}, new int[]{1022, 890, 270, 307}, new int[]{65, 1024, 44, 34}};
        cl = new int[][]{new int[]{260, 246}, new int[]{102, 96}, new int[]{74, 114}, new int[]{78, 118}, new int[]{61, 97}, new int[]{78, 85}, new int[]{103, 80}, new int[]{66, 85}, new int[]{53, 64}, new int[]{71, 72}, new int[]{64, 36}, new int[]{52, 25}, new int[]{64, 78}, new int[]{50, 39}, new int[]{124, 125}, new int[]{76, 122}, new int[]{51, 55}, new int[]{93, 67}, new int[]{55, 50}, new int[]{75, 88}, new int[]{64, 56}, new int[]{63, 104}, new int[]{83, 66}, new int[]{39, 61}, new int[]{59, 101}, new int[]{37, 59}, new int[]{67, 76}, new int[]{38, 52}, new int[]{55, 62}, new int[]{68, 103}, new int[]{77, 39}, new int[]{64, 61}, new int[]{93, 88}, new int[]{78, 62}, new int[]{79, 56}, new int[]{50, 29}, new int[]{60, 47}, new int[]{89, 83}, new int[]{96, 76}, new int[]{64, 66}, new int[]{66, 65}, new int[]{66, 96}, new int[]{77, 71}, new int[]{63, 85}, new int[]{45, 44}, new int[]{59, 55}, new int[]{135, 153}, new int[]{22, 17}};
        cm = new int[]{45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 46, 47, 48};
        cn = new int[]{3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 90, 32, 3, 0, 4, 3, 0, 4, 3, 90, 30, 3, 0, 4, 3, 0, 4, 3, 90, 31, 3, 0, 4, 3, 0, 4, 3, 85, 32, 3, 0, 4, 3, 0, 4, 33, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 93, 31, 3, 0, 4, 3, 0, 4, 33, 0, 4, 3, 0, 4, 3, 0, 4, 3, 90, 32, 3, 0, 4, 3, 0, 4, 30, 0, 4, 3, 0, 4, 3, 0, 4, 3, 99, 31, 3, 0, 4, 3, 0, 4, 3, 92, 31, 3, 0, 4, 3, 0, 4, 30, 0, 4, 3, 0, 4, 30, 0, 4, 3, 99, 32, 31, 0, 4, 33, 0, 4, 3, 0, 4, 4, 0, 4, 6, 60, 4, 4, 0, 4, 4, 70, 33};
        ac = new int[][]{new int[]{500, 1000, 2000, 4000, 8000, 12000, 16000, 20000, 24000, 28000}, new int[]{250, 500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500}, new int[]{250, 500, 1000, 2000, 4000, 6000, 8000, 10000, 12000, 15000}, new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000}, new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000}, new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000}, new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000}, new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000}, new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000}, new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000}};
        ad = new int[]{100, 1500, 3, 0, 25, 10000, 1000, 0, 100, 100, 100};
        cx = new int[]{4, 4, 4, 4, 3, 3, 2, 2, 1, 1};
        cy = new int[]{7, 4, 5, 7, 3, 3, 3, 7, 6, 1, 2};
        cz = new int[][]{new int[]{45, 44, 43, 42, 41, 40, 39}, new int[]{38, 37, 36, 35, -1}, new int[]{34, 33, 32, 31, 30, -1}, new int[]{29, 28, 27, 26, 25, 24, 23}, new int[]{22, 21, 18, -1}, new int[]{19, 20, 17, -1}, new int[]{16, 15, 14, -1}, new int[]{13, 12, 11, 10, 9, 8, 7}, new int[]{6, 5, 4, 3, 2, 1, -1}, new int[]{0, -1}, new int[]{46, 47, -1}};
        cA = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10};
        cB = new int[]{100, 100000, 30, 50, 7000, 50, 50, 50, 500, 150, 60};
        ds = new int[]{-960, -960, -448, -415, -382, -319, -256, -192, -128, -64, 0, -8, -16, -18, -20, -18, -16, -8, 0, 0, -4, -4};
        dt = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 11, 16, 12, 17, 24, 13, 14, 20, 18, 19, 23, 25, 26};
        du = new int[]{0, 3, 7, 9, 12, 14, 15, 15, 15, 14, 12, 9, 7, 3};
        fe = new int[][]{new int[]{8, 0, 127}, new int[]{0, 2, 127}, new int[]{0, 4, 127}, new int[]{0, 4, 127}, new int[]{0, 0, 127}, new int[]{-4, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 2, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{-8, 0, 127}, new int[]{-4, 0, 127}, new int[]{0, 0, 127}, new int[]{-4, 0, 127}, new int[]{-4, 0, 127}, new int[]{-8, 0, 127}, new int[]{-4, 0, 127}, new int[]{-8, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{2, 0, 127}, new int[]{2, 0, 127}, new int[]{4, 1, 127}, new int[]{-8, 0, 127}, new int[]{-4, 0, 127}, new int[]{-2, 0, 127}, new int[]{-4, 0, 127}, new int[]{-8, 0, 127}, new int[]{2, 0, 127}, new int[]{-4, 0, 127}, new int[]{-2, 0, 127}, new int[]{-4, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{-4, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{-4, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 127}, new int[]{0, 0, 156}, new int[]{0, 0, 156}};
        int[] iArr = new int[6];
        iArr[2] = 6;
        iArr[3] = -10;
        dv = iArr;
        eO = new int[]{0, 50, 80, 90, 100};
        cC = new int[]{0, 10, 20, 60, 99, 100, 99, 60, 20, 10};
        Z = new int[]{50, 90, 150, 180, 300, 90, 75, 150, 450, 900, 1500};
        aa = new int[]{9, 2, 7, 20, 5, 3, 5000, 12000, 40000, 100000, 200000};
        ab = new int[]{20, 10, 5, 90};
        aB = new int[]{1, 2, 0, 3};
        X = new int[]{0, 10, 20, 999, 999, 999, 999, 999, 999, 999};
        Y = new int[]{0, 5, 30, 999, 999, 999, 999, 999, 999, 999};
        this.purchaseIDs = new String[]{"jp.co.ponos.battlecats.nekokan1", "jp.co.ponos.battlecats.nekokan2", "jp.co.ponos.battlecats.nekokan3", "jp.co.ponos.battlecats.nekokan4", "jp.co.ponos.battlecats.nekokan5", "jp.co.ponos.battlecats.nekokan6", "jp.co.ponos.battlecats.nekokan7", "jp.co.ponos.battlecats.nekokan8"};
        l = new int[]{30, 90, 180, 330, 690, 1080, 1860, 3900};
        m = new int[]{1, 2, 3, 0, 4, 5, 6, 7};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentXTouch() {
        return this.currentXTouch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentYTouch() {
        return this.currentYTouch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int M() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int N() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPreviousXTouch() {
        return this.prevXTouch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPreviousYTouch() {
        return this.prevYTouch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Q() {
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean S() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T() {
        return this.R;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        for (int i = 0; i < 10; i++) {
            for (int i2 = 0; i2 < getLength(cz); i2++) {
                this.bO[i][i2] = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i4 >= getLength(cz[i2]) || cz[i2][i4] == -1) {
                        break;
                    } else if (this.bs[i][cz[i2][i4]] <= 0) {
                        i3 = 0;
                        break;
                    } else {
                        i3 += this.bs[i][cz[i2][i4]];
                        i4++;
                    }
                }
                if (i3 != 0) {
                    this.bO[i][i2] = (i3 * 100) / (cy[i2] * 3);
                }
            }
        }
    }

    void V() {
        for (int i = 0; i < getLength(this.cj); i++) {
            this.cj[i] = 0;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            if (this.eM[i2]) {
                //this.bA[i2] = r2[i2] - 1;
                this.eL[i2] = 1;
            } else {
                this.eL[i2] = 0;
            }
        }
        this.gM = 0;
        for (int i3 = 0; i3 < 10; i3++) {
            if (this.slotCatIDs[i3] - 2 >= 0) {
                this.slotFormIDs[i3] = this.bw[this.slotCatIDs[i3] - 2];
            } else {
                this.slotFormIDs[i3] = 0;
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 10; i5++) {
            if (this.slotCatIDs[i5] != -1) {
                i4++;
            }
        }
        if (i4 >= 6) {
            this.gO = true;
        } else {
            this.gO = false;
        }
        this.ee = false;
        this.ef = false;
        for (int i6 = 0; i6 < getLength(this.ha); i6++) {
            this.ha[i6] = false;
        }
        for (int i7 = 0; i7 < getLength(this.hk); i7++) {
            this.hk[i7] = 0;
        }
        for (int i8 = 0; i8 < getLength(this.gp); i8++) {
            this.gp[i8] = false;
        }
        for (int i9 = 0; i9 < getLength(this.battleData); i9++) {
            this.battleData[i9] = 0;
        }
        for (int i10 = 0; i10 < getLength(this.gameStats1); i10++) {
            this.gameStats1[i10] = 0;
        }
        for (int i11 = 0; i11 < getLength(this.bV); i11++) {
            this.bV[i11] = 0;
        }
        for (int i12 = 0; i12 < getLength(this.stageStats); i12++) {
            for (int i13 = 0; i13 < getLength(this.stageStats[i12]); i13++) {
                this.stageStats[i12][i13] = 0;
            }
        }
        this.bP = 0;
        for (int i14 = 0; i14 < getLength(this.bQ); i14++) {
            for (int i15 = 0; i15 < getLength(this.bQ[i14]); i15++) {
                this.bQ[i14][i15] = 0;
            }
        }
        for (int i16 = 0; i16 < getLength(this.fc); i16++) {
            this.fc[i16] = 0;
        }
        for (int i17 = 0; i17 < getLength(this.fd); i17++) {
            this.fd[i17] = 0;
        }
        U();
        this.eR = 0;
        this.eP = 0;
        for (int i18 = 0; i18 < getLength(this.fw); i18++) {
            for (int i19 = 0; i19 < getLength(this.fw[i18]); i19++) {
                this.fw[i18][i19] = 0;
            }
        }
        for (int i20 = 0; i20 < getLength(this.fx); i20++) {
            this.fx[i20] = 0;
        }
        for (int i21 = 0; i21 < getLength(this.fy); i21++) {
            this.fy[i21] = 0;
        }
        for (int i22 = 0; i22 < getLength(this.eK); i22++) {
            this.eK[i22] = 0;
        }
        for (int i23 = 0; i23 < getLength(this.fz); i23++) {
            this.fz[i23] = 0;
        }
        for (int i24 = 0; i24 < getLength(this.gZ); i24++) {
            this.gZ[i24] = 0;
        }
        for (int i25 = 0; i25 < getLength(this.eI); i25++) {
            this.eI[i25] = 0;
        }
        if (this.dH != 48) {
            this.bp[this.eQ] = this.dH;
        }
        this.battleData[0] = this.dH;
        loadStageStats(((this.eQ == 1 && this.battleData[0] == 47) ? 2 : (this.eQ == 2 && this.battleData[0] == 47) ? 3 : 0) + this.battleData[0]);
        this.battleData[20] = cm[this.battleData[0]];
        this.battleData[5] = this.bV[0] - 9600;
        this.battleData[15] = 0;
        int i26 = 100;
        while (true) {
            if (i26 < 0) {
                break;
            } else if ((this.bV[0] * i26) / 100 < 9600) {
                this.battleData[28] = i26 + 1;
                break;
            } else {
                i26--;
            }
        }
        this.zoomLevel = 10000;
        this.battleData[10] = 0;
        for (int i27 = 0; i27 < getLength(this.eW); i27++) {
            this.eW[i27] = 0;
        }
        this.battleData[14] = 3;
        this.battleData[11] = this.bx[4];
        this.battleData[6] = ad[4] + (this.battleData[11] * 10);
        this.battleData[7] = ad[5] + (this.bx[5] * 10000);
        for (int i28 = 0; i28 < getLength(this.bN); i28++) {
            this.bN[i28] = 0;
        }
        if (this.eL[2] == 1) {
            this.bN[0] = 7;
        }
        this.battleData[9] = (this.battleData[7] * ((this.bN[0] * 5) + 10)) / 10;
        for (int i29 = 0; i29 < 10; i29++) {
            int[] iArr = this.battleData;
            iArr[9] = iArr[9] + ((cB[1] * this.bO[i29][1]) / 100);
        }
        this.battleData[8] = (this.battleData[6] * (this.bN[0] + 10)) / 10;
        for (int i30 = 0; i30 < 10; i30++) {
            int[] iArr2 = this.battleData;
            iArr2[8] = iArr2[8] + ((cB[0] * this.bO[i30][0]) / 100);
        }
        for (int i31 = 0; i31 < getLength(this.unitBattleStats); i31++) {
            for (int i32 = 0; i32 < getLength(this.unitBattleStats[i31]); i32++) {
                for (int i33 = 0; i33 < getLength(this.unitBattleStats[i31][i32]); i33++) {
                    this.unitBattleStats[i31][i32][i33] = 0;
                }
            }
        }
        this.unitBattleStats[0][0][0] = 1;
        this.unitBattleStats[0][0][1] = 0;
        this.unitBattleStats[0][0][2] = 0;
        this.unitBattleStats[0][0][3] = this.bV[0] - 3200;
        this.unitBattleStats[0][0][4] = 4400;
        this.unitBattleStats[0][0][5] = 0;
        this.unitBattleStats[0][0][6] = ad[2] + (this.bx[2] * 1);
        this.unitBattleStats[0][0][7] = ad[6] + (this.bx[6] * 1000);
        if (this.bx[6] >= 4 && this.bx[6] <= 7) {
            this.unitBattleStats[0][0][7] = ((this.bx[6] - 4) * 2000) + 6000;
        } else if (this.bx[6] >= 8) {
            this.unitBattleStats[0][0][7] = ((this.bx[6] - 8) * 3000) + 15000;
        }
        for (int i34 = 0; i34 < 10; i34++) {
            int[] iArr3 = this.unitBattleStats[0][0];
            iArr3[7] = iArr3[7] + ((cB[4] * this.bO[i34][4]) / 100);
        }
        this.unitBattleStats[0][0][8] = this.unitBattleStats[0][0][7];
        this.unitBattleStats[0][0][9] = 0;
        this.unitBattleStats[0][0][10] = 0;
        this.unitBattleStats[0][0][11] = ((ad[1] + (this.bx[1] * 50)) - (ad[3] + (this.bx[3] * 50))) + (this.eQ * 450);
        for (int i35 = 0; i35 < 10; i35++) {
            int[] iArr4 = this.unitBattleStats[0][0];
            iArr4[11] = iArr4[11] - ((cB[9] * this.bO[i35][9]) / 100);
        }
        if (this.unitBattleStats[0][0][11] <= 60) {
            this.unitBattleStats[0][0][11] = 60;
        }
        this.unitBattleStats[0][0][12] = this.unitBattleStats[0][0][11];
        this.unitBattleStats[0][0][13] = 0;
        this.unitBattleStats[0][0][14] = 0;
        this.unitBattleStats[0][0][15] = 1800;
        this.unitBattleStats[0][0][16] = ad[0] + (this.bx[0] * 50);
        for (int i36 = 0; i36 < 10; i36++) {
            int[] iArr5 = this.unitBattleStats[0][0];
            iArr5[16] = iArr5[16] + ((cB[8] * this.bO[i36][8]) / 100);
        }
        this.unitBattleStats[1][0][0] = 1;
        this.unitBattleStats[1][0][1] = 0;
        this.unitBattleStats[1][0][2] = 0;
        this.unitBattleStats[1][0][3] = 3200;
        this.unitBattleStats[1][0][4] = 4400;
        this.unitBattleStats[1][0][5] = 0;
        this.unitBattleStats[1][0][7] = this.bV[1] * (this.eQ + 1);
        this.unitBattleStats[1][0][8] = this.unitBattleStats[1][0][7];
        this.unitBattleStats[1][0][14] = 0;
        this.unitBattleStats[1][0][15] = 1800;
        this.bP = aMath.rand((this.bV[3] - this.bV[2]) + 1) + this.bV[2];
        for (int i37 = 0; i37 < getLength(this.stageStats); i37++) {
            if (this.stageStats[i37][0] != 0) {
                this.bQ[i37][0] = this.stageStats[i37][2];
            } else {
                this.bQ[i37][0] = 0;
            }
        }
        for (int i38 = 0; i38 < getLength(this.bS); i38++) {
            for (int i39 = 0; i39 < getLength(this.bS[i38]); i39++) {
                for (int i40 = 0; i40 < getLength(this.bS[i38][i39]); i40++) {
                    this.bS[i38][i39][i40] = 0;
                }
            }
        }
        for (int i41 = 0; i41 < getLength(this.bT); i41++) {
            for (int i42 = 0; i42 < getLength(this.bT[i41]); i42++) {
                this.bT[i41][i42] = 0;
            }
        }
        for (int i43 = 0; i43 < getLength(this.bU); i43++) {
            this.bU[i43] = 0;
        }
        if (this.bV[4] == 2) {
            for (int i44 = 0; i44 < getLength(this.cc); i44++) {
                this.cc[i44][0] = ((i44 * 192) + aMath.rand(192)) % ((this.bV[0] / 10) + (this.w * 4));
                this.cc[i44][1] = aMath.rand(((100 - this.battleData[28]) * 20) + 200) - ((100 - this.battleData[28]) * 20);
                this.cc[i44][2] = 0;
                this.cc[i44][3] = aMath.rand(20) + 5;
                this.cc[i44][4] = aMath.rand(7);
            }
        } else if (this.bV[4] == 3) {
            for (int i45 = 0; i45 < getLength(this.ce); i45++) {
                this.ce[i45][0] = ((((i45 * 56) + aMath.rand(56)) % (this.bV[0] / 10)) + (this.w * 4)) * 100;
                this.ce[i45][1] = (aMath.rand(((100 - this.battleData[28]) * 20) + 640) - ((100 - this.battleData[28]) * 20)) * 100;
                this.ce[i45][2] = 175 - aMath.rand(85);
                this.ce[i45][3] = aMath.rand(600) + 200;
            }
        }
        if (this.settingsMenuTexture[1].isLoaded()) {
            this.settingsMenuTexture[1].reset();
        }
        if (!this.settingsMenuTexture[1].isLoaded()) {
            this.settingsMenuTexture[1].load(MyUtility.getString(String.format("img%03d.png", 100)), MyUtility.getString(String.format("img%03d.imgcut", 100)));
        }
        if (this.uiTextures[0].isLoaded()) {
            this.uiTextures[0].reset();
        }
        if (!this.uiTextures[0].isLoaded()) {
            this.uiTextures[0].load(MyUtility.getString(String.format("bg%03d.png", Integer.valueOf(this.bV[4] + 0))), MyUtility.getString(String.format("bg%03d.imgcut", Integer.valueOf(this.bV[4]))));
        }
        if (this.uiTextures[1].isLoaded()) {
            this.uiTextures[1].reset();
        }
        if (!this.uiTextures[1].isLoaded()) {
            this.uiTextures[1].load(MyUtility.getString(String.format("fc%03d.png", 0)), MyUtility.getString(String.format("fc%03d.imgcut", 0)));
        }
        if (this.uiTextures[2].isLoaded()) {
            this.uiTextures[2].reset();
        }
        if (!this.uiTextures[2].isLoaded()) {
            this.uiTextures[2].load(MyUtility.getString(String.format("ec%03d.png", Integer.valueOf(this.battleData[20]))), MyUtility.getString(String.format("ec%03d.imgcut", Integer.valueOf(this.battleData[20]))));
        }
        if (this.catBaseTexture[0].isLoaded()) {
            this.catBaseTexture[0].reset();
        }
        if (!this.catBaseTexture[0].isLoaded()) {
            this.catBaseTexture[0].load(MyUtility.getString(String.format("i%03d_a.png", 0)), MyUtility.getString(String.format("%03d_a.imgcut", 0)));
            this.catBaseModel[0].load(MyUtility.getString(String.format("%03d_a.mamodel", 0)));
            for (int i46 = 0; i46 < 1; i46++) {
                this.catBaseAnim[0][i46].load(MyUtility.getString(String.format("%03d_a%02d.maanim", 0, Integer.valueOf(i46))));
            }
            this.catBaseModel[1].load(MyUtility.getString(String.format("%03d_a.mamodel", 1)));
            for (int i47 = 0; i47 < 2; i47++) {
                this.catBaseAnim[1][i47].load(MyUtility.getString(String.format("%03d_a%02d.maanim", 1, Integer.valueOf(i47))));
            }
            for (int i48 = 0; i48 < 2; i48++) {
                this.catBaseModel[i48].setTextures(this.catBaseTexture);
                this.catBaseModel[i48].setAction();
            }
        }
        if (this.uiTextures[4].isLoaded()) {
            this.uiTextures[4].reset();
        }
        if (!this.uiTextures[4].isLoaded()) {
            this.uiTextures[4].load(MyUtility.getString(String.format("img%03d.png", 1)), MyUtility.getString(String.format("img%03d.imgcut", 1)));
        }
        if (this.uiTextures[15].isLoaded()) {
            this.uiTextures[15].reset();
        }
        if (!this.uiTextures[15].isLoaded()) {
            this.uiTextures[15].load(MyUtility.getString(String.format("img%03d.png", 2)), MyUtility.getString(String.format("img%03d.imgcut", 2)));
        }
        if (this.uiTextures[16].isLoaded()) {
            this.uiTextures[16].reset();
        }
        if (!this.uiTextures[16].isLoaded()) {
            this.uiTextures[16].load(MyUtility.getString(String.format("ec%03d_s.png", Integer.valueOf(this.battleData[20]))), MyUtility.getString(String.format("ec%03d_s.imgcut", Integer.valueOf(this.battleData[20]))));
        }
        if (this.uiTextures[17].isLoaded()) {
            this.uiTextures[17].reset();
        }
        if (!this.uiTextures[17].isLoaded()) {
            this.uiTextures[17].load(MyUtility.getString(String.format("ec%03d_n_%s.png", Integer.valueOf(this.battleData[20]), MyUtility.getString("lang"))), MyUtility.getString(String.format("ec%03d_n_%s.imgcut", Integer.valueOf(this.battleData[20]), MyUtility.getString("lang"))));
        }
        if (this.uiTextures[18].isLoaded()) {
            this.uiTextures[18].reset();
        }
        if (!this.uiTextures[18].isLoaded()) {
            this.uiTextures[18].load(MyUtility.getString(String.format("img%03d.png", 3)), MyUtility.getString(String.format("img%03d.imgcut", 3)));
        }
        if (this.uiTextures[19].isLoaded()) {
            this.uiTextures[19].reset();
        }
        if (!this.uiTextures[19].isLoaded()) {
            this.uiTextures[19].load(MyUtility.getString(String.format("img%03d.png", 4)), MyUtility.getString(String.format("img%03d.imgcut", 4)));
        }
        if (this.uiTextures[20].isLoaded()) {
            this.uiTextures[20].reset();
        }
        if (!this.uiTextures[20].isLoaded()) {
            this.uiTextures[20].load(MyUtility.getString(String.format("img%03d.png", 43)), MyUtility.getString(String.format("img%03d.imgcut", 43)));
        }
        if (this.uiTextures[21].isLoaded()) {
            this.uiTextures[21].reset();
        }
        if (!this.uiTextures[21].isLoaded()) {
            this.uiTextures[21].load(MyUtility.getString(String.format("img%03d.png", 6)), MyUtility.getString(String.format("img%03d.imgcut", 6)));
        }
        if (this.uiTextures[23].isLoaded()) {
            this.uiTextures[23].reset();
        }
        if (!this.uiTextures[23].isLoaded()) {
            this.uiTextures[23].load(MyUtility.getString(String.format("img%03d.png", 40)), MyUtility.getString(String.format("img%03d.imgcut", 40)));
        }
        if (this.uiTextures[24].isLoaded()) {
            this.uiTextures[24].reset();
        }
        if (!this.uiTextures[24].isLoaded()) {
            this.uiTextures[24].load(MyUtility.getString(String.format("img%03d.png", 41)), MyUtility.getString(String.format("img%03d.imgcut", 41)));
        }
        if (this.uiTextures[25].isLoaded()) {
            this.uiTextures[25].reset();
        }
        if (!this.uiTextures[25].isLoaded()) {
            this.uiTextures[25].load(MyUtility.getString(String.format("img%03d.png", 42)), MyUtility.getString(String.format("img%03d.imgcut", 42)));
        }
        if (this.godTexture[0].isLoaded()) {
            this.godTexture[0].reset();
        }
        if (!this.godTexture[0].isLoaded()) {
            this.godTexture[0].load(MyUtility.getString(String.format("i%03d_g.png", 0)), MyUtility.getString(String.format("%03d_g.imgcut", 0)));
        }
        this.godModel[0][0].load(MyUtility.getString(String.format("%03d_g%02d_%d.mamodel", 0, 0, 1)));
        this.godAnim[0][0].load(MyUtility.getString(String.format("%03d_g%02d_%d.maanim", 0, 0, 1)));
        this.godModel[0][0].setTextures(this.godTexture);
        this.godModel[0][0].setAction();
        this.godModel[0][1].load(MyUtility.getString(String.format("%03d_g%02d_%d.mamodel", 0, 0, 2)));
        this.godAnim[0][1].load(MyUtility.getString(String.format("%03d_g%02d_%d.maanim", 0, 0, 2)));
        this.godModel[0][1].setTextures(this.godTexture);
        this.godModel[0][1].setAction();
        this.godModel[1][0].load(MyUtility.getString(String.format("%03d_g%02d_%d.mamodel", 0, 1, 1)));
        this.godAnim[1][0].load(MyUtility.getString(String.format("%03d_g%02d_%d.maanim", 0, 1, 1)));
        this.godModel[1][0].setTextures(this.godTexture);
        this.godModel[1][0].setAction();
        this.godModel[1][1].load(MyUtility.getString(String.format("%03d_g%02d_%d.mamodel", 0, 1, 2)));
        this.godAnim[1][1].load(MyUtility.getString(String.format("%03d_g%02d_%d.maanim", 0, 1, 2)));
        this.godModel[1][1].setTextures(this.godTexture);
        this.godModel[1][1].setAction();
        this.godModel[2][0].load(MyUtility.getString(String.format("%03d_g%02d_%d.mamodel", 0, 2, 1)));
        this.godAnim[2][0].load(MyUtility.getString(String.format("%03d_g%02d_%d.maanim", 0, 2, 1)));
        this.godModel[2][0].setTextures(this.godTexture);
        this.godModel[2][0].setAction();
        this.godModel[2][1].load(MyUtility.getString(String.format("%03d_g%02d_%d.mamodel", 0, 2, 2)));
        this.godAnim[2][1].load(MyUtility.getString(String.format("%03d_g%02d_%d.maanim", 0, 2, 2)));
        this.godModel[2][1].setTextures(this.godTexture);
        this.godModel[2][1].setAction();
        this.godModel[3][0].load(MyUtility.getString(String.format("%03d_g%02d.mamodel", 0, 3)));
        this.godAnim[3][0].load(MyUtility.getString(String.format("%03d_g%02d.maanim", 0, 3)));
        this.godModel[3][0].setTextures(this.godTexture);
        this.godModel[3][0].setAction();
        for (int i49 = 0; i49 < getLength(this.unitTexturesF); i49++) {
            if (this.unitTexturesF[i49].isLoaded()) {
                this.unitTexturesF[i49].reset();
            }
        }
        for (int i50 = 0; i50 < getLength(this.unitTexturesC); i50++) {
            if (this.unitTexturesC[i50].isLoaded()) {
                this.unitTexturesC[i50].reset();
            }
        }
        for (int i51 = 0; i51 < 10; i51++) {
            if (this.uiTextures[i51 + 5].isLoaded()) {
                this.uiTextures[i51 + 5].reset();
            }
        }
        for (int i52 = 0; i52 < 10; i52++) {
            if (this.slotCatIDs[i52] == -1) {
                this.uiTextures[i52 + 5].load(MyUtility.getString(String.format("uni.png", new Object[0])), MyUtility.getString(String.format("uni.imgcut", new Object[0])));
            } else if (this.slotFormIDs[i52] == 0) {
                if (!this.uiTextures[i52 + 5].isLoaded()) {
                    this.uiTextures[i52 + 5].load(MyUtility.getString(String.format("uni%03d_f%02d.png", Integer.valueOf(this.slotCatIDs[i52] - 2), 0)), MyUtility.getString(String.format("uni%03d_f%02d.imgcut", Integer.valueOf(this.slotCatIDs[i52] - 2), 0)));
                }
            } else if (this.slotFormIDs[i52] == 1 && !this.uiTextures[i52 + 5].isLoaded()) {
                this.uiTextures[i52 + 5].load(MyUtility.getString(String.format("uni%03d_c%02d.png", Integer.valueOf(this.slotCatIDs[i52] - 2), 0)), MyUtility.getString(String.format("uni%03d_c%02d.imgcut", Integer.valueOf(this.slotCatIDs[i52] - 2), 0)));
            }
        }
        for (int i53 = 0; i53 < 10; i53++) {
            if (this.slotCatIDs[i53] != -1) {
                if (this.slotFormIDs[i53] == 0) {
                    if (!this.unitTexturesF[this.slotCatIDs[i53] - 2].isLoaded()) {
                        this.unitTexturesF[this.slotCatIDs[i53] - 2].load(MyUtility.getString(String.format("i%03d_f.png", Integer.valueOf(this.slotCatIDs[i53] - 2))), MyUtility.getString(String.format("%03d_f.imgcut", Integer.valueOf(this.slotCatIDs[i53] - 2))));
                        this.unitSlotModels[i53].load(MyUtility.getString(String.format("%03d_f.mamodel", Integer.valueOf(this.slotCatIDs[i53] - 2))));
                        for (int i54 = 0; i54 < getLength(this.unitSlotAnims[i53]); i54++) {
                            this.unitSlotAnims[i53][i54].load(MyUtility.getString(String.format("%03d_f%02d.maanim", Integer.valueOf(this.slotCatIDs[i53] - 2), Integer.valueOf(i54))));
                        }
                        this.unitSlotModels[i53].setTextures(this.unitTexturesF);
                        this.unitSlotModels[i53].setAction();
                    }
                } else if (this.slotFormIDs[i53] == 1 && !this.unitTexturesC[this.slotCatIDs[i53] - 2].isLoaded()) {
                    this.unitTexturesC[this.slotCatIDs[i53] - 2].load(MyUtility.getString(String.format("i%03d_c.png", Integer.valueOf(this.slotCatIDs[i53] - 2))), MyUtility.getString(String.format("%03d_c.imgcut", Integer.valueOf(this.slotCatIDs[i53] - 2))));
                    this.unitSlotModels[i53].load(MyUtility.getString(String.format("%03d_c.mamodel", Integer.valueOf(this.slotCatIDs[i53] - 2))));
                    for (int i55 = 0; i55 < getLength(this.unitSlotAnims[i53]); i55++) {
                        this.unitSlotAnims[i53][i55].load(MyUtility.getString(String.format("%03d_c%02d.maanim", Integer.valueOf(this.slotCatIDs[i53] - 2), Integer.valueOf(i55))));
                    }
                    this.unitSlotModels[i53].setTextures(this.unitTexturesC);
                    this.unitSlotModels[i53].setAction();
                }
            }
        }
        for (int i56 = 0; i56 < 10; i56++) {
            this.slotEnemyIDs[i56] = -1;
        }
        for (int i57 = 0; i57 < getLength(this.stageStats); i57++) {
            int i58 = 0;
            while (true) {
                if (i58 < 10 && this.stageStats[i57][0] != 0 && this.stageStats[i57][0] != this.slotEnemyIDs[i58]) {
                    if (this.slotEnemyIDs[i58] == -1) {
                        this.slotEnemyIDs[i58] = this.stageStats[i57][0];
                        break;
                    }
                    i58++;
                }
                else{
                    break;
                }
            }
        }
        for (int i59 = 0; i59 < getLength(this.enemyTextures); i59++) {
            if (this.enemyTextures[i59].isLoaded()) {
                this.enemyTextures[i59].reset();
            }
        }
        for (int i60 = 0; i60 < 10; i60++) {
            if (this.slotEnemyIDs[i60] != -1 && this.slotEnemyIDs[i60] > 0 && !this.enemyTextures[this.slotEnemyIDs[i60] - 2].isLoaded()) {
                if (this.slotEnemyIDs[i60] - 2 == 21) {
                    this.enemyTextures[this.slotEnemyIDs[i60] - 2].load(MyUtility.getString(String.format("i%03d_e.png", Integer.valueOf(this.slotEnemyIDs[i60] - 2))), MyUtility.getString(String.format("i%03d_e.imgcut", Integer.valueOf(this.slotEnemyIDs[i60] - 2))));
                } else {
                    this.enemyTextures[this.slotEnemyIDs[i60] - 2].load(MyUtility.getString(String.format("i%03d_e.png", Integer.valueOf(this.slotEnemyIDs[i60] - 2))), MyUtility.getString(String.format("%03d_e.imgcut", Integer.valueOf(this.slotEnemyIDs[i60] - 2))));
                }
                this.enemySlotModels[i60].load(MyUtility.getString(String.format("%03d_e.mamodel", Integer.valueOf(this.slotEnemyIDs[i60] - 2))));
                for (int i61 = 0; i61 < getLength(this.enemySlotAnims[i60]); i61++) {
                    this.enemySlotAnims[i60][i61].load(MyUtility.getString(String.format("%03d_e%02d.maanim", Integer.valueOf(this.slotEnemyIDs[i60] - 2), Integer.valueOf(i61))));
                }
                this.enemySlotModels[i60].setTextures(this.enemyTextures);
                this.enemySlotModels[i60].setAction();
            }
        }
        for (int i62 = 0; i62 < getLength(this.textTextures); i62++) {
            if (this.textTextures[i62].isLoaded()) {
                this.textTextures[i62].reset();
            }
        }
        for (int i63 = 0; i63 < getLength(this.warningTextures); i63++) {
            if (this.warningTextures[i63].isLoaded()) {
                this.warningTextures[i63].reset();
            }
        }
        for (int i64 = 0; i64 < getLength(this.gA); i64++) {
            this.gA[i64] = 0;
        }
        this.warningTextures[0].drawText(this.warning1Text[5], "FONT_SYSTEM_BOLD", 30, 1);
        for (int i65 = 0; i65 < 4; i65++) {
            this.textTextures[i65 + 1].drawText(this.stageFirstMessageText[0][i65], "FONT_SYSTEM_BOLD", 30, 1);
        }
        this.textTextures[10].drawText(this.optionText[1], "FONT_SYSTEM_BOLD", 30, 1);
        this.gA[0] = 20;
        this.fw[0][0] = this.w + 814;
        this.fw[0][1] = this.eZ + 510;
        this.fw[0][2] = 146;
        this.fw[0][3] = 130;
        this.fw[1][0] = 0;
        this.fw[1][1] = this.eZ + 515;
        this.fw[1][2] = 146;
        this.fw[1][3] = 125;
        this.fw[3][0] = 0;
        this.fw[3][1] = 0 - this.eZ;
        this.fw[3][2] = 88;
        this.fw[3][3] = 88;
        int i66 = 5;
        for (int i67 = 5; i67 >= 0; i67--) {
            if (this.eL[i67] != 0) {
                this.eJ[i67][0] = (i66 * 88) + 432 + this.w;
                this.eJ[i67][1] = 43 - this.eZ;
                this.eJ[i67][2] = 88;
                this.eJ[i67][3] = 88;
                i66--;
            }
        }
        for (int i68 = 0; i68 < getLength(this.eD); i68++) {
            this.eD[i68] = 0;
        }
        for (int i69 = 0; i69 < getLength(this.gd); i69++) {
            this.gd[i69] = 0;
        }
        for (int i70 = 0; i70 < getLength(this.ge); i70++) {
            this.ge[i70] = 0;
        }
        for (int i71 = 0; i71 < getLength(this.gf); i71++) {
            this.gf[i71] = 0;
        }
        for (int i72 = 0; i72 < getLength(this.gg); i72++) {
            this.gg[i72] = 0;
        }
        for (int i73 = 0; i73 < getLength(this.scrollAmount); i73++) {
            this.scrollAmount[i73] = 0;
        }
        for (int i74 = 0; i74 < getLength(this.eE); i74++) {
            this.eE[i74] = false;
        }
        for (int i75 = 0; i75 < getLength(this.el); i75++) {
            this.el[i75] = 0;
        }
        this.battleData[12] = 0;
        this.eG = 1;
        this.eX = false;
        this.fa = 0;
        this.fU = 0;
        this.eS = 0;
        for (int i76 = 0; i76 < getLength(this.gV); i76++) {
            this.gV[i76] = 0;
        }
        this.gW = 0;
        this.fX = aMath.rand(this.battleData[9]);
        aSound.getInstance().stop(-1);
        this.gameStats1[0] = 0;
        int i77 = 0;
        while (true) {
            if (i77 >= 10) {
                break;
            } else if (this.eQ == i77 && this.battleData[0] == 47) {
                this.gameStats1[0] = i77;
                break;
            } else {
                i77++;
            }
        }
        if (this.gameStats1[0] >= 1) {
            int[] iArr6 = this.gameStats1;
            iArr6[0] = iArr6[0] + 1;
        }
        aSound.getInstance().play(cn[(this.battleData[0] + this.gameStats1[0]) * 3]);
        this.gameStats1[0] = 0;
        for (int i78 = 0; i78 < getLength(this.fB); i78++) {
            for (int i79 = 0; i79 < getLength(this.fB[i78]); i79++) {
                this.fB[i78][i79] = 0;
            }
        }
        for (int i80 = 0; i80 < getLength(this.fC); i80++) {
            this.fC[i80] = 0;
        }
        this.fB[0][0] = (this.w / 2) + 280;
        this.fB[0][1] = 80;
        this.fB[0][2] = 88;
        this.fB[0][3] = 88;
        this.fB[1][0] = 0;
        this.fB[1][1] = 0;
        this.fB[1][2] = 0;
        this.fB[1][3] = 0;
        this.fB[2][0] = (this.w / 2) + 535;
        this.fB[2][1] = 276;
        this.fB[2][2] = 106;
        this.fB[2][3] = 88;
        this.fB[3][0] = (((this.w / 2) + 248) + 252) - 2;
        this.fB[3][1] = 371;
        this.fB[3][2] = 88;
        this.fB[3][3] = 88;
        this.fB[4][0] = (((this.w / 2) + 248) + 356) - 2;
        this.fB[4][1] = 371;
        this.fB[4][2] = 88;
        this.fB[4][3] = 88;
        this.fB[5][0] = (this.w / 2) + 248 + 404;
        this.fB[5][1] = 48;
        this.fB[5][2] = 95;
        this.fB[5][3] = 95;
        this.fB[6][0] = (this.w / 2) + 248 + 40;
        this.fB[6][1] = 456;
        this.fB[6][2] = 381;
        this.fB[6][3] = 88;
        this.fB[7][0] = (this.w / 2) + 248 + 40;
        this.fB[7][1] = 189;
        this.fB[7][2] = 168;
        this.fB[7][3] = 88;
        this.fB[8][0] = (this.w / 2) + 309;
        this.fB[8][1] = 284;
        this.fB[8][2] = 131;
        this.fB[8][3] = 131;
        this.fB[9][0] = (this.w / 2) + 288;
        this.fB[9][1] = 363;
        this.fB[9][2] = 168;
        this.fB[9][3] = 88;
        this.fB[10][0] = (this.w / 2) + 251;
        this.fB[10][1] = 374;
        this.fB[10][2] = 168;
        this.fB[10][3] = 88;
        this.fB[11][0] = (this.w / 2) + 541;
        this.fB[11][1] = 374;
        this.fB[11][2] = 168;
        this.fB[11][3] = 88;
        this.fB[12][0] = (this.w / 2) + 500;
        this.fB[12][1] = 191;
        this.fB[12][2] = 172;
        this.fB[12][3] = 88;
        for (int i81 = 0; i81 < getLength(this.hb); i81++) {
            this.hb[i81] = 0.0f;
        }
        this.hj[0][0] = (this.w / 2) + 246;
        this.hj[0][1] = 0 - this.eZ;
        this.hj[0][2] = 131;
        this.hj[0][3] = 107;
        this.hj[1][0] = (this.w / 2) + 246;
        this.hj[1][1] = 345;
        this.hj[1][2] = 96;
        this.hj[1][3] = 96;
        this.hj[2][0] = (this.w / 2) + 426;
        this.hj[2][1] = 335;
        this.hj[2][2] = 96;
        this.hj[2][3] = 96;
        this.hj[3][0] = (this.w / 2) + 606;
        this.hj[3][1] = 345;
        this.hj[3][2] = 96;
        this.hj[3][3] = 96;
        this.hj[4][0] = (this.w / 2) + 786;
        this.hj[4][1] = 335;
        this.hj[4][2] = 96;
        this.hj[4][3] = 96;
        this.hj[5][0] = 4;
        this.hj[5][1] = 541;
        this.hj[5][2] = 95;
        this.hj[5][3] = 95;
        this.hj[6][0] = (this.w / 2) + 422;
        this.hj[6][1] = 313;
        this.hj[6][2] = 381;
        this.hj[6][3] = 88;
        this.hj[7][0] = (this.w / 2) + 803;
        this.hj[7][1] = 173;
        this.hj[7][2] = 95;
        this.hj[7][3] = 95;
        this.hj[8][0] = 580;
        this.hj[8][1] = 547;
        this.hj[8][2] = 88;
        this.hj[8][3] = 88;
        this.fw[10][0] = this.w + 701;
        this.fw[10][1] = this.eZ + 578;
        this.fw[10][2] = 88;
        this.fw[10][3] = 88;
        this.fw[11][0] = this.w + 799;
        this.fw[11][1] = this.eZ + 578;
        this.fw[11][2] = 88;
        this.fw[11][3] = 88;
        this.fw[13][0] = 197;
        this.fw[13][1] = 552;
        this.fw[13][2] = 214;
        this.fw[13][3] = 88;
        this.fw[14][0] = this.w + 680;
        this.fw[14][1] = 552;
        this.fw[14][2] = 88;
        this.fw[14][3] = 88;
        for (int i82 = 0; i82 < getLength(this.em); i82++) {
            this.em[i82] = 0;
        }
        for (int i83 = 0; i83 < getLength(this.en); i83++) {
            this.en[i83] = 0;
        }
        this.eo = 0;
        for (int i84 = 0; i84 < getLength(this.ep); i84++) {
            this.ep[i84] = 0.0f;
        }
        for (int i85 = 0; i85 < getLength(this.eq); i85++) {
            this.eq[i85] = 0;
        }
        for (int i86 = 0; i86 < getLength(this.er); i86++) {
            this.er[i86] = 0;
        }
        for (int i87 = 0; i87 < getLength(this.es); i87++) {
            this.es[i87] = 0;
        }
        for (int i88 = 0; i88 < getLength(this.et); i88++) {
            this.et[i88] = false;
        }
        for (int i89 = 0; i89 < getLength(this.eu); i89++) {
            this.eu[i89] = 0;
        }
        for (int i90 = 0; i90 < getLength(this.ev); i90++) {
            this.ev[i90] = 0;
        }
        this.ew = 0;
        for (int i91 = 0; i91 < getLength(this.ev); i91++) {
            this.ev[i91] = 0;
        }
        this.ex = false;
        this.ey = 0;
        this.ez = 0;
        for (int i92 = 0; i92 < getLength(this.eA); i92++) {
            for (int i93 = 0; i93 < getLength(this.eA[i92]); i93++) {
                this.eA[i92][i93] = 0;
            }
        }
        for (int i94 = 0; i94 < getLength(this.eB); i94++) {
            for (int i95 = 0; i95 < getLength(this.eB[i94]); i95++) {
                for (int i96 = 0; i96 < getLength(this.eB[i94][i95]); i96++) {
                    this.eB[i94][i95][i96] = 0;
                }
            }
        }
        for (int i97 = 0; i97 < getLength(this.eh); i97++) {
            this.eh[i97] = 0;
        }
        for (int i98 = 0; i98 < getLength(this.ei); i98++) {
            this.ei[i98] = 0;
        }
        for (int i99 = 0; i99 < getLength(this.fQ); i99++) {
            this.fQ[i99] = 0;
        }
        this.eC = false;
        this.dV = false;
        this.dW = 0;
        this.hH = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: W */
    public int getScene() {
        return this.scene;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getScene2() {
        return this.scene2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadTextures2() {
        for (int i = 0; i < getLength(this.unitTexturesF); i++) {
            if (this.unitTexturesF[i].isLoaded()) {
                this.unitTexturesF[i].reset();
            }
        }
        for (int i2 = 0; i2 < getLength(this.unitTexturesC); i2++) {
            if (this.unitTexturesC[i2].isLoaded()) {
                this.unitTexturesC[i2].reset();
            }
        }
        for (int i3 = 0; i3 < getLength(this.enemyTextures); i3++) {
            if (this.enemyTextures[i3].isLoaded()) {
                this.enemyTextures[i3].reset();
            }
        }
        for (int i4 = 0; i4 < getLength(this.godTexture); i4++) {
            if (this.godTexture[i4].isLoaded()) {
                this.godTexture[i4].reset();
            }
        }
        for (int i5 = 0; i5 < getLength(this.catBaseTexture); i5++) {
            if (this.catBaseTexture[i5].isLoaded()) {
                this.catBaseTexture[i5].reset();
            }
        }
        for (int i6 = 0; i6 < getLength(this.uniTextures); i6++) {
            if (this.uniTextures[i6].isLoaded()) {
                this.uniTextures[i6].reset();
            }
        }
        for (int i7 = 0; i7 < getLength(this.openingTexture); i7++) {
            if (this.openingTexture[i7].isLoaded()) {
                this.openingTexture[i7].reset();
            }
        }
        for (int i8 = 0; i8 < getLength(this.warningTextures); i8++) {
            if (this.warningTextures[i8].isLoaded()) {
                this.warningTextures[i8].reset();
            }
        }
        for (int i9 = 0; i9 < getLength(this.stampTextures); i9++) {
            if (this.stampTextures[i9].isLoaded()) {
                this.stampTextures[i9].reset();
            }
        }
        for (int i10 = 0; i10 < getLength(this.legendTextures); i10++) {
            if (this.legendTextures[i10].isLoaded()) {
                this.legendTextures[i10].reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z() {
        for (int i = 0; i < getLength(this.gp); i++) {
            this.gp[i] = false;
        }
        //aAd.b().f();
        for (int i2 = 0; i2 < getLength(this.fw); i2++) {
            for (int i3 = 0; i3 < getLength(this.fw[i2]); i3++) {
                this.fw[i2][i3] = 0;
            }
        }
        for (int i4 = 0; i4 < getLength(this.eh); i4++) {
            this.eh[i4] = 0;
        }
        for (int i5 = 0; i5 < getLength(this.ei); i5++) {
            this.ei[i5] = 0;
        }
        for (int i6 = 0; i6 < getLength(this.fQ); i6++) {
            this.fQ[i6] = 0;
        }
        for (int i7 = 0; i7 < getLength(this.fx); i7++) {
            this.fx[i7] = 0;
        }
        this.fw[0][0] = 633;
        this.fw[0][1] = 488;
        this.fw[0][2] = 304;
        this.fw[0][3] = 86;
        this.fw[5][0] = 4;
        this.fw[5][1] = 541;
        this.fw[5][2] = 95;
        this.fw[5][3] = 95;
        for (int i8 = 0; i8 < getLength(this.gm); i8++) {
            this.gm[i8] = 0;
        }
        this.gm[1] = 297;
        for (int i9 = 0; i9 < getLength(this.eE); i9++) {
            this.eE[i9] = false;
        }
        this.gm[0] = 297;
        this.gm[1] = 0;
        this.eE[0] = false;
        this.fQ[2] = 0;
        loadTextures2();
        for (int i10 = 0; i10 < 10; i10++) {
            if (this.slotCatIDs[i10] - 2 >= 0) {
                this.slotFormIDs[i10] = this.bw[this.slotCatIDs[i10] - 2];
            } else {
                this.slotFormIDs[i10] = 0;
            }
        }
        for (int i11 = 0; i11 < 10; i11++) {
            if (!this.uniTextures[i11].isLoaded()) {
                if (this.slotCatIDs[i11] == -1) {
                    this.uniTextures[i11].load(MyUtility.getString(String.format("uni.png", new Object[0])), MyUtility.getString(String.format("uni.imgcut", new Object[0])));
                } else if (this.slotFormIDs[i11] == 0) {
                    this.uniTextures[i11].load(MyUtility.getString(String.format("uni%03d_f%02d.png", Integer.valueOf(this.slotCatIDs[i11] - 2), 0)), MyUtility.getString(String.format("uni%03d_f%02d.imgcut", Integer.valueOf(this.slotCatIDs[i11] - 2), 0)));
                } else if (this.slotFormIDs[i11] == 1) {
                    this.uniTextures[i11].load(MyUtility.getString(String.format("uni%03d_c%02d.png", Integer.valueOf(this.slotCatIDs[i11] - 2), 0)), MyUtility.getString(String.format("uni%03d_c%02d.imgcut", Integer.valueOf(this.slotCatIDs[i11] - 2), 0)));
                }
            }
        }
        if (this.uiTextures[6].isLoaded()) {
            this.uiTextures[6].reset();
        }
        if (!this.uiTextures[6].isLoaded()) {
            this.uiTextures[6].load(MyUtility.getString(String.format("img%03d.png", 32)), MyUtility.getString(String.format("img%03d.imgcut", 32)));
        }
        if (this.uiTextures[7].isLoaded()) {
            this.uiTextures[7].reset();
        }
        if (!this.uiTextures[7].isLoaded()) {
            this.uiTextures[7].load(MyUtility.getString(String.format("img%03d.png", 19)), MyUtility.getString(String.format("img%03d.imgcut", 19)));
        }
        if (this.uiTextures[8].isLoaded()) {
            this.uiTextures[8].reset();
        }
        if (!this.uiTextures[8].isLoaded()) {
            this.uiTextures[8].load(MyUtility.getString(String.format("img%03d.png", 33)), MyUtility.getString(String.format("img%03d.imgcut", 33)));
        }
        if (this.uiTextures[9].isLoaded()) {
            this.uiTextures[9].reset();
        }
        if (this.uiTextures[10].isLoaded()) {
            this.uiTextures[10].reset();
        }
        if (this.uiTextures[11].isLoaded()) {
            this.uiTextures[11].reset();
        }
        this.dY = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(float[] fArr) {
        return fArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(int[] iArr) {
        return iArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(String[] strArr) {
        return strArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(aTexture[] atextureArr) {
        return atextureArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(aModel[] amodelArr) {
        return amodelArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(aModelAnimation[] amodelanimationArr) {
        return amodelanimationArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(boolean[] zArr) {
        return zArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(int[][] iArr) {
        return iArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(String[][] strArr) {
        return strArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(aModel[][] amodelArr) {
        return amodelArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(aModelAnimation[][] amodelanimationArr) {
        return amodelanimationArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(int[][][] iArr) {
        return iArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength(String[][][] strArr) {
        return strArr.length;
    }

    public void onCreate() {
    }

    public void onTouchEvent(int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(aTextureRenderer atexturerenderer, int catID, int i2, int i3) {
        this.gameStats1[2] = this.unitStats[this.slotCatIDs[catID]][this.slotFormIDs[catID]][7];
        int[] iArr = this.gameStats1;
        iArr[2] = iArr[2] - (ad[7] + (this.bx[7] * 6));
        for (int i4 = 0; i4 < 10; i4++) {
            int[] iArr2 = this.gameStats1;
            iArr2[2] = iArr2[2] - ((cB[2] * this.bO[i4][2]) / 100);
        }
        if (this.gameStats1[2] <= 60) {
            this.gameStats1[2] = 60;
        }
        this.gameStats1[3] = ((this.gameStats1[2] - this.eW[catID]) * 93) / this.gameStats1[2];
        if (this.gameStats1[3] > 93) {
            this.gameStats1[3] = 93;
        }
        this.gameStats1[4] = ((100 - i3) * 97) / 100;
        this.gameStats1[5] = ((100 - i3) * 14) / 100;
        this.gameStats1[6] = (this.gameStats1[3] * (100 - i3)) / 100;
        this.gameStats1[7] = ((100 - i3) * 10) / 100;
        if (i2 == 0) {
            atexturerenderer.setColor(0, 0, 0);
            atexturerenderer.drawRectangle(fb[catID] + 6 + (this.w / 2), ((this.eI[0] + 610) - 4) + this.eZ, 97, 14);
            atexturerenderer.setColor(0, 255, 255);
            atexturerenderer.drawRectangle(fb[catID] + 8 + (this.w / 2), ((this.eI[0] + 612) - 4) + this.eZ, this.gameStats1[3], 10);
            return;
        }
        atexturerenderer.setColor(0, 0, 0);
        atexturerenderer.drawRectangle(fb[catID] + 6 + ((97 - this.gameStats1[4]) / 2) + (this.w / 2), (((this.eI[0] + 610) + this.eD[i2]) - ((14 - this.gameStats1[5]) / 2)) + this.eZ, this.gameStats1[4], this.gameStats1[5]);
        atexturerenderer.setColor(0, 255, 255);
        atexturerenderer.drawRectangle(fb[catID] + 8 + ((93 - (((100 - i3) * 93) / 100)) / 2) + (this.w / 2), (((this.eI[0] + 612) + this.eD[i2]) - ((10 - this.gameStats1[7]) / 2)) + this.eZ, this.gameStats1[6], this.gameStats1[7]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawCost(aTextureRenderer atexturerenderer, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i6 != 0) {
            if (i6 == 1) {
                int i7 = ((100 - i5) * 22) / 100;
                int i8 = ((100 - i5) * 26) / 100;
                atexturerenderer.drawScaledImage(this.uiTextures[8], i2 + ((22 - i7) / 2), i3 + ((26 - i8) / 2), i7, i8, 70);
                int i9 = i2 - (((100 - i5) * 15) / 100);
                int i10 = ((100 - i5) * 18) / 100;
                int i11 = ((100 - i5) * 26) / 100;
                do {
                    int i12 = i9;
                    atexturerenderer.drawScaledImage(this.uiTextures[8], i12 + ((18 - i10) / 2), i3 + ((26 - i11) / 2), i10, i11, (i % 10) + 60);
                    i /= 10;
                    i9 = i12 - (((100 - i5) * 15) / 100);
                } while (i > 0);
            }
        } else if (i4 != 0 && i4 != 1) {
            if (i4 == 2 || i4 == 3) {
                int i13 = 1;
                int i14 = i2;
                while (i13 <= i) {
                    i13 *= 10;
                    i14 += ((100 - i5) * 15) / 100;
                }
                int i15 = ((100 - i5) * 22) / 100;
                int i16 = ((100 - i5) * 26) / 100;
                if (i4 == 2) {
                    atexturerenderer.drawScaledImage(this.uiTextures[4], i14, i3 + ((26 - i16) / 2), i15, i16, 45);
                } else if (i4 == 3) {
                    atexturerenderer.drawScaledImage(this.uiTextures[4], i14, i3 + ((26 - i16) / 2), i15, i16, 56);
                }
                int i17 = ((100 - i5) * 18) / 100;
                int i18 = ((100 - i5) * 26) / 100;
                int i19 = i14 - (((100 - i5) * 15) / 100);
                do {
                    int i20 = i19;
                    if (i4 == 2) {
                        atexturerenderer.drawScaledImage(this.uiTextures[4], i20 + ((18 - i17) / 2), i3 + ((26 - i18) / 2), i17, i18, (i % 10) + 35);
                    } else if (i4 == 3) {
                        atexturerenderer.drawScaledImage(this.uiTextures[4], i20 + ((18 - i17) / 2), i3 + ((26 - i18) / 2), i17, i18, (i % 10) + 46);
                    }
                    i /= 10;
                    i19 = i20 - (((100 - i5) * 15) / 100);
                } while (i > 0);
            }
        } else {
            int i21 = i2 + 4;
            int i22 = i3 + 12;
            int i23 = ((100 - i5) * 22) / 100;
            int i24 = ((100 - i5) * 26) / 100;
            if (i4 == 0) {
                atexturerenderer.drawScaledImage(this.uiTextures[4], i21 + ((22 - i23) / 2), i22 + ((26 - i24) / 2), i23, i24, 45);
            } else if (i4 == 1) {
                atexturerenderer.drawScaledImage(this.uiTextures[4], i21 + ((22 - i23) / 2), i22 + ((26 - i24) / 2), i23, i24, 56);
            }
            int i25 = ((100 - i5) * 18) / 100;
            int i26 = ((100 - i5) * 26) / 100;
            int i27 = i21 - (((100 - i5) * 15) / 100);
            while (true) {
                if (i4 == 0) {
                    atexturerenderer.drawScaledImage(this.uiTextures[4], i27 + ((18 - i25) / 2), i22 + ((26 - i26) / 2), i25, i26, (i % 10) + 35);
                } else if (i4 == 1) {
                    atexturerenderer.drawScaledImage(this.uiTextures[4], i27 + ((18 - i25) / 2), i22 + ((26 - i26) / 2), i25, i26, (i % 10) + 46);
                }
                i /= 10;
                int i28 = i27 - (((100 - i5) * 15) / 100);
                if (i <= 0) {
                    return;
                }
                i27 = i28;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aa() {
        if (this.eE[5]) {
            if (!this.eE[0] && !this.eE[1] && !this.eE[2] && this.dY == 0) {
                if (this.fx[0] >= 1) {
                    int[] iArr = this.fx;
                    iArr[0] = iArr[0] + 1;
                    if (this.fx[0] > getLength(dv) - 1) {
                        this.fx[0] = 0;
                        this.eE[2] = true;
                        this.eh[1] = 960;
                        aSound.getInstance().play(7);
                    }
                } else if (this.fx[5] >= 1) {
                    int[] iArr2 = this.fx;
                    iArr2[5] = iArr2[5] + 1;
                    if (this.fx[5] > getLength(dv) - 1) {
                        this.fx[5] = 0;
                        screenTransition();
                        this.fP = 0;
                        this.fD = 9;
                        this.fF = -1;
                        this.fQ[2] = 0;
                        this.eE[1] = false;
                        return false;
                    }
                } else {
                    if (!R() || !b(this.fw[0][0], this.fw[0][1], this.fw[0][2], this.fw[0][3])) {
                        this.gp[0] = false;
                    } else if (!this.gp[0]) {
                        aSound.getInstance().play(10);
                        this.gp[0] = true;
                    }
                    if (!R() || !b(this.fw[5][0], this.fw[5][1], this.fw[5][2], this.fw[5][3])) {
                        this.gp[5] = false;
                    } else if (!this.gp[5]) {
                        aSound.getInstance().play(10);
                        this.gp[5] = true;
                    }
                    if (S() && b(this.fw[0][0], this.fw[0][1], this.fw[0][2], this.fw[0][3])) {
                        int[] iArr3 = this.fx;
                        iArr3[0] = iArr3[0] + 1;
                        aSound.getInstance().play(11);
                    } else if (S() && b(this.fw[5][0], this.fw[5][1], this.fw[5][2], this.fw[5][3])) {
                        int[] iArr4 = this.fx;
                        iArr4[5] = iArr4[5] + 1;
                        aSound.getInstance().play(11);
                    }
                }
            }
            if (this.eE[0]) {
                int[] iArr5 = this.fQ;
                iArr5[2] = iArr5[2] + 1;
                this.gm[0] = (this.gm[0] * 2) + 1;
                if (this.gm[0] >= 297) {
                    this.gm[0] = 297;
                    this.gm[1] = this.gm[1] / 2;
                }
                if (this.fQ[2] > getLength(fM) - 1) {
                    this.fQ[2] = getLength(fM) - 1;
                    this.fP = getWidth();
                    if (this.gm[1] <= 0) {
                        this.eE[0] = false;
                        this.fQ[2] = 0;
                    }
                } else {
                    this.fP = fM[this.fQ[2]];
                }
            } else if (this.eE[1]) {
                int[] iArr6 = this.fQ;
                iArr6[2] = iArr6[2] + 1;
                if (this.fQ[2] > getLength(fM) - 1) {
                    this.fP = 0;
                } else {
                    this.fP = fM[(getLength(fM) - 1) - this.fQ[2]];
                }
                if (this.fQ[2] > getLength(fM)) {
                    this.fQ[2] = 0;
                    screenTransition();
                    this.fP = 0;
                    this.fD = 9;
                    this.fF = -1;
                    this.eE[1] = false;
                    return false;
                }
            } else if (this.eE[2]) {
                this.eh[0] = (this.eh[0] * 2) + 1;
                this.ei[0] = (this.ei[0] * 2) + 1;
                if (this.eh[0] >= getWidth()) {
                    this.eh[0] = getWidth();
                    this.ei[0] = getHeight();
                    this.eh[1] = this.eh[1] / 2;
                    if (this.eh[1] >= getWidth()) {
                        this.eh[1] = getWidth();
                    }
                    int[] iArr7 = this.fQ;
                    iArr7[0] = iArr7[0] + 1;
                    if (this.fQ[0] >= getLength(cu)) {
                        this.fR[0] = 1;
                        this.dY = 1;
                        this.eE[2] = false;
                        this.fQ[0] = 0;
                    }
                }
            }
            if (this.dY == 1) {
                int[] iArr8 = this.fQ;
                iArr8[1] = iArr8[1] + 1;
                if (this.fQ[1] >= 10) {
                    int[] iArr9 = this.fQ;
                    iArr9[0] = iArr9[0] + 1;
                    if (this.fQ[0] >= 60) {
                        this.eb = true;
                        this.ed = 1;
                    }
                }
            }
        } else {
            this.eE[5] = true;
            this.pointerDown = false;
            this.pointerUp = false;
            this.P = false;
            this.O = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aLoad() {
        aFileStream afilestream = new aFileStream();
        if (afilestream.openRead("SAVE_DATA")) {
            afilestream.enableMD5();
            if (!afilestream.verifyMD5()) {
                afilestream.close();
                setScene(4);
                this.D = 0;
                return false;
            }
            int version = afilestream.readInt();
            aSound.getInstance().muteBGM(afilestream.readBoolean());
            aSound.getInstance().muteSE(afilestream.readBoolean());
            if (version == 0 || version == 1) {
                this.catfood = afilestream.readInt();
                this.currentEnergy = afilestream.readInt();
                for (int i = 0; i < getLength(this.years); i++) {
                    this.years[i] = afilestream.readInt();
                }
                for (int i2 = 0; i2 < getLength(this.months); i2++) {
                    this.months[i2] = afilestream.readInt();
                }
                for (int i3 = 0; i3 < getLength(this.days); i3++) {
                    this.days[i3] = afilestream.readInt();
                }
                this.aQ = afilestream.readDouble();
                this.hour = afilestream.readInt();
                this.minute = afilestream.readInt();
                this.second = afilestream.readInt();
                this.aU = afilestream.readInt();
                this.aV = afilestream.readInt();
                this.aW = afilestream.readInt();
                this.aX = afilestream.readInt();
                this.aY = afilestream.readInt();
                this.aZ = afilestream.readInt();
                this.ba = afilestream.readInt();
                this.bb = afilestream.readInt();
                for (int i4 = 0; i4 < getLength(this.bc); i4++) {
                    this.bc[i4] = afilestream.readInt();
                }
                this.bd = afilestream.readInt();
                this.be = afilestream.readInt();
                this.bf = afilestream.readInt();
                this.u = afilestream.readBoolean();
                this.bg = afilestream.readInt();
                this.bh = afilestream.readInt();
                this.bi = afilestream.readInt();
                this.bj = afilestream.readInt();
                for (int i5 = 0; i5 < getLength(this.slotCatIDs); i5++) {
                    this.slotCatIDs[i5] = afilestream.readInt();
                }
                this.bl = afilestream.readInt();
                for (int i6 = 0; i6 < getLength(this.bm); i6++) {
                    this.bm[i6] = afilestream.readInt();
                }
                this.bn = afilestream.readInt();
                this.bo = afilestream.readInt();
                for (int i7 = 0; i7 < getLength(this.bp); i7++) {
                    this.bp[i7] = afilestream.readInt();
                }
                for (int i8 = 0; i8 < getLength(this.bq); i8++) {
                    this.bq[i8] = afilestream.readInt();
                }
                for (int i9 = 0; i9 < getLength(this.br); i9++) {
                    for (int i10 = 0; i10 < getLength(this.br[i9]); i10++) {
                        this.br[i9][i10] = afilestream.readInt();
                    }
                }
                for (int i11 = 0; i11 < getLength(this.bs); i11++) {
                    for (int i12 = 0; i12 < getLength(this.bs[i11]); i12++) {
                        this.bs[i11][i12] = afilestream.readInt();
                    }
                }
                for (int i13 = 0; i13 < getLength(this.bt); i13++) {
                    this.bt[i13] = afilestream.readInt();
                }
                for (int i14 = 0; i14 < getLength(this.bu); i14++) {
                    this.bu[i14] = afilestream.readInt();
                }
                for (int i15 = 0; i15 < getLength(this.bv); i15++) {
                    this.bv[i15] = afilestream.readInt();
                }
                for (int i16 = 0; i16 < getLength(this.bw); i16++) {
                    this.bw[i16] = afilestream.readInt();
                }
                for (int i17 = 0; i17 < getLength(this.bx); i17++) {
                    this.bx[i17] = afilestream.readInt();
                }
                for (int i18 = 0; i18 < getLength(this.by); i18++) {
                    this.by[i18] = afilestream.readInt();
                }
                for (int i19 = 0; i19 < getLength(this.bz); i19++) {
                    this.bz[i19] = afilestream.readInt();
                }
                for (int i20 = 0; i20 < getLength(this.bA); i20++) {
                    this.bA[i20] = afilestream.readInt();
                }
                for (int i21 = 0; i21 < getLength(this.bB); i21++) {
                    this.bB[i21] = afilestream.readInt();
                }
                for (int i22 = 0; i22 < getLength(this.bC); i22++) {
                    this.bC[i22] = afilestream.readInt();
                }
                for (int i23 = 0; i23 < getLength(this.bD); i23++) {
                    this.bD[i23] = afilestream.readInt();
                }
                for (int i24 = 0; i24 < getLength(this.bE); i24++) {
                    this.bE[i24] = afilestream.readInt();
                }
                if (version >= 1) {
                    for (int i25 = 0; i25 < getLength(this.bF); i25++) {
                        this.bF[i25] = afilestream.readBoolean();
                    }
                }
            }
            afilestream.close();
        }
        if (ad()) {
            return true;
        }
        this.D = 0;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aSave() {
        aFileStream afilestream = new aFileStream();
        if (afilestream.openWrite("SAVE_DATA")) {
            afilestream.enableMD5();
            afilestream.writeInt(1);
            afilestream.writeBoolean(aSound.getInstance().isMutedBGM());
            afilestream.writeBoolean(aSound.getInstance().isMutedSE());
            afilestream.writeInt(this.catfood);
            afilestream.writeInt(this.currentEnergy);
            for (int i = 0; i < getLength(this.years); i++) {
                afilestream.writeInt(this.years[i]);
            }
            for (int i2 = 0; i2 < getLength(this.months); i2++) {
                afilestream.writeInt(this.months[i2]);
            }
            for (int i3 = 0; i3 < getLength(this.days); i3++) {
                afilestream.writeInt(this.days[i3]);
            }
            afilestream.writeDouble(this.aQ);
            afilestream.writeInt(this.hour);
            afilestream.writeInt(this.minute);
            afilestream.writeInt(this.second);
            afilestream.writeInt(this.aU);
            afilestream.writeInt(this.aV);
            afilestream.writeInt(this.aW);
            afilestream.writeInt(this.aX);
            afilestream.writeInt(this.aY);
            afilestream.writeInt(this.aZ);
            afilestream.writeInt(this.ba);
            afilestream.writeInt(this.bb);
            for (int i4 = 0; i4 < getLength(this.bc); i4++) {
                afilestream.writeInt(this.bc[i4]);
            }
            afilestream.writeInt(this.bd);
            afilestream.writeInt(this.be);
            afilestream.writeInt(this.bf);
            afilestream.writeBoolean(this.u);
            afilestream.writeInt(this.bg);
            afilestream.writeInt(this.bh);
            afilestream.writeInt(this.bi);
            afilestream.writeInt(this.bj);
            for (int i5 = 0; i5 < getLength(this.slotCatIDs); i5++) {
                afilestream.writeInt(this.slotCatIDs[i5]);
            }
            afilestream.writeInt(this.bl);
            for (int i6 = 0; i6 < getLength(this.bm); i6++) {
                afilestream.writeInt(this.bm[i6]);
            }
            afilestream.writeInt(this.bn);
            afilestream.writeInt(this.bo);
            for (int i7 = 0; i7 < getLength(this.bp); i7++) {
                afilestream.writeInt(this.bp[i7]);
            }
            for (int i8 = 0; i8 < getLength(this.bq); i8++) {
                afilestream.writeInt(this.bq[i8]);
            }
            for (int i9 = 0; i9 < getLength(this.br); i9++) {
                for (int i10 = 0; i10 < getLength(this.br[i9]); i10++) {
                    afilestream.writeInt(this.br[i9][i10]);
                }
            }
            for (int i11 = 0; i11 < getLength(this.bs); i11++) {
                for (int i12 = 0; i12 < getLength(this.bs[i11]); i12++) {
                    afilestream.writeInt(this.bs[i11][i12]);
                }
            }
            for (int i13 = 0; i13 < getLength(this.bt); i13++) {
                afilestream.writeInt(this.bt[i13]);
            }
            for (int i14 = 0; i14 < getLength(this.bu); i14++) {
                afilestream.writeInt(this.bu[i14]);
            }
            for (int i15 = 0; i15 < getLength(this.bv); i15++) {
                afilestream.writeInt(this.bv[i15]);
            }
            for (int i16 = 0; i16 < getLength(this.bw); i16++) {
                afilestream.writeInt(this.bw[i16]);
            }
            for (int i17 = 0; i17 < getLength(this.bx); i17++) {
                afilestream.writeInt(this.bx[i17]);
            }
            for (int i18 = 0; i18 < getLength(this.by); i18++) {
                afilestream.writeInt(this.by[i18]);
            }
            for (int i19 = 0; i19 < getLength(this.bz); i19++) {
                afilestream.writeInt(this.bz[i19]);
            }
            for (int i20 = 0; i20 < getLength(this.bA); i20++) {
                afilestream.writeInt(this.bA[i20]);
            }
            for (int i21 = 0; i21 < getLength(this.bB); i21++) {
                afilestream.writeInt(this.bB[i21]);
            }
            for (int i22 = 0; i22 < getLength(this.bC); i22++) {
                afilestream.writeInt(this.bC[i22]);
            }
            for (int i23 = 0; i23 < getLength(this.bD); i23++) {
                afilestream.writeInt(this.bD[i23]);
            }
            for (int i24 = 0; i24 < getLength(this.bE); i24++) {
                afilestream.writeInt(this.bE[i24]);
            }
            for (int i25 = 0; i25 < getLength(this.bF); i25++) {
                afilestream.writeBoolean(this.bF[i25]);
            }
            afilestream.close();
        }
        ae();
    }

    boolean ad() {
        aFileStream afilestream = new aFileStream();
        if (afilestream.openRead("SAVE_DATA2")) {
            afilestream.enableMD5();
            if (!afilestream.verifyMD5()) {
                setScene(4);
                this.D = 0;
                afilestream.close();
                return false;
            }
            if (afilestream.readInt() == 0) {
                for (int i = 0; i < getLength(this.ht); i++) {
                    this.ht[i] = afilestream.readInt();
                }
                for (int i2 = 0; i2 < getLength(this.hu); i2++) {
                    this.hu[i2] = afilestream.readInt();
                }
                this.hv = afilestream.readInt();
                for (int i3 = 0; i3 < getLength(this.hw); i3++) {
                    this.hw[i3] = afilestream.readInt();
                }
                for (int i4 = 0; i4 < getLength(this.hx); i4++) {
                    this.hx[i4] = afilestream.readInt();
                }
                this.hy = afilestream.readInt();
                this.hz = afilestream.readInt();
                this.hA = afilestream.readInt();
                this.hB = afilestream.readInt();
                for (int i5 = 0; i5 < getLength(this.hC); i5++) {
                    this.hC[i5] = afilestream.readInt();
                }
                for (int i6 = 0; i6 < getLength(this.hD); i6++) {
                    this.hD[i6] = afilestream.readInt();
                }
                for (int i7 = 0; i7 < getLength(this.hE); i7++) {
                    this.hE[i7] = afilestream.readInt();
                }
                this.hF = afilestream.readInt();
                this.hG = afilestream.readInt();
            }
            afilestream.close();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ae() {
        aFileStream afilestream = new aFileStream();
        if (afilestream.openWrite("SAVE_DATA2")) {
            afilestream.enableMD5();
            afilestream.writeInt(0);
            for (int i = 0; i < getLength(this.ht); i++) {
                afilestream.writeInt(this.ht[i]);
            }
            for (int i2 = 0; i2 < getLength(this.hu); i2++) {
                afilestream.writeInt(this.hu[i2]);
            }
            afilestream.writeInt(this.hv);
            for (int i3 = 0; i3 < getLength(this.hw); i3++) {
                afilestream.writeInt(this.hw[i3]);
            }
            for (int i4 = 0; i4 < getLength(this.hx); i4++) {
                afilestream.writeInt(this.hx[i4]);
            }
            afilestream.writeInt(this.hy);
            afilestream.writeInt(this.hz);
            afilestream.writeInt(this.hA);
            afilestream.writeInt(this.hB);
            for (int i5 = 0; i5 < getLength(this.hC); i5++) {
                afilestream.writeInt(this.hC[i5]);
            }
            for (int i6 = 0; i6 < getLength(this.hD); i6++) {
                afilestream.writeInt(this.hD[i6]);
            }
            for (int i7 = 0; i7 < getLength(this.hE); i7++) {
                afilestream.writeInt(this.hE[i7]);
            }
            afilestream.writeInt(this.hF);
            afilestream.writeInt(this.hG);
            afilestream.close();
        }
    }

    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i, int i2, int i3, int i4) {
        return getCurrentXTouch() >= i && getCurrentXTouch() <= i3 + i && getCurrentYTouch() >= i2 && getCurrentYTouch() <= i4 + i2;
    }

    public void onResume() {
    }

    public void d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInsideCircle(int x, int y, int radius, int centreX, int centreY, int tolerance) {
        return ((x - centreX) * (x - centreX)) + ((y - centreY) * (y - centreY)) <= (radius + tolerance) * (radius + tolerance);
    }

    public void onProcess() {
    }

    public void screenTransition() {
    }

    void loadStageStats(int i) {
        if (!aString.isEqual(aAssetTextStream.d(String.format("stage%02d.csv", Integer.valueOf(i))), new String[]{"345b93370a81c18c3e1ca485064c8105", "7eeb12db6cf61e975062554f2c2d5c47", "fbae56844862035ecac67dd840b163fe", "94519b25bf5f93710325a5f8ab0f0ec4", "3d0ca160ebad6570d113a7885259daf4", "385e19a0e69d5f11fc54e768f3de1d59", "386921150764335e057e770852656c60", "f72af96ebba61a4b5bb95b93c55c797c", "7a3eab28e914ddb5c5a7f7340d766079", "b8f2d0edc156bbb3eb184fd14e5cce52", "d88a1db9e289697124393a5361b410ca", "adc6425e4106bff2184ad1942da28765", "1aeddcbb0d534bb231ffdf60862d17f4", "54993a929642e6382ab479a7e6f96c8c", "0756993b94f5dcc37b5addaf3b3ae71f", "312987a22171ab38999b36dda3e43b37", "fd4267af7dd24ca6e33fea3eaebf3a3f", "d9fabf55cea824cf5cce990b55de3be7", "845beeee5c9adbdc21339ca2e8f98281", "cd0000479b0b70c6027886745abb4fe0", "91a863f669ecd4be900532e9fe4cde0d", "e7b42c80357526613831951245fdafdb", "e89c4c39c161560737dd467a9cce9e5e", "3119fd83734e199eade1372402c6d4b5", "e0c58745696c32a8ec03932d38c0e10c", "8213572ce0b7f006155528589a075ca4", "69595179dbf85559b386b69b668340f9", "5a5f04742ef5406fa1282068dd146d42", "53df5ec4d09b4797efcbbcf68f5fcc55", "941e6851b52e48c2b19c96fcb567e55b", "08f0eb6b5a35035569037d5a34eec92f", "efd0471c05bb8c352b45653737a0342c", "d74ced49669c5c93cd1528daf373df6f", "bdae74443acdb58b3d213c19d1994279", "420469b948ad3134999ddba7d11d0f72", "c217325fb3c462ff500f35d5dba8d6dd", "1f923af4c242703437a78ae6fed900a2", "bab2c03bdff10ca11d29317ee08f35e2", "30a1e1225661123fcdcfd2c080618bab", "0e2afa9fea9646dbc070408535687932", "8bc82c0f20d610d0dcb3730d706944e3", "8233d1ede2ca26dfb53fa31feb6c9356", "3dffa6ddaaadd924152cd2c9a101ad73", "1e43ffe66844c8abf330e59c2e3c5351", "727678b0f67daf70c867feab8b6445a2", "a04cc9b171fe4edeac9377f5605d112d", "a440aa434573dd1479e2fbca9b7a4446", "4f1b17f0b6047839cea04800097db840", "3f2cb30ef9b6c82fa5c083febf35d110", "b16cf2453de33589d886e1b39de8635e", "aaa4e070b70806c33d01fe218426a0a3"}[i])) {
            this.D = 0;
            setScene(4);
            return;
        }
        aResourceFileStream aresourcefilestream = new aResourceFileStream();
        aresourcefilestream.openRead(String.format("stage%02d.csv", Integer.valueOf(i)));
        aresourcefilestream.readLine();
        for (int i2 = 0; i2 < getLength(this.bV); i2++) {
            this.bV[i2] = aresourcefilestream.getInt(i2);
        }
        for (int i3 = 0; i3 < getLength(this.stageStats); i3++) {
            aresourcefilestream.readLine();
            for (int i4 = 0; i4 < getLength(this.stageStats[i3]); i4++) {
                this.stageStats[i3][i4] = aresourcefilestream.getInt(i4);
            }
        }
        aresourcefilestream.close();
        this.bV[0] = this.bV[0] * 4;
        for (int i5 = 0; i5 < getLength(this.stageStats); i5++) {
            for (int i6 = 0; i6 < getLength(this.stageStats[i5]); i6++) {
                if (i6 == 2 || i6 == 3 || i6 == 4) {
                    int[] iArr = this.stageStats[i5];
                    iArr[i6] = iArr[i6] * 2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void setScene(int i) {
        this.scene = i;
        setScene2(i);
        switch (getScene()) {
            case 4:
                MyUtility.getInstance().addButton(MyUtility.getString("err_txt"));
                aSound.getInstance().stop(-1);
                return;
            case 98:
                //aAd.b().f();
                for (int i2 = 0; i2 < getLength(this.gp); i2++) {
                    this.gp[i2] = false;
                }
                for (int i3 = 0; i3 < getLength(this.fw); i3++) {
                    for (int i4 = 0; i4 < getLength(this.fw[i3]); i4++) {
                        this.fw[i3][i4] = 0;
                    }
                }
                for (int i5 = 0; i5 < getLength(this.textTextures); i5++) {
                    if (this.textTextures[i5].isLoaded()) {
                        this.textTextures[i5].reset();
                    }
                }
                for (int i6 = 0; i6 < getLength(this.openingText); i6++) {
                    if (!this.textTextures[i6].isLoaded()) {
                        if (this.regionState == 0) {
                            if (i6 == 0) {
                                this.textTextures[i6].drawText(String.format("%d%s", Integer.valueOf(this.year), this.openingText[i6]), "FONT_SYSTEM_BOLD", 30, 1);
                            } else {
                                this.textTextures[i6].drawText(this.openingText[i6], "FONT_SYSTEM_BOLD", 30, 1);
                            }
                        } else if (this.regionState == 1) {
                            if (i6 == 2) {
                                this.textTextures[i6].drawText(String.format("%s", String.format(this.openingText[i6], Integer.valueOf(this.year))), "FONT_SYSTEM_BOLD", 30, 1);
                            } else {
                                this.textTextures[i6].drawText(this.openingText[i6], "FONT_SYSTEM_BOLD", 30, 1);
                            }
                        }
                    }
                }
                for (int i7 = 0; i7 < getLength(this.dw); i7++) {
                    this.dw[i7] = 0;
                }
                this.dy = 0;
                this.dz = 0;
                this.dA = 0;
                for (int i8 = 0; i8 < 50; i8++) {
                    for (int i9 = 0; i9 < 8; i9++) {
                        if (i9 == 0) {
                            this.cg[i8][0][i9] = ((i8 * 48) + (aMath.rand(48) % getWidth())) * 100;
                            this.cg[i8][1][i9] = (aMath.rand(50) + 640) * 100;
                        } else {
                            this.cg[i8][0][i9] = this.cg[i8][0][0];
                            this.cg[i8][1][i9] = this.cg[i8][1][0];
                        }
                    }
                    this.ci[i8][0] = 0;
                    this.ci[i8][1] = (aMath.rand(50) + 3) * 10;
                    this.ci[i8][2] = (aMath.rand(15) + 3) * 100;
                    this.ci[i8][3] = aMath.rand(8) + 1;
                }
                for (int i10 = 0; i10 < getLength(this.fw); i10++) {
                    for (int i11 = 0; i11 < getLength(this.fw[i10]); i11++) {
                        this.fw[i10][i11] = 0;
                    }
                }
                this.fw[0][0] = this.w + 788;
                this.fw[0][1] = this.eZ + 556;
                this.fw[0][2] = 168;
                this.fw[0][3] = 88;
                this.fF = -1;
                this.fD = 0;
                for (int i12 = 0; i12 < getLength(this.fQ); i12++) {
                    this.fQ[i12] = 0;
                }
                for (int i13 = 0; i13 < getLength(this.fx); i13++) {
                    this.fx[i13] = 0;
                }
                for (int i14 = 0; i14 < getLength(this.uiTextures); i14++) {
                    if (this.uiTextures[i14].isLoaded()) {
                        this.uiTextures[i14].reset();
                    }
                }
                loadTextures2();
                if (!this.openingTexture[0].isLoaded()) {
                    this.openingTexture[0].reset();
                }
                if (!this.openingTexture[0].isLoaded()) {
                    this.openingTexture[0].load(MyUtility.getString(String.format("img%03d.png", 13)), MyUtility.getString(String.format("000_img%03d.imgcut", 13)));
                }
                this.openingModel[0].load(MyUtility.getString(String.format("opening.mamodel", new Object[0])));
                this.openingAnim[0].load(MyUtility.getString(String.format("opening.maanim", new Object[0])));
                this.openingModel[0].setTextures(this.openingTexture);
                this.openingModel[0].setAction();
                if (!this.uiTextures[2].isLoaded()) {
                    this.uiTextures[2].reset();
                }
                if (!this.uiTextures[2].isLoaded()) {
                    this.uiTextures[2].load(MyUtility.getString(String.format("img%03d.png", 6)), MyUtility.getString(String.format("img%03d.imgcut", 6)));
                }
                this.zoomLevel = 10000;
                aSound.getInstance().stop(-1);
                aSound.getInstance().play(0);
                return;
            case 99:
                //aAd.b().f();
                for (int i15 = 0; i15 < getLength(this.gp); i15++) {
                    this.gp[i15] = false;
                }
                for (int i16 = 0; i16 < getLength(this.textTextures); i16++) {
                    if (this.textTextures[i16].isLoaded()) {
                        this.textTextures[i16].reset();
                    }
                }
                for (int i17 = 0; i17 < getLength(this.endingText); i17++) {
                    if (!this.textTextures[i17].isLoaded()) {
                        this.textTextures[i17].drawText(this.endingText[i17], "FONT_SYSTEM_BOLD", 30, 1);
                    }
                }
                for (int i18 = 0; i18 < getLength(this.fQ); i18++) {
                    this.fQ[i18] = 0;
                }
                for (int i19 = 0; i19 < getLength(this.fx); i19++) {
                    this.fx[i19] = 0;
                }
                for (int i20 = 0; i20 < getLength(this.eE); i20++) {
                    this.eE[i20] = false;
                }
                for (int i21 = 0; i21 < 50; i21++) {
                    for (int i22 = 0; i22 < 8; i22++) {
                        if (i22 == 0) {
                            this.cg[i21][0][i22] = ((i21 * 48) + (aMath.rand(48) % getWidth())) * 100;
                            this.cg[i21][1][i22] = (aMath.rand(50) + 640) * 100;
                        } else {
                            this.cg[i21][0][i22] = this.cg[i21][0][0];
                            this.cg[i21][1][i22] = this.cg[i21][1][0];
                        }
                    }
                    this.ci[i21][0] = 0;
                    this.ci[i21][1] = (aMath.rand(50) + 3) * 10;
                    this.ci[i21][2] = (aMath.rand(15) + 3) * 100;
                    this.ci[i21][3] = aMath.rand(8) + 1;
                }
                for (int i23 = 0; i23 < getLength(this.uiTextures); i23++) {
                    if (this.uiTextures[i23].isLoaded()) {
                        this.uiTextures[i23].reset();
                    }
                }
                loadTextures2();
                if (this.uiTextures[0].isLoaded()) {
                    this.uiTextures[0].reset();
                }
                if (!this.uiTextures[0].isLoaded()) {
                    this.uiTextures[0].load(MyUtility.getString(String.format("img%03d.png", 35)), MyUtility.getString(String.format("img%03d.imgcut", 35)));
                }
                if (this.uiTextures[1].isLoaded()) {
                    this.uiTextures[1].reset();
                }
                if (!this.uiTextures[1].isLoaded()) {
                    this.uiTextures[1].load(MyUtility.getString(String.format("img%03d.png", 7)), MyUtility.getString(String.format("img%03d.imgcut", 7)));
                }
                if (this.uiTextures[2].isLoaded()) {
                    this.uiTextures[2].reset();
                }
                if (!this.uiTextures[2].isLoaded()) {
                    this.uiTextures[2].load(MyUtility.getString(String.format("img%03d.png", 6)), MyUtility.getString(String.format("img%03d.imgcut", 6)));
                }
                if (this.uiTextures[3].isLoaded()) {
                    this.uiTextures[3].reset();
                }
                if (!this.uiTextures[3].isLoaded()) {
                    this.uiTextures[3].load(MyUtility.getString(String.format("img%03d.png", 36)), MyUtility.getString(String.format("img%03d.imgcut", 36)));
                }
                this.dE = 0;
                this.dF = 0;
                this.dG = 0;
                this.fF = -1;
                this.fD = 0;
                this.fw[0][0] = this.w + 788;
                this.fw[0][1] = this.eZ + 556;
                this.fw[0][2] = 168;
                this.fw[0][3] = 88;
                this.zoomLevel = 10000;
                aSound.getInstance().stop(-1);
                aSound.getInstance().play(5);
                return;
            case 100:
                for (int i24 = 0; i24 < getLength(this.gp); i24++) {
                    this.gp[i24] = false;
                }
                for (int i25 = 0; i25 < getLength(this.unitBattleStats); i25++) {
                    for (int i26 = 0; i26 < getLength(this.unitBattleStats[i25]); i26++) {
                        for (int i27 = 0; i27 < getLength(this.unitBattleStats[i25][i26]); i27++) {
                            this.unitBattleStats[i25][i26][i27] = 0;
                        }
                    }
                }
                for (int i28 = 0; i28 < getLength(this.fw); i28++) {
                    for (int i29 = 0; i29 < getLength(this.fw[i28]); i29++) {
                        this.fw[i28][i29] = 0;
                    }
                }
                this.zoomLevel = 10000;
                return;
            case 300:
                V();
                return;
            default:
                return;
        }
    }

    void setScene2(int i) {
        this.scene2 = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(aTextureRenderer atexturerenderer) {
        int i;
        int i2 = 0;
        int i3;
        int i4;
        int i5;
        atexturerenderer.drawScaledImagef(this.uiTextures[6], 0, 42, 0);
        atexturerenderer.setColor(0, 0, 0);
        if (this.eE[2]) {
            i = this.eh[0];
            if (i >= 63) {
                i = 63;
            }
        } else {
            i = 0;
        }
        if (this.dY == 0) {
            atexturerenderer.setAlpha(63 - i);
            atexturerenderer.drawRectangle(0, 367, getWidth(), 190);
            atexturerenderer.drawScaledImagef(this.uiTextures[6], 0 - this.eh[0], 79, 1);
            atexturerenderer.drawScaledImagef(this.uiTextures[6], 0 - this.eh[0], 66, 2);
            atexturerenderer.drawScaledImagef(this.uiTextures[6], 0 - this.eh[0], 352, 3);
            atexturerenderer.drawScaledImagef(this.uiTextures[6], this.eh[0] + 748, 85, 4);
            atexturerenderer.drawScaledImagef(this.uiTextures[6], this.eh[0] + 733, 60, 5);
            atexturerenderer.drawScaledImagef(this.uiTextures[6], this.eh[0] + 748, 277, 6);
            atexturerenderer.drawScaledImagef(this.uiTextures[6], this.eh[0] + 733, 252, 7);
            if (!this.eE[2]) {
                atexturerenderer.drawScaledImage(this.uiTextures[6], 633 - (dv[this.fx[0]] / 2), 494 - (dv[this.fx[0]] / 2), dv[this.fx[0]] + 304, dv[this.fx[0]] + 74, 21);
                atexturerenderer.drawScaledImage(this.uiTextures[6], 671 - (dv[this.fx[0]] / 2), 500 - (dv[this.fx[0]] / 2), dv[this.fx[0]] + 231, dv[this.fx[0]] + 62, 22);
            }
            int i6 = 0;
            for (int i7 = 0; i7 < 10; i7++) {
                if (this.slotCatIDs[i7] == -1) {
                    i5 = i6;
                } else {
                    atexturerenderer.drawScaledImage(this.uniTextures[i7], (((i7 % 5) * 121) + 111) - this.eh[0], ((i7 / 5) * 119) + 134, 110, 85, 0);
                    if (this.bv[this.slotCatIDs[i7] - 2] + 1 < this.bi) {
                        i5 = this.bv[this.slotCatIDs[i7] - 2] + 1;
                        int i8 = 0;
                        do {
                            atexturerenderer.drawScaledImagef(this.uiTextures[6], ((206 - (i8 * 12)) + ((i7 % 5) * 121)) - this.eh[0], ((i7 / 5) * 119) + 109, (i5 % 10) + 8);
                            i5 /= 10;
                            i8++;
                        } while (i5 > 0);
                    } else {
                        atexturerenderer.drawScaledImagef(this.uiTextures[6], (((i7 % 5) * 121) + 176) - this.eh[0], ((i7 / 5) * 119) + 109, 18);
                        i5 = i6;
                    }
                }
                i6 = i5;
            }
            int i9 = 0;
            int i10 = i6;
            for (int i11 = 0; i11 < 9; i11++) {
                if (i11 == 0) {
                    i9 = 108;
                    i10 = this.bx[0] + 1;
                    this.gameStats1[0] = this.bi;
                } else if (i11 == 1) {
                    i9 = 140;
                    i10 = this.bx[2] + 1;
                    this.gameStats1[0] = 10;
                } else if (i11 == 2) {
                    i9 = 172;
                    i10 = this.bx[3] + 1;
                    this.gameStats1[0] = this.bi;
                } else if (i11 == 3) {
                    i9 = 298;
                    i10 = this.bx[4] + 1;
                    this.gameStats1[0] = this.bi;
                } else if (i11 == 4) {
                    i9 = 330;
                    i10 = this.bx[5] + 1;
                    this.gameStats1[0] = this.bi;
                } else if (i11 == 5) {
                    i9 = 204;
                    i10 = this.bx[6] + 1;
                    this.gameStats1[0] = this.bi;
                } else if (i11 == 6) {
                    i9 = 362;
                    i10 = this.bx[7] + 1;
                    this.gameStats1[0] = this.bi;
                } else if (i11 == 7) {
                    i9 = 394;
                    i10 = this.bx[8] + 1;
                    this.gameStats1[0] = this.bi;
                } else if (i11 == 8) {
                    i9 = 426;
                    i10 = this.bx[9] + 1;
                    this.gameStats1[0] = this.bi;
                }
                if (i10 < this.gameStats1[0]) {
                    int i12 = i10;
                    int i13 = 0;
                    do {
                        atexturerenderer.drawScaledImagef(this.uiTextures[6], (919 - (i13 * 12)) + this.eh[0], i9, (i12 % 10) + 8);
                        i12 /= 10;
                        i13++;
                    } while (i12 > 0);
                    i10 = i12;
                } else {
                    atexturerenderer.drawScaledImagef(this.uiTextures[6], this.eh[0] + 889, i9, 18);
                }
            }
        }
        if (this.eE[2] || this.dY >= 1) {
            atexturerenderer.setColor(0, 0, 0);
            atexturerenderer.setAlpha(63);
            atexturerenderer.drawRectangle(this.eh[1] + 0, 487, getWidth(), 56);
            atexturerenderer.drawScaledImagef(this.uiTextures[7], 0 - this.eh[1], 492.0f, 224.0f, 45.0f, cm[this.dH]);
        }
        atexturerenderer.drawScaledImage(this.settingsMenuTexture[0], (0 - this.fP) - 88, 0, 572, 637, 0);
        atexturerenderer.drawScaledImage(this.settingsMenuTexture[0], (this.fP + 572) - 88, 0, 572, 637, 1);
        if (this.dY == 0) {
            if (this.fR[0] == 0) {
                i2 = cu[this.fQ[0]];
            } else if (this.fR[0] == 1) {
                i2 = cv[this.fQ[0]];
            } else {
                int i14 = this.fR[0];
            }
            if (this.dY != 1) {
                atexturerenderer.drawScaledImage(this.uiTextures[1], 659, (this.fQ[0] == 2 || this.fQ[0] == 3 || this.fQ[0] == 6 || this.fQ[0] == 7 || this.fQ[0] == 10 || this.fQ[0] == 11 || this.fQ[0] == 14 || this.fQ[0] == 15 || this.fQ[0] == 18 || this.fQ[0] == 19) ? 308 : 312, 355, 355, 0);
                if (this.fQ[0] >= 2) {
                    if (this.fQ[0] - 2 == 0) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], -28, -1, 504, 504, 0);
                    } else if (this.fQ[0] - 2 == 1) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 35, 62, 378, 378, 0);
                    } else if (this.fQ[0] - 2 == 2) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 98, 125, 252, 252, 0);
                    } else if (this.fQ[0] - 2 >= 3) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 161, 188, 126, 126, 0);
                    }
                }
                if (this.fQ[0] >= 6) {
                    if (this.fQ[0] - 6 == 0) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 100, -1, 504, 504, 1);
                    } else if (this.fQ[0] - 6 == 1) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 163, 62, 378, 378, 1);
                    } else if (this.fQ[0] - 6 == 2) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 226, 125, 252, 252, 1);
                    } else if (this.fQ[0] - 6 >= 3) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 289, 188, 126, 126, 1);
                    }
                }
                if (this.fQ[0] >= 10) {
                    if (this.fQ[0] - 2 == 0) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 228, -1, 504, 504, 2);
                    } else if (this.fQ[0] - 10 == 1) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 291, 62, 378, 378, 2);
                    } else if (this.fQ[0] - 10 == 2) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 354, 125, 252, 252, 2);
                    } else if (this.fQ[0] - 10 >= 3) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 417, 188, 126, 126, 2);
                    }
                }
                if (this.fQ[0] >= 14) {
                    if (this.fQ[0] - 14 == 0) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 356, -1, 504, 504, 3);
                    } else if (this.fQ[0] - 14 == 1) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 419, 62, 378, 378, 3);
                    } else if (this.fQ[0] - 14 == 2) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 482, 125, 252, 252, 3);
                    } else if (this.fQ[0] - 14 >= 3) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 545, 188, 126, 126, 3);
                    }
                }
                if (this.fQ[0] >= 18) {
                    if (this.fQ[0] - 18 == 0) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 484, -1, 504, 504, 4);
                    } else if (this.fQ[0] - 18 == 1) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 547, 62, 378, 378, 4);
                    } else if (this.fQ[0] - 18 == 2) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 610, 125, 252, 252, 4);
                    } else if (this.fQ[0] - 18 >= 3) {
                        atexturerenderer.drawScaledImage(this.uiTextures[8], 673, 188, 126, 126, 4);
                    }
                }
            } else {
                atexturerenderer.drawScaledImage(this.uiTextures[1], 659, i2, 355, 355, 0);
                if (this.fQ[1] == 1 || this.fQ[1] == 2 || this.fQ[1] == 4 || this.fQ[1] == 5) {
                    atexturerenderer.drawScaledImage(this.uiTextures[1], 659, i2, 355, 191, 2);
                }
            }
            atexturerenderer.drawScaledImagef(this.uiTextures[2], 0, -42, 10);
            atexturerenderer.drawScaledImagef(this.uiTextures[2], 0, 638, 10);
            atexturerenderer.drawScaledImagef(this.uiTextures[2], 0, 0, 0);
            atexturerenderer.setOrientation(2);
            atexturerenderer.drawScaledImagef(this.uiTextures[2], 0, 585, 0);
            atexturerenderer.setOrientation(0);
            if (this.gm[0] < 297) {
                atexturerenderer.drawScaledImagef(this.uiTextures[2], 8 - this.gm[0], 3, 6);
            }
            if (this.gm[1] < 297) {
                atexturerenderer.drawScaledImagef(this.uiTextures[2], (8 - this.gm[1]) - this.eh[0], 3, 7);
            }
            atexturerenderer.drawScaledImage(this.uiTextures[0], this.fw[5][0] - (dv[this.fx[5]] / 2), this.ei[0] + (this.fw[5][1] - (dv[this.fx[5]] / 2)), dv[this.fx[5]] + this.fw[5][2], dv[this.fx[5]] + this.fw[5][3], 9);
            atexturerenderer.drawScaledImage(this.uiTextures[0], (this.fw[5][0] + 4) - (dv[this.fx[5]] / 2), this.ei[0] + ((this.fw[5][1] + 17) - (dv[this.fx[5]] / 2)), dv[this.fx[5]] + 84, dv[this.fx[5]] + 60, 3);
            atexturerenderer.drawScaledImagef(this.uiTextures[5], this.eh[0] + 670, 0, 11);
            atexturerenderer.drawScaledImagef(this.uiTextures[5], this.eh[0] + 608, 7, 10);
            i3 = this.aY;
            i4 = 0;
            do {
                atexturerenderer.drawScaledImagef(this.uiTextures[5], (924 - (i4 * 29)) + this.eh[0], 6, i3 % 10);
                i3 /= 10;
                i4++;
            } while (i3 > 0);
        }
        i2 = 0;
        if (this.dY != 1) {
        }
        atexturerenderer.drawScaledImagef(this.uiTextures[2], 0, -42, 10);
        atexturerenderer.drawScaledImagef(this.uiTextures[2], 0, 638, 10);
        atexturerenderer.drawScaledImagef(this.uiTextures[2], 0, 0, 0);
        atexturerenderer.setOrientation(2);
        atexturerenderer.drawScaledImagef(this.uiTextures[2], 0, 585, 0);
        atexturerenderer.setOrientation(0);
        if (this.gm[0] < 297) {
        }
        if (this.gm[1] < 297) {
        }
        atexturerenderer.drawScaledImage(this.uiTextures[0], this.fw[5][0] - (dv[this.fx[5]] / 2), this.ei[0] + (this.fw[5][1] - (dv[this.fx[5]] / 2)), dv[this.fx[5]] + this.fw[5][2], dv[this.fx[5]] + this.fw[5][3], 9);
        atexturerenderer.drawScaledImage(this.uiTextures[0], (this.fw[5][0] + 4) - (dv[this.fx[5]] / 2), this.ei[0] + ((this.fw[5][1] + 17) - (dv[this.fx[5]] / 2)), dv[this.fx[5]] + 84, dv[this.fx[5]] + 60, 3);
        atexturerenderer.drawScaledImagef(this.uiTextures[5], this.eh[0] + 670, 0, 11);
        atexturerenderer.drawScaledImagef(this.uiTextures[5], this.eh[0] + 608, 7, 10);
        i3 = this.aY;
        i4 = 0;
        do {
            atexturerenderer.drawScaledImagef(this.uiTextures[5], (924 - (i4 * 29)) + this.eh[0], 6, i3 % 10);
            i3 /= 10;
            i4++;
        } while (i3 > 0);
    }
}
