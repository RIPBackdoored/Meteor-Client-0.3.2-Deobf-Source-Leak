package minegame159.meteorclient;

import com.mojang.authlib.*;
import java.lang.reflect.*;
import java.util.*;
import com.google.gson.*;

public class c35459 implements JsonSerializer<GameProfile>, JsonDeserializer<GameProfile>
{
    private static final String[] f35460;
    
    public c35459() {
        super();
    }
    
    public GameProfile m35461(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final JsonObject jsonObject = (JsonObject)jsonElement;
        return new GameProfile(jsonObject.has("id") ? ((UUID)jsonDeserializationContext.deserialize(jsonObject.get("id"), UUID.class)) : null, jsonObject.has("name") ? jsonObject.getAsJsonPrimitive("name").getAsString() : null);
    }
    
    public JsonElement m35469(final GameProfile gameProfile, final Type type, final JsonSerializationContext jsonSerializationContext) {
        final JsonObject jsonObject = new JsonObject();
        if (gameProfile.getId() != null) {
            jsonObject.add("id", jsonSerializationContext.serialize(gameProfile.getId()));
        }
        if (gameProfile.getName() != null) {
            jsonObject.addProperty("name", gameProfile.getName());
        }
        return jsonObject;
    }
    
    @Override
    public /* bridge */ JsonElement serialize(final Object o, final Type type, final JsonSerializationContext jsonSerializationContext) {
        return this.m35469((GameProfile)o, type, jsonSerializationContext);
    }
    
    @Override
    public /* bridge */ Object deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this.m35461(jsonElement, type, jsonDeserializationContext);
    }
    
    static {
        f35460 = new String[] { "id", "id", "name", "name", "id", "name" };
    }
}
