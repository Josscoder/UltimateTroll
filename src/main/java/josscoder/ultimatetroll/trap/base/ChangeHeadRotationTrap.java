package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.level.Location;
import josscoder.ultimatetroll.trap.Trap;

import java.util.concurrent.ThreadLocalRandom;

public class ChangeHeadRotationTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/ui/warning_alex.png";
    }

    @Override
    public void onExecute(Player target) {
        Location location = target.getLocation();
        location.yaw = ThreadLocalRandom.current().nextDouble(180);
        location.pitch = ThreadLocalRandom.current().nextDouble(180);

        target.teleport(location);
    }

    @Override
    public void close() {

    }
}
