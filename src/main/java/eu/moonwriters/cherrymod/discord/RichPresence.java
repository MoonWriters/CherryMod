package eu.moonwriters.cherrymod.discord;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class RichPresence {
    private long start;
    public DiscordRPC rpc = DiscordRPC.INSTANCE;

    public void create() {
        DiscordEventHandlers handlers = new DiscordEventHandlers();

        handlers.ready = (user) -> System.out.println("Ready!");
        start = System.currentTimeMillis();

        rpc.Discord_Initialize("1239296740008525894", handlers, true, "");

    }

    public void update(String state, String details) {
        DiscordRichPresence richPresence = new DiscordRichPresence();
        richPresence.state = state;
        richPresence.details = details;
        richPresence.largeImageKey = "logo";
        richPresence.startTimestamp = start;

        rpc.Discord_UpdatePresence(richPresence);

    }
}
