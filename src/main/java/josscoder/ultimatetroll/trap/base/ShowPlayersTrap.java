package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.Server;
import josscoder.ultimatetroll.trap.Trap;

public class ShowPlayersTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/ui/dressing_room_skins.png";
    }

    @Override
    public void onExecute(Player target) {
        Server.getInstance().getOnlinePlayers().values().forEach(target::showPlayer);
    }

    @Override
    public void close() {

    }
}
