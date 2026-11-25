# nso.Message

Original JVM class: `ce`.
CLR reference: `Message`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/Message.java`.

## Fields (5)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ce.aB | command | Message.command | reference_proposal | 11 |
| ce.bLjava/io/ByteArrayOutputStream; | outputBuffer |  | behavioral_name | 13 |
| ce.cLjava/io/DataOutputStream; | dos | Message.dos | reference_proposal | 15 |
| ce.dLjava/io/ByteArrayInputStream; | inputBuffer |  | behavioral_name | 17 |
| ce.eLjava/io/DataInputStream; | dis | Message.dis | reference_proposal | 19 |

## Methods (7)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ce.<init>()V | <init> | Message::.ctor | preserved | 21 |
| ce.<init>(B)V | <init> | Message::.ctor | preserved | 24 |
| ce.<init>(B[B)V | <init> | Message::.ctor | preserved | 30 |
| ce.a()[B | getData | Message::getData | reference_proposal | 36 |
| ce.b()Ljava/io/DataInputStream; | reader | Message::reader | reference_proposal | 40 |
| ce.c()Ljava/io/DataOutputStream; | writer | Message::writer | reference_proposal | 44 |
| ce.d()V | cleanup | Message::cleanup | reference_proposal | 48 |
