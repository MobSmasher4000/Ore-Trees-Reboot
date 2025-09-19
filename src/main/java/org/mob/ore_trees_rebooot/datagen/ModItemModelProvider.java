package org.mob.ore_trees_rebooot.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.mob.ore_trees_rebooot.Ore_trees_reboot;
import org.mob.ore_trees_rebooot.block.ModBlocks;
import org.mob.ore_trees_rebooot.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ore_trees_reboot.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.Crafting_Base.get());
        saplingItem(ModBlocks.IRON_SAPLING);
        saplingItem(ModBlocks.GOLD_SAPLING);
        saplingItem(ModBlocks.COPPER_SAPLING);
        saplingItem(ModBlocks.LAPIS_SAPLING);
        saplingItem(ModBlocks.REDSTONE_SAPLING);
        saplingItem(ModBlocks.DIAMOND_SAPLING);
        saplingItem(ModBlocks.ANCIENT_SAPLING);
        saplingItem(ModBlocks.COAL_SAPLING);
        saplingItem(ModBlocks.QUARTZ_SAPLING);
        saplingItem(ModBlocks.EMERALD_SAPLING);
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID,"block/" + item.getId().getPath()));
    }
}
