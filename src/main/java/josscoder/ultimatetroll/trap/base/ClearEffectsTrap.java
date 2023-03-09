package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import josscoder.ultimatetroll.trap.Trap;

public class ClearEffectsTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/items/bucket_milk.png";
    }

    @Override
    public void onExecute(Player target) {
        target.removeAllEffects();
        target.setMaxHealth(20);
    }

    @Override
    public void close() {

    }
}
