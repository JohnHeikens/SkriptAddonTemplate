package com.johnheikens.skriptaddontemplate.elements.conditions;

import org.bukkit.event.Event;
        import org.eclipse.jdt.annotation.Nullable;

        import ch.njol.skript.Skript;
        import ch.njol.skript.doc.Description;
        import ch.njol.skript.doc.Name;
        import ch.njol.skript.lang.Condition;
        import ch.njol.skript.lang.Expression;
        import ch.njol.skript.lang.SkriptParser.ParseResult;
        import ch.njol.util.Kleenean;

@Name("Addon Template Loaded Correctly")
@Description("Check if the addon template is loaded correctly")
public class CondLoadedCorrectly extends Condition {

    static {
        Skript.registerCondition(CondLoadedCorrectly.class, "[the] [addon] template (was|is)(0¦|1¦n('|o)t) loaded [correctly]");
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
        setNegated(parseResult.mark == 1);
        return true;
    }

    @Override
    public boolean check(Event event) {
        return true;
    }

    @Override
    public String toString(@Nullable Event event, final boolean debug) {
        if (event == null || debug)
            return "anvil click";
        return "the addon template was" + (isNegated() ? " not " : "") + "loaded correctly";
    }

}