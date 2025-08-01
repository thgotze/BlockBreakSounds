package com.gotze.blockbreaksounds.util;

import com.gotze.blockbreaksounds.BlockBreakSoundsPlugin;
import com.gotze.blockbreaksounds.model.CurrentSoundData;
import com.gotze.blockbreaksounds.model.FavoriteSoundData;
import com.gotze.blockbreaksounds.model.SoundData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public final class GUIUtils {

    private GUIUtils() {}

    public static final ItemStack FRAME = createItemStack(
            Material.BLACK_STAINED_GLASS_PANE,
            null,
            null,
            false,
            false,
            true
    );

    public static final ItemStack RETURN_BUTTON = createItemStack(
            Material.ARROW,
            ChatColor.YELLOW + "" + ChatColor.BOLD + convertToSmallFont("← return")
    );

    public static final ItemStack FAVORITE_SOUNDS_BUTTON = createItemStack(
            Material.NETHER_STAR,
            ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("pick from your ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorited ") + ChatColor.WHITE + convertToSmallFont("sounds"),
                    "",
                    ChatColor.WHITE + convertToSmallFont("shift right click sounds to ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorite")
            )
    );

    public static ItemStack CurrentSoundDisplayButton(Player player) {
        SoundData playerCurrentSound = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (playerCurrentSound == null) {
            return createItemStack(
                    Material.GLASS_PANE,
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    List.of(
                            ChatColor.WHITE + convertToSmallFont("no sound set")
                    )
            );
        } else {
            return createItemStack(
                    (playerCurrentSound.getDisplayMaterial()),
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    Arrays.asList(
                            ChatColor.WHITE + convertToSmallFont("sound: ") + ChatColor.GRAY + convertToSmallFont(playerCurrentSound.getFormattedSoundName()),
                            ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", playerCurrentSound.getVolume() * 100)),
                            ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", playerCurrentSound.getPitch())),
                            "",
                            ChatColor.WHITE + convertToSmallFont("click to ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("playtest"),
                            ChatColor.WHITE + convertToSmallFont("drop item to ") + ChatColor.RED + ChatColor.BOLD + convertToSmallFont("clear"),
                            ChatColor.WHITE + convertToSmallFont("shift right click to ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorite")
                    ),
                    true,
                    true,
                    false
            );
        }
    }

    public static void currentSoundButtonHandler(Inventory clickedInventory, ClickType clickType, Player player, int slot) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) return;

        ItemStack clickedItem = clickedInventory.getItem(slot);
        if (clickedItem == null) return;

        if (clickType == ClickType.DROP) {
            GUIUtils.clearCurrentSound(clickedItem, clickedInventory, player, slot);
            return;
        }

        if (clickType == ClickType.SHIFT_RIGHT) {
            FavoriteSoundData.addSoundToFavorites(player, currentSoundData);
            GUIUtils.handleFavoritedLineSound(clickedInventory, slot, player);
            return;
        }

        if (clickedItem.getType() == Material.BARRIER) return;

        currentSoundData.playSoundData(player);
    }

    private static void clearCurrentSound(ItemStack clickedItem, Inventory gui, Player player, int slot) {
        Material materialOfCurrentSound = clickedItem.getType();

        switch (materialOfCurrentSound) {
            case GLASS_PANE:
                SoundUtils.playErrorSound(player);
                return;

            case BARRIER:
                SoundUtils.playErrorSound(player);
                CurrentSoundData.currentSound.remove(player.getUniqueId());
                gui.setItem(slot, GUIUtils.CurrentSoundDisplayButton(player));
                CurrentSoundData.saveCurrentSoundDataToYAML(player);
                return;

            default:
                final ItemStack confirmClearCurrentSoundItem = createItemStack(
                        Material.BARRIER,
                        ChatColor.RED + convertToSmallFont("drop again to clear")
                );
                gui.setItem(slot, confirmClearCurrentSoundItem);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        ItemStack itemStackAfterDelay = gui.getItem(slot);
                        if (itemStackAfterDelay == null) return;

                        if (itemStackAfterDelay.getType().equals(Material.BARRIER)) {
                            gui.setItem(slot, clickedItem);
                        }
                    }
                }.runTaskLater(BlockBreakSoundsPlugin.INSTANCE, 60L);
        }
    }

    public static void handleFavoritedLineSound(Inventory clickedInventory, int slot, Player player) {
        final String SOUND_FAVORITED = ChatColor.GREEN + "" + ChatColor.BOLD + convertToSmallFont("sound favorited! ⭐");
        final String MAX_FAVORITED = ChatColor.RED + "" + ChatColor.BOLD + convertToSmallFont("max favorites reached!");

        ItemStack clickedItem = clickedInventory.getItem(slot);
        if (clickedItem == null || clickedItem.getType() == Material.GLASS_PANE) return;

        ItemMeta itemMeta = clickedItem.getItemMeta();
        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();
        if (lore == null) return;

        if (lore.contains(MAX_FAVORITED)) return;

        if (FavoriteSoundData.favoriteSounds.get(player.getUniqueId()).size() >= 27) {
            lore.add(MAX_FAVORITED);
        } else if (!lore.contains(SOUND_FAVORITED)) {
            lore.add(SOUND_FAVORITED);
        } else {
            return;
        }

        itemMeta.setLore(lore);
        clickedItem.setItemMeta(itemMeta);
        clickedInventory.setItem(slot, clickedItem);
    }

    public static void handlePickedLineSound(Inventory clickedInventory, int pickedSoundIndex) {
        final String CLICK_TO_PICK = ChatColor.YELLOW + convertToSmallFont("click to pick sound");
        final String SOUND_PICKED = ChatColor.YELLOW + "" + ChatColor.BOLD + convertToSmallFont("sound picked! ♪");

        // Replace sound picked line with click to pick sound line for all sounds in gui
        for (int i = 9; i < 36; i++) {
            if (i == pickedSoundIndex) continue;

            ItemStack item = clickedInventory.getItem(i);
            if (item == null) break;
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta == null) break;
            List<String> lore = itemMeta.getLore();
            if (lore == null) break;

            if (lore.contains(SOUND_PICKED)) {
                lore.set(lore.indexOf(SOUND_PICKED), CLICK_TO_PICK);
            }
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
            clickedInventory.setItem(i, item);
        }

        // Replace pick sound line with sound picked line for clicked sound in gui
        ItemStack item = clickedInventory.getItem(pickedSoundIndex);
        if (item == null) return;

        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();
        if (lore == null) return;

        if (lore.contains(CLICK_TO_PICK)) {
            lore.set(lore.indexOf(CLICK_TO_PICK), SOUND_PICKED);
        }
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        clickedInventory.setItem(pickedSoundIndex, item);
    }
}