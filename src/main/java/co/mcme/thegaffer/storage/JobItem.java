/*  This file is part of TheGaffer.
 * 
 *  TheGaffer is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  TheGaffer is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with TheGaffer.  If not, see <http://www.gnu.org/licenses/>.
 */
package co.mcme.thegaffer.storage;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class JobItem {

    @Getter
    @Setter
    private String material;
    @Getter
    @Setter
    private int amount;
    @Getter
    @Setter
    private String displayName;
    @Getter
    @Setter
    private short durability;
    @Getter
    @Setter
    private List<String> lore;
    @Getter
    @Setter
    private BookMeta bookMeta;
    @Getter
    @Setter
    private LeatherArmorMeta armorMeta;

    public JobItem(ItemStack i) {
        if (i == null) {
            this.material = Material.AIR.name();
            this.amount = 1;
            return;
        }
        this.material = i.getType().name();
        this.amount = i.getAmount();
        this.durability = i.getDurability();
        if (i.hasItemMeta()) {
            if (i.getItemMeta().hasDisplayName()) {
                this.displayName = i.getItemMeta().getDisplayName();
            }
            if (i.getItemMeta().hasLore()) {
                this.lore = i.getItemMeta().getLore();
            }
            if (i.getItemMeta() instanceof BookMeta) {
                this.bookMeta = (BookMeta) i.getItemMeta();
            }
            if (i.getItemMeta() instanceof LeatherArmorMeta) {
                this.armorMeta = (LeatherArmorMeta) i.getItemMeta();
            }
        }
    }

    public JobItem() {

    }

    public ItemStack toBukkitItem() {
        ItemStack out = new ItemStack(Material.valueOf(material));
        out.setAmount(amount);
        out.setDurability(durability);
        if (displayName != null || lore != null) {
            ItemMeta meta = out.getItemMeta();
            if (lore != null) {
                meta.setLore(lore);
            }
            if (displayName != null) {
                meta.setDisplayName(displayName);
            }
            out.setItemMeta(meta);
        }
        if (bookMeta != null) {
            out.setItemMeta(bookMeta);
        }
        if (armorMeta != null) {
            out.setItemMeta(armorMeta);
        }
        return out;
    }
}
