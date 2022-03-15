package net.xolt.freecam.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import me.shedaniel.clothconfig2.gui.entries.SelectionListEntry;

@Config(name = "freecam")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.Excluded
    public static ModConfig INSTANCE;

    public static void init() {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    @Comment("FreeCamera 使用的飛行類型")
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public FlightMode flightMode = FlightMode.DEFAULT;

    @Comment("FreeCamera 的水平速度")
    public double horizontalSpeed = 1.0;

    @Comment("FreeCamera 的垂直速度")
    public double verticalSpeed = 0.8;

    @Comment("是否在啟用 FreeCamera 時呈現在原始位置")
    public boolean showPlayer = true;

    @Comment("是否在啟用 FreeCamera 時顯示您的手")
    public boolean showHand = false;

    @Comment("是否受到傷害會禁用 FreeCamera")
    public boolean disableOnDamage = true;

    @Comment("是否可以在啟用 FreeCamera 時破壞方塊")
    public boolean allowBlockBreak = true;

    @Comment("是否可以在啟用 FreeCamera 時與實體交互")
    public boolean allowEntityInteract = true;

    @Comment("操作欄通知")
    public boolean notify = true;

    @Comment("啟用 FreeCamera 時顯示的消息")
    public String enableMessage = "Freecam has been enabled.";

    @Comment("禁用 FreeCamera 時顯示的消息")
    public String disableMessage = "Freecam has been disabled.";

    public enum FlightMode implements SelectionListEntry.Translatable {
        CREATIVE("創造"),
        DEFAULT("默認");

        private final String name;

        FlightMode(String name) {
            this.name = name;
        }

        public String getKey() {
            return name;
        }
    }
}
