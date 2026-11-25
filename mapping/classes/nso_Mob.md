# nso.Mob

Original JVM class: `ci`.
CLR reference: `Mob`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/Mob.java`.

## Fields (58)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ci.b[La; | arrMobTemplate | Mob.arrMobTemplate | reference_proposal | 8 |
| ci.cI | hp | Mob.hp | reference_proposal | 10 |
| ci.dI | maxHp | Mob.maxHp | reference_proposal | 12 |
| ci.eI | x | Mob.x | reference_proposal | 14 |
| ci.fI | y | Mob.y | reference_proposal | 16 |
| ci.EI | frame | Mob.frame | reference_proposal | 18 |
| ci.gI | dir | Mob.dir | reference_proposal | 20 |
| ci.FI | dirV | Mob.dirV | reference_proposal | 22 |
| ci.hI | status | Mob.status | reference_proposal | 24 |
| ci.GI | p1 | Mob.p1 | reference_proposal | 26 |
| ci.HI | p2 | Mob.p2 | reference_proposal | 28 |
| ci.II | p3 | Mob.p3 | reference_proposal | 30 |
| ci.iI | xFirst | Mob.xFirst | reference_proposal | 32 |
| ci.jI | yFirst | Mob.yFirst | reference_proposal | 34 |
| ci.kI | w | Mob.w | reference_proposal | 36 |
| ci.lI | h | Mob.h | reference_proposal | 38 |
| ci.JI | timeStatus | Mob.timeStatus | reference_proposal | 40 |
| ci.mS | mobId | Mob.mobId | reference_proposal | 42 |
| ci.nZ | isDisable | Mob.isDisable | reference_proposal | 44 |
| ci.oZ | isDontMove | Mob.isDontMove | reference_proposal | 46 |
| ci.pZ | isFire | Mob.isFire | reference_proposal | 48 |
| ci.qZ | isIce | Mob.isIce | reference_proposal | 50 |
| ci.rZ | isWind | Mob.isWind | reference_proposal | 52 |
| ci.KLaa; | vMobMove | Mob.vMobMove | reference_proposal | 54 |
| ci.sI | templateId | Mob.templateId | reference_proposal | 56 |
| ci.LLbp; | cFocus | Mob.cFocus | reference_proposal | 58 |
| ci.MLdk; | bFocus | Mob.bFocus | reference_proposal | 60 |
| ci.tI | dame | Mob.dame | reference_proposal | 62 |
| ci.uI | dameMp | Mob.dameMp | reference_proposal | 64 |
| ci.vI | sys | Mob.sys | reference_proposal | 66 |
| ci.NI | typeAtt | Mob.typeAtt | reference_proposal | 68 |
| ci.wS | levelBoss | Mob.levelBoss | reference_proposal | 70 |
| ci.xS | level | Mob.level | reference_proposal | 72 |
| ci.OZ | isBoss | Mob.isBoss | reference_proposal | 74 |
| ci.PJ | timeStartDie | Mob.timeStartDie | reference_proposal | 76 |
| ci.QI | frameIndex | Mob.frameIndex | reference_proposal | 78 |
| ci.yLbp; | interestChar | Mob.interestChar | reference_proposal | 80 |
| ci.zLaa; | vEggMonter | Mob.vEggMonter | reference_proposal | 82 |
| ci.RLbt; | egg | Mob.egg | reference_proposal | 84 |
| ci.SJ | timewait | Mob.timewait | reference_proposal | 86 |
| ci.TZ | removeWhenDie | Mob.removeWhenDie | reference_proposal | 88 |
| ci.AZ | isBusyAttackSomeOne | Mob.isBusyAttackSomeOne | reference_proposal | 90 |
| ci.UJ | timeCurrent | Mob.timeCurrent | reference_proposal | 92 |
| ci.BLbp; | owner | Mob.owner | reference_proposal | 94 |
| ci.VZ | isright | Mob.isright | reference_proposal | 96 |
| ci.WZ | isleft | Mob.isleft | reference_proposal | 98 |
| ci.CLbp; | injureBy | Mob.injureBy | reference_proposal | 100 |
| ci.DZ | injureThenDie | Mob.injureThenDie | reference_proposal | 102 |
| ci.XLci; | mobToAttack | Mob.mobToAttack | reference_proposal | 104 |
| ci.YLbp; | charToAttack | Mob.charToAttack | reference_proposal | 106 |
| ci.ZS | idSkill_atk | Mob.idSkill_atk | reference_proposal | 108 |
| ci.aaB | typeAtk | Mob.typeAtk | reference_proposal | 110 |
| ci.abB | typeTool | Mob.typeTool | reference_proposal | 112 |
| ci.acB | indexlongden | Mob.indexlongden | reference_proposal | 114 |
| ci.ad[[B | idframe | Mob.idframe | reference_proposal | 116 |
| ci.ae[[B | idframeAppear | Mob.idframeAppear | reference_proposal | 118 |
| ci.af[[B | idframeDisappear | Mob.idframeDisappear | reference_proposal | 120 |
| ci.agI | bossMoveFrameIndex |  | behavioral_name | 122 |

## Methods (29)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| ci.<clinit>()V | <clinit> | Mob::.cctor | preserved | static/field initializer |
| ci.<init>(SZZZZZIIIIISSBBZZ)V | <init> | Mob::.ctor | preserved | 124 |
| ci.a()V | updateMobAttack | Mob::updateMobAttack | reference_proposal | 162 |
| ci.b()V | setInjure | Mob::setInjure | reference_proposal | 890 |
| ci.a(Lbp;)V | setAttack | Mob::setAttack | reference_proposal | 897 |
| ci.a(Ldk;)V | setAttack | Mob::setAttack | reference_proposal | 923 |
| ci.h()V | updateInjure | Mob::updateInjure | reference_proposal | 931 |
| ci.i()V | updateTypeMobAttk | Mob::updateTypeMobAttk | reference_proposal | 978 |
| ci.a(IIII)I | getDistance | Mob::getDistance | reference_proposal | 1033 |
| ci.j()V | updateMobWalk | Mob::updateMobWalk | reference_proposal | 1048 |
| ci.c()La; | getTemplate | Mob::getTemplate | reference_proposal | 1260 |
| ci.d()Z | isPaint | Mob::isPaint | reference_proposal | 1264 |
| ci.a(Lt;)V | paint | Mob::paint | reference_proposal | 1298 |
| ci.e()I | getHPColor | Mob::getHPColor | reference_proposal | 1609 |
| ci.f()V | startDie | Mob::startDie | reference_proposal | 1619 |
| ci.a(Lci;)V | attackOtherMob | Mob::attackOtherMob | reference_proposal | 1634 |
| ci.b(Lbp;)V | attackOtherChar | Mob::attackOtherChar | reference_proposal | 1638 |
| ci.k()V | setatk_mob | Mob::setatk_mob | reference_proposal | 1642 |
| ci.a(SBB)V | setTypeAtk | Mob::setTypeAtk | reference_proposal | 1683 |
| ci.g()V | attackOtherInRange | Mob::attackOtherInRange | reference_proposal | 1689 |
| ci.b(I)I | setFrameMove | Mob::setFrameMove | reference_proposal | 1717 |
| ci.c(I)I | setFrameAppear | Mob::setFrameAppear | reference_proposal | 1722 |
| ci.d(I)I | setFrameAtt | Mob::setFrameAtt | reference_proposal | 1731 |
| ci.e(I)I | setFrameDisappear | Mob::setFrameDisappear | reference_proposal | 1826 |
| ci.l()V | updateAttk_Thunuoi | Mob::updateAttk_Thunuoi | reference_proposal | 1835 |
| ci.a(I)Lci; | get_Mob | Mob::get_Mob | reference_proposal | 1892 |
| ci.a(Lt;II)V | paintBoTomMobNew | Mob::paintBoTomMobNew | reference_proposal | 1902 |
| ci.b(Lt;II)V | paintTopMobNew | Mob::paintTopMobNew | reference_proposal | 1945 |
| ci.b(Lt;)V | paintBottomMobNew | Mob::paintBottomMobNew | reference_proposal | 1981 |
