# nso.Service

Original JVM class: `dq`.
CLR reference: `Service`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/Service.java`.

## Fields (4)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| dq.aLdh; | session | Service.session | reference_proposal | 9 |
| dq.bLdq; | instance | Service.instance | reference_proposal | 11 |
| dq.cI | xx | Service.xx | reference_proposal | 13 |
| dq.dI | yy | Service.yy | reference_proposal | 15 |

## Methods (151)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| dq.<init>()V | <init> | Service::.ctor | preserved | 17 |
| dq.a()Ldq; | gI | Service::gI | reference_proposal | 20 |
| dq.b(B)Lce; | messageNotLogin | Service::messageNotLogin | reference_proposal | 27 |
| dq.c(B)Lce; | messageNotMap | Service::messageNotMap | reference_proposal | 34 |
| dq.d(B)Lce; | messageSubCommand | Service::messageSubCommand | reference_proposal | 41 |
| dq.b()V | setClientType | Service::setClientType | reference_proposal | 48 |
| dq.a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V | login | Service::login | reference_proposal | 71 |
| dq.b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V | requestRegisterNew | Service::requestRegisterNew | reference_proposal | 89 |
| dq.a(Ljava/lang/String;)V | requestForgetPass | Service::requestForgetPass | reference_proposal | 102 |
| dq.c()V | requestChangeMap | Service::requestChangeMap | reference_proposal | 113 |
| dq.a(II)V | requestChangeZone | Service::requestChangeZone | reference_proposal | 119 |
| dq.b(II)V | charMove | Service::charMove | reference_proposal | 130 |
| dq.b(Ljava/lang/String;)V | selectCharToPlay | Service::selectCharToPlay | reference_proposal | 147 |
| dq.a(Ljava/lang/String;II)V | createChar | Service::createChar | reference_proposal | 158 |
| dq.a(I)V | requestModTemplate | Service::requestModTemplate | reference_proposal | 171 |
| dq.c(II)V | requestItemInfo | Service::requestItemInfo | reference_proposal | 183 |
| dq.d(II)V | requestItemPlayer | Service::requestItemPlayer | reference_proposal | 196 |
| dq.e(II)V | upPotential | Service::upPotential | reference_proposal | 209 |
| dq.f(II)V | upSkill | Service::upSkill | reference_proposal | 222 |
| dq.b(I)V | itemBodyToBag | Service::itemBodyToBag | reference_proposal | 235 |
| dq.c(I)V | itemMonToBag | Service::itemMonToBag | reference_proposal | 247 |
| dq.d(I)V | itemBoxToBag | Service::itemBoxToBag | reference_proposal | 259 |
| dq.e(I)V | itemBagToBox | Service::itemBagToBox | reference_proposal | 271 |
| dq.f(I)V | useItem | Service::useItem | reference_proposal | 283 |
| dq.g(II)V | saleItem | Service::saleItem | reference_proposal | 299 |
| dq.a(III)V | buyItem | Service::buyItem | reference_proposal | 315 |
| dq.g(I)V | selectSkill | Service::selectSkill | reference_proposal | 332 |
| dq.d()V | openFindParty | Service::openFindParty | reference_proposal | 344 |
| dq.e()V | openUIZone | Service::openUIZone | reference_proposal | 356 |
| dq.h(II)V | useItemChangeMap | Service::useItemChangeMap | reference_proposal | 368 |
| dq.h(I)V | openMenu | Service::openMenu | reference_proposal | 381 |
| dq.a(BIII)V | menu | Service::menu | reference_proposal | 393 |
| dq.a(S)V | menuId | Service::menuId | reference_proposal | 408 |
| dq.a(SLjava/lang/String;)V | textBoxId | Service::textBoxId | reference_proposal | 420 |
| dq.i(I)V | requestItem | Service::requestItem | reference_proposal | 433 |
| dq.f()V | bagSort | Service::bagSort | reference_proposal | 445 |
| dq.g()V | boxSort | Service::boxSort | reference_proposal | 457 |
| dq.j(I)V | boxCoinIn | Service::boxCoinIn | reference_proposal | 469 |
| dq.k(I)V | boxCoinOut | Service::boxCoinOut | reference_proposal | 481 |
| dq.a([Lby;)V | crystalCollect | Service::crystalCollect | reference_proposal | 493 |
| dq.a(Lby;[Lby;Z)V | upgradeItem | Service::upgradeItem | reference_proposal | 511 |
| dq.b([Lby;)V | crystalCollectLock | Service::crystalCollectLock | reference_proposal | 530 |
| dq.a(Lby;)V | splitItem | Service::splitItem | reference_proposal | 548 |
| dq.l(I)V | acceptInviteTrade | Service::acceptInviteTrade | reference_proposal | 561 |
| dq.m(I)V | acceptInviteTestDun | Service::acceptInviteTestDun | reference_proposal | 573 |
| dq.n(I)V | acceptInviteTestGT | Service::acceptInviteTestGT | reference_proposal | 585 |
| dq.o(I)V | sendUIConfirmID | Service::sendUIConfirmID | reference_proposal | 597 |
| dq.p(I)V | acceptInviteTest | Service::acceptInviteTest | reference_proposal | 609 |
| dq.h()V | cancelInviteTrade | Service::cancelInviteTrade | reference_proposal | 621 |
| dq.i()V | cancelTrade | Service::cancelTrade | reference_proposal | 633 |
| dq.j()V | tradeAccept | Service::tradeAccept | reference_proposal | 645 |
| dq.a(I[Lby;)V | tradeItemLock | Service::tradeItemLock | reference_proposal | 657 |
| dq.a(Laa;Laa;I)V | sendPlayerAttack | Service::sendPlayerAttack | reference_proposal | 681 |
| dq.q(I)V | pickItem | Service::pickItem | reference_proposal | 725 |
| dq.r(I)V | throwItem | Service::throwItem | reference_proposal | 740 |
| dq.k()V | returnTownFromDead | Service::returnTownFromDead | reference_proposal | 752 |
| dq.l()V | wakeUpFromDead | Service::wakeUpFromDead | reference_proposal | 764 |
| dq.b(III)V | getTask | Service::getTask | reference_proposal | 776 |
| dq.c(Ljava/lang/String;)V | chat | Service::chat | reference_proposal | 789 |
| dq.d(Ljava/lang/String;)V | adminChat | Service::adminChat | reference_proposal | 801 |
| dq.m()V | updateData | Service::updateData | reference_proposal | 813 |
| dq.n()V | updateMap | Service::updateMap | reference_proposal | 825 |
| dq.o()V | updateSkill | Service::updateSkill | reference_proposal | 837 |
| dq.p()V | updateItem | Service::updateItem | reference_proposal | 849 |
| dq.q()V | clientOk | Service::clientOk | reference_proposal | 861 |
| dq.s(I)V | tradeInvite | Service::tradeInvite | reference_proposal | 873 |
| dq.e(Ljava/lang/String;)V | addFriend | Service::addFriend | reference_proposal | 885 |
| dq.t(I)V | addPartyAccept | Service::addPartyAccept | reference_proposal | 897 |
| dq.u(I)V | addPartyCancel | Service::addPartyCancel | reference_proposal | 909 |
| dq.v(I)V | testInvite | Service::testInvite | reference_proposal | 921 |
| dq.w(I)V | addCuuSat | Service::addCuuSat | reference_proposal | 933 |
| dq.x(I)V | buffLive | Service::buffLive | reference_proposal | 945 |
| dq.f(Ljava/lang/String;)V | addParty | Service::addParty | reference_proposal | 957 |
| dq.y(I)V | requestMaptemplate | Service::requestMaptemplate | reference_proposal | 969 |
| dq.z(I)V | changePk | Service::changePk | reference_proposal | 981 |
| dq.A(I)V | changeTeamLeader | Service::changeTeamLeader | reference_proposal | 993 |
| dq.B(I)V | moveMember | Service::moveMember | reference_proposal | 1005 |
| dq.r()V | sendUseSkillMyBuff | Service::sendUseSkillMyBuff | reference_proposal | 1017 |
| dq.s()V | createParty | Service::createParty | reference_proposal | 1029 |
| dq.a(Z)V | lockParty | Service::lockParty | reference_proposal | 1041 |
| dq.t()V | outParty | Service::outParty | reference_proposal | 1053 |
| dq.u()V | requestFriend | Service::requestFriend | reference_proposal | 1065 |
| dq.C(I)V | requestMatchInfo | Service::requestMatchInfo | reference_proposal | 1077 |
| dq.a(Laa;)V | requestPlayerInfo | Service::requestPlayerInfo | reference_proposal | 1089 |
| dq.v()V | requestEnemies | Service::requestEnemies | reference_proposal | 1105 |
| dq.g(Ljava/lang/String;)V | removeFriend | Service::removeFriend | reference_proposal | 1117 |
| dq.h(Ljava/lang/String;)V | pleaseInputParty | Service::pleaseInputParty | reference_proposal | 1129 |
| dq.i(Ljava/lang/String;)V | acceptPleaseParty | Service::acceptPleaseParty | reference_proposal | 1141 |
| dq.a(Ljava/lang/String;I)V | viewInfo | Service::viewInfo | reference_proposal | 1153 |
| dq.j(Ljava/lang/String;)V | chatParty | Service::chatParty | reference_proposal | 1166 |
| dq.k(Ljava/lang/String;)V | chatGlobal | Service::chatGlobal | reference_proposal | 1178 |
| dq.a(Ljava/lang/String;Ljava/lang/String;)V | chatPrivate | Service::chatPrivate | reference_proposal | 1190 |
| dq.l(Ljava/lang/String;)V | chatClan | Service::chatClan | reference_proposal | 1203 |
| dq.b(Ljava/lang/String;Ljava/lang/String;)V | sendCardInfo | Service::sendCardInfo | reference_proposal | 1215 |
| dq.a(Ljava/lang/String;[BB)V | saveRms | Service::saveRms | reference_proposal | 1228 |
| dq.m(Ljava/lang/String;)V | loadRMS | Service::loadRMS | reference_proposal | 1243 |
| dq.D(I)V | adminMove | Service::adminMove | reference_proposal | 1255 |
| dq.b(Ljava/lang/String;I)V | changeName | Service::changeName | reference_proposal | 1267 |
| dq.E(I)V | requestIcon | Service::requestIcon | reference_proposal | 1280 |
| dq.w()V | requestClanInfo | Service::requestClanInfo | reference_proposal | 1292 |
| dq.x()V | requestClanMember | Service::requestClanMember | reference_proposal | 1304 |
| dq.y()V | requestClanItem | Service::requestClanItem | reference_proposal | 1316 |
| dq.z()V | requestClanLog | Service::requestClanLog | reference_proposal | 1328 |
| dq.F(I)V | clanInvite | Service::clanInvite | reference_proposal | 1340 |
| dq.G(I)V | clanPlease | Service::clanPlease | reference_proposal | 1352 |
| dq.H(I)V | acceptInviteClan | Service::acceptInviteClan | reference_proposal | 1364 |
| dq.I(I)V | acceptPleaseClan | Service::acceptPleaseClan | reference_proposal | 1376 |
| dq.n(Ljava/lang/String;)V | changeClanAlert | Service::changeClanAlert | reference_proposal | 1388 |
| dq.c(Ljava/lang/String;I)V | changeClanType | Service::changeClanType | reference_proposal | 1400 |
| dq.o(Ljava/lang/String;)V | moveOutClan | Service::moveOutClan | reference_proposal | 1413 |
| dq.A()V | outClan | Service::outClan | reference_proposal | 1425 |
| dq.J(I)V | inputCoinClan | Service::inputCoinClan | reference_proposal | 1437 |
| dq.K(I)V | outputCoinClan | Service::outputCoinClan | reference_proposal | 1449 |
| dq.B()V | clanUpLevel | Service::clanUpLevel | reference_proposal | 1461 |
| dq.c(III)V | doConvertUpgrade | Service::doConvertUpgrade | reference_proposal | 1473 |
| dq.p(Ljava/lang/String;)V | inviteClanDun | Service::inviteClanDun | reference_proposal | 1487 |
| dq.q(Ljava/lang/String;)V | inviteClanBattlefield | Service::inviteClanBattlefield | reference_proposal | 1499 |
| dq.C()V | acceptClanBattlefield | Service::acceptClanBattlefield | reference_proposal | 1511 |
| dq.D()V | inviteClanBattlefieldAll | Service::inviteClanBattlefieldAll | reference_proposal | 1523 |
| dq.E()V | unlockClanItem | Service::unlockClanItem | reference_proposal | 1535 |
| dq.i(II)V | inputNumSplit | Service::inputNumSplit | reference_proposal | 1547 |
| dq.L(I)V | activeAccProtect | Service::activeAccProtect | reference_proposal | 1560 |
| dq.M(I)V | clearAccProtect | Service::clearAccProtect | reference_proposal | 1572 |
| dq.j(II)V | updateActive | Service::updateActive | reference_proposal | 1584 |
| dq.N(I)V | openLockAccProtect | Service::openLockAccProtect | reference_proposal | 1597 |
| dq.F()V | rewardPB | Service::rewardPB | reference_proposal | 1609 |
| dq.G()V | rewardCT | Service::rewardCT | reference_proposal | 1621 |
| dq.a(Lby;I)V | sendToSaleItem | Service::sendToSaleItem | reference_proposal | 1633 |
| dq.O(I)V | requestItemAuction | Service::requestItemAuction | reference_proposal | 1646 |
| dq.P(I)V | buyItemAuction | Service::buyItemAuction | reference_proposal | 1658 |
| dq.H()V | selectCard | Service::selectCard | reference_proposal | 1670 |
| dq.r(Ljava/lang/String;)V | sendClanItem | Service::sendClanItem | reference_proposal | 1682 |
| dq.I()V | useClanItem | Service::useClanItem | reference_proposal | 1695 |
| dq.c([Lby;)V | luyenthach | Service::luyenthach | reference_proposal | 1707 |
| dq.a(Lby;[Lby;)V | tinhluyen | Service::tinhluyen | reference_proposal | 1731 |
| dq.b(Lby;[Lby;)V | dichchuyen | Service::dichchuyen | reference_proposal | 1749 |
| dq.Q(I)V | sendCatkeo | Service::sendCatkeo | reference_proposal | 1774 |
| dq.a(Ljava/lang/String;Ljava/lang/String;B)V | ChucTet | Service::ChucTet | reference_proposal | 1786 |
| dq.b(SLjava/lang/String;)V | SendCapcha | Service::SendCapcha | reference_proposal | 1799 |
| dq.b(S)V | sendAttackMobFast | Service::sendAttackMobFast | reference_proposal | 1812 |
| dq.a(BLjava/lang/String;)V | requestRanked | Service::requestRanked | reference_proposal | 1824 |
| dq.a(BS)V | request_imgEffAuto | Service::request_imgEffAuto | reference_proposal | 1837 |
| dq.a(SLjava/lang/String;B)V | luckyDraw | Service::luckyDraw | reference_proposal | 1850 |
| dq.a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V | info_Kiemduyet | Service::info_Kiemduyet | reference_proposal | 1864 |
| dq.a(B)V | send_Captcha | Service::send_Captcha | reference_proposal | 1881 |
| dq.a(BLby;Lby;[Lby;)V | ngockham | Service::ngockham | reference_proposal | 1894 |
| dq.d([Lby;)V | giaodo | Service::giaodo | reference_proposal | 1925 |
| dq.c(S)V | doGetImgIcon | Service::doGetImgIcon | reference_proposal | 1943 |
| dq.R(I)V | doGetByteData | Service::doGetByteData | reference_proposal | 1956 |
| dq.J()V | sendGPS | Service::sendGPS | reference_proposal | 1969 |
| dq.S(I)V | doRemoveVithu | Service::doRemoveVithu | reference_proposal | 1980 |
