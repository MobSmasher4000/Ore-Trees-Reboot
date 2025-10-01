package org.mob.ore_trees_reboot.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.item.ModItems;
import org.mob.ore_trees_reboot.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Ore_trees_reboot.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Items.ORE_UPGRADES)
                .add(ModItems.UPGRADE_BASE.get())

                .add(ModItems.UPGRADE_SPEED_TIER_1.get())
                .add(ModItems.UPGRADE_SPEED_TIER_2.get())
                .add(ModItems.UPGRADE_SPEED_TIER_3.get())
                .add(ModItems.UPGRADE_SPEED_TIER_4.get())

                .add(ModItems.UPGRADE_AMOUNT_TIER_1.get())
                .add(ModItems.UPGRADE_AMOUNT_TIER_2.get())
                .add(ModItems.UPGRADE_AMOUNT_TIER_3.get())
                .add(ModItems.UPGRADE_AMOUNT_TIER_4.get())
                .add(ModItems.UPGRADE_AMOUNT_TIER_5.get())
                .add(ModItems.UPGRADE_AMOUNT_TIER_6.get())

                .add(ModItems.UPGRADE_TIER_1.get())
                .add(ModItems.UPGRADE_TIER_2.get())
                .add(ModItems.UPGRADE_TIER_3.get())
                .add(ModItems.UPGRADE_TIER_4.get())
                .add(ModItems.UPGRADE_TIER_5.get())
                .add(ModItems.UPGRADE_TIER_6.get())
        ;

    }
}
