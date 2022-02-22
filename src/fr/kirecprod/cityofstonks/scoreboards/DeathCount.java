package fr.kirecprod.cityofstonks.scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.*;


public class DeathCount implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        final Player player = event.getEntity().getPlayer();

        final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        final Objective objective = scoreboard.registerNewObjective("deathCount", "deathCount");

        objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);

        Score score = objective.getScore(player.getDisplayName() + player.getStatistic(Statistic.DEATHS));

        player.setScoreboard(scoreboard);


    }
}
