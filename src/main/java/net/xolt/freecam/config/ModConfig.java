package net.xolt.freecam.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "freecam")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.Excluded
    public static ModConfig INSTANCE;
    @Comment("FreeCamera 的水平速度")
    public double horizontalSpeed = 1.0;
    @Comment("FreeCamera 的垂直速度")
    public double verticalSpeed = 0.8;
    @Comment("是否受到傷害會禁用 FreeCamera")
    public boolean disableOnDamage = true;
    @Comment("操作欄通知")
    public boolean notify = true;
    @Comment("啟用 FreeCamera 時顯示的消息")
    public String enableMessage = "FreeCamera 已啟用";
    @Comment("禁用 FreeCamera 時顯示的消息")
    public String disableMessage = "FreeCamera 已關閉";

    public static void init() {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

}
