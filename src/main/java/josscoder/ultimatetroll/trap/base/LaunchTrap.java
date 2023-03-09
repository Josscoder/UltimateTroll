package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.math.Vector3;
import josscoder.ultimatetroll.trap.Trap;

public class LaunchTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/ui/dressing_room_animation.png";
    }

    @Override
    public void onExecute(Player target) {
        target.setMotion(new Vector3(0, 3));
    }

    @Override
    public void close() {

    }
}

