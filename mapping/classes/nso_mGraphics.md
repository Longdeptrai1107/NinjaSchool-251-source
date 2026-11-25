# nso.mGraphics

Original JVM class: `t`.
CLR reference: `mGraphics`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/mGraphics.java`.

## Fields (2)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| t.aLjavax/microedition/lcdui/Graphics; | graphics |  | behavioral_name | 8 |
| t.bI | zoomLevel | mGraphics.zoomLevel | reference_proposal | 10 |

## Methods (17)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| t.<clinit>()V | <clinit> | mGraphics::.cctor | preserved | static/field initializer |
| t.<init>(Ljavax/microedition/lcdui/Graphics;)V | <init> |  | preserved | 12 |
| t.<init>()V | <init> | mGraphics::.ctor | preserved | 16 |
| t.a(Ljavax/microedition/lcdui/Image;III)V | drawImage | mGraphics::drawImage | reference_proposal | 19 |
| t.a(IIII)V | drawLine | mGraphics::drawLine | reference_proposal | 25 |
| t.b(IIII)V | drawRect | mGraphics::drawRect | reference_proposal | 33 |
| t.a(Ljavax/microedition/lcdui/Image;IIIIIIII)V | drawRegion | mGraphics::drawRegion | reference_proposal | 41 |
| t.a(IIIIII)V | drawRoundRect | mGraphics::drawRoundRect | reference_proposal | 51 |
| t.c(IIII)V | fillRect | mGraphics::fillRect | reference_proposal | 61 |
| t.b(IIIIII)V | fillRoundRect | mGraphics::fillRoundRect | reference_proposal | 69 |
| t.a()I | getTranslateX | mGraphics::getTranslateX | reference_proposal | 79 |
| t.b()I | getTranslateY | mGraphics::getTranslateY | reference_proposal | 83 |
| t.d(IIII)V | setClip | mGraphics::setClip | reference_proposal | 87 |
| t.a(I)V | setColor | mGraphics::setColor | reference_proposal | 95 |
| t.a(II)V | translate | mGraphics::translate | reference_proposal | 99 |
| t.a(Ljavax/microedition/lcdui/Image;)I | getImageWidth | mGraphics::getImageWidth | reference_proposal | 105 |
| t.b(Ljavax/microedition/lcdui/Image;)I | getImageHeight | mGraphics::getImageHeight | reference_proposal | 109 |
