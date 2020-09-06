package minegame159.meteorclient;

public class c34172 extends c39130
{
    private static final String[] f34173;
    
    public c34172(final c32097.c32098 c32098) {
        super("Chunk at " + c32098.f32101 + ", " + c32098.f32102, true);
        this.add(new c39081("Total:"));
        this.add(new c39081(c32098.m32112() + ""));
        this.m39132();
        this.add(new c38757()).m39587().m39583();
        this.m39132();
        this.add(new c39081("Chests:"));
        this.add(new c39081(c32098.f32103 + ""));
        this.m39132();
        this.add(new c39081("Barrels:"));
        this.add(new c39081(c32098.f32104 + ""));
        this.m39132();
        this.add(new c39081("Shulkers:"));
        this.add(new c39081(c32098.f32105 + ""));
        this.m39132();
        this.add(new c39081("Ender Chests:"));
        this.add(new c39081(c32098.f32106 + ""));
        this.m39132();
        this.add(new c39081("Furnaces:"));
        this.add(new c39081(c32098.f32107 + ""));
        this.m39132();
        this.add(new c39081("Dispensers and droppers:"));
        this.add(new c39081(c32098.f32108 + ""));
        this.m39132();
        this.add(new c39081("Hoppers:"));
        this.add(new c39081(c32098.f32109 + ""));
    }
    
    static {
        f34173 = new String[] { "Chunk at ", ", ", "Total:", "", "Chests:", "", "Barrels:", "", "Shulkers:", "", "Ender Chests:", "", "Furnaces:", "", "Dispensers and droppers:", "", "Hoppers:", "" };
    }
}
