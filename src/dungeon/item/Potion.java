package dungeon.item;

import dungeon.entity.Player;

public class Potion extends Item{
	
	private int heal = 2;

	public Potion() {
		super("small health potion");
	}

	@Override
	public void use(Player player) {
		player.takeDamage(-1*heal);
		player.removeItem(this);
	}

}
