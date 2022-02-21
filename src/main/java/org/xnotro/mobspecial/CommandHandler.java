package org.xnotro.mobspecial;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("[MobSpecial] > you cant use this command on console.");
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            player.sendMessage("[MobSpecial] > usage: /ms spawn [x:y:z]");
        }

        if(args.length >= 1) {
            player.sendMessage("[MobSpecial] > i think its like /ms spawn [x:y:z]");
            if (args[0].equalsIgnoreCase( "spawn" )) {
                if (args.length == 2) {
                    player.sendMessage( "[MobSpecial] > please specify x:y:z. you only specified X: " + args[1] );
                } else if (args.length == 3) {
                    player.sendMessage( "[MobSpecial] > please specify x:y:z. you only specified X: " + args[1] + " Y: " + args[2] );
                } else if (args.length == 4) {
                    try {
                        World world = player.getWorld();
                        Location location = new Location( world, Integer.parseInt( args[1] ), Integer.parseInt( args[2] ), Integer.parseInt( args[3] ) );
                        LivingEntity entity = (LivingEntity) world.spawnEntity( location, EntityType.SHEEP );
                        entity.setCustomName( "COOL" );
                        player.sendMessage( "[MobSpecial] > you spawned " + entity.getName() + " at location: " + "X:" + args[1] + " Y:" + args[2] + " Z:" + args[3] );
                    } catch (NumberFormatException e) {
                        player.sendMessage( "[MobSpecial] > do you really just type that? X: " + args[1] + " Y: " + args[2] + " Z: " + args[3]);
                    }
                } else player.sendMessage( "[MobSpecial] > please specify x:y:z" );
            }
        }
        return true;
    }
}
