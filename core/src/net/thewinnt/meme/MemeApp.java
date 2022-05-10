package net.thewinnt.meme;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.ScreenUtils;

public class MemeApp extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	FreeTypeFontGenerator gen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("meme_bg.jpg");  // load the background
		// load the font
		gen = new FreeTypeFontGenerator(Gdx.files.internal("segoeui.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter(); 
		parameter.size = 28;
		parameter.color = Color.BLACK;
		font = gen.generateFont(parameter);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0, 500, 500);  // draw the background
		// draw the text
		FontUtils.drawCenteredText(font, batch, "Making a meme\nwith Photoshop", 375, 375);
		FontUtils.drawCenteredText(font, batch, "Making a meme\nwith code", 375, 125);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		gen.dispose();
		font.dispose();
	}
}
