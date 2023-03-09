<h1>UltimateTroll
<img src="https://github.com/Josscoder/UltimateTroll/blob/master/.github/assets/logo.png" height="64" width="64" align="left" alt="">
</h1>

## 📩 Setup

1) Download the latest version [here](https://github.com/Josscoder/UltimateTroll/releases/latest)
2) Put the .jar in your plugins folder
3) And finally, start your server!

## 📙 Description

Plugin for your Nukkit Server to troll everyone

![](https://github.com/Josscoder/UltimateTroll/blob/master/.github/assets/Screenshot_1.png)

![](https://github.com/Josscoder/UltimateTroll/blob/master/.github/assets/Screenshot_2.png)

- Player Selector:

![](https://github.com/Josscoder/UltimateTroll/blob/master/.github/assets/Screenshot_7.png)

- Variety of traps:

![](https://github.com/Josscoder/UltimateTroll/blob/master/.github/assets/Screenshot_3.png)

![](https://github.com/Josscoder/UltimateTroll/blob/master/.github/assets/Screenshot_4.png)

![](https://github.com/Josscoder/UltimateTroll/blob/master/.github/assets/Screenshot_5.png)

![](https://github.com/Josscoder/UltimateTroll/blob/master/.github/assets/Screenshot_6.png)

## ⏯  Watch the video
[![Watch the video](https://i.imgur.com/WgkocOW.png)](https://www.youtube.com/watch?v=GLZIB9H5-sg)

# For Developers
## 🌏 Add as dependency
Maven:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.Josscoder</groupId>
    <artifactId>UltimateTroll</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 🕳 Create and get a trap

```java
package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.block.BlockAir;
import cn.nukkit.inventory.PlayerInventory;
import josscoder.ultimatetroll.UltimateTrollPlugin;
import josscoder.ultimatetroll.trap.Trap;

public class DropItemInHandTrap extends Trap {

    @Override
    public void init() {
        //To get: UltimateTrollPlugin.getInstance().getTrap("BurnTrap")...
    }

    @Override
    public String getImage() {
        return "https://i.imgur.com/piQOP6U.png";
    }

    @Override
    public void onExecute(Player target) {
        PlayerInventory inventory = target.getInventory();

        target.dropItem(inventory.getItemInHand());
        inventory.setItemInHand(new BlockAir().toItem());
        inventory.sendContents(target);
        inventory.sendHeldItem(target);
    }

    @Override
    public void close() {

    }
}

public class MyPlugin extends PluginBase {

    @Override
    public void onEnable() {
        //store new trap UltimateTrollPlugin.getInstance().storeNewTrap(new DropItemInHandTrap());
    }
}

```

## 📜 LICENSE

This plugin is licensed under the [GNU GENERAL PUBLIC LICENSE](https://github.com/Josscoder/UltimateTroll/blob/master/LICENSE), this plugin was completely created by Josscoder (José Luciano Mejia Arias)