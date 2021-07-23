package com.meacks.goldtoucher;

import com.meacks.goldtoucher.handlers.*;
import jdk.jfr.Name;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GoldToucher.MODID)
@Name(GoldToucher.NAME)
public class GoldToucher
{
    public static final String MODID = "goldtoucher";
    public static final String NAME = "Gold Toucher";
    public static final ItemGroup TOMB_Block_GROUP = new ItemGroup("tomb_block") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(Items.BONE_BLOCK);
        }
    };
    public static final ItemGroup TOMB_ITEM = new ItemGroup("tomb_item") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(Items.WITHER_SKELETON_SKULL);
        }
    };
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public GoldToucher() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        bus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        bus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        bus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        bus.addListener(this::doClientStuff);

        EntityHandler.ENTITY_TYPE_DEFERRED_REGISTER.register(bus);
        TileEntityHandler.TILE_ENTITY_TYPE_DEFERRED_REGISTER.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreHandler::generateOres);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            blockRegistryEvent.getRegistry().registerAll(BlockHandler.BLOCKS.toArray(new Block[0]));
            LOGGER.info("HELLO from block register");
        }@SubscribeEvent
        public static void onItemRegister(RegistryEvent.Register<Item> itemRegistryEvent) {
            itemRegistryEvent.getRegistry().registerAll(ItemHandler.ITEMS.toArray(new Item[0]));
            LOGGER.info("Hello from item register");
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientRegistry {
        @SubscribeEvent
        public static void onClientSetUpEvent(FMLClientSetupEvent event) {

        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonEventHandler {
        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {

        }
    }
}
