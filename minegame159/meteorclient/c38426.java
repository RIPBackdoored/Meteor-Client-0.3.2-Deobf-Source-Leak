package minegame159.meteorclient;

import net.minecraft.client.*;
import meteorclient.setting.*;

public class c38426 extends c36626
{
    private static final String[] f38427;
    
    public c38426() {
        super(TopBarType.Gui);
        final c34561 c37076 = new c34561();
        final Settings m34572 = c37076.m34572();
        m34572.addValue((Value<Object>)new c37033.c38947().m38959("gui-scale").m38962("Scale of the GUI.").m38965(2.0).m38974(1.0).m38977(4.0).m38986().m38968(n -> {
            c31870.f37895.f37896 = n;
            if (MinecraftClient.getInstance().currentScreen instanceof c32480) {
                ((c32480)MinecraftClient.getInstance().currentScreen).f37291.m31935();
            }
            return;
        }).m38971(value -> value.m33468(c31870.f37895.f37896)).m38988());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("text").m33190("Text color.").m33193(new c37042(255, 255, 255)).m33196(c37042 -> c31870.f37895.f37897.m37049(c37042)).m33199(value2 -> value2.m33468(c31870.f37895.f37897)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("window-header-text").m33190("Window header text color.").m33193(new c37042(255, 255, 255)).m33196(c37043 -> c31870.f37895.f37898.m37049(c37043)).m33199(value3 -> value3.m33468(c31870.f37895.f37898)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("logged-in-text").m33190("Logged in text color.").m33193(new c37042(45, 225, 45)).m33196(c37044 -> c31870.f37895.f37899.m37049(c37044)).m33199(value4 -> value4.m33468(c31870.f37895.f37899)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("background").m33190("Background color").m33193(new c37042(20, 20, 20, 200)).m33196(c37045 -> c31870.f37895.f37900.m37049(c37045)).m33199(value5 -> value5.m33468(c31870.f37895.f37900)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("background-hovered").m33190("Background hovered color.").m33193(new c37042(30, 30, 30, 200)).m33196(c37046 -> c31870.f37895.f37901.m37049(c37046)).m33199(value6 -> value6.m33468(c31870.f37895.f37901)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("background-pressed").m33190("Background pressed color.").m33193(new c37042(40, 40, 40, 200)).m33196(c37047 -> c31870.f37895.f37902.m37049(c37047)).m33199(value7 -> value7.m33468(c31870.f37895.f37902)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("outline").m33190("Outline color.").m33193(new c37042(0, 0, 0, 225)).m33196(c37048 -> c31870.f37895.f37903.m37049(c37048)).m33199(value8 -> value8.m33468(c31870.f37895.f37903)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("outline-hovered").m33190("Outline hovered color.").m33193(new c37042(10, 10, 10, 225)).m33196(c37049 -> c31870.f37895.f37904.m37049(c37049)).m33199(value9 -> value9.m33468(c31870.f37895.f37904)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("outline-pressed").m33190("Outline pressed color.").m33193(new c37042(20, 20, 20, 225)).m33196(c37050 -> c31870.f37895.f37905.m37049(c37050)).m33199(value10 -> value10.m33468(c31870.f37895.f37905)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("checkbox").m33190("Checkbox color.").m33193(new c37042(45, 225, 45)).m33196(c37051 -> c31870.f37895.f37906.m37049(c37051)).m33199(value11 -> value11.m33468(c31870.f37895.f37906)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("checkbox-pressed").m33190("Checkbox pressed color.").m33193(new c37042(70, 225, 70)).m33196(c37052 -> c31870.f37895.f37907.m37049(c37052)).m33199(value12 -> value12.m33468(c31870.f37895.f37907)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("separator").m33190("Separator color.").m33193(new c37042(10, 10, 10, 225)).m33196(c37053 -> c31870.f37895.f37908.m37049(c37053)).m33199(value13 -> value13.m33468(c31870.f37895.f37908)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("plus").m33190("Plus color.").m33193(new c37042(45, 225, 45)).m33196(c37054 -> c31870.f37895.f37909.m37049(c37054)).m33199(value14 -> value14.m33468(c31870.f37895.f37909)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("plus-hovered").m33190("Plus hovered color.").m33193(new c37042(60, 225, 60)).m33196(c37055 -> c31870.f37895.f37910.m37049(c37055)).m33199(value15 -> value15.m33468(c31870.f37895.f37910)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("plus-pressed").m33190("Plus pressed color.").m33193(new c37042(75, 255, 75)).m33196(c37056 -> c31870.f37895.f37911.m37049(c37056)).m33199(value16 -> value16.m33468(c31870.f37895.f37911)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("minus").m33190("Minus color.").m33193(new c37042(225, 45, 45)).m33196(c37057 -> c31870.f37895.f37912.m37049(c37057)).m33199(value17 -> value17.m33468(c31870.f37895.f37912)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("minus-hovered").m33190("Minus hovered color.").m33193(new c37042(225, 60, 60)).m33196(c37058 -> c31870.f37895.f37913.m37049(c37058)).m33199(value18 -> value18.m33468(c31870.f37895.f37913)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("minus-pressed").m33190("Minus pressed color.").m33193(new c37042(225, 75, 75)).m33196(c37059 -> c31870.f37895.f37914.m37049(c37059)).m33199(value19 -> value19.m33468(c31870.f37895.f37914)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("accent").m33190("Accent color.").m33193(new c37042(0, 255, 180)).m33196(c37060 -> c31870.f37895.f37915.m37049(c37060)).m33199(value20 -> value20.m33468(c31870.f37895.f37915)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("module-background").m33190("Module background color.").m33193(new c37042(50, 50, 50)).m33196(c37061 -> c31870.f37895.f37916.m37049(c37061)).m33199(value21 -> value21.m33468(c31870.f37895.f37916)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("reset").m33190("Reset color.").m33193(new c37042(50, 50, 50)).m33196(c37062 -> c31870.f37895.f37917.m37049(c37062)).m33199(value22 -> value22.m33468(c31870.f37895.f37917)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("reset-hovered").m33190("Reset hovered color.").m33193(new c37042(60, 60, 60)).m33196(c37063 -> c31870.f37895.f37918.m37049(c37063)).m33199(value23 -> value23.m33468(c31870.f37895.f37918)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("reset-pressed").m33190("Reset pressed color.").m33193(new c37042(70, 70, 70)).m33196(c37064 -> c31870.f37895.f37919.m37049(c37064)).m33199(value24 -> value24.m33468(c31870.f37895.f37919)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("slider-left").m33190("Slider left color.").m33193(new c37042(0, 150, 80)).m33196(c37065 -> c31870.f37895.f37920.m37049(c37065)).m33199(value25 -> value25.m33468(c31870.f37895.f37920)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("slider-right").m33190("Slider right color.").m33193(new c37042(50, 50, 50)).m33196(c37066 -> c31870.f37895.f37921.m37049(c37066)).m33199(value26 -> value26.m33468(c31870.f37895.f37921)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("slider-handle").m33190("Slider handle color.").m33193(new c37042(0, 255, 180)).m33196(c37067 -> c31870.f37895.f37922.m37049(c37067)).m33199(value27 -> value27.m33468(c31870.f37895.f37922)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("slider-handle-hovered").m33190("Slider handle hovered color.").m33193(new c37042(0, 240, 165)).m33196(c37068 -> c31870.f37895.f37923.m37049(c37068)).m33199(value28 -> value28.m33468(c31870.f37895.f37923)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("slider-handle-pressed").m33190("Slider handle pressed color.").m33193(new c37042(0, 225, 150)).m33196(c37069 -> c31870.f37895.f37924.m37049(c37069)).m33199(value29 -> value29.m33468(c31870.f37895.f37924)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("color-edit-handle").m33190("Color edit handle").m33193(new c37042(70, 70, 70)).m33196(c37070 -> c31870.f37895.f37925.m37049(c37070)).m33199(value30 -> value30.m33468(c31870.f37895.f37925)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("color-edit-handle-hovered").m33190("Color edit handle hovered color.").m33193(new c37042(80, 80, 80)).m33196(c37071 -> c31870.f37895.f37926.m37049(c37071)).m33199(value31 -> value31.m33468(c31870.f37895.f37926)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("color-edit-handle-pressed").m33190("Color edit handle pressed.").m33193(new c37042(90, 90, 90)).m33196(c37072 -> c31870.f37895.f37927.m37049(c37072)).m33199(value32 -> value32.m33468(c31870.f37895.f37927)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("edit").m33190("Edit color.").m33193(new c37042(50, 50, 50)).m33196(c37073 -> c31870.f37895.f37928.m37049(c37073)).m33199(value33 -> value33.m33468(c31870.f37895.f37928)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("edit-hovered").m33190("Edit hovered color.").m33193(new c37042(60, 60, 60)).m33196(c37074 -> c31870.f37895.f37929.m37049(c37074)).m33199(value34 -> value34.m33468(c31870.f37895.f37929)).m33202());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("edit-pressed").m33190("Edit pressed color.").m33193(new c37042(70, 70, 70)).m33196(c37075 -> c31870.f37895.f37930.m37049(c37075)).m33199(value35 -> value35.m33468(c31870.f37895.f37930)).m33202());
        this.add(new c35714(this.f37288, true)).m39601().m39632().m31937(c37076.m34596()).m39587().m39583();
    }
    
    @Override
    public void onClose() {
        c33436.f34122.m37303();
        super.onClose();
    }
    
    private static /* synthetic */ void m38428(final Value value) {
        value.m33468(c31870.f37895.f37930);
    }
    
    private static /* synthetic */ void m38430(final c37042 c37042) {
        c31870.f37895.f37930.m37049(c37042);
    }
    
    private static /* synthetic */ void m38432(final Value value) {
        value.m33468(c31870.f37895.f37929);
    }
    
    private static /* synthetic */ void m38434(final c37042 c37042) {
        c31870.f37895.f37929.m37049(c37042);
    }
    
    private static /* synthetic */ void m38436(final Value value) {
        value.m33468(c31870.f37895.f37928);
    }
    
    private static /* synthetic */ void m38438(final c37042 c37042) {
        c31870.f37895.f37928.m37049(c37042);
    }
    
    private static /* synthetic */ void m38440(final Value value) {
        value.m33468(c31870.f37895.f37927);
    }
    
    private static /* synthetic */ void m38442(final c37042 c37042) {
        c31870.f37895.f37927.m37049(c37042);
    }
    
    private static /* synthetic */ void m38444(final Value value) {
        value.m33468(c31870.f37895.f37926);
    }
    
    private static /* synthetic */ void m38446(final c37042 c37042) {
        c31870.f37895.f37926.m37049(c37042);
    }
    
    private static /* synthetic */ void m38448(final Value value) {
        value.m33468(c31870.f37895.f37925);
    }
    
    private static /* synthetic */ void m38450(final c37042 c37042) {
        c31870.f37895.f37925.m37049(c37042);
    }
    
    private static /* synthetic */ void m38452(final Value value) {
        value.m33468(c31870.f37895.f37924);
    }
    
    private static /* synthetic */ void m38454(final c37042 c37042) {
        c31870.f37895.f37924.m37049(c37042);
    }
    
    private static /* synthetic */ void m38456(final Value value) {
        value.m33468(c31870.f37895.f37923);
    }
    
    private static /* synthetic */ void m38458(final c37042 c37042) {
        c31870.f37895.f37923.m37049(c37042);
    }
    
    private static /* synthetic */ void m38460(final Value value) {
        value.m33468(c31870.f37895.f37922);
    }
    
    private static /* synthetic */ void m38462(final c37042 c37042) {
        c31870.f37895.f37922.m37049(c37042);
    }
    
    private static /* synthetic */ void m38464(final Value value) {
        value.m33468(c31870.f37895.f37921);
    }
    
    private static /* synthetic */ void m38466(final c37042 c37042) {
        c31870.f37895.f37921.m37049(c37042);
    }
    
    private static /* synthetic */ void m38468(final Value value) {
        value.m33468(c31870.f37895.f37920);
    }
    
    private static /* synthetic */ void m38470(final c37042 c37042) {
        c31870.f37895.f37920.m37049(c37042);
    }
    
    private static /* synthetic */ void m38472(final Value value) {
        value.m33468(c31870.f37895.f37919);
    }
    
    private static /* synthetic */ void m38474(final c37042 c37042) {
        c31870.f37895.f37919.m37049(c37042);
    }
    
    private static /* synthetic */ void m38476(final Value value) {
        value.m33468(c31870.f37895.f37918);
    }
    
    private static /* synthetic */ void m38478(final c37042 c37042) {
        c31870.f37895.f37918.m37049(c37042);
    }
    
    private static /* synthetic */ void m38480(final Value value) {
        value.m33468(c31870.f37895.f37917);
    }
    
    private static /* synthetic */ void m38482(final c37042 c37042) {
        c31870.f37895.f37917.m37049(c37042);
    }
    
    private static /* synthetic */ void m38484(final Value value) {
        value.m33468(c31870.f37895.f37916);
    }
    
    private static /* synthetic */ void m38486(final c37042 c37042) {
        c31870.f37895.f37916.m37049(c37042);
    }
    
    private static /* synthetic */ void m38488(final Value value) {
        value.m33468(c31870.f37895.f37915);
    }
    
    private static /* synthetic */ void m38490(final c37042 c37042) {
        c31870.f37895.f37915.m37049(c37042);
    }
    
    private static /* synthetic */ void m38492(final Value value) {
        value.m33468(c31870.f37895.f37914);
    }
    
    private static /* synthetic */ void m38494(final c37042 c37042) {
        c31870.f37895.f37914.m37049(c37042);
    }
    
    private static /* synthetic */ void m38496(final Value value) {
        value.m33468(c31870.f37895.f37913);
    }
    
    private static /* synthetic */ void m38498(final c37042 c37042) {
        c31870.f37895.f37913.m37049(c37042);
    }
    
    private static /* synthetic */ void m38500(final Value value) {
        value.m33468(c31870.f37895.f37912);
    }
    
    private static /* synthetic */ void m38502(final c37042 c37042) {
        c31870.f37895.f37912.m37049(c37042);
    }
    
    private static /* synthetic */ void m38504(final Value value) {
        value.m33468(c31870.f37895.f37911);
    }
    
    private static /* synthetic */ void m38506(final c37042 c37042) {
        c31870.f37895.f37911.m37049(c37042);
    }
    
    private static /* synthetic */ void m38508(final Value value) {
        value.m33468(c31870.f37895.f37910);
    }
    
    private static /* synthetic */ void m38510(final c37042 c37042) {
        c31870.f37895.f37910.m37049(c37042);
    }
    
    private static /* synthetic */ void m38512(final Value value) {
        value.m33468(c31870.f37895.f37909);
    }
    
    private static /* synthetic */ void m38514(final c37042 c37042) {
        c31870.f37895.f37909.m37049(c37042);
    }
    
    private static /* synthetic */ void m38516(final Value value) {
        value.m33468(c31870.f37895.f37908);
    }
    
    private static /* synthetic */ void m38518(final c37042 c37042) {
        c31870.f37895.f37908.m37049(c37042);
    }
    
    private static /* synthetic */ void m38520(final Value value) {
        value.m33468(c31870.f37895.f37907);
    }
    
    private static /* synthetic */ void m38522(final c37042 c37042) {
        c31870.f37895.f37907.m37049(c37042);
    }
    
    private static /* synthetic */ void m38524(final Value value) {
        value.m33468(c31870.f37895.f37906);
    }
    
    private static /* synthetic */ void m38526(final c37042 c37042) {
        c31870.f37895.f37906.m37049(c37042);
    }
    
    private static /* synthetic */ void m38528(final Value value) {
        value.m33468(c31870.f37895.f37905);
    }
    
    private static /* synthetic */ void m38530(final c37042 c37042) {
        c31870.f37895.f37905.m37049(c37042);
    }
    
    private static /* synthetic */ void m38532(final Value value) {
        value.m33468(c31870.f37895.f37904);
    }
    
    private static /* synthetic */ void m38534(final c37042 c37042) {
        c31870.f37895.f37904.m37049(c37042);
    }
    
    private static /* synthetic */ void m38536(final Value value) {
        value.m33468(c31870.f37895.f37903);
    }
    
    private static /* synthetic */ void m38538(final c37042 c37042) {
        c31870.f37895.f37903.m37049(c37042);
    }
    
    private static /* synthetic */ void m38540(final Value value) {
        value.m33468(c31870.f37895.f37902);
    }
    
    private static /* synthetic */ void m38542(final c37042 c37042) {
        c31870.f37895.f37902.m37049(c37042);
    }
    
    private static /* synthetic */ void m38544(final Value value) {
        value.m33468(c31870.f37895.f37901);
    }
    
    private static /* synthetic */ void m38546(final c37042 c37042) {
        c31870.f37895.f37901.m37049(c37042);
    }
    
    private static /* synthetic */ void m38548(final Value value) {
        value.m33468(c31870.f37895.f37900);
    }
    
    private static /* synthetic */ void m38550(final c37042 c37042) {
        c31870.f37895.f37900.m37049(c37042);
    }
    
    private static /* synthetic */ void m38552(final Value value) {
        value.m33468(c31870.f37895.f37899);
    }
    
    private static /* synthetic */ void m38554(final c37042 c37042) {
        c31870.f37895.f37899.m37049(c37042);
    }
    
    private static /* synthetic */ void m38556(final Value value) {
        value.m33468(c31870.f37895.f37898);
    }
    
    private static /* synthetic */ void m38558(final c37042 c37042) {
        c31870.f37895.f37898.m37049(c37042);
    }
    
    private static /* synthetic */ void m38560(final Value value) {
        value.m33468(c31870.f37895.f37897);
    }
    
    private static /* synthetic */ void m38562(final c37042 c37042) {
        c31870.f37895.f37897.m37049(c37042);
    }
    
    private static /* synthetic */ void m38564(final Value value) {
        value.m33468(c31870.f37895.f37896);
    }
    
    private static /* synthetic */ void m38566(final Double n) {
        c31870.f37895.f37896 = n;
        if (MinecraftClient.getInstance().currentScreen instanceof c32480) {
            ((c32480)MinecraftClient.getInstance().currentScreen).f37291.m31935();
        }
    }
    
    static {
        f38427 = new String[] { "gui-scale", "Scale of the GUI.", "text", "Text color.", "window-header-text", "Window header text color.", "logged-in-text", "Logged in text color.", "background", "Background color", "background-hovered", "Background hovered color.", "background-pressed", "Background pressed color.", "outline", "Outline color.", "outline-hovered", "Outline hovered color.", "outline-pressed", "Outline pressed color.", "checkbox", "Checkbox color.", "checkbox-pressed", "Checkbox pressed color.", "separator", "Separator color.", "plus", "Plus color.", "plus-hovered", "Plus hovered color.", "plus-pressed", "Plus pressed color.", "minus", "Minus color.", "minus-hovered", "Minus hovered color.", "minus-pressed", "Minus pressed color.", "accent", "Accent color.", "module-background", "Module background color.", "reset", "Reset color.", "reset-hovered", "Reset hovered color.", "reset-pressed", "Reset pressed color.", "slider-left", "Slider left color.", "slider-right", "Slider right color.", "slider-handle", "Slider handle color.", "slider-handle-hovered", "Slider handle hovered color.", "slider-handle-pressed", "Slider handle pressed color.", "color-edit-handle", "Color edit handle", "color-edit-handle-hovered", "Color edit handle hovered color.", "color-edit-handle-pressed", "Color edit handle pressed.", "edit", "Edit color.", "edit-hovered", "Edit hovered color.", "edit-pressed", "Edit pressed color." };
    }
}
