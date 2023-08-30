package jp.co.ponos.library.game;

import java.util.ArrayList;

public class TexturesLoader {
    static TexturesLoader texturesLoader;
    ArrayList textures = new ArrayList();

    TexturesLoader() {
    }

    public static void createInstance() {
        texturesLoader = new TexturesLoader();
    }

    public static TexturesLoader getInstance() {
        return texturesLoader;
    }

    public ArrayList getTextures() {
        return this.textures;
    }
}
