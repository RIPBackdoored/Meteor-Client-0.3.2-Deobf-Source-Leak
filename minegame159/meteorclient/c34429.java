package minegame159.meteorclient;

import net.minecraft.*;
import meteorclient.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.entity.damage.*;
import net.minecraft.text.*;
import net.minecraft.entity.*;
import net.minecraft.world.chunk.*;
import net.minecraft.util.math.*;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.client.sound.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.network.*;

public class c34429
{
    private static final c36628 f34430;
    private static final c32410 f34431;
    private static final c33752 f34432;
    private static final c32918 f34433;
    private static final c34242 f34434;
    private static final c32661 f34435;
    private static final c38944 f34436;
    private static final c34369 f34437;
    private static final c37149 f34438;
    private static final c31559 f34439;
    private static final c38402 f34440;
    private static final c36846 f34441;
    private static final c36575 f34442;
    private static final c31561 f34443;
    private static final c33675 f34444;
    private static final c37829 f34445;
    private static final c39097 f34446;
    private static final c31526 f34447;
    private static final c38391 f34448;
    private static final c39306 f34449;
    private static final c37294 f34450;
    private static final c39291 f34451;
    private static final c32900<c33296> f34452;
    private static final c33360 f34453;
    private static final c32772 f34454;
    private static final c37141 f34455;
    private static final c32497 f34456;
    private static final c33735 f34457;
    private static final c32606 f34458;
    private static final c37956 f34459;
    private static final c37172 f34460;
    private static final c38846 f34461;
    private static final c38839 f34462;
    private static final c37812 f34463;
    private static final c34622 f34464;
    private static final c32191 f34465;
    private static final c32250 f34466;
    
    public c34429() {
        super();
    }
    
    public static c36628 m34467(final PlaySoundS2CPacket f36629) {
        c34429.f34430.f36629 = f36629;
        return c34429.f34430;
    }
    
    public static c32410 m34469(final class_2596<?> f32411) {
        c34429.f34431.m35010(false);
        c34429.f34431.f32411 = (Packet)f32411;
        return c34429.f34431;
    }
    
    public static c33752 m34471() {
        return c34429.f34432;
    }
    
    public static c32918 m34472(final char f32919) {
        c34429.f34433.m35010(false);
        c34429.f34433.f32919 = f32919;
        return c34429.f34433;
    }
    
    public static c34242 m34474(final Entity f34243) {
        c34429.f34434.f34243 = f34243;
        return c34429.f34434;
    }
    
    public static c32661 m34476(final Entity f32662) {
        c34429.f34435.f32662 = f32662;
        return c34429.f34435;
    }
    
    public static c38944 m34478(final int f38945, final boolean f38946) {
        c34429.f34436.m35010(false);
        c34429.f34436.f38945 = f38945;
        c34429.f34436.f38946 = f38946;
        return c34429.f34436;
    }
    
    public static c34369 m34481(final c38667 f34370) {
        c34429.f34437.f34370 = f34370;
        return c34429.f34437;
    }
    
    public static c37149 m34483(final Module f37150) {
        c34429.f34438.f37150 = f37150;
        return c34429.f34438;
    }
    
    public static c31559 m34485(final Screen f31560) {
        c34429.f34439.m35010(false);
        c34429.f34439.f31560 = f31560;
        return c34429.f34439;
    }
    
    public static c38402 m34487(final int f38403, final int f38404, final float f38405) {
        c34429.f34440.f38403 = f38403;
        c34429.f34440.f38404 = f38404;
        c34429.f34440.f38405 = f38405;
        return c34429.f34440;
    }
    
    public static c36846 m34491(final float f36847, final double f36848, final double f36849, final double f36850) {
        c34429.f34441.f36847 = f36847;
        c34429.f34441.f36848 = f36848;
        c34429.f34441.f36849 = f36849;
        c34429.f34441.f36850 = f36850;
        return c34429.f34441;
    }
    
    public static c36575 m34496() {
        return c34429.f34442;
    }
    
    public static c31561 m34497(final LivingEntity f31562, final DamageSource f31563) {
        c34429.f34443.f31562 = f31562;
        c34429.f34443.f31563 = f31563;
        return c34429.f34443;
    }
    
    public static c33675 m34500() {
        return c34429.f34444;
    }
    
    public static c37829 m34501(final Text f37830) {
        c34429.f34445.f37830 = f37830;
        return c34429.f34445;
    }
    
