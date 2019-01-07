package peep.biotic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import peep.biotic.proxy.CommonProxy;

@Mod(modid = Biotic.MODID, name = Biotic.MODNAME, version = Biotic.MODVERSION, dependencies = "required-after:forge@[11.16.0.1865,)", useMetadata = true)
public class Biotic {
        public static final String MODID = "biotic";
        public static final String MODNAME = "Biotic";
        public static final String MODVERSION= "0.0.1";

        @SidedProxy(clientSide = "peep.biotic.proxy.ClientProxy", serverSide = "peep.biotic.proxy.ServerProxy")
        public static CommonProxy proxy;

        public static CreativeTabs creativeTab = new CreativeTabs("biotic") {
            @Override
            public ItemStack getTabIconItem() { return new ItemStack(ModBlocks.blockFastFurnace);}
        };

        @Mod.Instance
        public static Biotic instance;

        public static Logger logger;

        @Mod.EventHandler
        public void preInit(FMLPreInitializationEvent event) {
            logger = event.getModLog();
            proxy.preInit(event);
        }

        @Mod.EventHandler
        public void init(FMLInitializationEvent e) {
            proxy.init(e);
        }

        @Mod.EventHandler
        public void postInit(FMLPostInitializationEvent e) {
            proxy.postInit(e);
        }
}
