package minegame159.meteorclient;

import net.minecraft.entity.*;
import java.util.*;

private static class c36215
{
    public String f36216;
    public int f36217;
    public String f36218;
    public boolean f36219;
    
    public c36215(final String f36216) {
        super();
        this.f36216 = f36216;
    }
    
    public void m36220(final Entity entity) {
        if (entity instanceof ItemEntity) {
            this.f36217 += ((ItemEntity)entity).getStack().getCount();
        }
        else {
            ++this.f36217;
        }
        this.f36218 = Integer.toString(this.f36217);
        this.f36219 = true;
    }
    
    public void m36223() {
        this.f36217 = 0;
        this.f36219 = false;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && Objects.equals(this.f36216, ((c36215)o).f36216));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f36216);
    }
}
