package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.Server;
import josscoder.ultimatetroll.trap.Trap;

public class HideAllPlayersTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "https://i.imgur.com/Bu7VFUM.png";
    }

    @Override
    public void onExecute(Player target) {
        Server.getInstance().getOnlinePlayers().values().forEach(target::hidePlayer);
    }

    @Override
    public void close() {

    }
}

