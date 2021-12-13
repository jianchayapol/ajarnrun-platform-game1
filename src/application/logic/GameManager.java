package application.logic;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import logic.level.Level;
import player.Player;
import sharedObject.RenderableHolder;
import view.ViewManager;

public class GameManager {
	public static HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
	private static ArrayList<Node> platforms = new ArrayList<Node>();
	private static Player player;
	private static boolean canJump;
	private static int levelWidth;
	private static boolean isMute;
	
	private static AnchorPane appRoot = new AnchorPane();
	private static AnchorPane gameRoot = new AnchorPane();
	private static AnchorPane uiRoot = new AnchorPane();
	
	private static final int BLOCK_WIDTH = 60;
	private static final int BLOCK_HEIGHT = 60;
	
	private static int time;
	
	static {
		RenderableHolder.loadResource();
		setLevelWidth();
		setFirstLevelPlatform();
		initializePlayer();
		setCanJump(true);
		setGameRootLayoutX();
		addGameRoot();
		addUIRoot();
		setIsMute(false);
		setTime(0);
		initializeKeysValue();
	}
	
	/* ============================== PRIVATE STATIC METHOD ============================== */
	/* ==================== USE IN CONSTRUCTOR ==================== */
	
	private static void setLevelWidth() {
		levelWidth = Level.LEVEL1[0].length() * BLOCK_WIDTH;
	}
	
	private static void setFirstLevelPlatform() {
		Rectangle background = new Rectangle(ViewManager.getScreenWidth(), ViewManager.getScreenHeight());
		background.setFill(new ImagePattern(RenderableHolder.normalLevelImage));
		for (int i = 0; i < Level.LEVEL1.length; i++) {
			String line = Level.LEVEL1[i];
			for (int j = 0; j < line.length(); j++) {
				ImageView platform;
				switch (line.charAt(j)) {
				case '0':
					break;
				case '1':
					platform = RenderableHolder.createImageViewForPlatform(j * BLOCK_WIDTH, i * BLOCK_HEIGHT, "1");
					gameRoot.getChildren().add(platform);
					platforms.add(platform);
					break;
				case '2':
					platform = RenderableHolder.createImageViewForPlatform(j * BLOCK_WIDTH, i * BLOCK_HEIGHT, "2");
					gameRoot.getChildren().add(platform);
					platforms.add(platform);
					break;
				case '3':
					platform = RenderableHolder.createImageViewForPlatform(j * BLOCK_WIDTH, i * BLOCK_HEIGHT, "3");
					gameRoot.getChildren().add(platform);
					platforms.add(platform);
					break;
				case '4':
					platform = RenderableHolder.createImageViewForPlatform(j * BLOCK_WIDTH, i * BLOCK_HEIGHT, "4");
					gameRoot.getChildren().add(platform);
					platforms.add(platform);
					break;
				case '5':
					platform = RenderableHolder.createImageViewForPlatform(j * BLOCK_WIDTH, i * BLOCK_HEIGHT, "5");
					gameRoot.getChildren().add(platform);
					platforms.add(platform);
					break;
				case 'A':
					platform = RenderableHolder.createImageViewForPlatform(j * BLOCK_WIDTH, i * BLOCK_HEIGHT, "f1");
					gameRoot.getChildren().add(platform);
					platforms.add(platform);
					break;
				case 'B':
					platform = RenderableHolder.createImageViewForPlatform(j * BLOCK_WIDTH, i * BLOCK_HEIGHT, "f2");
					gameRoot.getChildren().add(platform);
					platforms.add(platform);
					break;
				case 'C':
					platform = RenderableHolder.createImageViewForPlatform(j * BLOCK_WIDTH, i * BLOCK_HEIGHT, "f3");
					gameRoot.getChildren().add(platform);
					platforms.add(platform);
					break;
				case 'D':
					platform = RenderableHolder.createImageViewForPlatform(j * BLOCK_WIDTH, i * BLOCK_HEIGHT, "f4");
					gameRoot.getChildren().add(platform);
					platforms.add(platform);
					break;
				default:
					break;
				}
			}
		}
		appRoot.getChildren().add(background);
	}
	
	private static void initializePlayer() {
		player = new Player(RenderableHolder.spritePlayerStanding, 0, 0, 200, 1);
		gameRoot.getChildren().add(player);
	}
	
	private static void setGameRootLayoutX() {
		player.translateXProperty().addListener((observer, oldValue, newValue) -> {
			int offSet = newValue.intValue();
			if (offSet > 400 && offSet < levelWidth-400) {
				gameRoot.setLayoutX(-(offSet-400));
			}
		});
	}
	
	private static void addGameRoot() {
		appRoot.getChildren().add(gameRoot);
	}
	
	private static void addUIRoot() {
		appRoot.getChildren().add(uiRoot);
	}
	
