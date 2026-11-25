# main.MotherCanvas

Original JVM class: `main/b`.
CLR reference: `MotherCanvas`.
Status: `reference_proposal`.

Source: `source/src/main/java/main/MotherCanvas.java`.

## Fields (6)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| main/b.aLmain/b; | instance | MotherCanvas.instance | reference_proposal | 9 |
| main/b.bLmain/c; | canvasAdapter |  | behavioral_name | 11 |
| main/b.cI | zoomLevel | MotherCanvas.zoomLevel | reference_proposal | 13 |
| main/b.dI | newWidth | MotherCanvas.newWidth | reference_proposal | 15 |
| main/b.eI | newHeight | MotherCanvas.newHeight | reference_proposal | 17 |
| main/b.fZ | disableZoom |  | behavioral_name | 19 |

## Methods (11)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| main/b.<clinit>()V | <clinit> | MotherCanvas::.cctor | preserved | static/field initializer |
| main/b.<init>()V | <init> | MotherCanvas::.ctor | preserved | 21 |
| main/b.a(Lmain/c;)V | setCanvasAdapter |  | behavioral_name | 41 |
| main/b.paint(Ljavax/microedition/lcdui/Graphics;)V | paint |  | preserved | 45 |
| main/b.keyPressed(I)V | keyPressed | MotherCanvas::keyPressed | preserved | 49 |
| main/b.keyReleased(I)V | keyReleased | MotherCanvas::keyReleased | preserved | 53 |
| main/b.pointerDragged(II)V | pointerDragged | MotherCanvas::pointerDragged | preserved | 57 |
| main/b.pointerPressed(II)V | pointerPressed | MotherCanvas::pointerPressed | preserved | 63 |
| main/b.pointerReleased(II)V | pointerReleased | MotherCanvas::pointerReleased | preserved | 69 |
| main/b.a()I | getHeight_new | MotherCanvas::getHeight_new | reference_proposal | 75 |
| main/b.b()I | getWidth_new | MotherCanvas::getWidth_new | reference_proposal | 79 |
