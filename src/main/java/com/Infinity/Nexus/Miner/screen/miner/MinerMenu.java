package com.Infinity.Nexus.Miner.screen.miner;


import com.Infinity.Nexus.Core.slots.ResultSlot;
import com.Infinity.Nexus.Core.slots.*;
import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.block.entity.MinerBlockEntity;
import com.Infinity.Nexus.Miner.screen.ModMenuTypes;
import com.Infinity.Nexus.Miner.slots.EnchantSlot;
import com.Infinity.Nexus.Miner.slots.StructureSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class MinerMenu extends AbstractContainerMenu {
    public final MinerBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public MinerMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(15));
    }

    public MinerMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.MINER_MENU.get(), pContainerId);
        checkContainerSize(inv, TE_INVENTORY_SLOT_COUNT);
        blockEntity = ((MinerBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            this.addSlot(new ResultSlot(iItemHandler, 0, 80, 11));
            this.addSlot(new ResultSlot(iItemHandler, 1, 98, 11));
            this.addSlot(new ResultSlot(iItemHandler, 2, 116, 11));
            this.addSlot(new ResultSlot(iItemHandler, 3, 80, 29));
            this.addSlot(new ResultSlot(iItemHandler, 4, 98, 29));
            this.addSlot(new ResultSlot(iItemHandler, 5, 116, 29));
            this.addSlot(new ResultSlot(iItemHandler, 6, 80, 47));
            this.addSlot(new ResultSlot(iItemHandler, 7, 98, 47));
            this.addSlot(new ResultSlot(iItemHandler, 8, 116, 47));

            this.addSlot(new UpgradeSlot(iItemHandler, 9, -11, 11));
            this.addSlot(new UpgradeSlot(iItemHandler, 10, -11,23));
            this.addSlot(new UpgradeSlot(iItemHandler, 11, -11,35));
            this.addSlot(new UpgradeSlot(iItemHandler, 12, -11,47));

            this.addSlot(new ComponentSlot(iItemHandler, 13, 8, 29));

            this.addSlot(new EnchantSlot(iItemHandler, 14, 44, 11));
            this.addSlot(new LinkSlot(iItemHandler, 15, 44, 29));
            this.addSlot(new FuelSlot(iItemHandler, 16, 44, 47));

            this.addSlot(new StructureSlot(iItemHandler, 17, 26, 29));
        });

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0 && data.get(7) > 0 && data.get(8) > 0 && data.get(9) > 0;
    }
    public MinerBlockEntity getBlockEntity(){
        return blockEntity;
    }
    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        int progressArrowSize = 62; // This is the height in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 18;  // must be the number of slots you have!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex + " Ignore this!");
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocksMiner.MINER.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

}