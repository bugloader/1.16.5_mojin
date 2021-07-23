package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;

public class GasMask extends ArmorItem {

    public GasMask(){
        super(ArmorMaterial.IRON, EquipmentSlotType.HEAD, new Properties().tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("gas_mask");
        ItemHandler.ITEMS.add(this);
    }

}
