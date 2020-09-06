package minegame159.meteorclient;

import net.minecraft.world.dimension.*;
import java.util.function.*;
import meteorclient.setting.*;
import net.minecraft.client.gui.screen.*;

public class c33684 extends c39130
{
    private static final String[] f36161;
    private final c33820 f36162;
    private final boolean f36163;
    
    public c33684(final c33820 c33820) {
        super((c33820 == null) ? "New Waypoint" : "Edit Waypoint", true);
        this.f36163 = (c33820 == null);
        this.f36162 = (this.f36163 ? new c33820() : c33820);
        if (this.f36163) {
            this.f36162.f33826 = (int)this.f37289.player.x;
            this.f36162.f33827 = (int)this.f37289.player.y + 2;
            this.f36162.f33828 = (int)this.f37289.player.z;
            if (this.f37289.player.dimension == DimensionType.field_13072) {
                this.f36162.f33832 = true;
            }
            else if (this.f37289.player.dimension == DimensionType.field_13076) {
                this.f36162.f33833 = true;
            }
            else if (this.f37289.player.dimension == DimensionType.field_13078) {
                this.f36162.f33834 = true;
            }
        }
        this.m36164();
    }
    
    private void m36164() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: new             Lminegame159/meteorclient/c39081;
        //     4: dup            
        //     5: ldc             "Name:"
        //     7: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //    10: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //    13: pop            
        //    14: aload_0        
        //    15: new             Lminegame159/meteorclient/c31399;
        //    18: dup            
        //    19: aload_0        
        //    20: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //    23: getfield        minegame159/meteorclient/c33820.f33823:Ljava/lang/String;
        //    26: ldc2_w          125.0
        //    29: invokespecial   minegame159/meteorclient/c31399.<init>:(Ljava/lang/String;D)V
        //    32: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //    35: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //    38: checkcast       Lminegame159/meteorclient/c31399;
        //    41: aload_0        
        //    42: invokedynamic   BootstrapMethod #0, m35816:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c35815;
        //    47: putfield        minegame159/meteorclient/c31399.f31401:Lminegame159/meteorclient/c35815;
        //    50: aload_0        
        //    51: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //    54: aload_0        
        //    55: new             Lminegame159/meteorclient/c39081;
        //    58: dup            
        //    59: ldc             "Icon:"
        //    61: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //    64: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //    67: pop            
        //    68: aload_0        
        //    69: new             Lminegame159/meteorclient/c36715;
        //    72: dup            
        //    73: invokespecial   minegame159/meteorclient/c36715.<init>:()V
        //    76: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //    79: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //    82: checkcast       Lminegame159/meteorclient/c36715;
        //    85: astore_1       
        //    86: aload_1        
        //    87: new             Lminegame159/meteorclient/c38616;
        //    90: dup            
        //    91: ldc             "Prev"
        //    93: invokespecial   minegame159/meteorclient/c38616.<init>:(Ljava/lang/String;)V
        //    96: invokevirtual   minegame159/meteorclient/c36715.m31937:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //    99: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   102: checkcast       Lminegame159/meteorclient/c38616;
        //   105: aload_0        
        //   106: invokedynamic   BootstrapMethod #1, m34754:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c34753;
        //   111: putfield        minegame159/meteorclient/c38616.f38618:Lminegame159/meteorclient/c34753;
        //   114: aload_1        
        //   115: new             Lminegame159/meteorclient/c33684$c33880;
        //   118: dup            
        //   119: aload_0        
        //   120: aconst_null    
        //   121: invokespecial   minegame159/meteorclient/c33684$c33880.<init>:(Lminegame159/meteorclient/c33684;Lminegame159/meteorclient/c33684$c33685;)V
        //   124: invokevirtual   minegame159/meteorclient/c36715.m31937:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   127: pop            
        //   128: aload_1        
        //   129: new             Lminegame159/meteorclient/c38616;
        //   132: dup            
        //   133: ldc             "Next"
        //   135: invokespecial   minegame159/meteorclient/c38616.<init>:(Ljava/lang/String;)V
        //   138: invokevirtual   minegame159/meteorclient/c36715.m31937:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   141: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   144: checkcast       Lminegame159/meteorclient/c38616;
        //   147: aload_0        
        //   148: invokedynamic   BootstrapMethod #2, m34754:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c34753;
        //   153: putfield        minegame159/meteorclient/c38616.f38618:Lminegame159/meteorclient/c34753;
        //   156: aload_0        
        //   157: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   160: aload_0        
        //   161: new             Lminegame159/meteorclient/c39081;
        //   164: dup            
        //   165: ldc             "Color:"
        //   167: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   170: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   173: pop            
        //   174: aload_0        
        //   175: new             Lminegame159/meteorclient/c36715;
        //   178: dup            
        //   179: invokespecial   minegame159/meteorclient/c36715.<init>:()V
        //   182: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   185: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   188: checkcast       Lminegame159/meteorclient/c36715;
        //   191: astore_2       
        //   192: aload_2        
        //   193: new             Lminegame159/meteorclient/c32910;
        //   196: dup            
        //   197: aload_0        
        //   198: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   201: getfield        minegame159/meteorclient/c33820.f33825:Lminegame159/meteorclient/c37042;
        //   204: invokespecial   minegame159/meteorclient/c32910.<init>:(Lminegame159/meteorclient/c37042;)V
        //   207: invokevirtual   minegame159/meteorclient/c36715.m31937:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   210: pop            
        //   211: aload_2        
        //   212: new             Lminegame159/meteorclient/c38616;
        //   215: dup            
        //   216: getstatic       minegame159/meteorclient/c36250.f36261:Lminegame159/meteorclient/c33493;
        //   219: invokespecial   minegame159/meteorclient/c38616.<init>:(Lminegame159/meteorclient/c33493;)V
        //   222: invokevirtual   minegame159/meteorclient/c36715.m31937:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   225: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   228: checkcast       Lminegame159/meteorclient/c38616;
        //   231: aload_0        
        //   232: invokedynamic   BootstrapMethod #3, m34754:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c34753;
        //   237: putfield        minegame159/meteorclient/c38616.f38618:Lminegame159/meteorclient/c34753;
        //   240: aload_0        
        //   241: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   244: aload_0        
        //   245: new             Lminegame159/meteorclient/c38757;
        //   248: dup            
        //   249: invokespecial   minegame159/meteorclient/c38757.<init>:()V
        //   252: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   255: invokevirtual   minegame159/meteorclient/c33587.m39587:()Lminegame159/meteorclient/c33587;
        //   258: invokevirtual   minegame159/meteorclient/c33587.m39583:()Lminegame159/meteorclient/c33587;
        //   261: pop            
        //   262: aload_0        
        //   263: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   266: aload_0        
        //   267: new             Lminegame159/meteorclient/c39081;
        //   270: dup            
        //   271: ldc             "X:"
        //   273: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   276: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   279: pop            
        //   280: aload_0        
        //   281: new             Lminegame159/meteorclient/c36453;
        //   284: dup            
        //   285: aload_0        
        //   286: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   289: getfield        minegame159/meteorclient/c33820.f33826:I
        //   292: ldc2_w          50.0
        //   295: invokespecial   minegame159/meteorclient/c36453.<init>:(ID)V
        //   298: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   301: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   304: checkcast       Lminegame159/meteorclient/c36453;
        //   307: aload_0        
        //   308: invokedynamic   BootstrapMethod #4, m37146:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c37145;
        //   313: putfield        minegame159/meteorclient/c36453.f36454:Lminegame159/meteorclient/c37145;
        //   316: aload_0        
        //   317: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   320: aload_0        
        //   321: new             Lminegame159/meteorclient/c39081;
        //   324: dup            
        //   325: ldc             "Y:"
        //   327: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   330: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   333: pop            
        //   334: aload_0        
        //   335: new             Lminegame159/meteorclient/c36453;
        //   338: dup            
        //   339: aload_0        
        //   340: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   343: getfield        minegame159/meteorclient/c33820.f33827:I
        //   346: ldc2_w          50.0
        //   349: invokespecial   minegame159/meteorclient/c36453.<init>:(ID)V
        //   352: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   355: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   358: checkcast       Lminegame159/meteorclient/c36453;
        //   361: aload_0        
        //   362: invokedynamic   BootstrapMethod #5, m37146:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c37145;
        //   367: putfield        minegame159/meteorclient/c36453.f36454:Lminegame159/meteorclient/c37145;
        //   370: aload_0        
        //   371: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   374: aload_0        
        //   375: new             Lminegame159/meteorclient/c39081;
        //   378: dup            
        //   379: ldc_w           "Z:"
        //   382: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   385: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   388: pop            
        //   389: aload_0        
        //   390: new             Lminegame159/meteorclient/c36453;
        //   393: dup            
        //   394: aload_0        
        //   395: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   398: getfield        minegame159/meteorclient/c33820.f33828:I
        //   401: ldc2_w          50.0
        //   404: invokespecial   minegame159/meteorclient/c36453.<init>:(ID)V
        //   407: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   410: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   413: checkcast       Lminegame159/meteorclient/c36453;
        //   416: aload_0        
        //   417: invokedynamic   BootstrapMethod #6, m37146:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c37145;
        //   422: putfield        minegame159/meteorclient/c36453.f36454:Lminegame159/meteorclient/c37145;
        //   425: aload_0        
        //   426: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   429: aload_0        
        //   430: new             Lminegame159/meteorclient/c38757;
        //   433: dup            
        //   434: invokespecial   minegame159/meteorclient/c38757.<init>:()V
        //   437: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   440: invokevirtual   minegame159/meteorclient/c33587.m39587:()Lminegame159/meteorclient/c33587;
        //   443: invokevirtual   minegame159/meteorclient/c33587.m39583:()Lminegame159/meteorclient/c33587;
        //   446: pop            
        //   447: aload_0        
        //   448: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   451: aload_0        
        //   452: new             Lminegame159/meteorclient/c39081;
        //   455: dup            
        //   456: ldc_w           "Visible:"
        //   459: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   462: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   465: pop            
        //   466: aload_0        
        //   467: new             Lminegame159/meteorclient/c38264;
        //   470: dup            
        //   471: aload_0        
        //   472: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   475: getfield        minegame159/meteorclient/c33820.f33829:Z
        //   478: invokespecial   minegame159/meteorclient/c38264.<init>:(Z)V
        //   481: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   484: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   487: checkcast       Lminegame159/meteorclient/c38264;
        //   490: aload_0        
        //   491: invokedynamic   BootstrapMethod #7, m31922:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c31921;
        //   496: putfield        minegame159/meteorclient/c38264.f38265:Lminegame159/meteorclient/c31921;
        //   499: aload_0        
        //   500: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   503: aload_0        
        //   504: new             Lminegame159/meteorclient/c39081;
        //   507: dup            
        //   508: ldc_w           "Max Visible Distance:"
        //   511: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   514: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   517: pop            
        //   518: aload_0        
        //   519: new             Lminegame159/meteorclient/c32167;
        //   522: dup            
        //   523: iconst_0       
        //   524: sipush          10000
        //   527: aload_0        
        //   528: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   531: getfield        minegame159/meteorclient/c33820.f33830:I
        //   534: invokespecial   minegame159/meteorclient/c32167.<init>:(III)V
        //   537: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   540: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   543: checkcast       Lminegame159/meteorclient/c32167;
        //   546: aload_0        
        //   547: invokedynamic   BootstrapMethod #8, m32768:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c32767;
        //   552: putfield        minegame159/meteorclient/c32167.f32168:Lminegame159/meteorclient/c32767;
        //   555: aload_0        
        //   556: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   559: aload_0        
        //   560: new             Lminegame159/meteorclient/c39081;
        //   563: dup            
        //   564: ldc_w           "Scale:"
        //   567: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   570: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   573: pop            
        //   574: aload_0        
        //   575: new             Lminegame159/meteorclient/c36873;
        //   578: dup            
        //   579: dconst_0       
        //   580: ldc2_w          4.0
        //   583: aload_0        
        //   584: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   587: getfield        minegame159/meteorclient/c33820.f33831:D
        //   590: invokespecial   minegame159/meteorclient/c36873.<init>:(DDD)V
        //   593: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   596: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   599: checkcast       Lminegame159/meteorclient/c36873;
        //   602: aload_0        
        //   603: invokedynamic   BootstrapMethod #9, m39852:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c39851;
        //   608: putfield        minegame159/meteorclient/c36873.f36874:Lminegame159/meteorclient/c39851;
        //   611: aload_0        
        //   612: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   615: aload_0        
        //   616: new             Lminegame159/meteorclient/c38757;
        //   619: dup            
        //   620: invokespecial   minegame159/meteorclient/c38757.<init>:()V
        //   623: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   626: invokevirtual   minegame159/meteorclient/c33587.m39587:()Lminegame159/meteorclient/c33587;
        //   629: invokevirtual   minegame159/meteorclient/c33587.m39583:()Lminegame159/meteorclient/c33587;
        //   632: pop            
        //   633: aload_0        
        //   634: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   637: aload_0        
        //   638: new             Lminegame159/meteorclient/c39081;
        //   641: dup            
        //   642: ldc_w           "Overworld:"
        //   645: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   648: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   651: pop            
        //   652: aload_0        
        //   653: new             Lminegame159/meteorclient/c38264;
        //   656: dup            
        //   657: aload_0        
        //   658: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   661: getfield        minegame159/meteorclient/c33820.f33832:Z
        //   664: invokespecial   minegame159/meteorclient/c38264.<init>:(Z)V
        //   667: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   670: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   673: checkcast       Lminegame159/meteorclient/c38264;
        //   676: aload_0        
        //   677: invokedynamic   BootstrapMethod #10, m31922:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c31921;
        //   682: putfield        minegame159/meteorclient/c38264.f38265:Lminegame159/meteorclient/c31921;
        //   685: aload_0        
        //   686: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   689: aload_0        
        //   690: new             Lminegame159/meteorclient/c39081;
        //   693: dup            
        //   694: ldc_w           "Nether:"
        //   697: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   700: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   703: pop            
        //   704: aload_0        
        //   705: new             Lminegame159/meteorclient/c38264;
        //   708: dup            
        //   709: aload_0        
        //   710: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   713: getfield        minegame159/meteorclient/c33820.f33833:Z
        //   716: invokespecial   minegame159/meteorclient/c38264.<init>:(Z)V
        //   719: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   722: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   725: checkcast       Lminegame159/meteorclient/c38264;
        //   728: aload_0        
        //   729: invokedynamic   BootstrapMethod #11, m31922:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c31921;
        //   734: putfield        minegame159/meteorclient/c38264.f38265:Lminegame159/meteorclient/c31921;
        //   737: aload_0        
        //   738: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   741: aload_0        
        //   742: new             Lminegame159/meteorclient/c39081;
        //   745: dup            
        //   746: ldc_w           "End:"
        //   749: invokespecial   minegame159/meteorclient/c39081.<init>:(Ljava/lang/String;)V
        //   752: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   755: pop            
        //   756: aload_0        
        //   757: new             Lminegame159/meteorclient/c38264;
        //   760: dup            
        //   761: aload_0        
        //   762: getfield        minegame159/meteorclient/c33684.f36162:Lminegame159/meteorclient/c33820;
        //   765: getfield        minegame159/meteorclient/c33820.f33834:Z
        //   768: invokespecial   minegame159/meteorclient/c38264.<init>:(Z)V
        //   771: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   774: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   777: checkcast       Lminegame159/meteorclient/c38264;
        //   780: aload_0        
        //   781: invokedynamic   BootstrapMethod #12, m31922:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c31921;
        //   786: putfield        minegame159/meteorclient/c38264.f38265:Lminegame159/meteorclient/c31921;
        //   789: aload_0        
        //   790: invokevirtual   minegame159/meteorclient/c33684.m39132:()V
        //   793: aload_0        
        //   794: new             Lminegame159/meteorclient/c38616;
        //   797: dup            
        //   798: ldc_w           "Save"
        //   801: invokespecial   minegame159/meteorclient/c38616.<init>:(Ljava/lang/String;)V
        //   804: invokevirtual   minegame159/meteorclient/c33684.add:(Lminegame159/meteorclient/c31923;)Lminegame159/meteorclient/c33587;
        //   807: invokevirtual   minegame159/meteorclient/c33587.m39587:()Lminegame159/meteorclient/c33587;
        //   810: invokevirtual   minegame159/meteorclient/c33587.m39583:()Lminegame159/meteorclient/c33587;
        //   813: invokevirtual   minegame159/meteorclient/c33587.m39632:()Lminegame159/meteorclient/c31923;
        //   816: checkcast       Lminegame159/meteorclient/c38616;
        //   819: aload_0        
        //   820: invokedynamic   BootstrapMethod #13, m34754:(Lminegame159/meteorclient/c33684;)Lminegame159/meteorclient/c34753;
        //   825: putfield        minegame159/meteorclient/c38616.f38618:Lminegame159/meteorclient/c34753;
        //   828: return         
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private /* synthetic */ void m36168(final c38616 c38616) {
        if (this.f36163) {
            c34924.f34927.m34935(this.f36162);
        }
        else {
            c34924.f34927.m37303();
        }
        this.onClose();
    }
    
