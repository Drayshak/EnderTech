package io.endertech.config;

import io.endertech.util.helper.LogHelper;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ItemConfig
{
    private static Configuration itemConfig;

    public static int itemExchangerBlockCost;
    public static int itemExchangerMaxRadius;

    protected static void init(File configFile)
    {
        itemConfig = new Configuration(configFile);
        try
        {
            itemConfig.load();
            itemExchangerBlockCost = itemConfig.get("item.general", "Exchanger.BlockCost", 8192).getInt(8192);
            itemExchangerMaxRadius = itemConfig.get("item.general", "Exchanger.MaxRadius", 8).getInt(8);
            if (itemExchangerMaxRadius < 1)
            {
                itemExchangerMaxRadius = 1;
            }
            if (itemExchangerMaxRadius > 64)
            {
                itemExchangerMaxRadius = 64;
            }
        } catch (Exception e)
        {
            LogHelper.error("Failed to load item config");
        } finally
        {
            itemConfig.save();
        }
    }
}