    public static c39097 m34503() {
        return c34429.f34446;
    }
    
    public static c31526 m34504() {
        return c34429.f34447;
    }
    
    public static c38391 m34505() {
        return c34429.f34448;
    }
    
    public static c39306 m34506(final class_2596<?> f39307) {
        c34429.f34449.m35010(false);
        c34429.f34449.f39307 = (Packet)f39307;
        return c34429.f34449;
    }
    
    public static c37294 m34508(final MovementType f37295, final Vec3d f37296) {
        c34429.f34450.f37295 = f37295;
        c34429.f34450.f37296 = f37296;
        return c34429.f34450;
    }
    
    public static c39291 m34511() {
        return c34429.f34451;
    }
    
    public static c33296 m34512(final WorldChunk f33297) {
        final c33296 c33296 = c34429.f34452.m32903();
        c33296.f33297 = f33297;
        return c33296;
    }
    
    public static void m34515(final c33296 c33296) {
        c34429.f34452.m32905(c33296);
    }
    
    public static c33360 m34517(final Entity f33361) {
        c34429.f34453.m35010(false);
        c34429.f34453.f33361 = f33361;
        return c34429.f34453;
    }
    
    public static c32772 m34519(final BlockPos f32773, final Direction f32774) {
        c34429.f34454.m35010(false);
        c34429.f34454.f32773 = f32773;
        c34429.f34454.f32774 = f32774;
        return c34429.f34454;
    }
    
    public static c37141 m34522(final Entity f37142) {
        c34429.f34455.f37142 = f37142;
        return c34429.f34455;
    }
    
    public static c32497 m34524(final LivingEntity f32498, final DamageSource f32499) {
        c34429.f34456.f32498 = f32498;
        c34429.f34456.f32499 = f32499;
        return c34429.f34456;
    }
    
    public static c33735 m34527() {
        return c34429.f34457;
    }
    
    public static c32606 m34528(final ContainerSlotUpdateS2CPacket f32607) {
        c34429.f34458.f32607 = f32607;
        return c34429.f34458;
    }
    
    public static c37956 m34530(final BlockState f37957) {
        c34429.f34459.f37957 = f37957;
        return c34429.f34459;
    }
    
    public static c37172 m34532(final String f37173) {
        c34429.f34460.f37173 = f37173;
        return c34429.f34460;
    }
    
    public static c38846 m34534(final SoundInstance f38847) {
        c34429.f34461.m35010(false);
        c34429.f34461.f38847 = f38847;
        return c34429.f34461;
    }
    
    public static c38839 m34536() {
        return c34429.f34462;
    }
    
    public static c37812 m34537(final BlockPos f37813) {
        c34429.f34463.f37813 = f37813;
        return c34429.f34463;
    }
    
    public static c34622 m34539(final BlockPos f34623, final Block f34624) {
        c34429.f34464.f34623 = f34623;
        c34429.f34464.f34624 = f34624;
        return c34429.f34464;
    }
    
    public static c32191 m34542(final ItemStack f32192) {
        c34429.f34465.f32192 = f32192;
        return c34429.f34465;
    }
    
    public static c32250 m34544(final ItemStack f32251, final int f32252) {
        c34429.f34466.f32251 = f32251;
        c34429.f34466.f32252 = f32252;
        return c34429.f34466;
    }
    
    static {
        f34430 = new c36628();
        f34431 = new c32410();
        f34432 = new c33752();
        f34433 = new c32918();
        f34434 = new c34242();
        f34435 = new c32661();
        f34436 = new c38944();
        f34437 = new c34369();
        f34438 = new c37149();
        f34439 = new c31559();
        f34440 = new c38402();
        f34441 = new c36846();
        f34442 = new c36575();
        f34443 = new c31561();
        f34444 = new c33675();
        f34445 = new c37829();
        f34446 = new c39097();
        f34447 = new c31526();
        f34448 = new c38391();
        f34449 = new c39306();
        f34450 = new c37294();
        f34451 = new c39291();
        f34452 = new c32900<c33296>(c33296::new);
        f34453 = new c33360();
        f34454 = new c32772();
        f34455 = new c37141();
        f34456 = new c32497();
        f34457 = new c33735();
        f34458 = new c32606();
        f34459 = new c37956();
        f34460 = new c37172();
        f34461 = new c38846();
        f34462 = new c38839();
        f34463 = new c37812();
        f34464 = new c34622();
        f34465 = new c32191();
        f34466 = new c32250();
    }
}
