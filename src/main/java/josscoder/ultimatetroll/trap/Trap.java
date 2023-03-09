package josscoder.ultimatetroll.trap;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;

public abstract class Trap implements ITrap {

    public Trap() {
        init();
    }

    @Override
    public String getId() {
        return getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    @Override
    public String getName() {
        return getClass().getSimpleName().replace("Trap", "").replaceAll("([a-z])([A-Z])", "$1 $2");
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
}
