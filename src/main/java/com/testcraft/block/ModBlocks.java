package com.testcraft.block;

import com.testcraft.TestCraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CALCITE_TILES = registerBlock("calcite_tiles", new Block(AbstractBlock.Settings.create()
            .strength(4.0F)
            .requiresTool()
            .sounds(BlockSoundGroup.CALCITE)
            .mapColor(MapColor.WHITE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block); {
        return Registry.register(Registries.BLOCK, new Identifier(TestCraft.MOD_ID,name),
        block);
        }
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM,
                new Identifier(TestCraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void regiterModBlocks() {
        TestCraft.LOGGER.info("Registering ModBlocks for " + TestCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
                entries.addAfter(Blocks.OAK_PLANKS, ModBlocks.CALCITE_TILES));
    }

}
