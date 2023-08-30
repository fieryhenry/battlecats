package jp.co.ponos.battlecats;

import java.util.Calendar;

import jp.co.ponos.library.game.Model;
import jp.co.ponos.library.game.ModelAnimation;
import jp.co.ponos.library.game.Point;
import jp.co.ponos.library.game.SoundType;
import jp.co.ponos.library.game.TextureRenderer;
import jp.co.ponos.library.game.aMath;
import jp.co.ponos.library.game.Sound;
import jp.co.ponos.library.game.MyApplicationBase;
import jp.co.ponos.library.game.Texture;
import jp.co.ponos.library.game.AnimTransformer;
import jp.co.ponos.library.game.aString;
import jp.co.ponos.library.game.stream.AssetTextStream;
import jp.co.ponos.library.game.stream.FileStream;
import jp.co.ponos.library.game.AlertAppli;
import jp.co.ponos.library.score.MyUtility;

public class Game extends MyApplicationBase {
    static int[] X = new int[10];
    static int[] Y = new int[10];
    static int[] Z = new int[11];
    static int[] aB = new int[4];
    static int[] aa = new int[11];
    static int[] ab = new int[4];
    static int[][] ac = new int[10][10];
    static int[] initialSkillValues = new int[11];
    static int[] cA = new int[11];
    static int[] initialTreasureBonuses = new int[11];
    static int[] cC = new int[11];
    static int[][] ck = new int[48][4];
    static int[][] cl = new int[48][2];
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
    static int[][] cz = new int[11][7];
    static int[] ds = new int[24];
    static int[] dt = new int[23];
    static int[] du = new int[14];
    static int[] dv = new int[6];
    static int[] eO = new int[5];
    static int[] eT = new int[8];
    static int[] fM = new int[12];
    static int[] fN = new int[7];
    static int[] fO = new int[7];
    static int[] fb = new int[10];
    static int[][] fe = new int[49][3];
    static int hn = 2000;
    String errorText = "F99";
    static int[] l = new int[8];
    static int[] m = new int[8];
    AnimTransformer A = new AnimTransformer();
    AnimTransformer B = new AnimTransformer();
    MyScore C = new MyScore();
    int D;
    int currentXTouch;
    int touchX;
    int G;
    int previousXTouch;
    int currentYTouch;
    int touchY;
    int K;
    int previousYTouch;
    boolean pointerDownNow;
    boolean isPressEvent;
    boolean pointerDown;
    boolean pointerUp;
    boolean isReleaseEvent;
    boolean R;
    boolean backPressed;
    int scene;
    int scene2;
    int V;
    int W;
    Calendar calendar;
    ModelAnimation[][] aA = new ModelAnimation[4][2];
    Texture[] aC = new Texture[1];
    Model[] aD = new Model[2];
    ModelAnimation[][] aE = new ModelAnimation[2][3];
    Texture[] stampTextures = new Texture[2];
    Model[] stampModels = new Model[2];
    ModelAnimation[] stampAnims = new ModelAnimation[2];
    Texture[] aI = new Texture[2];
    Model aJ;
    ModelAnimation[] aK = new ModelAnimation[2];
    int catfood;
    int currentEnergy;
    int[] years = new int[2];
    int[] months = new int[2];
    int[] days = new int[2];
    double aQ;
    int hour;
    int minute;
    int second;
    int aU;
    int aV;
    int aW;
    int aX;
    int xp;
    int aZ;
    Texture[] uiTextures = new Texture[30];
    Texture[] af = new Texture[4];
    Texture[] textTextures = new Texture[100];
    Texture[] ah = new Texture[15];
    Texture[] ai = new Texture[8];
    Texture[] aj = new Texture[1];
    Texture[] ak = new Texture[11];
    Texture al;
    Texture am;
    Texture an;
    Texture[] ao = new Texture[1];
    Model[] ap = new Model[1];
    ModelAnimation[] aq = new ModelAnimation[1];
    Texture[] ar = new Texture[26];
    Texture[] as = new Texture[26];
    Model[] at = new Model[10];
    ModelAnimation[][] au = new ModelAnimation[10][4];
    Texture[] av = new Texture[30];
    Model[] aw = new Model[10];
    ModelAnimation[][] ax = new ModelAnimation[10][4];
    Texture[] ay = new Texture[1];
    Model[][] az = new Model[4][2];
    boolean b;
    int[] battleItems = new int[6];
    int[] bB = new int[10];
    int[] bC = new int[20];
    int[] bD = new int[1];
    int[] bE = new int[1];
    boolean[] bF = new boolean[11];
    int[] bG = new int[48];
    int[][] bH = new int[201][3];
    int bI;
    int[][] bJ = new int[26][16];
    int[] bK = new int[26];
    int[] bL = new int[26];
    int[] battleStats = new int[34];
    int[] bN = new int[3];
    int[][] treasureMultValues = new int[10][11];
    int bP;
    int[][] bQ = new int[20][2];
    int[][][] deployedUnits = new int[2][51][38];
    int[][][] bS = new int[2][56][3];
    int[][] bT = new int[6][5];
    int[] bU = new int[2];
    int[] bV = new int[6];
    int[][] bW = new int[20][8];
    int[][][] unitStats = new int[28][2][14];
    int[][] bY = new int[32][13];
    int[][] bZ = new int[52][2];
    int ba;
    int bb;
    int[] bc = new int[3];
    int bd;
    int be;
    int bf;
    int bg;
    int bh;
    int bi;
    int bj;
    int[] slotCatIDs = new int[10];
    int currentStamp;
    int[] stampClaimFlags = new int[30];
    int bn;
    int bo;
    int[] bp = new int[10];
    int[] bq = new int[10];
    int[][] br = new int[10][49];
    int[][] bs = new int[10][49];
    int[] bt = new int[30];
    int[] bu = new int[26];
    int[] bv = new int[26];
    int[] bw = new int[26];
    int[] baseSpecialSkillLevels = new int[11];
    int[] by = new int[5];
    int[] bz = new int[5];
    MyPresentRenderer c = new MyPresentRenderer();
    String[] warning1Text = new String[15];
    String[][] warning2Text = new String[18][4];
    String[] stageNamesText = new String[100];
    String[] treasure1Text = new String[49];
    String[] treasure2Text = new String[11];
    String[][] treasure3Text = new String[23][3];
    String[] openingText = new String[73];
    String[] endingText = new String[77];
    String[][] mainMenuWText = new String[10][5];
    String[][] mainMenuPText = new String[2][5];
    String[][] mainMenuUText = new String[5][5];
    String[][] mainMenuTText = new String[2][5];
    String[][] mainMenuBText = new String[4][5];
    String[][] enemyPictureBookText = new String[30][5];
    String[] enemyPictureBookQuestionText = new String[5];
    String[][] unitExplanationOffText = new String[2][4];
    String[][][] unitExplanationText = new String[26][2][4];
    String[] godExplanationText = new String[4];
    String[][] catExplanationText = new String[10][4];
    String[][] stageFirstMessageText = new String[3][4];
    String[] challengeModeText = new String[4];
    String[] pageNameText = new String[9];
    String[] firstLoseText = new String[2];
    int ca;
    int[] cb = new int[2];
    int[][] cc = new int[100][5];
    int[][] cd = new int[10][5];
    int[][] ce = new int[100][4];
    int[][][] cf = new int[100][2][8];
    int[][][] cg = new int[50][2][8];
    int[][][] ch = new int[50][2][8];
    int[][] ci = new int[50][4];
    int[] cj = new int[5];
    int ct;
    MyPresentHandler d = new MyPresentHandler();
    int dA;
    int[] dB = new int[4];
    int[] dC = new int[4];
    int[] dD = new int[4];
    int dE;
    int dF;
    int dG;
    int dH;
    int[] dI = new int[4];
    int[] dJ = new int[3];
    int[] dK = new int[3];
    int[] dL = new int[2];
    int[] dM = new int[200];
    int[] dN = new int[200];
    int[] dO = new int[200];
    int[] dP = new int[2];
    int dQ;
    int dR;
    int dS;
    int dT;
    int dU;
    boolean dV;
    int dW;
    int dX;
    int dY;
    int dZ;
    String[][][] loseText = new String[3][1][4];
    String[] optionText = new String[3];
    String[] itemNameText = new String[11];
    String[][] itemExplanationText = new String[11][3];
    String[][] mainMenuPopUpText = new String[8][4];
    String[][] tutorialText = new String[10][12];
    String[][] endingMessageText = new String[2][4];
    String[][] god1Text = new String[2][2];
    String[][] god2Text = new String[33][2];
    String[][] god3Text = new String[1][2];
    String[][] god4Text = new String[1][2];
    String godNameText;
    String[] godItemNameText = new String[4];
    String[][] godItemExplanationText = new String[4][2];
    String[][] popUpMessageText = new String[3][10];
    String[][] categoryExplanationText = new String[2][4];
    String[] stampMessageText = new String[20];
    String[][] giftMessageText = new String[2][4];
    int[] dw = new int[2];
    int dx;
    int dy;
    int dz;
    String e;
    int[][] eA = new int[4][5];
    int[][][] eB = new int[50][2][3];
    boolean eC;
    int[] eD = new int[7];
    boolean[] eE = new boolean[14];
    int[] eF = new int[26];
    int eG;
    int[] eH = new int[10];
    int[] eI = new int[2];
    int[][] eJ = new int[10][4];
    int[] eK = new int[10];
    int[] eL = new int[10];
    boolean[] eM = new boolean[10];
    int eN;
    int eP;
    int eQ;
    int eR;
    int eS;
    int[] eU = new int[10];
    int[] eV = new int[10];
    int[] rechargeTimes = new int[10];
    boolean eX;
    int pointerID;
    int eZ;
    int ea;
    boolean eb;
    int ec;
    int ed;
    boolean isSettingsOpen;
    boolean ef;
    int eg;
    int[] scrollOffset = new int[5];
    int[] ei = new int[3];
    int[] ej = new int[1];
    int[] ek = new int[3];
    int[] el = new int[1];
    int[] em = new int[4];
    int[] en = new int[4];
    int eo;
    float[] ep = new float[3];
    int[] eq = new int[50];
    int[] er = new int[50];
    int[] es = new int[50];
    boolean[] et = new boolean[50];
    int[] eu = new int[50];
    int[] ev = new int[50];
    int ew;
    boolean ex;
    int ey;
    int ez;
    String f;
    int[][] fA = new int[2][4];
    int[][] buttonCoordinatesSettings = new int[13][4];
    int[] buttonDelay = new int[13];
    int screen;
    int fE;
    int screenLoadState;
    int[] fG = new int[4];
    int[] fH = new int[3];
    int fI;
    int qouteIndex;
    int fK;
    int fL;
    int fP;
    int[] frameCounter = new int[11];
    int[] fR = new int[2];
    int[] fS = new int[6];
    boolean fT;
    int fU;
    int fV;
    int[] fW = new int[10];
    int fX;
    int fY;
    int fZ;
    int fa;
    int[] fc = new int[2];
    int[] fd = new int[2];
    int[] ff = new int[6];
    int[][] fg = new int[10][2];
    int fh;
    int fi;
    int[][] fj = new int[10][4];
    int[] fk = new int[11];
    int fl;
    int fm;
    boolean fn;
    int[] fo = new int[3];
    int[] fp = new int[10];
    int[] fq = new int[4];
    int fr;
    int[] fs = new int[3];
    int ft;
    int fu;
    int fv;
    int[][] buttonCoordinates1 = new int[17][4];
    int[] fx = new int[17];
    int[] fy = new int[10];
    int[] fz = new int[2];
    int menuType;
    int[] gA = new int[6];
    int[] gB = new int[5];
    int[] gC = new int[4];
    int[] gD = new int[4];
    int[] gE = new int[20];
    boolean[] gF = new boolean[2];
    int[] gG = new int[20];
    int gH;
    boolean gI;
    boolean gJ;
    int gK;
    boolean gL;
    int gM;
    boolean gN;
    boolean gO;
    int[] gP = new int[4];
    int gQ;
    int gR;
    int[] gS = new int[11];
    int[] gT = new int[11];
    boolean gU;
    int[] gV = new int[4];
    int gW;
    int[][] gX = new int[1][4];
    int[] gY = new int[6];
    int[] gZ = new int[1];
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
    int[][] gk = new int[2][3];
    int[][] gl = new int[2][8];
    int[] gm = new int[2];
    int[][] gn = new int[2][3];
    int[][] go = new int[60][2];
    boolean[] shouldPlayButtonSelect = new boolean[17];
    boolean[] gq = new boolean[15];
    boolean[] gr = new boolean[15];
    boolean[] gs = new boolean[2];
    boolean[] gt = new boolean[1];
    boolean gu;
    int[] gv = new int[3];
    int gw;
    int gx;
    int boxScale;
    int gz;
    boolean h;
    int hA;
    int hB;
    int[] hC = new int[4];
    int[] hD = new int[11];
    int[] hE = new int[4];
    int hF;
    int hG;
    int hH;
    boolean isScrolling;
    int[] hJ = new int[]{5, 5, 5, 5, 5, 1, 5, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 2, 2, 2, 2, 2, 2, 2, 2};
    boolean[] ha = new boolean[2];
    float[] hb = new float[3];
    int[] hc = new int[29];
    int[] hd = new int[2];
    int[] he = new int[3];
    int[] hf = new int[2];
    int[] hg = new int[2];
    int[] hh = new int[20];
    int[] hi = new int[20];
    int[][] hj = new int[10][4];
    int[] hk = new int[10];
    int hl;
    int[] catGodFlags = new int[4];
    int[][] ho = new int[31][2];
    int hp;
    int[] hq = new int[4];
    boolean hr;
    int hs;
    int[] ht = new int[2];
    int[] hu = new int[2];
    int hv;
    int[] hw = new int[3];
    int[] hx = new int[8];
    int hy;
    int hz;
    int i;
    boolean j;
    String[] k = new String[8];
    boolean n;
    boolean o;
    int versionCode;
    int q;
    AlertAppli r = new AlertAppli();
    AlertAppli s = new AlertAppli();
    boolean t;
    boolean u;
    boolean v;
    int excessWidth;
    Point x = new Point();
    Zoom zoom = new Zoom();
    int z;

