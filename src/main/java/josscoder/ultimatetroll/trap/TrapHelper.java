package josscoder.ultimatetroll.trap;

import com.google.common.collect.Lists;
import josscoder.ultimatetroll.trap.base.*;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class TrapHelper {

    @Getter
    private final List<Trap> trapList = Lists.newArrayList();

    public void init() {
        addAll(
                new BedrockJailTrap(),
                new BurnTrap(),
                new ChangeHeadRotationTrap(),
                new ChangeTimeCycleTrap(),
                new CrashClientTrap(),
                new DropAllInventoryTrap(),
                new DropItemInHandTrap(),
                new GiveAllEffectsTrap(),
                new ClearEffectsTrap(),
                new HideAllPlayersTrap(),
                new ShowPlayersTrap(),
                new LaunchTrap(),
                new LightningStrikeTramp(),
                new NextBlockExplodesTrap(),
                new NukeTrap(),
                new ShuffleInventoryTrap(),
                new TNTJailTrap(),
                new VanishTrap(),
                new AppearTrap()
        );
    }

    public void addAll(Trap... traps) {
        Arrays.stream(traps).forEach(this::add);
    }

    public void add(Trap trap) {
        trap.onEnable();
        trapList.add(trap);
    }

    public void remove(String id) {
        Trap trap = get(id);
        if (trap != null) {
            trap.onDisable();
            trapList.remove(trap);
        }
    }

    public Trap get(String id) {
        return trapList.stream()
                .filter(trap -> trap.getId().equalsIgnoreCase(id) || trap.getName().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public void close() {
        trapList.forEach(Trap::onDisable);
    }
}
