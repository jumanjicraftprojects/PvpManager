package dev.appeazethecheese.pvpmanager.Cooldown;

import dev.appeazethecheese.pvpmanager.Main;

import java.util.TimerTask;
import org.bukkit.scheduler.BukkitTask;

public class CooldownTimer {
    private boolean started = false;
    private int secondsElapsed = 0;
    private final int totalSeconds;
    private final TimerTask timerTask;
    private BukkitTask internalTask;

    public CooldownTimer(TimerTask task, int seconds){
        this.timerTask = task;
        this.totalSeconds = seconds;
    }

    public void start() {
        schedule(timerTask);
    }

    public void stop() {
        if (internalTask != null) internalTask.cancel();
        internalTask = null;
        this.started = false;
    }

    private void schedule(TimerTask task) {
        internalTask = Main.Instance.getServer().getScheduler().runTaskTimer(Main.Instance, new Runnable() {
            @Override
            public void run() {
                secondsElapsed++;

                if(secondsElapsed >= totalSeconds){
                    started = false;
                    if (internalTask != null) internalTask.cancel();
                    internalTask = null;
                    if(task != null)
                        task.run();
                }
            }
        }, 0L, 20L);
        started = true;
    }

    public int getSecondsRemaining(){
        return totalSeconds - secondsElapsed;
    }

    public boolean isStarted() {
        return started;
    }
}
