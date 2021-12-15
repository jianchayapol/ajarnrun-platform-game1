package logic.level;

public class Level {
	
	// X = finish point
	// E = enemy_1
	// e = enemy_2
	// M = coin
	// K = book1 (exp)
	// k = book2 (exp)
	// S = start
	// U = UNSEEN NODE
	
	private static final String[] LEVEL1 = new String[] {
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"000000000000000000055000000000000000000000000000000000000MMMMMMM00000000000KKKkkk0000000000000000000",
			"0000000000000000055000000000000000000000000000000000001222222222300122222222222222222222222222222222",
			"0000000000000000000000000000000000000000000000000000124444444444400444444444444444444444444444444444",
			"0000000000050000e000000e00000050000000050E0050000012444444444444400444444444444444444444444444444444",
			"2300122300142222222222222222224300012224222242222244444444444444400444444444444444444444444444444444",
			"4422444422444444444444444444444400044444444444444444444444444444400444444444444444444444444444444444"
	};
	
	private static final String[] LEVEL2 = new String[] {
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000X000000",
			"2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222",
			"4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444",
			"4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444"
	};
	
	private static final String[] LEVEL3 = new String[] {
			"0000000000000000000000004444000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000400000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000004444000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000400000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000004444000000000000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
			"000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000X000000",
			"2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222",
			"4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444",
			"4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444"
	};
	
	public static final String[][] ALL_LEVEL = new String[][] {
		LEVEL1, LEVEL2, LEVEL3
	};
}