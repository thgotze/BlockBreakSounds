package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.utils.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.utils.ButtonCreator.createButton;
import static com.gotze.blockBreakSounds.utils.GUIUtils.Frame;

public class PickSoundGUI {

    private final Inventory gui;
    private final Player player;

    public PickSoundGUI(Player player) {
        this.player = player;
        this.gui = Bukkit.createInventory(null, 45, "Pick Sound");
        setupGUI();
    }

    public void openPickSoundGUI(Player player) {
        player.openInventory(gui);
    }

    private void setupGUI() {
        setFrames();
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(44, PickFromAllSoundsButton());
        gui.setItem(40, FavoriteSoundsButton());
        gui.setItem(36, ReturnButton());

        gui.setItem(9, AmethystBreakSoundButton());
        gui.setItem(10, ItemPickupButton());
        gui.setItem(11, ExperienceOrbPickupButton());
        gui.setItem(12, ItemFrameRemoveItemButton());
        gui.setItem(13, PlayerLevelupButton());
        gui.setItem(14, ArmadilloBrushButton());
        gui.setItem(15, DecoratedPotBreakButton());
        gui.setItem(16, DecoratedPotInsertButton());
        gui.setItem(17, BoneBreakSoundButton());
        gui.setItem(18, BambooBreakSoundButton());
        gui.setItem(19, BeehiveExitSoundButton());
        gui.setItem(20, EnderEyeDeathButton());
        gui.setItem(21, BubbleColumnBubblePopButton());
        gui.setItem(22, BubbleColumnUpwardsAmbientButton());
        gui.setItem(23, CalciteBreakButton());
        gui.setItem(24, ScaffoldingBreakButton());
        gui.setItem(25, EndPortalFrameFillButton());
        gui.setItem(26, CopperBulbPlaceButton());
        gui.setItem(27, FungusBreakButton());
        gui.setItem(28, LavaPopButton());
        gui.setItem(29, LodestonePlaceButton());
        gui.setItem(30, AmethystChimeButton());
        gui.setItem(31, SnowBreakButton());
        gui.setItem(32, DeepslateBreakButton());
        gui.setItem(33, VexHurtButton());
        gui.setItem(34, SnifferEatButton());
        gui.setItem(35, NetheriteBlockBreakButton());
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, Frame());
        }
    }

    public static ItemStack PickFromAllSoundsButton() {
        return createButton(
                Material.JUKEBOX,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Pick From All Sounds",
                Arrays.asList(
                        ChatColor.WHITE + "ᴘɪᴄᴋ ᴀ ѕᴏᴜɴᴅ ꜰʀᴏᴍ ᴀʟʟ ѕᴏᴜɴᴅѕ",
                        ChatColor.WHITE + "ᴀᴠᴀɪʟᴀʙʟᴇ ɪɴ ᴍɪɴᴇᴄʀᴀꜰᴛ!",
                        "",
                        ChatColor.DARK_GRAY + "... ᴇᴠᴇɴ ᴛʜᴇ ᴡᴇɪʀᴅ ᴏɴᴇѕ ...")
        );
    }

    public static ItemStack FavoriteSoundsButton() {
        return createButton(
                Material.NETHER_STAR,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.YELLOW + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ",
                        "",
                        ChatColor.GRAY + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ ꜰᴀᴠᴏʀɪᴛᴇ")
        );
    }

    public static ItemStack ReturnButton() {
        return createButton(
                Material.ARROW,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "← ʀᴇᴛᴜʀɴ"
        );
    }

    public static ItemStack PlayerLevelupButton() {
        return createButton(
                Material.SUNFLOWER,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Glimmer!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ᴇɴᴛɪᴛʏ ᴘʟᴀʏᴇʀ ʟᴇᴠᴇʟᴜᴘ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₁₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₂.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack DecoratedPotBreakButton() {
        return createButton(
                Material.DECORATED_POT,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Clonk!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ᴅᴇᴄᴏʀᴀᴛᴇᴅ ᴘᴏᴛ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack AmethystBreakSoundButton() {
        return createButton(
                Material.AMETHYST_BLOCK,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Cling!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ᴀᴍᴇᴛʜʏѕᴛ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₂₅",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack AmethystChimeButton() {
        return createButton(
                Material.PINK_PETALS,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Chime!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ᴀᴍᴇᴛʜʏѕᴛ ʙʟᴏᴄᴋ ᴄʜɪᴍᴇ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack BeehiveExitSoundButton() {
        return createButton(
                Material.BEE_NEST,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Plop!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ʙᴇᴇʜɪᴠᴇ ᴇхɪᴛ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ"),
                true,
                false,
                true
        );
    }

    public static ItemStack ItemFrameRemoveItemButton() {
        return createButton(
                Material.ITEM_FRAME,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Smack!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ᴇɴᴛɪᴛʏ ɪᴛᴇᴍ ꜰʀᴀᴍᴇ ʀᴇᴍᴏᴠᴇ ɪᴛᴇᴍ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack ArmadilloBrushButton() {
        return createButton(
                Material.BRUSH,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Brushplop!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ᴇɴᴛɪᴛʏ ᴀʀᴍᴀᴅʟʟɪᴏ ʙʀᴜѕʜ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }


    public static ItemStack BambooBreakSoundButton() {
        return createButton(
                Material.BAMBOO,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Bamboo!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ʙᴀᴍʙᴏᴏ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack SnifferEatButton() {
        return createButton(
                Material.COOKED_BEEF,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Monch!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ᴇɴᴛɪᴛʏ ѕɴɪꜰꜰᴇʀ ᴇᴀᴛ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.DARK_GRAY + "ᴇᴀᴛ ᴀᴡᴀʏ ᴛʜᴇ ᴡᴏʀʟᴅ",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack NetheriteBlockBreakButton() {
        return createButton(
                Material.NETHERITE_BLOCK,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Clank!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ɴᴇᴛʜᴇʀɪᴛᴇ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack BoneBreakSoundButton() {
        return createButton(
                Material.BONE_BLOCK,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Clatter!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ʙᴏɴᴇ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack BubbleColumnBubblePopButton() {
        return createButton(
                Material.GLASS_BOTTLE,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Blip!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ʙᴜʙʙʟᴇ ᴄᴏʟᴜᴍɴ ʙᴜʙʙʟᴇ ᴘᴏᴘ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack BubbleColumnUpwardsAmbientButton() {
        return createButton(
                Material.CAULDRON,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Sizzle!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ʙᴜʙʙʟᴇ ᴄᴏʟᴜᴍɴ ᴜᴘᴡᴀʀᴅѕ ᴀᴍʙɪᴇɴᴛ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.DARK_GRAY + "ᴡʜᴏ ʟᴇᴛ ʜɪᴍ ᴄᴏᴏᴋ?",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack CalciteBreakButton() {
        return createButton(
                Material.CALCITE,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Crumble!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ᴄᴀʟᴄɪᴛᴇ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack CopperBulbPlaceButton() {
        return createButton(
                Material.COPPER_BULB,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Klink!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ᴄᴏᴘᴘᴇʀ ʙᴜʟʙ ᴘʟᴀᴄᴇ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack EndPortalFrameFillButton() {
        return createButton(
                Material.END_PORTAL_FRAME,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Whomp!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ᴇɴᴅ ᴘᴏʀᴛᴀʟ ꜰʀᴀᴍᴇ ꜰɪʟʟ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack FungusBreakButton() {
        return createButton(
                Material.OAK_PLANKS,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Creak!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ꜰᴜɴɢᴜѕ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack LavaPopButton() {
        return createButton(
                Material.LAVA_BUCKET,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Bloop!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ʟᴀᴠᴀ ᴘᴏᴘ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack ScaffoldingBreakButton() {
        return createButton(
                Material.SCAFFOLDING,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Snap!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ѕᴄᴀꜰꜰᴏʟᴅɪɴɢ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack LodestonePlaceButton() {
        return createButton(
                Material.LODESTONE,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Quink!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ʟᴏᴅᴇѕᴛᴏɴᴇ ᴘʟᴀᴄᴇ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack SnowBreakButton() {
        return createButton(
                Material.SNOW_BLOCK,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Snow!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ѕɴᴏᴡ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack DeepslateBreakButton() {
        return createButton(
                Material.COBBLED_DEEPSLATE,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Grumble!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ᴅᴇᴇᴘѕʟᴀᴛᴇ ʙʀᴇᴀᴋ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack VexHurtButton() {
        return createButton(
                Material.SPECTRAL_ARROW,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Pew!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ᴇɴᴛɪᴛʏ ᴠᴇх ʜᴜʀᴛ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₅₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack DecoratedPotInsertButton() {
        return createButton(
                Material.HOPPER,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Pop!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ᴅᴇᴄᴏʀᴀᴛᴇᴅ ᴘᴏᴛ ɪɴѕᴇʀᴛ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack EnderEyeDeathButton() {
        return createButton(
                Material.ENDER_EYE ,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Whoosh!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ᴇɴᴛɪᴛʏ ᴇɴᴅᴇʀ ᴇʏᴇ ᴅᴇᴀᴛʜ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack ItemPickupButton() {
        return createButton(
                Material.PUFFERFISH,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Pickup!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ᴇɴᴛɪᴛʏ ɪᴛᴇᴍ ᴘɪᴄᴋᴜᴘ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    public static ItemStack ExperienceOrbPickupButton () {
        return createButton(
                Material.EXPERIENCE_BOTTLE,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Ding!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ᴇɴᴛɪᴛʏ ᴇхᴘᴇʀɪᴇɴᴄᴇ ᴏʀʙ ᴘɪᴄᴋᴜᴘ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₁₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₂.₀₀",
                        "",
                        ChatColor.DARK_GRAY + "ᴀ ʜʏᴘɪᴄᴋʟᴇ ꜰᴀᴠᴏʀɪᴛᴇ",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }
}


