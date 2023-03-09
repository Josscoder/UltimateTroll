package josscoder.ultimatetroll.trap;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginLogger;
import cn.nukkit.utils.TextFormat;
import josscoder.ultimatetroll.UltimateTrollPlugin;

public abstract class Trap implements ITrap {

    private static final PluginLogger logger = UltimateTrollPlugin.getInstance().getLogger();

    public String getSimpleName() {
        return getClass().getSimpleName();
    }

    @Override
    public String getId() {
        return getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    @Override
    public String getName() {
        return getSimpleName().replace("Trap", "").replaceAll("([a-z])([A-Z])", "$1 $2");
    }

    @Override
    public void onEnable() {
        init();
        logger.warning(TextFormat.GREEN + getName() + " trap was loaded!");
    }

    @Override
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

    @Override
    public String getImage() {
        return "textures/blocks/barrier.png";
    }

    @Override
    public void onDisable() {
        close();
        logger.warning(TextFormat.RED + getName() + " trap was closed!");
    }
}
