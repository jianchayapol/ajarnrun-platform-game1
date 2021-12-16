package sharedObject;

import java.lang.reflect.Field;

import javafx.scene.media.AudioClip;

public class AudioLoader {

	public static AudioClip Mouse_Click = new AudioClip(
			ClassLoader.getSystemResource("audio/mouse_click2.wav").toString());
	public static AudioClip Mouse_Click1 = new AudioClip(
			ClassLoader.getSystemResource("audio/mouse_click.mp3").toString());
	public static AudioClip Winning_Coin_Sound = new AudioClip(
			ClassLoader.getSystemResource("audio/winning-coin.wav").toString());
	public static AudioClip Jumping_Sound = new AudioClip(
			ClassLoader.getSystemResource("audio/jumping.wav").toString());
	public static AudioClip Pick_Up_Item_Sound = new AudioClip(
			ClassLoader.getSystemResource("audio/picking-up-item.wav").toString());
	public static AudioClip Entrance_Theme_Song = new AudioClip(
			ClassLoader.getSystemResource("audio/entrance_music.mp3").toString());
	public static AudioClip Game_Theme_Song = new AudioClip(ClassLoader.getSystemResource("audio/game.mp3").toString());
}