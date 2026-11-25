# nso.Paint

Original JVM class: `ay`.
CLR reference: `Paint`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/Paint.java`.

## Fields (7)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ay.aI | COLORBACKGROUND | Paint.COLORBACKGROUND | reference_proposal | 8 |
| ay.bI | COLORLIGHT | Paint.COLORLIGHT | reference_proposal | 10 |
| ay.cI | COLORDARK | Paint.COLORDARK | reference_proposal | 12 |
| ay.dI | COLORBORDER | Paint.COLORBORDER | reference_proposal | 14 |
| ay.eI | COLORFOCUS | Paint.COLORFOCUS | reference_proposal | 16 |
| ay.fI | hTab | Paint.hTab | reference_proposal | 18 |
| ay.gI | lenCaption | Paint.lenCaption | reference_proposal | 20 |

## Methods (11)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ay.<clinit>()V | <clinit> | Paint::.cctor | preserved | static/field initializer |
| ay.<init>()V | <init> | Paint::.ctor | preserved | 22 |
| ay.a(Lt;Lbd;Lbd;Lbd;)V | paintCmdBar | Paint::paintCmdBar | reference_proposal | 26 |
| ay.a(Lt;)V | paintCommandBarBackground |  | behavioral_name | 84 |
| ay.a(Lt;ZIIIIIILjava/lang/String;)V | paintInputTf | Paint::paintInputTf | reference_proposal | 93 |
| ay.a(Lt;ZIIIIILjava/lang/String;)V | paintInputTf_new | Paint::paintInputTf_new | reference_proposal | 114 |
| ay.a(Lt;IIII[Ljava/lang/String;Ljavax/microedition/lcdui/Image;)V | paintInputDlg | Paint::paintInputDlg | reference_proposal | 134 |
| ay.a(IIIILt;)V | paintFrame | Paint::paintFrame | reference_proposal | 155 |
| ay.b(IIIILt;)V | paintFrameBorder | Paint::paintFrameBorder | reference_proposal | 173 |
| ay.c(IIIILt;)V | paintFrameInside | Paint::paintFrameInside | reference_proposal | 189 |
| ay.d(IIIILt;)V | paintFrameInsideSelected | Paint::paintFrameInsideSelected | reference_proposal | 194 |
