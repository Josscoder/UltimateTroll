package josscoder.ultimatetroll;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import josscoder.ultimatetroll.command.TrollCommand;
import josscoder.ultimatetroll.trap.ITrap;
import josscoder.ultimatetroll.trap.base.*;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class UltimateTrollPlugin extends PluginBase {

    @Getter
    private static UltimateTrollPlugin instance;

    @Getter
    private final List<ITrap> trapList = Arrays.asList(
            new BedrockJailTrap(),
            new BurnTrap(),
            new ChangeHeadRotationTrap(),
            new ChangeTimeCycleTrap(),
            new CrashClientTrap(),
            new CreepersTrap(),
            new DropAllInventoryTrap(),
            new DropItemInHandTrap(),
            new GiveAllEffectsTrap(),
            new HideAllPlayersTrap(),
            new LaunchTrap(),
            new LightningStrikeTramp(),
            new NextBlockExplodesTrap(),
            new NukeTrap(),
            new ShuffleInventoryTrap(),
            new TNTJailTrap(),
            new VanishTrap()
    );

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getServer().getCommandMap().register("troll", new TrollCommand());
        getLogger().info(TextFormat.GREEN + "UltimateTroll has been enabled");
    }

    public void storeTrap(ITrap... trap) {
        trapList.addAll(Arrays.asList(trap));
    }

    public ITrap getTrap(String id) {
        return trapList.stream()
                .filter(trap -> trap.getId().equalsIgnoreCase(id) || trap.getName().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void onDisable() {
        trapList.forEach(ITrap::close);
        getLogger().info(TextFormat.RED + "UltimateTroll has been disabled");
    }
}