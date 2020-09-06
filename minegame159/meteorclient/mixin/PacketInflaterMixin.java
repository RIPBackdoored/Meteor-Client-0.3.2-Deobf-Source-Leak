package minegame159.meteorclient.mixin;

import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import io.netty.channel.*;
import java.util.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import meteorclient.*;
import net.minecraft.util.*;
import io.netty.handler.codec.*;
import io.netty.buffer.*;
import java.util.zip.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_2532.class })
public class PacketInflaterMixin
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    private int field_11623;
    @Shadow
    @Final
    private Inflater field_11622;
    
    public PacketInflaterMixin() {
        super();
    }
    
    @Inject(method = { "decode" }, at = { @At("HEAD") }, cancellable = true)
    private void onDecode(final ChannelHandlerContext channelHandlerContext, final ByteBuf byteBuf, final List<Object> list, final CallbackInfo callbackInfo) throws DataFormatException {
        if (c34030.f34033.m34049(Antichunkban.class)) {
            callbackInfo.cancel();
            if (byteBuf.readableBytes() != 0) {
                final PacketByteBuf packetByteBuf = new PacketByteBuf(byteBuf);
                final int varInt = packetByteBuf.readVarInt();
                if (varInt == 0) {
                    list.add(packetByteBuf.readBytes(packetByteBuf.readableBytes()));
                }
                else {
                    if (varInt < this.compressionThreshold) {
                        throw new DecoderException("Badly compressed packet - size of " + varInt + " is below server threshold of " + this.compressionThreshold);
                    }
                    if (varInt > 51200000) {
                        throw new DecoderException("Badly compressed packet - size of " + varInt + " is larger than protocol maximum of " + 51200000);
                    }
                    final byte[] input = new byte[packetByteBuf.readableBytes()];
                    packetByteBuf.readBytes(input);
                    this.inflater.setInput(input);
                    final byte[] array = new byte[varInt];
                    this.inflater.inflate(array);
                    list.add(Unpooled.wrappedBuffer(array));
                    this.inflater.reset();
                }
            }
        }
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Badly compressed packet - size of ", " is below server threshold of ", "Badly compressed packet - size of ", " is larger than protocol maximum of " };
    }
}
