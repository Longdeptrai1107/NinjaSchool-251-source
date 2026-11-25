# nso.SmallImage

Original JVM class: `ab`.
CLR reference: `SmallImage`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/SmallImage.java`.

## Fields (7)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ab.a[[I | smallImg | SmallImage.smallImg | reference_proposal | 13 |
| ab.g[Ljavax/microedition/lcdui/Image; | imgbig | SmallImage.imgbig | reference_proposal | 15 |
| ab.bLjava/util/Hashtable; | imgNew | SmallImage.imgNew | reference_proposal | 17 |
| ab.cS | x | SmallImage.x | reference_proposal | 19 |
| ab.dS | y | SmallImage.y | reference_proposal | 21 |
| ab.eS | w | SmallImage.w | reference_proposal | 23 |
| ab.fS | h | SmallImage.h | reference_proposal | 25 |

## Methods (13)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ab.<clinit>()V | <clinit> | SmallImage::.cctor | preserved | static/field initializer |
| ab.<init>(IIIII)V | <init> | SmallImage::.ctor | preserved | 27 |
| ab.a()V | checkTimeUseImg | SmallImage::checkTimeUseImg | reference_proposal | 34 |
| ab.b()V | freeBig | SmallImage::freeBig | reference_proposal | 48 |
| ab.c()V | loadBigImage | SmallImage::loadBigImage | reference_proposal | 53 |
| ab.<init>()V | <init> | SmallImage::.ctor | preserved | 60 |
| ab.d()V | init | SmallImage::init | reference_proposal | 64 |
| ab.e()V | readImage | SmallImage::readImage | reference_proposal | 68 |
| ab.a(I[B)V | reciveImage | SmallImage::reciveImage | reference_proposal | 85 |
| ab.a(I)Z | isExitsImage | SmallImage::isExitsImage | reference_proposal | 97 |
| ab.b(I)I | getHeight | SmallImage::getHeight | reference_proposal | 122 |
| ab.a(Lt;IIIII)V | drawSmallImage | SmallImage::drawSmallImage | reference_proposal | 126 |
| ab.a(Lt;IIIIII)V | drawSmallImageNew | SmallImage::drawSmallImageNew | reference_proposal | 153 |
