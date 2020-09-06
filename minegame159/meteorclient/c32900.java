package minegame159.meteorclient;

import java.util.*;

public class c32900<T>
{
    private List<T> f32901;
    private c36844<T> f32902;
    
    public c32900(final c36844<T> f32902) {
        super();
        this.f32901 = new ArrayList<T>();
        this.f32902 = f32902;
    }
    
    public T m32903() {
        if (this.f32901.size() > 0) {
            return this.f32901.remove(this.f32901.size() - 1);
        }
        return this.f32902.m36845();
    }
    
    public void m32905(final T t) {
        this.f32901.add(t);
    }
}
