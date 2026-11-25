# nso.mScreen

Original JVM class: `ag`.
CLR reference: `mScreen`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/mScreen.java`.

## Fields (7)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ag.kLbd; | left | mScreen.left | reference_proposal | 8 |
| ag.lLbd; | center | mScreen.center | reference_proposal | 10 |
| ag.mLbd; | right | mScreen.right | reference_proposal | 12 |
| ag.nI | ITEM_HEIGHT | mScreen.ITEM_HEIGHT | reference_proposal | 14 |
| ag.oI | cmdW | mScreen.cmdW | reference_proposal | 16 |
| ag.pI | cmdH | mScreen.cmdH | reference_proposal | 18 |
| ag.qI | keyTouch | mScreen.keyTouch | reference_proposal | 20 |

## Methods (10)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ag.<clinit>()V | <clinit> | mScreen::.cctor | preserved | static/field initializer |
| ag.<init>()V | <init> | mScreen::.ctor | preserved | 22 |
| ag.a()V | switchToMe | mScreen::switchToMe | reference_proposal | 25 |
| ag.e()V | unLoad | mScreen::unLoad | reference_proposal | 36 |
| ag.f()V | initPos | mScreen::initPos | reference_proposal | 39 |
| ag.b(I)V | keyPress | mScreen::keyPress | reference_proposal | 47 |
| ag.c()V | update |  | reference_proposal | 50 |
| ag.d()V | updateKey | mScreen::updateKey | reference_proposal | 53 |
| ag.a(Lbd;)Z | getCmdPointerLast | mScreen::getCmdPointerLast | reference_proposal | 89 |
| ag.a(Lt;)V | paint | mScreen::paint | reference_proposal | 138 |
