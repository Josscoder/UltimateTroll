package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Level;
import cn.nukkit.scheduler.Task;
import josscoder.ultimatetroll.trap.Trap;
import josscoder.ultimatetroll.utils.TrapUtils;

import java.util.concurrent.ThreadLocalRandom;

public class ChangeTimeCycleTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/ui/time_4sunset.png";
    }

    @Override
    public void onExecute(Player target) {
        Server.getInstance().getScheduler().scheduleRepeatingTask(new Task() {
            private int timer = 10;

            @Override
            public void onRun(int i) {
                if (timer-- <= 0) {
                    cancel();
                } else {
                    TrapUtils.setTime(target, ThreadLocalRandom.current().nextInt(Level.TIME_DAY, Level.TIME_SUNRISE));
                }
            }

            @Override
            public void onCancel() {
                TrapUtils.resetTime(target);
            }
        }, 20 * 2);
    }

    @Override
    public void close() {

    }
}

