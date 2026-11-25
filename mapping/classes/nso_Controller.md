# nso.Controller

Original JVM class: `an`.
CLR reference: `Controller`.
Status: `reference_proposal`.

Source: `source/src/main/java/nso/Controller.java`.

## Fields (2)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| an.aLan; | me | Controller.me | reference_proposal | 12 |
| an.bLce; | messWait | Controller.messWait | reference_proposal | 14 |

## Methods (27)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| an.<init>()V | <init> | Controller::.ctor | preserved | 16 |
| an.a()Lan; | gI | Controller::gI | reference_proposal | 19 |
| an.b()V | onConnectionError |  | behavioral_name | 26 |
| an.b(Lce;)V | requestItemPlayer | Controller::requestItemPlayer | reference_proposal | 30 |
| an.c(Lce;)V | viewItemAuction | Controller::viewItemAuction | reference_proposal | 49 |
| an.a(Lce;)V | onMessage | Controller::onMessage | reference_proposal | 79 |
| an.a(Ljava/io/DataInputStream;)V | createItem | Controller::createItem | reference_proposal | 2375 |
| an.b(Ljava/io/DataInputStream;)V | createSkill | Controller::createSkill | reference_proposal | 2390 |
| an.c(Ljava/io/DataInputStream;)V | createMap | Controller::createMap | reference_proposal | 2440 |
| an.d(Ljava/io/DataInputStream;)V | createData | Controller::createData | reference_proposal | 2475 |
| an.a([B)Ljavax/microedition/lcdui/Image; | createImage | Controller::createImage | reference_proposal | 2545 |
| an.d(Lce;)V | loadInfoMap | Controller::loadInfoMap | reference_proposal | 2553 |
| an.e(Lce;)V | messageNotMap | Controller::messageNotMap | reference_proposal | 2639 |
| an.f(Lce;)V | messageNotLogin | Controller::messageNotLogin | reference_proposal | 3207 |
| an.g(Lce;)V | messageSubCommand | Controller::messageSubCommand | reference_proposal | 3226 |
| an.a(Lbp;Lce;)Z | readCharInfo | Controller::readCharInfo | reference_proposal | 4398 |
| an.h(Lce;)V | requestItemInfo | Controller::requestItemInfo | reference_proposal | 4513 |
| an.i(Lce;)V | addMob | Controller::addMob | reference_proposal | 4703 |
| an.j(Lce;)V | addEffAuto | Controller::addEffAuto | reference_proposal | 4740 |
| an.k(Lce;)V | getDataEffAuto | Controller::getDataEffAuto | reference_proposal | 4754 |
| an.l(Lce;)V | getImgEffAuto | Controller::getImgEffAuto | reference_proposal | 4770 |
| an.m(Lce;)V | khamngoc | Controller::khamngoc | reference_proposal | 4781 |
| an.n(Lce;)V | addEffect | Controller::addEffect | reference_proposal | 4822 |
| an.o(Lce;)V | getImgEffect | Controller::getImgEffect | reference_proposal | 4870 |
| an.p(Lce;)V | getDataEffect | Controller::getDataEffect | reference_proposal | 4891 |
| an.a(Lce;I)V | readDataMobOld | Controller::readDataMobOld | reference_proposal | 4915 |
| an.b(Lce;I)V | readDataMobNew | Controller::readDataMobNew | reference_proposal | 4947 |
