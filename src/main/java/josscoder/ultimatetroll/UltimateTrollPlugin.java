package josscoder.ultimatetroll;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import josscoder.ultimatetroll.trap.ITrap;
import josscoder.ultimatetroll.trap.base.BurnTrap;
import josscoder.ultimatetroll.trap.base.DropItemInHandTrap;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class UltimateTrollPlugin extends PluginBase {

    @Getter
    private static UltimateTrollPlugin instance;

    @Getter
    private final List<ITrap> trapList = Arrays.asList(
            new BurnTrap(),
            new DropItemInHandTrap()
    );

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getLogger().info(TextFormat.GREEN + "UltimateTroll has been enabled");
    }

    public void storeTrap(ITrap ...trap) {
        trapList.addAll(Arrays.asList(trap));
    }

    @Override
    public void onDisable() {
        getLogger().info(TextFormat.RED + "UltimateTroll has been disabled");
    }
}