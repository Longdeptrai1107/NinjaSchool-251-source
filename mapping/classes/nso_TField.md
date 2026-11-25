# nso.TField

Original JVM class: `ad`.
CLR reference: `TField`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/TField.java`.

## Fields (33)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ad.aI | x | TField.x | reference_proposal | 11 |
| ad.bI | y | TField.y | reference_proposal | 13 |
| ad.cI | width | TField.width | reference_proposal | 15 |
| ad.dI | height | TField.height | reference_proposal | 17 |
| ad.eZ | isFocus | TField.isFocus | reference_proposal | 19 |
| ad.mZ | unusedInputFlag |  | behavioral_name | 21 |
| ad.nI | typeXpeed | TField.typeXpeed | reference_proposal | 23 |
| ad.o[I | MAX_TIME_TO_CONFIRM_KEY | TField.MAX_TIME_TO_CONFIRM_KEY | reference_proposal | 25 |
| ad.pI | CARET_HEIGHT | TField.CARET_HEIGHT | reference_proposal | 27 |
| ad.q[Ljava/lang/String; | print | TField.print | reference_proposal | 29 |
| ad.r[Ljava/lang/String; | printA | TField.printA | reference_proposal | 31 |
| ad.fLjava/lang/String; | title | TField.title | reference_proposal | 33 |
| ad.gLjava/lang/String; | title_Null | TField.title_Null | reference_proposal | 35 |
| ad.sLjava/lang/String; | text | TField.text | reference_proposal | 37 |
| ad.tLjava/lang/String; | passwordText | TField.passwordText | reference_proposal | 39 |
| ad.uLjava/lang/String; | paintedText | TField.paintedText | reference_proposal | 41 |
| ad.vI | caretPos | TField.caretPos | reference_proposal | 43 |
| ad.wI | counter | TField.counter | reference_proposal | 45 |
| ad.xI | maxTextLenght | TField.maxTextLenght | reference_proposal | 47 |
| ad.yI | offsetX | TField.offsetX | reference_proposal | 49 |
| ad.zI | lastKey | TField.lastKey | reference_proposal | 51 |
| ad.AI | keyInActiveState | TField.keyInActiveState | reference_proposal | 53 |
| ad.BI | indexOfActiveChar | TField.indexOfActiveChar | reference_proposal | 55 |
| ad.CI | showCaretCounter | TField.showCaretCounter | reference_proposal | 57 |
| ad.DI | inputType | TField.inputType | reference_proposal | 59 |
| ad.hZ | isQwerty | TField.isQwerty | reference_proposal | 61 |
| ad.EI | unusedTypingModeAreaWidth |  | behavioral_name | 63 |
| ad.FI | mode | TField.mode | reference_proposal | 65 |
| ad.GI | changeModeKey | TField.changeModeKey | reference_proposal | 67 |
| ad.iLjavax/microedition/lcdui/Canvas; | returnCanvas |  | behavioral_name | 69 |
| ad.jLjavax/microedition/midlet/MIDlet; | midlet |  | behavioral_name | 71 |
| ad.kLjava/lang/String; | name | TField.name | reference_proposal | 73 |
| ad.lLbd; | cmdClear | TField.cmdClear | reference_proposal | 75 |

## Methods (17)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ad.<clinit>()V | <clinit> | TField::.cctor | preserved | static/field initializer |
| ad.a()V | showNativeTextBox |  | behavioral_name | 82 |
| ad.a(C)Z | setNormal | TField::setNormal | reference_proposal | 103 |
| ad.<init>()V | <init> | TField::.ctor | preserved | 107 |
| ad.b()V | clear | TField::clear | reference_proposal | 117 |
| ad.e()V | setOffset | TField::setOffset | reference_proposal | 126 |
| ad.d(I)V | keyPressedAscii | TField::keyPressedAscii | reference_proposal | 146 |
| ad.a(I)Z | keyPressed | TField::keyPressed | reference_proposal | 161 |
| ad.a(Lt;)V | paint | TField::paint | reference_proposal | 289 |
| ad.b(Lt;)V | paint_NonSetClip | TField::paint_NonSetClip | reference_proposal | 309 |
| ad.f()V | setPasswordTest | TField::setPasswordTest | reference_proposal | 327 |
| ad.c()V | update | TField::update | reference_proposal | 339 |
| ad.d()Ljava/lang/String; | getText | TField::getText | reference_proposal | 376 |
| ad.a(Ljava/lang/String;)V | setText | TField::setText | reference_proposal | 380 |
| ad.b(I)V | setMaxTextLenght | TField::setMaxTextLenght | reference_proposal | 393 |
| ad.c(I)V | setIputType | TField::setIputType | reference_proposal | 397 |
| ad.a(ILjava/lang/Object;)V | perform | TField::perform | reference_proposal | 401 |
