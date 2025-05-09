package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.utility.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;

public class PickSoundGUI {

    private final Inventory gui;


    // TODO: Refactor class to use SoundData instead
    public PickSoundGUI(Player player) {
        this.gui = Bukkit.createInventory(null, 45, "Pick Sound");
        setFrames();
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(36, GUIUtils.ReturnButton());
        gui.setItem(40, FavoriteSoundsButton());
        gui.setItem(44, PickFromAllSoundsButton());

        gui.setItem(9, AmethystBreakSoundButton());
        gui.setItem(10, ItemPickupButton());
        gui.setItem(11, ExperienceOrbPickupButton());
        gui.setItem(12, ItemSpyglassUseButton());
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
        player.openInventory(gui);
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
    }

    private ItemStack PickFromAllSoundsButton() {
        return createItemStack(
                Material.JUKEBOX,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Pick From All Sounds",
                Arrays.asList(
                        ChatColor.WHITE + "ᴘɪᴄᴋ ᴀ ѕᴏᴜɴᴅ ꜰʀᴏᴍ ᴀʟʟ ѕᴏᴜɴᴅѕ",
                        ChatColor.WHITE + "ᴀᴠᴀɪʟᴀʙʟᴇ ɪɴ ᴍɪɴᴇᴄʀᴀꜰᴛ!",
                        "",
                        ChatColor.DARK_GRAY + "... ᴇᴠᴇɴ ᴛʜᴇ ᴡᴇɪʀᴅ ᴏɴᴇѕ ...")
        );
    }

    // Favorite Sounds Button (Nether Star)
    private ItemStack FavoriteSoundsButton() {
        return createItemStack(
                Material.NETHER_STAR,
                ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.GREEN + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ",
                        "",
                        ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ " + ChatColor.GREEN + "ꜰᴀᴠᴏʀɪᴛᴇ")
        );
    }

    private ItemStack PlayerLevelupButton() {
        return createItemStack(
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

    private ItemStack DecoratedPotBreakButton() {
        return createItemStack(
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

    private ItemStack AmethystBreakSoundButton() {
        return createItemStack(
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

    private ItemStack AmethystChimeButton() {
        return createItemStack(
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

    private ItemStack BeehiveExitSoundButton() {
        return createItemStack(
                Material.BEE_NEST,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Plop!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ʙᴇᴇʜɪᴠᴇ ᴇхɪᴛ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ"),
                true,
                true,
                false
        );
    }

    private ItemStack ItemSpyglassUseButton() {
        return createItemStack(
                Material.SPYGLASS,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Rattle!",
                Arrays.asList(
                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ɪᴛᴇᴍ ѕᴘʏɢʟᴀѕѕ ᴜѕᴇ",
                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
        );
    }

    private ItemStack ArmadilloBrushButton() {
        return createItemStack(
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


    private ItemStack BambooBreakSoundButton() {
        return createItemStack(
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

    private ItemStack SnifferEatButton() {
        return createItemStack(
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

    private ItemStack NetheriteBlockBreakButton() {
        return createItemStack(
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

    private ItemStack BoneBreakSoundButton() {
        return createItemStack(
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

    private ItemStack BubbleColumnBubblePopButton() {
        return createItemStack(
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

    private ItemStack BubbleColumnUpwardsAmbientButton() {
        return createItemStack(
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

    private ItemStack CalciteBreakButton() {
        return createItemStack(
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

    private ItemStack CopperBulbPlaceButton() {
        return createItemStack(
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

    private ItemStack EndPortalFrameFillButton() {
        return createItemStack(
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

    private ItemStack FungusBreakButton() {
        return createItemStack(
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

    private ItemStack LavaPopButton() {
        return createItemStack(
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

    private ItemStack ScaffoldingBreakButton() {
        return createItemStack(
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

    private ItemStack LodestonePlaceButton() {
        return createItemStack(
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

    private ItemStack SnowBreakButton() {
        return createItemStack(
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

    private ItemStack DeepslateBreakButton() {
        return createItemStack(
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

    private ItemStack VexHurtButton() {
        return createItemStack(
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

    private ItemStack DecoratedPotInsertButton() {
        return createItemStack(
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

    private ItemStack EnderEyeDeathButton() {
        return createItemStack(
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

    private ItemStack ItemPickupButton() {
        return createItemStack(
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

    private ItemStack ExperienceOrbPickupButton () {
        return createItemStack(
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