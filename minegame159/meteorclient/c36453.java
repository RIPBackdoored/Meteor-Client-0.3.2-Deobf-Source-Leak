package minegame159.meteorclient;

public class c36453 extends c31399
{
    public c37145 f36454;
    public int f36455;
    
    public c36453(final int f36455, final double n) {
        super(Integer.toString(f36455), n);
        this.f31402 = c38392.f38394;
        this.f36455 = f36455;
        super.f31401 = this::m36457;
    }
    
    @Override
    protected void m31408() {
        if (this.f31403.length() > 1 || (this.f31403.length() == 1 && this.f31403.charAt(0) != '-')) {
            super.m31408();
        }
    }
    
    private void m36457(final c31399 c31399) {
        final int f36455 = this.f36455;
        if (this.f31403.isEmpty()) {
            this.f36455 = 0;
        }
        else if (this.f31403.length() == 1 && this.f31403.charAt(0) == '-') {
            this.f36455 = 0;
        }
        else {
            try {
                this.f36455 = Integer.parseInt(this.f31403);
            }
            catch (NumberFormatException ex) {
                try {
                    this.f36455 = ((Long.parseLong(this.f31403) > 0L) ? 0 : Integer.MIN_VALUE);
                }
                catch (NumberFormatException ex2) {
                    this.f36455 = 0;
                }
                this.f31403 = Integer.toString(this.f36455);
            }
        }
        if (this.f36454 != null && this.f36455 != f36455) {
            this.f36454.m37146(this);
        }
    }
    
    public void m36464(final int f36455) {
        this.f36455 = f36455;
        this.f31403 = Integer.toString(f36455);
    }
}
