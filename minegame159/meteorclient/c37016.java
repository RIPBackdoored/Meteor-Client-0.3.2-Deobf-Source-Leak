package minegame159.meteorclient;

import org.apache.commons.lang3.*;

public class c37016 extends c39130
{
    private static final String[] f37017;
    private c37436 f37018;
    private c31399 f37019;
    
    public c37016(final c37436 f37018) {
        super("Select Potion", true);
        this.f37018 = f37018;
        (this.f37019 = new c31399("", 200.0)).m31416(true);
        this.f37019.f31401 = (p0 -> {
            this.clear();
            this.m37020();
            return;
        });
        this.m37020();
    }
    
    private void m37020() {
        this.add(this.f37019).m39587().m39583().m39632();
        this.m39132();
        final c36715 c36715 = this.add(new c36715()).m39632();
        final MyPotion[] values = MyPotion.values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final c34625 c36716 = new c34625(values[i].potion);
            if (this.f37019.f31403.isEmpty() || StringUtils.containsIgnoreCase(c36716.m34638(), this.f37019.f31403)) {
                c36715.m31937(c36716);
                final MyPotion myPotion;
                c36715.m31937(new c38616("Select")).m39632().f38618 = (p1 -> {
                    this.f37018.m33468(myPotion);
                    this.onClose();
                    return;
                });
                c36715.m36739();
            }
        }
    }
    
    private /* synthetic */ void m37026(final MyPotion myPotion, final c38616 c38616) {
        this.f37018.m33468(myPotion);
        this.onClose();
    }
    
    private /* synthetic */ void m37030(final c31399 c31399) {
        this.clear();
        this.m37020();
    }
    
    static {
        f37017 = new String[] { "Select Potion", "", "Select" };
    }
}
