package minegame159.meteorclient;

import net.minecraft.*;
import net.minecraft.block.*;
import java.lang.reflect.*;
import net.minecraft.util.registry.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class c35513 implements JsonSerializer<class_2248>, JsonDeserializer<class_2248>
{
    public c35513() {
        super();
    }
    
    public JsonElement m35514(final Block block, final Type type, final JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(Registry.BLOCK.getId((Object)block).toString());
    }
    
    public Block m35519(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Block)Registry.BLOCK.get(new Identifier(jsonElement.getAsString()));
    }
    
    @Override
    public /* bridge */ JsonElement serialize(final Object o, final Type type, final JsonSerializationContext jsonSerializationContext) {
        return this.m35514((Block)o, type, jsonSerializationContext);
    }
    
    @Override
    public /* bridge */ Object deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this.m35519(jsonElement, type, jsonDeserializationContext);
    }
}
