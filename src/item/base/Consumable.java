package item.base;

import entity.character.Player;
import exception.ConsumePotionFailedException;

public interface Consumable {
	public abstract void consumed(Player player) throws ConsumePotionFailedException;

}