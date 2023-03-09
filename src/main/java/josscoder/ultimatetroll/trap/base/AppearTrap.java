package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.Server;
import josscoder.ultimatetroll.trap.Trap;

public class AppearTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/ui/sidebar_icons/profile_screen_icon.png";
    }

    @Override
    public void onExecute(Player target) {
        Server.getInstance().getOnlinePlayers().values().forEach(onlinePlayer -> onlinePlayer.showPlayer(target));
    }

    @Override
    public void close() {

    }
}
