package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.Server;
import josscoder.ultimatetroll.trap.Trap;

public class VanishTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/ui/user_icon.png";
    }

    @Override
    public void onExecute(Player target) {
        Server.getInstance().getOnlinePlayers().values().forEach(onlinePlayer -> onlinePlayer.hidePlayer(target));
    }

    @Override
    public void close() {

    }
}

