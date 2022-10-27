package com.johnheikens.skriptaddontemplate.elements;

import org.bukkit.World;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.classes.Converter;
import ch.njol.skript.registrations.Converters;
import com.johnheikens.skriptaddontemplate.objects.ClientWorldBorder;

public class DefaultConverters {

	static {
		Converters.registerConverter(ClientWorldBorder.class, World.class, new Converter<ClientWorldBorder, World>() {
			@Override
			@Nullable
			public World convert(ClientWorldBorder border) {
				return border.getWorld();
			}
		});
	}

}
