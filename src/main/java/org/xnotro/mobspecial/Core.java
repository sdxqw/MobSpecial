package org.xnotro.mobspecial;

import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Core extends JavaPlugin implements Listener {

    Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        logger.info( "[MobSpecial] > Plugin Enabled." );
        getCommand("ms").setExecutor( new CommandHandler());
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            if (event.getEntity().getCustomName() != "COOL") {
                Player player = event.getEntity().getKiller();
                ItemStack item = new ItemStack( Material.DIAMOND );
                player.getInventory().addItem( item );
            }
        }
    }
}
