package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.potion.Effect;
import josscoder.ultimatetroll.trap.Trap;

public class LevitationTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/items/potion_bottle_splash_levitation.png";
    }

    @Override
    public void onExecute(Player target) {
        target.addEffect(Effect.getEffect(Effect.LEVITATION).setDuration(20 * 20));
    }

    @Override
    public void close() {

    }
}