    private /* synthetic */ void m36171(final c38264 c38264) {
        this.f36162.f33834 = c38264.f38266;
    }
    
    private /* synthetic */ void m36174(final c38264 c38264) {
        this.f36162.f33833 = c38264.f38266;
    }
    
    private /* synthetic */ void m36177(final c38264 c38264) {
        this.f36162.f33832 = c38264.f38266;
    }
    
    private /* synthetic */ void m36180(final c36873 c36873) {
        c36873.m36879(Math.round(c36873.m36877() * 1000.0) / 1000.0);
        this.f36162.f33831 = c36873.m36877();
    }
    
    private /* synthetic */ void m36183(final c32167 c32167) {
        this.f36162.f33830 = c32167.m32171();
    }
    
    private /* synthetic */ void m36186(final c38264 c38264) {
        this.f36162.f33829 = c38264.f38266;
    }
    
    private /* synthetic */ void m36189(final c36453 c36453) {
        this.f36162.f33828 = c36453.f36455;
    }
    
    private /* synthetic */ void m36192(final c36453 c36453) {
        if (c36453.f36455 < 0) {
            c36453.m36464(0);
        }
        else if (c36453.f36455 > 255) {
            c36453.m36464(255);
        }
        this.f36162.f33827 = c36453.f36455;
    }
    
