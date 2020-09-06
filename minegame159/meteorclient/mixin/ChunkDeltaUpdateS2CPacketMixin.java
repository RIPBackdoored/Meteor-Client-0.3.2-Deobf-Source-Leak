package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import net.minecraft.util.math.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_2637.class })
public class ChunkDeltaUpdateS2CPacketMixin implements c32182
{
    @Shadow
    private ChunkPos field_12116;
    
    public ChunkDeltaUpdateS2CPacketMixin() {
        super();
    }
    
    @Override
    public ChunkPos m32183() {
        return this.chunkPos;
    }
}
