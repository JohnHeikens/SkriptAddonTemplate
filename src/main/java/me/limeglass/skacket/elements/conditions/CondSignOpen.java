package me.limeglass.skacket.elements.conditions;

import org.bukkit.entity.Player;

import ch.njol.skript.conditions.base.PropertyCondition;
import me.limeglass.skacket.Skacket;
import me.limeglass.skacket.managers.SignManager;

public class CondSignOpen extends PropertyCondition<Player> {

	private final static SignManager signManager;

	static {
		register(CondSignOpen.class, PropertyType.HAVE, "[a] sign [gui] open", "players");
		signManager = Skacket.getInstance().getSignManager();
	}

	@Override
	public boolean check(Player player) {
		return signManager.getSignFor(player).isPresent();
	}

	@Override
	protected String getPropertyName() {
		return "sign open";
	}

}
