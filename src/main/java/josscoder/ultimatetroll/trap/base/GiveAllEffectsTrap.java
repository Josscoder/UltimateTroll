package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.potion.Effect;
import josscoder.ultimatetroll.UltimateTrollPlugin;
import josscoder.ultimatetroll.trap.Trap;

public class GiveAllEffectsTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/ui/speed_effect.png";
    }

    @Override
    public void onExecute(Player target) {
        int duration = 20 * 10;

        Server.getInstance().getScheduler()
                .scheduleDelayedTask(UltimateTrollPlugin.getInstance(), () -> target.setMaxHealth(20), duration);

        for (int i = 1; i <= 30; i++) {
            Effect effect = Effect.getEffect(i);
            if (effect == null) {
                continue;
            }

            effect.setDuration(duration);
            effect.setAmplifier(2);
            effect.setVisible(false);

            target.addEffect(effect);
            target.sendPotionEffects(target);
        }
    }

    @Override
    public void close() {

    }
}

