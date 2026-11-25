# nso.Command

Original JVM class: `bd`.
CLR reference: `Command`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/Command.java`.

## Fields (13)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| bd.aLjava/lang/String; | caption | Command.caption | reference_proposal | 8 |
| bd.b[Ljava/lang/String; | subCaption | Command.subCaption | reference_proposal | 10 |
| bd.cLcs; | actionListener | Command.actionListener | reference_proposal | 12 |
| bd.dI | idAction | Command.idAction | reference_proposal | 14 |
| bd.lLjavax/microedition/lcdui/Image; | back | Command.back | reference_proposal | 16 |
| bd.mLjavax/microedition/lcdui/Image; | focus | Command.focus | reference_proposal | 18 |
| bd.eLjavax/microedition/lcdui/Image; | img | Command.img | reference_proposal | 20 |
| bd.fI | x | Command.x | reference_proposal | 22 |
| bd.gI | y | Command.y | reference_proposal | 24 |
| bd.hI | w | Command.w | reference_proposal | 26 |
| bd.iI | h | Command.h | reference_proposal | 28 |
| bd.jZ | isFocus | Command.isFocus | reference_proposal | 30 |
| bd.kLjava/lang/Object; | p | Command.p | reference_proposal | 32 |

## Methods (9)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| bd.<init>(Ljava/lang/String;Lcs;ILjava/lang/Object;II)V | <init> | Command::.ctor | preserved | 34 |
| bd.<init>(Ljava/lang/String;Lcs;ILjava/lang/Object;)V | <init> | Command::.ctor | preserved | 47 |
| bd.<init>(Ljava/lang/String;ILjava/lang/Object;)V | <init> | Command::.ctor | preserved | 54 |
| bd.<init>(Ljava/lang/String;I)V | <init> | Command::.ctor | preserved | 60 |
| bd.<init>(Ljava/lang/String;III)V | <init> | Command::.ctor | preserved | 65 |
| bd.a()V | performAction | Command::performAction | reference_proposal | 72 |
| bd.a(Lt;)V | paint | Command::paint | reference_proposal | 82 |
| bd.b()Z | input | Command::input | reference_proposal | 97 |
| bd.c()V | updatePointer | Command::updatePointer | reference_proposal | 110 |