	private static void setTime(int time) {
		GameManager.time = time;
	}
	
	private static void setCanJump(boolean canJump) {
		GameManager.canJump = canJump;
	}
	
	private static void initializeKeysValue() {
		keys.put(KeyCode.W, false);
		keys.put(KeyCode.A, false);
		keys.put(KeyCode.D, false);
	}
	
	/* ==================== USED IN update() METHOD ==================== */
	
//	private static void movePlayerX(int moveX) {
//		boolean moveRight = moveX > 0;
//		for (int i = 0; i < Math.abs(moveX); i++) {
//			for (Node platform: platforms) {
//				if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
//					if (moveRight) {
//						if (player.getTranslateX() + player.getWidth() - 30 == platform.getTranslateX()) {
//							return;
//						}
//					} else if (player.getTranslateX() == platform.getTranslateX() + BLOCK_WIDTH + 5) {
//						return;
//					}
//				}
//			}
//			player.setTranslateX(player.getTranslateX() + (moveRight ? 1: -1));
//		}
//	}
//	
//	private static void movePlayerY(int moveY) {
//		boolean moveDown = moveY > 0;
//		for (int i = 0; i < Math.abs(moveY); i++) {
//			for (Node platform: platforms) {
//				if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
//					if (moveDown) {
//						if (player.getTranslateY() + player.getHeight() == platform.getTranslateY()) {
//							player.setTranslateY(player.getTranslateY() - 1);
//							setCanJump(true);
//						}
//					} else if (player.getTranslateY() == platform.getTranslateY() + 61) {
//						return ;
//					}
//				}
//			}
//			player.setTranslateY(player.getTranslateY() + (moveDown ? 1: -1));
//		}
//	}
	
	private static void movePlayerX(int value) {
		boolean movingRight = value > 0;
		for (int i = 0; i < Math.abs(value); i++) {
			for (Node platform : platforms) {
				if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
					if (movingRight) {
						if (player.getTranslateX() + player.getWidth() - 20 == platform.getTranslateX()) {
							return;
						}
					} else {
						if (player.getTranslateX() == platform.getTranslateX() + BLOCK_WIDTH - 20) {
							return;
						}
					}
				}
			}
			player.setTranslateX(player.getTranslateX() + (movingRight ? 1 : -1));
		}
	}

	private static void movePlayerY(int value) {
		boolean movingDown = value > 0;
		for (int i = 0; i < Math.abs(value); i++) {
			for (Node platform : platforms) {
				if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
					if (movingDown) {
						if (player.getTranslateY() + player.getHeight() == platform.getTranslateY()) {
							canJump = true;
							return;
						}
					} else {
						if (player.getTranslateY() == platform.getTranslateY() + 45) {
							return;
						}
					}
				}
			}
			player.setTranslateY(player.getTranslateY() + (movingDown ? 1 : -1));
		}
	}

	private static void jumpPlayer(int jumpHeight) {
		if (canJump) {
			player.setVelocityY(player.getVelocityY() - jumpHeight);
			setCanJump(false);
		}
	}
	
	private static boolean isPressed(KeyCode key) {
		return keys.getOrDefault(key, false);
	}
	
	/* ============================== PUBLIC STATIC METHOD ============================== */
	
	public static void update() {
		if (isPressed(KeyCode.W) && player.getTranslateY() >= 5) {
			jumpPlayer(30);
		}
		if (isPressed(KeyCode.A) && player.getTranslateX() >= 5) {
			jumpPlayer(3);
			movePlayerX(-5);
		}
		if (isPressed(KeyCode.D) && player.getTranslateX() <= levelWidth - 5 - player.getWidth()) {
			jumpPlayer(3);
			movePlayerX(5);
		}
		if (player.getVelocityY() < 10) {
			player.setVelocityY(player.getVelocityY() + 1);
		}
		movePlayerY(player.getVelocityY());
		player.update();
//		System.out.println(player.getVelocityY());
	}
	
	
	/* ============================== GETTER/SETTER ============================== */
	
	public static AnchorPane getAppRoot() {
		return appRoot;
	}

	public static void setAppRoot(AnchorPane appRoot) {
		GameManager.appRoot = appRoot;
	}
	
	public static void setIsMute(boolean isMute) {
		GameManager.isMute = isMute;
	}
	
	public static boolean getIsMute() {
		return isMute;
	}
	
	public static int getBlockWidth() {
		return BLOCK_WIDTH;
	}
	
	public static int getBlockHeight() {
		return BLOCK_HEIGHT;
	}
	
	public static void setKeysValue(KeyCode keyCode, boolean value) {
		keys.put(keyCode, value);
	}
	
	public static boolean getKeysValue(KeyCode key) {
		return keys.getOrDefault(key, false);
	}
	
	public static void getPlayerTranslateY() {
		System.out.println(player.getTranslateY());
	}
}
