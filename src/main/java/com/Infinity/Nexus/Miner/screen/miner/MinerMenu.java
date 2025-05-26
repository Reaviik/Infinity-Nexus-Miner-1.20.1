package com.Infinity.Nexus.Miner.screen.miner;


import com.Infinity.Nexus.Core.itemStackHandler.RestrictedItemStackHandler;
import com.Infinity.Nexus.Core.screen.BaseAbstractContainerMenu;
import com.Infinity.Nexus.Core.slots.*;
import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.block.entity.MinerBlockEntity;
import com.Infinity.Nexus.Miner.screen.ModMenuTypes;
import com.Infinity.Nexus.Miner.slots.EnchantSlot;
import com.Infinity.Nexus.Miner.slots.RecipeSlot;
import com.Infinity.Nexus.Miner.slots.StructureSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class MinerMenu extends BaseAbstractContainerMenu {
    public final MinerBlockEntity blockEntity;
    private final Level level;
    private IEnergyStorage energyStorage;
    private final ContainerData data;
    private static final int slots = 18;

    public MinerMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, (MinerBlockEntity) inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(15), new RestrictedItemStackHandler(slots));
    }

    public MinerMenu(int pContainerId, Inventory inv, MinerBlockEntity entity, ContainerData data, RestrictedItemStackHandler iItemHandler) {
        super(ModMenuTypes.MINER_MENU.get(), pContainerId, slots);
        checkContainerSize(inv, slots);
        blockEntity = entity;
        energyStorage = blockEntity.getEnergyStorage();
        level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);


        this.addSlot(new ResultSlot(iItemHandler, 0, 80, 11));
        this.addSlot(new ResultSlot(iItemHandler, 1, 98, 11));
        this.addSlot(new ResultSlot(iItemHandler, 2, 116, 11));
        this.addSlot(new ResultSlot(iItemHandler, 3, 80, 29));
        this.addSlot(new ResultSlot(iItemHandler, 4, 98, 29));
        this.addSlot(new ResultSlot(iItemHandler, 5, 116, 29));
        this.addSlot(new ResultSlot(iItemHandler, 6, 80, 47));
        this.addSlot(new ResultSlot(iItemHandler, 7, 98, 47));

        this.addSlot(new RecipeSlot(iItemHandler, 8, 116, 47));

        this.addSlot(new UpgradeSlot(iItemHandler, 9, -11, 11));
        this.addSlot(new UpgradeSlot(iItemHandler, 10, -11, 23));
        this.addSlot(new UpgradeSlot(iItemHandler, 11, -11, 35));
        this.addSlot(new UpgradeSlot(iItemHandler, 12, -11, 47));

        this.addSlot(new ComponentSlot(iItemHandler, 13, 8, 29));

        this.addSlot(new EnchantSlot(iItemHandler, 14, 44, 11));
        this.addSlot(new LinkSlot(iItemHandler, 15, 44, 29));
        this.addSlot(new FuelSlot(iItemHandler, 16, 44, 47));

        this.addSlot(new StructureSlot(iItemHandler, 17, 26, 29));

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0 && data.get(7) > 0 && data.get(8) > 0 && data.get(9) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        int progressArrowSize = 62; // This is the height in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }
    public MinerBlockEntity getBlockEntity(){
        return blockEntity;
    }
    public IEnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(this.getBlockEntity().getLevel(), this.getBlockEntity().getBlockPos()),
                pPlayer, ModBlocksMiner.MINER.get());
    }

    public int[] getDisplayInfo() {
        return new int[] { data.get(5), data.get(8), data.get(9), data.get(4), data.get(7), data.get(10)};
    }
}