    private /* synthetic */ void m36195(final c36453 c36453) {
        this.f36162.f33826 = c36453.f36455;
    }
    
    private /* synthetic */ void m36198(final c38616 c38616) {
        this.f37289.openScreen((Screen)new c37174(new c33179("", "", this.f36162.f33825, c38617 -> this.f36162.f33825.m37049(c38617), null)));
    }
    
    private /* synthetic */ void m36201(final c37042 c37042) {
        this.f36162.f33825.m37049(c37042);
    }
    
    private /* synthetic */ void m36204(final c38616 c38616) {
        this.f36162.m33862();
    }
    
    private /* synthetic */ void m36207(final c38616 c38616) {
        this.f36162.m33860();
    }
    
    private /* synthetic */ void m36210(final c31399 c31399) {
        this.f36162.f33823 = c31399.f31403;
    }
    
    static /* synthetic */ c33820 m36213(final c33684 c33684) {
        return c33684.f36162;
    }
    
    static {
        f36161 = new String[] { "New Waypoint", "Edit Waypoint", "Name:", "Icon:", "Prev", "Next", "Color:", "X:", "Y:", "Z:", "Visible:", "Max Visible Distance:", "Scale:", "Overworld:", "Nether:", "End:", "Save", "", "" };
    }
    
    private class c33880 extends c31923
    {
        final /* synthetic */ c33684 f33881;
        
        private c33880(final c33684 f33881) {
            this.f33881 = f33881;
            super();
        }
        
        @Override
        protected void m31978() {
            this.f31927 = 16.0;
            this.f31928 = 16.0;
        }
        
        @Override
        protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
            c36250.m36285(() -> this.f33881.f36162.m33843(this.f31925, this.f31926, 0.0));
        }
        
        private /* synthetic */ void m33888() {
            this.f33881.f36162.m33843(this.f31925, this.f31926, 0.0);
        }
        
        c33880(final c33684 c33684, final c33685 c33685) {
            this(c33684);
        }
    }
    
    static class c33685
    {
    }
}
