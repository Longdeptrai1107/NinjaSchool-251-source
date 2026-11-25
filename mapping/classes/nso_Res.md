# nso.Res

Original JVM class: `am`.
CLR reference: `Res`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/Res.java`.

## Fields (4)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| am.a[S | SIN | Res.SIN | reference_proposal | 8 |
| am.b[S | COS | Res.COS | reference_proposal | 10 |
| am.c[I | TAN | Res.TAN | reference_proposal | 12 |
| am.dLjava/util/Random; | r | Res.r | reference_proposal | 14 |

## Methods (16)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| am.<clinit>()V | <clinit> | Res::.cctor | preserved | static/field initializer |
| am.<init>()V | <init> | Res::.ctor | preserved | 16 |
| am.a()V | init | Res::init | reference_proposal | 19 |
| am.a(I)I | sin | Res::sin | reference_proposal | 32 |
| am.b(I)I | cos | Res::cos | reference_proposal | 42 |
| am.a(II)I | angle | Res::angle | reference_proposal | 52 |
| am.c(I)I | fixangle | Res::fixangle | reference_proposal | 82 |
| am.b(II)I | xetVX | Res::xetVX | reference_proposal | 92 |
| am.c(II)I | xetVY | Res::xetVY | reference_proposal | 96 |
| am.d(II)I | random | Res::random | reference_proposal | 100 |
| am.a(IIII)I | distance | Res::distance | reference_proposal | 104 |
| am.d(I)I | rnd | Res::rnd | reference_proposal | 116 |
| am.e(I)I | abs | Res::abs | reference_proposal | 120 |
| am.a(Lt;)V | resetTrans | Res::resetTrans | reference_proposal | 124 |
| am.a(Ljava/lang/String;Ljava/lang/String;I)[Ljava/lang/String; | split | Res::split | reference_proposal | 129 |
| am.a(JI)Ljava/lang/String; | getTimeCountDown | Res::getTimeCountDown | reference_proposal | 142 |
