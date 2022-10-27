package com.johnheikens.skriptaddontemplate.elements.conditions;

import com.johnheikens.skriptaddontemplate.managers.SignManager;
import org.bukkit.entity.Player;

import ch.njol.skript.conditions.base.PropertyCondition;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Name;
import com.johnheikens.skriptaddontemplate.SkriptAddonTemplate;

@Name("Sign Open")
@Description("Checks if a sign gui is open to a player. Skacket sign guis only.")
public class CondSignOpen extends PropertyCondition<Player> {

	private final static SignManager signManager;

	static {
		register(CondSignOpen.class, PropertyType.HAVE, "[a] sign [gui] open", "players");
		signManager = SkriptAddonTemplate.getInstance().getSignManager();
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
