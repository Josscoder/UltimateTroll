package josscoder.ultimatetroll.trap;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginLogger;
import cn.nukkit.utils.TextFormat;
import josscoder.ultimatetroll.UltimateTrollPlugin;

public abstract class Trap {

    private static final PluginLogger logger = UltimateTrollPlugin.getInstance().getLogger();

    public void onEnable() {
        init();
        logger.warning(TextFormat.GREEN + getName() + " trap was loaded!");
    }

    public abstract void init();

    public String getSimpleName() {
        return getClass().getSimpleName();
    }

    public String getId() {
        return getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    public String getName() {
        return getSimpleName().replace("Trap", "").replaceAll("([a-z])([A-Z])", "$1 $2");
    }

    public String getImage() {
        return "textures/blocks/barrier.png";
    }

    public void execute(Player target, Player sender) {
        if (target == null) {
            sender.sendMessage(TextFormat.RED + "The player was disconnected");
            return;
        }

        onExecute(target);

        sender.sendMessage(TextFormat.colorize(String.format(
                "&a%s fell into your trap &6(%s)",
                target.getName(),
                getName()
        )));
    }

    public abstract void onExecute(Player target);

    public void onDisable() {
        close();
        logger.warning(TextFormat.RED + getName() + " trap was closed!");
    }

    public abstract void close();
}
