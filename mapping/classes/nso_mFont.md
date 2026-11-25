# nso.mFont

Original JVM class: `dd`.
CLR reference: `mFont`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/mFont.java`.

## Fields (27)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| dd.uI | space | mFont.space | reference_proposal | 10 |
| dd.vI | height | mFont.height | reference_proposal | 12 |
| dd.wLjavax/microedition/lcdui/Image; | imgFont | mFont.imgFont | reference_proposal | 14 |
| dd.xLjava/lang/String; | strFont | mFont.strFont | reference_proposal | 16 |
| dd.y[[I | fImages | mFont.fImages | reference_proposal | 18 |
| dd.zLjava/lang/String; | FONT_CHARACTERS |  | behavioral_name | 20 |
| dd.aLdd; | tahoma_7b_red | mFont.tahoma_7b_red | reference_proposal | 22 |
| dd.bLdd; | tahoma_7b_blue | mFont.tahoma_7b_blue | reference_proposal | 24 |
| dd.cLdd; | tahoma_7b_purple | mFont.tahoma_7b_purple | reference_proposal | 26 |
| dd.dLdd; | tahoma_7b_yellow | mFont.tahoma_7b_yellow | reference_proposal | 28 |
| dd.eLdd; | tahoma_7b_white | mFont.tahoma_7b_white | reference_proposal | 30 |
| dd.fLdd; | tahoma_7b_green | mFont.tahoma_7b_green | reference_proposal | 32 |
| dd.gLdd; | tahoma_7 | mFont.tahoma_7 | reference_proposal | 34 |
| dd.hLdd; | tahoma_7_blue1 | mFont.tahoma_7_blue1 | reference_proposal | 36 |
| dd.iLdd; | tahoma_7_white | mFont.tahoma_7_white | reference_proposal | 38 |
| dd.jLdd; | tahoma_7_yellow | mFont.tahoma_7_yellow | reference_proposal | 40 |
| dd.kLdd; | tahoma_7_grey | mFont.tahoma_7_grey | reference_proposal | 42 |
| dd.lLdd; | tahoma_7_red | mFont.tahoma_7_red | reference_proposal | 44 |
| dd.mLdd; | tahoma_7_blue | mFont.tahoma_7_blue | reference_proposal | 46 |
| dd.nLdd; | tahoma_7_green | mFont.tahoma_7_green | reference_proposal | 48 |
| dd.oLdd; | tahoma_8b | mFont.tahoma_8b | reference_proposal | 50 |
| dd.pLdd; | number_yellow | mFont.number_yellow | reference_proposal | 52 |
| dd.qLdd; | number_red | mFont.number_red | reference_proposal | 54 |
| dd.rLdd; | number_green | mFont.number_green | reference_proposal | 56 |
| dd.sLdd; | number_white | mFont.number_white | reference_proposal | 58 |
| dd.tLdd; | number_orange | mFont.number_orange | reference_proposal | 60 |
| dd.ALjava/lang/String; | fontImagePath |  | behavioral_name | 62 |

## Methods (10)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| dd.<clinit>()V | <clinit> | mFont::.cctor | preserved | static/field initializer |
| dd.<init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IB)V | <init> |  | preserved | 64 |
| dd.a()V | reloadImage | mFont::reloadImage | reference_proposal | 95 |
| dd.b()V | freeImage | mFont::freeImage | reference_proposal | 99 |
| dd.c()I | getHeight | mFont::getHeight | reference_proposal | 103 |
| dd.a(Ljava/lang/String;)I | getWidth | mFont::getWidth | reference_proposal | 107 |
| dd.a(Lt;Ljava/lang/String;III)V | drawString | mFont::drawString | reference_proposal | 119 |
| dd.a(Lt;Ljava/lang/String;IIILdd;)V | drawString | mFont::drawString | reference_proposal | 139 |
| dd.a(Ljava/lang/String;I)Laa; | splitFontVector | mFont::splitFontVector | reference_proposal | 161 |
| dd.b(Ljava/lang/String;I)[Ljava/lang/String; | splitFontArray | mFont::splitFontArray | reference_proposal | 191 |
