package minegame159.meteorclient;

import meteorclient.setting.*;
import java.awt.*;
import baritone.api.*;

public class c37462 extends c36626
{
    private static final String[] f37463;
    
    public c37462() {
        super(TopBarType.Baritone);
        final Settings settings = BaritoneAPI.getSettings();
        final c34561 c37054 = new c34561();
        final meteorclient.setting.Settings m34588 = c37054.m34588("Allow");
        final meteorclient.setting.Settings m34589 = c37054.m34588("Assume");
        final meteorclient.setting.Settings m34590 = c37054.m34588("Render");
        final meteorclient.setting.Settings m34591 = c37054.m34588("Penalties");
        final meteorclient.setting.Settings m34592 = c37054.m34588("Colors");
        final meteorclient.setting.Settings m34593 = c37054.m34588("Other");
        final Boolean b;
        m34588.addValue((Value<Object>)new c34427.c34657().m34664("allow-break").m34667("Allow Baritone to break blocks.").m34670((boolean)settings.allowBreak.defaultValue).m34673(value -> {
            settings.allowBreak.value = value;
            b = value;
            return;
        }).m34676(value2 -> value2.m33468(settings.allowBreak.value)).m34679());
        final Boolean b2;
        m34588.addValue((Value<Object>)new c34427.c34657().m34664("allow-sprint").m34667("Allow Baritone to sprint.").m34670((boolean)settings.allowSprint.defaultValue).m34673(value3 -> {
            settings.allowSprint.value = value3;
            b2 = value3;
            return;
        }).m34676(value4 -> value4.m33468(settings.allowSprint.value)).m34679());
        final Boolean b3;
        m34588.addValue((Value<Object>)new c34427.c34657().m34664("allow-place").m34667("Allow Baritone to place blocks.").m34670((boolean)settings.allowPlace.defaultValue).m34673(value5 -> {
            settings.allowPlace.value = value5;
            b3 = value5;
            return;
        }).m34676(value6 -> value6.m33468(settings.allowPlace.value)).m34679());
        final Boolean b4;
        m34588.addValue((Value<Object>)new c34427.c34657().m34664("allow-inventory").m34667("Allow Baritone to move items in your inventory to your hotbar.").m34670((boolean)settings.allowInventory.defaultValue).m34673(value7 -> {
            settings.allowInventory.value = value7;
            b4 = value7;
            return;
        }).m34676(value8 -> value8.m33468(settings.allowInventory.value)).m34679());
        final Boolean b5;
        m34588.addValue((Value<Object>)new c34427.c34657().m34664("allow-parkour").m34667("Allow Baritone to perform parkour.").m34670((boolean)settings.allowParkour.defaultValue).m34673(value9 -> {
            settings.allowParkour.value = value9;
            b5 = value9;
            return;
        }).m34676(value10 -> value10.m33468(settings.allowParkour.value)).m34679());
        final Boolean b6;
        m34588.addValue((Value<Object>)new c34427.c34657().m34664("allow-parkour-place").m34667("Allow Baritone to place blocks to perform parkour.").m34670((boolean)settings.allowParkourPlace.defaultValue).m34673(value11 -> {
            settings.allowParkourPlace.value = value11;
            b6 = value11;
            return;
        }).m34676(value12 -> value12.m33468(settings.allowParkourPlace.value)).m34679());
        final Boolean b7;
        m34588.addValue((Value<Object>)new c34427.c34657().m34664("allow-water-bucket-fall").m34667("Allow Baritone to fall arbitrary distances and place a water bucket beneath it. Reliability: questionable.").m34670((boolean)settings.allowWaterBucketFall.value).m34673(value13 -> {
            settings.allowWaterBucketFall.value = value13;
            b7 = value13;
            return;
        }).m34676(value14 -> value14.m33468(settings.allowWaterBucketFall.value)).m34679());
        final Boolean b8;
        m34589.addValue((Value<Object>)new c34427.c34657().m34664("assume-walk-on-water").m34667("Allow Baritone to assume it can walk on still water just like any other block. This functionality is assumed to be provided by a separate library that might have imported Baritone.").m34670((boolean)settings.assumeWalkOnWater.defaultValue).m34673(value15 -> {
            settings.assumeWalkOnWater.value = value15;
            b8 = value15;
            return;
        }).m34676(value16 -> value16.m33468(settings.assumeWalkOnWater.value)).m34679());
        final Boolean b9;
        m34589.addValue((Value<Object>)new c34427.c34657().m34664("assume-walk-on-lava").m34667("If you have Fire Resistance and Jesus then I guess you could turn this on lol.").m34670((boolean)settings.assumeWalkOnLava.defaultValue).m34673(value17 -> {
            settings.assumeWalkOnLava.value = value17;
            b9 = value17;
            return;
        }).m34676(value18 -> value18.m33468(settings.assumeWalkOnLava.value)).m34679());
        final Boolean b10;
        m34589.addValue((Value<Object>)new c34427.c34657().m34664("assume-step").m34667("Assume step functionality; don't jump on an Ascend.").m34670((boolean)settings.assumeStep.defaultValue).m34673(value19 -> {
            settings.assumeStep.value = value19;
            b10 = value19;
            return;
        }).m34676(value20 -> value20.m33468(settings.assumeStep.value)).m34679());
        final Boolean b11;
        m34589.addValue((Value<Object>)new c34427.c34657().m34664("assume-safe-walk").m34667("Assume safe walk functionality; don't sneak on a backplace traverse.").m34670((boolean)settings.assumeSafeWalk.defaultValue).m34673(value21 -> {
            settings.assumeSafeWalk.value = value21;
            b11 = value21;
            return;
        }).m34676(value22 -> value22.m33468(settings.assumeSafeWalk.value)).m34679());
        final Boolean b12;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-path").m34667("Render the path.").m34670((boolean)settings.renderPath.defaultValue).m34673(value23 -> {
            settings.renderPath.value = value23;
            b12 = value23;
            return;
        }).m34676(value24 -> value24.m33468(settings.renderPath.value)).m34679());
        final Boolean b13;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-path-as-line").m34667("Render the path as line instead of a frickin thingy.").m34670((boolean)settings.renderPathAsLine.defaultValue).m34673(value25 -> {
            settings.renderPathAsLine.value = value25;
            b13 = value25;
            return;
        }).m34676(value26 -> value26.m33468(settings.renderPathAsLine.value)).m34679());
        final Boolean b14;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-goal").m34667("Render the goal.").m34670((boolean)settings.renderGoal.defaultValue).m34673(value27 -> {
            settings.renderGoal.value = value27;
            b14 = value27;
            return;
        }).m34676(value28 -> value28.m33468(settings.renderGoal.value)).m34679());
        final Boolean b15;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-selection-boxes").m34667("Render the selection boxes.").m34670((boolean)settings.renderSelectionBoxes.defaultValue).m34673(value29 -> {
            settings.renderSelectionBoxes.value = value29;
            b15 = value29;
            return;
        }).m34676(value30 -> value30.m33468(settings.renderSelectionBoxes.value)).m34679());
        final Boolean b16;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-goal-ignore-depth").m34667("Ignore depth when rendering the goal").m34670((boolean)settings.renderGoalIgnoreDepth.defaultValue).m34673(value31 -> {
            settings.renderGoalIgnoreDepth.value = value31;
            b16 = value31;
            return;
        }).m34676(value32 -> value32.m33468(settings.renderGoalIgnoreDepth.value)).m34679());
        final Boolean b17;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-goal-XZ-beacon").m34667("Renders X/Z type Goals with the vanilla beacon beam effect. Combining this with renderGoalIgnoreDepth will cause strange render clipping.").m34670((boolean)settings.renderGoalXZBeacon.defaultValue).m34673(value33 -> {
            settings.renderGoalXZBeacon.value = value33;
            b17 = value33;
            return;
        }).m34676(value34 -> value34.m33468(settings.renderGoalXZBeacon.value)).m34679());
        final Boolean b18;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-path-ignore-deph").m34667("Ignore path when rendering the path.").m34670((boolean)settings.renderPathIgnoreDepth.defaultValue).m34673(value35 -> {
            settings.renderPathIgnoreDepth.value = value35;
            b18 = value35;
            return;
        }).m34676(value36 -> value36.m33468(settings.renderPathIgnoreDepth.value)).m34679());
        final Boolean b19;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-selection").m34667("Render the selections.").m34670((boolean)settings.renderSelection.defaultValue).m34673(value37 -> {
            settings.renderSelection.value = value37;
            b19 = value37;
            return;
        }).m34676(value38 -> value38.m33468(settings.renderSelection.value)).m34679());
        final Boolean b20;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-selection-ignore-depth").m34667("Ignore depth when rendering selection.").m34670((boolean)settings.renderSelectionBoxesIgnoreDepth.defaultValue).m34673(value39 -> {
            settings.renderSelectionIgnoreDepth.value = value39;
            b20 = value39;
            return;
        }).m34676(value40 -> value40.m33468(settings.renderSelectionIgnoreDepth.value)).m34679());
        final Boolean b21;
        m34590.addValue((Value<Object>)new c34427.c34657().m34664("render-selection-corners.").m34667("Render the selection corners.").m34670((boolean)settings.renderSelectionCorners.defaultValue).m34673(value41 -> {
            settings.renderSelectionCorners.value = value41;
            b21 = value41;
            return;
        }).m34676(value42 -> value42.m33468(settings.renderSelectionCorners.value)).m34679());
        final Double n;
        m34591.addValue((Value<Object>)new c37033.c38947().m38959("block-placement-penalty").m38962("Decrease to make Baritone more often consider would require placing blocks.").m38965((double)settings.blockPlacementPenalty.defaultValue).m38968(value43 -> {
            settings.blockPlacementPenalty.value = value43;
            n = value43;
            return;
        }).m38971(value44 -> value44.m33468(settings.blockPlacementPenalty.value)).m38974(0.0).m38988());
        final Double n2;
        m34591.addValue((Value<Object>)new c37033.c38947().m38959("block-break-additional-penalty").m38962("This is just a tiebreaker to make it less likely to break blocks if it can avoid it.").m38965((double)settings.blockBreakAdditionalPenalty.defaultValue).m38968(value45 -> {
            settings.blockBreakAdditionalPenalty.value = value45;
            n2 = value45;
            return;
        }).m38971(value46 -> value46.m33468(settings.blockBreakAdditionalPenalty.value)).m38974(0.0).m38988());
        final Double n3;
        m34591.addValue((Value<Object>)new c37033.c38947().m38959("jump-penalty").m38962("Additional penalty for hitting the space bar (ascend, pillar, or parkour) because it uses hunger.").m38965((double)settings.jumpPenalty.defaultValue).m38968(value47 -> {
            settings.jumpPenalty.value = value47;
            n3 = value47;
            return;
        }).m38971(value48 -> value48.m33468(settings.jumpPenalty.value)).m38974(0.0).m38988());
        final Double n4;
        m34591.addValue((Value<Object>)new c37033.c38947().m38959("walk-on-water-penalty").m38962("Walking on water uses up hunger really quick, so penalize it.").m38965((double)settings.walkOnWaterOnePenalty.defaultValue).m38968(value49 -> {
            settings.walkOnWaterOnePenalty.value = value49;
            n4 = value49;
            return;
        }).m38971(value50 -> value50.m33468(settings.walkOnWaterOnePenalty.value)).m38974(0.0).m38988());
        final Settings.Setting colorCurrentPath;
        final Color value105;
        final Color color;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-current-path").m33190("The color of the current path.").m33193(new c37042((Color)settings.colorCurrentPath.defaultValue)).m33196(c37042 -> {
            colorCurrentPath = settings.colorCurrentPath;
            value105 = new Color(c37042.m37056(), true);
            colorCurrentPath.value = value105;
            color = value105;
            return;
        }).m33199(value51 -> value51.m33468(new c37042(((Color)settings.colorCurrentPath.value).getRGB()))).m33202());
        final Settings.Setting colorNextPath;
        final Color value106;
        final Color color2;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-next-path").m33190("The color of the next path.").m33193(new c37042((Color)settings.colorNextPath.defaultValue)).m33196(c37043 -> {
            colorNextPath = settings.colorNextPath;
            value106 = new Color(c37043.m37056(), true);
            colorNextPath.value = value106;
            color2 = value106;
            return;
        }).m33199(value52 -> value52.m33468(new c37042(((Color)settings.colorNextPath.value).getRGB()))).m33202());
        final Settings.Setting colorBlocksToBreak;
        final Color value107;
        final Color color3;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-blocks-to-break").m33190("The color of the blocks to break.").m33193(new c37042((Color)settings.colorBlocksToBreak.defaultValue)).m33196(c37044 -> {
            colorBlocksToBreak = settings.colorBlocksToBreak;
            value107 = new Color(c37044.m37056(), true);
            colorBlocksToBreak.value = value107;
            color3 = value107;
            return;
        }).m33199(value53 -> value53.m33468(new c37042(((Color)settings.colorBlocksToBreak.value).getRGB()))).m33202());
        final Settings.Setting colorBlocksToPlace;
        final Color value108;
        final Color color4;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-blocks-to-place").m33190("The color of the blocks to place.").m33193(new c37042((Color)settings.colorBlocksToPlace.defaultValue)).m33196(c37045 -> {
            colorBlocksToPlace = settings.colorBlocksToPlace;
            value108 = new Color(c37045.m37056(), true);
            colorBlocksToPlace.value = value108;
            color4 = value108;
            return;
        }).m33199(value54 -> value54.m33468(new c37042(((Color)settings.colorBlocksToPlace.value).getRGB()))).m33202());
        final Settings.Setting colorBlocksToWalkInto;
        final Color value109;
        final Color color5;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-blocks-to-walk-into").m33190("The color of the blocks to walk into.").m33193(new c37042((Color)settings.colorBlocksToWalkInto.defaultValue)).m33196(c37046 -> {
            colorBlocksToWalkInto = settings.colorBlocksToWalkInto;
            value109 = new Color(c37046.m37056(), true);
            colorBlocksToWalkInto.value = value109;
            color5 = value109;
            return;
        }).m33199(value55 -> value55.m33468(new c37042(((Color)settings.colorBlocksToWalkInto.value).getRGB()))).m33202());
        final Settings.Setting colorBestPathSoFar;
        final Color value110;
        final Color color6;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-best-path-so-far").m33190("The color of the best path so far.").m33193(new c37042((Color)settings.colorBestPathSoFar.defaultValue)).m33196(c37047 -> {
            colorBestPathSoFar = settings.colorBestPathSoFar;
            value110 = new Color(c37047.m37056(), true);
            colorBestPathSoFar.value = value110;
            color6 = value110;
            return;
        }).m33199(value56 -> value56.m33468(new c37042(((Color)settings.colorBestPathSoFar.value).getRGB()))).m33202());
        final Settings.Setting colorMostRecentConsidered;
        final Color value111;
        final Color color7;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-most-recent-considered").m33190("The color of the most recent considered node.").m33193(new c37042((Color)settings.colorMostRecentConsidered.defaultValue)).m33196(c37048 -> {
            colorMostRecentConsidered = settings.colorMostRecentConsidered;
            value111 = new Color(c37048.m37056(), true);
            colorMostRecentConsidered.value = value111;
            color7 = value111;
            return;
        }).m33199(value57 -> value57.m33468(new c37042(((Color)settings.colorMostRecentConsidered.value).getRGB()))).m33202());
        final Settings.Setting colorGoalBox;
        final Color value112;
        final Color color8;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-goal-box").m33190("The color of the goal box.").m33193(new c37042((Color)settings.colorGoalBox.defaultValue)).m33196(c37049 -> {
            colorGoalBox = settings.colorGoalBox;
            value112 = new Color(c37049.m37056(), true);
            colorGoalBox.value = value112;
            color8 = value112;
            return;
        }).m33199(value58 -> value58.m33468(new c37042(((Color)settings.colorGoalBox.value).getRGB()))).m33202());
        final Settings.Setting colorInvertedGoalBox;
        final Color value113;
        final Color color9;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-inverted-goal-box").m33190("The color of the goal box when it's inverted.").m33193(new c37042((Color)settings.colorInvertedGoalBox.defaultValue)).m33196(c37050 -> {
            colorInvertedGoalBox = settings.colorInvertedGoalBox;
            value113 = new Color(c37050.m37056(), true);
            colorInvertedGoalBox.value = value113;
            color9 = value113;
            return;
        }).m33199(value59 -> value59.m33468(new c37042(((Color)settings.colorInvertedGoalBox.value).getRGB()))).m33202());
        final Settings.Setting colorSelection;
        final Color value114;
        final Color color10;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-selection").m33190("The color of all selections.").m33193(new c37042((Color)settings.colorSelection.defaultValue)).m33196(c37051 -> {
            colorSelection = settings.colorSelection;
            value114 = new Color(c37051.m37056(), true);
            colorSelection.value = value114;
            color10 = value114;
            return;
        }).m33199(value60 -> value60.m33468(new c37042(((Color)settings.colorSelection.value).getRGB()))).m33202());
        final Settings.Setting colorSelectionPos1;
        final Color value115;
        final Color color11;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-selection-pos-1").m33190("The color of the selection pos 1.").m33193(new c37042((Color)settings.colorSelectionPos1.defaultValue)).m33196(c37052 -> {
            colorSelectionPos1 = settings.colorSelectionPos1;
            value115 = new Color(c37052.m37056(), true);
            colorSelectionPos1.value = value115;
            color11 = value115;
            return;
        }).m33199(value61 -> value61.m33468(new c37042(((Color)settings.colorSelectionPos1.value).getRGB()))).m33202());
        final Settings.Setting colorSelectionPos2;
        final Color value116;
        final Color color12;
        m34592.addValue((Value<Object>)new c33179.c33180().m33187("color-selection-pos-2").m33190("The color of the selection pos 2.").m33193(new c37042((Color)settings.colorSelectionPos2.defaultValue)).m33196(c37053 -> {
            colorSelectionPos2 = settings.colorSelectionPos2;
            value116 = new Color(c37053.m37056(), true);
            colorSelectionPos2.value = value116;
            color12 = value116;
            return;
        }).m33199(value62 -> value62.m33468(new c37042(((Color)settings.colorSelectionPos2.value).getRGB()))).m33202());
        final Boolean b22;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("legit-mine").m34667("Disallow MineBehavior from using X-Ray to see where the ores are. Turn this option on to force it to mine \"legit\" where it will only mine an ore once it can actually see it, so it won't do or know anything that a normal player couldn't. If you don't want it to look like you're X-Raying, turn this on.").m34670((boolean)settings.legitMine.defaultValue).m34673(value63 -> {
            settings.legitMine.value = value63;
            b22 = value63;
            return;
        }).m34676(value64 -> value64.m33468(settings.legitMine.value)).m34679());
        final Boolean b23;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("backfill").m34667("Fill in blocks behind you").m34670((boolean)settings.backfill.defaultValue).m34673(value65 -> {
            settings.backfill.value = value65;
            b23 = value65;
            return;
        }).m34676(value66 -> value66.m33468(settings.backfill.value)).m34679());
        final Integer n5;
        m34593.addValue((Value<Object>)new c32369.c32370().m32381("follow-radius").m32384("The radius (for the GoalNear) of how close to your target position you actually have to be.").m32387((int)settings.followRadius.defaultValue).m32390(value67 -> {
            settings.followRadius.value = value67;
            n5 = value67;
            return;
        }).m32393(value68 -> value68.m33468(settings.followRadius.value)).m32396(0).m32408());
        final Boolean b24;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("build-in-layers").m34667("Don't consider the next layer in builder until the current one is done.").m34670((boolean)settings.buildInLayers.defaultValue).m34673(value69 -> {
            settings.buildInLayers.value = value69;
            b24 = value69;
            return;
        }).m34676(value70 -> value70.m33468(settings.buildInLayers.value)).m34679());
        final Boolean b25;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("layer-order").m34667("false = build from bottom to top, true = build from top to bottom").m34670((boolean)settings.layerOrder.defaultValue).m34673(value71 -> {
            settings.layerOrder.value = value71;
            b25 = value71;
            return;
        }).m34676(value72 -> value72.m33468(settings.layerOrder.value)).m34679());
        final Boolean b26;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("mine-scan-dropped-items").m34667("While mining, should it also consider dropped items of the correct type as a pathing destination (as well as ore blocks)?").m34670((boolean)settings.mineScanDroppedItems.defaultValue).m34673(value73 -> {
            settings.mineScanDroppedItems.value = value73;
            b26 = value73;
            return;
        }).m34676(value74 -> value74.m33468(settings.mineScanDroppedItems.value)).m34679());
        final Boolean b27;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("anti-cheat-compatibility").m34667("Will cause some minor behavioral differences to ensure that Baritone works on anticheats.").m34670((boolean)settings.antiCheatCompatibility.defaultValue).m34673(value75 -> {
            settings.antiCheatCompatibility.value = value75;
            b27 = value75;
            return;
        }).m34676(value76 -> value76.m33468(settings.antiCheatCompatibility.value)).m34679());
        final Boolean b28;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("censor-coordinates").m34667("Censor coordinates in goals and block positions.").m34670((boolean)settings.censorCoordinates.defaultValue).m34673(value77 -> {
            settings.censorCoordinates.value = value77;
            b28 = value77;
            return;
        }).m34676(value78 -> value78.m33468(settings.censorCoordinates.value)).m34679());
        final Boolean b29;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("censor-ran-commands").m34667("Censor arguments to ran commands, to hide, for example, coordinates to @goal.").m34670((boolean)settings.censorRanCommands.defaultValue).m34673(value79 -> {
            settings.censorRanCommands.value = value79;
            b29 = value79;
            return;
        }).m34676(value80 -> value80.m33468(settings.censorRanCommands.value)).m34679());
        final Boolean b30;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("container-memory").m34667("Remember the contents of containers (chests, echests, furnaces).").m34670((boolean)settings.containerMemory.defaultValue).m34673(value81 -> {
            settings.containerMemory.value = value81;
            b30 = value81;
            return;
        }).m34676(value82 -> value82.m33468(settings.containerMemory.value)).m34679());
        final Boolean b31;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("desktop-notifications").m34667("Desktop notifications.").m34670((boolean)settings.desktopNotifications.defaultValue).m34673(value83 -> {
            settings.desktopNotifications.value = value83;
            b31 = value83;
            return;
        }).m34676(value84 -> value84.m33468(settings.desktopNotifications.value)).m34679());
        final Boolean b32;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("echo-commands").m34667("Echo commands to chat when they are run.").m34670((boolean)settings.echoCommands.defaultValue).m34673(value85 -> {
            settings.echoCommands.value = value85;
            b32 = value85;
            return;
        }).m34676(value86 -> value86.m33468(settings.echoCommands.value)).m34679());
        final Boolean b33;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("enter-portal.").m34667("When running a goto towards a nether portal block, walk all the way into the portal instead of stopping one block before.").m34670((boolean)settings.enterPortal.defaultValue).m34673(value87 -> {
            settings.enterPortal.value = value87;
            b33 = value87;
            return;
        }).m34676(value88 -> value88.m33468(settings.enterPortal.value)).m34679());
        final Boolean b34;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("free-look").m34667("Move without having to force the client-sided rotations.").m34670((boolean)settings.freeLook.defaultValue).m34673(value89 -> {
            settings.freeLook.value = value89;
            b34 = value89;
            return;
        }).m34676(value90 -> value90.m33468(settings.freeLook.value)).m34679());
        final Boolean b35;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("map-art-mode").m34667("Build in map art mode, which makes baritone only care about the top block in each column.").m34670((boolean)settings.mapArtMode.defaultValue).m34673(value91 -> {
            settings.mapArtMode.value = value91;
            b35 = value91;
            return;
        }).m34676(value92 -> value92.m33468(settings.mapArtMode.value)).m34679());
        final Integer n6;
        m34593.addValue((Value<Object>)new c32369.c32370().m32381("max-fall-height-bucket").m32384("How far are you allowed to fall onto solid ground (with a water bucket)? It's not that reliable, so I've set it below what would kill an unarmored player (23).").m32387((int)settings.maxFallHeightBucket.defaultValue).m32390(value93 -> {
            settings.maxFallHeightBucket.value = value93;
            n6 = value93;
            return;
        }).m32393(value94 -> value94.m33468(settings.maxFallHeightBucket.value)).m32396(0).m32408());
        final Integer n7;
        m34593.addValue((Value<Object>)new c32369.c32370().m32381("max-fall-height-no-water").m32384("How far are you allowed to fall onto solid ground (without a water bucket)? 3 won't deal any damage.").m32387((int)settings.maxFallHeightNoWater.defaultValue).m32390(value95 -> {
            settings.maxFallHeightNoWater.value = value95;
            n7 = value95;
            return;
        }).m32393(value96 -> value96.m33468(settings.maxFallHeightNoWater.value)).m32396(0).m32408());
        final Boolean b36;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("prefer-silk-touch").m34667("Always prefer silk touch tools over regular tools.").m34670((boolean)settings.preferSilkTouch.defaultValue).m34673(value97 -> {
            settings.preferSilkTouch.value = value97;
            b36 = value97;
            return;
        }).m34676(value98 -> value98.m33468(settings.preferSilkTouch.value)).m34679());
        final Boolean b37;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("replant-crops").m34667("Replant normal Crops while farming and leave cactus and sugarcane to regrow.").m34670((boolean)settings.replantCrops.defaultValue).m34673(value99 -> {
            settings.replantCrops.value = value99;
            b37 = value99;
            return;
        }).m34676(value100 -> value100.m33468(settings.replantCrops.value)).m34679());
        final Boolean b38;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("replant-nether-wart").m34667("Replant nether wart while farming.").m34670((boolean)settings.replantNetherWart.defaultValue).m34673(value101 -> {
            settings.replantNetherWart.value = value101;
            b38 = value101;
            return;
        }).m34676(value102 -> value102.m33468(settings.replantNetherWart.value)).m34679());
        final Boolean b39;
        m34593.addValue((Value<Object>)new c34427.c34657().m34664("sprint-in-water").m34667("Continue sprinting while in water.").m34670((boolean)settings.sprintInWater.defaultValue).m34673(value103 -> {
            settings.sprintInWater.value = value103;
            b39 = value103;
            return;
        }).m34676(value104 -> value104.m33468(settings.sprintInWater.value)).m34679());
        this.add(new c35714(this.f37288, true)).m39601().m39632().m31937(c37054.m34596()).m39587().m39583();
    }
    
    private static /* synthetic */ void m37464(final Settings settings, final Value value) {
        value.m33468(settings.sprintInWater.value);
    }
    
    private static /* synthetic */ void m37467(final Settings settings, final Boolean value) {
        settings.sprintInWater.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37470(final Settings settings, final Value value) {
        value.m33468(settings.replantNetherWart.value);
    }
    
    private static /* synthetic */ void m37473(final Settings settings, final Boolean value) {
        settings.replantNetherWart.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37476(final Settings settings, final Value value) {
        value.m33468(settings.replantCrops.value);
    }
    
    private static /* synthetic */ void m37479(final Settings settings, final Boolean value) {
        settings.replantCrops.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37482(final Settings settings, final Value value) {
        value.m33468(settings.preferSilkTouch.value);
    }
    
    private static /* synthetic */ void m37485(final Settings settings, final Boolean value) {
        settings.preferSilkTouch.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37488(final Settings settings, final Value value) {
        value.m33468(settings.maxFallHeightNoWater.value);
    }
    
    private static /* synthetic */ void m37491(final Settings settings, final Integer value) {
        settings.maxFallHeightNoWater.value = value;
        final Integer n = value;
    }
    
    private static /* synthetic */ void m37494(final Settings settings, final Value value) {
        value.m33468(settings.maxFallHeightBucket.value);
    }
    
    private static /* synthetic */ void m37497(final Settings settings, final Integer value) {
        settings.maxFallHeightBucket.value = value;
        final Integer n = value;
    }
    
    private static /* synthetic */ void m37500(final Settings settings, final Value value) {
        value.m33468(settings.mapArtMode.value);
    }
    
    private static /* synthetic */ void m37503(final Settings settings, final Boolean value) {
        settings.mapArtMode.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37506(final Settings settings, final Value value) {
        value.m33468(settings.freeLook.value);
    }
    
    private static /* synthetic */ void m37509(final Settings settings, final Boolean value) {
        settings.freeLook.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37512(final Settings settings, final Value value) {
        value.m33468(settings.enterPortal.value);
    }
    
    private static /* synthetic */ void m37515(final Settings settings, final Boolean value) {
        settings.enterPortal.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37518(final Settings settings, final Value value) {
        value.m33468(settings.echoCommands.value);
    }
    
    private static /* synthetic */ void m37521(final Settings settings, final Boolean value) {
        settings.echoCommands.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37524(final Settings settings, final Value value) {
        value.m33468(settings.desktopNotifications.value);
    }
    
    private static /* synthetic */ void m37527(final Settings settings, final Boolean value) {
        settings.desktopNotifications.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37530(final Settings settings, final Value value) {
        value.m33468(settings.containerMemory.value);
    }
    
    private static /* synthetic */ void m37533(final Settings settings, final Boolean value) {
        settings.containerMemory.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37536(final Settings settings, final Value value) {
        value.m33468(settings.censorRanCommands.value);
    }
    
    private static /* synthetic */ void m37539(final Settings settings, final Boolean value) {
        settings.censorRanCommands.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37542(final Settings settings, final Value value) {
        value.m33468(settings.censorCoordinates.value);
    }
    
    private static /* synthetic */ void m37545(final Settings settings, final Boolean value) {
        settings.censorCoordinates.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37548(final Settings settings, final Value value) {
        value.m33468(settings.antiCheatCompatibility.value);
    }
    
    private static /* synthetic */ void m37551(final Settings settings, final Boolean value) {
        settings.antiCheatCompatibility.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37554(final Settings settings, final Value value) {
        value.m33468(settings.mineScanDroppedItems.value);
    }
    
    private static /* synthetic */ void m37557(final Settings settings, final Boolean value) {
        settings.mineScanDroppedItems.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37560(final Settings settings, final Value value) {
        value.m33468(settings.layerOrder.value);
    }
    
    private static /* synthetic */ void m37563(final Settings settings, final Boolean value) {
        settings.layerOrder.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37566(final Settings settings, final Value value) {
        value.m33468(settings.buildInLayers.value);
    }
    
    private static /* synthetic */ void m37569(final Settings settings, final Boolean value) {
        settings.buildInLayers.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37572(final Settings settings, final Value value) {
        value.m33468(settings.followRadius.value);
    }
    
    private static /* synthetic */ void m37575(final Settings settings, final Integer value) {
        settings.followRadius.value = value;
        final Integer n = value;
    }
    
    private static /* synthetic */ void m37578(final Settings settings, final Value value) {
        value.m33468(settings.backfill.value);
    }
    
    private static /* synthetic */ void m37581(final Settings settings, final Boolean value) {
        settings.backfill.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37584(final Settings settings, final Value value) {
        value.m33468(settings.legitMine.value);
    }
    
    private static /* synthetic */ void m37587(final Settings settings, final Boolean value) {
        settings.legitMine.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37590(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorSelectionPos2.value).getRGB()));
    }
    
    private static /* synthetic */ void m37593(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorSelectionPos2 = settings.colorSelectionPos2;
        final Color value = new Color(c37042.m37056(), true);
        colorSelectionPos2.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37596(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorSelectionPos1.value).getRGB()));
    }
    
    private static /* synthetic */ void m37599(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorSelectionPos1 = settings.colorSelectionPos1;
        final Color value = new Color(c37042.m37056(), true);
        colorSelectionPos1.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37602(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorSelection.value).getRGB()));
    }
    
    private static /* synthetic */ void m37605(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorSelection = settings.colorSelection;
        final Color value = new Color(c37042.m37056(), true);
        colorSelection.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37608(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorInvertedGoalBox.value).getRGB()));
    }
    
    private static /* synthetic */ void m37611(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorInvertedGoalBox = settings.colorInvertedGoalBox;
        final Color value = new Color(c37042.m37056(), true);
        colorInvertedGoalBox.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37614(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorGoalBox.value).getRGB()));
    }
    
    private static /* synthetic */ void m37617(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorGoalBox = settings.colorGoalBox;
        final Color value = new Color(c37042.m37056(), true);
        colorGoalBox.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37620(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorMostRecentConsidered.value).getRGB()));
    }
    
    private static /* synthetic */ void m37623(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorMostRecentConsidered = settings.colorMostRecentConsidered;
        final Color value = new Color(c37042.m37056(), true);
        colorMostRecentConsidered.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37626(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorBestPathSoFar.value).getRGB()));
    }
    
    private static /* synthetic */ void m37629(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorBestPathSoFar = settings.colorBestPathSoFar;
        final Color value = new Color(c37042.m37056(), true);
        colorBestPathSoFar.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37632(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorBlocksToWalkInto.value).getRGB()));
    }
    
    private static /* synthetic */ void m37635(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorBlocksToWalkInto = settings.colorBlocksToWalkInto;
        final Color value = new Color(c37042.m37056(), true);
        colorBlocksToWalkInto.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37638(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorBlocksToPlace.value).getRGB()));
    }
    
    private static /* synthetic */ void m37641(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorBlocksToPlace = settings.colorBlocksToPlace;
        final Color value = new Color(c37042.m37056(), true);
        colorBlocksToPlace.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37644(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorBlocksToBreak.value).getRGB()));
    }
    
    private static /* synthetic */ void m37647(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorBlocksToBreak = settings.colorBlocksToBreak;
        final Color value = new Color(c37042.m37056(), true);
        colorBlocksToBreak.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37650(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorNextPath.value).getRGB()));
    }
    
    private static /* synthetic */ void m37653(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorNextPath = settings.colorNextPath;
        final Color value = new Color(c37042.m37056(), true);
        colorNextPath.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37656(final Settings settings, final Value value) {
        value.m33468(new c37042(((Color)settings.colorCurrentPath.value).getRGB()));
    }
    
    private static /* synthetic */ void m37659(final Settings settings, final c37042 c37042) {
        final Settings.Setting colorCurrentPath = settings.colorCurrentPath;
        final Color value = new Color(c37042.m37056(), true);
        colorCurrentPath.value = value;
        final Color color = value;
    }
    
    private static /* synthetic */ void m37662(final Settings settings, final Value value) {
        value.m33468(settings.walkOnWaterOnePenalty.value);
    }
    
    private static /* synthetic */ void m37665(final Settings settings, final Double value) {
        settings.walkOnWaterOnePenalty.value = value;
        final Double n = value;
    }
    
    private static /* synthetic */ void m37668(final Settings settings, final Value value) {
        value.m33468(settings.jumpPenalty.value);
    }
    
    private static /* synthetic */ void m37671(final Settings settings, final Double value) {
        settings.jumpPenalty.value = value;
        final Double n = value;
    }
    
    private static /* synthetic */ void m37674(final Settings settings, final Value value) {
        value.m33468(settings.blockBreakAdditionalPenalty.value);
    }
    
    private static /* synthetic */ void m37677(final Settings settings, final Double value) {
        settings.blockBreakAdditionalPenalty.value = value;
        final Double n = value;
    }
    
    private static /* synthetic */ void m37680(final Settings settings, final Value value) {
        value.m33468(settings.blockPlacementPenalty.value);
    }
    
    private static /* synthetic */ void m37683(final Settings settings, final Double value) {
        settings.blockPlacementPenalty.value = value;
        final Double n = value;
    }
    
    private static /* synthetic */ void m37686(final Settings settings, final Value value) {
        value.m33468(settings.renderSelectionCorners.value);
    }
    
    private static /* synthetic */ void m37689(final Settings settings, final Boolean value) {
        settings.renderSelectionCorners.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37692(final Settings settings, final Value value) {
        value.m33468(settings.renderSelectionIgnoreDepth.value);
    }
    
    private static /* synthetic */ void m37695(final Settings settings, final Boolean value) {
        settings.renderSelectionIgnoreDepth.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37698(final Settings settings, final Value value) {
        value.m33468(settings.renderSelection.value);
    }
    
    private static /* synthetic */ void m37701(final Settings settings, final Boolean value) {
        settings.renderSelection.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37704(final Settings settings, final Value value) {
        value.m33468(settings.renderPathIgnoreDepth.value);
    }
    
    private static /* synthetic */ void m37707(final Settings settings, final Boolean value) {
        settings.renderPathIgnoreDepth.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37710(final Settings settings, final Value value) {
        value.m33468(settings.renderGoalXZBeacon.value);
    }
    
    private static /* synthetic */ void m37713(final Settings settings, final Boolean value) {
        settings.renderGoalXZBeacon.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37716(final Settings settings, final Value value) {
        value.m33468(settings.renderGoalIgnoreDepth.value);
    }
    
    private static /* synthetic */ void m37719(final Settings settings, final Boolean value) {
        settings.renderGoalIgnoreDepth.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37722(final Settings settings, final Value value) {
        value.m33468(settings.renderSelectionBoxes.value);
    }
    
    private static /* synthetic */ void m37725(final Settings settings, final Boolean value) {
        settings.renderSelectionBoxes.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37728(final Settings settings, final Value value) {
        value.m33468(settings.renderGoal.value);
    }
    
    private static /* synthetic */ void m37731(final Settings settings, final Boolean value) {
        settings.renderGoal.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37734(final Settings settings, final Value value) {
        value.m33468(settings.renderPathAsLine.value);
    }
    
    private static /* synthetic */ void m37737(final Settings settings, final Boolean value) {
        settings.renderPathAsLine.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37740(final Settings settings, final Value value) {
        value.m33468(settings.renderPath.value);
    }
    
    private static /* synthetic */ void m37743(final Settings settings, final Boolean value) {
        settings.renderPath.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37746(final Settings settings, final Value value) {
        value.m33468(settings.assumeSafeWalk.value);
    }
    
    private static /* synthetic */ void m37749(final Settings settings, final Boolean value) {
        settings.assumeSafeWalk.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37752(final Settings settings, final Value value) {
        value.m33468(settings.assumeStep.value);
    }
    
    private static /* synthetic */ void m37755(final Settings settings, final Boolean value) {
        settings.assumeStep.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37758(final Settings settings, final Value value) {
        value.m33468(settings.assumeWalkOnLava.value);
    }
    
    private static /* synthetic */ void m37761(final Settings settings, final Boolean value) {
        settings.assumeWalkOnLava.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37764(final Settings settings, final Value value) {
        value.m33468(settings.assumeWalkOnWater.value);
    }
    
    private static /* synthetic */ void m37767(final Settings settings, final Boolean value) {
        settings.assumeWalkOnWater.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37770(final Settings settings, final Value value) {
        value.m33468(settings.allowWaterBucketFall.value);
    }
    
    private static /* synthetic */ void m37773(final Settings settings, final Boolean value) {
        settings.allowWaterBucketFall.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37776(final Settings settings, final Value value) {
        value.m33468(settings.allowParkourPlace.value);
    }
    
    private static /* synthetic */ void m37779(final Settings settings, final Boolean value) {
        settings.allowParkourPlace.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37782(final Settings settings, final Value value) {
        value.m33468(settings.allowParkour.value);
    }
    
    private static /* synthetic */ void m37785(final Settings settings, final Boolean value) {
        settings.allowParkour.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37788(final Settings settings, final Value value) {
        value.m33468(settings.allowInventory.value);
    }
    
    private static /* synthetic */ void m37791(final Settings settings, final Boolean value) {
        settings.allowInventory.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37794(final Settings settings, final Value value) {
        value.m33468(settings.allowPlace.value);
    }
    
    private static /* synthetic */ void m37797(final Settings settings, final Boolean value) {
        settings.allowPlace.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37800(final Settings settings, final Value value) {
        value.m33468(settings.allowSprint.value);
    }
    
    private static /* synthetic */ void m37803(final Settings settings, final Boolean value) {
        settings.allowSprint.value = value;
        final Boolean b = value;
    }
    
    private static /* synthetic */ void m37806(final Settings settings, final Value value) {
        value.m33468(settings.allowBreak.value);
    }
    
    private static /* synthetic */ void m37809(final Settings settings, final Boolean value) {
        settings.allowBreak.value = value;
        final Boolean b = value;
    }
    
    static {
        f37463 = new String[] { "Allow", "Assume", "Render", "Penalties", "Colors", "Other", "allow-break", "Allow Baritone to break blocks.", "allow-sprint", "Allow Baritone to sprint.", "allow-place", "Allow Baritone to place blocks.", "allow-inventory", "Allow Baritone to move items in your inventory to your hotbar.", "allow-parkour", "Allow Baritone to perform parkour.", "allow-parkour-place", "Allow Baritone to place blocks to perform parkour.", "allow-water-bucket-fall", "Allow Baritone to fall arbitrary distances and place a water bucket beneath it. Reliability: questionable.", "assume-walk-on-water", "Allow Baritone to assume it can walk on still water just like any other block. This functionality is assumed to be provided by a separate library that might have imported Baritone.", "assume-walk-on-lava", "If you have Fire Resistance and Jesus then I guess you could turn this on lol.", "assume-step", "Assume step functionality; don't jump on an Ascend.", "assume-safe-walk", "Assume safe walk functionality; don't sneak on a backplace traverse.", "render-path", "Render the path.", "render-path-as-line", "Render the path as line instead of a frickin thingy.", "render-goal", "Render the goal.", "render-selection-boxes", "Render the selection boxes.", "render-goal-ignore-depth", "Ignore depth when rendering the goal", "render-goal-XZ-beacon", "Renders X/Z type Goals with the vanilla beacon beam effect. Combining this with renderGoalIgnoreDepth will cause strange render clipping.", "render-path-ignore-deph", "Ignore path when rendering the path.", "render-selection", "Render the selections.", "render-selection-ignore-depth", "Ignore depth when rendering selection.", "render-selection-corners.", "Render the selection corners.", "block-placement-penalty", "Decrease to make Baritone more often consider would require placing blocks.", "block-break-additional-penalty", "This is just a tiebreaker to make it less likely to break blocks if it can avoid it.", "jump-penalty", "Additional penalty for hitting the space bar (ascend, pillar, or parkour) because it uses hunger.", "walk-on-water-penalty", "Walking on water uses up hunger really quick, so penalize it.", "color-current-path", "The color of the current path.", "color-next-path", "The color of the next path.", "color-blocks-to-break", "The color of the blocks to break.", "color-blocks-to-place", "The color of the blocks to place.", "color-blocks-to-walk-into", "The color of the blocks to walk into.", "color-best-path-so-far", "The color of the best path so far.", "color-most-recent-considered", "The color of the most recent considered node.", "color-goal-box", "The color of the goal box.", "color-inverted-goal-box", "The color of the goal box when it's inverted.", "color-selection", "The color of all selections.", "color-selection-pos-1", "The color of the selection pos 1.", "color-selection-pos-2", "The color of the selection pos 2.", "legit-mine", "Disallow MineBehavior from using X-Ray to see where the ores are. Turn this option on to force it to mine \"legit\" where it will only mine an ore once it can actually see it, so it won't do or know anything that a normal player couldn't. If you don't want it to look like you're X-Raying, turn this on.", "backfill", "Fill in blocks behind you", "follow-radius", "The radius (for the GoalNear) of how close to your target position you actually have to be.", "build-in-layers", "Don't consider the next layer in builder until the current one is done.", "layer-order", "false = build from bottom to top, true = build from top to bottom", "mine-scan-dropped-items", "While mining, should it also consider dropped items of the correct type as a pathing destination (as well as ore blocks)?", "anti-cheat-compatibility", "Will cause some minor behavioral differences to ensure that Baritone works on anticheats.", "censor-coordinates", "Censor coordinates in goals and block positions.", "censor-ran-commands", "Censor arguments to ran commands, to hide, for example, coordinates to @goal.", "container-memory", "Remember the contents of containers (chests, echests, furnaces).", "desktop-notifications", "Desktop notifications.", "echo-commands", "Echo commands to chat when they are run.", "enter-portal.", "When running a goto towards a nether portal block, walk all the way into the portal instead of stopping one block before.", "free-look", "Move without having to force the client-sided rotations.", "map-art-mode", "Build in map art mode, which makes baritone only care about the top block in each column.", "max-fall-height-bucket", "How far are you allowed to fall onto solid ground (with a water bucket)? It's not that reliable, so I've set it below what would kill an unarmored player (23).", "max-fall-height-no-water", "How far are you allowed to fall onto solid ground (without a water bucket)? 3 won't deal any damage.", "prefer-silk-touch", "Always prefer silk touch tools over regular tools.", "replant-crops", "Replant normal Crops while farming and leave cactus and sugarcane to regrow.", "replant-nether-wart", "Replant nether wart while farming.", "sprint-in-water", "Continue sprinting while in water." };
    }
}
