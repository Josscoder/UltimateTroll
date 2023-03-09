package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.level.Position;
import josscoder.ultimatetroll.trap.Trap;
import josscoder.ultimatetroll.utils.TrapUtils;

public class LightningStrikeTramp extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/ui/weather_thunderstorm.png";
    }

    @Override
    public void onExecute(Player target) {
        Position position = target.getPosition();

        TrapUtils.spawnLightning(position);
        TrapUtils.burn(position);
        target.attack(1);
    }

    @Override
    public void close() {

    }
}

