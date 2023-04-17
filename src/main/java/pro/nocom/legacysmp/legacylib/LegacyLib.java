package pro.nocom.legacysmp.legacylib;

import net.minecraft.server.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.command.ColouredConsoleSender;
import org.bukkit.plugin.java.JavaPlugin;
import pro.nocom.legacysmp.legacylib.listener.BroadcastListener;

import javax.annotation.Nullable;
import java.util.LinkedHashSet;
import java.util.Set;

public final class LegacyLib extends JavaPlugin {
    private final Set<BroadcastListener> broadcastListeners = new LinkedHashSet<>();
    private static LegacyLib instance;
    private ColouredConsoleSender colouredConsoleSender;

    public static @Nullable LegacyLib getInstance() {
        return instance;
    }

    public void unregister(final BroadcastListener listener) {
        this.broadcastListeners.remove(listener);
    }

    public void register(final BroadcastListener listener) {
        this.broadcastListeners.add(listener);
    }

    public void broadcast(final String type, final String message) {
        Bukkit.broadcastMessage(message);

        this.colouredConsoleSender.sendMessage(message);

        this.broadcastListeners.forEach(l -> l.onMessage(type, message));
    }

    @Override
    public void onDisable() {
        instance = null;

        this.broadcastListeners.clear();
    }

    @Override
    public void onEnable() {
        instance = this;

        final Server server = Bukkit.getServer();
        final CraftServer craftServer = (CraftServer) server;
        final MinecraftServer minecraftServer = craftServer.getServer();

        this.colouredConsoleSender = minecraftServer.console;
    }
}
