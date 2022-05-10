package net.thewinnt.meme;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

/** Some utility functions for easier text drawing */
public class FontUtils {
    /**
     * Centers the text around some x coordinate
     * @param x The center coordinate
     * @param font The font that the text uses
     * @param text The text itself
     * @return The coodinate to place the text at
     */
    public static int centerTextX(float x, BitmapFont font, String text) {
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text);
        return (int) (x - layout.width / 2);
    }

    /**
     * Centers the text around some y coordinate
     * @param y The center coordinate
     * @param font The font that the text uses
     * @param text The text itself
     * @return The coodinate to place the text at
     */
    public static int centerTextY(float y, BitmapFont font, String text) {
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text);
        return (int) (y + layout.height / 2);
    }

    /**
     * Draws some text centered at a specific coordinate
     * @param font The font to use
     * @param batch The batch to draw the text at
     * @param text The text to draw
     * @param x The x-coordinate of the center point
     * @param y The y-coordinate of the center point
     */
    public static void drawCenteredText(BitmapFont font, Batch batch, String text, float x, float y) {
        font.draw(batch, text, centerTextX(x, font, text), centerTextY(y, font, text));
    }

    /**
     * Draws some text centered at a specific coordinate and scaled by some factor
     * @param font The font to use
     * @param batch The batch to draw the text at
     * @param text The text to draw
     * @param x The x-coordinate of the center point
     * @param y The y-coordinate of the center point
     * @param scale The scale of the text
     */
    public static void drawScaledCenteredText(BitmapFont font, Batch batch, String text, float x, float y, float scale) {
        float old_scale_x = font.getData().scaleX;
        float old_scale_y = font.getData().scaleY;
        font.getData().setScale(scale);
        font.draw(batch, text, centerTextX(x, font, text), centerTextY(y, font, text));
        font.getData().setScale(old_scale_x, old_scale_y);
    }
}
