package minegame159.meteorclient;

import net.minecraft.*;
import meteorclient.modules.*;
import net.minecraft.client.gui.widget.*;
import net.minecraft.client.gui.screen.multiplayer.*;
import net.minecraft.client.gui.screen.*;

private class c39534 extends class_419
{
    private static final String[] f39535;
    private int f39536;
    private ButtonWidget f39537;
    private boolean f39538;
    private int f39539;
    final /* synthetic */ Autoreconnect f39540;
    
    public c39534(final Autoreconnect f39540, final DisconnectedScreen disconnectedScreen) {
        this.f39540 = f39540;
        super(((c34234)disconnectedScreen).m34235(), disconnectedScreen.getTitle().asString(), ((c34234)disconnectedScreen).m34236());
        this.f39538 = true;
        this.f39536 = ((c34234)disconnectedScreen).m34237();
        this.f39539 = (int)(Autoreconnect.m33535(f39540).m33466() * 20.0);
    }
    
    protected void init() {
        super.init();
        this.f39537 = (ButtonWidget)this.addButton((AbstractButtonWidget)new ButtonWidget(this.width / 2 - 100, this.height / 2 + this.f39536 / 2 + 9 + 30, 200, 20, "Reconnecting in " + this.f39539 / 20.0f, this::m39541));
    }
    
    public void tick() {
        super.tick();
        if (this.f39539 <= 0) {
            this.minecraft.openScreen((Screen)new ConnectScreen((Screen)new MultiplayerScreen((Screen)new TitleScreen()), this.minecraft, Autoreconnect.m33537(this.f39540)));
        }
        if (this.f39538) {
            --this.f39539;
            ((c34882)this.f39537).m34883(String.format("Reconnecting in %.1f", this.f39539 / 20.0f));
        }
    }
    
    private /* synthetic */ void m39541(final ButtonWidget buttonWidget) {
        this.f39538 = !this.f39538;
    }
    
    static {
        c39534.f39535 = new String[] { "Reconnecting in ", "Reconnecting in %.1f" };
    }
}
