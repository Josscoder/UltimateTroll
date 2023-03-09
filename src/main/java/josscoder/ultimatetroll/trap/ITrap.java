package josscoder.ultimatetroll.trap;

import cn.nukkit.Player;

public interface ITrap {

    void init();

    String getId();

    String getName();

    String getImage();

    void execute(Player target, Player sender);
    void onExecute(Player target);

    void close();

}
