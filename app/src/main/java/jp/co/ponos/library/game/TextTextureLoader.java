package jp.co.ponos.library.game;

public class TextTextureLoader extends TextureLoader {
    String text;
    String font;
    int fontSize;
    int textMode;
    int width;
    int height;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextTextureLoader(String text, String font, int fontSize, int textMode, int width, int height) {
        this.text = text;
        this.font = font;
        this.fontSize = fontSize;
        this.textMode = textMode;
        this.width = width;
        this.height = height;
    }
}
