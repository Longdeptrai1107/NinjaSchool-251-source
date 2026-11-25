# nso.TileMap

Original JVM class: `af`.
CLR reference: `TileMap`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/TileMap.java`.

## Fields (51)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| af.aI | tmw | TileMap.tmw | reference_proposal | 13 |
| af.bI | tmh | TileMap.tmh | reference_proposal | 15 |
| af.cI | pxw | TileMap.pxw | reference_proposal | 17 |
| af.dI | pxh | TileMap.pxh | reference_proposal | 19 |
| af.eI | tileID | TileMap.tileID | reference_proposal | 21 |
| af.f[C | maps | TileMap.maps | reference_proposal | 23 |
| af.g[I | types | TileMap.types | reference_proposal | 25 |
| af.ELjavax/microedition/lcdui/Image; | imgTile |  | behavioral_name | 27 |
| af.FLjavax/microedition/lcdui/Image; | imgTileSmall | TileMap.imgTileSmall | reference_proposal | 29 |
| af.hLjavax/microedition/lcdui/Image; | imgMiniMap | TileMap.imgMiniMap | reference_proposal | 31 |
| af.GLjavax/microedition/lcdui/Image; | imgWaterfall | TileMap.imgWaterfall | reference_proposal | 33 |
| af.HLjavax/microedition/lcdui/Image; | imgTopWaterfall | TileMap.imgTopWaterfall | reference_proposal | 35 |
| af.ILjavax/microedition/lcdui/Image; | imgWaterflow | TileMap.imgWaterflow | reference_proposal | 37 |
| af.JLjavax/microedition/lcdui/Image; | imgLeaf | TileMap.imgLeaf | reference_proposal | 39 |
| af.KLjavax/microedition/lcdui/Image; | imgflowRiver | TileMap.imgflowRiver | reference_proposal | 41 |
| af.iB | size | TileMap.size | reference_proposal | 43 |
| af.LI | bx | TileMap.bx | reference_proposal | 45 |
| af.MI | dbx | TileMap.dbx | reference_proposal | 47 |
| af.NI | fx | TileMap.fx | reference_proposal | 49 |
| af.OI | dfx | TileMap.dfx | reference_proposal | 51 |
| af.jLjava/lang/String; | mapName1 | TileMap.mapName1 | reference_proposal | 53 |
| af.kLjava/lang/String; | mapName | TileMap.mapName | reference_proposal | 55 |
| af.lB | zoneID | TileMap.zoneID | reference_proposal | 57 |
| af.mB | bgID | TileMap.bgID | reference_proposal | 59 |
| af.nB | typeMap | TileMap.typeMap | reference_proposal | 61 |
| af.oS | mapID | TileMap.mapID | reference_proposal | 63 |
| af.PI | cmtoYmini | TileMap.cmtoYmini | reference_proposal | 65 |
| af.QI | cmyMini | TileMap.cmyMini | reference_proposal | 67 |
| af.RI | cmdyMini | TileMap.cmdyMini | reference_proposal | 69 |
| af.SI | cmvyMini | TileMap.cmvyMini | reference_proposal | 71 |
| af.TI | cmtoXMini | TileMap.cmtoXMini | reference_proposal | 73 |
| af.UI | cmxMini | TileMap.cmxMini | reference_proposal | 75 |
| af.VI | cmdxMini | TileMap.cmdxMini | reference_proposal | 77 |
| af.WI | cmvxMini | TileMap.cmvxMini | reference_proposal | 79 |
| af.pI | wMiniMap | TileMap.wMiniMap | reference_proposal | 81 |
| af.qI | hMiniMap | TileMap.hMiniMap | reference_proposal | 83 |
| af.rI | posMiniMapX | TileMap.posMiniMapX | reference_proposal | 85 |
| af.sI | posMiniMapY | TileMap.posMiniMapY | reference_proposal | 87 |
| af.tLjava/util/Vector; | vGo | TileMap.vGo | reference_proposal | 89 |
| af.u[Ljava/lang/String; | mapNames | TileMap.mapNames | reference_proposal | 91 |
| af.vLbm; | locationStand | TileMap.locationStand | reference_proposal | 93 |
| af.wLbm; | itemMap | TileMap.itemMap | reference_proposal | 95 |
| af.XI | defaultSolidTile | TileMap.defaultSolidTile | reference_proposal | 97 |
| af.xI | sizeMiniMap | TileMap.sizeMiniMap | reference_proposal | 99 |
| af.yI | gssx | TileMap.gssx | reference_proposal | 101 |
| af.zI | gssxe | TileMap.gssxe | reference_proposal | 103 |
| af.AI | gssy | TileMap.gssy | reference_proposal | 105 |
| af.BI | gssye | TileMap.gssye | reference_proposal | 107 |
| af.CI | countx | TileMap.countx | reference_proposal | 109 |
| af.DI | county | TileMap.county | reference_proposal | 111 |
| af.Y[I | colorMini | TileMap.colorMini | reference_proposal | 113 |

## Methods (21)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| af.<clinit>()V | <clinit> | TileMap::.cctor | preserved | static/field initializer |
| af.<init>()V | <init> | TileMap::.ctor | preserved | 115 |
| af.a(IIII)V | setPosMiniMap | TileMap::setPosMiniMap | reference_proposal | 118 |
| af.a()V | updateMiniMap | TileMap::updateMiniMap | reference_proposal | 125 |
| af.b()V | updateCmMiniMap | TileMap::updateCmMiniMap | reference_proposal | 145 |
| af.c()V | freeTileImage |  | behavioral_name | 162 |
| af.d()V | loadTileImage | TileMap::loadTileImage | reference_proposal | 167 |
| af.a(I)V | loadMap | TileMap::loadMap | reference_proposal | 186 |
| af.a(Lt;)V | paintTilemap | TileMap::paintTilemap | reference_proposal | 414 |
| af.b(Lt;)V | paintMiniMap | TileMap::paintMiniMap | reference_proposal | 542 |
| af.c(Lt;)V | paintOutTilemap | TileMap::paintOutTilemap | reference_proposal | 596 |
| af.b(II)I | tileAt | TileMap::tileAt | reference_proposal | 643 |
| af.c(II)I | tileTypeAt | TileMap::tileTypeAt | reference_proposal | 651 |
| af.a(II)I | tileTypeAtPixel | TileMap::tileTypeAtPixel | reference_proposal | 659 |
| af.a(III)Z | tileTypeAt | TileMap::tileTypeAt | reference_proposal | 667 |
| af.b(III)V | setTileTypeAtPixel | TileMap::setTileTypeAtPixel | reference_proposal | 675 |
| af.c(III)V | killTileTypeAt | TileMap::killTileTypeAt | reference_proposal | 679 |
| af.b(I)I | tileYofPixel | TileMap::tileYofPixel | reference_proposal | 683 |
| af.c(I)I | tileXofPixel | TileMap::tileXofPixel | reference_proposal | 687 |
| af.e()V | loadMapFromResource | TileMap::loadMapFromResource | reference_proposal | 691 |
| af.f()V | reloadTileSheets |  | behavioral_name | 705 |