    void setConstants() {
        fb = new int[]{159, 289, 419, 549, 679, 171, 301, 431, 561, 691};
        int[] var1 = new int[]{0, 0, 1, 1, 2, 2, 3, 3};
        eT = var1;
        var1 = new int[]{0, -125, -125, -75, -75, -25, -25, 0, 0, 25, 25, 75, 75, 125, 125, -50, -50, -25, -25, 25, 25, 50, 50, 0};
        co = var1;
        var1 = new int[12];
        var1[2] = -100;
        var1[3] = -100;
        var1[4] = -50;
        var1[5] = -50;
        var1[8] = 50;
        var1[9] = 50;
        var1[10] = 100;
        var1[11] = 100;
        cp = var1;
        var1 = new int[]{960, 960, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1, 0};
        cq = var1;
        cr = new int[]{-54, -54, -54, -54, -54, -54, -54, -54, -54, -24, 6, 36, 66, 96, 90, 87, 86, 85, 86, 87, 90, 96, 95, 94, 95, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96};
        cs = new int[]{-132, -94, -57, -20, 17, 54, 92, 129, 167, 204, 242, 235, 227, 224, 220, 219, 217, 216, 215, 216, 217, 218, 220, 223, 227, 234, 242, 241, 240, 239, 237, 238, 240, 241, 242, 242, 242, 242, 242, 242, 242, 242, 242, 242};
        cu = new int[]{640, 640, 640, 640, 640, 532, 492, 384, 276, 274, 272, 274, 276, 298, 320};
        cv = new int[]{312, 314, 316, 316, 316, 318, 320, 320, 320, 320, 320, 320, 320, 320, 320, 316, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312, 312};
        fM = new int[]{1, 6, 12, 32, 52, 92, 132, 192, 252, 368, 480, 2000};
        var1 = new int[]{72, 40, 8, 4, 2, 1, 0};
        fN = var1;
        var1 = new int[]{104, 40, 8, 4, 2, 1, 0};
        fO = var1;
        var1 = new int[]{3270, 589, 521, 493};
        int[] var2 = new int[]{2766, 1165, 205, 193};
        int[] var3 = new int[]{2481, 1614, 123, 195};
        int[] var4 = new int[]{2495, 1957, 206, 161};
        int[] var5 = new int[]{2399, 2167, 133, 170};
        int[] var6 = new int[]{2325, 2065, 106, 129};
        int[] var7 = new int[]{2194, 2086, 142, 145};
        int[] var8 = new int[]{2230, 2292, 104, 51};
        int[] var9 = new int[]{2127, 2336, 100, 78};
        int[] var10 = new int[]{1962, 2120, 152, 244};
        int[] var11 = new int[]{1893, 2383, 186, 135};
        int[] var12 = new int[]{1775, 2128, 150, 177};
        int[] var13 = new int[]{1615, 2086, 167, 133};
        int[] var14 = new int[]{1539, 2272, 78, 123};
        int[] var15 = new int[]{1562, 2395, 118, 203};
        int[] var16 = new int[]{1457, 2418, 75, 118};
        int[] var17 = new int[]{1452, 2232, 134, 152};
        int[] var18 = new int[]{1406, 2336, 77, 104};
        int[] var19 = new int[]{1302, 2207, 136, 206};
        int[] var20 = new int[]{1191, 2084, 154, 79};
        int[] var21 = new int[]{897, 2093, 187, 177};
        int[] var22 = new int[]{890, 2206, 157, 124};
        int[] var23 = new int[]{1094, 2353, 101, 58};
        int[] var24 = new int[]{1124, 2412, 120, 94};
        int[] var25 = new int[]{909, 2387, 178, 167};
        int[] var26 = new int[]{903, 2493, 192, 153};
        int[] var27 = new int[]{573, 2485, 133, 131};
        int[] var28 = new int[]{401, 2609, 155, 142};
        int[] var29 = new int[]{263, 2469, 118, 111};
        int[] var30 = new int[]{65, 1024, 44, 34};
        ck = new int[][]{var1, var2, {2641, 1295, 149, 228}, {2802, 1455, 157, 237}, var3, {2586, 1745, 156, 171}, var4, var5, var6, var7, {2165, 2200, 128, 73}, var8, {2327, 2367, 128, 157}, var9, {2152, 1942, 249, 251}, var10, {2030, 2257, 103, 111}, var11, {1886, 1976, 111, 100}, var12, {1707, 2302, 129, 113}, {1701, 2014, 127, 208}, var13, var14, var15, var16, var17, var18, {1337, 2461, 110, 125}, var19, var20, {1095, 2160, 129, 122}, var21, var22, {664, 2247, 158, 113}, var23, var24, var25, var26, {477, 2331, 128, 133}, var27, {502, 2670, 133, 192}, var28, {327, 2694, 126, 170}, {320, 2374, 91, 88}, var29, {1022, 890, 270, 307}, var30};
        var1 = new int[]{260, 246};
        var2 = new int[]{74, 114};
        var3 = new int[]{78, 118};
        var4 = new int[]{61, 97};
        var5 = new int[]{103, 80};
        var6 = new int[]{66, 85};
        var7 = new int[]{71, 72};
        var8 = new int[]{64, 36};
        var9 = new int[]{52, 25};
        var10 = new int[]{64, 78};
        var11 = new int[]{50, 39};
        var12 = new int[]{124, 125};
        var13 = new int[]{76, 122};
        var14 = new int[]{55, 50};
        var15 = new int[]{75, 88};
        var16 = new int[]{63, 104};
        var17 = new int[]{83, 66};
        var18 = new int[]{39, 61};
        var19 = new int[]{59, 101};
        var20 = new int[]{37, 59};
        var21 = new int[]{67, 76};
        var22 = new int[]{38, 52};
        var23 = new int[]{55, 62};
        var24 = new int[]{68, 103};
        var25 = new int[]{64, 61};
        var26 = new int[]{93, 88};
        var27 = new int[]{78, 62};
        var28 = new int[]{79, 56};
        var29 = new int[]{50, 29};
        var30 = new int[]{89, 83};
        int[] var31 = new int[]{96, 76};
        int[] var32 = new int[]{66, 65};
        int[] var33 = new int[]{66, 96};
        int[] var34 = new int[]{77, 71};
        int[] var35 = new int[]{63, 85};
        int[] var36 = new int[]{45, 44};
        int[] var37 = new int[]{59, 55};
        int[] var38 = new int[]{135, 153};
        int[] var39 = new int[]{22, 17};
        cl = new int[][]{var1, {102, 96}, var2, var3, var4, {78, 85}, var5, var6, {53, 64}, var7, var8, var9, var10, var11, var12, var13, {51, 55}, {93, 67}, var14, var15, {64, 56}, var16, var17, var18, var19, var20, var21, var22, var23, var24, {77, 39}, var25, var26, var27, var28, var29, {60, 47}, var30, var31, {64, 66}, var32, var33, var34, var35, var36, var37, var38, var39};
        var1 = new int[]{45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 46, 47, 48};
        cm = var1;
        var1 = new int[]{3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 90, 32, 3, 0, 4, 3, 0, 4, 3, 90, 30, 3, 0, 4, 3, 0, 4, 3, 90, 31, 3, 0, 4, 3, 0, 4, 3, 85, 32, 3, 0, 4, 3, 0, 4, 33, 0, 4, 3, 0, 4, 3, 0, 4, 3, 0, 4, 3, 93, 31, 3, 0, 4, 3, 0, 4, 33, 0, 4, 3, 0, 4, 3, 0, 4, 3, 90, 32, 3, 0, 4, 3, 0, 4, 30, 0, 4, 3, 0, 4, 3, 0, 4, 3, 99, 31, 3, 0, 4, 3, 0, 4, 3, 92, 31, 3, 0, 4, 3, 0, 4, 30, 0, 4, 3, 0, 4, 30, 0, 4, 3, 99, 32, 31, 0, 4, 33, 0, 4, 3, 0, 4, 4, 0, 4, 6, 60, 4, 4, 0, 4, 4, 70, 33};
        cn = var1;
        var1 = new int[]{250, 500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500};
        var2 = new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
        var3 = new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
        var4 = new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
        var5 = new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
        var6 = new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
        var7 = new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
        var8 = new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
        ac = new int[][]{{500, 1000, 2000, 4000, 8000, 12000, 16000, 20000, 24000, 28000}, var1, {250, 500, 1000, 2000, 4000, 6000, 8000, 10000, 12000, 15000}, var2, var3, var4, var5, var6, var7, var8};
        initialSkillValues = new int[]{100, 1500, 3, 0, 25, 10000, 1000, 0, 100, 100, 100};
        var1 = new int[]{4, 4, 4, 4, 3, 3, 2, 2, 1, 1, 0, 0};
        cx = var1;
        cy = new int[]{7, 4, 5, 7, 3, 3, 3, 7, 6, 1, 2};
        var2 = new int[]{45, 44, 43, 42, 41, 40, 39};
        var3 = new int[]{38, 37, 36, 35, -1};
        var4 = new int[]{34, 33, 32, 31, 30, -1};
        var5 = new int[]{29, 28, 27, 26, 25, 24, 23};
        var6 = new int[]{22, 21, 18, -1};
        var7 = new int[]{19, 20, 17, -1};
        var8 = new int[]{16, 15, 14, -1};
        var9 = new int[]{6, 5, 4, 3, 2, 1, -1};
        var1 = new int[]{0, -1};
        var10 = new int[]{46, 47, -1};
        cz = new int[][]{var2, var3, var4, var5, var6, var7, var8, {13, 12, 11, 10, 9, 8, 7}, var9, var1, var10};
        var1 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10};
        cA = var1;
        initialTreasureBonuses = new int[]{100, 100000, 30, 50, 7000, 50, 50, 50, 500, 150, 60};
        var1 = new int[]{-960, -960, -448, -415, -382, -319, -256, -192, -128, -64, 0, -8, -16, -18, -20, -18, -16, -8, 0, 0, -4, -4, 0, 0};
        ds = var1;
        dt = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 11, 16, 12, 17, 24, 13, 14, 20, 18, 19, 23, 25, 26};
        var1 = new int[]{0, 3, 7, 9, 12, 14, 15, 15, 15, 14, 12, 9, 7, 3};
        du = var1;
        var18 = new int[]{8, 0, 127};
        var4 = new int[]{0, 2, 127};
        var6 = new int[]{0, 4, 127};
        var10 = new int[]{0, 4, 127};
        var37 = new int[]{0, 0, 127};
        var9 = new int[]{-4, 0, 127};
        var31 = new int[]{0, 0, 127};
        var36 = new int[]{0, 2, 127};
        int[] var40 = new int[]{0, 0, 127};
        var17 = new int[]{0, 0, 127};
        var38 = new int[]{0, 0, 127};
        var30 = new int[]{0, 0, 127};
        var2 = new int[]{0, 0, 127};
        var25 = new int[]{0, 0, 127};
        var14 = new int[]{-8, 0, 127};
        int[] var41 = new int[]{-4, 0, 127};
        var1 = new int[]{0, 0, 127};
        var27 = new int[]{-4, 0, 127};
        var33 = new int[]{-4, 0, 127};
        var32 = new int[]{-8, 0, 127};
        var20 = new int[]{-4, 0, 127};
        int[] var42 = new int[]{-8, 0, 127};
        int[] var43 = new int[]{0, 0, 127};
        var22 = new int[]{0, 0, 127};
        var15 = new int[]{2, 0, 127};
        var8 = new int[]{2, 0, 127};
        int[] var44 = new int[]{4, 1, 127};
        int[] var45 = new int[]{-8, 0, 127};
        int[] var46 = new int[]{-4, 0, 127};
        var21 = new int[]{-2, 0, 127};
        var35 = new int[]{-4, 0, 127};
        var34 = new int[]{-8, 0, 127};
        var24 = new int[]{2, 0, 127};
        var5 = new int[]{-4, 0, 127};
        var39 = new int[]{-2, 0, 127};
        var3 = new int[]{-4, 0, 127};
        var19 = new int[]{0, 0, 127};
        int[] var47 = new int[]{0, 0, 127};
        var23 = new int[]{0, 0, 127};
        var13 = new int[]{-4, 0, 127};
        var28 = new int[]{0, 0, 127};
        var12 = new int[]{0, 0, 127};
        var7 = new int[]{-4, 0, 127};
        int[] var48 = new int[]{0, 0, 127};
        var29 = new int[]{0, 0, 127};
        var26 = new int[]{0, 0, 127};
        var16 = new int[]{0, 0, 127};
        int[] var49 = new int[]{0, 0, 156};
        var11 = new int[]{0, 0, 156};
        fe = new int[][]{var18, var4, var6, var10, var37, var9, var31, var36, var40, var17, var38, var30, var2, var25, var14, var41, var1, var27, var33, var32, var20, var42, var43, var22, var15, var8, var44, var45, var46, var21, var35, var34, var24, var5, var39, var3, var19, var47, var23, var13, var28, var12, var7, var48, var29, var26, var16, var49, var11};
        var1 = new int[]{0, 0, 6, -10, 0, 0};
        dv = var1;
        var1 = new int[]{0, 50, 80, 90, 100};
        eO = var1;
        var1 = new int[]{0, 10, 20, 60, 99, 100, 99, 60, 20, 10, 0};
        cC = var1;
        Z = new int[]{50, 90, 150, 180, 300, 90, 75, 150, 450, 900, 1500};
        aa = new int[]{9, 2, 7, 20, 5, 3, 5000, 12000, 40000, 100000, 200000};
        ab = new int[]{20, 10, 5, 90};
        var1 = new int[]{1, 2, 0, 3};
        aB = var1;
        var1 = new int[]{0, 10, 20, 999, 999, 999, 999, 999, 999, 999};
        X = var1;
        var1 = new int[]{0, 5, 30, 999, 999, 999, 999, 999, 999, 999};
        Y = var1;
        this.k = new String[]{"jp.co.ponos.battlecats.nekokan1", "jp.co.ponos.battlecats.nekokan2", "jp.co.ponos.battlecats.nekokan3", "jp.co.ponos.battlecats.nekokan4", "jp.co.ponos.battlecats.nekokan5", "jp.co.ponos.battlecats.nekokan6", "jp.co.ponos.battlecats.nekokan7", "jp.co.ponos.battlecats.nekokan8"};
        l = new int[]{30, 90, 180, 330, 690, 1080, 1860, 3900};
        var1 = new int[]{1, 2, 3, 0, 4, 5, 6, 7};
        m = var1;
    }

    int getCurrentX() {
        return this.currentXTouch;
    }

    int getCurrentY() {
        return this.currentYTouch;
    }

    int M() {
        return this.G;
    }

    int N() {
        return this.K;
    }

    int getPreviousX() {
        return this.previousXTouch;
    }

    int getPreviousY() {
        return this.previousYTouch;
    }

    boolean isPointerDownNow() {
        return this.pointerDownNow;
    }

    boolean isPointerDown() {
        return this.pointerDown;
    }

    boolean isPointerUp() {
        return this.pointerUp;
    }

    boolean T() {
        return this.R;
    }

    void U() {
        for (int var1 = 0; var1 < 10; ++var1) {
            for (int var2 = 0; var2 < this.getLength(cz); ++var2) {
                this.treasureMultValues[var1][var2] = 0;
                int var3 = 0;
                int var4 = 0;

                int var5;
                while (true) {
                    if (var4 >= this.getLength(cz[var2])) {
                        var5 = var3;
                        break;
                    }

                    var5 = var3;
                    if (cz[var2][var4] == -1) {
                        break;
                    }

                    if (this.bs[var1][cz[var2][var4]] <= 0) {
                        var5 = 0;
                        break;
                    }

                    var3 += this.bs[var1][cz[var2][var4]];
                    ++var4;
                }

                if (var5 != 0) {
                    this.treasureMultValues[var1][var2] = var5 * 100 / (cy[var2] * 3);
                }
            }
        }

    }

    void V() {
        int var1;
        for (var1 = 0; var1 < this.getLength(this.cj); ++var1) {
            this.cj[var1] = 0;
        }

        int var10002;
        int[] var4;
        for (var1 = 0; var1 < 6; ++var1) {
            if (this.eM[var1]) {
                var4 = this.battleItems;
                var10002 = var4[var1]--;
                this.eL[var1] = 1;
            } else {
                this.eL[var1] = 0;
            }
        }

        this.gM = 0;

        for (var1 = 0; var1 < 10; ++var1) {
            if (this.slotCatIDs[var1] - 2 >= 0) {
                this.eV[var1] = this.bw[this.slotCatIDs[var1] - 2];
            } else {
                this.eV[var1] = 0;
            }
        }

        int var2 = 0;

        for (var1 = 0; var1 < 10; ++var1) {
            if (this.slotCatIDs[var1] != -1) {
                ++var2;
            }
        }

        if (var2 >= 6) {
            this.gO = true;
        } else {
            this.gO = false;
        }

        this.isSettingsOpen = false;
        this.ef = false;

        for (var1 = 0; var1 < this.getLength(this.ha); ++var1) {
            this.ha[var1] = false;
        }

        for (var1 = 0; var1 < this.getLength(this.hk); ++var1) {
            this.hk[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.shouldPlayButtonSelect); ++var1) {
            this.shouldPlayButtonSelect[var1] = false;
        }

        for (var1 = 0; var1 < this.getLength(this.battleStats); ++var1) {
            this.battleStats[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.eH); ++var1) {
            this.eH[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.bV); ++var1) {
            this.bV[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.bW); ++var1) {
            for (var2 = 0; var2 < this.getLength(this.bW[var1]); ++var2) {
                this.bW[var1][var2] = 0;
            }
        }

        this.bP = 0;

        for (var1 = 0; var1 < this.getLength(this.bQ); ++var1) {
            for (var2 = 0; var2 < this.getLength(this.bQ[var1]); ++var2) {
                this.bQ[var1][var2] = 0;
            }
        }

        for (var1 = 0; var1 < this.getLength(this.fc); ++var1) {
            this.fc[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.fd); ++var1) {
            this.fd[var1] = 0;
        }

        this.U();
        this.eR = 0;
        this.eP = 0;

        for (var1 = 0; var1 < this.getLength(this.buttonCoordinates1); ++var1) {
            for (var2 = 0; var2 < this.getLength(this.buttonCoordinates1[var1]); ++var2) {
                this.buttonCoordinates1[var1][var2] = 0;
            }
        }

        for (var1 = 0; var1 < this.getLength(this.fx); ++var1) {
            this.fx[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.fy); ++var1) {
            this.fy[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.eK); ++var1) {
            this.eK[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.fz); ++var1) {
            this.fz[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.gZ); ++var1) {
            this.gZ[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.eI); ++var1) {
            this.eI[var1] = 0;
        }

        if (this.dH != 48) {
            this.bp[this.eQ] = this.dH;
        }

        this.battleStats[0] = this.dH;
        byte var5;
        if (this.eQ == 1 && this.battleStats[0] == 47) {
            var5 = 2;
        } else if (this.eQ == 2 && this.battleStats[0] == 47) {
            var5 = 3;
        } else {
            var5 = 0;
        }

        this.loadStageStats(var5 + this.battleStats[0]);
        this.battleStats[20] = cm[this.battleStats[0]];
        this.battleStats[5] = this.bV[0] - 9600;
        this.battleStats[15] = 0;

        for (var1 = 100; var1 >= 0; --var1) {
            if (this.bV[0] * var1 / 100 < 9600) {
                this.battleStats[28] = var1 + 1;
                break;
            }
        }

        this.z = 10000;
        this.battleStats[10] = 0;

        for (var1 = 0; var1 < this.getLength(this.rechargeTimes); ++var1) {
            this.rechargeTimes[var1] = 0;
        }

        this.battleStats[14] = 3;
        this.battleStats[11] = this.baseSpecialSkillLevels[4];
        this.battleStats[6] = initialSkillValues[4] + this.battleStats[11] * 10;
        this.battleStats[7] = initialSkillValues[5] + this.baseSpecialSkillLevels[5] * 10000;

        for (var1 = 0; var1 < this.getLength(this.bN); ++var1) {
            this.bN[var1] = 0;
        }

        if (this.eL[2] == 1) {
            this.bN[0] = 7;
        }

        this.battleStats[9] = this.battleStats[7] * (this.bN[0] * 5 + 10) / 10;

        for (var1 = 0; var1 < 10; ++var1) {
            var4 = this.battleStats;
            var4[9] += initialTreasureBonuses[1] * this.treasureMultValues[var1][1] / 100;
        }

        this.battleStats[8] = this.battleStats[6] * (this.bN[0] + 10) / 10;

        for (var1 = 0; var1 < 10; ++var1) {
            var4 = this.battleStats;
            var4[8] += initialTreasureBonuses[0] * this.treasureMultValues[var1][0] / 100;
        }

        int var3;
        for (var1 = 0; var1 < this.getLength(this.deployedUnits); ++var1) {
            for (var2 = 0; var2 < this.getLength(this.deployedUnits[var1]); ++var2) {
                for (var3 = 0; var3 < this.getLength(this.deployedUnits[var1][var2]); ++var3) {
                    this.deployedUnits[var1][var2][var3] = 0;
                }
            }
        }

        this.deployedUnits[0][0][0] = 1;
        this.deployedUnits[0][0][1] = 0;
        this.deployedUnits[0][0][2] = 0;
        this.deployedUnits[0][0][3] = this.bV[0] - 3200;
        this.deployedUnits[0][0][4] = 4400;
        this.deployedUnits[0][0][5] = 0;
        this.deployedUnits[0][0][6] = initialSkillValues[2] + this.baseSpecialSkillLevels[2] * 1;
        this.deployedUnits[0][0][7] = initialSkillValues[6] + this.baseSpecialSkillLevels[6] * 1000;
        if (this.baseSpecialSkillLevels[6] >= 4 && this.baseSpecialSkillLevels[6] <= 7) {
            this.deployedUnits[0][0][7] = (this.baseSpecialSkillLevels[6] - 4) * 2000 + 6000;
        } else if (this.baseSpecialSkillLevels[6] >= 8) {
            this.deployedUnits[0][0][7] = (this.baseSpecialSkillLevels[6] - 8) * 3000 + 15000;
        }

        for (var1 = 0; var1 < 10; ++var1) {
            var4 = this.deployedUnits[0][0];
            var4[7] += initialTreasureBonuses[4] * this.treasureMultValues[var1][4] / 100;
        }

        this.deployedUnits[0][0][8] = this.deployedUnits[0][0][7];
        this.deployedUnits[0][0][9] = 0;
        this.deployedUnits[0][0][10] = 0;
        this.deployedUnits[0][0][11] = initialSkillValues[1] + this.baseSpecialSkillLevels[1] * 50 - (initialSkillValues[3] + this.baseSpecialSkillLevels[3] * 50) + this.eQ * 450;

        for (var1 = 0; var1 < 10; ++var1) {
            var4 = this.deployedUnits[0][0];
            var4[11] -= initialTreasureBonuses[9] * this.treasureMultValues[var1][9] / 100;
        }

        if (this.deployedUnits[0][0][11] <= 60) {
            this.deployedUnits[0][0][11] = 60;
        }

        this.deployedUnits[0][0][12] = this.deployedUnits[0][0][11];
        this.deployedUnits[0][0][13] = 0;
        this.deployedUnits[0][0][14] = 0;
        this.deployedUnits[0][0][15] = 1800;
        this.deployedUnits[0][0][16] = initialSkillValues[0] + this.baseSpecialSkillLevels[0] * 50;

        for (var1 = 0; var1 < 10; ++var1) {
            var4 = this.deployedUnits[0][0];
            var4[16] += initialTreasureBonuses[8] * this.treasureMultValues[var1][8] / 100;
        }

        this.deployedUnits[1][0][0] = 1;
        this.deployedUnits[1][0][1] = 0;
        this.deployedUnits[1][0][2] = 0;
        this.deployedUnits[1][0][3] = 3200;
        this.deployedUnits[1][0][4] = 4400;
        this.deployedUnits[1][0][5] = 0;
        this.deployedUnits[1][0][7] = this.bV[1] * (this.eQ + 1);
        this.deployedUnits[1][0][8] = this.deployedUnits[1][0][7];
        this.deployedUnits[1][0][14] = 0;
        this.deployedUnits[1][0][15] = 1800;
        this.bP = aMath.rand(this.bV[3] - this.bV[2] + 1) + this.bV[2];

        for (var1 = 0; var1 < this.getLength(this.bW); ++var1) {
            if (this.bW[var1][0] != 0) {
                this.bQ[var1][0] = this.bW[var1][2];
            } else {
                this.bQ[var1][0] = 0;
            }
        }

        for (var1 = 0; var1 < this.getLength(this.bS); ++var1) {
            for (var2 = 0; var2 < this.getLength(this.bS[var1]); ++var2) {
                for (var3 = 0; var3 < this.getLength(this.bS[var1][var2]); ++var3) {
                    this.bS[var1][var2][var3] = 0;
                }
            }
        }

        for (var1 = 0; var1 < this.getLength(this.bT); ++var1) {
            for (var2 = 0; var2 < this.getLength(this.bT[var1]); ++var2) {
                this.bT[var1][var2] = 0;
            }
        }

        for (var1 = 0; var1 < this.getLength(this.bU); ++var1) {
            this.bU[var1] = 0;
        }

        if (this.bV[4] == 2) {
            for (var1 = 0; var1 < this.getLength(this.cc); ++var1) {
                this.cc[var1][0] = (var1 * 192 + aMath.rand(192)) % (this.bV[0] / 10 + this.excessWidth * 4);
                this.cc[var1][1] = aMath.rand((100 - this.battleStats[28]) * 20 + 200) - (100 - this.battleStats[28]) * 20;
                this.cc[var1][2] = 0;
                this.cc[var1][3] = aMath.rand(20) + 5;
                this.cc[var1][4] = aMath.rand(7);
            }
        } else if (this.bV[4] == 3) {
            for (var1 = 0; var1 < this.getLength(this.ce); ++var1) {
                this.ce[var1][0] = ((var1 * 56 + aMath.rand(56)) % (this.bV[0] / 10) + this.excessWidth * 4) * 100;
                this.ce[var1][1] = (aMath.rand((100 - this.battleStats[28]) * 20 + 640) - (100 - this.battleStats[28]) * 20) * 100;
                this.ce[var1][2] = 175 - aMath.rand(85);
                this.ce[var1][3] = aMath.rand(600) + 200;
            }
        }

        if (this.af[1].isLoaded()) {
            this.af[1].reset();
        }

        if (!this.af[1].isLoaded()) {
            this.af[1].load(MyUtility.getString(aString.format("img%03d.png", 100)), MyUtility.getString(aString.format("img%03d.imgcut", 100)));
        }

        if (this.uiTextures[0].isLoaded()) {
            this.uiTextures[0].reset();
        }

        if (!this.uiTextures[0].isLoaded()) {
            this.uiTextures[0].load(MyUtility.getString(aString.format("bg%03d.png", this.bV[4] + 0)), MyUtility.getString(aString.format("bg%03d.imgcut", this.bV[4])));
        }

        if (this.uiTextures[1].isLoaded()) {
            this.uiTextures[1].reset();
        }

        if (!this.uiTextures[1].isLoaded()) {
            this.uiTextures[1].load(MyUtility.getString(aString.format("fc%03d.png", 0)), MyUtility.getString(aString.format("fc%03d.imgcut", 0)));
        }

        if (this.uiTextures[2].isLoaded()) {
            this.uiTextures[2].reset();
        }

        if (!this.uiTextures[2].isLoaded()) {
            this.uiTextures[2].load(MyUtility.getString(aString.format("ec%03d.png", this.battleStats[20])), MyUtility.getString(aString.format("ec%03d.imgcut", this.battleStats[20])));
        }

        if (this.aC[0].isLoaded()) {
            this.aC[0].reset();
        }

        if (!this.aC[0].isLoaded()) {
            this.aC[0].load(MyUtility.getString(aString.format("i%03d_a.png", 0)), MyUtility.getString(aString.format("%03d_a.imgcut", 0)));
            this.aD[0].load(MyUtility.getString(aString.format("%03d_a.mamodel", 0)));

            for (var1 = 0; var1 < 1; ++var1) {
                this.aE[0][var1].load(MyUtility.getString(aString.format("%03d_a%02d.maanim", 0, var1)));
            }

            this.aD[1].load(MyUtility.getString(aString.format("%03d_a.mamodel", 1)));

            for (var1 = 0; var1 < 2; ++var1) {
                this.aE[1][var1].load(MyUtility.getString(aString.format("%03d_a%02d.maanim", 1, var1)));
            }

            for (var1 = 0; var1 < 2; ++var1) {
                this.aD[var1].setTextures(this.aC);
                this.aD[var1].setAction();
            }
        }

        if (this.uiTextures[4].isLoaded()) {
            this.uiTextures[4].reset();
        }

        if (!this.uiTextures[4].isLoaded()) {
            this.uiTextures[4].load(MyUtility.getString(aString.format("img%03d.png", 1)), MyUtility.getString(aString.format("img%03d.imgcut", 1)));
        }

        if (this.uiTextures[15].isLoaded()) {
            this.uiTextures[15].reset();
        }

        if (!this.uiTextures[15].isLoaded()) {
            this.uiTextures[15].load(MyUtility.getString(aString.format("img%03d.png", 2)), MyUtility.getString(aString.format("img%03d.imgcut", 2)));
        }

        if (this.uiTextures[16].isLoaded()) {
            this.uiTextures[16].reset();
        }

        if (!this.uiTextures[16].isLoaded()) {
            this.uiTextures[16].load(MyUtility.getString(aString.format("ec%03d_s.png", this.battleStats[20])), MyUtility.getString(aString.format("ec%03d_s.imgcut", this.battleStats[20])));
        }

        if (this.uiTextures[17].isLoaded()) {
            this.uiTextures[17].reset();
        }

        if (!this.uiTextures[17].isLoaded()) {
            this.uiTextures[17].load(MyUtility.getString(aString.format("ec%03d_n_%s.png", this.battleStats[20], MyUtility.getString("lang"))), MyUtility.getString(aString.format("ec%03d_n_%s.imgcut", this.battleStats[20], MyUtility.getString("lang"))));
        }

        if (this.uiTextures[18].isLoaded()) {
            this.uiTextures[18].reset();
        }

        if (!this.uiTextures[18].isLoaded()) {
            this.uiTextures[18].load(MyUtility.getString(aString.format("img%03d.png", 3)), MyUtility.getString(aString.format("img%03d.imgcut", 3)));
        }

        if (this.uiTextures[19].isLoaded()) {
            this.uiTextures[19].reset();
        }

        if (!this.uiTextures[19].isLoaded()) {
            this.uiTextures[19].load(MyUtility.getString(aString.format("img%03d.png", 4)), MyUtility.getString(aString.format("img%03d.imgcut", 4)));
        }

        if (this.uiTextures[20].isLoaded()) {
            this.uiTextures[20].reset();
        }

        if (!this.uiTextures[20].isLoaded()) {
            this.uiTextures[20].load(MyUtility.getString(aString.format("img%03d.png", 43)), MyUtility.getString(aString.format("img%03d.imgcut", 43)));
        }

        if (this.uiTextures[21].isLoaded()) {
            this.uiTextures[21].reset();
        }

        if (!this.uiTextures[21].isLoaded()) {
            this.uiTextures[21].load(MyUtility.getString(aString.format("img%03d.png", 6)), MyUtility.getString(aString.format("img%03d.imgcut", 6)));
        }

        if (this.uiTextures[23].isLoaded()) {
            this.uiTextures[23].reset();
        }

        if (!this.uiTextures[23].isLoaded()) {
            this.uiTextures[23].load(MyUtility.getString(aString.format("img%03d.png", 40)), MyUtility.getString(aString.format("img%03d.imgcut", 40)));
        }

        if (this.uiTextures[24].isLoaded()) {
            this.uiTextures[24].reset();
        }

        if (!this.uiTextures[24].isLoaded()) {
            this.uiTextures[24].load(MyUtility.getString(aString.format("img%03d.png", 41)), MyUtility.getString(aString.format("img%03d.imgcut", 41)));
        }

        if (this.uiTextures[25].isLoaded()) {
            this.uiTextures[25].reset();
        }

        if (!this.uiTextures[25].isLoaded()) {
            this.uiTextures[25].load(MyUtility.getString(aString.format("img%03d.png", 42)), MyUtility.getString(aString.format("img%03d.imgcut", 42)));
        }

        if (this.ay[0].isLoaded()) {
            this.ay[0].reset();
        }

        if (!this.ay[0].isLoaded()) {
            this.ay[0].load(MyUtility.getString(aString.format("i%03d_g.png", 0)), MyUtility.getString(aString.format("%03d_g.imgcut", 0)));
        }

        this.az[0][0].load(MyUtility.getString(aString.format("%03d_g%02d_%d.mamodel", 0, 0, 1)));
        this.aA[0][0].load(MyUtility.getString(aString.format("%03d_g%02d_%d.maanim", 0, 0, 1)));
        this.az[0][0].setTextures(this.ay);
        this.az[0][0].setAction();
        this.az[0][1].load(MyUtility.getString(aString.format("%03d_g%02d_%d.mamodel", 0, 0, 2)));
        this.aA[0][1].load(MyUtility.getString(aString.format("%03d_g%02d_%d.maanim", 0, 0, 2)));
        this.az[0][1].setTextures(this.ay);
        this.az[0][1].setAction();
        this.az[1][0].load(MyUtility.getString(aString.format("%03d_g%02d_%d.mamodel", 0, 1, 1)));
        this.aA[1][0].load(MyUtility.getString(aString.format("%03d_g%02d_%d.maanim", 0, 1, 1)));
        this.az[1][0].setTextures(this.ay);
        this.az[1][0].setAction();
        this.az[1][1].load(MyUtility.getString(aString.format("%03d_g%02d_%d.mamodel", 0, 1, 2)));
        this.aA[1][1].load(MyUtility.getString(aString.format("%03d_g%02d_%d.maanim", 0, 1, 2)));
        this.az[1][1].setTextures(this.ay);
        this.az[1][1].setAction();
        this.az[2][0].load(MyUtility.getString(aString.format("%03d_g%02d_%d.mamodel", 0, 2, 1)));
        this.aA[2][0].load(MyUtility.getString(aString.format("%03d_g%02d_%d.maanim", 0, 2, 1)));
        this.az[2][0].setTextures(this.ay);
        this.az[2][0].setAction();
        this.az[2][1].load(MyUtility.getString(aString.format("%03d_g%02d_%d.mamodel", 0, 2, 2)));
        this.aA[2][1].load(MyUtility.getString(aString.format("%03d_g%02d_%d.maanim", 0, 2, 2)));
        this.az[2][1].setTextures(this.ay);
        this.az[2][1].setAction();
        this.az[3][0].load(MyUtility.getString(aString.format("%03d_g%02d.mamodel", 0, 3)));
        this.aA[3][0].load(MyUtility.getString(aString.format("%03d_g%02d.maanim", 0, 3)));
        this.az[3][0].setTextures(this.ay);
        this.az[3][0].setAction();

        for (var1 = 0; var1 < this.getLength(this.ar); ++var1) {
            if (this.ar[var1].isLoaded()) {
                this.ar[var1].reset();
            }
        }

        for (var1 = 0; var1 < this.getLength(this.as); ++var1) {
            if (this.as[var1].isLoaded()) {
                this.as[var1].reset();
            }
        }

        for (var1 = 0; var1 < 10; ++var1) {
            if (this.uiTextures[var1 + 5].isLoaded()) {
                this.uiTextures[var1 + 5].reset();
            }
        }

        for (var1 = 0; var1 < 10; ++var1) {
            if (this.slotCatIDs[var1] == -1) {
                this.uiTextures[var1 + 5].load(MyUtility.getString(aString.format("uni.png")), MyUtility.getString(aString.format("uni.imgcut")));
            } else if (this.eV[var1] == 0) {
                if (!this.uiTextures[var1 + 5].isLoaded()) {
                    this.uiTextures[var1 + 5].load(MyUtility.getString(aString.format("uni%03d_f%02d.png", this.slotCatIDs[var1] - 2, 0)), MyUtility.getString(aString.format("uni%03d_f%02d.imgcut", this.slotCatIDs[var1] - 2, 0)));
                }
            } else if (this.eV[var1] == 1 && !this.uiTextures[var1 + 5].isLoaded()) {
                this.uiTextures[var1 + 5].load(MyUtility.getString(aString.format("uni%03d_c%02d.png", this.slotCatIDs[var1] - 2, 0)), MyUtility.getString(aString.format("uni%03d_c%02d.imgcut", this.slotCatIDs[var1] - 2, 0)));
            }
        }

        for (var1 = 0; var1 < 10; ++var1) {
            if (this.slotCatIDs[var1] != -1) {
                if (this.eV[var1] == 0) {
                    if (!this.ar[this.slotCatIDs[var1] - 2].isLoaded()) {
                        this.ar[this.slotCatIDs[var1] - 2].load(MyUtility.getString(aString.format("i%03d_f.png", this.slotCatIDs[var1] - 2)), MyUtility.getString(aString.format("%03d_f.imgcut", this.slotCatIDs[var1] - 2)));
                        this.at[var1].load(MyUtility.getString(aString.format("%03d_f.mamodel", this.slotCatIDs[var1] - 2)));

                        for (var2 = 0; var2 < this.getLength(this.au[var1]); ++var2) {
                            this.au[var1][var2].load(MyUtility.getString(aString.format("%03d_f%02d.maanim", this.slotCatIDs[var1] - 2, var2)));
                        }

                        this.at[var1].setTextures(this.ar);
                        this.at[var1].setAction();
                    }
                } else if (this.eV[var1] == 1 && !this.as[this.slotCatIDs[var1] - 2].isLoaded()) {
                    this.as[this.slotCatIDs[var1] - 2].load(MyUtility.getString(aString.format("i%03d_c.png", this.slotCatIDs[var1] - 2)), MyUtility.getString(aString.format("%03d_c.imgcut", this.slotCatIDs[var1] - 2)));
                    this.at[var1].load(MyUtility.getString(aString.format("%03d_c.mamodel", this.slotCatIDs[var1] - 2)));

                    for (var2 = 0; var2 < this.getLength(this.au[var1]); ++var2) {
                        this.au[var1][var2].load(MyUtility.getString(aString.format("%03d_c%02d.maanim", this.slotCatIDs[var1] - 2, var2)));
                    }

                    this.at[var1].setTextures(this.as);
                    this.at[var1].setAction();
                }
            }
        }

        for (var1 = 0; var1 < 10; ++var1) {
            this.eU[var1] = -1;
        }

        for (var1 = 0; var1 < this.getLength(this.bW); ++var1) {
            for (var2 = 0; var2 < 10 && this.bW[var1][0] != 0 && this.bW[var1][0] != this.eU[var2]; ++var2) {
                if (this.eU[var2] == -1) {
                    this.eU[var2] = this.bW[var1][0];
                    break;
                }
            }
        }

        for (var1 = 0; var1 < this.getLength(this.av); ++var1) {
            if (this.av[var1].isLoaded()) {
                this.av[var1].reset();
            }
        }

        for (var1 = 0; var1 < 10; ++var1) {
            if (this.eU[var1] != -1 && this.eU[var1] > 0 && !this.av[this.eU[var1] - 2].isLoaded()) {
                if (this.eU[var1] - 2 == 21) {
                    this.av[this.eU[var1] - 2].load(MyUtility.getString(aString.format("i%03d_e.png", this.eU[var1] - 2)), MyUtility.getString(aString.format("i%03d_e.imgcut", this.eU[var1] - 2)));
                } else {
                    this.av[this.eU[var1] - 2].load(MyUtility.getString(aString.format("i%03d_e.png", this.eU[var1] - 2)), MyUtility.getString(aString.format("%03d_e.imgcut", this.eU[var1] - 2)));
                }

                this.aw[var1].load(MyUtility.getString(aString.format("%03d_e.mamodel", this.eU[var1] - 2)));

                for (var2 = 0; var2 < this.getLength(this.ax[var1]); ++var2) {
                    this.ax[var1][var2].load(MyUtility.getString(aString.format("%03d_e%02d.maanim", this.eU[var1] - 2, var2)));
                }

                this.aw[var1].setTextures(this.av);
                this.aw[var1].setAction();
            }
        }

        for (var1 = 0; var1 < this.getLength(this.textTextures); ++var1) {
            if (this.textTextures[var1].isLoaded()) {
                this.textTextures[var1].reset();
            }
        }

        for (var1 = 0; var1 < this.getLength(this.aj); ++var1) {
            if (this.aj[var1].isLoaded()) {
                this.aj[var1].reset();
            }
        }

        for (var1 = 0; var1 < this.getLength(this.gA); ++var1) {
            this.gA[var1] = 0;
        }

        this.aj[0].loadText(this.warning1Text[5], "FONT_SYSTEM_BOLD", 30, 1);

        for (var1 = 0; var1 < 4; ++var1) {
            this.textTextures[var1 + 1].loadText(this.stageFirstMessageText[0][var1], "FONT_SYSTEM_BOLD", 30, 1);
        }

        this.textTextures[10].loadText(this.optionText[1], "FONT_SYSTEM_BOLD", 30, 1);
        this.gA[0] = 20;
        this.buttonCoordinates1[0][0] = this.excessWidth + 814;
        this.buttonCoordinates1[0][1] = this.eZ + 510;
        this.buttonCoordinates1[0][2] = 146;
        this.buttonCoordinates1[0][3] = 130;
        this.buttonCoordinates1[1][0] = 0;
        this.buttonCoordinates1[1][1] = this.eZ + 515;
        this.buttonCoordinates1[1][2] = 146;
        this.buttonCoordinates1[1][3] = 125;
        this.buttonCoordinates1[3][0] = 0;
        this.buttonCoordinates1[3][1] = 0 - this.eZ;
        this.buttonCoordinates1[3][2] = 88;
        this.buttonCoordinates1[3][3] = 88;
        var3 = 5;

        for (var1 = 5; var1 >= 0; var3 = var2) {
            var2 = var3;
            if (this.eL[var1] != 0) {
                this.eJ[var1][0] = var3 * 88 + 432 + this.excessWidth;
                this.eJ[var1][1] = 43 - this.eZ;
                this.eJ[var1][2] = 88;
                this.eJ[var1][3] = 88;
                var2 = var3 - 1;
            }

            --var1;
        }

        for (var1 = 0; var1 < this.getLength(this.eD); ++var1) {
            this.eD[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.gd); ++var1) {
            this.gd[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.ge); ++var1) {
            this.ge[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.gf); ++var1) {
            this.gf[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.gg); ++var1) {
            this.gg[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.ek); ++var1) {
            this.ek[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.eE); ++var1) {
            this.eE[var1] = false;
        }

        for (var1 = 0; var1 < this.getLength(this.el); ++var1) {
            this.el[var1] = 0;
        }

        this.battleStats[12] = 0;
        this.eG = 1;
        this.eX = false;
        this.fa = 0;
        this.fU = 0;
        this.eS = 0;

        for (var1 = 0; var1 < this.getLength(this.gV); ++var1) {
            this.gV[var1] = 0;
        }

        this.gW = 0;
        this.fX = aMath.rand(this.battleStats[9]);
        Sound.getInstance().stop(SoundType.ALL);
        this.eH[0] = 0;

        for (var1 = 0; var1 < 10; ++var1) {
            if (this.eQ == var1 && this.battleStats[0] == 47) {
                this.eH[0] = var1;
                break;
            }
        }

        if (this.eH[0] >= 1) {
            var4 = this.eH;
            var10002 = var4[0]++;
        }

        Sound.getInstance().play(cn[(this.battleStats[0] + this.eH[0]) * 3]);
        this.eH[0] = 0;

        for (var1 = 0; var1 < this.getLength(this.buttonCoordinatesSettings); ++var1) {
            for (var2 = 0; var2 < this.getLength(this.buttonCoordinatesSettings[var1]); ++var2) {
                this.buttonCoordinatesSettings[var1][var2] = 0;
            }
        }

        for (var1 = 0; var1 < this.getLength(this.buttonDelay); ++var1) {
            this.buttonDelay[var1] = 0;
        }

        this.buttonCoordinatesSettings[0][0] = this.excessWidth / 2 + 280;
        this.buttonCoordinatesSettings[0][1] = 80;
        this.buttonCoordinatesSettings[0][2] = 88;
        this.buttonCoordinatesSettings[0][3] = 88;
        this.buttonCoordinatesSettings[1][0] = 0;
        this.buttonCoordinatesSettings[1][1] = 0;
        this.buttonCoordinatesSettings[1][2] = 0;
        this.buttonCoordinatesSettings[1][3] = 0;
        this.buttonCoordinatesSettings[2][0] = this.excessWidth / 2 + 535;
        this.buttonCoordinatesSettings[2][1] = 276;
        this.buttonCoordinatesSettings[2][2] = 106;
        this.buttonCoordinatesSettings[2][3] = 88;
        this.buttonCoordinatesSettings[3][0] = this.excessWidth / 2 + 248 + 252 - 2;
        this.buttonCoordinatesSettings[3][1] = 371;
        this.buttonCoordinatesSettings[3][2] = 88;
        this.buttonCoordinatesSettings[3][3] = 88;
        this.buttonCoordinatesSettings[4][0] = this.excessWidth / 2 + 248 + 356 - 2;
        this.buttonCoordinatesSettings[4][1] = 371;
        this.buttonCoordinatesSettings[4][2] = 88;
        this.buttonCoordinatesSettings[4][3] = 88;
        this.buttonCoordinatesSettings[5][0] = this.excessWidth / 2 + 248 + 404;
        this.buttonCoordinatesSettings[5][1] = 48;
        this.buttonCoordinatesSettings[5][2] = 95;
        this.buttonCoordinatesSettings[5][3] = 95;
        this.buttonCoordinatesSettings[6][0] = this.excessWidth / 2 + 248 + 40;
        this.buttonCoordinatesSettings[6][1] = 456;
        this.buttonCoordinatesSettings[6][2] = 381;
        this.buttonCoordinatesSettings[6][3] = 88;
        this.buttonCoordinatesSettings[7][0] = this.excessWidth / 2 + 248 + 40;
        this.buttonCoordinatesSettings[7][1] = 189;
        this.buttonCoordinatesSettings[7][2] = 168;
        this.buttonCoordinatesSettings[7][3] = 88;
        this.buttonCoordinatesSettings[8][0] = this.excessWidth / 2 + 309;
        this.buttonCoordinatesSettings[8][1] = 284;
        this.buttonCoordinatesSettings[8][2] = 131;
        this.buttonCoordinatesSettings[8][3] = 131;
        this.buttonCoordinatesSettings[9][0] = this.excessWidth / 2 + 288;
        this.buttonCoordinatesSettings[9][1] = 363;
        this.buttonCoordinatesSettings[9][2] = 168;
        this.buttonCoordinatesSettings[9][3] = 88;
        this.buttonCoordinatesSettings[10][0] = this.excessWidth / 2 + 251;
        this.buttonCoordinatesSettings[10][1] = 374;
        this.buttonCoordinatesSettings[10][2] = 168;
        this.buttonCoordinatesSettings[10][3] = 88;
        this.buttonCoordinatesSettings[11][0] = this.excessWidth / 2 + 541;
        this.buttonCoordinatesSettings[11][1] = 374;
        this.buttonCoordinatesSettings[11][2] = 168;
        this.buttonCoordinatesSettings[11][3] = 88;
        this.buttonCoordinatesSettings[12][0] = this.excessWidth / 2 + 500;
        this.buttonCoordinatesSettings[12][1] = 191;
        this.buttonCoordinatesSettings[12][2] = 172;
        this.buttonCoordinatesSettings[12][3] = 88;

        for (var1 = 0; var1 < this.getLength(this.hb); ++var1) {
            this.hb[var1] = 0.0F;
        }

        this.hj[0][0] = this.excessWidth / 2 + 246;
        this.hj[0][1] = 0 - this.eZ;
        this.hj[0][2] = 131;
        this.hj[0][3] = 107;
        this.hj[1][0] = this.excessWidth / 2 + 246;
        this.hj[1][1] = 345;
        this.hj[1][2] = 96;
        this.hj[1][3] = 96;
        this.hj[2][0] = this.excessWidth / 2 + 426;
        this.hj[2][1] = 335;
        this.hj[2][2] = 96;
        this.hj[2][3] = 96;
        this.hj[3][0] = this.excessWidth / 2 + 606;
        this.hj[3][1] = 345;
        this.hj[3][2] = 96;
        this.hj[3][3] = 96;
        this.hj[4][0] = this.excessWidth / 2 + 786;
        this.hj[4][1] = 335;
        this.hj[4][2] = 96;
        this.hj[4][3] = 96;
        this.hj[5][0] = 4;
        this.hj[5][1] = 541;
        this.hj[5][2] = 95;
        this.hj[5][3] = 95;
        this.hj[6][0] = this.excessWidth / 2 + 422;
        this.hj[6][1] = 313;
        this.hj[6][2] = 381;
        this.hj[6][3] = 88;
        this.hj[7][0] = this.excessWidth / 2 + 803;
        this.hj[7][1] = 173;
        this.hj[7][2] = 95;
        this.hj[7][3] = 95;
        this.hj[8][0] = 580;
        this.hj[8][1] = 547;
        this.hj[8][2] = 88;
        this.hj[8][3] = 88;
        this.buttonCoordinates1[10][0] = this.excessWidth + 701;
        this.buttonCoordinates1[10][1] = this.eZ + 578;
        this.buttonCoordinates1[10][2] = 88;
        this.buttonCoordinates1[10][3] = 88;
        this.buttonCoordinates1[11][0] = this.excessWidth + 799;
        this.buttonCoordinates1[11][1] = this.eZ + 578;
        this.buttonCoordinates1[11][2] = 88;
        this.buttonCoordinates1[11][3] = 88;
        this.buttonCoordinates1[13][0] = 197;
        this.buttonCoordinates1[13][1] = 552;
        this.buttonCoordinates1[13][2] = 214;
        this.buttonCoordinates1[13][3] = 88;
        this.buttonCoordinates1[14][0] = this.excessWidth + 680;
        this.buttonCoordinates1[14][1] = 552;
        this.buttonCoordinates1[14][2] = 88;
        this.buttonCoordinates1[14][3] = 88;

        for (var1 = 0; var1 < this.getLength(this.em); ++var1) {
            this.em[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.en); ++var1) {
            this.en[var1] = 0;
        }

        this.eo = 0;

        for (var1 = 0; var1 < this.getLength(this.ep); ++var1) {
            this.ep[var1] = 0.0F;
        }

        for (var1 = 0; var1 < this.getLength(this.eq); ++var1) {
            this.eq[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.er); ++var1) {
            this.er[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.es); ++var1) {
            this.es[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.et); ++var1) {
            this.et[var1] = false;
        }

        for (var1 = 0; var1 < this.getLength(this.eu); ++var1) {
            this.eu[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.ev); ++var1) {
            this.ev[var1] = 0;
        }

        this.ew = 0;

        for (var1 = 0; var1 < this.getLength(this.ev); ++var1) {
            this.ev[var1] = 0;
        }

        this.ex = false;
        this.ey = 0;
        this.ez = 0;

        for (var1 = 0; var1 < this.getLength(this.eA); ++var1) {
            for (var2 = 0; var2 < this.getLength(this.eA[var1]); ++var2) {
                this.eA[var1][var2] = 0;
            }
        }

        for (var1 = 0; var1 < this.getLength(this.eB); ++var1) {
            for (var2 = 0; var2 < this.getLength(this.eB[var1]); ++var2) {
                for (var3 = 0; var3 < this.getLength(this.eB[var1][var2]); ++var3) {
                    this.eB[var1][var2][var3] = 0;
                }
            }
        }

        for (var1 = 0; var1 < this.getLength(this.scrollOffset); ++var1) {
            this.scrollOffset[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.ei); ++var1) {
            this.ei[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.frameCounter); ++var1) {
            this.frameCounter[var1] = 0;
        }

        this.eC = false;
        this.dV = false;
        this.dW = 0;
        this.hH = 0;
    }

    int getScene() {
        return this.scene;
    }

    int getScreen() {
        return this.screen;
    }

    ScreenType getScreenType() {
        return ScreenType.valueOf(this.screen);
    }

    public void setScreenType(ScreenType screenType) {
        this.screen = screenType.screenID;
    }

    SceneType getSceneType() {
        return SceneType.valueOf(this.scene);
    }

    int getScene2() {
        return this.scene2;
    }

    SceneType getScene2Type() {
        return SceneType.valueOf(this.scene2);
    }

    void resetTextures() {
        byte var1 = 0;

        int var2;
        for (var2 = 0; var2 < this.getLength(this.ar); ++var2) {
            if (this.ar[var2].isLoaded()) {
                this.ar[var2].reset();
            }
        }

        for (var2 = 0; var2 < this.getLength(this.as); ++var2) {
            if (this.as[var2].isLoaded()) {
                this.as[var2].reset();
            }
        }

        for (var2 = 0; var2 < this.getLength(this.av); ++var2) {
            if (this.av[var2].isLoaded()) {
                this.av[var2].reset();
            }
        }

        for (var2 = 0; var2 < this.getLength(this.ay); ++var2) {
            if (this.ay[var2].isLoaded()) {
                this.ay[var2].reset();
            }
        }

        for (var2 = 0; var2 < this.getLength(this.aC); ++var2) {
            if (this.aC[var2].isLoaded()) {
                this.aC[var2].reset();
            }
        }

        for (var2 = 0; var2 < this.getLength(this.ak); ++var2) {
            if (this.ak[var2].isLoaded()) {
                this.ak[var2].reset();
            }
        }

        for (var2 = 0; var2 < this.getLength(this.ao); ++var2) {
            if (this.ao[var2].isLoaded()) {
                this.ao[var2].reset();
            }
        }

        for (var2 = 0; var2 < this.getLength(this.aj); ++var2) {
            if (this.aj[var2].isLoaded()) {
                this.aj[var2].reset();
            }
        }

        for (var2 = 0; var2 < this.getLength(this.stampTextures); ++var2) {
            if (this.stampTextures[var2].isLoaded()) {
                this.stampTextures[var2].reset();
            }
        }

        for (var2 = var1; var2 < this.getLength(this.aI); ++var2) {
            if (this.aI[var2].isLoaded()) {
                this.aI[var2].reset();
            }
        }

    }

    void map2Load() {
        int var1;
        for (var1 = 0; var1 < this.getLength(this.shouldPlayButtonSelect); ++var1) {
            this.shouldPlayButtonSelect[var1] = false;
        }

        //jp.co.ponos.library.a.a.b().f();

        for (var1 = 0; var1 < this.getLength(this.buttonCoordinates1); ++var1) {
            for (int var2 = 0; var2 < this.getLength(this.buttonCoordinates1[var1]); ++var2) {
                this.buttonCoordinates1[var1][var2] = 0;
            }
        }

        for (var1 = 0; var1 < this.getLength(this.scrollOffset); ++var1) {
            this.scrollOffset[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.ei); ++var1) {
            this.ei[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.frameCounter); ++var1) {
            this.frameCounter[var1] = 0;
        }

        for (var1 = 0; var1 < this.getLength(this.fx); ++var1) {
            this.fx[var1] = 0;
        }

        this.buttonCoordinates1[0][0] = 633;
        this.buttonCoordinates1[0][1] = 488;
        this.buttonCoordinates1[0][2] = 304;
        this.buttonCoordinates1[0][3] = 86;
        this.buttonCoordinates1[5][0] = 4;
        this.buttonCoordinates1[5][1] = 541;
        this.buttonCoordinates1[5][2] = 95;
        this.buttonCoordinates1[5][3] = 95;

        for (var1 = 0; var1 < this.getLength(this.gm); ++var1) {
            this.gm[var1] = 0;
        }

        this.gm[1] = 297;

        for (var1 = 0; var1 < this.getLength(this.eE); ++var1) {
            this.eE[var1] = false;
        }

        this.gm[0] = 297;
        this.gm[1] = 0;
        this.eE[0] = false;
        this.frameCounter[2] = 0;
        this.resetTextures();

        for (var1 = 0; var1 < 10; ++var1) {
            if (this.slotCatIDs[var1] - 2 >= 0) {
                this.eV[var1] = this.bw[this.slotCatIDs[var1] - 2];
            } else {
                this.eV[var1] = 0;
            }
        }

        for (var1 = 0; var1 < 10; ++var1) {
            if (!this.ak[var1].isLoaded()) {
                if (this.slotCatIDs[var1] == -1) {
                    this.ak[var1].load(MyUtility.getString(aString.format("uni.png")), MyUtility.getString(aString.format("uni.imgcut")));
                } else if (this.eV[var1] == 0) {
                    this.ak[var1].load(MyUtility.getString(aString.format("uni%03d_f%02d.png", this.slotCatIDs[var1] - 2, 0)), MyUtility.getString(aString.format("uni%03d_f%02d.imgcut", this.slotCatIDs[var1] - 2, 0)));
                } else if (this.eV[var1] == 1) {
                    this.ak[var1].load(MyUtility.getString(aString.format("uni%03d_c%02d.png", this.slotCatIDs[var1] - 2, 0)), MyUtility.getString(aString.format("uni%03d_c%02d.imgcut", this.slotCatIDs[var1] - 2, 0)));
                }
            }
        }

        if (this.uiTextures[6].isLoaded()) {
            this.uiTextures[6].reset();
        }

        if (!this.uiTextures[6].isLoaded()) {
            this.uiTextures[6].load(MyUtility.getString(aString.format("img%03d.png", 32)), MyUtility.getString(aString.format("img%03d.imgcut", 32)));
        }

        if (this.uiTextures[7].isLoaded()) {
            this.uiTextures[7].reset();
        }

        if (!this.uiTextures[7].isLoaded()) {
            this.uiTextures[7].load(MyUtility.getString(aString.format("img%03d.png", 19)), MyUtility.getString(aString.format("img%03d.imgcut", 19)));
        }

        if (this.uiTextures[8].isLoaded()) {
            this.uiTextures[8].reset();
        }

        if (!this.uiTextures[8].isLoaded()) {
            this.uiTextures[8].load(MyUtility.getString(aString.format("img%03d.png", 33)), MyUtility.getString(aString.format("img%03d.imgcut", 33)));
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

    int getLength(float[] var1) {
        return var1.length;
    }

    int getLength(int[] var1) {
        return var1.length;
    }

    int getLength(String[] var1) {
        return var1.length;
    }

    int getLength(Texture[] var1) {
        return var1.length;
    }

    int getLength(Model[] var1) {
        return var1.length;
    }

    int getLength(ModelAnimation[] var1) {
        return var1.length;
    }

    int getLength(boolean[] var1) {
        return var1.length;
    }

    int getLength(int[][] var1) {
        return var1.length;
    }

    int getLength(String[][] var1) {
        return var1.length;
    }

    int getLength(Model[][] var1) {
        return var1.length;
    }

    int getLength(ModelAnimation[][] var1) {
        return var1.length;
    }

    int getLength(int[][][] var1) {
        return var1.length;
    }

    int getLength(String[][][] var1) {
        return var1.length;
    }

    public void onCreate() {
    }

    public void onTouchEvent(int var1, int var2, int var3, int var4) {
    }

    void a(TextureRenderer var1, int var2, int var3, int var4) {
        this.eH[2] = this.unitStats[this.slotCatIDs[var2]][this.eV[var2]][7];
        int[] var5 = this.eH;
        var5[2] -= initialSkillValues[7] + this.baseSpecialSkillLevels[7] * 6;

        for (int var6 = 0; var6 < 10; ++var6) {
            var5 = this.eH;
            var5[2] -= initialTreasureBonuses[2] * this.treasureMultValues[var6][2] / 100;
        }

        if (this.eH[2] <= 60) {
            this.eH[2] = 60;
        }

        this.eH[3] = (this.eH[2] - this.rechargeTimes[var2]) * 93 / this.eH[2];
        if (this.eH[3] > 93) {
            this.eH[3] = 93;
        }

        this.eH[4] = (100 - var4) * 97 / 100;
        this.eH[5] = (100 - var4) * 14 / 100;
        this.eH[6] = this.eH[3] * (100 - var4) / 100;
        this.eH[7] = (100 - var4) * 10 / 100;
        if (var3 == 0) {
            var1.setColor(0, 0, 0);
            var1.drawRectangle(fb[var2] + 6 + this.excessWidth / 2, this.eI[0] + 610 - 4 + this.eZ, 97, 14);
            var1.setColor(0, 255, 255);
            var1.drawRectangle(fb[var2] + 8 + this.excessWidth / 2, this.eI[0] + 612 - 4 + this.eZ, this.eH[3], 10);
        } else {
            var1.setColor(0, 0, 0);
            var1.drawRectangle(fb[var2] + 6 + (97 - this.eH[4]) / 2 + this.excessWidth / 2, this.eI[0] + 610 + this.eD[var3] - (14 - this.eH[5]) / 2 + this.eZ, this.eH[4], this.eH[5]);
            var1.setColor(0, 255, 255);
            var1.drawRectangle(fb[var2] + 8 + (93 - (100 - var4) * 93 / 100) / 2 + this.excessWidth / 2, this.eI[0] + 612 + this.eD[var3] - (10 - this.eH[7]) / 2 + this.eZ, this.eH[6], this.eH[7]);
        }

    }

    void a(TextureRenderer var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        int var8;
        if (var7 == 0) {
            int var9;
            if (var5 != 0 && var5 != 1) {
                if (var5 == 2 || var5 == 3) {
                    for (var7 = 1; var7 <= var2; var3 += (100 - var6) * 15 / 100) {
                        var7 *= 10;
                    }

                    var7 = (100 - var6) * 22 / 100;
                    var8 = (100 - var6) * 26 / 100;
                    if (var5 == 2) {
                        var1.drawScaledImageI(this.uiTextures[4], var3, var4 + (26 - var8) / 2, var7, var8, 45);
                    } else if (var5 == 3) {
                        var1.drawScaledImageI(this.uiTextures[4], var3, var4 + (26 - var8) / 2, var7, var8, 56);
                    }

                    var9 = (100 - var6) * 18 / 100;
                    var8 = (100 - var6) * 26 / 100;
                    var7 = var3 - (100 - var6) * 15 / 100;
                    var3 = var2;
                    var2 = var7;

                    while (true) {
                        if (var5 == 2) {
                            var1.drawScaledImageI(this.uiTextures[4], var2 + (18 - var9) / 2, var4 + (26 - var8) / 2, var9, var8, var3 % 10 + 35);
                        } else if (var5 == 3) {
                            var1.drawScaledImageI(this.uiTextures[4], var2 + (18 - var9) / 2, var4 + (26 - var8) / 2, var9, var8, var3 % 10 + 46);
                        }

                        var3 /= 10;
                        var7 = (100 - var6) * 15 / 100;
                        if (var3 <= 0) {
                            break;
                        }

                        var2 -= var7;
                    }
                }
            } else {
                var3 += 4;
                var7 = var4 + 12;
                var4 = (100 - var6) * 22 / 100;
                var8 = (100 - var6) * 26 / 100;
                if (var5 == 0) {
                    var1.drawScaledImageI(this.uiTextures[4], var3 + (22 - var4) / 2, var7 + (26 - var8) / 2, var4, var8, 45);
                } else if (var5 == 1) {
                    var1.drawScaledImageI(this.uiTextures[4], var3 + (22 - var4) / 2, var7 + (26 - var8) / 2, var4, var8, 56);
                }

                var4 = (100 - var6) * 15 / 100;
                var9 = (100 - var6) * 18 / 100;
                var8 = (100 - var6) * 26 / 100;
                var4 = var3 - var4;
                var3 = var2;
                var2 = var4;

                while (true) {
                    if (var5 == 0) {
                        var1.drawScaledImageI(this.uiTextures[4], var2 + (18 - var9) / 2, var7 + (26 - var8) / 2, var9, var8, var3 % 10 + 35);
                    } else if (var5 == 1) {
                        var1.drawScaledImageI(this.uiTextures[4], var2 + (18 - var9) / 2, var7 + (26 - var8) / 2, var9, var8, var3 % 10 + 46);
                    }

                    var3 /= 10;
                    var4 = (100 - var6) * 15 / 100;
                    if (var3 <= 0) {
                        break;
                    }

                    var2 -= var4;
                }
            }
        } else if (var7 == 1) {
            var7 = (100 - var6) * 22 / 100;
            var5 = (100 - var6) * 26 / 100;
            var1.drawScaledImageI(this.uiTextures[8], var3 + (22 - var7) / 2, var4 + (26 - var5) / 2, var7, var5, 70);
            var5 = (100 - var6) * 15 / 100;
            var8 = (100 - var6) * 18 / 100;
            var7 = (100 - var6) * 26 / 100;
            var5 = var3 - var5;
            var3 = var2;
            var2 = var5;

            while (true) {
                var1.drawScaledImageI(this.uiTextures[8], var2 + (18 - var8) / 2, var4 + (26 - var7) / 2, var8, var7, var3 % 10 + 60);
                var3 /= 10;
                var5 = (100 - var6) * 15 / 100;
                if (var3 <= 0) {
                    break;
                }

                var2 -= var5;
            }
        }

    }

    boolean map2Process() {
        boolean var1 = false;
        if (this.eE[5]) {
            int[] var2;
            int var10002;
            if (!this.eE[0] && !this.eE[1] && !this.eE[2] && this.dY == 0) {
                if (this.fx[0] >= 1) {
                    var2 = this.fx;
                    var10002 = var2[0]++;
                    if (this.fx[0] > this.getLength(dv) - 1) {
                        this.fx[0] = 0;
                        this.eE[2] = true;
                        this.scrollOffset[1] = 960;
                        Sound.getInstance().play(SoundType.BATTLE_START);
                    }
                } else if (this.fx[5] >= 1) {
                    var2 = this.fx;
                    var10002 = var2[5]++;
                    if (this.fx[5] > this.getLength(dv) - 1) {
                        this.fx[5] = 0;
                        this.screenTransition();
                        this.fP = 0;
                        this.setScreenType(ScreenType.MAP);
                        this.screenLoadState = -1;
                        this.frameCounter[2] = 0;
                        this.eE[1] = false;
                        return var1;
                    }
                } else {
                    if (this.isPointerDown() && this.isTouching(this.buttonCoordinates1[0][0], this.buttonCoordinates1[0][1], this.buttonCoordinates1[0][2], this.buttonCoordinates1[0][3])) {
                        if (!this.shouldPlayButtonSelect[0]) {
                            Sound.getInstance().play(SoundType.BUTTON_SELECT);
                            this.shouldPlayButtonSelect[0] = true;
                        }
                    } else {
                        this.shouldPlayButtonSelect[0] = false;
                    }

                    if (this.isPointerDown() && this.isTouching(this.buttonCoordinates1[5][0], this.buttonCoordinates1[5][1], this.buttonCoordinates1[5][2], this.buttonCoordinates1[5][3])) {
                        if (!this.shouldPlayButtonSelect[5]) {
                            Sound.getInstance().play(SoundType.BUTTON_SELECT);
                            this.shouldPlayButtonSelect[5] = true;
                        }
                    } else {
                        this.shouldPlayButtonSelect[5] = false;
                    }

                    if (this.isPointerUp() && this.isTouching(this.buttonCoordinates1[0][0], this.buttonCoordinates1[0][1], this.buttonCoordinates1[0][2], this.buttonCoordinates1[0][3])) {
                        var2 = this.fx;
                        var10002 = var2[0]++;
                        Sound.getInstance().play(SoundType.BUTTON_PRESS);
                    } else if (this.isPointerUp() && this.isTouching(this.buttonCoordinates1[5][0], this.buttonCoordinates1[5][1], this.buttonCoordinates1[5][2], this.buttonCoordinates1[5][3])) {
                        var2 = this.fx;
                        var10002 = var2[5]++;
                        Sound.getInstance().play(SoundType.BUTTON_PRESS);
                    }
                }
            }

            if (this.eE[0]) {
                var2 = this.frameCounter;
                var10002 = var2[2]++;
                this.gm[0] = this.gm[0] * 2 + 1;
                if (this.gm[0] >= 297) {
                    this.gm[0] = 297;
                    this.gm[1] /= 2;
                }

                if (this.frameCounter[2] > this.getLength(fM) - 1) {
                    this.frameCounter[2] = this.getLength(fM) - 1;
                    this.fP = this.getWidth();
                    if (this.gm[1] <= 0) {
                        this.eE[0] = false;
                        this.frameCounter[2] = 0;
                    }
                } else {
                    this.fP = fM[this.frameCounter[2]];
                }
            } else if (this.eE[1]) {
                var2 = this.frameCounter;
                var10002 = var2[2]++;
                if (this.frameCounter[2] > this.getLength(fM) - 1) {
                    this.fP = 0;
                } else {
                    this.fP = fM[this.getLength(fM) - 1 - this.frameCounter[2]];
                }

                if (this.frameCounter[2] > this.getLength(fM)) {
                    this.frameCounter[2] = 0;
                    this.screenTransition();
                    this.fP = 0;
                    this.setScreenType(ScreenType.MAP);
                    this.screenLoadState = -1;
                    this.eE[1] = false;
                    return var1;
                }
            } else if (this.eE[2]) {
                this.scrollOffset[0] = this.scrollOffset[0] * 2 + 1;
                this.ei[0] = this.ei[0] * 2 + 1;
                if (this.scrollOffset[0] >= this.getWidth()) {
                    this.scrollOffset[0] = this.getWidth();
                    this.ei[0] = this.getHeight();
                    this.scrollOffset[1] /= 2;
                    if (this.scrollOffset[1] >= this.getWidth()) {
                        this.scrollOffset[1] = this.getWidth();
                    }

                    var2 = this.frameCounter;
                    var10002 = var2[0]++;
                    if (this.frameCounter[0] >= this.getLength(cu)) {
                        this.fR[0] = 1;
                        this.dY = 1;
                        this.eE[2] = false;
                        this.frameCounter[0] = 0;
                    }
                }
            }

            if (this.dY == 1) {
                var2 = this.frameCounter;
                var10002 = var2[1]++;
                if (this.frameCounter[1] >= 10) {
                    var2 = this.frameCounter;
                    var10002 = var2[0]++;
                    if (this.frameCounter[0] >= 60) {
                        this.eb = true;
                        this.ed = 1;
                    }
                }
            }
        } else {
            this.eE[5] = true;
            this.isPressEvent = false;
            this.isReleaseEvent = false;
            this.pointerUp = false;
            this.pointerDown = false;
        }

        var1 = true;
        return var1;
    }

    boolean ab() {
        boolean var1 = false;
        FileStream stream = new FileStream();
        if (stream.openRead("SAVE_DATA")) {
            stream.enableMD5();
            //if (!var2.e()) {
            //   var2.f();
            //   this.errorText = "F06";
            //   this.j(4);
            //   this.D = 0;
            //   return var1;
            //}

            int gameVersion = stream.readInt();
            Sound.getInstance().muteBGM(stream.readBoolean());
            Sound.getInstance().muteSE(stream.readBoolean());
            if (gameVersion == 0 || gameVersion == 1) {
                this.catfood = stream.readInt();
                this.currentEnergy = stream.readInt();

                int var4;
                for (var4 = 0; var4 < this.getLength(this.years); ++var4) {
                    this.years[var4] = stream.readInt();
                }

                for (var4 = 0; var4 < this.getLength(this.months); ++var4) {
                    this.months[var4] = stream.readInt();
                }

                for (var4 = 0; var4 < this.getLength(this.days); ++var4) {
                    this.days[var4] = stream.readInt();
                }

                this.aQ = stream.readDouble();
                this.hour = stream.readInt();
                this.minute = stream.readInt();
                this.second = stream.readInt();
                this.aU = stream.readInt();
                this.aV = stream.readInt();
                this.aW = stream.readInt();
                this.aX = stream.readInt();
                this.xp = stream.readInt();
                this.aZ = stream.readInt();
                this.ba = stream.readInt();
                this.bb = stream.readInt();

                for (var4 = 0; var4 < this.getLength(this.bc); ++var4) {
                    this.bc[var4] = stream.readInt();
                }

                this.bd = stream.readInt();
                this.be = stream.readInt();
                this.bf = stream.readInt();
                this.u = stream.readBoolean();
                this.bg = stream.readInt();
                this.bh = stream.readInt();
                this.bi = stream.readInt();
                this.bj = stream.readInt();

                for (var4 = 0; var4 < this.getLength(this.slotCatIDs); ++var4) {
                    this.slotCatIDs[var4] = stream.readInt();
                }

                this.currentStamp = stream.readInt();

                for (var4 = 0; var4 < this.getLength(this.stampClaimFlags); ++var4) {
                    this.stampClaimFlags[var4] = stream.readInt();
                }

                this.bn = stream.readInt();
                this.bo = stream.readInt();

                for (var4 = 0; var4 < this.getLength(this.bp); ++var4) {
                    this.bp[var4] = stream.readInt();
                }

                for (var4 = 0; var4 < this.getLength(this.bq); ++var4) {
                    this.bq[var4] = stream.readInt();
                }

                var4 = 0;

                label193:
                while (true) {
                    int var5;
                    if (var4 >= this.getLength(this.br)) {
                        for (var4 = 0; var4 < this.getLength(this.bs); ++var4) {
                            for (var5 = 0; var5 < this.getLength(this.bs[var4]); ++var5) {
                                this.bs[var4][var5] = stream.readInt();
                            }
                        }

                        for (var4 = 0; var4 < this.getLength(this.bt); ++var4) {
                            this.bt[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.bu); ++var4) {
                            this.bu[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.bv); ++var4) {
                            this.bv[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.bw); ++var4) {
                            this.bw[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.baseSpecialSkillLevels); ++var4) {
                            this.baseSpecialSkillLevels[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.by); ++var4) {
                            this.by[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.bz); ++var4) {
                            this.bz[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.battleItems); ++var4) {
                            this.battleItems[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.bB); ++var4) {
                            this.bB[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.bC); ++var4) {
                            this.bC[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.bD); ++var4) {
                            this.bD[var4] = stream.readInt();
                        }

                        for (var4 = 0; var4 < this.getLength(this.bE); ++var4) {
                            this.bE[var4] = stream.readInt();
                        }

                        if (gameVersion < 1) {
                            break;
                        }

                        var4 = 0;

                        while (true) {
                            if (var4 >= this.getLength(this.bF)) {
                                break label193;
                            }

                            this.bF[var4] = stream.readBoolean();
                            ++var4;
                        }
                    }

                    for (var5 = 0; var5 < this.getLength(this.br[var4]); ++var5) {
                        this.br[var4][var5] = stream.readInt();
                    }

                    ++var4;
                }
            }

            stream.close();
        }

        if (!this.ad()) {
            this.D = 0;
        } else {
            var1 = true;
        }

        return var1;
    }

    public synchronized void ac() {
        synchronized (this) {
            byte var1 = 0;
            FileStream var2 = new FileStream();
            if (var2.openWrite("SAVE_DATA")) {
                var2.enableMD5();
                var2.writeInt(1);
                var2.writeBoolean(Sound.getInstance().isMutedBGM());
                var2.writeBoolean(Sound.getInstance().isMutedSE());
                var2.writeInt(this.catfood);
                var2.writeInt(this.currentEnergy);

                int var3;
                for (var3 = 0; var3 < this.getLength(this.years); ++var3) {
                    var2.writeInt(this.years[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.months); ++var3) {
                    var2.writeInt(this.months[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.days); ++var3) {
                    var2.writeInt(this.days[var3]);
                }

                var2.writeDouble(this.aQ);
                var2.writeInt(this.hour);
                var2.writeInt(this.minute);
                var2.writeInt(this.second);
                var2.writeInt(this.aU);
                var2.writeInt(this.aV);
                var2.writeInt(this.aW);
                var2.writeInt(this.aX);
                var2.writeInt(this.xp);
                var2.writeInt(this.aZ);
                var2.writeInt(this.ba);
                var2.writeInt(this.bb);

                for (var3 = 0; var3 < this.getLength(this.bc); ++var3) {
                    var2.writeInt(this.bc[var3]);
                }

                var2.writeInt(this.bd);
                var2.writeInt(this.be);
                var2.writeInt(this.bf);
                var2.writeBoolean(this.u);
                var2.writeInt(this.bg);
                var2.writeInt(this.bh);
                var2.writeInt(this.bi);
                var2.writeInt(this.bj);

                for (var3 = 0; var3 < this.getLength(this.slotCatIDs); ++var3) {
                    var2.writeInt(this.slotCatIDs[var3]);
                }

                var2.writeInt(this.currentStamp);

                for (var3 = 0; var3 < this.getLength(this.stampClaimFlags); ++var3) {
                    var2.writeInt(this.stampClaimFlags[var3]);
                }

                var2.writeInt(this.bn);
                var2.writeInt(this.bo);

                for (var3 = 0; var3 < this.getLength(this.bp); ++var3) {
                    var2.writeInt(this.bp[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.bq); ++var3) {
                    var2.writeInt(this.bq[var3]);
                }

                int var4;
                for (var3 = 0; var3 < this.getLength(this.br); ++var3) {
                    for (var4 = 0; var4 < this.getLength(this.br[var3]); ++var4) {
                        var2.writeInt(this.br[var3][var4]);
                    }
                }

                for (var3 = 0; var3 < this.getLength(this.bs); ++var3) {
                    for (var4 = 0; var4 < this.getLength(this.bs[var3]); ++var4) {
                        var2.writeInt(this.bs[var3][var4]);
                    }
                }

                for (var3 = 0; var3 < this.getLength(this.bt); ++var3) {
                    var2.writeInt(this.bt[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.bu); ++var3) {
                    var2.writeInt(this.bu[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.bv); ++var3) {
                    var2.writeInt(this.bv[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.bw); ++var3) {
                    var2.writeInt(this.bw[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.baseSpecialSkillLevels); ++var3) {
                    var2.writeInt(this.baseSpecialSkillLevels[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.by); ++var3) {
                    var2.writeInt(this.by[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.bz); ++var3) {
                    var2.writeInt(this.bz[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.battleItems); ++var3) {
                    var2.writeInt(this.battleItems[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.bB); ++var3) {
                    var2.writeInt(this.bB[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.bC); ++var3) {
                    var2.writeInt(this.bC[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.bD); ++var3) {
                    var2.writeInt(this.bD[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.bE); ++var3) {
                    var2.writeInt(this.bE[var3]);
                }

                for (var3 = var1; var3 < this.getLength(this.bF); ++var3) {
                    var2.writeBoolean(this.bF[var3]);
                }

                var2.close();
            }

            this.ae();
        }
    }

    boolean ad() {
        boolean var1 = false;
        byte var2 = 0;
        FileStream var3 = new FileStream();
        if (var3.openRead("SAVE_DATA2")) {
            var3.enableMD5();
            //if (!var3.e()) {
            //   this.errorText = "F07";
            //   this.j(4);
            //   this.D = 0;
            //   var3.f();
            //   return var1;
            //}

            if (var3.readInt() == 0) {
                int var4;
                for (var4 = 0; var4 < this.getLength(this.ht); ++var4) {
                    this.ht[var4] = var3.readInt();
                }

                for (var4 = 0; var4 < this.getLength(this.hu); ++var4) {
                    this.hu[var4] = var3.readInt();
                }

                this.hv = var3.readInt();

                for (var4 = 0; var4 < this.getLength(this.hw); ++var4) {
                    this.hw[var4] = var3.readInt();
                }

                for (var4 = 0; var4 < this.getLength(this.hx); ++var4) {
                    this.hx[var4] = var3.readInt();
                }

                this.hy = var3.readInt();
                this.hz = var3.readInt();
                this.hA = var3.readInt();
                this.hB = var3.readInt();

                for (var4 = 0; var4 < this.getLength(this.hC); ++var4) {
                    this.hC[var4] = var3.readInt();
                }

                for (var4 = 0; var4 < this.getLength(this.hD); ++var4) {
                    this.hD[var4] = var3.readInt();
                }

                for (var4 = var2; var4 < this.getLength(this.hE); ++var4) {
                    this.hE[var4] = var3.readInt();
                }

                this.hF = var3.readInt();
                this.hG = var3.readInt();
            }

            var3.close();
        }

        var1 = true;
        return var1;
    }

    public synchronized void ae() {
        synchronized (this) {
            byte var1 = 0;
            FileStream var2 = new FileStream();
            if (var2.openWrite("SAVE_DATA2")) {
                var2.enableMD5();
                var2.writeInt(0);

                int var3;
                for (var3 = 0; var3 < this.getLength(this.ht); ++var3) {
                    var2.writeInt(this.ht[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.hu); ++var3) {
                    var2.writeInt(this.hu[var3]);
                }

                var2.writeInt(this.hv);

                for (var3 = 0; var3 < this.getLength(this.hw); ++var3) {
                    var2.writeInt(this.hw[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.hx); ++var3) {
                    var2.writeInt(this.hx[var3]);
                }

                var2.writeInt(this.hy);
                var2.writeInt(this.hz);
                var2.writeInt(this.hA);
                var2.writeInt(this.hB);

                for (var3 = 0; var3 < this.getLength(this.hC); ++var3) {
                    var2.writeInt(this.hC[var3]);
                }

                for (var3 = 0; var3 < this.getLength(this.hD); ++var3) {
                    var2.writeInt(this.hD[var3]);
                }

                for (var3 = var1; var3 < this.getLength(this.hE); ++var3) {
                    var2.writeInt(this.hE[var3]);
                }

                var2.writeInt(this.hF);
                var2.writeInt(this.hG);
                var2.close();
            }

        }
    }

    public void onRestart() {
    }

    public boolean isTouching(int x, int y, int width, int height) {
        boolean isTouching;
        if (this.getCurrentX() >= x && this.getCurrentX() <= width + x && this.getCurrentY() >= y && this.getCurrentY() <= height + y) {
            isTouching = true;
        } else {
            isTouching = false;
        }

        return isTouching;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    boolean d(int var1, int var2, int var3, int var4, int var5, int var6) {
        boolean var7;
        if ((var1 - var4) * (var1 - var4) + (var2 - var5) * (var2 - var5) <= (var3 + var6) * (var3 + var6)) {
            var7 = true;
        } else {
            var7 = false;
        }

        return var7;
    }

    public void onProcess() {
    }

    public void screenTransition() {
    }

    void loadStageStats(int stageID) {
        //if (!jp.co.ponos.library.b.aa.equals(jp.co.ponos.library.b.stream.b.d(aString.format("stage%02d.csv", stageID)), (new String[]{"345b93370a81c18c3e1ca485064c8105", "7eeb12db6cf61e975062554f2c2d5c47", "fbae56844862035ecac67dd840b163fe", "94519b25bf5f93710325a5f8ab0f0ec4", "3d0ca160ebad6570d113a7885259daf4", "385e19a0e69d5f11fc54e768f3de1d59", "386921150764335e057e770852656c60", "f72af96ebba61a4b5bb95b93c55c797c", "7a3eab28e914ddb5c5a7f7340d766079", "b8f2d0edc156bbb3eb184fd14e5cce52", "d88a1db9e289697124393a5361b410ca", "adc6425e4106bff2184ad1942da28765", "1aeddcbb0d534bb231ffdf60862d17f4", "54993a929642e6382ab479a7e6f96c8c", "0756993b94f5dcc37b5addaf3b3ae71f", "312987a22171ab38999b36dda3e43b37", "fd4267af7dd24ca6e33fea3eaebf3a3f", "d9fabf55cea824cf5cce990b55de3be7", "845beeee5c9adbdc21339ca2e8f98281", "cd0000479b0b70c6027886745abb4fe0", "91a863f669ecd4be900532e9fe4cde0d", "e7b42c80357526613831951245fdafdb", "e89c4c39c161560737dd467a9cce9e5e", "3119fd83734e199eade1372402c6d4b5", "e0c58745696c32a8ec03932d38c0e10c", "8213572ce0b7f006155528589a075ca4", "69595179dbf85559b386b69b668340f9", "5a5f04742ef5406fa1282068dd146d42", "53df5ec4d09b4797efcbbcf68f5fcc55", "941e6851b52e48c2b19c96fcb567e55b", "08f0eb6b5a35035569037d5a34eec92f", "efd0471c05bb8c352b45653737a0342c", "d74ced49669c5c93cd1528daf373df6f", "bdae74443acdb58b3d213c19d1994279", "420469b948ad3134999ddba7d11d0f72", "c217325fb3c462ff500f35d5dba8d6dd", "1f923af4c242703437a78ae6fed900a2", "bab2c03bdff10ca11d29317ee08f35e2", "30a1e1225661123fcdcfd2c080618bab", "0e2afa9fea9646dbc070408535687932", "8bc82c0f20d610d0dcb3730d706944e3", "8233d1ede2ca26dfb53fa31feb6c9356", "3dffa6ddaaadd924152cd2c9a101ad73", "1e43ffe66844c8abf330e59c2e3c5351", "727678b0f67daf70c867feab8b6445a2", "a04cc9b171fe4edeac9377f5605d112d", "a440aa434573dd1479e2fbca9b7a4446", "4f1b17f0b6047839cea04800097db840", "3f2cb30ef9b6c82fa5c083febf35d110", "b16cf2453de33589d886e1b39de8635e", "aaa4e070b70806c33d01fe218426a0a3"})[stageID])) {
        //   this.D = 0;
        //   this.errorText = "F05" + aString.format("%02d", Integer.valueOf(stageID));
        //   this.j(4);
        //} else {
        AssetTextStream stream = new AssetTextStream();
        stream.openRead(aString.format("stage%02d.csv", stageID));
        stream.readLine();

        for (stageID = 0; stageID < this.getLength(this.bV); ++stageID) {
            this.bV[stageID] = stream.getInt(stageID);
        }

        int var3;
        for (stageID = 0; stageID < this.getLength(this.bW); ++stageID) {
            stream.readLine();

            for (var3 = 0; var3 < this.getLength(this.bW[stageID]); ++var3) {
                this.bW[stageID][var3] = stream.getInt(var3);
            }
        }

        stream.close();
        this.bV[0] *= 4;

        for (stageID = 0; stageID < this.getLength(this.bW); ++stageID) {
            for (var3 = 0; var3 < this.getLength(this.bW[stageID]); ++var3) {
                if (var3 == 2 || var3 == 3 || var3 == 4) {
                    int[] var4 = this.bW[stageID];
                    var4[var3] *= 2;
                }
            }
        }
        //}

    }

    void setScene(SceneType scene) {
        this.setScene(scene.sceneID);
    }

    void setScene(int sceneID) {
        this.scene = sceneID;
        this.setScene2(sceneID);
        int var2;
        switch (this.getSceneType()) {
            case ERROR:
                MyUtility.getInstance().addButton(MyUtility.getString("err_txt") + "\u3000" + this.errorText);
                Sound.getInstance().stop(SoundType.ALL);
                break;
            case OPENING:
                //jp.co.ponos.library.a.a.b().f();

                for (sceneID = 0; sceneID < this.getLength(this.shouldPlayButtonSelect); ++sceneID) {
                    this.shouldPlayButtonSelect[sceneID] = false;
                }

                for (sceneID = 0; sceneID < this.getLength(this.buttonCoordinates1); ++sceneID) {
                    for (var2 = 0; var2 < this.getLength(this.buttonCoordinates1[sceneID]); ++var2) {
                        this.buttonCoordinates1[sceneID][var2] = 0;
                    }
                }

                for (sceneID = 0; sceneID < this.getLength(this.textTextures); ++sceneID) {
                    if (this.textTextures[sceneID].isLoaded()) {
                        this.textTextures[sceneID].reset();
                    }
                }

                for (sceneID = 0; sceneID < this.getLength(this.openingText); ++sceneID) {
                    if (!this.textTextures[sceneID].isLoaded()) {
                        if (this.versionCode == 0) {
                            if (sceneID == 0) {
                                this.textTextures[sceneID].loadText(aString.format("%d%s", this.fv, this.openingText[sceneID]), "FONT_SYSTEM_BOLD", 30, 1);
                            } else {
                                this.textTextures[sceneID].loadText(this.openingText[sceneID], "FONT_SYSTEM_BOLD", 30, 1);
                            }
                        } else if (this.versionCode == 1) {
                            if (sceneID == 2) {
                                String var3 = aString.format(this.openingText[sceneID], this.fv);
                                this.textTextures[sceneID].loadText(aString.format("%s", var3), "FONT_SYSTEM_BOLD", 30, 1);
                            } else {
                                this.textTextures[sceneID].loadText(this.openingText[sceneID], "FONT_SYSTEM_BOLD", 30, 1);
                            }
                        }
                    }
                }

                for (sceneID = 0; sceneID < this.getLength(this.dw); ++sceneID) {
                    this.dw[sceneID] = 0;
                }

                this.dy = 0;
                this.dz = 0;
                this.dA = 0;

                for (sceneID = 0; sceneID < 50; ++sceneID) {
                    for (var2 = 0; var2 < 8; ++var2) {
                        if (var2 == 0) {
                            this.cg[sceneID][0][var2] = (sceneID * 48 + aMath.rand(48) % this.getWidth()) * 100;
                            this.cg[sceneID][1][var2] = (aMath.rand(50) + 640) * 100;
                        } else {
                            this.cg[sceneID][0][var2] = this.cg[sceneID][0][0];
                            this.cg[sceneID][1][var2] = this.cg[sceneID][1][0];
                        }
                    }

                    this.ci[sceneID][0] = 0;
                    this.ci[sceneID][1] = (aMath.rand(50) + 3) * 10;
                    this.ci[sceneID][2] = (aMath.rand(15) + 3) * 100;
                    this.ci[sceneID][3] = aMath.rand(8) + 1;
                }

                for (sceneID = 0; sceneID < this.getLength(this.buttonCoordinates1); ++sceneID) {
                    for (var2 = 0; var2 < this.getLength(this.buttonCoordinates1[sceneID]); ++var2) {
                        this.buttonCoordinates1[sceneID][var2] = 0;
                    }
                }

                this.buttonCoordinates1[0][0] = this.excessWidth + 788;
                this.buttonCoordinates1[0][1] = this.eZ + 556;
                this.buttonCoordinates1[0][2] = 168;
                this.buttonCoordinates1[0][3] = 88;
                this.screenLoadState = -1;
                this.setScreenType(ScreenType.TITLE);

                for (sceneID = 0; sceneID < this.getLength(this.frameCounter); ++sceneID) {
                    this.frameCounter[sceneID] = 0;
                }

                for (sceneID = 0; sceneID < this.getLength(this.fx); ++sceneID) {
                    this.fx[sceneID] = 0;
                }

                for (sceneID = 0; sceneID < this.getLength(this.uiTextures); ++sceneID) {
                    if (this.uiTextures[sceneID].isLoaded()) {
                        this.uiTextures[sceneID].reset();
                    }
                }

                this.resetTextures();
                if (!this.ao[0].isLoaded()) {
                    this.ao[0].reset();
                }

                if (!this.ao[0].isLoaded()) {
                    this.ao[0].load(MyUtility.getString(aString.format("img%03d.png", 13)), MyUtility.getString(aString.format("000_img%03d.imgcut", 13)));
                }

                this.ap[0].load(MyUtility.getString(aString.format("opening.mamodel")));
                this.aq[0].load(MyUtility.getString(aString.format("opening.maanim")));
                this.ap[0].setTextures(this.ao);
                this.ap[0].setAction();
                if (!this.uiTextures[2].isLoaded()) {
                    this.uiTextures[2].reset();
                }

                if (!this.uiTextures[2].isLoaded()) {
                    this.uiTextures[2].load(MyUtility.getString(aString.format("img%03d.png", 6)), MyUtility.getString(aString.format("img%03d.imgcut", 6)));
                }

                this.z = 10000;
                Sound.getInstance().stop(SoundType.ALL);
                Sound.getInstance().play(SoundType.OPENING);
                break;
            case ENDING:
                //jp.co.ponos.library.a.a.b().f();

                for (sceneID = 0; sceneID < this.getLength(this.shouldPlayButtonSelect); ++sceneID) {
                    this.shouldPlayButtonSelect[sceneID] = false;
                }

                for (sceneID = 0; sceneID < this.getLength(this.textTextures); ++sceneID) {
                    if (this.textTextures[sceneID].isLoaded()) {
                        this.textTextures[sceneID].reset();
                    }
                }

                for (sceneID = 0; sceneID < this.getLength(this.endingText); ++sceneID) {
                    if (!this.textTextures[sceneID].isLoaded()) {
                        this.textTextures[sceneID].loadText(this.endingText[sceneID], "FONT_SYSTEM_BOLD", 30, 1);
                    }
                }

                for (sceneID = 0; sceneID < this.getLength(this.frameCounter); ++sceneID) {
                    this.frameCounter[sceneID] = 0;
                }

                for (sceneID = 0; sceneID < this.getLength(this.fx); ++sceneID) {
                    this.fx[sceneID] = 0;
                }

                for (sceneID = 0; sceneID < this.getLength(this.eE); ++sceneID) {
                    this.eE[sceneID] = false;
                }

                for (sceneID = 0; sceneID < 50; ++sceneID) {
                    for (var2 = 0; var2 < 8; ++var2) {
                        if (var2 == 0) {
                            this.cg[sceneID][0][var2] = (sceneID * 48 + aMath.rand(48) % this.getWidth()) * 100;
                            this.cg[sceneID][1][var2] = (aMath.rand(50) + 640) * 100;
                        } else {
                            this.cg[sceneID][0][var2] = this.cg[sceneID][0][0];
                            this.cg[sceneID][1][var2] = this.cg[sceneID][1][0];
                        }
                    }

                    this.ci[sceneID][0] = 0;
                    this.ci[sceneID][1] = (aMath.rand(50) + 3) * 10;
                    this.ci[sceneID][2] = (aMath.rand(15) + 3) * 100;
                    this.ci[sceneID][3] = aMath.rand(8) + 1;
                }

                for (sceneID = 0; sceneID < this.getLength(this.uiTextures); ++sceneID) {
                    if (this.uiTextures[sceneID].isLoaded()) {
                        this.uiTextures[sceneID].reset();
                    }
                }

                this.resetTextures();
                if (this.uiTextures[0].isLoaded()) {
                    this.uiTextures[0].reset();
                }

                if (!this.uiTextures[0].isLoaded()) {
                    this.uiTextures[0].load(MyUtility.getString(aString.format("img%03d.png", 35)), MyUtility.getString(aString.format("img%03d.imgcut", 35)));
                }

                if (this.uiTextures[1].isLoaded()) {
                    this.uiTextures[1].reset();
                }

                if (!this.uiTextures[1].isLoaded()) {
                    this.uiTextures[1].load(MyUtility.getString(aString.format("img%03d.png", 7)), MyUtility.getString(aString.format("img%03d.imgcut", 7)));
                }

                if (this.uiTextures[2].isLoaded()) {
                    this.uiTextures[2].reset();
                }

                if (!this.uiTextures[2].isLoaded()) {
                    this.uiTextures[2].load(MyUtility.getString(aString.format("img%03d.png", 6)), MyUtility.getString(aString.format("img%03d.imgcut", 6)));
                }

                if (this.uiTextures[3].isLoaded()) {
                    this.uiTextures[3].reset();
                }

                if (!this.uiTextures[3].isLoaded()) {
                    this.uiTextures[3].load(MyUtility.getString(aString.format("img%03d.png", 36)), MyUtility.getString(aString.format("img%03d.imgcut", 36)));
                }

                this.dE = 0;
                this.dF = 0;
                this.dG = 0;
                this.screenLoadState = -1;
                this.setScreenType(ScreenType.TITLE);
                this.buttonCoordinates1[0][0] = this.excessWidth + 788;
                this.buttonCoordinates1[0][1] = this.eZ + 556;
                this.buttonCoordinates1[0][2] = 168;
                this.buttonCoordinates1[0][3] = 88;
                this.z = 10000;
                Sound.getInstance().stop(SoundType.ALL);
                Sound.getInstance().play(SoundType.ENDING);
                break;
            case MAIN:
                for (sceneID = 0; sceneID < this.getLength(this.shouldPlayButtonSelect); ++sceneID) {
                    this.shouldPlayButtonSelect[sceneID] = false;
                }

                for (sceneID = 0; sceneID < this.getLength(this.deployedUnits); ++sceneID) {
                    for (var2 = 0; var2 < this.getLength(this.deployedUnits[sceneID]); ++var2) {
                        for (int var4 = 0; var4 < this.getLength(this.deployedUnits[sceneID][var2]); ++var4) {
                            this.deployedUnits[sceneID][var2][var4] = 0;
                        }
                    }
                }

                for (sceneID = 0; sceneID < this.getLength(this.buttonCoordinates1); ++sceneID) {
                    for (var2 = 0; var2 < this.getLength(this.buttonCoordinates1[sceneID]); ++var2) {
                        this.buttonCoordinates1[sceneID][var2] = 0;
                    }
                }

                this.z = 10000;
                break;
            case BATTLE:
                this.V();
        }

    }

    void setScene2(int sceneID) {
        this.scene2 = sceneID;
    }

    void setScene2(SceneType scene) {
        this.scene2 = scene.sceneID;
    }

    void map2Draw(TextureRenderer var1) {
        var1.drawScaledImageI(this.uiTextures[6], 0, 42, 0);
        var1.setColor(0, 0, 0);
        int var2;
        int var3;
        if (this.eE[2]) {
            var2 = this.scrollOffset[0];
            var3 = var2;
            if (var2 >= 63) {
                var3 = 63;
            }
        } else {
            var3 = 0;
        }

        int var4;
        int var7;
        int var9;
        if (this.dY == 0) {
            var1.setAlpha(63 - var3);
            var1.drawRectangle(0, 367, this.getWidth(), 190);
            var1.drawScaledImageI(this.uiTextures[6], 0 - this.scrollOffset[0], 79, 1);
            var1.drawScaledImageI(this.uiTextures[6], 0 - this.scrollOffset[0], 66, 2);
            var1.drawScaledImageI(this.uiTextures[6], 0 - this.scrollOffset[0], 352, 3);
            var1.drawScaledImageI(this.uiTextures[6], this.scrollOffset[0] + 748, 85, 4);
            var1.drawScaledImageI(this.uiTextures[6], this.scrollOffset[0] + 733, 60, 5);
            var1.drawScaledImageI(this.uiTextures[6], this.scrollOffset[0] + 748, 277, 6);
            var1.drawScaledImageI(this.uiTextures[6], this.scrollOffset[0] + 733, 252, 7);
            if (!this.eE[2]) {
                var1.drawScaledImageI(this.uiTextures[6], 633 - dv[this.fx[0]] / 2, 494 - dv[this.fx[0]] / 2, dv[this.fx[0]] + 304, dv[this.fx[0]] + 74, 21);
                var1.drawScaledImageI(this.uiTextures[6], 671 - dv[this.fx[0]] / 2, 500 - dv[this.fx[0]] / 2, dv[this.fx[0]] + 231, dv[this.fx[0]] + 62, 22);
            }

            var3 = 0;

            for (var2 = 0; var2 < 10; ++var2) {
                if (this.slotCatIDs[var2] != -1) {
                    var1.drawScaledImageI(this.ak[var2], var2 % 5 * 121 + 111 - this.scrollOffset[0], var2 / 5 * 119 + 134, 110, 85, 0);
                    if (this.bv[this.slotCatIDs[var2] - 2] + 1 >= this.bi) {
                        var1.drawScaledImageI(this.uiTextures[6], var2 % 5 * 121 + 176 - this.scrollOffset[0], var2 / 5 * 119 + 109, 18);
                    } else {
                        var3 = this.bv[this.slotCatIDs[var2] - 2] + 1;
                        var9 = 0;

                        do {
                            var1.drawScaledImageI(this.uiTextures[6], 206 - var9 * 12 + var2 % 5 * 121 - this.scrollOffset[0], var2 / 5 * 119 + 109, var3 % 10 + 8);
                            var4 = var3 / 10;
                            ++var9;
                            var3 = var4;
                        } while (var4 > 0);

                        var3 = var4;
                    }
                }
            }

            short var11 = 0;

            for (var4 = 0; var4 < 9; ++var4) {
                if (var4 == 0) {
                    var11 = 108;
                    var3 = this.baseSpecialSkillLevels[0] + 1;
                    this.eH[0] = this.bi;
                } else if (var4 == 1) {
                    var11 = 140;
                    var3 = this.baseSpecialSkillLevels[2] + 1;
                    this.eH[0] = 10;
                } else if (var4 == 2) {
                    var11 = 172;
                    var3 = this.baseSpecialSkillLevels[3] + 1;
                    this.eH[0] = this.bi;
                } else if (var4 == 3) {
                    var11 = 298;
                    var3 = this.baseSpecialSkillLevels[4] + 1;
                    this.eH[0] = this.bi;
                } else if (var4 == 4) {
                    var11 = 330;
                    var3 = this.baseSpecialSkillLevels[5] + 1;
                    this.eH[0] = this.bi;
                } else if (var4 == 5) {
                    var11 = 204;
                    var3 = this.baseSpecialSkillLevels[6] + 1;
                    this.eH[0] = this.bi;
                } else if (var4 == 6) {
                    var11 = 362;
                    var3 = this.baseSpecialSkillLevels[7] + 1;
                    this.eH[0] = this.bi;
                } else if (var4 == 7) {
                    var11 = 394;
                    var3 = this.baseSpecialSkillLevels[8] + 1;
                    this.eH[0] = this.bi;
                } else if (var4 == 8) {
                    var11 = 426;
                    var3 = this.baseSpecialSkillLevels[9] + 1;
                    this.eH[0] = this.bi;
                }

                if (var3 >= this.eH[0]) {
                    var1.drawScaledImageI(this.uiTextures[6], this.scrollOffset[0] + 889, var11, 18);
                } else {
                    var7 = 0;

                    do {
                        var1.drawScaledImageI(this.uiTextures[6], 919 - var7 * 12 + this.scrollOffset[0], var11, var3 % 10 + 8);
                        var9 = var3 / 10;
                        ++var7;
                        var3 = var9;
                    } while (var9 > 0);

                    var3 = var9;
                }
            }
        }

        if (this.eE[2] || this.dY >= 1) {
            var1.setColor(0, 0, 0);
            var1.setAlpha(63);
            var1.drawRectangle(this.scrollOffset[1] + 0, 487, this.getWidth(), 56);
            var1.drawScaledImage(this.uiTextures[7], (float) (0 - this.scrollOffset[1]), 492.0F, 224.0F, 45.0F, cm[this.dH]);
        }

        label203:
        {
            var1.drawScaledImageI(this.af[0], 0 - this.fP - 88, 0, 572, 637, 0);
            var1.drawScaledImageI(this.af[0], this.fP + 572 - 88, 0, 572, 637, 1);
            if (this.dY == 0) {
                if (this.fR[0] == 0) {
                    var3 = cu[this.frameCounter[0]];
                    break label203;
                }

                if (this.fR[0] == 1) {
                    var3 = cv[this.frameCounter[0]];
                    break label203;
                }

                var3 = this.fR[0];
            }

            var3 = 0;
        }

        if (this.dY == 1) {
            short var12 = 312;
            if (this.frameCounter[0] == 2 || this.frameCounter[0] == 3 || this.frameCounter[0] == 6 || this.frameCounter[0] == 7 || this.frameCounter[0] == 10 || this.frameCounter[0] == 11 || this.frameCounter[0] == 14 || this.frameCounter[0] == 15 || this.frameCounter[0] == 18 || this.frameCounter[0] == 19) {
                var12 = 308;
            }

            var1.drawScaledImageI(this.uiTextures[1], 659, var12, 355, 355, 0);
            if (this.frameCounter[0] >= 2) {
                if (this.frameCounter[0] - 2 == 0) {
                    var1.drawScaledImageI(this.uiTextures[8], -28, -1, 504, 504, 0);
                } else if (this.frameCounter[0] - 2 == 1) {
                    var1.drawScaledImageI(this.uiTextures[8], 35, 62, 378, 378, 0);
                } else if (this.frameCounter[0] - 2 == 2) {
                    var1.drawScaledImageI(this.uiTextures[8], 98, 125, 252, 252, 0);
                } else if (this.frameCounter[0] - 2 >= 3) {
                    var1.drawScaledImageI(this.uiTextures[8], 161, 188, 126, 126, 0);
                }
            }

            if (this.frameCounter[0] >= 6) {
                if (this.frameCounter[0] - 6 == 0) {
                    var1.drawScaledImageI(this.uiTextures[8], 100, -1, 504, 504, 1);
                } else if (this.frameCounter[0] - 6 == 1) {
                    var1.drawScaledImageI(this.uiTextures[8], 163, 62, 378, 378, 1);
                } else if (this.frameCounter[0] - 6 == 2) {
                    var1.drawScaledImageI(this.uiTextures[8], 226, 125, 252, 252, 1);
                } else if (this.frameCounter[0] - 6 >= 3) {
                    var1.drawScaledImageI(this.uiTextures[8], 289, 188, 126, 126, 1);
                }
            }

            if (this.frameCounter[0] >= 10) {
                if (this.frameCounter[0] - 2 == 0) {
                    var1.drawScaledImageI(this.uiTextures[8], 228, -1, 504, 504, 2);
                } else if (this.frameCounter[0] - 10 == 1) {
                    var1.drawScaledImageI(this.uiTextures[8], 291, 62, 378, 378, 2);
                } else if (this.frameCounter[0] - 10 == 2) {
                    var1.drawScaledImageI(this.uiTextures[8], 354, 125, 252, 252, 2);
                } else if (this.frameCounter[0] - 10 >= 3) {
                    var1.drawScaledImageI(this.uiTextures[8], 417, 188, 126, 126, 2);
                }
            }

            if (this.frameCounter[0] >= 14) {
                if (this.frameCounter[0] - 14 == 0) {
                    var1.drawScaledImageI(this.uiTextures[8], 356, -1, 504, 504, 3);
                } else if (this.frameCounter[0] - 14 == 1) {
                    var1.drawScaledImageI(this.uiTextures[8], 419, 62, 378, 378, 3);
                } else if (this.frameCounter[0] - 14 == 2) {
                    var1.drawScaledImageI(this.uiTextures[8], 482, 125, 252, 252, 3);
                } else if (this.frameCounter[0] - 14 >= 3) {
                    var1.drawScaledImageI(this.uiTextures[8], 545, 188, 126, 126, 3);
                }
            }

            if (this.frameCounter[0] >= 18) {
                if (this.frameCounter[0] - 18 == 0) {
                    var1.drawScaledImageI(this.uiTextures[8], 484, -1, 504, 504, 4);
                } else if (this.frameCounter[0] - 18 == 1) {
                    var1.drawScaledImageI(this.uiTextures[8], 547, 62, 378, 378, 4);
                } else if (this.frameCounter[0] - 18 == 2) {
                    var1.drawScaledImageI(this.uiTextures[8], 610, 125, 252, 252, 4);
                } else if (this.frameCounter[0] - 18 >= 3) {
                    var1.drawScaledImageI(this.uiTextures[8], 673, 188, 126, 126, 4);
                }
            }
        } else {
            var1.drawScaledImageI(this.uiTextures[1], 659, var3, 355, 355, 0);
            if (this.frameCounter[1] == 1 || this.frameCounter[1] == 2 || this.frameCounter[1] == 4 || this.frameCounter[1] == 5) {
                var1.drawScaledImageI(this.uiTextures[1], 659, var3, 355, 191, 2);
            }
        }

        var1.drawScaledImageI(this.uiTextures[2], 0, -42, 10);
        var1.drawScaledImageI(this.uiTextures[2], 0, 638, 10);
        var1.drawScaledImageI(this.uiTextures[2], 0, 0, 0);
        var1.setImageOrientation(2);
        var1.drawScaledImageI(this.uiTextures[2], 0, 585, 0);
        var1.setImageOrientation(0);
        if (this.gm[0] < 297) {
            var1.drawScaledImageI(this.uiTextures[2], 8 - this.gm[0], 3, 6);
        }

        if (this.gm[1] < 297) {
            var1.drawScaledImageI(this.uiTextures[2], 8 - this.gm[1] - this.scrollOffset[0], 3, 7);
        }

        Texture var5 = this.uiTextures[0];
        int var6 = this.buttonCoordinates1[5][0];
        var4 = dv[this.fx[5]] / 2;
        var2 = this.buttonCoordinates1[5][1];
        var7 = dv[this.fx[5]] / 2;
        var3 = this.ei[0];
        int var8 = this.buttonCoordinates1[5][2];
        var9 = dv[this.fx[5]];
        int var10 = this.buttonCoordinates1[5][3];
        var1.drawScaledImageI(var5, var6 - var4, var3 + (var2 - var7), var9 + var8, dv[this.fx[5]] + var10, 9);
        var5 = this.uiTextures[0];
        var9 = this.buttonCoordinates1[5][0];
        var4 = dv[this.fx[5]] / 2;
        var2 = this.buttonCoordinates1[5][1];
        var3 = dv[this.fx[5]] / 2;
        var1.drawScaledImageI(var5, var9 + 4 - var4, this.ei[0] + (var2 + 17 - var3), dv[this.fx[5]] + 84, dv[this.fx[5]] + 60, 3);
        var1.drawScaledImageI(this.uiTextures[5], this.scrollOffset[0] + 670, 0, 11);
        var1.drawScaledImageI(this.uiTextures[5], this.scrollOffset[0] + 608, 7, 10);
        var3 = this.xp;
        var2 = 0;

        do {
            var1.drawScaledImageI(this.uiTextures[5], 924 - var2 * 29 + this.scrollOffset[0], 6, var3 % 10);
            var4 = var3 / 10;
            ++var2;
            var3 = var4;
        } while (var4 > 0);

    }
}
