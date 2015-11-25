package com.github.maxopoly.SkilUp.listeners.xpgains;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import com.github.maxopoly.SkilUp.skills.Skill;

public class ConsumptionListener extends AbstractXPListener {
	private Material material;
	private Integer durability;
	private String lore;
	public ConsumptionListener(Skill skill, int xp, Material material,
			Integer durability, String lore) {
		super(skill,xp);
		
	}
	@EventHandler
	public void catchEvent(PlayerItemConsumeEvent e) {
		ItemStack is = e.getItem();
		if (material == null || is.getType() == material) {
			if (durability == null || durability == is.getDurability()) {
				if (lore == null || (is.hasItemMeta() && is.getItemMeta().hasLore() && is.getItemMeta().getLore().equals(lore))) {
					giveXP(e.getPlayer());
				}
			}
		}
	}

}